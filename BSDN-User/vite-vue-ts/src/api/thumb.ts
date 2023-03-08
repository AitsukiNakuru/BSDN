
import {http} from "@/service/http";
import {ThumbParam} from "@/Type/api/thumb";

export const getIsThumb = (data: ThumbParam) => {
  return http.post<boolean>('/thumb/isThumb', data)
}
export const thumbArticle = (data: ThumbParam) => {
  return http.post<null>('/thumb/thumb', data)
}
export const getThumbCount = (data: number) => {
  return http.post<number>('/thumb/getThumbCount', {}, {
    params: {
      articleId: data
    }
  })
}
export const cancelThumb = (data: ThumbParam) => {
  return http.post('/thumb/cancelThumb', data)
}
