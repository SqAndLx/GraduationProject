<template>
  <div class="all">
    <div class="content">
      <div class="btn">
        <el-button type="primary" class="hyzk" @click="flag=false">
          会员:
          <input v-model="zk" :disabled="flag" class="input" @blur="updatezk()"/>折
        </el-button>
        <el-button type="primary" @click="dialogVisible = true" icon="el-icon-plus" class="insert"></el-button>
        <el-dialog
          title="消 费 信 息"
          :visible.sync="dialogVisible"
          width="35%"
          :close-on-click-modal="false"
        >
          <addMenu @getData="getData" @closeDialog="closeDialog"></addMenu>
        </el-dialog>
      </div>
      <div class="table">
        <tables class="tab" :tableData="xfjlList" :currentPage="currentPage"></tables>
        <div class="block">
          <el-pagination
            @current-change="handleCurrentChange"
            @size-change="handleSizeChange"
            :current-page="currentPage"
            :page-size="pagesize"
            layout="total, prev, pager, next, jumper"
            :total="xfjlList.length"
          ></el-pagination>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
    import tables from "./xfglTable.vue";
    import addMenu from "./addMenu.vue";
    import axios from "axios";
    import util from "../../../res/util.js";

    export default {
        data() {
            return {
                dialogVisible: false,
                currentPage: 1, //初始页
                pagesize: 8, //    每页的数据
                xfjlList: [],
                zk: '',
                flag: true
            };
        },
        components: {
            tables,
            addMenu
        },
        methods: {
            closeDialog() {
                this.dialogVisible = false
            },
            updatezk() {
                this.$store.commit('setZk', this.zk)
                axios
                    .get("/axios/api/updateZk?type=" + this.zk)
                    .then(response => {
                        if (response.data.code == "200") {
                            this.$message.success("修改折扣成功！");
                        }
                    })
                    .catch(error => {
                        console.log(error);
                    });
                this.flag = true;
            },
            handleCurrentChange(currentPage) {
                this.currentPage = currentPage;
            },
            // 初始页currentPage、初始每页数据数pagesize和数据data
            handleSizeChange(size) {
                this.pagesize = size;
            },
            getData() {
                axios
                    .post("/axios/api/getXfxx")
                    .then(response => {
                        if (response.data.code == "200") {
                            this.xfjlList = response.data.data;
                            for (var i in this.xfjlList) {
                                if (this.xfjlList[i].id == '0000') {
                                    this.xfjlList.splice(i, 1)
                                }
                                // 处理时间类型数据
                                this.xfjlList[i].data = util.getTimeY(this.xfjlList[i].data);
                            }
                        }
                    })
                    .catch(error => {
                        console.log(error);
                    });
            },
            getZk() {
                axios
                    .post("/axios/api/getZk")
                    .then(response => {
                        if (response.data.code == "200") {
                            console.log(response)
                            this.zk = response.data.data.type;
                            this.$store.commit('setZk', this.zk)
                        }
                    })
                    .catch(error => {
                        console.log(error);
                    });
            }
        },
        created() {
            this.getData();
            this.getZk();
        }
    };
</script>

<style scoped>
  .all {
    height: 100%;
    width: 100%;
    overflow: hidden;
  }

  .content {
    height: 98%;
    width: 99%;
    border: 1px solid #a9c4df;
    margin-left: 0.5%;
    margin-top: 0.5%;
  }

  .btn {
    height: 10%;
    float: right;
    width: 20%;
  }

  .el-button--primary {
    margin-left: 90%;
    margin-top: 1%;
    width: 8%;
    font-size: 18px;
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

  .hyzk {
    width: 39%;
    margin-left: 0%;
    margin-top: 20px;
  }

  .insert {
    width: 39%;
    margin-left: 10%;
  }

  .input {
    width: 20px;
    cursor: pointer;
    background-color: #409EFF;
    border: none
  }
</style>
<style>
  .el-dialog__title {
    font-size: 24px !important;
  }
</style>
