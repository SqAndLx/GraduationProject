<template>
  <div class="menu">
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
        <el-button type="primary" @click="addUser()">立即创建</el-button>
        <el-button @click="close()">取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>

<script>
import axios from "axios";
export default {
  name: "addUsr",
  data() {
    return {
      name: "",
      sex: "",
      salary: "",
      remarks: "",
      tel: ""
    };
  },
  methods: {
    // openDialog(val) {
    //   this.name = val.name;
    //   this.sex = val.sex;
    //   this.salary = val.salary;
    //   this.tel = val.tel;
    //   this.remarks = val.remarks;
    // },
    close() {
      this.name = "";
      this.sex = "";
      this.salary = "";
      this.tel = "";
      this.remarks = "";
      this.$emit("closeDialog");
    },
    addUser() {
      var myreg = /^[1][3,4,5,7,8][0-9]{9}$/;
      if (this.tel == "" && !myreg.test(this.tel)) {
        this.$message({
          message: "请输入正确的手机号！",
          type: "warning"
        });
        return;
      }
      if (this.sex == "" || this.salary == "") {
        this.$message({
          message: "请输入必填項！",
          type: "warning"
        });
        return;
      }
      let user = {
        name: this.name,
        sex: this.sex,
        salary: this.salary,
        remarks: this.remarks,
        tel: this.tel
      };
      axios
        .post("/axios/api/insertYg", user)
        .then(response => {
          if (response.data.code === 200) {
            this.$emit("getData");
            this.close();
          }
        })
        .catch(error => {
          console.log(error);
        });
    }
  }
};
</script>

<style scoped>
</style>
