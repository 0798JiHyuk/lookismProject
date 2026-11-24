import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'

export default defineConfig({
  plugins: [vue()],
  server: {
    proxy: {
      '/members': 'http://127.0.0.1:9999',
      '/boards': 'http://127.0.0.1:9999',
      '/discovery': 'http://127.0.0.1:9999',
    },
  },
})
