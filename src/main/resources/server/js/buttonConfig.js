var buttons = document.querySelectorAll('button');
buttons.forEach(function(button) {
    button.addEventListener('click', function() {
        if (ws.readyState === WebSocket.OPEN) {
            ws.send(button.id);
            console.log('Message sent: ' + button.id);
        } else {
            console.log('WebSocket is not open.');
        }
    });
});
fetch('../config.json').then(response => response.json()).then(data => {
    for (var buttonId in data.buttons) {
        var divbutton = document.querySelector('#' + buttonId);
        var buttonText = data.buttons[buttonId].text;
        divbutton.querySelector('.buttontext p').innerText = buttonText;
        var imageURL = data.buttons[buttonId].image;
        divbutton.style.backgroundImage = "url('" + imageURL + "')";
        divbutton.style.backgroundSize = "contain";
        divbutton.style.backgroundRepeat = "no-repeat";
        divbutton.style.backgroundPosition = "50%";
    }
}).catch(error => console.error('Error loading JSON:', error));
