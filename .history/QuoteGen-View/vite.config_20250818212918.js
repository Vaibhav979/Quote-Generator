import { defineConfig } from 'vite'
import tailwindcss from '@tailwindcss/vite'
import { defineConfig } from 'vite'
import react from '@vitejs/plugin-react'

export default defineConfig({
  plugins: [react()],
  server: {
    port: 5173,
    proxy: {
      '/api': {
        target: 'http://localhost:8080',
        changeOrigin: true,
        secure: false,
        // Enable cookie-based sessions
        configure: (proxy) => {
          proxy.on('proxyReq', (proxyReq, req) => {
            proxyReq.setHeader('Origin', 'http://localhost:5173')
          });
        }
      }
    }
  }
})

export default defineConfig({
  plugins: [
    tailwindcss(),
  ],
})