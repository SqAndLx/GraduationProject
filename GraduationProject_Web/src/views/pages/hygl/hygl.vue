<template>
  <div class="all">
    <div class="content">
      <div class="title">
        <el-button type="primary" @click="dialogVisible = true">新增会员</el-button>
        <el-dialog title="添  加  会  员" :visible.sync="dialogVisible" width="35%" :close-on-click-modal="false">
          <addMenu></addMenu>
        </el-dialog>
      </div>
      <div class="table">
        <tables class="tab" :tableData="hyxxList" :currentPage="currentPage"></tables>
        <div class="block">
          <el-pagination
            @current-change="handleCurrentChange"
            @size-change="handleSizeChange"
            :current-page="currentPage"
            :page-size="pagesize"
            layout="total, prev, pager, next, jumper"
            :total="hyxxList.length">
          </el-pagination>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
    import tables from './table.vue'
    import axios from "axios"

    export default {
        data() {
            return {
                dialogVisible:false,
                hyxxList: [],
                currentPage: 1, //初始页
                pagesize: 13,    //    每页的数据
            }
        },
        components: {
            tables
        },
        methods: {
            getData() {
                axios.post('/axios/api/getHyxx')
                    .then((response) => {
                        if (response.data.code == '200') {
                            this.hyxxList = response.data.data
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
</style>
