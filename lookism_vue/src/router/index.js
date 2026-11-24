import { createRouter, createWebHashHistory } from 'vue-router'
import Login from '../views/member/Login.vue'
import Enroll from '../views/member/Enroll.vue'
import Board from '../views/Board.vue'
import Discovery from '../views/Discovery.vue'

export default createRouter({
  history: createWebHashHistory(),
  routes: [
    { path: '/', component: Login },
    { path: '/signup', component: Enroll },
    { path: '/board', component: Board },
    { path: '/discovery', component: Discovery },
    { path: '/:pathMatch(.*)*', redirect: '/' },
  ],
})
