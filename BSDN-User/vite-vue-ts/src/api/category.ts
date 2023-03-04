
import {http} from "@/service/http";
import {Category} from "@/Type/api/category";

export const getCategoryList = (data: Category) => {
  return http.post<Category[]>('/category/select', data)
};
