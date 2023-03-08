export interface Category {
  id: number,
  categoryName: string,
  description: string
}

export interface CategoryParam {
  id?: number
  categoryName?: string
  description?: string
}

export type CategoryListResponseData = IApiResponseData<{ categoryList: Category[], categoryCount: number }>
