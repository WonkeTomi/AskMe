const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,
  devServer: {
      port: 4000,
      proxy: {
          '/': {
              target: 'http://localhost:8080',
              changeOrigin: true,

          }
      }
  }
})
