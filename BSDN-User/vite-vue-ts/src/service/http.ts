import type { AxiosError, AxiosRequestConfig } from 'axios'
import service from './index'
export const http = {
  get<T=any>(url: string, config?: AxiosRequestConfig) : Promise<T> {
    return service.get(url, config)
  },

  post<T=any>(url: string, data?: object, config?: AxiosRequestConfig) :Promise<T> {
    return service.post(url, data, config)
  },

  put<T=any>(url: string, data?: object, config?: AxiosRequestConfig) :Promise<T> {
    return service.put(url, data, config)
  },

  delete<T=any>(url: string, config?: AxiosRequestConfig) : Promise<T> {
    return service.delete(url, config)
  }
}
