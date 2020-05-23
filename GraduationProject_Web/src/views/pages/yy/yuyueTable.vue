<template>
  <div>
    <el-table :data="tableData.slice((currentPage-1)*8,currentPage*8)" border>
    <el-table-column type="index" width="65" align="center"></el-table-column>
    <el-table-column prop="name" label="姓名" align="center"></el-table-column>
    <el-table-column prop="tel" label="电话" align="center"></el-table-column>
    <el-table-column prop="time" label="时间" align="center"></el-table-column>
    <el-table-column prop="lfs" label="理发师" align="center"></el-table-column>
    <el-table-column prop="nr" label="内容" align="center"></el-table-column>
    <el-table-column label="操作" width="230" align="center" v-if="loginer.type === '2'">
    <template slot-scope="scope">
        <el-button type="danger"  icon="el-icon-delete"  circle @click="deleteYy(scope.row)"></el-button>
    </template>
    </el-table-column>
  </el-table>
  <div>
  </div>
  </div>
</template>

<script>
import axios from "axios"
import qs from 'qs'
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
        created() {
          console.log(this.tableData)
        },
        methods: {
            showUpdateLog(val){
                this.dialogVisible = true
                this.name = val.name
                this.sex = val.sex
                this.salary = val.salary
                this.remarks = val.remarks
                this.tel = val.tel
                this.id = val.id
            },
            close() {
                this.dialogVisible = false
            },
            update() {
                let updateParams = {
                    name:this.name,
                    sex:this.sex,
                    tel:this.tel,
                    salary:this.salary,
                    remarks:this.remarks,
                    id: this.id
                }
                 axios.post('/axios/api/updateYg', updateParams)
                     .then((response) => {
                         if (response.data.code == '200') {
                            this.$message({
                                message: '修改成功',
                                type: 'success'
                            });
                            this.$parent.getData()
                            this.close()
                         }
                     }).catch((error) => {
                     console.log(error)
                 })
            },
            deleteYy(val) {
              let params = {
                    id:val.id
                }
              axios.post('/axios/api/deleteYy',this.qs.stringify(params))
                  .then((response) => {
                      if (response.data.code == '200') {
                          this.$message({
                              message: '删除成功！',
                              type: 'success'
                          })
                          this.$parent.getYyList()
                      }
                  }).catch((error) => {
                  console.log(error)
              })

            }
        },
        data() {
            return {
                loginer : JSON.parse(window.localStorage.getItem('loginer')),
                dialogVisible: false,
                name:'',
                tel:'',
                sex:'',
                salary:'',
                remarks:'',
                id: ''
            }
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
