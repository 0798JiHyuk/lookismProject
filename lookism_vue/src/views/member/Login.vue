<script setup>
import { onMounted, ref } from 'vue'
import { request, submit } from '../../api.js'
import PasswordField from '../../components/PasswordField.vue'

const email = ref('')
const password = ref('')
const profile = ref(null)
const status = ref('')
const pending = ref('profile')

async function loadProfile() {
  const response = await request('/members/me', { cache: 'no-store' })
  if (response.ok) profile.value = await response.json()
  else if (response.status !== 401) throw new Error('회원 정보를 불러오지 못했습니다.')
}

onMounted(async () => {
  try { await loadProfile() }
  catch (error) { status.value = error.message }
  finally { pending.value = '' }
})

async function signIn() {
  if (pending.value) return
  pending.value = 'login'
  status.value = ''
  try {
    const response = await submit('/members/signin', new URLSearchParams({
      userEmail: email.value,
      userPwd: password.value,
    }))
    if (response.status === 401) throw new Error('이메일 또는 비밀번호를 확인해 주세요.')
    if (!response.ok) throw new Error('로그인 요청을 처리하지 못했습니다.')
    await loadProfile()
  } catch (error) {
    status.value = error.message
  } finally {
    password.value = ''
    pending.value = ''
  }
}

async function signOut() {
  if (pending.value) return
  pending.value = 'logout'
  status.value = ''
  try {
    if (!(await submit('/members/signout')).ok) throw new Error('로그아웃에 실패했습니다.')
    profile.value = null
  } catch (error) {
    status.value = error.message
  } finally {
    pending.value = ''
  }
}
</script>

<template>
  <section class="member-card" aria-labelledby="login-title">
    <template v-if="profile">
      <h1 id="login-title">{{ profile.name }}님</h1>
      <p class="intro profile-email">{{ profile.email }}</p>
      <button class="secondary" type="button" :disabled="!!pending" @click="signOut">
        {{ pending === 'logout' ? '로그아웃 중…' : '로그아웃' }}
      </button>
    </template>
    <template v-else>
      <h1 id="login-title">로그인</h1>
      <p v-if="pending === 'profile'" class="intro" role="status">로그인 상태 확인 중…</p>
      <form v-else class="form-grid" :aria-busy="pending === 'login'" @submit.prevent="signIn">
        <div class="field">
          <label for="login-email">이메일</label>
          <input id="login-email" v-model.trim="email" type="email" autocomplete="username" maxlength="254" :disabled="!!pending" required />
        </div>
        <PasswordField id="login-password" v-model="password" label="비밀번호" autocomplete="current-password" :disabled="!!pending" />
        <button :disabled="!!pending">{{ pending === 'login' ? '로그인 중…' : '로그인' }}</button>
      </form>
      <p v-if="pending !== 'profile'" class="form-footer">계정이 없나요? <RouterLink to="/signup">회원가입</RouterLink></p>
    </template>
    <p class="notice notice-error" role="alert">{{ status }}</p>
  </section>
</template>
