
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
    this.getdata()
  },
  data() {
    return {
      headerlist: [
        {
          label: '序号',
          prop: 'mid',
          format:(row, column, cellValue, index)=>{
            console.log(row,column,cellValue,index)
            return cellValue
          }
        },
        {
          label: '地址',
          prop: 'maddress',
        },
        {
          label: '验证码',
          prop: 'mcode',
        },
        {
          label: '时间',
          prop: 'mtime',
          format:(row, column, cellValue, index)=>{
            return cellValue.substring(0,10)
          }
        },
        
      ],
      pageNum: 1,
      pageSize: 10,
      pageTotal: 0,
      tableData: [],
      search: '',
      currentRow:[]
    }
  },
  methods: {
    getdata() {
      let queryparams = this.$route.params
      let param = null
      console.log(queryparams)
      var query = Object.keys(queryparams)
      if (query.length != 0) {
        param = {
          pageNum: queryparams.get('pageNum', this.pageNum),
          pageSize: queryparams.get('pageSize', this.pageSize),
        }
      } else
        param = {
          pageSize: this.pageSize,
          pageNum: this.pageNum,
        }
      const _this = this
      $axios.get('http://127.0.0.1:8088/admin/mail', param).then((data) => {
        let res = data.data
        _this.pageTotal = res.total
        _this.tableData = res.rows
        console.log(data)
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
      this.pageNum=val
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
