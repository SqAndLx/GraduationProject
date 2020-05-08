<template>
  <div class="all">
    <div class="innerBoder">
      <!--     操作行-->
      <div class="consleLine">
        <el-input placeholder="请输入内容" v-model="input3" class="input-with-select">
          <el-select v-model="select" slot="prepend" placeholder="请选择" class="input-select">
            <el-option label="商品名" value="c_name"></el-option>
          </el-select>
          <el-button slot="append" icon="el-icon-search" @click="selectByValue()"></el-button>
        </el-input>
        <el-button type="primary" class="addBtn" @click="updateDialogVisible = true">添加</el-button>
      </div>
      <!-- 商品渲染开始-->
      <div class="picBoder">
        <!--一个商品为单位-->
        <div class="itemPic" v-for="item in goodsList" :key="item.id">
          <div class="doBtn">
            <div class="innerBtn">
              <span class="update" title="点击修改商品" @click="openUpdateGood(item)">改</span>
              <span class="dele" title="点击下架商品" @click="delGood(item)">删</span>
            </div>
          </div>
          <!--      简介-->
          <div class="tittle">
            {{item.name}}
          </div>
          <div class="detial">
            <el-form label-width="80px">
              <el-form-item label="商品单价">
                <el-input v-model="item.price" class="innerPut" :disabled="true"></el-input>
              </el-form-item>
              <el-form-item label="商品简介">
                <el-input
                  type="textarea"
                  :rows="6"
                  placeholder="请输入内容"
                  v-model="item.remarks"
                  class="innerPut"
                  :disabled="true">
                </el-input>
              </el-form-item>
              <el-form-item label="商品个数">
                <el-input v-model="item.number" class="innerPut" :disabled="true"></el-input>
              </el-form-item>
            </el-form>
          </div>
        </div>
      </div>
      <el-dialog title="商品修改" :visible.sync="updateDialogVisible" width="35%">
        <el-form label-width="80px">
          <el-form-item label="商品名称">
            <el-input v-model="good.name"></el-input>
          </el-form-item>
          <el-form-item label="商品单价">
            <el-input v-model="good.price"></el-input>
          </el-form-item>
          <el-form-item label="商品简介">
            <el-input
              type="textarea"
              :rows="6"
              placeholder="请输入内容"
              v-model="good.remarks">
            </el-input>
          </el-form-item>
          <el-form-item label="商品个数">
            <el-input v-model="good.number"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="updateGood(good)">确认修改</el-button>
            <el-button @click="close()">取消</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
      <el-dialog title="添加商品" :visible.sync="updateDialogVisible" width="35%">
        <el-form label-width="80px">
          <el-form-item label="商品名称">
            <el-input v-model="good.name"></el-input>
          </el-form-item>
          <el-form-item label="商品单价">
            <el-input v-model="good.price"></el-input>
          </el-form-item>
          <el-form-item label="商品简介">
            <el-input
              type="textarea"
              :rows="6"
              placeholder="请输入内容"
              v-model="good.remarks">
            </el-input>
          </el-form-item>
          <el-form-item label="商品个数">
            <el-input v-model="good.number"></el-input>
          </el-form-item>
          <el-form-item>
            <el-button type="primary" @click="insertGood(good)">确认添加</el-button>
            <el-button @click="close()">取消</el-button>
          </el-form-item>
        </el-form>
      </el-dialog>
    </div>
  </div>
</template>
<script>
    import axios from "axios";

    export default {
        data() {
            return {
                textarea: '',
                num: '',
                input3: "",
                select: "c_name",
                goodsList: '',
                price: '',
                updateDialogVisible: false,
                good: {},
            }
        },
        methods: {
            updateGood(good) {
                axios.post('/axios/api/updateSp/', good).then((response) => {
                    if (response.data.code == '200') {
                        this.$message({
                            message: '修改成功！',
                            type: 'success'
                        })
                        this.close()
                    }
                })
            },
            insertGood(good) {
                axios.post('/axios/api/insertSp/', good).then((response) => {
                    if (response.data.code == '200') {
                        this.$message({
                            message: '添加成功！',
                            type: 'success'
                        })
                        this.close();
                        this.getGoodsList();
                    }
                })
            },
            delGood(good) {
                this.$confirm('确定下架此商品吗?', '提示', {
                    confirmButtonText: '确定',
                    cancelButtonText: '取消',
                    type: 'warning'
                }).then(() => {
                    let url = '/axios/api/deleteSp/' + good.id
                    axios.get(url).then((response) => {
                        if (response.data.code == '200') {
                            this.$message({
                                message: '修改成功！',
                                type: 'success'
                            })
                            this.getGoodsList()
                        }
                    })
                }).catch(() => {
                    this.$message({
                        type: 'info',
                        message: '已取消删除'
                    });
                });
            },
            close() {
                this.updateDialogVisible = false
                this.good = {}
            },
            openUpdateGood(data) {
                this.updateDialogVisible = true
                this.good = data
            },
            getGoodsList() {
                axios.post('/axios/api/getSpxx').then((response) => {
                    let list = response.data.data
                    for (var i = 0; i < list.length; i++) {
                        if (list[i].type === '1') {
                            list.splice(i, 1); // 将使后面的元素依次前移，数组长度减1
                            i--; // 如果不减，将漏掉一个元素
                        }
                    }
                    this.goodsList = list
                    console.log(this.goodsList,"sdfsdg")
                })
            },
            selectByValue() {
                if (this.input3 === '') {
                    this.getGoodsList()
                } else {
                    let url = '/axios/api/getSpxxByName/' + this.input3
                    axios
                        .get(url).then((response) => {
                        let list = response.data.data
                        for (var i = 0; i < list.length; i++) {
                            if (list[i].type === '1') {
                                list.splice(i, 1); // 将使后面的元素依次前移，数组长度减1
                                i--; // 如果不减，将漏掉一个元素
                            }
                        }
                        this.goodsList = list
                    })
                }
            },
        },
        created() {
            this.getGoodsList()
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
    height: 10%;
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
</style>
