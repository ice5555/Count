<template>
    <div id="chart3"></div>
  </template>
  
<script>
      export default {
          name: "echart3",
      mounted() {
        let url = "/static/api/home/compare"
        this.$axios
          .get(url)
          .then(res => {
            // 基于准备好的dom，初始化echarts实例
            let myChart = echarts.init(document.getElementById("chart3"))
            myChart.clear()
  
            let totalLabel = "总数"
            let users = []
            let result = {
              [totalLabel]: {}
            }
            let labels = [totalLabel]
  
            for (let i in res.data) {
              let item = res.data[i]
              if (!result.hasOwnProperty(item.name)) {
                result[item.name] = {}
                result[item.name][item.author] = item.value
                labels.push(item.name)
              } else {
                result[item.name][item.author] = item.value
              }
              if (users.indexOf(item.author) < 0) {
                users.push(item.author)
              }
              if (result[totalLabel].hasOwnProperty(item.author))
                result[totalLabel][item.author] += item.value
              else
                result[totalLabel][item.author] = item.value
            }
  
            this.substrate = ((result[totalLabel][users[0]] - result[totalLabel][users[1]]) / 2).toFixed(2)
  
            myChart.setOption({
              title: {
                text: "消费对比图（单位:元）",
              },
              tooltip: {
                trigger: "axis",
                axisPointer: {
                  type: "shadow"
                }
              },
              legend: {
                data: users
              },
              xAxis: [
                {
                  type: "category",
                  axisTick: {show: false},
                  data: labels
                }
              ],
              yAxis: [
                {
                  type: "value"
                }
              ],
              series: users.map(user => {
                return {
                  name: user,
                  type: "bar",
                  barGap: 0,
                  label: {
                    show: true,
                    position: "inside"
                  },
                  emphasis: {
                    focus: "series"
                  },
                  data: labels.map(type => {
                    return Number((result[type][user] || 0).toFixed(2))
                  })
                }
              })
            })
          })
          .catch(error => {
          })
      }
    }
  </script>
  
  <style scoped>
    #chart3 {
      width: 100%;
      height: calc(50vh - 150px);
    }
  </style>
  