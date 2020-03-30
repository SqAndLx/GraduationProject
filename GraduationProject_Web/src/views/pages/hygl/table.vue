<template>
  <el-table :data="tableData.slice((currentPage-1)*8,currentPage*8)" border>
    <el-table-column type="index" width="65" align="center"></el-table-column>
    <el-table-column prop="name" label="姓名" width="150" align="center"></el-table-column>
    <el-table-column prop="tel" label="会员号" width="230" align="center"></el-table-column>
    <el-table-column prop="sex" label="性别" width="100" align="center"></el-table-column>
    <el-table-column prop="integral" label="会员积分" width="150" align="center"></el-table-column>
    <el-table-column prop="grade" label="会员等级" width="150" align="center"></el-table-column>
    <el-table-column prop="data" label="办理日期" width="230" align="center"></el-table-column>
    <el-table-column prop="updateName" label="办理人" width="200" align="center"></el-table-column>
    <el-table-column prop="balance" label="账户余额" width="150" align="center"></el-table-column>
    <el-table-column label="操作" width="230" align="center">
      <el-button type="primary" icon="el-icon-edit" circle @click="update"></el-button>
      <el-button type="danger" icon="el-icon-delete" circle @click="delect"></el-button>
    </el-table-column>
  </el-table>
</template>

<script>
    export default {
        name: "table",
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
        methods: {
            update() {
                this.$message({
                    message: '修改',
                    type: 'warning'
                })
            },
            delect() {
                this.$message({
                    message: '确认删除吗？',
                    type: 'warning'
                })
            }
        },
        data() {
            return {}
        }
    }
</script>
<style scoped>
  .el-icon-edit {
    color: darkgoldenrod;
  }

  .el-icon-delete-solid {
    color: chartreuse;
  }
</style>
