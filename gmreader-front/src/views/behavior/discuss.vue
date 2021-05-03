
<template>
  <el-table
    strip="true"
    border
    :data="tableData.filter(data => !search || data.maddress.toLowerCase().includes(search.toLowerCase()))"
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
export default {
  created() {
    let query = this.$route.query
    if (query != null && query.hasOwnProperty('userid')) {
      this.userid = query.userid
    }
    this.getdata()
  },
  data() {
    return {
      userid: 0,
      headerlist: [
        {
          label: '用户id',
          prop: 'rid',
        },
        {
          label: '用户名',
          prop: 'rname',
        },
        {
          label: '分支',
          prop: 'bid',
        },
        {
          label: '分支名',
          prop: 'bname',
        },
        {
          label: '评论',
          prop: 'comment',
        },
        {
          label: '时间',
          prop: 'time',
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
        userid: this.userid,
      }
      const _this = this
      $axios
        .get('http://127.0.0.1:8088/admin/discussall', param)
        .then((data) => {
          let res = data.data
          _this.pageTotal = res.total
          _this.tableData = res.rows
        })
    },
    handleEdit(index, row) {
      console.log(index, row)
    },
    handleDelete(index, row) {
      const self = this
      this.$confirm('此操作将永久删除该, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      })
        .then(() => {
          let param = {
            discussid: row.did,
          }
          console.log(param)
          $axios
            .post('/admin/deletediscuss', param)
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
