import {ElMessage} from "element-plus";
import lodash from "lodash-es";

export const IMessage = {
  success: (...message: string[]) => {
    let str = lodash.join(message)
    ElMessage({
      type: "success",
      message: str,
      customClass: "ElMessage-Z"
    })
  },
  info: (...message: string[]) => {
    let str = lodash.join(message)
    ElMessage({
      type: "info",
      message: str,
      customClass: "ElMessage-Z"
    })
  },
  warning: (...message: string[]) => {
    let str = lodash.join(message)
    ElMessage({
      type: "warning",
      message: str,
      customClass: "ElMessage-Z"
    })
  },
  error: (...message: string[]) => {
    let str = lodash.join(message)
    ElMessage({
      type: "error",
      message: str,
      customClass: "ElMessage-Z"
    })
  }
}
