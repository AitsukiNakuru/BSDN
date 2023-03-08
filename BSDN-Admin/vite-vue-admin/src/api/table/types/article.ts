import {User} from "@/api/table/types/user";
import {Category} from "@/api/table/types/category";

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

export interface Article {
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
}

export interface ArticleParam{
  author: string,
  title: string,
  category: string
}

export type ArticleListResponseData = IApiResponseData<{articleList: ArticleWithOther[], articleCount: number}>
