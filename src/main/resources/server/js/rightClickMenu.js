var a = document.getElementsByTagName('button');
for (let i = 0; i < a.length; i++) {
    var element = a[i];
    element.onclick = hideRMBMenu;
    element.oncontextmenu = function(e) { rightClick(e, a[i]); };
}
function hideRMBMenu() {
    document.getElementById("contextMenu").style.display = "none";
}
function rightClick(e, a) {
    e.preventDefault();
    if (document.getElementById("contextMenu").style.display == "block") hideRMBMenu();
    else {
        var menu = document.getElementById("contextMenu");
        buttonToModify = a;
        menu.style.display = 'block';
        menu.style.left = e.pageX + "px";
        menu.style.top = e.pageY + "px";
    }
}
