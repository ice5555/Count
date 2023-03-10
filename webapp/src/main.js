// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from '../node_modules/element-ui';
import '../node_modules/element-ui/lib/theme-chalk/index.css';
import axios from "axios"
import * as echarts from "echarts"
import "element-ui/lib/theme-chalk/index.css"
window.echarts=echarts
Vue.use(ElementUI);

Vue.config.productionTip = false
Vue.prototype.$axios=axios

Vue.prototype.$axiosJava =axios.create({
  baseURL:process.env.VUE_APP_URL
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  components: { App },
  template: '<App/>'
})
