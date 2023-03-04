import axios, {Axios, AxiosResponse, AxiosRequestConfig, AxiosInstance} from "axios";

declare module "axios" {
  interface AxiosResponse<T = any> {
    code: number;
    message: string;
    data: any
  }
  export function create(config?: AxiosRequestConfig): AxiosInstance;
}
declare module '@kangc/v-md-editor/lib/theme/vuepress.js';
