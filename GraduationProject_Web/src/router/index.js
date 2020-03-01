import Vue from 'vue'
import Router from 'vue-router'


import home from '@/views/home/home'
import login from '@/views/login/login'
Vue.use(Router)
export default new Router({
  routes: [
    {
      path: '/home',
      name: 'home',
      component: home
    },
    {
      path: '/',
      name: 'login',
      component: login
    },
  ]
})
