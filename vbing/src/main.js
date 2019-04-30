// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
var axios = require('axios')
axios.defaults.baseURL = 'http://localhost:9099'
// axios.defaults.headers.post['Content-type'] = 'application/json'
axios.defaults.headers.post['Content-type'] = 'application/x-www-form-urlencoded'
// 将API方法绑定到全局
Vue.prototype.$axios = axios
Vue.config.productionTip = false

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
