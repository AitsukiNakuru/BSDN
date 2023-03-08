<template>
  <div>{{categoryList}}</div>
  <el-form :inline="true" :model="articleParam" class="demo-form-inline">
    <el-form-item label="标题">
      <el-input v-model="articleParam.title" placeholder="标题" />
    </el-form-item>
    <el-form-item label="作者">
      <el-input v-model="articleParam.author" placeholder="作者" />
    </el-form-item>
    <el-form-item label="分类">
      <el-select v-model="articleParam.category" placeholder="分类" clearable filterable>
        <el-option v-for="(item, index) in categoryList" :label="item.categoryName" :value="item.categoryName" />
      </el-select>
    </el-form-item>
    <el-button @click="selectArticleByParam">搜索</el-button>
  </el-form>

  <div v-infinite-scroll="toLoadMore" :infinite-scroll-disabled="scrollDisable">
    <el-card v-for="(item, index) in articleList" class="Article-Card">
      <div>
        <div class="Article-Title">{{item.title}}</div>
        <div class="Article-Author">{{item.author.nickname}}</div>
        <div class="Article-Content">{{item.content}}</div>
      </div>
      <el-button @click="handleArticleDetail(item)">阅读全文</el-button>
    </el-card>
  </div>
</template>

<script setup lang="ts">
import {onMounted, ref} from 'vue';
import {ArticleParam, ArticleWithOther} from "@/Type/api/article";
import {getArticleList} from "@/api/article";
import {Category, CategoryConstructor} from "@/Type/api/category";
import {getCategoryList} from "@/api/category";
import {useArticleStore} from "@/store";
import router from "@/router";
import {stringifyQuery} from "vue-router";
import {PageParam} from "@/Type/api/page";

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
  const result = getArticleList(articleParam.value, pageParam.value)
  result.then((res) => {
    if(res.length === 0) {
      scrollDisable.value = true

    } else {
      articleList.value?.push(...res)
    }
    
  })
}
const selectArticleByParam = () => {
  toGetList()
  scrollDisable.value = false
  toLoadMore()
}


const articleList = ref<ArticleWithOther[]>()
const articleParam = ref<ArticleParam>({
  title: "",
  author: "",
  category: ""
})
const categoryList = ref<Category[]>()


const handleArticleDetail = (item: ArticleWithOther) => {
  router.push({path: '/home/articleDetail', query: {articleId: item.id}})
}
onMounted(async () => {
  toGetList()
  categoryList.value = await getCategoryList(new CategoryConstructor(""))
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
