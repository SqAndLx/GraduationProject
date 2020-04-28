<template>
  <div class="menu">
    <div class="select"><span class="font">手机号:</span>
      <el-input v-model="input" placeholder="请输入内容" class="selectbtn"></el-input>
      <el-button type="primary" icon="el-icon-search" @click="selectUserInfo()">搜 索</el-button>
    </div>
    <div class="vipMes" v-if="isVip">
      <el-divider class="line"></el-divider>
      <div class="vipFont"><i class="el-icon-s-custom"></i> 会员信息:</div>
      <div class="for">
        <el-form :inline="true" :model="userInfo">
          <el-form-item label="姓   名:">
            <el-input v-model="userInfo.name" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="会员等级:">
            <el-input v-model="userInfo.grade" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="电   话:">
            <el-input v-model="userInfo.tel" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="会员积分:">
            <el-input v-model="userInfo.integral" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="性   别:">
            <el-input v-model="userInfo.sex" :disabled="true"></el-input>
          </el-form-item>
          <el-form-item label="账户余额:">
            <el-input v-model="userInfo.balance" :disabled="true"></el-input>
          </el-form-item>
        </el-form>
      </div>
    </div>

    <div class="payMes">
      <el-divider class="line"></el-divider>
      <div class="payFont"><i class="el-icon-s-order"></i>消费信息:</div>
      <div class="for">
        <el-form :inline="true">
          <el-form-item label="消费项目:">
            <el-select v-model="xfxm" multiple placeholder="请选择" class="selectMenu">
              <el-option v-for="item in goodsList" :key="item.id" :label="item.name" :value="item.id"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="理发技师:">
            <el-select v-model="lfs" placeholder="请选择" class="selectMenu">
              <el-option v-for="item in barberList" :key="item.id" :label="item.name" :value="item"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="支付方式:">
            <el-select v-model="value" placeholder="请选择" class="selectMenu">
              <el-option v-for="item in options" :key="item.value" :label="item.label" :value="item.value"></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="是否会员:">
            <div class="dxk">
              <el-radio v-model="radio" label="1" :disabled="true">是</el-radio>
              <el-radio v-model="radio" label="2" :disabled="true">否</el-radio>
            </div>
          </el-form-item>
        </el-form>
        <div class="result">
          <span v-if="!isVip" class="resultMoney">消费金额:{{money}}元</span>
          <span v-else class="resultMoney">折后价格:{{money}}元</span>
          <span class="footerDiv">
            <el-button @click="dialogVisible = false">取 消</el-button>
            <el-button type="primary" @click="dialogVisible = false,addXfjl()">提交</el-button>
          </span>
        </div>
      </div>
    </div>
<!--    <div class="footerDiv">-->
<!--      <span class="footerDiv">-->
<!--            <el-button @click="dialogVisible = false">取 消</el-button>-->
<!--            <el-button type="primary" @click="dialogVisible = false">提交</el-button>-->
<!--      </span>-->
<!--    </div>-->
  </div>
</template>
<script>
    import axios from "axios"
    import qs from 'qs'

    export default {
        data() {
            return {
                // money: 100,
                radio: '2',
                isVip: false,
                userInfo: {},
                goodsList: [],
                barberList: [],
                options:[{
                    value:101,
                    label:'微信',
                },{
                    value:102,
                    label:'支付宝',
                },{
                    value:103,
                    label:'现金',
                },{
                    value:104,
                    label:'银行卡',
                }],
                input: '',
                value: '',
                lfs: '',//理发师
                xfxm:''//消费项目
            }
        },
        computed: {
          money() {
            let count = 0
            for (let item of this.xfxm) {
                let goodList = this.$store.state.goodsList
                for (let good of goodList) {
                    if (good.id === item) {
                        console.log('xiangdengl', good.price)
                        count += Number(good.price)
                    }
                }
            }
            if (this.lfs) {
                count += Number(this.lfs.salary)
            }
            let zk = this.$store.state.zk
            if (zk && zk !== 0 && this.radio === '1') {
              return count * (Number(zk) / 10)
            }
            return count
          }
        },
        methods: {
          addXfjl() {
            if(isVip){
              let param = {
              data : new Date(),
              hymoney : this.money,
              customerId : this.lfs.id,
              personnelId : this.lfs.id,
              goodsId : this.xfxm.id,
              codeId : this.value
              }
            } else {
              let param = {
              data : new Date(),
              money : this.money,
              customerId : this.lfs.id,
              personnelId : this.lfs.id,
              goodsId : this.xfxm.id,
              codeId : this.value
              }
            }
            let url = '/axios/api/addXfjl'
            axios.post(url, this.qs.stringify(saveParams)).then(() => {
              if (response.data.code == '200') {
                this.$message({
                    message: '添加成功！',
                    type: 'success'
                })
              }
            })
          },
            selectUserInfo() {
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
                            if (response.data.data != null) {
                                this.userInfo = response.data.data
                                this.isVip = true
                                this.radio = '1'
                            } else {
                                this.$message({
                                    message: '无此会员！',
                                    type: 'warning'
                                })
                            }
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
            },
            getXfxm() {
                axios.post('/axios/api/getSpxx')
                    .then((response) => {
                        if (response.data.code == '200') {
                            this.goodsList = response.data.data
                            this.$store.commit('setGoodsList', this.goodsList)
                        }
                    }).catch((error) => {
                    console.log(error)
                })
            },
            getLfs(){
                axios.post('/axios/api/getYgxx')
                    .then((response) => {
                        if (response.data.code == '200') {
                            this.barberList = response.data.data
                        }
                    }).catch((error) => {
                    console.log(error)
                })
            }
        },
        created() {
            //获取下拉框各个选项
            this.getXfxm();
            this.getLfs();
        },
        watch: {}
    };
</script>

<style scoped>
  .menu {
    width: 100%;
    height: 500px;
    overflow-y: auto;
    overflow-x: hidden;
  }

  .select {
    width: 100%;
    height: 50px;
  }

  .font {
    font-size: 20px;
    line-height: 50px;
    float: left;
    margin-left: 4%;
  }

  .selectbtn {
    width: 40% !important;
    float: left;
    left: 10%;
    top: 10%;
  }

  .vipMes {
    width: 100%;
    height: 240px;
  }

  .vipFont, .payFont {
    font-size: 20px;
    width: 90%;
    height: 35px;
    text-align: left;
    padding-top: 10px;
  }

  .payFont {
    margin-left: 3%;
  }

  .vipFont {
    margin-left: 3.5%;
  }

  .payMes {
    width: 100%;
    height: 230px;
    margin-top: 3px;
  }

  .for {
    margin-top: 10px
  }

  .footerDiv{
    line-height: 67px;
  }

  .dxk {
    width: 190px
  }

  .line {
    margin: 2% !important;
  }

  .result {
    width: 755px;
    height: 70px;
    margin-left: 2%;
  }

  .resultMoney {
    font-size: 30px;
    line-height: 67px;
    float: left;
  }

  .el-icon-s-order{
   margin-right: 5px;
}

  .el-icon-s-custom {
    margin-right: 5px;
  }
  .selectMenu {
    width: 190px;
  }
  .btn{
    margin-left: 20%;
  }
</style>
