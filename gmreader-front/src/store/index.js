import { CommonPicker } from 'element-plus/lib/el-time-picker';
import { createStore } from 'vuex'

export default createStore({
 
    state: {
      token:localStorage.getItem("token") , //初始化token,
      user:localStorage.getItem("user"),
      uservaild:localStorage.getItem("uservaild")
    },
    mutations: {
      //存储token方法
      //设置token等于外部传递进来的值
      setToken(state, token) {
          state.token = token
          localStorage.token = token //同步存储token至localStorage
      },
      setUser(state, user){
          state.user = user
          localStorage.user=user
      
      },
      setVaild(state,vaild)
      {
        state.uservaild=vaild
        localStorage.uservaild=vaild
      },
      clear(state)
      {
        state.token=null
        state.user=null
        state.uservaild=false
        localStorage.clear()
      }
    },
   getters : {
    //获取token方法
    //判断是否有token,如果没有重新赋值，返回给state的token
    getUservaild(state)
    {
      return state.uservaild
    },
    getUser(state)
    {
      return state.user
    },
    getToken(state) {
      if (!state.token) {
        state.token = localStorage.getItem('token')
      }
      return state.token
      }
    },
    actions: {
      async login({commit}, username){
        const res = await userLogin(username);
        if (res.code === 1) { // 登录失败
          return Promise.reject(res);
        }
        // 登录成功后将接口返回的token保存在本地
        localStorage.setItem('token', res.token);
        // 将用户名保存在vuex中
        commit('setUsername', username);
      },
      async validate({commit}) {
        // 调用userValidate时，会将
        const res = await userValidate();
        if (res.code === 1) { // 此时用户校验失败
          return Promise.reject(res);
        }
        // 如果校验成功，重新保存token和username 
        localStorage.setItem('token', res.token);
        commit('setUsername', res.username);
      },
      logout()
      {
        this.commit('clear')      
      }
    }
})
