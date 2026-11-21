<script setup>
import { onMounted, reactive, ref } from 'vue'
import { request, submit } from '../../api.js'

const account = reactive({ userEmail: '', userName: '', userPwd: '', emailCode: '' })
const fields = reactive({})
const confirmation = ref('')
const verificationRequired = ref(true)
const configured = ref(false)
const busy = ref(false)
const created = ref(false)
const status = ref('')

onMounted(async () => {
  try {
    const response = await request('/members/signup-options')
    if (!response.ok) throw new Error('가입 설정을 불러오지 못했습니다.')
    verificationRequired.value = (await response.json()).emailVerificationRequired
    configured.value = true
  } catch (error) {
    status.value = error.message
  }
})

async function sendCode() {
  busy.value = true
  status.value = ''
  try {
    const query = new URLSearchParams({ email: account.userEmail })
    const response = await submit('/members/email?' + query)
    if (response.status === 429) throw new Error('잠시 후 다시 요청해 주세요.')
    if (response.status === 400) throw new Error('올바른 이메일 주소를 입력해 주세요.')
    if (!response.ok) throw new Error('인증번호를 보내지 못했습니다.')
    status.value = '이메일로 전송된 인증번호를 입력해 주세요.'
  } catch (error) {
    status.value = error.message
  } finally {
    busy.value = false
  }
}

async function signUp() {
  status.value = ''
  if (account.userPwd !== confirmation.value) {
    status.value = '비밀번호가 서로 다릅니다.'
    return
  }
  if (new TextEncoder().encode(account.userPwd).length > 72) {
    status.value = '비밀번호는 UTF-8 기준 72바이트 이내로 입력해 주세요.'
    return
  }
  busy.value = true
  try {
    const profile = Object.fromEntries(Object.entries(fields).filter(([, value]) => value !== ''))
    const response = await submit('/members/signup', { ...account, ...profile })
    if (response.status === 409) throw new Error('이미 등록된 이메일입니다.')
    if (response.status === 400) throw new Error('가입 정보와 이메일 인증번호를 확인해 주세요.')
    if (!response.ok) throw new Error('회원가입에 실패했습니다.')
    account.userPwd = ''
    confirmation.value = ''
    created.value = true
  } catch (error) {
    status.value = error.message
  } finally {
    busy.value = false
  }
}
</script>

<template>
  <section>
    <h1>회원가입</h1>
    <p v-if="created">가입이 완료되었습니다. <RouterLink to="/">로그인하기</RouterLink></p>
    <form v-else @submit.prevent="signUp">
      <div class="email-row">
        <label>이메일<input v-model.trim="account.userEmail" type="email" autocomplete="username" maxlength="254" required /></label>
        <button v-if="verificationRequired" type="button" :disabled="!configured || busy || !account.userEmail" @click="sendCode">인증번호 받기</button>
      </div>
      <label v-if="verificationRequired">인증번호<input v-model.trim="account.emailCode" inputmode="numeric" autocomplete="one-time-code" pattern="[0-9]{8}" maxlength="8" required /></label>
      <label>이름<input v-model.trim="account.userName" autocomplete="name" maxlength="80" required /></label>
      <label>비밀번호<input v-model="account.userPwd" type="password" autocomplete="new-password" minlength="8" maxlength="72" required /></label>
      <label>비밀번호 확인<input v-model="confirmation" type="password" autocomplete="new-password" minlength="8" maxlength="72" required /></label>
      <details>
        <summary>추가 프로필</summary>
        <div>
          <label>생년월일<input v-model="fields.userBirth" type="date" autocomplete="bday" /></label>
          <label>전화번호<input v-model.trim="fields.userPhone" type="tel" autocomplete="tel" maxlength="30" /></label>
          <label>키 (cm)<input v-model.number="fields.userHeight" type="number" min="1" max="300" /></label>
          <label>몸무게 (kg)<input v-model.number="fields.userWeight" type="number" min="1" max="500" /></label>
          <label>흡연<input v-model.trim="fields.userCigarette" maxlength="30" /></label>
          <label>음주<input v-model.trim="fields.userDrinking" maxlength="30" /></label>
          <label>종교<input v-model.trim="fields.userReligion" maxlength="30" /></label>
          <label>MBTI<input v-model.trim="fields.userMBTI" maxlength="4" /></label>
          <label>소개<textarea v-model.trim="fields.userProfile" maxlength="500"></textarea></label>
        </div>
      </details>
      <button :disabled="!configured || busy">가입하기</button>
    </form>
    <p v-if="status" role="status">{{ status }}</p>
  </section>
</template>
