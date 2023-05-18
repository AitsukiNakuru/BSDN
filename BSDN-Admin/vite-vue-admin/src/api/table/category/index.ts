import {CategoryParam, CategoryListResponseData} from "@/api/table/types/category";
import {PageParam} from "@/api/table/types/page";
import {http} from "@/utils/http";
import {MessageResponseData} from "@/api/common/types";

export function getCategoryListApi(categoryParam: CategoryParam, pageParam: PageParam) {
  return http.post<CategoryListResponseData>('category/list', categoryParam, {
    params: {
      ...pageParam
    }
  })
}

export function updateCategoryApi(categoryParam: CategoryParam) {
  return http.post<MessageResponseData>('category/update', categoryParam)
}

export function deleteCategoryApi(categoryParam: CategoryParam) {
  return http.post<MessageResponseData>('category/delete', categoryParam)
}

export function addCategoryApi(categoryParam: CategoryParam) {
  return http.post<MessageResponseData>('category/add', categoryParam)
}

export function getAllCategoryApi() {
  return http.post<MessageResponseData>('category/selectAll')
}
