<template>

  <div v-infinite-scroll="toLoadMore" :infinite-scroll-disabled="scrollDisable">
    <el-card v-for="(item, index) in articleList" class="Article-Card">
      <div>
        <div class="Article-Title">{{item.title}}</div>
        <div class="Article-Author">{{item.author.nickname}}</div>
        <div class="Article-Content">{{item.content}}</div>
      </div>
      <el-button @click="handleArticleDetail(item)">阅读全文</el-button>
      <el-button @click="handleDeleteArticle(item)">删除</el-button>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import {onMounted, ref} from 'vue';
import {useUserStore} from "@/store";
import {PageParam} from "@/Type/api/page";
import {getCollection} from "@/api/collection";
import {ArticleWithOther} from "@/Type/api/article";
import router from "@/router";
import {deleteArticle, getMyArticle} from "@/api/article";
const userStore = useUserStore()
const pageParam = ref<PageParam>({
  pageSize: 5,
  pageNumber: 0
})
const scrollDisable = ref(false)
const toGetList = () => {
  pageParam.value = {
    pageSize: 5,
    pageNumber: 0
  }
  articleList.value = []
}
const toLoadMore = () => {
  pageParam.value.pageNumber+=1
  const result = getMyArticle(userStore.user.id, pageParam.value)
  result.then((res) => {
    if (res.length === 0) {
      scrollDisable.value = true
    } else {
      console.log(res)
      articleList.value?.push(...res)
    }
  })
}
const handleDeleteArticle = (item: ArticleWithOther) => {
  deleteArticle(item.id)
  toGetList()
  scrollDisable.value = false
}
const articleList = ref<ArticleWithOther[]>()


const handleArticleDetail = (item: ArticleWithOther) => {
  router.push({path: '/home/articleDetail', query: {articleId: item.id}})
}
onMounted(async () => {
  toGetList()
})

</script>

<style scoped lang="scss">
.Article-Card{
  margin: 50px 200px;
  height: 200px;
  padding: 30px 50px;
  .Article-Content{

    display: -webkit-box;  /*弹性伸缩盒子*/
    -webkit-box-orient: vertical;/*垂直排列*/
    line-clamp: 6;
    -webkit-line-clamp: 6;  /*只显示6行*/
    overflow: hidden;   /*溢出隐藏*/
    text-overflow: ellipsis;   /*省略号代替*/

  }
}
</style>
