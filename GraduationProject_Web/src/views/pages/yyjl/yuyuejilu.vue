<template>
  <div class="all">
    <div class="innerBoder">
        <!--     操作行-->
      <div class="consleLine">
      </div>
      <div class="table">
        <yytable class="tab" :tableData="yyList" :currentPage="currentPage"></yytable>
        <div class="block">
          <el-pagination
            @current-change="handleCurrentChange"
            @size-change="handleSizeChange"
            :current-page="currentPage"
            :page-size="pagesize"
            layout="total, prev, pager, next, jumper"
            :total="yyList.length"
          ></el-pagination>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
    import axios from "axios";
    import qs from "qs";
    import yytable from '../yy/yuyueTable.vue'
    export default {
        components: {
                yytable
        },
        data() {
            return {
                addDialogVisible:false,
                page: {
                    tel: '',
                    name: '',
                    time: '',
                    lfs: '',
                    nr: ''
                },
                loginer: '',
                currentPage: 1, //初始页
                pagesize: 8, //    每页的数据
                yyList: [],
                me: '',
                options: [{
                    id: 'Tom',
                    name: 'Tom',
                }, {
                    id: '李四',
                    name: '李四',
                }, {
                    id: '李楠楠',
                    name: '李楠楠',
                }, {
                    id: '刘鑫',
                    name: '刘鑫',
                }],
            }
        },
        methods: {
            
            close() {
                this.page = {
                    tel: '',
                    name: '',
                    time: '',
                    lfs: '',
                    nr: ''
                }
                this.addDialogVisible = false
            },
            yuyue() {
              this.page.name = this.loginer.id
                axios.post('/axios/api/insertYy/', this.page).then((response) => {
                    if (response.data.code == '200') {
                        this.$message({
                            message: '预约成功！',
                            type: 'success'
                        })
                        this.getYyList()
                        this.close()
                    }
                })
            },
            getYyList() {
              axios.post('/axios/api/getAll/').then((response) => {
                    if (response.data.code == '200') {
                        this.yyList = response.data.data
                    }
                })
            }
            
        },
        created() {
            this.loginer = JSON.parse(window.localStorage.getItem('loginer'))
            this.getYyList()
        }
    }
</script>

<style scoped>
  .all {
    height: 100%;
    width: 100%;
  }

  .innerBoder {
    width: 99%;
    height: 97.5%;
    margin-left: 0.5%;
    margin-top: 0.5%;
    border: 1px solid #a9c4df;
  }

  .consleLine {
    width: 100%;
    height: 2%;
  }

  .picBoder {
    width: 100%;
    height: 90%;
    overflow: auto;
  }

  .itemPic {
    position: relative;
    width: 23.5%;
    height: 49%;
    float: left;
    margin-top: 1%;
    margin-bottom: 1%;
    margin-left: 1%;
    border: 1px solid #a9c4df;
  }

  .input-with-select {
    background-color: #fff;
    width: 500px;
    float: left;
    margin-left: 20px;
  }

  .input-select {
    width: 100px;
  }

  .tittle {
    width: 100%;
    height: 25%;
    line-height: 100px;
    font-size: 22px;
    /*background-color: #2F80EC;*/
  }

  .detial {
    width: 100%;
    height: 80%;
    /*background-color: lightgreen;*/
  }

  .innerPut {
    width: 200px;
  }

  .doBtn {
    z-index: 11;
    width: 150px;
    height: 50px;
    position: absolute;
    background-color: #EEF2FB;
    border-radius: 8px 8px 25px 25px;
    box-shadow: #666 0px 0px 10px;
    zoom: 0.7;
    right: 20px;
    top: -7px;
  }

  .update, .dele {
    width: 35px;
    height: 35px;
    background-color: #F9F9F9;
    margin-left: 18px;
    margin-top: 2px;
    border-radius: 50%;
    float: left;
    color: white;
    text-align: center;
    font-size: 20px;
    line-height: 35px;
    cursor: pointer;
    /*background-color: #409eff;*/
  }

  .update {
    background-color: #3884E2;
  }

  .dele {
    background-color: #F3AD3E;
  }

  .innerBtn {
    position: absolute;
    width: 126px;
    height: 40px;
    margin-top: 5px;
    background-color: #F9F9F9;
    margin-left: 12px;
    border-radius: 20px 20px 20px 20px;
    box-shadow: #666 0px 0px 4px;
  }

  .input-with-select {
    margin-top: 20px;
  }

  .addBtn {
    float: right;
    top: 20px;
    right: 20px;
    position: relative;
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
  .chooseTime{
    position: absolute
  }
  .selectMenu{
    float: left;
  }
</style>
