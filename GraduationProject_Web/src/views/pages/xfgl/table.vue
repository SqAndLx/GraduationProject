<template>
    <el-table :data="tableData.slice((currentPage-1)*8,currentPage*8)" border >
        <el-table-column type="index" width="65" align="center"></el-table-column>
        <el-table-column prop="data" label="日期" width="230" align="center" value-format="yyyy-MM-dd"></el-table-column>
        <el-table-column prop="name" label="姓名" width="230" align="center"></el-table-column>
        <el-table-column prop="tel" label="会员号" width="230" align="center"></el-table-column>
        <el-table-column prop="detail" label="消费内容" width="230" align="center"></el-table-column>
        
        <!-- <el-table-column prop="hymoney" label="会员价" width="230" align="center"></el-table-column> -->
        <el-table-column prop="money" label="消费金额" width="230" align="center"></el-table-column>
        <el-table-column prop="barber"  label="理发师" width="230" align="center"></el-table-column>
        <el-table-column prop="way" label="支付方式" width="230" align="center"></el-table-column>
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
    },
    data() {
      return {

      }
    }
  }
</script>
