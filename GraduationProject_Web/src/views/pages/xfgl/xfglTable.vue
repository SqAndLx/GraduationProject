<template>
  <el-table :data="tableData.slice((currentPage-1)*8,currentPage*8)" border>
    <el-table-column type="index" width="65" align="center"></el-table-column>
    <el-table-column prop="data" label="日期" width="230" align="center"></el-table-column>
    <el-table-column prop="name" label="姓名" width="230" align="center">
      <template slot-scope="scope">
        <span v-if="scope.row.name == null">非会员</span>
        <span v-else>{{ scope.row.name }}</span>
      </template>
    </el-table-column>
    <el-table-column prop="tel" label="会员号" width="230" align="center">
      <template slot-scope="scope">
        <span v-if="scope.row.tel == null">非会员</span>
        <span v-else>{{ scope.row.tel }}</span>
      </template>
    </el-table-column>
    <el-table-column prop="goodsId" label="消费内容" width="230" align="center"></el-table-column>
    <el-table-column prop="money" label="消费金额" width="230" align="center">
      <template slot-scope="scope">
        <span v-if="scope.row.hymoney == null">{{scope.row.money}}</span>
        <span v-else>{{ scope.row.hymoney }}</span>
      </template>
    </el-table-column>
    <el-table-column prop="personnelId" label="理发师" width="230" align="center"></el-table-column>
    <el-table-column prop="way" label="支付方式" width="230" align="center"></el-table-column>
  </el-table>
</template>

<script>
    export default {
        props: {
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
        methods: {},
        data() {
            return {}
        }
    }
</script>
