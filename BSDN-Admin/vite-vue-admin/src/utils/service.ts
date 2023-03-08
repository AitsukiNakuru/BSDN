import axios, {AxiosInstance, AxiosRequestConfig} from "axios";
import {ElMessage} from "element-plus";
import { get } from "lodash-es"
import {useUserStoreHook} from "@/store/modules/user";
import {getToken} from "@/utils/cache/cookie";

/**
 * 创建一个Axios实例，返回一个service，并给service添加请求拦截和响应拦截，这里响应拦截提前配置好，请求拦截可以在创建请求方法时配置
 */
function createService() {
  // 创建一个 Axios 实例
  const service = axios.create()
  // 请求拦截
  service.interceptors.request.use(
    (config) => {
      // 在发送请求之前做些什么
      return config
    }, (error) => {
      // 对请求错误做些什么
      return Promise.reject(error)
    }
  )

  // 响应拦截（可根据具体业务作出相应的调整）
  service.interceptors.response.use(
    // 2xx 范围内的状态码都会触发该函数。
    // 对响应数据做点什么
    (response) => {
      // apiData 是 API 返回的数据
      const apiData = response.data as any
      // 这个 Code 是和后端约定的业务 Code
      const code = apiData.code
      // 如果没有 Code, 代表这不是项目后端开发的 API
      if (code === undefined) {
        ElMessage.error("非本系统的接口")
        return Promise.reject(new Error("非本系统的接口"))
      } else {
        switch (code) {
          case 200:
            // code === 200 代表没有错误
            return apiData
          default:
            // 不是正确的 Code
            ElMessage.error(apiData.message || "Error")
            return Promise.reject(new Error("Error"))
        }
      }
      // 超出 2xx 范围的状态码都会触发该函数。
      // 对响应错误做点什么
    }, (error) => {

      const status = get(error, 'response.status')
      switch (status) {
        case 400:
          error.message = "请求错误"
          break
        case 401:
          // Token 过期时，直接退出登录并强制刷新页面（会重定向到登录页）
          useUserStoreHook().logout()
          location.reload()
          break
        case 403:
          error.message = "拒绝访问"
          break
        case 404:
          error.message = "请求地址出错"
          break
        case 408:
          error.message = "请求超时"
          break
        case 500:
          error.message = "服务器内部错误"
          break
        case 501:
          error.message = "服务未实现"
          break
        case 502:
          error.message = "网关错误"
          break
        case 503:
          error.message = "服务不可用"
          break
        case 504:
          error.message = "网关超时"
          break
        case 505:
          error.message = "HTTP 版本不受支持"
          break
        default:
          break
      }
      ElMessage.error(error.message)
      return Promise.reject(error)
    }
  )
  return service
}

/**
 * 创建一个请求方法，传入一个service（Axios实例），
 * 返回一个带泛型T（后端传回的数据类型）的方法（参数为config，用于配置， 返回值为用config配置好的请求方法）用这个返回的方法可以创建一个发给后端的请求
 * @param service
 */
function createRequestFunction(service: AxiosInstance) {
  return function <T>(config: AxiosRequestConfig): Promise<T> {
    /**
     * 最终配置=传入的config（优先级最高）+默认配置
     */
    const configDefault = {
      headers: {
        // 携带 Token
        Authorization: "Bearer " + getToken(),
        "token": getToken(),
        "Content-Type": get(config, "headers.Content-Type", "application/json")
      },
      timeout: 5000,
      baseURL: import.meta.env.VITE_BASE_API,
      data: {}
    }
    return service(Object.assign(configDefault, config))
  }
}


export const service = createService()
/**
 * 创建一个请求方法，传入一个service（Axios实例），
 * 返回一个带泛型T（后端传回的数据类型）的方法（参数为config，用于配置， 返回值为用config配置好的请求方法）用这个返回的方法可以创建一个发给后端的请求
 * @param service
 */
export const request = createRequestFunction(service)
