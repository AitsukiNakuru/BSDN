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
        <el-button text class="button">登出</el-button>
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
             v-model="reigsterDialogVisible"
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
import {userLogin} from "@/api/user";
import {Result} from "@/Type/interface";
import {useUserStore} from "@/store";
import {AxiosResponse} from "axios";
import {User} from "@/Type/api/user";

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
  console.log("confirm")
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

}

onMounted(async () => {
  userForm.value.username = userStore.user.username
  userForm.value.password = userStore.user.password
  if (userForm.value.username != undefined && userForm.value.password != undefined) {
    let loginResult = await userLogin(userForm.value);
    userStore.user = loginResult
    user.value = loginResult
  }

})

</script>

<style scoped>

</style>
