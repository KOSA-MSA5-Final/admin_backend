// 이미지 URL 추가 기능
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('addImageButton').addEventListener('click', function() {
        console.log("버튼 눌림");
        const imageUrlInput = document.getElementById('productImageUrl');
        const imageUrl = imageUrlInput.value.trim();

        // URL이 비어있지 않은 경우에만 추가
        if (imageUrl) {
            // 리스트에 추가
            const imageUrlList = document.getElementById('imageUrlList');
            const listItem = document.createElement('li');
            listItem.className = 'list-group-item';
            listItem.textContent = imageUrl;
            imageUrlList.appendChild(listItem);

            // 입력 필드 비우기
            imageUrlInput.value = '';

            // 추가된 URL을 숨겨진 필드에 저장
            const hiddenImageUrls = document.getElementById('hiddenImageUrls');
            const existingUrls = hiddenImageUrls.value ? hiddenImageUrls.value.split(',') : [];
            existingUrls.push(imageUrl);
            hiddenImageUrls.value = existingUrls.join(',');
        }
    });
});