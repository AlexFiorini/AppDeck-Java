document.getElementById('qrcodebutton').addEventListener('click', function() {
    document.getElementById('qrcodeOverlay').style.display = 'block';
});
document.getElementById('qrcodeOverlay').addEventListener('click', function() {
    document.getElementById('qrcodeOverlay').style.display = 'none';
});
