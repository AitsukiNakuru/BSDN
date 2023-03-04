<template>
  <div class="Home-Layout">
    <el-row>
      <el-col :span="24">
        <el-menu
          class="el-menu-demo"
          default-active=0
          mode="horizontal"
          router
          @select="handleMenuItemSelect"
        >
          <el-menu-item v-for="(item, index) in menuItems" :index=item.path>
            {{ item.title }} ++ {{ index }}
          </el-menu-item>

        </el-menu>
      </el-col>
    </el-row>

    <el-row>
      <el-col :span="20">
        <router-view></router-view>
      </el-col>
      <el-col :span="4">
        <user-board></user-board>
      </el-col>
    </el-row>
  </div>


</template>

<script lang="ts" setup>
import {ref} from 'vue';

import {useStore} from "@/store"
import UserBoard from "@/views/UserBoard.vue";

const activeIndex2 = ref('1')
const handleSelect = (key: string, keyPath: string[]) => {
  console.log(key, keyPath)
}

const menuItems = [
  {
    title: "文章列表",
    path: "/home/articleList",
  },
  {
    title: "分类",
    path: "/home/categoryList",
  },
  {
    title: "文章编辑",
    path: "/home/articleEdit",
  },
  {
    title: "Fourth",
    path: "",
  },
  {
    title: "测试用",
    path: "/home/articleDetail",
  }
]

const handleMenuItemSelect = () => {
  console.log()
}


let store = useStore()
</script>

<style scoped>
.Sass {
  height: 100px;
  width: 100px;
  color: red;
}
</style>
