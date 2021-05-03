import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Main from '../views/Main.vue'
import notFound from '../views/404.vue'
import index from '../views/pages/index.vue'
import table from '../views/pages/table.vue'

import discuss from '../views/behavior/discuss.vue'
import star from '../views/behavior/star.vue'
import thumb from '../views/behavior/thumb.vue'

import branchlist from '../views/book/branchlist.vue'
import chapterlist from '../views/book/chapterlist.vue'
import charpter from '../views/book/charpter.vue'

import readerlist from '../views/reader/readerlist.vue'
import reader from '../views/reader/reader.vue'





const routes = [
  {
    path: '/',
    name: '登录',
    component: Login,

    show: false,
  },
  {
    path: '/admin',
    name: '管理后台',
    component: Home,
    show: false,
    icon: "el-icon-user",
    children:
      [
        {
          path: '/main',
          name: '首页',
          component: Main,
          show: true,
          icon: "el-icon-s-home",
          children: [
            {
              path: '/countdata',
              name: '数据概览',
              component: index,
              show: true
            }]
        },
        {
          path: '/reader',
          name: '读者管理',
          component: Main,
          show: true,
          icon: "el-icon-user",
          children: [
            {
              path: '/readerlist',
              name: '读者列表',
              component: readerlist,
              show: true
            },
            {
              path: '/reader',
              name: '读者状态',
              component: reader,
              show: true
            }
          ],
        },
        {
          path: '/branch',
          name: '书籍管理',
          component: Main,
          show: true,
          icon: "el-icon-notebook-2",
          children:
            [
              {
                path: '/branchlist',
                name: '分支管理',
                component: branchlist,
                show: true
              },
              {
                path: '/chapterlist',
                name: '章节管理',
                component: chapterlist,
                show: true
              },
              {
                path: '/chapter',
                name: '章节内容',
                component: charpter,
                show: true
              }
            ],
        },
        {
          path: '/behavior',
          name: '行为管理',
          component: Main,
          show: true,
          icon: "el-icon-s-comment",
          children:
            [
              {
                path: '/discuss',
                name: '评论管理',
                component: discuss,
                show: true
              },
              {
                path: '/thumb',
                name: '点赞管理',
                component: thumb,
                show: true
              },
              {
                path: '/star',
                name: '订阅管理',
                component: star,
                show: true
              },
            ],
        }

      ]
  },
  {
    path: "/404",
    name: "notFound",
    component: notFound
  },
  {
    path: "/:pathMatch(.*)*", // 此处需特别注意置于最底部
    redirect: "/404"
  }

]




const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})



export default router
