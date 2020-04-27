import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

const store = new Vuex.Store({
    state: {
        identifyCode: '', // 正确的验证码
        actionName: 'zjetj',
        zk: 0
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
