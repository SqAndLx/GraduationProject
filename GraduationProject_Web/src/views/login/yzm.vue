<template>
<div class="form-group" style="display: flex;">
    <div>
        <span class="font">验证码：</span>
        <input type="text" id="code" v-model="code" class="code"  placeholder="请输入您的验证码" />
    </div>
    <div class="login-code" @click="refreshCode">
        <!--验证码组件-->
        <s-identify :identifyCode="identifyCode"></s-identify>
    </div>
</div>
</template>

<script>
import SIdentify  from '../login/sidentify'
export default {
components: { SIdentify },
  data() {
    return {
        identifyCodes: '1234567890',
        identifyCode: '',
        code: '',//text框输入的验证码
    }
  },
  mounted(){
    this.identifyCode = ''
    this.makeCode(this.identifyCodes, 4)
 },
 methods:{
     //验证码
    randomNum(min, max) {
        return Math.floor(Math.random() * (max - min) + min)
    },
        
    refreshCode() {
        this.code = ''
        this.identifyCode = ''
        this.makeCode(this.identifyCodes, 4)
    },
    makeCode(o, l) {
        for (let i = 0; i < l; i++) {
            this.identifyCode += this.identifyCodes[
            this.randomNum(0, this.identifyCodes.length)
            ];
        }
        this.changeIdentifyCode()
    },
    changeIdentifyCode() {
      this.$store.commit('changeIdentifyCode', {
        identifyCode: this.identifyCode
      })
    },
 }
}
</script>
<style scoped>
.code{
    width:124px;
    height:31px;
    border:1px solid rgba(186,186,186,1);
}
.login-code{
     cursor: pointer;
     margin-left: 2.5%
}
.font{
    color: white;
    font-size: 18px
}
</style>
