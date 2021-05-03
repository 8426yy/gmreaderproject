<template>
  <el-col :span="14">
    <el-space wrap>
      <el-card
        class="box-card"
        v-for="(item,index) in datalist"
        :key="index"
        :body-style="{width: '250px', height :'100px','background-color':item.color,color:'white'}"
        shadow="hover"
      >
        <div class="card-body">
          <div class="card-left">
            <div class="card-lefttop">{{item.title}}</div>
            <el-divider></el-divider>
            <div class="card-leftbottom">{{item.num}}</div>
          </div>
          <div class="card-right">
            <i :class="item.icon"></i>
          </div>
        </div>
      </el-card>
    </el-space>
    <el-row>
      <section class="chart-container">
        <el-row>
          <el-col :span="24">
            <div id="rectLine" style="width:100%; height:300px;"></div>
          </el-col>
        </el-row>
      </section>
    </el-row>
  </el-col>
  <el-col :span="10">
    <el-timeline>
      <el-timeline-item
        v-for="item in loginlist"
        :key="item.lid"
        :timestamp="item.time"
        placement="top"
      >
        <el-card>
          <p>用户 {{item.rname}} 在 IP:{{item.rip}} 进行了登录操作,用户角色为 {{item.role}}</p>
        </el-card>
      </el-timeline-item>
    </el-timeline>
  </el-col>
</template>
<script >
export default {
  data() {
    return {
      rectLine: null,
      datalist: [
        {
          title: '读者',
          color: '#67C23A',
          icon: 'el-icon-user-solid',
          num: 0,
        },
        {
          title: '分支',
          color: '#E6A23C',
          icon: 'el-icon-notebook-1',
          num: 0,
        },
        {
          title: '章节',
          color: '#F56C6C',
          icon: 'el-icon-s-order',
          num: 0,
        },
        {
          title: '讨论',
          color: '#409EFF',
          icon: 'el-icon-s-comment',
          num: 0,
        },
        {
          title: '订阅',
          color: '#071e30',
          icon: 'el-icon-star-on',
          num: 0,
        },
        {
          title: '评价',
          color: '#495060',
          icon: 'el-icon-thumb',
          num: 0,
        },
      ],
      loginlist: [],
    }
  },
  methods: {
    drawLineChart() {
      this.rectLine = echarts.init(document.getElementById('rectLine'))
      this.rectLine.setOption({
        title: {
          text: '数据概览',
        },
        // tooltip: {
        //   trigger: 'axis',
        // },
        // legend: {
        //   data: ['登录人数'],
        // },
        grid: {
          left: '3%',
          right: '4%',
          bottom: '3%',
          containLabel: true,
        },
        xAxis: {
          type: 'category',
          data: this.datalist.map((item) => {
            return item.title
          }),
        },
        yAxis: {},
        series: [
          {
            type: 'bar',
            data: this.datalist.map((item) => {
              return {
                value: item.num,
                itemStyle: {
                  color: item.color,
                },
              }
            }),
          },
        ],
      })
    },

    drawCharts() {
      this.drawLineChart()
    },
  },

  mounted: function () {
    const self = this
    $axios
      .post('/admin/data')
      .then((res) => {
        self.datalist[0].num = res.data.readernum
        self.datalist[1].num = res.data.branchnum
        self.datalist[2].num = res.data.chapternum
        self.datalist[3].num = res.data.discussnum
        self.datalist[4].num = res.data.starnum
        self.datalist[5].num = res.data.thumbnum
        self.loginlist = res.data.loginlog
        self.drawCharts()
      })
      .catch((err) => {
        console.log(err)
      })
  },
  updated: function () {
    this.drawCharts()
  },
}
</script>
<style lang="less">
.card-body {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;
}
.card-left {
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
}
.card-right {
  display: flex;
  justify-content: center;
  align-items: center;
  font-size: 100px;
}
.card-lefttop {
  font-size: 20px;
}
.card-leftbottom {
  font-size: 30px;
}
.chart-container {
  width: 100%;
  float: left;
}
/*.chart div {
        height: 400px;
        float: left;
    }*/

.el-col {
  padding: 30px 20px;
}
</style>
