export default {
  getOptions(bztData) {
    var servicedata = [];
    for (var i = 0; i < bztData.length; i++) {
      var obj = new Object();
      obj.name = bztData[i].name;
      obj.value = bztData[i].cou;
      servicedata[i] = obj;
    }
    let orgOptions = {
      title: {
        text: '员工业绩分析',
        subtext: '美酷',
        left: 'center'
      },
      tooltip: {
        trigger: 'item',
        formatter: '{a} <br/>{b} : {c}件 ({d}%)'
      },
      legend: {
        orient: 'horizontal',
        left: 'right',
        top: 100,
        data: bztData.name,
      },
      series: [
        {
          name: '本月員工業績情況',
          type: 'pie',
          radius: '55%',
          center: ['50%', '60%'],
          data: servicedata,
          emphasis: {
            itemStyle: {
              shadowBlur: 10,
              shadowOffsetX: 0,
              shadowColor: 'rgba(0, 0, 0, 0.5)'
            }
          }
        }
      ]
    };
    return orgOptions
  },




  getZzOptions(zztData) {
    var srdata = [];
    var yldata = [];
    for (var i = 0; i < zztData.length; i++) {
      var srObj = new Object();
      var ylObj = new Object();
      srObj = zztData[i].total;
      ylObj = zztData[i].yl;
      srdata.push(srObj)
      yldata.push(ylObj)
    }
      let option = {
        tooltip: {
        },
        legend: {
          orient: 'horizontal',
          x: 'right',
          y: 'top',
          data: [
            {
              name: '盈利'
            },
            {
              name: '收入'
            }
          ]
        },
        grid: {
          left: '36px',
          right: '0%',
          bottom: '20px',
          top: '37px'
        },
        dataset: {
            dimensions: ['product', '盈利', '收入'],
            source: [
              //当当前年份小于5则第一个时间将不准确
                {product: new Date().getFullYear() + "年" + (new Date().getMonth()-3) + "月", '盈利': yldata[4], '收入': srdata[4]},
                {product: new Date().getFullYear() + "年" + (new Date().getMonth()-2) + "月", '盈利': yldata[3], '收入': srdata[3]},
                {product: new Date().getFullYear() + "年" + (new Date().getMonth()-1) + "月", '盈利': yldata[2], '收入': srdata[2]},
                {product: new Date().getFullYear() + "年" + new Date().getMonth() + "月", '盈利': yldata[1], '收入': srdata[1]},
                {product: new Date().getFullYear() + "年" + (new Date().getMonth()+1) + "月", '盈利': yldata[0], '收入': srdata[0]}
            ]
        },
        xAxis: {type: 'category'},
        yAxis: {},
        series: [
            {type: 'bar',
            barWidth: '15%'},
            {type: 'bar',
            barWidth: '15%',},
        ]
      };
    return option
  }
}
