const sel1 = document.querySelector("#levCk");
const sel2 = document.querySelector("#genHere");
const levelRe  = document.getElementsByName("levRe")[0];
const genRe = document.getElementsByName("genRe")[0];
		
function level(){
		const child=sel1.children;
		//console.log(child[0],levelRe);
		if(child[0].value===levelRe.value){
		child[0].selected="selected";
		}else if(child[1].value===levelRe.value){
		child[1].selected="selected";
	}
}
		
function gender(){
	const child=sel2.children;

	if(child[0].value===genRe.value){
	child[0].selected="selected";
	}else if(child[1].value===genRe.value){
	child[1].selected="selected";
  }
}

function init(){
	level();
	gender();
}

init();