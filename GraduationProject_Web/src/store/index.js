import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

const store = new Vuex.Store({
    state: {
        identifyCode: '', // 正确的验证码
        actionName: '',
        zk: 0,
        goodsList: []
    },
    mutations: {
        changeIdentifyCode(state, data){
            state.identifyCode = data.identifyCode
        },
        changeActionName(state, actionName){
            state.actionName = actionName
        },
        setZk(state, zk) {
          state.zk = zk
        },
        setGoodsList(state, goodsList) {
        state.goodsList = goodsList
      }
    },
    getters: {
        getIdentifyCode: state => {
            return state.identifyCode
        },
        getActionName: state => {
            return state.actionName
        }
    }
})
export default store
