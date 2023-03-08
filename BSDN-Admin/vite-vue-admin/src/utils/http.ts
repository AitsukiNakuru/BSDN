import {AxiosRequestConfig} from "axios";
import {request, service} from "@/utils/service";

/**
 * 把{code, message, data}包进Promise返回，此时，code已经在Axios的响应拦截器中进行处理了.在调用的地方对message和data进行处理
 */
export const http = {
  get<T>(url: string, config?: AxiosRequestConfig): Promise<T> {
    return request<T>(Object.assign({method: 'get'}, {
      url,
      ...config
    }))
  },
  post<T>(url: string, data?: object, config?: AxiosRequestConfig) :Promise<T> {
    return request<T>(Object.assign({method: 'post'}, {
      url,
      data,
      ...config
    }))
  },

  put<T=any>(url: string, data?: object, config?: AxiosRequestConfig) :Promise<T> {
    return request<T>(Object.assign({method: 'put'}, {
      url,
      data,
      ...config
    }))
  },

  delete<T=any>(url: string, config?: AxiosRequestConfig) : Promise<T> {
    return request<T>(Object.assign({method: 'delete'}, {
      url,
      ...config
    }))
  }
}
