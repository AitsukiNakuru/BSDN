<template>
  <div style="height: 99%">
    <vxe-table
      ref="xTable"
      :column-config="{resizable: true}"
      :data="tableData"
      :row-config="{height: 41, isHover: true}"
      border
      height="95%"
      show-overflow
      @cell-dblclick="cellDBLClickEvent">
      <vxe-column type="seq" width="60"></vxe-column>
      <vxe-column field="title" title="标题"></vxe-column>
      <vxe-column field="author.nickname" title="作者"></vxe-column>
      <vxe-column field="category.categoryName" title="分类"></vxe-column>
      <vxe-column field="viewCount" title="阅读数"></vxe-column>
      <vxe-column field="thumbCount" title="点赞数"></vxe-column>
      <vxe-column field="collectCount" title="收藏数"></vxe-column>
      <vxe-column show-overflow title="编辑" width="100">
        <template #default="{ row }">
          <vxe-button icon="vxe-icon-file-markdown" type="text" @click="viewEvent(row)"></vxe-button>
          <vxe-button icon="vxe-icon-delete" type="text" @click="removeEvent(row)"></vxe-button>
        </template>
      </vxe-column>

    </vxe-table>
    <vxe-pager
      :layouts="['PrevJump', 'PrevPage', 'Number', 'NextPage', 'NextJump', 'FullJump', 'Total']"
      v-model:current-page="pageParam.pageNumber"
      v-model:page-size="pageParam.pageSize"
      :total="pageParam.totalCount"
      @page-change="handlePageChange">
    </vxe-pager>
    <el-dialog v-model="showView">
      <template #title>{{viewData.title}}</template>
      <div>{{viewData.content}}</div>
    </el-dialog>
  </div>
</template>

<script setup lang="ts">
import {onMounted, ref} from 'vue';
import {PageParam} from "@/api/table/types/page";
import {VxePagerEvents} from "vxe-table";
import {ArticleParam, ArticleWithOther} from "@/api/table/types/article";
import {deleteArticleApi, getArticleListApi} from "@/api/table/article";
import {User} from "@/api/table/types/user";
import {Category} from "@/api/table/types/category";
import {IMessage} from "@/utils/IMessage";
onMounted(() => {
  toGetTableData()
})

// 表格数据
const tableData = ref<ArticleWithOther[]>()
const queryParam = ref<ArticleParam>({
  author: "",
  title: "",
  category: ""
})
const pageParam = ref<PageParam>({
  pageSize: 19,
  pageNumber: 1,
  totalCount: 0
})
const toGetTableData = () => {
  const result = getArticleListApi(queryParam.value, pageParam.value)
  result.then((res) => {
    tableData.value = res.data.articleList
    pageParam.value.totalCount = res.data.articleCount
  }).catch(() => {
    tableData.value = []
    pageParam.value.totalCount = 0
  }).finally(() => {

  })
}
const handlePageChange: VxePagerEvents.PageChange = ({ currentPage, pageSize }) => {
  pageParam.value.pageNumber = currentPage
  pageParam.value.pageSize = pageSize
  toGetTableData()
}



// 表格查看

const selectRow = ref<ArticleWithOther>()
const showView = ref(false)
const viewData = ref<ArticleWithOther>({
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
const viewEvent = (row: ArticleWithOther) => {
  const result = new Promise((resolve, reject) => {
    viewData.value = row
    selectRow.value = row
    resolve('success')
  })
  result.then(() => {
    showView.value = true
  })

}
const removeEvent = (row: ArticleWithOther) => {
  const result = deleteArticleApi(row.id)
  result.then((res) => {
    if (res.code === 200) {
      IMessage.success(res.message)
    } else {
      IMessage.error(res.message)
    }
  })
  toGetTableData()
}
const cellDBLClickEvent = () => {
  
}
</script>

<style scoped>

</style>
