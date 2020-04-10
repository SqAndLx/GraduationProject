<template>
  <div class="all">
    <div class="content">
      <div class="title">
        <div style="margin-top: 15px;">
          <el-button type="primary" @click="dialogVisible = true" icon="el-icon-plus" class="insert"></el-button>
        </div>
        <!--        <i class="el-icon-edit" @click="dialogVisible = true"></i>-->
        <el-dialog title="添  加  员 工" :visible.sync="dialogVisible" width="35%" :close-on-click-modal="false">
          <addUsr></addUsr>
        </el-dialog>
      </div>
      <div class="table">
        <tables class="tab" :tableData="ryxxList" :currentPage="currentPage"></tables>
        <div class="block">
          <el-pagination
            @current-change="handleCurrentChange"
            @size-change="handleSizeChange"
            :current-page="currentPage"
            :page-size="pagesize"
            layout="total, prev, pager, next, jumper"
            :total="ryxxList.length">
          </el-pagination>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
    import tables from './table.vue'
    import axios from "axios"
    import AddUsr from "./addUsr";

    export default {
        data() {
            return {
                dialogVisible: false,
                ryxxList: [],
                currentPage: 1, //初始页
                pagesize: 8,    //    每页的数据
            }
        },
        components: {
            AddUsr,
            tables
        },
        methods: {
            getData() {
                axios.post('/axios/api/getYgxx')
                    .then((response) => {
                        if (response.data.code == '200') {
                            this.ryxxList = response.data.data
                        }
                    }).catch((error) => {
                    console.log(error)
                })
            },
            handleCurrentChange(currentPage) {
                this.currentPage = currentPage
            },
            // 初始页currentPage、初始每页数据数pagesize和数据data
            handleSizeChange(size) {
                this.pagesize = size
            }
        },
        created() {
            this.getData();
        }
    }
</script>

<style scoped>
  .all {
    height: 100%;
    width: 100%;
    overflow: hidden;
  }

  .title {
    height: 10%;
  }

  .content {
    height: 98%;
    width: 99%;
    border: 1px solid #a9c4df;
    margin-left: 0.5%;
    margin-top: 0.5%
  }

  .table {
    display: inline-block;
    height: 90%;
    width: 100%;
  }

  .tab {
    width: 98% !important;
    margin-left: 1%;
  }

  .block {
    margin-right: -70%;
    margin-top: 2%;
  }


  .insert {
    float: right;
    margin-right: 20px;
  }


</style>
