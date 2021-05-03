/**axios封装
 * 请求拦截、
 */
import router from '../router/index';
import store from '../store/index.js';
import axios from 'axios'
import { ElMessage } from 'element-plus'
import qs from 'qs'

var server_url = "http://127.0.0.1:8088"
//配置默认地址
axios.defaults.baseURL = server_url;

/** 
 * 跳转登录页
 * 携带当前页面路由，以期在登录页面完成登录后返回当前页面
 */
const toLogin = () => {
    router.replace({
        path: '/',
        query: {
            redirect: router.currentRoute.fullPath
        }
    });
}
//post请求的请求头

axios.defaults.headers.post['Content-Type'] = 'application/json';

//axios拦截器，目的是为了在请求头上带上token
// axios.interceptors.request.use(
//     config => {
//     if (localStorage.getItem('Authorization')) {
//       //token字段是要和后端协商好的
//         config.headers.common["token"] = localStorage.getItem('Authorization');
//         // debugger
//     }
//     return config;
//     },
//     error => {
//     return Promise.reject(error);
//     });
/**  get方法，对应get请求 
 * @param {String} url [请求的url地址] 
 * @param {Object} params [请求时携带的参数] 
 */


/** 
 * post方法，对应post请求 
 * @param {String} url [请求的url地址] 
 * @param {Object} params [请求时携带的参数] 
 */


export default
    {
        staticpath: server_url + "/static/",
        get(url, params) {
            let vaild = store.getters.getUservaild
            return new Promise((resolve, reject) => {
                console.log(url)
                axios.get(url, {
                    params: params
                })
                    .then(res => {
                        resolve(res.data);
                    })
                    .catch(err => {
                        reject(err.data)
                    })
            })
        },
        post(url, params) {
            let vaild = store.getters.getUservaild
            if (vaild) {
                let token = store.getters.getToken
                axios.defaults.headers.common["token"] = token
            }
            else {
                ElMessage.error('请登录后进行操作')
                toLogin()
                return
            }
            return new Promise((resolve, reject) => {
                console.log(url)
                console.log(qs.stringify(params))
                axios.post(url, qs.stringify(params),
                    {
                        headers: {
                            'Content-Type': 'application/x-www-form-urlencoded'
                        }
                    }
                )
                    .then(res => {
                        console.log(res)
                        if (res.data.errorCode == 200)
                            resolve(res.data)
                        else
                            reject(res.data.errorMsg)
                    })
                    .catch(err => {
                        reject(err.data)
                    })
            });
        },
        login(url, params) {
            return new Promise((resolve, reject) => {
                axios.post(url, JSON.stringify(params))
                    .then(res => {
                        resolve(res.data);
                    })
                    .catch(err => {
                        console.log(err)
                        reject(err.data)
                    })
            });
        }
    }
