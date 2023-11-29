//index.js : 첫 페이지(App.vue)에 사용되는 라우터 => 루트 라우터임
//url path 설정하는 자바스크립트 파일
//url path 와 연결될 페이지를 지정함
//import 된 vue 파일 안에서 저장된 url path 를 사용함
//template 에서는 router 관련 태그들로 출력 표시함

//라이브러리가 제공하는 함수를 임포트할 때는 { 함수명 } 표기함
import { createRouter, createWebHistory } from 'vue-router'

//라우터가 연결할 페이지(컴포넌트 : vue 파일)들 임포트함
import ErrorPage from '@/views/common/Error.vue'
import MainSection from '@/views/common/Main.vue'
import login from "@/views/member/login.vue";

//각 페이지(컴포넌트)에 대한 url path 지정
//routes 는 고정변수임
const routes = [
    {
        path: '/main',
        name: 'MainSection', //임의대로 지정
        component: MainSection
    },
    {
        path: '/error',
        name: 'notFound', //임의대로 지정
        component: ErrorPage
    },
    {
        path: '/login',
        name: 'login', //임의대로 지정
        component: login
    },
] //url path 배열

//라우터 객체 만들기함
const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

//이 js 파일 밖에서 import 한 대상이 사용할 수 있게 처리함
export default router



