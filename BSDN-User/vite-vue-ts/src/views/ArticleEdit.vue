<template>
  <el-form :inline="true" :model="article" class="demo-form-inline">
    <el-form-item label="标题">
      <el-input v-model="article.title" placeholder="标题" />
    </el-form-item>
    <el-form-item label="分类">
      <el-select v-model="article.categoryId" placeholder="分类" filterable>
        <el-option v-for="(item, index) in categoryList" :label="item.categoryName" :value="item.id" />
      </el-select>
    </el-form-item>
  </el-form>
  <div id="editor">
    <mavon-editor class="Markdown-Edit" v-model="article.content"/>
  </div>
  <el-button @click="handlePublicArticle" :disabled="publicDisable">发布</el-button>
</template>

<script setup lang="ts">
import {onMounted, ref, watch} from 'vue';
import {PublicArticle} from "@/Type/api/article";
import {useUserStore} from "@/store";
import {getCategoryList} from "@/api/category";
import {Category} from "@/Type/api/category";
import {publicArticle} from "@/api/article";


const categoryList = ref<Category[]>()
const userStore = useUserStore();
const article = ref<PublicArticle>({
  id: 0,
  title: "",
  createTime: "",
  authorId: 0,
  categoryId: 0,
  viewCount: 0,
  thumbCount: 0,
  collectCount: 0,
  content: "",
  contentHtml: ""
})
const handlePublicArticle = () => {
  article.value.authorId = userStore.user.id
  publicArticle(article.value)
}

watch(() => userStore.user, (newValue, oldValue) => {
  updatePublicArticle()
})

const publicDisable = ref(true)
const updatePublicArticle = () => {
  publicDisable.value = userStore.user.id===-1
}

const testResult = ref()
const testButton = () => {
  const category = {
    id: 0,
    categoryName: "",
    description: "",
  }
  const result = getCategoryList(category)
  testResult.value = result
  console.log(result)
}


onMounted(async () => {
  const category = {
    id: 0,
    categoryName: "",
    description: "",
  }
  categoryList.value = await getCategoryList(category)
  updatePublicArticle()
})
</script>

<style scoped>
.Markdown-Edit{
  height: 800px
}
</style>
