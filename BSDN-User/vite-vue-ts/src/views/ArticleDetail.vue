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
      <el-button :disabled="thumbDisable" icon="Check" round @click="handleThumb">{{ thumbCount }}</el-button>
      <el-button icon="User" round :disabled="subscribeDisable" @click="handleSubscribe">{{ fanCount }}</el-button>
      <el-button icon="Star" round :disabled="collectionDisable" @click="handleCollection">{{ collectionCount }}</el-button>
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
          <el-button @click="handleAddComment" :disabled="commentDisabled">评论</el-button>
        </template>
      </el-input>
    </div>
  </div>

</template>

<script lang="ts" setup>
import {computed, onBeforeMount, onMounted, ref, watch} from 'vue';
import {ArticleWithOther} from "@/Type/api/article";
import {useArticleStore, useUserStore} from "@/store";
import {User} from "@/Type/api/user";
import {Category} from "@/Type/api/category";
import {addComment, selectCommentByParam} from "@/api/comment";
import {CommentParam, Comment} from "@/Type/api/comment";
import {getArticleById, getArticleList, viewArticle} from "@/api/article";
import router from "@/router";
import {useRoute} from "vue-router";
import {PageParam} from "@/Type/api/page";
import {cancelThumb, getIsThumb, getThumbCount, thumbArticle} from "@/api/thumb";
import {cancelSubscribe, getFanCount, getIsSubscribe, toSubscribe} from "@/api/fan";
import {FanParam} from "@/Type/api/fan";
import {addCollection, deleteCollection, getCollectionCount, getIsCollected} from "@/api/collection";

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


const pageParam = ref<PageParam>({
  pageSize: 5,
  pageNumber: 0
})
const scrollDisabled = ref(false)

watch(() =>userStore.user, async (newUser, oldUser) => {
  console.log("watch")
  updateSubscribeDisable()
  updateThumbDisable()
  updateCollectionDisable()
  updateCommentDisabled()
})

// Comment
const commentDisabled = ref(true)
const updateCommentDisabled = () => {
  commentDisabled.value = userStore.user.id === -1
}
const comment = ref<Comment>({
  userId: -1,
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
    commentList.value?.push(...res)
  })
}
const handleAddComment = async () => {
  comment.value.userId = userStore.user.id
  await addComment(comment.value)
  await toGetCommentList()
  scrollDisabled.value = false
}


// Subscribe
const subscribeDisable = ref(true)
const handleSubscribe = async () => {
  let isSubscribe = await getIsSubscribe({
    authorId: article.value.authorId,
    userId: userStore.user.id
  })
  console.log(isSubscribe)
  if (isSubscribe) {
    await cancelSubscribe({
      authorId: article.value.authorId,
      userId: userStore.user.id
    })
  } else {
    await toSubscribe({
      authorId: article.value.authorId,
      userId: userStore.user.id
    })
  }
  await updateFanCount()
}
const updateSubscribeDisable = () => {
  subscribeDisable.value = userStore.user.id === -1;
}

// Thumb
const thumbCount = ref<number>(0)
const updateThumbCount = async () => {
  thumbCount.value = await getThumbCount(article.value.id)
}
const thumbDisable = ref(true)
const handleThumb = async () => {
  let isThumb = await getIsThumb({
    userId: userStore.user.id,
    articleId: route.query.articleId as unknown as number
  })
  if (isThumb) {
    await cancelThumb({
      articleId: article.value.id,
      userId: userStore.user.id
    })
  } else {
    await thumbArticle({
      articleId: article.value.id,
      userId: userStore.user.id
    })
  }
  await updateThumbCount()
}
const updateThumbDisable = () => {
  thumbDisable.value = userStore.user.id === -1;
}

// Collection
const collectionCount = ref(0)
const collectionDisable = ref(true)
const updateCollectionDisable = () => {
  collectionDisable.value = userStore.user.id === -1;
}
const updateCollectionCount = async () => {
  let collectionParam: CommentParam = {
    articleId: article.value.id,
    userId: -1
  };
  collectionCount.value = await getCollectionCount(collectionParam)
}
const handleCollection = async () => {
  let collectionParam: CommentParam = {
    articleId: article.value.id,
    userId: userStore.user.id
  };
  let isCollected = await getIsCollected(collectionParam)
  if (isCollected) {
    await deleteCollection(collectionParam)
  } else {
    await addCollection(collectionParam)
  }
  await updateCollectionCount()
}


// Fan
const fanCount = ref<number>(0)
const updateFanCount = async () => {
  fanCount.value = await getFanCount(article.value.authorId)
}

onMounted(async () => {
  toGetCommentList()
  await viewArticle(route.query.articleId as unknown as number)
  article.value = await getArticleById(route.query.articleId as unknown as number)
  if (userStore.user != undefined) {
    updateSubscribeDisable()
    updateCollectionDisable()
    updateThumbDisable()
    updateCommentDisabled()
  }
  await updateFanCount()
  await updateThumbCount()
  await updateCollectionCount()
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
