<template>
  <div>
    <el-table :data="tableData.slice((currentPage-1)*8,currentPage*8)" border>
      <el-table-column type="index" width="65" align="center"></el-table-column>
      <el-table-column prop="name" label="姓名" width="150" align="center"></el-table-column>
      <el-table-column prop="tel" label="会员号" width="230" align="center"></el-table-column>
      <el-table-column prop="sex" label="性别" width="100" align="center"></el-table-column>
      <el-table-column prop="integral" label="会员积分" width="150" align="center"></el-table-column>
      <el-table-column prop="grade" label="会员等级" width="150" align="center"></el-table-column>
      <el-table-column prop="data" label="办理日期" width="230" align="center"></el-table-column>
      <el-table-column prop="updateName" label="办理人" width="200" align="center"></el-table-column>
      <el-table-column prop="balance" label="账户余额" width="150" align="center"></el-table-column>
      <el-table-column label="操作" width="230" align="center">
        <template slot-scope="scope">
          <el-button
            type="primary"
            icon="el-icon-notebook-2"
            circle
            title="充值记录"
            @click="openCzjlDialog(scope.row)"
          ></el-button>
          <el-button
            type="success"
            icon="el-icon-shopping-cart-full"
            title="充值"
            circle
            @click="openCzDialog(scope.row)"
          ></el-button>
          <el-button
            type="warning"
            icon="el-icon-edit"
            circle
            title="修改会员信息"
            @click="showUpdateLog(scope.row)"
          ></el-button>
          <el-button
            type="danger"
            icon="el-icon-delete"
            circle
            title="删除会员"
            @click="deleteHy(scope.row)"
          ></el-button>
        </template>
      </el-table-column>
    </el-table>
    <div>
      <el-dialog title="充值记录" :visible.sync="czjlDialogVisible" width="35%">
        <el-table :data="czjlData" border>
          <el-table-column type="index" width="65" align="center"></el-table-column>
          <el-table-column prop="data" label="充值时间" width="150" align="center"></el-table-column>
          <el-table-column prop="rechargemoney" label="充值金额" width="100" align="center"></el-table-column>
          <el-table-column prop="rechargeway" label="充值方式" width="100" align="center"></el-table-column>
          <el-table-column prop="remarks" label="备注" width="215" align="center">
            <template slot-scope="scope">
              <span v-if="scope.row.remarks == ''">无</span>
              <span v-else>{{ scope.row.remarks }}</span>
            </template>
          </el-table-column>
        </el-table>
      </el-dialog>
      <el-dialog title="会 员 充 值" :visible.sync="czDialogVisible" width="35%">
        <el-form label-width="150px">
          <el-form-item label="账 户 的 当 前 余 额 :">
            <el-input v-model="money"></el-input>
          </el-form-item>
          <el-form-item label="请 输 入 充 值 金 额 :">
            <el-input v-model="czje" placeholder="请输入要充值的金额"></el-input>
          </el-form-item>
          <el-form-item label="充 值 后 账 户 余 额 :">
            <el-input v-model="czhje"></el-input>
          </el-form-item>
          <el-form-item label="充    值    方    式 :">
            <el-select v-model="way" placeholder="请选择" style="width:100%">
              <el-option
                v-for="item in rechargeway"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              ></el-option>
            </el-select>
          </el-form-item>
          <el-form-item label="备                注 :">
            <el-input v-model="remarks"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="cz()">充值</el-button>
            <el-button @click="czDialogVisible = false, czje = '',remarks = '',way = ''">取消</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
      <el-dialog title="修改会员信息" :visible.sync="dialogVisible" width="35%">
        <el-form label-width="80px">
          <el-form-item label="姓   名:">
            <el-input v-model="name"></el-input>
          </el-form-item>
          <el-form-item label="性   別:">
            <el-radio-group v-model="sex">
              <el-radio label="男" value="男"></el-radio>
              <el-radio label="女" vaule="女"></el-radio>
            </el-radio-group>
          </el-form-item>
          <el-form-item label="会 员 号:">
            <el-input v-model="tel"></el-input>
          </el-form-item>
          <el-form-item label="会员等级:">
            <el-input v-model="grade"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="update()">确认修改</el-button>
            <el-button @click="close()">取消</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </div>
  </div>
</template>

<script>
import axios from "axios";
import util from "../../../res/util.js";

export default {
  props: {
    tableData: {
      type: Array,
      default() {
        return [];
      }
    },
    currentPage: {
      type: Number,
      default() {
        return 0;
      }
    }
  },
  data() {
    return {
      dialogVisible: false,
      name: "",
      tel: "",
      sex: "",
      grade: "",
      id: "",
      czDialogVisible: false,
      czje: "",
      money: "",
      czjlDialogVisible: false,
      czjlData: [],
      remarks: "",
      rechargeway: [
        {
          value: 101,
          label: "微信"
        },
        {
          value: 102,
          label: "支付宝"
        },
        {
          value: 103,
          label: "现金"
        },
        {
          value: 104,
          label: "银行卡"
        }
      ],
      way: ""
    };
  },
  computed: {
    czhje() {
      var reg = /^[0-9]+.?[0-9]*$/;
      if (!reg.test(this.czje) && this.czje !== "") {
        this.$message({
          message: "请输入数字！",
          type: "warning"
        });
        return Number(this.money);
      }
      return Number(this.czje) + Number(this.money);
    }
  },
  methods: {
    cz() {
      var reg = /^[0-9]+.?[0-9]*$/;
      if (!reg.test(this.czje) || this.czje === "") {
        this.$message({
          message: "请输入正确的充值金额！",
          type: "warning"
        });
        return;
      }
      // let way;
      // switch (this.rechargeway) {
      //   case "微信":
      //     way = 101;
      //     break;
      //   case "支付宝":
      //     way = 102;
      //     break;
      //     case "现金":
      //     way = 103;
      //     break;
      //     case "银行卡":
      //     way = 104;
      //     break;
      // }
      let updateParams = {
        id: this.id,
        rechargemoney: this.czje,
        tel: this.tel,
        rechargeway: this.way,
        remarks: this.remarks
      };
      axios
        .post("/axios/api/recharge", updateParams)
        .then(response => {
          if (response.data.code == "200") {
            this.$message({
              message: "充值成功",
              type: "success"
            });
            this.$parent.getData();
            this.czje = "";
            this.czDialogVisible = false;
          } else {
            this.$message.error("充值失败");
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    openCzDialog(data) {
      this.id = data.id;
      this.czDialogVisible = true;
      this.money = data.balance;
      this.tel = data.tel;
    },
    openCzjlDialog(val) {
      this.czjlDialogVisible = true;
      this.getCzjlData(val.tel);
    },
    getCzjlData(val) {
      let url = "/axios/api/getRechargeByTel/" + val;
      axios
        .get(url)
        .then(response => {
          if (response.data.code == "200") {
            this.czjlData = response.data.data;
            for (var i in this.czjlData) {
              // 处理时间类型数据
              this.czjlData[i].data = util.getTimeY(this.czjlData[i].data);
            }
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    showUpdateLog(val) {
      this.dialogVisible = true;
      this.grade = val.grade;
      this.name = val.name;
      this.sex = val.sex;
      this.tel = val.tel;
      this.id = val.id;
    },
    close() {
      this.dialogVisible = false;
    },
    update() {
      let updateParams = {
        id: this.id,
        grade: this.grade,
        name: this.name,
        sex: this.sex,
        tel: this.tel
      };
      axios
        .post("/axios/api/updateHy", updateParams)
        .then(response => {
          if (response.data.code == "200") {
            this.$message({
              message: "修改成功",
              type: "success"
            });
            this.$parent.getData();
            this.close();
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    deleteHy(val) {
      this.$confirm("将删除该会员, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        let deleteParams = {
          id: val.id,
          name: val.name
        };
        axios
          .post("/axios/api/deleteHy", this.qs.stringify(deleteParams))
          .then(response => {
            if (response.data.code == "200") {
              this.$message({
                message: "删除成功！",
                type: "success"
              });
              this.$parent.getData();
            }
          })
          .catch(error => {
            console.log(error);
          });
      });
    }
  }
};
</script>
<style scoped>
.el-icon-edit {
  color: darkgoldenrod;
}

.el-icon-delete-solid {
  color: chartreuse;
}
</style>
