<template>
  <el-table :data="tableData.slice((currentPage-1)*8,currentPage*8)" border>
    <el-table-column type="index" width="65" align="center"></el-table-column>
    <el-table-column prop="name" label="姓名" align="center"></el-table-column>
    <el-table-column prop="tel" label="电话" align="center"></el-table-column>
    <el-table-column prop="sex" label="性别" align="center"></el-table-column>
    <el-table-column prop="remarks" label="描述" align="center"></el-table-column>
    <el-table-column prop="salary" label="薪资" align="center"></el-table-column>
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
                        }
                        axios.post('/axios/api/deleteYg',this.qs.stringify(deleteParams))
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
