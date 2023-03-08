
import { request } from "@/utils/service"
import {PageParam} from "@/api/table/types/page";
import {http} from "@/utils/http";
import {User, UserListResponseData, UserParam} from "@/api/table/types/user";
import {MessageResponseData} from "@/api/common/types";
export function getUserListApi(userParam: UserParam, pageParam: PageParam) {
  return http.post<UserListResponseData>('user/userList', userParam, {
    params: {
      ...pageParam
    }
  })

}


export function updateUserApi(user: User) {
  return http.post<MessageResponseData>('user/update', user)
}
