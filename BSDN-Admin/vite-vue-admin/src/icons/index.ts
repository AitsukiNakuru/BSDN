import { type App } from "vue"
import SvgIcon from "@/components/SvgIcon/index.vue" // Svg Component
import "virtual:svg-icons-register"

export function loadSvg(app: App) {
  // 将SvgIcon注册到app中
  app.component("SvgIcon", SvgIcon)
  //app.component("svg-icon", SvgIcon)
}
