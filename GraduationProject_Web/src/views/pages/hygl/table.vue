<template >
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
      <el-button type="primary" icon="el-icon-edit"  circle @click="update()"></el-button>
      <el-button type="danger" prop="id" icon="el-icon-delete"  circle @click="deleteHy(tableData[index].id)"></el-button>
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
                });
                // axios.post('/axios/api/deleteHy')
                //     .then((response) => {
                //         if (response.data.code == '200') {
                //
                //         }
                //     }).catch((error) => {
                //     console.log(error)
                // })
            },
            deleteHy(val) {
                    this.$confirm('将删除该会员, 是否继续?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        debugger
                        let deleteParams = {
                            id: val
                        }
                        axios.post('/axios/api/deleteHy',this.qs.stringify(deleteParams))
                            .then((response) => {
                                if (response.data.code == '200') {
                                    this.$message({
                                        message: '删除成功！',
                                        type: 'success'
                                    });
                                }
                            }).catch((error) => {
                            console.log(error)
                        })
                    }).catch(() => {
                        this.$message({
                            type: 'info',
                            message: '已取消删除'
                        });
                    });

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
