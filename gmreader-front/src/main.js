import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'


import ElementPlus from 'element-plus'
import * as echarts from 'echarts'
import axios from './utils/axios.js'

import 'element-plus/lib/theme-chalk/index.css';
import './assets/css/color.less'

import 'dayjs/locale/zh-cn'
import locale from 'element-plus/lib/locale/lang/zh-cn'

import { ElMessage } from 'element-plus';



const hookglobal = global.__proto__ || global

hookglobal.echarts = echarts
hookglobal.$axios = axios
hookglobal.$store = store


Date.prototype.format = function (format) {
  var o = {
    "M+": this.getMonth() + 1, //month
    "d+": this.getDate(), //day
    "h+": this.getHours(), //hour
    "m+": this.getMinutes(), //minute
    "s+": this.getSeconds(), //second
    "q+": Math.floor((this.getMonth() + 3) / 3), //quarter
    "S": this.getMilliseconds() //millisecond
  }
  if (/(y+)/.test(format)) {
    format = format.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
  }
  for (var k in o) {
    if (new RegExp("(" + k + ")").test(format)) {
      format = format.replace(RegExp.$1, RegExp.$1.length == 1 ? o[k] : ("00" + o[k]).substr(("" + o[k]).length));
    }
  }
  return format;
}

const rawParse = JSON.parse
JSON.parse = function (str, defaults) {
  try {
    return rawParse(str)
  } catch (err) {
    console.error(`JSON解析失败：${str}, ${err.stack}`)
    return defaults
  }
}


// const whiteList = ['/'];
// router.beforeEach(async (to, from, next) => {
//   console.log(to.path)
//   // 要去的页面是白名单，直接跳转
//   if (to.path == '/') {
//     next()
//   }
//   else {
//     let vaild = store.getters.getUservaild
//     console.log(vaild)
//     if (vaild) { // 用户校验通过，直接跳转
//       next();
//     } else { // 用户校验失败
//       ElMessage.error('请登录后进行操作');
//       next('/')
//       // 顺带说一下，这里还可以在router中的meta属性中添加isNeeded: true/false
//       // 然后配合这个属性更加精细的控制未通过用户校验时的页面是否允许跳转
//     }

//   }
//   // 不是白名单，调用vuex中的validate行为

// });


const app = createApp(App)
app.use(ElementPlus, { locale })
app.use(store).use(router).mount('#app')
