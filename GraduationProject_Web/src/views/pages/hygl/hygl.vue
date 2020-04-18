<template>
  <div class="all">
    <div class="content">
      <div class="title">
        <div style="margin-top: 15px;">
          <el-input placeholder="请输入内容" v-model="input3" class="input-with-select">
            <el-select v-model="select" slot="prepend" placeholder="请选择" class="input-select">
              <el-option label="姓名" value="1"></el-option>
              <el-option label="会员号" value="2"></el-option>
              <el-option label="办理人" value="3"></el-option>
            </el-select>
            <el-button slot="append" icon="el-icon-search"></el-button>
          </el-input>
          <el-button type="primary" @click="openDialog()" icon="el-icon-plus" class="insert"></el-button>
        </div>
        <el-dialog title="添  加  会  员" :visible.sync="dialogVisible" width="35%">
          <addVip @getData="getData" @closeDialog="closeDialog"></addVip>
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
            :total="hyxxList.length"
          ></el-pagination>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import tables from "./hyglTable.vue";
import axios from "axios";
import addVip from "./addVip";
import util from "../../../res/util.js";

export default {
  data() {
    return {
      dialogVisible: false,
      hyxxList: [],
      currentPage: 1, //初始页
      pagesize: 8, //    每页的数据
      input3: "",
      select: ""
    };
  },
  components: {
    tables,
    addVip
  },
  methods: {
    openDialog() {
      this.dialogVisible = true;
    },
    closeDialog() {
      this.dialogVisible = false;
    },
    getData() {
      axios
        .post("/axios/api/getHyxx")
        .then(response => {
          if (response.data.code == "200") {
            this.hyxxList = response.data.data;
            for (var i in this.hyxxList) {
              // 处理时间类型数据
              this.hyxxList[i].data = util.getTimeY(this.hyxxList[i].data);
            }
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
    },
    // 初始页currentPage、初始每页数据数pagesize和数据data
    handleSizeChange(size) {
      this.pagesize = size;
    }
  },
  created() {
    this.getData();
  }
};
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
  margin-top: 0.5%;
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

.input-with-select {
  background-color: #fff;
  width: 500px;
  float: left;
  margin-left: 20px;
}

.insert {
  float: right;
  margin-right: 20px;
}

.input-select {
  width: 100px;
}
</style>
