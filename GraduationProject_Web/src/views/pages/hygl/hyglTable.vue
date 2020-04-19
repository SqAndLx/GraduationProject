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
          <el-button type="primary" icon="el-icon-edit" circle @click="showUpdateLog(scope.row)"></el-button>
          <el-button type="danger" icon="el-icon-delete" circle @click="deleteHy(scope.row)"></el-button>
        </template>
      </el-table-column>
    </el-table>
    <div>
      <el-dialog title="修改会员信息" :visible.sync="dialogVisible" width="35%">
        <el-form label-width="80px">
          <el-form-item label="姓   名:">
            <el-input v-model="name"></el-input>
          </el-form-item>
          <el-form-item label="性   別:" >
            <el-radio-group v-model="sex">
              <el-radio label="男" value="男" ></el-radio>
              <el-radio label="女" vaule="女" ></el-radio>
            </el-radio-group>
          </el-form-item>
          <!-- <el-form-item label="理发技师:" style="width: 50%;float: right;">
            <el-select v-model="updateName" placeholder="请选择" style="z-index:1">
              <el-option
                v-for="item in barberList"
                :key="item.id"
                :label="item.name"
                :value="item.name"
              ></el-option>
            </el-select>
          </el-form-item>-->
          <el-form-item label="会 员 号:">
            <el-input v-model="tel"></el-input>
          </el-form-item>
          <!-- <el-form-item label="会员积分:">
            <el-input v-model="integral" ></el-input>
          </el-form-item>-->
          <el-form-item label="会员等级:">
            <el-input v-model="grade"></el-input>
          </el-form-item>
          <!-- <el-form-item label="账户余额:">
            <el-input v-model="balance"></el-input>
          </el-form-item>-->
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
import qs from "qs";

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
      id: ""
    };
  },
  methods: {
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
    update(val) {
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
  },
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
