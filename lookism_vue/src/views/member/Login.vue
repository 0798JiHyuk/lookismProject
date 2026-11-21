<script setup>
import { onMounted, ref } from 'vue'
import { request, submit } from '../../api.js'

const email = ref('')
const password = ref('')
const profile = ref(null)
const status = ref('')
const busy = ref(true)

async function loadProfile() {
  const response = await request('/members/me', { cache: 'no-store' })
  if (response.ok) profile.value = await response.json()
  else if (response.status !== 401) throw new Error('회원 정보를 불러오지 못했습니다.')
}

onMounted(async () => {
  try { await loadProfile() }
  catch (error) { status.value = error.message }
  finally { busy.value = false }
})

async function signIn() {
  busy.value = true
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
    busy.value = false
  }
}

async function signOut() {
  busy.value = true
  status.value = ''
  try {
    if (!(await submit('/members/signout')).ok) throw new Error('로그아웃에 실패했습니다.')
    profile.value = null
  } catch (error) {
    status.value = error.message
  } finally {
    busy.value = false
  }
}
</script>

<template>
  <section>
    <template v-if="profile">
      <h1>{{ profile.name }}님</h1>
      <p>{{ profile.email }}</p>
      <button type="button" :disabled="busy" @click="signOut">로그아웃</button>
    </template>
    <template v-else>
      <h1>로그인</h1>
      <form @submit.prevent="signIn">
        <label>이메일<input v-model.trim="email" type="email" autocomplete="username" maxlength="254" required /></label>
        <label>비밀번호<input v-model="password" type="password" autocomplete="current-password" maxlength="72" required /></label>
        <button :disabled="busy">로그인</button>
      </form>
    </template>
    <p v-if="status" role="status">{{ status }}</p>
  </section>
</template>
