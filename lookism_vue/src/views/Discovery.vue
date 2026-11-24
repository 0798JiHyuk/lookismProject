<script setup>
import { onMounted, reactive, ref } from 'vue'
import { memberRequest } from '../api.js'

const cards = ref([])
const settings = reactive({ visible: false, introduction: '' })
const published = ref(false)
const page = ref(0)
const hasNext = ref(false)
const ready = ref(false)
const busy = ref(false)
const error = ref('')
const announcement = ref('')

async function load(number, copySettings = false) {
  const result = await memberRequest('/discovery?page=' + number)
  if (copySettings) Object.assign(settings, result.settings)
  published.value = result.settings.visible
  cards.value = result.profiles
  hasNext.value = result.hasNext
  page.value = number
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

onMounted(() => run(() => load(0, true)))

function save() {
  return run(async () => {
    await memberRequest('/discovery/profile', 'PUT', settings)
    await load(0, true)
    announcement.value = '탐색 프로필 설정을 저장했습니다.'
  })
}

function toggleInterest(card) {
  return run(async () => {
    const result = await memberRequest('/discovery/' + card.id + '/interest', 'PUT', { interested: !card.interested })
    Object.assign(card, result)
    announcement.value = result.matched ? '서로 관심을 표시했습니다.' :
      result.interested ? '관심을 표시했습니다.' : '관심을 취소했습니다.'
  })
}
</script>

<template>
  <section class="member-card feature-card" aria-labelledby="discovery-title">
    <h1 id="discovery-title">회원 탐색</h1>
    <p class="intro">등록한 이름과 아래 소개만 공개됩니다. 서로 관심을 표시하면 매칭됩니다.</p>
    <p class="notice notice-error" role="alert">{{ error }}</p>
    <p class="notice" role="status">{{ announcement }}</p>
    <p v-if="!ready && busy" role="status">프로필을 불러오는 중…</p>
    <RouterLink v-if="!ready && error" to="/">로그인 화면으로</RouterLink>
    <template v-if="ready">
      <form class="form-grid" :aria-busy="busy" @submit.prevent="save">
        <label class="check-label"><input v-model="settings.visible" type="checkbox" :disabled="busy" /> 내 프로필 공개</label>
        <p class="hint">공개를 끄면 주고받은 관심과 매칭이 삭제됩니다.</p>
        <div class="field">
          <label for="public-intro">공개 소개</label>
          <textarea id="public-intro" v-model.trim="settings.introduction" maxlength="500" :disabled="busy"></textarea>
        </div>
        <button :disabled="busy">설정 저장</button>
      </form>
      <p v-if="!published" class="form-footer">프로필을 공개하면 다른 회원을 볼 수 있습니다.</p>
      <p v-else-if="!cards.length" class="form-footer">아직 다른 공개 프로필이 없습니다.</p>
      <ul v-else class="entry-list">
        <li v-for="card in cards" :key="card.id" class="entry">
          <h2>{{ card.name }}</h2>
          <p v-if="card.introduction">{{ card.introduction }}</p>
          <div class="action-row">
            <button class="secondary" :disabled="busy" @click="toggleInterest(card)">
              {{ card.interested ? '관심 취소' : '관심 보내기' }}
            </button>
            <span v-if="card.matched" class="hint">서로 관심 있음</span>
          </div>
        </li>
      </ul>
      <div v-if="published" class="action-row">
        <button class="secondary" :disabled="busy" @click="run(() => load(page))">목록 새로고침</button>
        <button v-if="page > 0" class="secondary" :disabled="busy" @click="run(() => load(page - 1))">이전</button>
        <button v-if="hasNext" class="secondary" :disabled="busy" @click="run(() => load(page + 1))">다음</button>
      </div>
    </template>
  </section>
</template>
