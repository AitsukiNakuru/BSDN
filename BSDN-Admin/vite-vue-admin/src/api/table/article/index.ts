import {Article, ArticleListResponseData, ArticleParam} from "@/api/table/types/article";
import { PageParam } from "../types/page";
import {http} from "@/utils/http";
import {MessageResponseData} from "@/api/common/types";

export function getArticleListApi(articleParam: ArticleParam, pageParam: PageParam) {
  return http.post<ArticleListResponseData>('/article/articleList', articleParam, {
    params: {
      ...pageParam
    }
  })
}
export function updateArticleApi(article: Article) {
  return http.post<MessageResponseData>('/article/update', article)
}

export function deleteArticleApi(articleId: number) {
  return http.post<MessageResponseData>('/article/deleteArticle', {}, {
    params: {
      articleId
    }
  })
}
