<template>
    <div id="app">
        <div class="container">
            <router-view />
            <!-- 라우팅된 컴포넌트를 이곳에 렌더링 -->
        </div>
    </div>
</template>

<script>
export default {
    name: "App",
};
</script>

<style>
#app {
    font-family: Avenir, Helvetica, Arial, sans-serif;
    -webkit-font-smoothing: antialiased;
    -moz-osx-font-smoothing: grayscale;
    text-align: center;
    color: #2c3e50;
    margin-top: 60px;
}
</style>
