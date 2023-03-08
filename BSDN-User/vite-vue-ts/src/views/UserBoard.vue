<template>
  <div>UserBoard.vue</div>
  <el-card>
    <div>头像</div>
    <div>昵称</div>
    <div>{{ user }}</div>
    <div style="padding: 14px">
      <div v-if="user.id === -1">
        <el-button text class="button" @click="handleLogin">登录</el-button>
        <el-button text class="button" @click="handleRegister">注册</el-button>
      </div>
      <div v-else>
        <el-button text class="button" @click="handleLogout">登出</el-button>
      </div>
    </div>


  </el-card>
  <el-dialog class="Login-Dialog"
             v-model="loginDialogVisible"
             title="登录"
             width="30%"
  >
    <el-form class="Login-Form"
             label-position="right"
             label-width="100px"
             :model="userForm"
             style="max-width: 460px"
    >
      <el-form-item label="用户名">
        <el-input v-model="userForm.username" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="userForm.password" />
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
  <el-dialog class="Register-Dialog"
             v-model="registerDialogVisible"
             title="注册"
             width="30%"
  >
    <el-form class="Register-Form"
             label-position="right"
             label-width="100px"
             :model="userForm"
             style="max-width: 460px"
    >
      <el-form-item label="用户名">
        <el-input v-model="userForm.username" />
      </el-form-item>
      <el-form-item label="密码">
        <el-input v-model="userForm.password" />
      </el-form-item>
      <el-form-item label="昵称">
        <el-input v-model="userForm.nickname" />
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
</template>

<script setup lang="ts">
import {onMounted, ref} from 'vue';
import {userLogin, userRegister} from "@/api/user";
import {Result} from "@/Type/interface";
import {useUserStore} from "@/store";
import {AxiosResponse} from "axios";
import {User} from "@/Type/api/user";
import {ElMessage} from "element-plus";

const userStore = useUserStore();
const user = ref<User>({
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
  let loginResult = userLogin(userForm.value);

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
  console.log("register")
  let registerResult = userRegister(userForm.value);
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

onMounted(async () => {
  if (userStore.user != undefined && userStore.user.id != -1 && userStore.user.id != undefined) {

    userForm.value.username = userStore.user.username
    userForm.value.password = userStore.user.password

    let loginResult = await userLogin(userForm.value);
    userStore.user = loginResult
    user.value = loginResult
  }
  if (userForm.value.username != undefined && userForm.value.password != undefined) {

  }

})

</script>

<style scoped>

</style>
