/**
 * 
 */
//const reg=document.querySelector("#reg");
const userId = document.querySelector("#userId");
const pwd = document.querySelector("#pwd");

function validate(){
	if(userId.value === null || userId.value.length===0){
		alert(`필수 입력 항목(아이디)을 입력해주세요`);
		userId.focus();
		return false;
	}
	if(pwd.value === null || pwd.value.length===0){
		alert(`필수 입력 항목(비밀번호)을 입력해주세요`);
		pwd.focus();
		return false;
	}
	
	return true;
}
