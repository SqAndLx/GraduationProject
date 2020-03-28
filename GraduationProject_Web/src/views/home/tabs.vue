<template>
<div>
    <el-tabs :tab-position="tabPosition" v-model="actionName" type="border-card">
        <el-tab-pane label="总金额统计" name="zjetj"></el-tab-pane>
        <el-tab-pane label="消费管理" name="xfgl"></el-tab-pane>
        <el-tab-pane label="会员管理" name="hygl"></el-tab-pane>
        <el-tab-pane label="人员管理" name="rygl" v-if="isAdmin"></el-tab-pane>
        <el-tab-pane label="库存管理" name="kcgl"></el-tab-pane>
  </el-tabs>
</div>
</template>
<script>
export default {
  data() {
    return {
        tabPosition: 'left',
        actionName: 'zjetj',
        isAdmin: false
    }
  },
  methods: {
  },
  created(){
      let loginer = JSON.parse(window.localStorage.getItem('loginer'))
      if (loginer.type === '1') {
          this.isAdmin = true
      }
  },
  watch:{
    actionName(newValue, oldValue){
      this.$store.commit('changeActionName', newValue)
    }
  }
};
</script>

<style scoped>
</style>
