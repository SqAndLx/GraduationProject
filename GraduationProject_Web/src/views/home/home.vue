<template>
<div class="all">
    <div class="tittleBackGround">
        <span class="tittleContent">美酷理发店管理系统</span>
        <span class="out" @click="dialogVisible = true">[ 注销 ]</span>
        <span class="hello">您好，{{name}} !</span>
        <el-dialog title="提示" :visible.sync="dialogVisible" width="25%">
          <span style="font-size:18px">确定退出吗？</span>
          <span slot="footer" class="dialog-footer">
              <el-button @click="dialogVisible = false">取 消</el-button>
              <el-button type="primary" @click="dialogVisible = false,out()">确 定</el-button>
          </span>
        </el-dialog>
    </div>
    <tabs class="tab"></tabs>
    <div class="conten">
      <jetjPage v-if="actionName === 'zjetj'"></jetjPage>
      <xfglPage v-if="actionName === 'xfgl'"></xfglPage>
      <hyglPage v-if="actionName === 'hygl'"></hyglPage>
      <ryglPage v-if="actionName === 'rygl'"></ryglPage>
      <kcglPage v-if="actionName === 'kcgl'"></kcglPage>
    </div>
</div>
</template>

<script>
import tabs from './tabs.vue'
import hyglPage from '../pages/hygl/hygl.vue'
import jetjPage from '../pages/jetj/jetj.vue'
import kcglPage from '../pages/kcgl/kcgl.vue'
import ryglPage from '../pages/rygl/rygl.vue'
import xfglPage from '../pages/xfgl/xfgl.vue'

export default {
  data() {
    return {
     name: '',
     dialogVisible: false,
     actionName: 'zjetj'
    }
  },
  components:{
    tabs, hyglPage, jetjPage, kcglPage, ryglPage, xfglPage
  },
  methods: {
    out(){
      window.localStorage.clear()
      this.$router.push({name:'login'})
    }
  },
  created(){
    // 从缓存中取出json，转换成对象
    let loginer = JSON.parse(window.localStorage.getItem('loginer'))
    if (loginer.type === '0') {
      this.name = '店员'
    } else if (loginer.type === '1') {
      this.name = '管理员'
    }
  },
  watch: {
    '$store.state.actionName'(newValue, oldValue) {
      this.actionName = newValue
    },
  }
};
</script>

<style scoped>
.tittleBackGround{
  background: url(../../assets/title.png) no-repeat;
  background-size: 100% 100%;
  width: 100%;
  height: 70px;
}
.tittleContent{
  color: white;
  font-weight: bold;
  font-size: 35px;
  float: left;
  margin-left: 1%;
  margin-top: 0.5%;
  letter-spacing: 10px;
}
.hello{
  color: white;
  font-weight: bold;
  font-size: 20px;
  float: right;;
  margin-right: 2%;
  margin-top: 2%
}
.out{
  color: white;
  font-size: 16px;
  float: right;
  margin-right: 1%;
  margin-top: 2.2%;
  cursor:pointer;
}
.out:hover{
  color: red;
}
.all{
}
.conten{
  width: 90%;
  height: 867px;
  float: left;
}
.tab{
  float: left;
  width: 10%;
}
</style>
<style>
.el-tabs.el-tabs--left{
  height: 858px;
  width: 100%;
}
.el-tabs--left .el-tabs__item.is-left {
    text-align: right;
    font-size: 20px;
}
.el-tabs__nav-scroll {
  width: 190px;
}
.el-tabs--left .el-tabs__nav.is-left, .el-tabs--left .el-tabs__nav.is-right, .el-tabs--right .el-tabs__nav.is-left, .el-tabs--right .el-tabs__nav.is-right {
    transform: translateY(20px) !important;
}
.el-tabs--left .el-tabs__item.is-left {
    height: 60px;
    margin-top: 5px
}
.el-tabs--border-card>.el-tabs__header .el-tabs__item+.el-tabs__item, .el-tabs--border-card>.el-tabs__header .el-tabs__item:first-child {
    line-height: 60px;
    text-align: center;
}
</style>
