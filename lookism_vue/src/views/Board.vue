<script setup>
import { nextTick, onMounted, reactive, ref } from 'vue'
import { memberRequest } from '../api.js'

const posts = ref([])
const page = ref(0)
const hasNext = ref(false)
const ready = ref(false)
const busy = ref(false)
const error = ref('')
const announcement = ref('')
const editing = ref(null)
const titleInput = ref(null)
const draft = reactive({ title: '', body: '' })

async function load(number) {
  const result = await memberRequest('/boards?page=' + number)
  page.value = number
  posts.value = result.posts
  hasNext.value = result.hasNext
  ready.value = true
}

async function run(action) {
  if (busy.value) return
  busy.value = true
  error.value = ''
  announcement.value = ''
  try { await action() }
  catch (failure) { error.value = failure.message }
  finally { busy.value = false }
}

onMounted(() => run(() => load(0)))

function reset() {
  editing.value = null
  draft.title = ''
  draft.body = ''
}

async function edit(post) {
  editing.value = post.id
  draft.title = post.title
  draft.body = post.body
  await nextTick()
  titleInput.value?.focus()
}

function save() {
  return run(async () => {
    const id = editing.value
    await memberRequest(id === null ? '/boards' : '/boards/' + id, id === null ? 'POST' : 'PATCH', draft)
    reset()
    await load(id === null ? 0 : page.value)
    announcement.value = id === null ? '글을 등록했습니다.' : '글을 수정했습니다.'
  })
}

function remove(post) {
  if (!window.confirm('이 글을 삭제할까요?')) return
  return run(async () => {
    await memberRequest('/boards/' + post.id, 'DELETE')
    if (editing.value === post.id) reset()
    await load(posts.value.length === 1 ? Math.max(0, page.value - 1) : page.value)
    announcement.value = '글을 삭제했습니다.'
  })
}
</script>

<template>
  <section class="member-card feature-card" aria-labelledby="board-title">
    <h1 id="board-title">게시판</h1>
    <p class="notice notice-error" role="alert">{{ error }}</p>
    <p class="notice" role="status">{{ announcement }}</p>
    <p v-if="!ready && busy" role="status">게시판을 불러오는 중…</p>
    <RouterLink v-if="!ready && error" to="/">로그인 화면으로</RouterLink>
    <template v-if="ready">
      <form class="form-grid" :aria-busy="busy" @submit.prevent="save">
        <div class="field">
          <label for="post-title">{{ editing === null ? '글 제목' : '글 제목 수정' }}</label>
          <input id="post-title" ref="titleInput" v-model.trim="draft.title" maxlength="120" required :disabled="busy" />
        </div>
        <div class="field">
          <label for="post-body">내용</label>
          <textarea id="post-body" v-model.trim="draft.body" maxlength="4000" required :disabled="busy"></textarea>
        </div>
        <div class="action-row">
          <button :disabled="busy">{{ editing === null ? '글 등록' : '수정 저장' }}</button>
          <button v-if="editing !== null" class="secondary" type="button" :disabled="busy" @click="reset">취소</button>
        </div>
      </form>
      <p v-if="!posts.length" class="intro">아직 등록된 글이 없습니다.</p>
      <ul v-else class="entry-list">
        <li v-for="post in posts" :key="post.id" class="entry">
          <h2>{{ post.title }}</h2>
          <div class="hint">{{ post.author }} · <time :datetime="post.createdAt">{{ new Date(post.createdAt).toLocaleDateString('ko-KR') }}</time></div>
          <p>{{ post.body }}</p>
          <div v-if="post.mine" class="action-row">
            <button class="secondary" type="button" :disabled="busy" @click="edit(post)">수정</button>
            <button class="secondary" type="button" :disabled="busy" @click="remove(post)">삭제</button>
          </div>
        </li>
      </ul>
      <nav v-if="page > 0 || hasNext" class="action-row" aria-label="게시판 페이지">
        <button class="secondary" :disabled="busy || page === 0" @click="run(() => load(page - 1))">이전</button>
        <button class="secondary" :disabled="busy || !hasNext" @click="run(() => load(page + 1))">다음</button>
      </nav>
    </template>
  </section>
</template>
