import {LoginForm, RegisterForm, User} from "@/Type/api/user";
import {http} from "@/service/http";

export const login = (data: LoginForm) => {
  return http.post<User>('/user/login', data)
}


export const register = (data: RegisterForm) => {
  return http.post<User>('/user/register', data)
}
export const update = (data: User) => {
  return http.post<null>('/user/update', data)
}
