<template>
  <div class="all" style="background: #f1f1f1;">
    <!-- 概述 -->
    <div class="gs-all">
      <div class="gs">
        <img src="../../../assets/gs.png" style="color: #2F80EC">
        <span class="newTitle">概述</span>
      </div>
      <div class="wordkuang">
        从{{this.tjq1}}到{{this.tjq2}}，美酷理发店共收入
        <span style="cursor:text;color:#333;">10000</span>元，
        其中，盈利
        <span style="cursor:text;color:#333;">2546</span>元。
      </div>
    </div>
    <!-- 柱状图-->
    <div class="zzt-all">
      <div class="zzt">
        <img src="../../../assets/gs.png">
        <span class="newTitle">近五月盈利、收入分析</span>
      </div>
      <p class="chartTitle" style="background-color:#f5f5f5">
        <span style="float:right;margin-right:10px;">单位：元</span>
      </p>
      <div class="echartsZz">
        <chart :options="zzOptions"></chart>
      </div>
    </div>
    <!-- 饼状图-->
    <div class="zzt-all">
      <div class="zzt">
        <img src="../../../assets/gs.png">
        <span class="newTitle">员工业绩分析</span>
      </div>
      <p class="chartTitle" style="background-color:#f5f5f5">
        <span style="float:right;margin-right:10px;">单位：件</span>
      </p>
      <div class="echartsBz">
        <chart :options="orgOptions"></chart>
      </div>
    </div>
  </div>
</template>

<script>
    import echarts from './echarts.js'
    import axios from "axios"

    export default {
        data() {
            return {
                orgOptions: {},
                tjq1: '',
                tjq2: '',
                zzOptions: {},
                bztData: [],
            }
        },
        methods: {
            getNowDate() {
                this.tjq1 = new Date().getFullYear();
                this.tjq2 = new Date().getFullYear() - 1;
            },
            getBzt() {
                axios.post('/axios/api/bzt')
                    .then((response) => {
                        if (response.data.code == '200') {
                            for (var i = 0; i < response.data.data.length; i++) {
                                this.bztData.push(response.data.data[i-1]);
                            }
                        }
                    }).catch((error) => {
                    console.log(error)
                })
            }
        },
        created() {
            this.getNowDate();
            this.getBzt();//获取饼状图数据
        },
        mounted() {
            this.orgOptions = echarts.getOptions(this.bztData);
            this.zzOptions = echarts.getZzOptions();
        }
    }
</script>

<style scoped>
  .all {
    height: 100%;
    width: 100%;
  }

  .gs,
  .zzt {
    border-bottom: 3px solid #409EFF;
    background: #f1f1f1;
    padding: 15px;
    text-align: left;
  }

  .gs img {
    height: 20px;
    padding-right: 5px;
    width: 20px;
  }

  .zzt img {
    height: 20px;
    padding-right: 5px;
    width: 20px;
  }

  .newTitle {
    font-size: 20px;
    color: #409EFF;
    font-weight: bolder;
  }

  .wordkuang {
    text-indent: 3em;
    color: #333;
    padding: 10px;
    text-align: left;
  }

  .wordkuang span {
    color: #409EFF;
    cursor: pointer;
  }

  .gs-all,
  .zzt-all {
    margin: 10px 10px 0 10px;
    background: #fff;
  }

  .zzt {

  }
</style>
