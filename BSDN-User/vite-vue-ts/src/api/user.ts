import {LoginForm, User} from "@/Type/api/user";
import {http} from "@/service/http";

export const userLogin = (data: LoginForm) => {

  return http.post<User>('/user/login', data)
};
