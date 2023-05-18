<template>

  <el-card>
    <div v-if="user.id != -1">
      <el-form :model="user"
               class="Update-Form"
               label-position="right"
               label-width="100px"
               style="max-width: 460px"
      >
        <el-form-item label="用户名">
          <el-input v-model="user.username"/>
        </el-form-item>
        <el-form-item label="密码">
          <el-input v-model="user.password"/>
        </el-form-item>
        <el-form-item label="昵称">
          <el-input v-model="user.nickname"/>
        </el-form-item>
        <el-form-item label="简介">
          <el-input v-model="user.introduction"></el-input>
        </el-form-item>
        <el-form-item label="头像">
          <el-input v-model="user.avatar"></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="user.email"></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="user.email"></el-input>
        </el-form-item>
        <el-form-item label="邮箱">
          <el-input v-model="user.email"></el-input>
        </el-form-item>
        <el-form-item label="创建时间">
          <el-input v-model="user.createTime"></el-input>
        </el-form-item>
        <el-form-item label="最后登陆时间">
          <el-input v-model="user.lastLogin"></el-input>
        </el-form-item>
      </el-form>
    </div>
    <div v-else>
      未登录
    </div>
    <div style="padding: 14px">
      <div v-if="user.id === -1">
        <el-button class="button" text @click="handleLogin">登录</el-button>
        <el-button class="button" text @click="handleRegister">注册</el-button>
      </div>
      <div v-else>
        <el-button class="button" text @click="handleLogout">登出</el-button>
        <el-button class="button" text @click="handleUpdate">修改</el-button>
      </div>
    </div>


  </el-card>
  <el-dialog v-model="loginDialogVisible"
             class="Login-Dialog"
             title="登录"
             width="30%"
  >
    <el-form :model="userForm"
             class="Login-Form"
             label-position="right"
             label-width="100px"
             style="max-width: 460px"
    >
      <el-form-item label="用户名">
        <el-input v-model="userForm.username"/>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="userForm.password"/>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="confirmLogin">确定</el-button>
        <el-button type="primary" @click="cancelLogin">
          取消
        </el-button>
      </span>
    </template>
  </el-dialog>
  <el-dialog v-model="registerDialogVisible"
             class="Register-Dialog"
             title="注册"
             width="30%"
  >
    <el-form :model="userForm"
             class="Register-Form"
             label-position="right"
             label-width="100px"
             style="max-width: 460px"
    >
      <el-form-item label="用户名">
        <el-input v-model="userForm.username"/>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="userForm.password"/>
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="userForm.nickname"/>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="confirmRegister">确定</el-button>
        <el-button type="primary" @click="cancelRegister">
          取消
        </el-button>
      </span>
    </template>
  </el-dialog>
  <el-dialog v-model="updateDialogVisible"
             class="Register-Dialog"
             title="修改用户"
             width="30%"
  >
    <el-form :model="updateForm"
             class="Update-Form"
             label-position="right"
             label-width="100px"
             style="max-width: 460px"
    >
      <el-form-item label="用户名">
        <el-input v-model="updateForm.username"/>
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="updateForm.password"/>
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="updateForm.nickname"/>
      </el-form-item>
      <el-form-item label="简介">
        <el-input v-model="updateForm.introduction"></el-input>
      </el-form-item>
      <el-form-item label="头像">
        <el-input v-model="updateForm.avatar"></el-input>
      </el-form-item>
      <el-form-item label="邮箱">
        <el-input v-model="updateForm.email"></el-input>
      </el-form-item>
    </el-form>
    <template #footer>
      <span class="dialog-footer">
        <el-button @click="confirmUpdate">确定</el-button>
        <el-button type="primary" @click="cancelUpdate">
          取消
        </el-button>
      </span>
    </template>
  </el-dialog>
</template>

<script lang="ts" setup>
import {onMounted, ref} from 'vue';
import { register, update, login} from "@/api/user";
import {Result} from "@/Type/interface";
import {useUserStore} from "@/store";
import {AxiosResponse} from "axios";
import {User} from "@/Type/api/user";
import {ElMessage} from "element-plus";

const userStore = useUserStore();
const user = ref<User>({
  id: -1,
  username: "未登录",
  password: "未登录",
  nickname: "未登录",
  introduction: "",
  avatar: "未登录",
  email: "未登录",
  createTime: "未登录",
  lastLogin: "未登录",
  token: ""
})
const updateForm = ref<User>({
  id: -1,
  username: "",
  password: "",
  nickname: "未登录",
  introduction: "",
  avatar: "",
  email: "",
  createTime: "",
  lastLogin: "",
  token: ""
})

const userForm = ref({
  username: "",
  password: "",
  nickname: "",
})

// Login Dialog
const loginDialogVisible = ref(false)
const handleLogin = () => {
  loginDialogVisible.value = true;
}
const cancelLogin = () => {
  loginDialogVisible.value = false;
}
const confirmLogin = async () => {
  let loginResult = login(userForm.value);

  loginResult.then((res) => {
    userStore.user = res
    user.value = res
    loginDialogVisible.value = false

  }, (err) => {

  })
}

// Register Dialog
const registerDialogVisible = ref(false)
const handleRegister = () => {
  registerDialogVisible.value = true;
}
const cancelRegister = () => {
  registerDialogVisible.value = false;
}
const confirmRegister = () => {
  let registerResult = register(userForm.value);
  userForm.value = {
    username: "",
    password: "",
    nickname: "",
  }
  registerResult.then((res) => {
    userStore.user = res
    user.value = res
    registerDialogVisible.value = false
  }, (err) => {

  })
}

const handleLogout = () => {
  user.value = {
    id: -1,
    username: "",
    password: "",
    nickname: "未登录",
    introduction: "",
    avatar: "",
    email: "",
    createTime: "",
    lastLogin: "",
    token: ""
  }
  userStore.user = {
    id: -1,
    username: "",
    password: "",
    nickname: "未登录",
    introduction: "",
    avatar: "",
    email: "",
    createTime: "",
    lastLogin: "",
    token: ""
  }
}
// Update Dialog
const updateDialogVisible = ref(false)
const handleUpdate = () => {
  updateForm.value = JSON.parse(JSON.stringify(user.value))
  updateDialogVisible.value = true;

}
const confirmUpdate = () => {
  const result = update(updateForm.value)
  result.then(async (res) => {
    userForm.value.username = updateForm.value.username
    userForm.value.password = updateForm.value.password
    updateDialogVisible.value = false;
    let loginResult = await userLogin(userForm.value);
    userStore.user = loginResult
    user.value = loginResult
  })
}
const cancelUpdate = () => {
  updateDialogVisible.value = false;
}
onMounted(async () => {
  if (userStore.user != undefined && userStore.user.id != -1 && userStore.user.id != undefined) {

    userForm.value.username = userStore.user.username
    userForm.value.password = userStore.user.password

    let loginResult = await userLogin(userForm.value);
    userStore.user = loginResult
    user.value = loginResult
  }
  if (userForm.value.username != undefined && userForm.value.password != undefined) {
    ElMessage.error("登陆失败")
  }

})

</script>

<style scoped>

</style>
