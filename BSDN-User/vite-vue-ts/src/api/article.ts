
import {http} from "@/service/http";
import {ArticleParam, ArticleWithOther, PublicArticle} from "@/Type/api/article";
import {PageParam} from "@/Type/api/page";

export const publicArticle = (data: PublicArticle) => {

  return http.post<null>('/article/public', data)
};
export const getArticleList = (data: ArticleParam, pageParam: PageParam) => {
  return http.post<ArticleWithOther[]>('/article/selectByParam', data,  {
    params: pageParam
  })
}

export const getArticleById = (data: number) => {
  return http.post<ArticleWithOther>('/article/selectById?articleId=' + data)
}
