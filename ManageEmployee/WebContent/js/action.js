/**
 * 
 */
const lev = document.querySelector("input[type=hidden]");
const levBtn = document.querySelector("#regEmp");


//사원등록 접근 제한
function checkPriv(){
	const priv = lev.value;
	if(priv ==="A"){
		//관리자인 경우
		location.href="custom.do";
	}else{
		//사용자인 경우
		alert(`관리자만 사용가능합니다!`);
		return false;
	}
}

levBtn.addEventListener("click",checkPriv);