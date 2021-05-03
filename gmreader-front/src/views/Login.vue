<template>
  <el-form
    :model="ruleForm"
    :rules="rules"
    ref="ruleForm"
    label-position="left"
    label-width="0px"
    class="demo-ruleForm login-container"
  >
    <h3 class="title">系统登录</h3>
    <el-form-item prop="account">
      <el-input type="text" v-model="ruleForm.account" auto-complete="off" placeholder="账号"></el-input>
    </el-form-item>
    <el-form-item prop="checkPass">
      <el-input type="password" v-model="ruleForm.checkPass" auto-complete="off" placeholder="密码"></el-input>
    </el-form-item>
    <el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox>
    <el-form-item style="width:100%;">
      <el-button
        type="primary"
        style="width:100%;"
        @click="handleSubmit"
        :loading="logining"
      >登录</el-button>
  
    </el-form-item>
  </el-form>
</template>

<script>


export default {
  data() {
    return {
      logining: false,
      ruleForm: {
        account: 'admin',
        checkPass: 'admin',
      },
      rules: {
        account: [
          { required: true, message: '请输入账号', trigger: 'blur' },
          //{ validator: validaePass }
        ],
        checkPass: [
          { required: true, message: '请输入密码', trigger: 'blur' },
          //{ validator: validaePass }
        ],
      },
      checked: true,
    }
  },
  methods: {
    handleReset() {
      this.$refs.ruleForm.resetFields()
    },
    handleSubmit(ev) {
      var _this = this
      this.$refs.ruleForm.validate((valid) => {
        if (valid) {
          //_this.$router.replace('/table');
          this.logining = true
          //NProgress.start();
          var loginParams = {
            username: this.ruleForm.account,
            password: this.ruleForm.checkPass,
          }
          console.log(loginParams)
          $axios.login("/login",loginParams).then((res)=>{
            _this.logining=false
            if(res.errorCode==200)
            {
              $store.commit("setToken",res.data.token)
              $store.commit("setUser",res.data.infor)
              $store.commit("setVaild",true)
              _this.$router.push('/admin') 
              console.log($store.getters)
            }
            else
            {
              console.log('b')
            }
            //$store.commit("setToken",res.data)
            console.log(res)
          }).catch((err)=>
          {
            console.log(err)
            _this.logining=false
          })
          // requestLogin(loginParams).then((data) => {
          //   this.logining = false
          //   //NProgress.done();
          //   let { msg, code, user } = data
          //   if (code !== 200) {
          //     this.$message({
          //       message: msg,
          //       type: 'error',
          //     })
          //   } else {
          //     sessionStorage.setItem('user', JSON.stringify(user))
          //     this.$router.push({ path: '/table' })
          //   }
          // })
        } else {

          console.log('error submit!!')
          return false
        }
      })
    },
  },
}
</script>

<style lang="less" scoped>
.login-container {
  /*box-shadow: 0 0px 8px 0 rgba(0, 0, 0, 0.06), 0 1px 0px 0 rgba(0, 0, 0, 0.02);*/
  -webkit-border-radius: 5px;
  border-radius: 5px;
  -moz-border-radius: 5px;
  background-clip: padding-box;
  margin: 180px auto;
  width: 350px;
  padding: 35px 35px 15px 35px;
  background: #fff;
  border: 1px solid #eaeaea;
  box-shadow: 0 0 25px #cac6c6;
  .title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  .remember {
    margin: 0px 0px 35px 0px;
  }
}
</style>