<template>
  <div>
    <el-table :data="tableData.slice((currentPage-1)*8,currentPage*8)" border>
    <el-table-column type="index" width="65" align="center"></el-table-column>
    <el-table-column prop="name" label="姓名" align="center"></el-table-column>
    <el-table-column prop="tel" label="电话" align="center"></el-table-column>
    <el-table-column prop="sex" label="性别" align="center"></el-table-column>
    <el-table-column prop="remarks" label="描述" align="center"></el-table-column>
    <el-table-column prop="salary" label="薪资" align="center"></el-table-column>
    <el-table-column label="操作" width="230" align="center">
    <template slot-scope="scope">
        <el-button type="primary" icon="el-icon-edit"  circle @click="showUpdateLog(scope.row)"></el-button>
        <el-button type="danger"  icon="el-icon-delete"  circle @click="deleteHy(scope.row)"></el-button>
    </template>
    </el-table-column>
  </el-table>
  <div>
    <el-dialog title="修  改" :visible.sync="dialogVisible" width="35%">
        <el-form label-width="80px">
      <span style="color:red">*</span>
      <el-form-item label="姓   名:">
        <el-input v-model="name"></el-input>
      </el-form-item>
      <el-form-item label="性   別:">
        <el-radio-group v-model="sex">
          <el-radio label="男" value="男"></el-radio>
          <el-radio label="女" vaule="女"></el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="电   话:">
        <el-input v-model="tel"></el-input>
      </el-form-item>
      <el-form-item label="薪   資:">
        <el-input v-model="salary"></el-input>
      </el-form-item>
      <el-form-item label="描   述:">
        <el-input type="textarea" v-model="remarks"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="update()">确认修改</el-button>
        <el-button @click="close()">取消</el-button>
      </el-form-item>
    </el-form>
    </el-dialog>
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
            deleteHy(val) {
                    this.$confirm('将删除该员工, 是否继续?', '提示', {
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
            return {
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
