<template>
  <div class="all">
    <span class="font">账&nbsp;&nbsp;&nbsp;&nbsp;号：</span>
    <el-input
      placeholder="请输入账号"
      type="text"
      show-word-limit
      clearable
      v-model="input"
      class="input"
    ></el-input>
    <br />
    <span class="font">密&nbsp;&nbsp;&nbsp;&nbsp;码：</span>
    <el-input placeholder="请输入密码" v-model="password" clearable class="password" show-password></el-input>
    <br />
    <yzm class="yzm" ref="child"></yzm>
    <el-button type="primary" @click="login" class="btn">登录</el-button>
    <br />
    <div class="xgmmdiv">
      <span class="xgmm" @click="openXg()">修改密码</span>
    </div>
    <el-dialog title="修改密码" :visible.sync="flag" width="35%">
      <span class="font2">账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</span>
      <el-input placeholder="请输入账号" v-model="input2" clearable class="password2" type="text" show-word-limit></el-input>
      <br />
      <span class="font2">初始密码：</span>
      <el-input placeholder="请输入初始密码" v-model="password2" clearable class="password2" show-password></el-input>
      <br />
      <span class="font2">新&nbsp;&nbsp;密&nbsp;码：</span>
      <el-input
        placeholder="请输入新的密码"
        v-model="newPassword"
        clearable
        class="password2"
        show-password
      ></el-input>
      <br />
      <span class="font2">确认密码：</span>
      <el-input
        placeholder="请确认密码"
        v-model="newPassword2"
        clearable
        class="password2"
        show-password
      ></el-input>
      <br />
      <el-button type="primary" @click="update()" class="btn">确定修改</el-button>
    </el-dialog>
  </div>
</template>

<script>
import axios from "axios";
import qs from "qs";
import yzm from "../login/yzm.vue";
export default {
  components: { yzm },
  data() {
    return {
      input: "",
      password: "",
      flag: false,
      newPassword: "",
      password2: "",
      newPassword2: "",
      input2: ""
    };
  },
  methods: {
    openXg() {
      this.flag = true;
    },
    update() {
      if (this.newPassword != this.newPassword2) {
        this.$message({
          message: "填入的新密码不一致",
          type: "error"
        });
        return false;
      }
      let saveParams = {
        number: this.input2,
        password: this.password2
      };
      axios
        .post("/axios/api/Login", this.qs.stringify(saveParams))
        .then(response => {
          let ms = response.data;
          if (ms != null && ms != "") {
            updateMM();
            this.$router.push({ name: "login" });
          } else {
            this.$message.error("原始账号或密码错误！");
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    updateMM() {
      let saveParams = {
        number: this.input2,
        password: this.newPassword
      };
      axios
        .post("/axios/api/update", this.qs.stringify(saveParams))
        .then(response => {
          this.$message.success("修改密码成功，请登录！");
          this.flag=false
        })
        .catch(error => {
          console.log(error);
        });
    },
    login() {
      let checkResult = this.checkNull();
      if (!checkResult) {
        return;
      }
      if (this.test()) {
        let saveParams = {
          number: this.input,
          password: this.password
        };
        axios
          .post("/axios/api/Login", this.qs.stringify(saveParams))
          .then(response => {
            debugger
            let ms = response.data;
            if (ms != null  && ms != "") {
              // 将对象转换成json存在缓存中
              window.localStorage.setItem("loginer", JSON.stringify(ms));
              this.$router.push({ name: "home" });
            } else {
              this.$message.error("账号或密码错误！");
            }
          })
          .catch(error => {
            console.log(error);
          });
      }
    },
    // 验证码校验
    test() {
      let identifyCode = this.$store.getters.getIdentifyCode;
      let code = this.$refs.child.code;
      if (code === "") {
        this.$message({
          message: "请输入验证码！",
          type: "warning"
        });
        return false;
      } else if (identifyCode !== code) {
        this.$message.error("验证码填写错误！");
        this.$refs.child.refreshCode();
        return false;
      } else {
        return true;
      }
    },
    // 检验账号密码是否为空
    checkNull() {
      if (this.password === "" || this.input === "") {
        this.$message({
          message: "账号或密码不能为空！",
          type: "warning"
        });
        return false;
      } else {
        return true;
      }
    }
  }
};
</script>

<style scoped>
.password {
  width: 20%;
  margin-top: 2%;
}
.password2 {
  width: 40%;
  margin-top: 2%;
}
.input {
  margin-top: 20%;
  width: 20%;
}
.all {
  width: 100%;
  height: 100%;
  background: url(../../assets/login.jpg) no-repeat;
  background-size: 100% 100%;
}
.btn {
  width: 25%;
  margin-top: 2%;
}
.yzm {
  margin-left: 38.2%;
  margin-top: 2%;
}
.font {
  color: white;
  font-size: 18px;
}
.font2 {
  font-size: 18px;
}
.xgmm {
  font-size: 18px;
  font-style: italic;
  text-decoration: underline;
  color: cornflowerblue;
}
.xgmmdiv {
  margin-top: 15px;
  cursor: pointer;
}
</style>
