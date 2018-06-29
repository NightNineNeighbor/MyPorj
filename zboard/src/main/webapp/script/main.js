history.pushState(null, null, location.href);
window.onpopstate = function(event) {
	history.go(1);
};
function noEvent() { // 새로 고침 방지
	if (event.keyCode == 116) {
		alert("새로고침을 할 수 없습니다.");
		event.keyCode = 2;
		return false;
	} else if (event.ctrlKey && (event.keyCode == 78 || event.keyCode == 82)) {
		return false;
	}
}
document.onkeydown = noEvent;
