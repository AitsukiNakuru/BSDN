export interface Category {
  id: number,
  categoryName: string,
  description: string
}
export class CategoryConstructor {
  id=0
  categoryName = ""
  description = ""
  constructor(categoryName: string) {
    this.id = 0
    this.categoryName = categoryName
    this.description = ""
  }
}

