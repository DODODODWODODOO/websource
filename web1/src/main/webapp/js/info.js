// submit 클릭 시
// 값이 비어 있지않도록 처리
// age는 숫자인지 확인
const form = document.querySelector("form");
form.addEventListener("submit", (e) => {
  e.preventDefault(); // submit 중지

  const id = document.querySelector("#id");
  const name = document.querySelector("#name");
  const age = document.querySelector("#age");

  if (!id.value) {
    alert("아이디를 확인해 주세요");
    id.focus();
    return;
  } else if (!name.value) {
    alert("이름을 확인해 주세요");
    name.focus();
    return;
  } else if (!age.value || isNaN(age.value)) {
    alert("나이를 확인해 주세요");
    age.focus();
    return;
  }

  // 검증 완료 후 폼 submit 실행
  form.submit();
});
