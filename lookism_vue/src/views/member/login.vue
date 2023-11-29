<template>
  <div>
    <h1>로그인페이지</h1>
    <form @submit.prevent="fnLogin">
      <label for="userEmail">이메일:</label>
      <input type="text" id="userEmail" v-model="userEmail" required>

      <label for="userPwd">비밀번호:</label>
      <input type="password" id="userPwd" v-model="userPwd" required>

      <button type="submit">로그인</button>
    </form>
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

        // 로그인이 성공하면 메인 페이지로 이동
        this.$router.push('/main');
      } catch (error) {
        console.error('로그인 실패:', error.response.data);
        // 로그인 실패 시 사용자에게 알림을 주거나 다른 동작을 수행하도록 구현
      }
    },
  },
};
</script>

<style>
/* 스타일 추가 */
</style>
