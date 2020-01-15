<template>
  <div>
    <el-button type="primary" @click="go">获取</el-button>
    {{data}}
  </div>
</template>

<script>
import axios from "axios"
import qs from 'qs'
export default {
  data() {
    return {
      data: ''
    }
  },
  methods: {
    go() {
      let saveParams = {
          id: '1',
        }
      axios.post('/api/demo', this.qs.stringify(saveParams))
      .then((response) => {
          let ms = response.data
          this.data = ms
      }).catch((error) => {
        console.log(error)
      })
    }
  }
};
</script>

<style scoped>
</style>
