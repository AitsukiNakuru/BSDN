
import { createRouter, createWebHashHistory } from 'vue-router'


const routes = [
  {
    path: '/',
    redirect: '/home'
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
        path: 'categoryList',
        name: 'CategoryList',
        component: () => import('@/views/CategoryList.vue')
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
    ]
  },
]
const router = createRouter({
  history: createWebHashHistory(),
  routes
})
// 导出路由
export default router
