<template>
    <div>
        <vxe-table
                ref="xTable"
                :column-config="{resizable: true}"
                :data="tableData"
                :row-config="{height: 41, isHover: true}"
                border
                height="91%"
                show-overflow
        >
            <vxe-column type="seq" width="60"></vxe-column>
            <vxe-column field="categoryName" title="分类名称"></vxe-column>
            <vxe-column field="description" title="分类详情"></vxe-column>
            <vxe-column show-overflow title="编辑" width="100">
                <template #default="{ row }">
                    <vxe-button icon="vxe-icon-file-markdown" type="text" @click="viewEvent(row)"></vxe-button>
                    <vxe-button icon="vxe-icon-delete" type="text" @click="removeEvent(row)"></vxe-button>
                </template>
            </vxe-column>

        </vxe-table>
        <div style="display: flex">
            <el-input v-model="addParam.categoryName" placeholder="分类名称"></el-input>
            <el-input v-model="addParam.description" placeholder="分类描述">分类描述</el-input>
            <el-button @click="toAddCategory">添加分类</el-button>
        </div>
        <vxe-pager
                v-model:current-page="pageParam.pageNumber"
                v-model:page-size="pageParam.pageSize"
                :layouts="['PrevJump', 'PrevPage', 'Number', 'NextPage', 'NextJump', 'FullJump', 'Total']"
                :total="pageParam.totalCount"
                @page-change="handlePageChange">
        </vxe-pager>
    </div>
</template>

<script lang="ts" setup>
import {onMounted, ref} from 'vue';
import {PageParam} from "@/api/table/types/page";
import {Category, CategoryParam} from "@/api/table/types/category";
import {addCategoryApi, deleteCategoryApi, getCategoryListApi} from "@/api/table/category";
import {VxePagerEvents} from "vxe-table";
import {IMessage} from "@/utils/IMessage";


onMounted(() => {
    toGetTableData()
})
const tableData = ref<Category[]>()
const pageParam = ref<PageParam>({
    pageSize: 10,
    pageNumber: 1,
    totalCount: 0
})
const queryParam = ref<CategoryParam>({
    categoryName: "",
    description: "",
})
const addParam = ref<CategoryParam>({
    categoryName: "",
    description: ""

})
const toGetTableData = () => {
    const result = getCategoryListApi(queryParam.value, pageParam.value);
    result.then((res) => {
        tableData.value = res.data.categoryList
        pageParam.value.totalCount = res.data.categoryCount
    })
}
const toAddCategory = () => {
    const result = addCategoryApi(addParam.value)
    result.then((res) => {
        IMessage.success(res.message)
        toGetTableData()
    })
}
const toDeleteCategory = (row: Category) => {
    const result = deleteCategoryApi(row)
    result.then((res) => {
        IMessage.success(res.message)
        toGetTableData()
    })
}
const viewEvent = (row: Category) => {

}
const removeEvent = (row: Category) => {
    toDeleteCategory(row)

}
const handlePageChange: VxePagerEvents.PageChange = ({currentPage, pageSize}) => {
    pageParam.value.pageNumber = currentPage
    pageParam.value.pageSize = pageSize
    toGetTableData()
}
</script>

<style scoped>

</style>
