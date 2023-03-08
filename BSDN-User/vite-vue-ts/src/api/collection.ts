import {CollectionParam} from "@/Type/api/collection";
import {http} from "@/service/http";
import {PageParam} from "@/Type/api/page";

export const getIsCollected = (data: CollectionParam) => {
  return http.post<boolean>('/collection/isCollected', data)
}
export const addCollection = (data: CollectionParam) => {
  return http.post<boolean>('/collection/addCollection', data)
}
export const deleteCollection = (data: CollectionParam) => {
  return http.post('/collection/deleteCollection', data)
}
export const getCollection = (data: number, pageParam: PageParam) => {
  return http.post('/collection/getCollection', {}, {
    params: {
      userId: data,
      pageNumber: pageParam.pageNumber,
      pageSize: pageParam.pageSize
    }
  })
}
export const getCollectionCount = (data: CollectionParam) => {
  return http.post<number>('/collection/getCollectionCount', data);
}
