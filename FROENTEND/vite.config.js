// vite.config.js
import { defineConfig } from 'vite';

export default defineConfig({
  server: {
    proxy: {
      '/FOODDELIVERYPROJECT': {
        target: 'http://localhost:8082',
        changeOrigin: true,
        rewrite: (path) => path.replace(/^\/FOODDELIVERYPROJECT/, ''),
      },
    },
  },
});
