import {User} from "@/Type/api/user";
import {Category} from "@/Type/api/category";

export interface ArticleWithOther {
  id: number,
  title: string,
  createTime: string,
  authorId: number,
  categoryId: number,
  viewCount: number,
  thumbCount: number,
  collectCount: number,
  content: string,
  contentHtml: string,
  author: User,
  category: Category
}

export interface PublicArticle {
  id: number,
  title: string,
  createTime: string,
  authorId: number,
  categoryId: number,
  viewCount: number,
  thumbCount: number,
  collectCount: number,
  content: string,
  contentHtml: string
}
export interface ArticleParam{
  author: string,
  title: string,
  category: string
}
