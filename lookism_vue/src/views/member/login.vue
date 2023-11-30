<template>
  <div>
    <h2>Lookism</h2>
    <h3>새로운 인연을 경험하세요</h3>
    <br>
    <p class="font-s1">로그인을 진행해주세요.</p>
    <form @submit.prevent="fnLogin">
      <p>
        <label for="userEmail">이메일:</label>
        <input type="text" id="userEmail" v-model="userEmail" required>
      </p>
      <P>
        <label for="userPwd">비밀번호:</label>
        <input type="password" id="userPwd" v-model="userPwd" required>
      </P>
      <P>
      <button type="submit">로그인</button>
      </P>
      <p v-if="loginError" style="color: red;">{{ loginError }}</p>
    </form>
    <div>
      <p>계정이 없으신가요?</p>
      <router-link to="/enroll">회원가입</router-link>
    </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  name: 'loginPage',
  data() {
    return {
      userEmail: '',
      userPwd: '',
      loginError: '', // 새로운 데이터 속성 추가
    };
  },
  methods: {

    async fnLogin() {
      try {
        const response = await axios.post('http://localhost:9999/members/signin', {
          userEmail: this.userEmail,
          userPwd: this.userPwd,
        });

        console.log(response.data);

        this.$router.push('/main');
      } catch (error) {
        console.error('로그인 실패:', error.response.data);
        // 로그인 실패 시 오류 메시지를 설정
        this.loginError = '이메일 또는 비밀번호가 올바르지 않습니다.';
        // 일정 시간 후에 오류 메시지를 초기화하여 다시 표시되지 않도록 설정
        setTimeout(() => {
          this.loginError = '';
        }, 5000); // 5000 밀리초(5초) 후에 초기화
      }
    },
  },
};
</script>

<style>
.font-s1{
  font-size:9px;
}
</style>
