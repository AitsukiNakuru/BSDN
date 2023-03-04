
import {http} from "@/service/http";
import {CommentParam, Comment} from "@/Type/api/comment";
import {PageParam} from "@/Type/api/page";

export const addComment = (data: Comment) => {
  return http.post<null>('/comment/addComment', data)
};

export const selectCommentByParam = (data: CommentParam, pageParam: PageParam) => {
  return http.post<Comment[]>('/comment/selectByParam', data, {
    params: pageParam
  })
}
