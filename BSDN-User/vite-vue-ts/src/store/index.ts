import { defineStore } from 'pinia'
import {User} from "@/Type/api/user";
import {ArticleWithOther} from "@/Type/api/article";

// useStore 可以是 useUser、useCart 之类的任何东西
// 第一个参数是应用程序中 store 的唯一 id
export const useStore = defineStore('main', {
  state:()=>{//创建状态
    return {
      text:"我是pinia的一个状态变量"
    }
  }
})

export const useUserStore = defineStore('userStore', {
  state: () =>{
    return {
      user: {} as User
    }
  },

  getters: {

  },

  actions: {
  },
  persist: true,
})

export const useArticleStore = defineStore('articleStore', {
  state: () =>{
    return {
      articleSelectedId: {} as number,
      article: {} as ArticleWithOther
    }
  },

  getters: {

  },

  actions: {
  },
})
