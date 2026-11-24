<script setup>
import { nextTick, onMounted, reactive, ref } from 'vue'
import { request, submit } from '../../api.js'
import PasswordField from '../../components/PasswordField.vue'

const account = reactive({ userEmail: '', userName: '', userPwd: '', emailCode: '' })
const fields = reactive({})
const confirmation = ref('')
const verificationRequired = ref(true)
const configured = ref(false)
const pending = ref('')
const created = ref(false)
const status = ref('')
const errorMessage = ref('')
const emailInput = ref(null)
const codeInput = ref(null)
const successHeading = ref(null)
const sentEmail = ref('')
const profileDetails = ref(null)

function revealInvalidField(event) {
  if (profileDetails.value?.contains(event.target)) profileDetails.value.open = true
}

onMounted(async () => {
  try {
    const response = await request('/members/signup-options')
    if (!response.ok) throw new Error('가입 설정을 불러오지 못했습니다.')
    verificationRequired.value = (await response.json()).emailVerificationRequired
    configured.value = true
  } catch (error) {
    errorMessage.value = error.message
  }
})

async function sendCode() {
  if (pending.value || !emailInput.value.reportValidity()) return
  pending.value = 'email'
  status.value = ''
  errorMessage.value = ''
  try {
    const query = new URLSearchParams({ email: account.userEmail })
    const response = await submit('/members/email?' + query)
    if (response.status === 429) throw new Error('잠시 후 다시 요청해 주세요.')
    if (response.status === 400) throw new Error('올바른 이메일 주소를 입력해 주세요.')
    if (!response.ok) throw new Error('인증번호를 보내지 못했습니다.')
    sentEmail.value = account.userEmail
    status.value = '이메일로 전송된 인증번호를 입력해 주세요.'
  } catch (error) {
    errorMessage.value = error.message
  } finally {
    pending.value = ''
  }
  if (status.value) {
    await nextTick()
    codeInput.value?.focus()
  }
}

async function signUp() {
  if (pending.value || !configured.value) return
  status.value = ''
  errorMessage.value = ''
  if (verificationRequired.value && sentEmail.value !== account.userEmail) {
    errorMessage.value = '현재 이메일 주소로 인증번호를 요청해 주세요.'
    return
  }
  if (account.userPwd !== confirmation.value) {
    errorMessage.value = '비밀번호가 서로 다릅니다.'
    return
  }
  if (new TextEncoder().encode(account.userPwd).length > 72) {
    errorMessage.value = '비밀번호는 UTF-8 기준 72바이트 이내로 입력해 주세요.'
    return
  }
  pending.value = 'signup'
  try {
    const profile = Object.fromEntries(Object.entries(fields).filter(([, value]) => value !== ''))
    const response = await submit('/members/signup', { ...account, ...profile })
    if (response.status === 409) throw new Error('이미 등록된 이메일입니다.')
    if (response.status === 400) throw new Error('가입 정보와 이메일 인증번호를 확인해 주세요.')
    if (!response.ok) throw new Error('회원가입에 실패했습니다.')
    account.userPwd = ''
    confirmation.value = ''
    created.value = true
    await nextTick()
    successHeading.value?.focus()
  } catch (error) {
    errorMessage.value = error.message
  } finally {
    pending.value = ''
  }
}
</script>

<template>
  <section class="member-card member-card--wide" aria-labelledby="signup-title">
    <template v-if="created">
      <h1 id="signup-title" ref="successHeading" tabindex="-1">가입 완료</h1>
      <p class="intro">이제 가입한 이메일로 로그인할 수 있습니다.</p>
      <RouterLink class="button" to="/">로그인하기</RouterLink>
    </template>
    <template v-else>
    <h1 id="signup-title">회원가입</h1>
    <form class="form-grid" :aria-busy="!!pending" @invalid.capture="revealInvalidField" @submit.prevent="signUp">
      <div class="field">
        <label for="signup-email">이메일</label>
        <div :class="{ 'inline-control email-control': verificationRequired }">
          <input id="signup-email" ref="emailInput" v-model.trim="account.userEmail" type="email" autocomplete="username" maxlength="254" :disabled="!!pending" required />
          <button v-if="verificationRequired" class="secondary" type="button" :disabled="!configured || !!pending" @click="sendCode">
            {{ pending === 'email' ? '전송 중…' : '인증번호 받기' }}
          </button>
        </div>
      </div>
      <div v-if="verificationRequired" class="field">
        <label for="signup-code">인증번호</label>
        <input id="signup-code" ref="codeInput" v-model.trim="account.emailCode" inputmode="numeric" autocomplete="one-time-code" pattern="[0-9]{8}" maxlength="8" aria-describedby="code-hint" :disabled="!!pending" required />
        <p id="code-hint" class="hint">이메일로 받은 숫자 8자리를 입력해 주세요.</p>
      </div>
      <div class="field">
        <label for="signup-name">이름</label>
        <input id="signup-name" v-model.trim="account.userName" autocomplete="name" maxlength="80" :disabled="!!pending" required />
      </div>
      <PasswordField id="signup-password" v-model="account.userPwd" label="비밀번호" autocomplete="new-password" :min-length="8" description="password-hint" :disabled="!!pending" />
      <p id="password-hint" class="hint">8자 이상 입력해 주세요.</p>
      <PasswordField id="signup-confirmation" v-model="confirmation" label="비밀번호 확인" autocomplete="new-password" :min-length="8" :disabled="!!pending" />
      <details ref="profileDetails" class="details">
        <summary>추가 프로필 (선택)</summary>
        <div class="details-grid">
          <label>생년월일<input v-model="fields.userBirth" type="date" autocomplete="bday" /></label>
          <label>전화번호<input v-model.trim="fields.userPhone" type="tel" autocomplete="tel" maxlength="30" /></label>
          <label>키 (cm)<input v-model.number="fields.userHeight" type="number" min="1" max="300" /></label>
          <label>몸무게 (kg)<input v-model.number="fields.userWeight" type="number" min="1" max="500" /></label>
          <label>흡연<input v-model.trim="fields.userCigarette" maxlength="30" /></label>
          <label>음주<input v-model.trim="fields.userDrinking" maxlength="30" /></label>
          <label>종교<input v-model.trim="fields.userReligion" maxlength="30" /></label>
          <label>MBTI<input v-model.trim="fields.userMBTI" maxlength="4" /></label>
          <label class="full">소개<textarea v-model.trim="fields.userProfile" maxlength="500"></textarea></label>
        </div>
      </details>
      <p class="notice" role="status">{{ status }}</p>
      <p class="notice notice-error" role="alert">{{ errorMessage }}</p>
      <button :disabled="!configured || !!pending">{{ pending === 'signup' ? '가입 처리 중…' : '가입하기' }}</button>
    </form>
    <p class="form-footer">이미 계정이 있나요? <RouterLink to="/">로그인</RouterLink></p>
    </template>
  </section>
</template>
