<template>
  <div>
    <h2>Lookism</h2>
    <h3>새로운 인연을 경험하세요</h3>
    <br>
    <p class="font-s1">회원가입을 진행해주세요.</p>
    <form @submit.prevent="fnEnroll">
      <p>
        <label for="userEmail">이메일:</label>
        <input type="text" id="userEmail" v-model="userEmail" required>
        <button v-on:click="sendEmail">이메일인증</button>
      </p>
      <div>
        <input type="text" placeholder="인증번호를 입력해주세요." @input="updateEmailCheck" />
        <button v-on:click="emailcheck">확인</button>
      </div>
      <p>
        <label for="userPwd">비밀번호:</label>
        <input type="password" id="userPwd" v-model="userPwd" required>
      </p>
      <p>
        <label for="userPwd2">비밀번호 확인:</label>
        <input type="password" id="userPwd2" v-model="userPwd2" required>
      </p>
      <p v-if="passwordsMatch">
        비밀번호가 일치합니다.
      </p>
      <p v-else>
        <span style="color: red;">비밀번호가 일치하지 않습니다.</span>
      </p>
      <p>
        <label for="userName">이름:</label>
        <input type="text" id="userName" v-model="userName" required>
      </p>
      <p>
        <label for="userBirth">생년월일:</label>
        <input type="date" id="userBirth" v-model="userBirth" required>
      </p>
      <p>
        <label for="userHeight">키:</label>
        <input type="text" id="userHeight" v-model="userHeight" required>
      </p>
      <p>
        <label for="userPhone">전화번호:</label>
        <input type="tel" id="userPhone" v-model="userPhone" required>
      </p>
      <p>
        <label for="userWeight">몸무게:</label>
        <input type="text" id="userWeight" v-model="userWeight" required>
      </p>
      <p>
        <label for="userCigarette">흡연여부:</label>
        <select id="userCigarette" v-model="userCigarette" required>
          <option value="">선택하세요</option>
          <option value="흡연자">흡연자</option>
          <option value="비흡연자">비흡연자</option>
        </select>
      </p>
      <p>
        <label for="userDrinking">음주빈도:</label>
        <select id="userDrinking" v-model="userDrinking" required>
          <option value="">선택하세요</option>
          <option value="주1회이상">주1회이상</option>
          <option value="주4회이상">주4회이상</option>
          <option value="거의마시지않음">거의마시지않음</option>
        </select>
      </p>
      <p>
        <label for="userReligion">종교:</label>
        <select id="userReligion" v-model="userReligion" required>
          <option value="">선택하세요</option>
          <option value="기독교">기독교</option>
          <option value="천주교">천주교</option>
          <option value="이슬람교">이슬람교</option>
          <option value="이슬람교">불교</option>
          <option value="무교">없음</option>
          <option value="기타">기타</option>
        </select>
      </p>
      <p>
        <label for="userMbti">MBTI:</label>
        <input type="text" id="userMbti" v-model="userMBTI">
      </p>
      <div>
        <label for="userProfile">간단한 자기소개:</label>
        <br>
        <p class="font-s3">ex) 여행을 좋아하고 집에서 책읽는 것을 좋아합니다.</p>
        <br>
        <input type="text" id="userProfile" v-model="userProfile">
      </div>
      <p>
        <button type="submit">회원가입</button>
      </p>
    </form>
    <div>
      <router-link to="/login">로그인하러가기</router-link>
    </div>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  name: 'enrollPage',
  data() {
    return {
      userId: '',
      userPwd: '',
      userName: '',
      userBirth: '',
      userEnrolldate: '',
      userEmail: '',
      userHeight: '',
      userPhone: '',
      userWeight: '',
      userCigarette: '',
      userDrinking: '',
      userReligion: '',
      userProfile: '',
      userMBTI: '',
      userLevel: '',
      adminLV: '',
    };
  },

  methods: {
    sendEmail(){
      const self = this;
      if(this.email == ''){
        alert('이메일을 입력해주세요.')
      }else{
        const form = new FormData();
        form.append('email',self.email);
        self.$axios.post('주소',form)
            .then(function(res){
              if(res.data.exist){
                alert(res.data.exist)
              }else if(res.status == 200){
                alert('이메일이 발송되었습니다.');
                const key =  res.data.key;
                alert(key);
                self.emailKey = key;
              }else{
                alert('잘못된 이메일입니다.');
              }
            })
      }
    },
    emailcheck(){
      const self = this;
      if (self.echeck === self.emailkey){
        alert('확인완료');
        this.isVisable = true;
      }else{
        alert('인증번호가 일치하지 않습니다.');
      }
    },
    async fnEnroll() {
      try {
        const response = await axios.post('http://localhost:9999/members/signup', {
          userId: this.userId,
          userName: this.userName,
          userBirth: this.userBirth,
          userEnrolldate: this.userEnrolldate,
          userEmail: this.userEmail,
          userHeight: this.userHeight,
          userPhone: this.userPhone,
          userWeight: this.userWeight,
          userCigarette: this.userCigarette,
          userDrinking: this.userDrinking,
          userReligion: this.userReligion,
          userProfile: this.userProfile,
          userMBTI: this.userMBTI,
          userPwd: this.userPwd,
          userLevel: this.userLevel,
          adminLV: this.adminLV,
        });
        console.log(response.data);
        this.$router.push('/login');
      } catch (error) {
        console.error('회원가입 실패 : ', error.response.data);
      }
    },
  },
  computed: {
    passwordsMatch() {
      // 비밀번호와 비밀번호 확인이 일치하는지 확인
      return this.userPwd === this.userPwd2;
    },
  },
};
</script>

<style>
.font-s1{
  font-size: 9px;
}
.font-s3{
  font-size: 11px;
}
</style>
