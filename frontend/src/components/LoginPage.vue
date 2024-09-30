<template>
    <div class="container">
        <h2>Login</h2>
        <form @submit.prevent="handleSubmit">
            <div class="form-group">
                <label for="username">Username</label>
                <input
                    v-model="username"
                    type="text"
                    class="form-control"
                    id="username"
                    required
                />
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input
                    v-model="password"
                    type="password"
                    class="form-control"
                    id="password"
                    required
                />
            </div>
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>
</template>

<script>
export default {
    name: "LoginPage",
    data() {
        return {
            username: "",
            password: "",
        };
    },
    methods: {
        handleSubmit() {
            const loginData = {
                username: this.username,
                password: this.password,
            };
            console.log("Login data:", loginData);
            this.$router.push({ name: "admin" }); // 로그인 후 admin 페이지로 이동
        },
    },
};
</script>

<style scoped>
.container {
    margin-top: 50px;
}
</style>
