import { createRouter, createWebHistory } from "vue-router";
import LoginPage from "../components/LoginPage.vue";
import AdminPage from "../components/AdminPage.vue";

const routes = [
    {
        path: "/",
        name: "login",
        component: LoginPage, // 로그인 페이지 경로 설정
    },
    {
        path: "/admin",
        name: "admin",
        component: AdminPage, // 로그인 페이지 경로 설정
    },
];

const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes,
});

export default router;
