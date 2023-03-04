<template>
  <div>
    <div>{{ article.title }}</div>
    <mavon-editor
      v-model="article.content"
      :editable="false"
      :scrollStyle="true"
      :subfield="false"
      :toolbarsFlag="false"
      class="Markdown"
      defaultOpen="preview"
      style="min-height:20px"
    ></mavon-editor>
    <div>
      <el-button icon="View" round>{{ article.viewCount }}</el-button>
      <el-button disabled="isThumbed" icon="Check" round>{{ article.viewCount }}</el-button>
      <el-button icon="Star" round>{{ article.viewCount }}</el-button>
    </div>
    <div class="Comment-List">
      <ul v-infinite-scroll="toGetCommentMore" :infinite-scroll-disabled="scrollDisabled" class="infinite-list"
          style="overflow: auto">
        <li v-for="(item, index) in commentList" class="infinite-list-item">
          <div>{{ item.user.nickname }}:</div>
          <div>{{ item.content }}</div>
        </li>
      </ul>
    </div>
    <div>
      <el-input v-model="comment.content" maxlength="20" placeholder="输入评论">
        <template #append>
          <el-button @click="handleAddComment">评论</el-button>
        </template>
      </el-input>
    </div>
  </div>
  <div>{{ isThumbed }}</div>
</template>

<script lang="ts" setup>
import {computed, onBeforeMount, onMounted, ref, watch} from 'vue';
import {ArticleWithOther} from "@/Type/api/article";
import {useArticleStore, useUserStore} from "@/store";
import {User} from "@/Type/api/user";
import {Category} from "@/Type/api/category";
import {addComment, selectCommentByParam} from "@/api/comment";
import {CommentParam, Comment} from "@/Type/api/comment";
import {getArticleById, getArticleList} from "@/api/article";
import router from "@/router";
import {useRoute} from "vue-router";
import {PageParam} from "@/Type/api/page";
import {getIsThumb} from "@/api/thumb";

const route = useRoute()
const article = ref<ArticleWithOther>({
  id: 0,
  title: "",
  createTime: "",
  authorId: 0,
  categoryId: 0,
  viewCount: 0,
  thumbCount: 0,
  collectCount: 0,
  content: "",
  contentHtml: "",
  author: {} as User,
  category: {} as Category
})
const articleStore = useArticleStore()
const userStore = useUserStore()
const comment = ref<Comment>({
  userId: userStore.user.id,
  articleId: route.query.articleId as unknown as number,
  id: 0,
  content: "",
  createTime: "",
  user: {
    id: -1,
    username: "",
    password: "",
    nickname: "",
    introduction: "",
    avatar: "",
    email: "",
    createTime: "",
    lastLogin: "",
    token: ""
  }
})
const commentList = ref<Comment[]>([])
const commentParam = ref<CommentParam>({
  userId: -1,
  articleId: route.query.articleId as unknown as number
})
const pageParam = ref<PageParam>({
  pageSize: 5,
  pageNumber: 0
})
const scrollDisabled = ref(false)
const isThumbed = ref(false)
watch(userStore.user, async (newUser, oldUser) => {
  console.log("watch")
  await getGetIsThumb()
})
const getGetIsThumb = async () => {
  isThumbed.value = await getIsThumb({
    userId: userStore.user.id,
    articleId: route.query.articleId as unknown as number
  })
}
const toGetCommentList = () => {
  pageParam.value = {
    pageSize: 5,
    pageNumber: 0
  }
  commentList.value = []
}
const toGetCommentMore = () => {
  pageParam.value.pageNumber += 1
  const result = selectCommentByParam(commentParam.value, pageParam.value)
  result.then((res) => {
    if (res.length == 0) {
      scrollDisabled.value = true
    }
    console.log(res)
    commentList.value?.push(...res)
  })
}

const handleAddComment = () => {
  addComment(comment.value)
}

onMounted(async () => {
  article.value = await getArticleById(route.query.articleId as unknown as number)
})


</script>

<style lang="scss" scoped>
.Markdown {
  margin: 50px;
}

.infinite-list {
  height: 300px;
  padding: 0;
  margin: 0;
  list-style: none;
}

.infinite-list .infinite-list-item {
  display: flex;
  align-items: center;
  justify-content: center;
  height: 50px;
  background: var(--el-color-primary-light-9);
  margin: 10px;
  color: var(--el-color-primary);
}

.infinite-list .infinite-list-item + .list-item {
  margin-top: 10px;
}
</style>
