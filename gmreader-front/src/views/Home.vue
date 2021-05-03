<template>
  <el-header>
    <el-radio-group v-model="collapse" size="mini" fill="#071e30">
      <el-radio-button :label="true">{{'<'}}</el-radio-button>
      <el-radio-button :label="false">{{'>'}}</el-radio-button>
    </el-radio-group>
    <div class="title">
      <div class="title-left">GM</div>
      <div class="title-right">阅读后台管理系统</div>
    </div>
    <el-dropdown>
      <span class="el-dropdown-link text-self">
        管理员
        <i class="el-icon-arrow-down el-icon--right"></i>
      </span>
      <template #dropdown>
        <el-dropdown-menu>
          <el-dropdown-item @click="loginout">退出</el-dropdown-item>
        </el-dropdown-menu>
      </template>
    </el-dropdown>
  </el-header>
  <el-container>
    <el-menu class="el-menu-vertical-demo" router :collapse="collapse" :unique-opened="true">
      <el-submenu
        v-for="(item,index) in $router.options.routes[1].children"
        :index="index+''"
        :key="index"
      >
        <template #title>
          <i :class="item.icon"></i>
          <span v-show="!collapse">{{item.name}}</span>
        </template>
        <el-menu-item
          v-for="(item1,index1) in item.children"
          v-show="item1.show"
          :index="item1.path"
          :class="$route.path==item1.path?'is-active':''"
          :key="index1"
        >{{item1.name}}</el-menu-item>
      </el-submenu>
    </el-menu>

    <el-main>
      <el-breadcrumb separator="/">
        <el-breadcrumb-item v-for="item in levelList" :key="item" :to="item.path">{{item}}</el-breadcrumb-item>
      </el-breadcrumb>
      <el-divider></el-divider>
      <router-view />
    </el-main>
  </el-container>
  <el-footer>
    <div>asdawd</div>
  </el-footer>
</template>

<style>
.el-header {
  display: flex;
  height: 10%;
  justify-content: space-between;
  align-items: center;
}
.el-container {
  height: 85%;
  border: 1px solid #eee;
}

.el-aside {
  color: #333;
  background-color: rgb(238, 241, 246);
}
.el-footer {
  height: 5%;
  background-color: #b3c0d1;
  display: flex;
  justify-content: center;
}
.el-menu-vertical-demo:not(.el-menu--collapse) {
  width: 200px;
}
.title {
  display: flex;
  justify-content: center;
  align-items: center;
}
.title-left {
  background-color: white;
  color: #071e30;
  font-size: 30px;
  border-radius: 5%;
}
.title-right {
  color: white;
  font-size: 30px;
}
</style>

<script>
export default {
  created() {
    const _this = this
    this.getBreadcrumb()
    window.onresize = () => {
      return (() => {
        window.screenWidth = document.body.clientWidth
        _this.screenWidth = window.screenWidth
      })()
    }
  },
  data() {
    return {
      asidewidth: 200,
      screenWidth: 0,
      timer: false,
      collapse: false,
      levelList: [],
    }
  },
  watch: {
    $route() {
      this.getBreadcrumb()
    },
    screenWidth(val) {
      if (!this.timer) {
        if (this.screenWidth < 800) {
          this.collapse = true
        } else {
          this.collapse = false
        }
        this.screenWidth = val
        this.timer = true
        const _this = this
        setTimeout(function () {
          _this.timer = false
        }, 400)
      }
    },
  },
  methods: {
    getBreadcrumb() {
      let matched = this.$route.matched
      console.log(matched)
      this.levelList = matched.map((item) => item.name)
    },
    loginout() {
      $store.commit('clear')
      this.$router.replace('/')
    },
  },
}
</script>