import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import qs from 'qs'
import store from './store'
import ECharts from 'vue-echarts'
import 'echarts/lib/chart/pie'
import 'echarts/lib/chart/bar'
import 'echarts/lib/component/tooltip'
import 'echarts/lib/component/legend'
import 'echarts/lib/component/grid'
Vue.component('chart', ECharts)

Vue.prototype.$axios = axios
Vue.prototype.qs = qs
// Vue.config.productionTip = false
Vue.use(ElementUI)
window.bus = new Vue({}) 
new Vue({
  el: '#app',
  router,
  store,
  components: { App },
  template: '<App/>'
})

