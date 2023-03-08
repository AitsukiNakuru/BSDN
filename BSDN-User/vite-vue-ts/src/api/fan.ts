import {http} from "@/service/http";
import {FanParam} from "@/Type/api/fan";
import {ArticleWithOther} from "@/Type/api/article";
import {PageParam} from "@/Type/api/page";

export const getIsSubscribe = (data: FanParam) => {
  return http.post<boolean>('/fan/isSubscribe', {}, {
    params: data
  })
}
export const toSubscribe = (data: FanParam) => {
  return http.post<boolean>('/fan/subscribe', {}, {
    params: data
  })
}
export const cancelSubscribe = (data: FanParam) => {
  return http.post<boolean>('/fan/cancelSubscribe', {}, {
    params: data
  })
}
export const getSubscribeArticle = (userId: number, pageParam: PageParam) => {
  return http.post<ArticleWithOther[]>('/fan/getSubscriptArticle', {}, {
    params: {
      userId: userId,
      pageSize: pageParam.pageSize,
      pageNumber: pageParam.pageNumber
    }
  })
}
export const getFanCount = (authorId: number) => {
  return http.post<number>('fan/getFanCount', {}, {
    params: {
      authorId: authorId
    }
  })
}
