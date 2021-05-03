<template>
  <div class="reader">
    <div class="reader-header">
      <el-avatar shape="square" :size="100" fit="fill" :src="staticpath+userinfo.rhimg">
        <img :src="url" />
      </el-avatar>
      <div class="reader-name">{{userinfo.rname}}</div>
      <el-space wrap>
        <div class="data-box">
          <div class="data-num">{{branchnum}}</div>
          <div class="data-text">分支数量</div>
        </div>
        <el-divider direction="vertical"></el-divider>
        <div class="data-box">
          <div class="data-num">{{thumbnum}}</div>
          <div class="data-text">点赞数量</div>
        </div>
        <el-divider direction="vertical"></el-divider>
        <div class="data-box">
          <div class="data-num">{{discussnum}}</div>
          <div class="data-text">评论数量</div>
        </div>
        <el-divider direction="vertical"></el-divider>
        <div class="data-box">
          <div class="data-num">{{starnum}}</div>
          <div class="data-text">订阅数量</div>
        </div>
      </el-space>
    </div>
    <div class="reader-body">
      <div class="reader-left">
        <div class="reader-line">
          <div class="line-left">用户ID:</div>
          <div class="line-right">{{userinfo.rid}}</div>
        </div>
        <div class="reader-line">
          <div class="line-left">用户名:</div>
          <div class="line-right">{{userinfo.rname}}</div>
        </div>
        <div class="reader-line">
          <div class="line-left">用户密码:</div>
          <div class="line-right">{{userinfo.rpwd}}</div>
        </div>
        <div class="reader-line">
          <div class="line-left">用户邮箱:</div>
          <div class="line-right">{{userinfo.rmail}}</div>
        </div>
        <div class="reader-line">
          <div class="line-left">注册时间:</div>
          <div class="line-right">{{userinfo.rtime}}</div>
        </div>
        <div class="reader-line">
          <div class="line-left">用户头像</div>
          <div class="line-right">{{userinfo.rhimg}}</div>
        </div>
      </div>
      <div class="reader-right">
        <el-button @click="detail('/discuss')">查看评论</el-button>
        <el-button @click="detail('/branchlist')">查看分支</el-button>
        <el-button @click="detail('/star')">查看订阅</el-button>
        <el-button @click="detail('/thumb')">查看点赞</el-button>
        <el-button @click="resetheader">重置头像</el-button>
        <el-button @click="deleteuser">删除用户</el-button>
      </div>
    </div>
  </div>
</template>
<script>
import { ElMessage } from 'element-plus'
export default {
  created() {
    let query = this.$route.query
    if (query != null && query.hasOwnProperty('userid')) {
      this.userid = query.userid
      this.getdata()
    }
  },
  data() {
    return {
      staticpath: $axios.staticpath,
      userid: 0,
      url:
        'https://cube.elemecdn.com/3/7c/3ea6beec64369c2642b92c6726f1epng.png',
      userinfo: {
        rid: 'NULL',
        rname: '未选择',
        rpwd: 'NULL',
        rmail: 'NULL',
        rtime: 'NULL',
        rhimg: 'read.jpg',
      },
      branchnum: 0,
      starnum: 0,
      thumbnum: 0,
      discussnum: 0,
    }
  },
  computed: {
    ctimetext() {
      if (this.ctime)
        return this.ctime.substring(0, 10) + ' ' + this.ctime.substring(11, 19)
      else return ''
    },
  },
  methods: {
    getdata() {
      let param = {
        userId: this.userid,
      }
      const _this = this
      $axios
        .get('/admin/userdata', param)
        .then((data) => {
          console.log(data)
          _this.userinfo = data.data.infor
          _this.branchnum = data.data.branchnum
          _this.thumbnum = data.data.thumbnum
          _this.starnum = data.data.starnum
          _this.discussnum = data.data.discussnum
        })
        .catch((err) => {
          console.log(err)
        })
    },
    detail(route) {
      if (this.userinfo.rid == 'NULL') {
        ElMessage.warning({
          message: '当前没有选定读者',
          type: 'warning',
        })
        return
      }
      this.$router.push({
        path: route,
        query: {
          userid: this.userid,
        },
      })
    },
    deleteuser() {
      if (this.userinfo.rid == 'NULL') {
        ElMessage.warning({
          message: '当前没有选定读者',
          type: 'warning',
        })
        return
      }
      const self = this
      this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(() => {
          let param = {
            userId: self.userid,
          }
          console.log(param)
          $axios
            .post('/admin/deletereader', param)
            .then(() => {
              self.$message({
                type: 'success',
                message: '删除成功!',
              })
              self.$router.back()
            })
            .catch(() => {})
        })
        .catch(() => {
          this.$message({
            type: 'info',
            message: '已取消删除',
          })
        })
    },
    resetuser() {
      if (this.userinfo.rid == 'NULL') {
        ElMessage.warning({
          message: '当前没有选定读者',
          type: 'warning',
        })
        return
      }
      const self = this
      let param = {
        chpaterid: self.chapterid,
      }
      console.log(param)
      $axios
        .post('/admin/resetuserhead', param)
        .then(() => {
          self.$message({
            type: 'success',
            message: '重置成功!',
          })
          self.rhimg = 'read.jpg'
        })
        .catch(() => {
          self.$message({
            message: '重置失败，请稍后再试',
          })
        })
    },
  },
}
</script>
<style lang="less" scoped>
.reader {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
}
.reader-header {
  background-color: #ffffff;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
  width: 100%;
}
.data-box {
  width: 100px;
  height: 80px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
}
.data-num {
  color: #303133;
  font-size: 25px;
}

.data-text {
  color: #909399;
  font-size: 15px;
}
.reader-name {
  color: #000000;
  font-size: 25px;
}
.reader-body {
  margin-top: 10px;
  width: 100%;
  height: 420px;
  display: flex;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.12), 0 0 6px rgba(0, 0, 0, 0.04);
}
.reader-left {
  width: 80%;
  height: 400px;
  border-right: 1px solid rgb(223, 223, 223);
  margin: 5px;
}
.reader-right {
  width: 20%;
  height: 400px;
  margin: 5px;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
}
.reader-line {
  display: flex;
  justify-content: space-between;
  align-items: flex-end;
  margin: 5px;
  padding: 5px;
  width: 95%;
  height: 50px;
  border-bottom: 1px solid #dcdfe6;
}
</style>