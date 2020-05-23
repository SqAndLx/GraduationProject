<template>
<div>
    <el-tabs :tab-position="tabPosition" v-model="actionName" type="border-card">
        <el-tab-pane label="统计详情" name="zjetj" v-if="!isYh"></el-tab-pane>
        <el-tab-pane label="消费管理" name="xfgl" v-if="!isYh"></el-tab-pane>
        <el-tab-pane label="会员管理" name="hygl"  v-if="!isYh"></el-tab-pane>
        <el-tab-pane label="人员管理" name="rygl" v-if="isAdmin && !isYh"></el-tab-pane>
        <el-tab-pane label="库存管理" name="kcgl" v-if="!isYh"></el-tab-pane>
        <el-tab-pane label="预约记录" name="yyjl" v-if="!isYh"></el-tab-pane>
        <el-tab-pane label="预约" name="yy" v-if="isYh"></el-tab-pane>
    </el-tabs>
</div>
</template>
<script>
export default {
  data() {
    return {
        tabPosition: 'left',
        actionName: 'zjetj',
        isAdmin: false,
        isYh: false
    }
  },
  methods: {
  },
  created(){
      let loginer = JSON.parse(window.localStorage.getItem('loginer'))
      debugger
      if (loginer.type === '1') {
          this.isAdmin = true
      }
      if (loginer.type === '2') {
        this.isYh = true
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
