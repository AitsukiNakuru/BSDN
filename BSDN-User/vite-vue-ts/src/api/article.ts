
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

export const viewArticle = (data: number) => {
  return http.post<null>('/article/viewArticle', {}, {
    params: {
      articleId: data
    }
  })
}

export const getMyArticle = (data: number, pageParam: PageParam) => {
  return http.post<ArticleWithOther[]>('/article/selectByAuthorId', {}, {
    params: {
      authorId: data,
      pageSize: pageParam.pageSize,
      pageNumber: pageParam.pageNumber
    }
  })
}
export const deleteArticle = (data: number) => {
  return http.post('/article/deleteArticle', {}, {
    params: {
      articleId: data
    }
  })
}
