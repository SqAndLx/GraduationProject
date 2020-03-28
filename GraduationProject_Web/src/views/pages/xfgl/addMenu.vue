<template>
    <div class="menu">
        <div class="select"><span class="font">手机号:</span>
            <el-input v-model="input" placeholder="请输入内容" class="selectbtn"></el-input>
            <el-button type="primary" @click="selectUserInfo()">搜  索</el-button>
        </div>
        <el-divider class="line"></el-divider>
        <div class="vipMes">
            <div class="vipFont">会员信息:</div>
            <div class="for">
                <el-form :inline="true" :model="userInfo">
                <el-form-item label="姓   名:">
                    <el-input v-model="userInfo.name" disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="会员等级:">
                    <el-input v-model="userInfo.grade"  disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="电   话:">
                    <el-input v-model="userInfo.tel"  disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="会员积分:">
                    <el-input v-model="userInfo.integral"  disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="性   别:">
                    <el-input v-model="userInfo.sex"  disabled="true"></el-input>
                </el-form-item>
                <el-form-item label="账户余额:">
                    <el-input v-model="userInfo.balance"  disabled="true"></el-input>
                </el-form-item>
            </el-form>
            </div>
        </div>
        <el-divider class="line"></el-divider>
        <div class="payMes">
            <div class="payFont">消费信息:</div>
           <div class="for">
                <el-form :inline="true" :model="formInline">
                <el-form-item label="消费项目:">
                    <el-select v-model="value" placeholder="请选择" class="selectMenu">
                    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="理发技师:">
                    <el-select v-model="value" placeholder="请选择" class="selectMenu">
                    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="支付方式:">
                    <el-select v-model="value" placeholder="请选择" class="selectMenu">
                    <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>
                    </el-select>
                </el-form-item>
                <el-form-item label="是否会员:">
                    <div class="dxk">
                        <el-radio v-model="radio" label="1">是</el-radio>
                        <el-radio v-model="radio" label="2">否</el-radio>
                    </div>
                </el-form-item>
            </el-form>
            <div class="result">
                <span  v-if="!isVip" class="resultMoney">消费金额:{{money}}元</span>
                <span v-else class="resultMoney">折后价格:{{money}}元</span>
            </div>
            </div>
        </div>
        <span slot="footer" class="dialog-footer">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogVisible = false">提交</el-button>
        </span>
    </div>
</template>
<script>
import axios from "axios"
import qs from 'qs'
export default {
  data() {
    return {
        money: 100,
        radio: '1',
        isVip: false,
        userInfo: {},
        input: '',
         options: [{
          value: '选项1',
          label: '黄金糕'
        }, {
          value: '选项2',
          label: '双皮奶'
        }, {
          value: '选项3',
          label: '蚵仔煎'
        }, {
          value: '选项4',
          label: '龙须面'
        }, {
          value: '选项5',
          label: '北京烤鸭'
        }],
        value: ''
    }
  },
  methods: {
      selectUserInfo(){
          if (this.input !== '') {
            var myreg = /^[1][3,4,5,7,8][0-9]{9}$/
            if (!myreg.test(this.input)) {
              this.$message({
                message: '请输入正确的手机号！',
                type: 'warning'
              })
            } else {
                let number = this.input
                let saveParams = {
                    tel: number
                }
                axios.post('/axios/api/selectHyByTel', this.qs.stringify(saveParams)).then((response) => {
                    this.userInfo = response.data.data
                }).catch((error) => {
                console.log(error)
                })
            }
          } else {
              this.$message({
                message: '手机号不能为空！',
                type: 'warning'
              })
          }
      }
  },
  created(){
  },
  watch: {
  }
};
</script>

<style scoped>
.menu{
    width: 100%;
    height: 550px;
}
.select{
    width: 100%;
    height: 50px;
}
.font{
    font-size: 20px;
    line-height: 50px;
    float: left;
    margin-left: 4%;
}
.selectbtn{
    width: 40% !important;
    float: left;
    left: 10%;
    top: 10%;
}
.vipMes{
    width: 100%;
    height: 220px;
}
.vipFont,.payFont{
    font-size: 20px;
    width: 90%;
    height: 35px;
    text-align: left;
    padding-top: 10px;
}
.payFont{
    margin-left: 3%;
}
.vipFont{
    margin-left: 3.5%;
}
.payMes{
    width: 100%;
    height: 230px;
    margin-top: 3px;
}
.for{
    margin-top: 10px
}
.dialog-footer {
    margin-top: -33px;
    right: 5%;
    position: absolute;
}
.dxk{
    width: 190px
}
.line{
    margin: 2% !important;
}
.result {
    width: 410px;
    height: 70px;
    margin-left: 2%;
}
.resultMoney {
    font-size: 30px;
    line-height: 67px;
    float: left;
}
</style>
<style>
.el-button--primary {
    margin-left: 20%;
    margin-top: 1%;
}
.el-form-item__label {
    margin-left: 12px;
    font-size: 20px !important;
}
.selectMenu{
    width: 190px;
}
</style>
