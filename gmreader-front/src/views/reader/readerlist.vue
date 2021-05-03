<template>
  <el-table
    strip="true"
    border
    :data="tableData.filter(data => !search || data.rname.toLowerCase().includes(search.toLowerCase()))"
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
    this.getdata()
  },
  data() {
    return {
      headerlist: [
        {
          label: '用户ID',
          prop: 'rid',
          format: (row, column, cellValue, index) => {
            return cellValue
          },
        },
        {
          label: '笔名',
          prop: 'rname',
        },
        {
          label: '注册邮箱',
          prop: 'rmail',
        },
        {
          label: '头像',
          prop: 'rhimg',
          format: (row, column, cellValue, index) => {
            return Vue.h('img', {
              src: 'http://127.0.0.1:8088/static/' + cellValue,
              style: {
                width: '50px',
                height: '50px',
              },
            })
          },
        },
        {
          label: '时间',
          prop: 'rtime',
          format: (row, column, cellValue, index) => {
            return (
              cellValue.substring(0, 10) + ' ' + cellValue.substring(11, 19)
            )
          },
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
      }
      const _this = this
      $axios.get('/admin/readerall', param).then((data) => {
        let res = data.data
        _this.pageTotal = res.total
        _this.tableData = res.rows
      })
    },
    handleEdit(index, row) {
      this.$router.replace({
        path: '/reader',
        query: {
          userid: row.rid,
        },
      })
    },
    handleDelete(index, row) {
      const self = this
      this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(() => {
          let param = {
            userId: row.rid,
          }
          $axios
            .post('/admin/deleteuser', param)
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
      console.log(this.currentRow)
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
