import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

const store = new Vuex.Store({
    state: {
        identifyCode: '' // 正确的验证码
    },
    mutations: {
        changeIdentifyCode(state, data){
            state.identifyCode = data.identifyCode
        }
    },
    getters: {
        getIdentifyCode: state => {
            return state.identifyCode 
        }
    }
})
export default store
