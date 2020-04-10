export default {
  getOptions(bztData) {
    var servicedata = [];
    for (var i = 0; i < bztData.length; i++) {
      debugger
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
        formatter: '{a} <br/>{b} : {c} ({d}%)'
      },
      legend: {
        orient: 'vertical',
        left: 'left',
        data: bztData.name
      },
      series: [
        {
          name: '这是什么',
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
  getZzOptions() {
    let zzOptions = {
      legend: {},
      tooltip: {},
      dataset: {
        dimensions: ['product', '2015', '2016', '2017'],
        source: [
          {product: 'Matcha Latte', '2015': 43.3, '2016': 85.8, '2017': 93.7},
          {product: 'Milk Tea', '2015': 83.1, '2016': 73.4, '2017': 55.1},
          {product: 'Cheese Cocoa', '2015': 86.4, '2016': 65.2, '2017': 82.5},
          {product: 'Walnut Brownie', '2015': 72.4, '2016': 53.9, '2017': 39.1}
        ]
      },
      xAxis: {type: 'category'},
      yAxis: {},
      // Declare several bar series, each will be mapped
      // to a column of dataset.source by default.
      series:[]
        // [
        //   // {type: 'bar'},
        //   // {type: 'bar'},
        //   // {type: 'bar'}
        //   {
        //     name: '销量',
        //     type: 'bar',
        //     // data:data.data
        //   }]

    };
    return zzOptions
  }
}
