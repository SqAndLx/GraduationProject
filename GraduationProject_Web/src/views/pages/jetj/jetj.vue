<template>
  <div class="all">
    <div class="content">
      <!-- 概述 -->
      <div class="gs-all">
        <div class="gs">
          <img src="../../../assets/gs.png" style="color: #2F80EC" />
          <span class="newTitle">概述</span>
        </div>
        <div class="wordkuang">
          从{{this.tjq2}}到{{this.tjq1}}，美酷理发店共收入
          <span
            style="cursor:text;color:#333;"
          >{{this.gsData.total}}</span>元，
          其中，盈利
          <span style="cursor:text;color:#333;">{{this.gsData.yl}}</span>元。
        </div>
      </div>
      <!-- 柱状图-->
      <div class="zzt-all">
        <div class="zzt">
          <img src="../../../assets/gs.png" />
          <span class="newTitle">近五月盈利、收入分析</span>
        </div>
        <p class="chartTitle" style="background-color:#f5f5f5">
          <span style="float:right;margin-right:10px;">单位：元</span>
        </p>
        <!-- <div class="echartsZz"> -->
        <chart :options="zzOptions" id="zztEchars"></chart>
        <!-- </div> -->
      </div>
      <!-- 饼状图-->
      <div class="bzt-all">
        <div class="bzt">
          <img src="../../../assets/gs.png" />
          <span class="newTitle">员工业绩分析</span>
        </div>
        <p class="chartTitle" style="background-color:#f5f5f5">
          <span style="float:right;margin-right:10px;">单位：件</span>
        </p>
        <div class="echartsBz">
          <chart :options="orgOptions" id="bztEchars"></chart>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import echarts from "./echarts.js";
import axios from "axios";

export default {
  data() {
    return {
      orgOptions: {},
      tjq1: "",
      tjq2: "",
      zzOptions: {},
      bztData: [],
      zztData: [],
      gsData: {}
    };
  },
  methods: {
    getNowDate() {
      this.tjq1 = new Date().getFullYear();
      this.tjq2 = new Date().getFullYear() - 1;
    },
    getBzt() {
      axios
        .post("/axios/api/bzt")
        .then(response => {
          if (response.data.code == "200") {
            this.bztData = response.data.data;
            this.orgOptions = echarts.getOptions(this.bztData);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    getZzt() {
      axios
        .post("/axios/api/getYYlZj")
        .then(response => {
          if (response.data.code == "200") {
            this.zztData = response.data.data;
            this.zzOptions = echarts.getZzOptions(this.zztData);
          }
        })
        .catch(error => {
          console.log(error);
        });
    },
    getGs() {
      axios
        .post("/axios/api/getYlZj")
        .then(response => {
          if (response.data.code == "200") {
            this.gsData = response.data.data[0];
            this.getNowDate(); //获取概述时间
            console.log(this.gsData);
          }
        })
        .catch(error => {
          console.log(error);
        });
    }
  },
  created() {},
  mounted() {
    this.getBzt(); //获取饼状图数据
    this.getZzt(); //获取饼状图数据
    this.getGs(); //获取概述数据
  }
};
</script>

<style scoped>
.all {
  height: 100%;
  width: 100%;
}

.gs,
.zzt,
.bzt {
  border-bottom: 3px solid #409eff;
  background: #f1f1f1;
  padding: 15px;
  text-align: left;
}
.zzt {
  overflow: auto;
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

.bzt img {
  height: 20px;
  padding-right: 5px;
  width: 20px;
}

.newTitle {
  font-size: 20px;
  color: #409eff;
  font-weight: bolder;
}

.wordkuang {
  text-indent: 3em;
  color: #333;
  padding: 10px;
  text-align: left;
}

.wordkuang span {
  color: #409eff;
  cursor: pointer;
}

.gs-all {
  margin: 10px 10px 0 10px;
  background: #fff;
  height: 15%;
  /* background-color: red; */
}
.zzt-all {
  margin: 10px 10px 0 10px;
  background: #fff;
  height: 40%;
  /* background-color: green; */
}
.bzt-all {
  margin: 10px 10px 0 10px;
  background: #fff;
  height: 40%;
  /* background-color: yellow; */
}

.content {
  height: 98%;
  width: 99%;
  border: 1px solid #a9c4df;
  margin-left: 0.5%;
  margin-top: 0.5%;
}
#bztEchars {
  position: relative;
  top: -105px;
}
#zztEchars {
  position: relative;
  height: 80%;
  width: 60%;
  top: 0;
}
</style>
