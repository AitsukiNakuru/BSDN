import {User} from "@/Type/api/user";

export interface Comment {
  id: number,
  content: string,
  userId: number,
  articleId: number,
  createTime: string
  user: User
}
export interface CommentParam {
  userId: number,
  articleId: number
}
