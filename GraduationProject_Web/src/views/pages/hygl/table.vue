<template>
  <el-table :data="tableData.slice((currentPage-1)*13,currentPage*13)" border >
    <el-table-column type="index" width="65" align="center"></el-table-column>
    <el-table-column prop="name" label="姓名" width="230" align="center"></el-table-column>
    <el-table-column prop="tel" label="会员号" width="230" align="center"></el-table-column>
    <el-table-column prop="sex" label="性别" width="230" align="center"></el-table-column>
    <el-table-column prop="integral" label="会员积分" width="230" align="center"></el-table-column>
    <el-table-column prop="grade" label="会员等级" width="230" align="center" ></el-table-column>
    <el-table-column prop="data"  label="办理日期" width="230" align="center"></el-table-column>
    <el-table-column prop="updateName" label="办理人" width="230" align="center"></el-table-column>
    <el-table-column prop="balance"  label="账户余额" width="230" align="center"></el-table-column>
  </el-table>
</template>

<script>
    export default {
        name: "table",
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
