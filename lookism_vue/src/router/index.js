import { createRouter, createWebHashHistory } from 'vue-router'
import Login from '../views/member/Login.vue'
import Enroll from '../views/member/Enroll.vue'

export default createRouter({
  history: createWebHashHistory(),
  routes: [
    { path: '/', component: Login },
    { path: '/signup', component: Enroll },
    { path: '/:pathMatch(.*)*', redirect: '/' },
  ],
})
