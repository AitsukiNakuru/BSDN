import {LoginForm, RegisterForm, User} from "@/Type/api/user";
import {http} from "@/service/http";

export const userLogin = (data: LoginForm) => {
  return http.post<User>('/user/login', data)
}

export const userRegister = (data: RegisterForm) => {
  return http.post<User>('/user/register', data)
}
export const userUpdate = (data: User) => {
  return http.post<null>('/user/update', data)
}
