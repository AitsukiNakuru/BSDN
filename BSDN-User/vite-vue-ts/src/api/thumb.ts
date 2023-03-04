
import {http} from "@/service/http";
import {ThumbParam} from "@/Type/api/thumb";

export const getIsThumb = (data: ThumbParam) => {
  return http.post<boolean>('/thumb/isThumb', data)
};
