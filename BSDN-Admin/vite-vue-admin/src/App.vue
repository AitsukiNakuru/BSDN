<template>
  <ElConfigProvider :locale="locale" :message="{max: 10}">
    <router-view />
  </ElConfigProvider>

</template>
<script setup lang="ts">
import zhCn from "element-plus/lib/locale/lang/zh-cn"
import { useTheme } from "@/hooks/useTheme"
const { initTheme } = useTheme()

/** 初始化主题 */
initTheme()
/** 将 Element Plus 的语言设置为中文 */
const locale = zhCn
</script>



<style scoped>

</style>
