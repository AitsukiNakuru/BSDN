export interface User {
  id: number,
  username: string,
  password: string,
  nickname: string,
  introduction: string,
  avatar: string,
  email: string,
  createTime: string,
  lastLogin: string
}
export interface UserParam{
  id?: number,
  username?: string,
  password?: string,
  nickname?: string,
  introduction?: string,
  avatar?: string,
  email?: string,
  createTime?: string,
  lastLogin?: string
}


export type UserListResponseData = IApiResponseData<{userList: User[], userCount: number}>
