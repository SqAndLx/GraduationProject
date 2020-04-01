<template>
<div class="all">
  <div class="echarts">
    <chart :options="orgOptions"></chart>
  </div>
</div>
</template>

<script>
import echarts from './echarts.js'
export default {
  data() {
    return {
      orgOptions: {}
    }
  },
  methods: {
  },
  created(){
    
  },
  mounted() {
    this.orgOptions = echarts.getOptions()
  }
}
</script>

<style scoped>
.all{
  height: 100%;
  width: 100%;
}
</style>
