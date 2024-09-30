const { defineConfig } = require("@vue/cli-service");
module.exports = defineConfig({
    transpileDependencies: true,
    outputDir: "../resources/static", // Build Directory
    // 개발 서버 설정
    devServer: {
        port: 8083,
        proxy: {
            "/api": {
                target: "http://localhost:8082", // Spring Boot 서버 주소
                changeOrigin: true, // CORS 문제 해결을 위해 origin 변경 허용
                pathRewrite: { "^/api": "" }, // 필요에 따라 경로 재작성 설정 가능
            },
        },
    },
});
