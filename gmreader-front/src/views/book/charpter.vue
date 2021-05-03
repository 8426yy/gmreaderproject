<template>
  <div class="chapter">
    <h1>{{chaptertitle}}</h1>
    <div class="delete" @click="deletechapter">
      <el-button type="danger" icon="el-icon-delete" circle></el-button>
    </div>

    <el-divider></el-divider>
    <div class="page-body">
      <text>{{cbody}}</text>
    </div>
    <el-divider></el-divider>
    <h3>{{ctimetext}}</h3>
  </div>
</template>
<script>
import discuss from '../behavior/discuss.vue'

import { ElMessage } from 'element-plus'

export default {
  components: { discuss },
  created() {
    let query = this.$route.query
    if (query != null && query.hasOwnProperty('chapterid')) {
      this.chapterid = query.chapterid
      this.getdata()
    } else {
      this.cbody = '没有选择章节'
      this.chaptertitle = '没有该章节的信息'
    }
  },
  data() {
    return {
      chapterid: 0,
      chaptertitle: '加载中',
      cbody: '请等待。。。',
      currentRow: [],
      ctime: null,
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
        chapterid: this.chapterid,
      }
      const _this = this
      $axios
        .get('/api/getchapterbody', param)
        .then((data) => {
          console.log(data)
          _this.cbody = data.data.cbody
          _this.chaptertitle = data.data.ctitle
          _this.ctime = data.data.ctime
        })
        .catch((err) => {
          console.log(err)
        })
    },
    deletechapter() {
      if (this.chapterid == 0) {
        console.log('no to delete')
        ElMessage.warning({
          message: '当前没有选中章节',
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
            chpaterid: self.chapterid,
          }
          console.log(param)
          $axios
            .post('/admin/deletechapter', param)
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
  },
}
</script>
<style scoped>
.chapter {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: flex-start;
  align-items: center;
}
.delete {
  position: fixed;
  right: 50px;
  bottom: 100px;
}
</style>