declare module "*.vue" {
  import { DefineComponent } from "vue"
  const component: DefineComponent<{}, {}, any>
  export default component
}

declare module "*.scss" {
  const scss: Record<string, string>
  export default scss
}
// src/typing/shims.d.ts
declare module '@kangc/v-md-editor/lib/theme/vuepress.js';

