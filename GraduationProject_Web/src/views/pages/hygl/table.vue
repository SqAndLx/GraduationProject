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
    <template slot-scope="scope">
        <el-button type="primary" icon="el-icon-edit"  circle @click="update(scope.row)"></el-button>
        <el-button type="danger"  icon="el-icon-delete"  circle @click="deleteHy(scope.row)"></el-button>
    </template>
    </el-table-column>
  </el-table>
</template>

<script>
import axios from "axios"
import qs from 'qs'
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
            update(val) {
                let updateParams = {
                    id:val.id,

                }
                 axios.post('/axios/api/updateHy', this.qs.stringify(updateParams))
                     .then((response) => {
                         if (response.data.code == '200') {
                            this.$message({
                                message: '修改成功',
                                type: 'warning'
                            });
                         }
                     }).catch((error) => {
                     console.log(error)
                 })
            },
            deleteHy(val) {
                    this.$confirm('将删除该会员, 是否继续?', '提示', {
                        confirmButtonText: '确定',
                        cancelButtonText: '取消',
                        type: 'warning'
                    }).then(() => {
                        let deleteParams = {
                            id: val.id,
                            name:val.name,
                        }
                        axios.post('/axios/api/deleteHy',this.qs.stringify(deleteParams))
                            .then((response) => {
                                if (response.data.code == '200') {
                                    this.$message({
                                        message: '删除成功！',
                                        type: 'success'
                                    })
                                    this.$parent.getData()
                                }
                            }).catch((error) => {
                            console.log(error)
                        })
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
