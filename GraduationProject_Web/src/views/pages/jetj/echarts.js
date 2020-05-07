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
                {product: '2020年1月', '盈利': yldata[4], '收入': srdata[4]},
                {product: '2020年2月', '盈利': yldata[3], '收入': srdata[3]},
                {product: '2020年3月', '盈利': yldata[2], '收入': srdata[2]},
                {product: '2020年4月', '盈利': yldata[1], '收入': srdata[1]},
                {product: '2020年5月', '盈利': yldata[0], '收入': srdata[0]}
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
    // let zzOptions = {
    //   title: {
    //     text: '当年前五个月盈利收入分析',
    //     top:10,
    //     left:10
    // },
    // tooltip : {
    //     trigger: 'item',
    //     formatter: "{a} <br/>{b} : {c}"+
    // },
    // toolbox: {
    //     show : true,
    //     top:10,
    //     right:10,
    //     feature : {
    //         mark : {show: true},
    //         magicType : {show: true, type: ['line', 'bar']},
    //         restore : {show: true},
    //         saveAsImage : {show: true}
    //     }
    // },
    // grid:{
    //     top:60,
    //     right:70,
    //     bottom:30,
    //     left:60
    // },
    // legend: {
    //     top:32,
    //     left:'center',
    //     data:['收入','盈利']
    // },
    // calculable : true,
    // xAxis : [
    //     {
    //         type : 'category',
    //         data : [1,1,1]
    //     }
    // ],
    // yAxis : [
    //     {
    //         type: 'value',
    //         nameLocation:"center",
    //         nameGap:35,
    //         nameRotate:0,
    //         nameTextStyle:{
    //             fontSize: 16,
    //         },
    //         //默认以千分位显示，不想用的可以在这加一段
    //         axisLabel : {   //调整左侧Y轴刻度， 直接按对应数据显示
    //             show:true,
    //             showMinLabel:true,
    //             showMaxLabel:true,
    //             formatter: function (value) {
    //                 return value;
    //             }
    //         }
    //     },
    // ],
    // series : [
    //     {
    //         name:'收入',
    //         type:'bar',
    //         yAxisIndex: 0,
    //         data:srdata,
    //         // itemStyle : { normal: {label : {show: true}}},
    //         // markPoint : {
    //         //     data : [
    //         //         {type : 'max', name: '最大值'},
    //         //         {type : 'min', name: '最小值'}
    //         //     ]
    //         // }
    //     },
    //     {
    //         name:'盈利',
    //         type:'bar',
    //         yAxisIndex: 1,
    //         data:yldata,
    //         // itemStyle : { normal: {label : {show: true}}},
    //         // markPoint : {
    //         //     data : [
    //         //         {type : 'max', name: '最大值'},
    //         //         {type : 'min', name: '最小值'}
    //         //     ]
    //         // }
    //     }
    // ]
    // };
    return option
  }
}
