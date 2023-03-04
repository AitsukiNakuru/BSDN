/* 登录接口参数类型 */
export interface LoginForm {
  username: string,
  password: string,
}


export interface User{
  id: number,
  username: string,
  password: string,
  nickname: string,
  introduction: string,
  avatar: string,
  email: string,
  createTime: string,
  lastLogin: string
  token?: string
}
