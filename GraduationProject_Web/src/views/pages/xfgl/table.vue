<template>
    <el-table :data="tableData.slice((currentPage-1)*13,currentPage*13)" border >
        <el-table-column type="index" width="65" align="center"></el-table-column>
        <el-table-column prop="date" label="日期" width="230" align="center"></el-table-column>
        <el-table-column prop="name" label="姓名" width="230" align="center"></el-table-column>
        <el-table-column prop="province" label="省份" width="230" align="center"></el-table-column>
        <el-table-column prop="city" label="市区" width="230" align="center"></el-table-column>
        <el-table-column prop="address" label="地址" width="230" align="center"></el-table-column>
        <el-table-column prop="zip"  label="邮编" width="230" align="center"></el-table-column>
        <el-table-column prop="zip" label="哈哈" width="230" align="center"></el-table-column>
    </el-table>
</template>

<script>
  export default {
    props:{
      tableData: {
        type: Array,
        default() {
            return []
        }
      },
      currentPage: {
        type: Number,
        default() {
            return 0
        }
      },
    },
    methods: {
      handleClick(row) {
        console.log(row);
      }
    },
    data() {
      return {
        
      }
    }
  }
</script>