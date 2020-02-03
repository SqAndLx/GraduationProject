<template>
<div>
    <div class="tittleBackGround">
      <span class="tittleContent">裤衩儿理发管理系统</span>
      <span class="out" @click="dialogVisible = true">[ 注销 ]</span>
      <span class="hello">您好，{{name}} !</span>
      <el-dialog title="提示" :visible.sync="dialogVisible" width="25%">
      <span>确定退出吗？</span>
      <span slot="footer" class="dialog-footer">
      <el-button @click="dialogVisible = false">取 消</el-button>
      <el-button type="primary" @click="dialogVisible = false,out()">确 定</el-button>
  </span>
</el-dialog>
    </div>
</div>
</template>

<script>
export default {
  data() {
    return {
     name: '',
     dialogVisible: false
    }
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
    // 获取对象的属性
    this.name = loginer.id
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
  margin-top: 2%;
  cursor:pointer;
}
.out:hover{
  color: red;
}
</style>
