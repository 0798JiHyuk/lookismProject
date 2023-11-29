import { createApp } from 'vue'
import App from './App.vue'
import router from '@/router/index.js'
import axios from 'axios'


//createApp(App).mount('#app')
const app = createApp(App)
//모든 컴포넌트에 사용할 전역변수 선언
app.config.globalProperties.$axios = axios
app.config.globalProperties.$serverUrl = '//localhost:9999'

//앱에 라우터 사용을 지정함
app.use(router).mount('#app')
