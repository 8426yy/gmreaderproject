
<template>
  <el-table
    strip="true"
    border
    :data="tableData.filter(data => !search || data.authorname.includes(search.toLowerCase())|| data.bname.includes(search.toLowerCase()))"
    style="width: 100%"
    height="75%"
    @current-change="rowSelectChange"
  >
    <el-table-column
      v-for="(item,index) in headerlist"
      :key="index"
      :label="item.label"
      :prop="item.prop"
      :formatter="item.format"
    ></el-table-column>
    <el-table-column align="right">
      <template #header>
        <el-input v-model="search" size="mini" placeholder="输入关键字搜索" />
      </template>
      <template #default="scope">
        <el-button size="mini" @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
        <el-button size="mini" type="danger" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
      </template>
    </el-table-column>
  </el-table>
  <el-divider />
  <el-row class="page">
    <div class="block">
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="pageNum"
        :page-size="pageSize"
        layout="total, prev, pager, next, jumper"
        :total="pageTotal"
      ></el-pagination>
    </div>
  </el-row>
</template>

<script>
import * as Vue from 'vue'
export default {
  created() {
    let query = this.$route.query
    if (query != null && query.hasOwnProperty('userid')) {
      this.userid = query.userid
    }
    console.log(this.userid)
    this.getdata()
  },
  data() {
    return {
      userid: 0,
      headerlist: [
        {
          label: '序号',
          prop: 'bid',
        },
        {
          label: '书名',
          prop: 'bname',
        },
        {
          label: '作者序号',
          prop: 'authorid',
        },
        {
          label: '作者名',
          prop: 'authorname',
        },
        {
          label: '时间',
          prop: 'btime',
          format: (row, column, cellValue, index) => {
            return (
              cellValue.substring(0, 10) + ' ' + cellValue.substring(11, 19)
            )
          },
        },
        {
          label: '简介',
          prop: 'bintro',
          format: (row, column, cellValue, index) => {
            return cellValue.substring(0, 10)
          },
        },
        {
          label: '封面',
          prop: 'bhimg',
          format: (row, column, cellValue, index) => {
            return Vue.h('img', {
              src: 'http://127.0.0.1:8088/static/' + cellValue,
              style: {
                width: '50px',
                height: '75px',
              },
            })
          },
        },
        {
          label: '前置章节',
          prop: 'bpre',
          format: (row, column, cellValue, index) => {
            if (cellValue) return cellValue
            else return '无'
          },
        },
        {
          label: '章节数',
          prop: 'num',
        },
        {
          label: '点赞',
          prop: 'up',
        },
        {
          label: '点踩',
          prop: 'down',
        },
      ],
      pageNum: 1,
      pageSize: 10,
      pageTotal: 0,
      tableData: [],
      search: '',
      currentRow: [],
    }
  },
  methods: {
    getdata() {
      let param = {
        pageSize: this.pageSize,
        pageNum: this.pageNum,
        userid: this.userid,
      }
      const _this = this
      $axios
        .get('http://127.0.0.1:8088/admin/branchall', param)
        .then((data) => {
          let res = data.data
          _this.pageTotal = res.total
          _this.tableData = res.rows
        })
    },
    handleEdit(index, row) {
      this.$router.push({
        path: '/chapterlist',
        query: {
          branchid: row.bid,
        },
      })
    },
    handleDelete(index, row) {
      const self = this
      this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(() => {
          let param = {
            branchid: row.bid,
          }
          console.log(param)
          $axios
            .post('/admin/deletebranch', param)
            .then(() => {
              self.$message({
                type: 'success',
                message: '删除成功!',
              })
              self.tableData.splice(index, 1)
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
    rowSelectChange(val) {
      this.currentRow = val
    },
    handleCurrentChange(val) {
      this.pageNum = val
      this.getdata()
      console.log(`当前页: ${val}`)
    },
  },
}
</script>

<style>
.page {
  display: flex;
  justify-content: center;
}
</style>
