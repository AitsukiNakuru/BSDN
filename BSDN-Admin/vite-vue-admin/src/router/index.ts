import {createRouter, createWebHistory, RouteRecordRaw} from "vue-router";

const Layout = () => import("@/layout/index.vue")
export const constantRoutes: RouteRecordRaw[] = [
  {
    path: "/redirect",
    component: Layout,
    meta: {
      hidden: true
    },
    children: [
      {
        path: "/redirect/:path(.*)",
        component: () => import("@/views/redirect/index.vue")
      }
    ]
  },
  {
    path: "/403",
    component: () => import("@/views/error-page/403.vue"),
    meta: {
      hidden: true
    }
  },
  {
    path: "/404",
    component: () => import("@/views/error-page/404.vue"),
    meta: {
      hidden: true
    },
    alias: "/:pathMatch(.*)*"
  },
  {
    path: "/",
    component: Layout,
    redirect: "/table/article",

  },
  {
    path: "/login",
    component: () => import("@/views/login/index.vue"),
    meta: {
      hidden: true
    }
  },
  {
    path: '/table/user',
    component: Layout,
    name: "UserTable",
    redirect: '/table/user/index',
    children: [
      {
        path: "index",
        component: () => import("@/views/table/user-table/index.vue"),
        name: 'UserTableIndex',
        meta: {
          title: "用户表格",
          svgIcon: "unocss"
        },
      }
    ]
  },
  {
    path: '/table/article',
    component: Layout,
    name: "ArticleTable",
    redirect: '/table/article/index',
    children: [
      {
        path: "index",
        component: () => import("@/views/table/article-table/index.vue"),
        name: 'ArticleTable',
        meta: {
          title: "文章表格",
          svgIcon: "unocss"
        },
      }
    ]
  },
  {
    path: '/table/category',
    component: Layout,
    name: "CategoryTable",
    redirect: '/table/category/index',
    children: [
      {
        path: "index",
        component: () => import("@/views/table/category-table/index.vue"),
        name: 'CategoryTable',
        meta: {
          title: "分类表格",
          svgIcon: "unocss"
        },
      }
    ]
  },
  {
    path: "/unocss",
    component: Layout,
    redirect: "/unocss/index",
    children: [
      {
        path: "index",
        component: () => import("@/views/unocss/index.vue"),
        name: "UnoCSS",
        meta: {
          title: "unocss",
          svgIcon: "unocss"
        }
      }
    ]
  },
]

/**
 * 动态路由
 * 用来放置有权限 (Roles 属性) 的路由
 * 必须带有 Name 属性
 */
export const asyncRoutes: RouteRecordRaw[] = [
  /*{
    path: "/permission",
    component: Layout,
    redirect: "/permission/page",
    name: "Permission",
    meta: {
      title: "权限管理",
      svgIcon: "lock",
      roles: ["admin", "editor"], // 可以在根路由中设置角色
      alwaysShow: true // 将始终显示根菜单
    },
    children: [
      {
        path: "page",
        component: () => import("@/views/permission/page.vue"),
        name: "PagePermission",
        meta: {
          title: "页面权限",
          roles: ["admin"] // 或者在子导航中设置角色
        }
      },
      {
        path: "directive",
        component: () => import("@/views/permission/directive.vue"),
        name: "DirectivePermission",
        meta: {
          title: "指令权限" // 如果未设置角色，则表示：该页面不需要权限，但会继承根路由的角色
        }
      }
    ]
  },*/
  {
    path: "/:pathMatch(.*)*", // Must put the 'ErrorPage' route at the end, 必须将 'ErrorPage' 路由放在最后
    redirect: "/404",
    name: "ErrorPage",
    meta: {
      hidden: true
    }
  }
]
/** 重置路由 */
export function resetRouter() {
  // 注意：所有动态路由路由必须带有 Name 属性，否则可能会不能完全重置干净
  try {
    router.getRoutes().forEach((route) => {
      const {name, meta} = route
      // 只删有权限的路由
      if (name && meta.roles?.length) {
        router.hasRoute(name) && router.removeRoute(name)
      }
    })
  } catch (error) {
    // 强制刷新浏览器也行，只是交互体验不是很好
    window.location.reload()
  }
}

const router = createRouter({
  history: import.meta.env.VITE_ROUTER_HISTORY === 'hash' ? createWebHistory() : createWebHistory(),
  routes: constantRoutes
})

export default router
