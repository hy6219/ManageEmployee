/**
 * 
 */
const access1 = document.querySelector("#access1");
const access2 = document.querySelector("#access2");

//마이페이지
function accessCk(){
	alert(`로그인 후 사용가능합니다!`);
	return false;
}


access1.addEventListener("click",accessCk);
access2.addEventListener("click",accessCk);