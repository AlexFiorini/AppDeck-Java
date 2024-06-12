function openFullscreen(elem) {
    if (elem.requestFullscreen) {
        elem.requestFullscreen();
    } else if (elem.webkitRequestFullscreen) {
        elem.webkitRequestFullscreen();
    } else if (elem.msRequestFullscreen) {
        elem.msRequestFullscreen();
    }
}
document.addEventListener('DOMContentLoaded', function() {
    document.addEventListener('click', function() {
        var elem = document.documentElement;
        openFullscreen(elem);
    });
});
