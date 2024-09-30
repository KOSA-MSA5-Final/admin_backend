import { createApp } from "vue";
import App from "./App.vue";
import router from "@/routes/index"; // routes 폴더에서 index.js 가져오기
import axios from "axios";
import { register } from "swiper/element/bundle";
import { createPinia } from "pinia";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap-vue-next/dist/bootstrap-vue-next.css"; // BootstrapVue 스타일
import VueTypewriterEffect from "vue-typewriter-effect";

register();

// axios 전역 설정
axios.defaults.baseURL = "/api"; // 프록시를 통해 백엔드와 통신
axios.defaults.withCredentials = true; // 쿠키 전송 설정

const app = createApp(App);
const pinia = createPinia();

// 글로벌 axios 등록
app.config.globalProperties.$axios = axios;

// Pinia 상태 관리 라이브러리 사용
app.use(pinia);

// Vue Router 등록
app.use(router);

// Vue Typewriter Effect 등록
app.component("vue-typewriter-effect", VueTypewriterEffect);

// 애플리케이션 마운트
app.mount("#app");
