
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
          label: '读者号',
          prop: 'rid',
        },
        {
          label: '读者名',
          prop: 'rname',
        },
        {
          label: '分支号',
          prop: 'bid',
        },
        {
          label: '分支号',
          prop: 'bname',
        },
        {
          label: '订阅时间',
          prop: 'sttime',
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
      $axios.get('/admin/starall', param).then((data) => {
        let res = data.data
        _this.pageTotal = res.total
        _this.tableData = res.rows
      })
    },
    handleEdit(index, row) {
      console.log(index, row)
    },
    handleDelete(index, row) {
      console.log(index, row)
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
