// page 영역 가져오기
const pagination = document.querySelector(".pagination");
console.log(pagination);

// 검색 폼
// criteria, keyword 비어 있는지 확인
document.querySelector('[name="search"]').addEventListener("submit", (e) => {
  e.preventDefault();

  const criteria = document.querySelector('[name="criteria"]');
  const keyword = document.querySelector('[name="keyword"]');

  if (criteria.value == "n") {
    alert("검색 조건을 선택하세요");
    criteria.focus();
    return;
  } else if (!keyword.value) {
    alert("검색어를 입력하세요");
    keyword.focus();
    return;
  }
  e.target.submit();
});
