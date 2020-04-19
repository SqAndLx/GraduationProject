<template>
  <div class="menu">
    <el-form label-width="80px">
      <el-form-item label="姓   名:">
        <!-- <span style="color:red">*</span> -->
        <el-input v-model="name"></el-input>
      </el-form-item>
      <el-form-item label="性   別:" style="width: 50%;float: left">
        <el-radio-group v-model="sex">
          <el-radio label="男" value="男" style="z-index:1"></el-radio>
          <el-radio label="女" vaule="女" style="z-index:1"></el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="理发技师:" style="width: 50%;float: right;">
        <el-select v-model="updateName" placeholder="请选择" style="z-index:1">
          <el-option v-for="item in barberList" :key="item.id" :label="item.name" :value="item.name"></el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="会 员 号:">
        <el-input v-model="tel"></el-input>
      </el-form-item>
      <el-form-item label="会员积分:">
        <el-input v-model="integral" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="会员等级:">
        <el-input v-model="grade" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="办理日期:">
        <el-input v-model="data" :disabled="true"></el-input>
      </el-form-item>
      <el-form-item label="账户余额:">
        <el-input v-model="balance"></el-input>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="addVip()">立即创建</el-button>
        <el-button @click="close()">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";
import util from "../../../res/util.js";

export default {
  name: "addVip",
  data() {
    return {
      barberList: [],
      name: "",
      sex: "",
      tel: "",
      integral: 0,
      grade: "初级",
      data: util.getTimeY(new Date()),
      balance: "",
      updateName: ""
    };
  },
  methods: {
    getLfs() {
      axios
        .post("/axios/api/getYgxx")
        .then(response => {
          if (response.data.code == "200") {
            this.barberList = response.data.data;
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    addVip() {
      var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
      if (this.tel == "" && !myreg.test(this.tel)) {
        this.$message({
          message: "请输入正确的手机号！",
          type: "warning"
        });
        return;
      }
      if (
        this.sex == "" ||
        this.balance == "" ||
        this.name == "" ||
        this.updateName == ""
      ) {
        this.$message({
          message: "请输入必填項！",
          type: "warning"
        });
        return;
      }
      let user = {
        name: this.name,
        sex: this.sex,
        tel: this.tel,
        integral: this.integral,
        grade: this.grade,
        data: this.data,
        balance: this.balance,
        updateName: this.updateName
      };
      axios
        .post("/axios/api/insertHy", user)
        .then(response => {
          if (response.data.code === 200) {
            this.$emit("getData");
            this.close();
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    close() {
      this.name = "";
      this.sex = "";
      this.tel = "";
      this.balance= "";
      this.updateName= "";
      this.$emit("closeDialog");
    },
  },
  created() {
    this.getLfs();
  }
};
</script>

<style scoped>
</style>
