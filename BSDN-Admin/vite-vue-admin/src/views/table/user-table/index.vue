<template>
  <div style="height: 99%">

    <vxe-table
      ref="xTable"
      :column-config="{resizable: true}"
      :data="tableData"
      :row-config="{height: 99.5, isHover: true}"
      border
      height="95%"
      show-overflow
      @cell-dblclick="cellDBLClickEvent">
      <vxe-column type="seq" width="60"></vxe-column>
      <vxe-column field="username" title="用户名"></vxe-column>
      <vxe-column field="password" title="密码"></vxe-column>
      <vxe-column field="nickname" title="昵称"></vxe-column>
      <vxe-column field="introduction" title="简介"></vxe-column>
      <vxe-column field="email" title="电子邮箱"></vxe-column>
      <vxe-column field="avatar" title="头像" width="120">
        <template #default="{ row }">
          <img v-if="row.avatar" :src="row.avatar" style="width: 100px;">
          <span v-else>无</span>
        </template>
      </vxe-column>
      <vxe-column field="lastLogin" title="最后登录时间"></vxe-column>
      <vxe-column field="createTime" title="创建时间"></vxe-column>
      <vxe-column show-overflow title="编辑" width="100">
        <template #default="{ row }">
          <vxe-button icon="vxe-icon-edit" type="text" @click="editEvent(row)"></vxe-button>
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

    <vxe-modal v-model="showEdit" destroy-on-close min-height="300" min-width="600" resize title="编辑信息" width="800">
      <template #default>
        <vxe-form :data="editData" title-align="right" title-width="100" @submit="submitEvent">
          <vxe-form-item :item-render="{}" :span="12" field="username" title="用户名">
            <template #default="{ data }">
              <vxe-input v-model="data.username" placeholder="请输入用户名"></vxe-input>
            </template>
          </vxe-form-item>
          <vxe-form-item :item-render="{}" :span="12" field="password" title="密码">
            <template #default="{ data }">
              <vxe-input v-model="data.password" placeholder="请输入密码"></vxe-input>
            </template>
          </vxe-form-item>
          <vxe-form-item :item-render="{}" :span="12" field="nickname" title="昵称">
            <template #default="{ data }">
              <vxe-input v-model="data.nickname" placeholder="请输入昵称"></vxe-input>
            </template>
          </vxe-form-item>
          <vxe-form-item :item-render="{}" :span="12" field="introduction" title="简介">
            <template #default="{ data }">
              <vxe-input v-model="data.introduction" placeholder="请输入简介"></vxe-input>
            </template>
          </vxe-form-item>
          <vxe-form-item :item-render="{}" :span="12" field="email" title="电子邮箱">
            <template #default="{ data }">
              <vxe-input v-model="data.email" placeholder="请输入电子邮箱"></vxe-input>
            </template>
          </vxe-form-item>
          <vxe-form-item :item-render="{}" :span="12" field="avatar" title="头像">
            <template #default="{ data }">
              <vxe-input v-model="data.avatar" placeholder="请输入头像"></vxe-input>
            </template>
          </vxe-form-item>
          <vxe-form-item :item-render="{}" :span="12" field="lastLogin" title="最后登录时间">
            <template #default="{ data }">
              <vxe-input v-model="data.lastLogin" placeholder="请输入最后登录时间"></vxe-input>
            </template>
          </vxe-form-item>
          <vxe-form-item :item-render="{}" :span="12" field="createTime" title="创建时间">
            <template #default="{ data }">
              <vxe-input v-model="data.createTime" placeholder="请输入创建时间"></vxe-input>
            </template>
          </vxe-form-item>
          <vxe-form-item :span="24" align="center" title-align="left">
            <template #default>
              <vxe-button type="submit">提交</vxe-button>
              <vxe-button type="reset">重置</vxe-button>
            </template>
          </vxe-form-item>
        </vxe-form>
      </template>
    </vxe-modal>
  </div>
</template>

<script lang="ts" setup>
import {onMounted, ref} from 'vue';
import {VxeColumnPropTypes, VxeFormItemPropTypes, VxePagerEvents, VxeTableInstance} from "vxe-table";
import {User, UserParam} from "@/api/table/types/user";
import {getUserListApi, updateUserApi} from "@/api/table/user";
import {PageParam} from "@/api/table/types/page";
import {ElMessage} from "element-plus";
import {reject} from "lodash-es";
import {IMessage} from "@/utils/IMessage";

onMounted(() => {
  toGetTableData()
})
// 表格数据
const tableData = ref<User[]>()
const queryParam = ref<UserParam>({
  username: "",
  nickname: "",
  email: ""
})
const pageParam = ref<PageParam>({
  pageSize: 7,
  pageNumber: 1,
  totalCount: 0
})
const toGetTableData = () => {
  const result = getUserListApi(queryParam.value, pageParam.value)
  result.then((res) => {
    tableData.value = res.data.userList
    pageParam.value.totalCount = res.data.userCount
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

// 编辑表格
const selectRow = ref<User>()
const showEdit = ref(false)
const editData = ref<User>({
  id: 0,
  username: "",
  password: "",
  nickname: "",
  introduction: "",
  avatar: "",
  email: "",
  createTime: "",
  lastLogin: ""
})
const editEvent = (row: User) => {
  Object.assign(editData.value, row)
  selectRow.value = row
  showEdit.value = true
}
const submitEvent = () => {
  const result = updateUserApi(editData.value)
  /*const result2 = result.then((res) => {
    return new Promise((resolve, reject) => {
      if (res.code === 200) {
        resolve("我是来自result的第一次状态判断resolve")
      } else {
        reject("我是来自result的第一次状态判断reject")
      }
    })
  })
  result2.then((res) => {
    console.log("这是result的第二次状态判断，状态为resolve" + "，上一次的判断结果是")
    console.log(res)
  }, (err) => {
    console.log("这是result的第二次状态判断，状态为reject" + "，上一次的判断结果是")
    console.log(err)
  })*/
  result.then((res) => {
    if (res.code === 200) {
      console.log("200")
      IMessage.success(res.message)
      showEdit.value = false
    } else {
      IMessage.error(res.message)
    }
  }).then(() => {
    toGetTableData()
  })
}

const cellDBLClickEvent = () => {

}

const removeEvent = (row: any) => {

}
const xTable = ref<VxeTableInstance>()

const formatterSex: VxeColumnPropTypes.Formatter = ({cellValue}) => {
  return ""
}

const visibleMethod: VxeFormItemPropTypes.VisibleMethod = ({data}) => {
  return false
}

</script>

<style scoped>

</style>
