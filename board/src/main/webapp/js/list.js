// page 영역 가져오기
const pagination = document.querySelector(".pagination");
const actionForm = document.querySelector("#actionForm");

// console.log(pagination);

// 세글 작성 클릭시 a 태그 기능 중지
// actionForm 안에 page=1, criteria="", keyword="" 변경 후
// actionForm.submit()
document.querySelector(".btn-success").addEventListener("click", (e) => {
  e.preventDefault();

  actionForm.querySelector('[name="page"]').value = 1;
  actionForm.querySelector('[name="criteria"]').value = "";
  actionForm.querySelector('[name="keyword"]').value = "";

  actionForm.action = "/view/qna_board_write.jsp";
  actionForm.submit();
});

// 제목 클릭 시 a태그 기능중지
// href 가져오기
// actionForm 안에 bno 태그 추가
// actionForm.action = "/qCount.do" 변경
const moves = document.querySelectorAll(".move");

moves.forEach((move) => {
  move.addEventListener("click", (e) => {
    e.preventDefault();
    const href = e.target.getAttribute("href");

    const element = `<input type="hidden" name="bno" value="${href}">`;
    actionForm.insertAdjacentHTML("beforeend", element);

    actionForm.action = "/qCount.do";

    console.log(actionForm);
    actionForm.submit();
  });
});

pagination.addEventListener("click", (e) => {
  // 하단의 번호 클릭 시 a 태그 기능 중지
  e.preventDefault();

  // 태그 속성 값 가져오기
  // img.src or img.getAttribute("src")
  console.log(e.target.href); // 찾은태그.속성명
  console.log(e.target.getAttribute("href"));

  // a 태그의 href 속성 값 가져오기
  const href = e.target.getAttribute("href");

  // 가져온 값 actionForm 의 page value 값으로 변경
  actionForm.querySelector('[name="page"]').value = href;

  console.log(actionForm);
  actionForm.submit();
});

// 사용자가 목록 개수 변경 시 목록 값 가져온 후
// actionForm 의 amount 값 변겅 후 actionForm 전송
document.querySelector('select[name="amount"]').addEventListener("change", (e) => {
  actionForm.querySelector('[name="amount"]').value = e.target.value;
  actionForm.submit();
});

// 검색 폼
// criteria, keyword 비어 있는지 확인
document.querySelector('[name="search"]').addEventListener("submit", (e) => {
  e.preventDefault();

  const criteria = document.querySelector('[name="criteria"]');
  const keyword = document.querySelector('[name="keyword"]');
  // 검색하는 경우에는 첫 페이지 보여주기
  document.querySelector('[name="page"]').value = 1;

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
