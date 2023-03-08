
import { createRouter, createWebHashHistory } from 'vue-router'
import * as path from "path";


const routes = [
  {
    path: '/',
    redirect: '/home/ArticleList'
  },
  {
    path: '/admin',
    redirect: '/adminLogin'
  },
  {
    path: '/home',
    name: 'Home',
    component: () => import('@/views/Home.vue'),
    children: [
      {
        path: 'articleList',
        name: 'ArticleList',
        component: () => import('@/views/ArticleList.vue')
      },
      {
        path: 'collectionList',
        name: 'CollectionList',
        component: () => import('@/views/CollectionList.vue')
      },
      {
        path: 'articleEdit',
        name: 'ArticleEdit',
        component: () => import('@/views/ArticleEdit.vue')
      },
      {
        path: 'articleDetail',
        name: 'ArticleDetail',
        component: () => import('@/views/ArticleDetail.vue')
      },
      {
        path: 'subscribeList',
        name: 'SubscribeList',
        component: () => import('@/views/SubscribeList.vue')
      },
      {
        path: 'myArticleList',
        name: 'MyArticleList',
        component: () => import('@/views/MyArticleList.vue')
      }
    ]
  },
  {
    path: '/adminLogin',
    name: 'AdminLogin',
    component: () => import('@/views/admin/AdminLogin.vue'),
    children: [
      {
        path: 'articleList',
        name: 'AdminArticleList',
        component: () => import('@/views/admin/AdminArticleList.vue'),
      },
      {
        path: 'categoryList',
        name: 'AdminCategoryList',
        component: () => import('@/views/admin/AdminCategoryList.vue'),
      },
      {
        path: 'commentsList',
        name: 'AdminCommentsList',
        component: () => import('@/views/admin/AdminCommentList.vue'),
      },
      {
        path: 'userManage',
        name: 'AdminUserManage',
        component: () => import('@/views/admin/AdminUserManage.vue')
      }
    ]
  }
]
const router = createRouter({
  history: createWebHashHistory(),
  routes
})
// 导出路由
export default router
