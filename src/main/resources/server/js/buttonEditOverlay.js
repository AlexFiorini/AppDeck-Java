document.getElementById('modificaBottone').addEventListener('click', function() {
    hideRMBMenu();
    openButtonEditOverlay();
});
document.getElementById('resettaBottone').addEventListener('click', function() {
    var buttonId = buttonToModify.id;
    creaQueryBottone(buttonId, null, null, null);
    hideRMBMenu();
});
document.addEventListener('click', function() {
    hideRMBMenu();
});
function openButtonEditOverlay() {
    var overlay = document.getElementById('buttonEditOverlay');
    overlay.style.display = 'block';

    fetch('../config.json').then(response => response.json()).then(data => {
        for (var buttonId in data.buttons) {
            if(buttonId == buttonToModify.id) {
                document.getElementById('buttonAction').value = data.buttons[buttonId].action;
                document.getElementById('buttonPreviewText').value = data.buttons[buttonId].text;
                document.getElementById('buttonPreviewImageUrl').value = data.buttons[buttonId].image;
                updateImagePrewiew();
                updateTextPreview();
                break;
            }
        }
    }).catch(error => console.error('Error loading JSON:', error));
}
document.getElementById('saveButtonEdit').addEventListener('click', function() {
    var azione = document.getElementById('buttonAction').value;
    var buttonText = document.getElementById('buttonPreviewText').value;
    var buttonImageUrl = document.getElementById('buttonPreviewImageUrl').value;
    var buttonId = buttonToModify.id;

    creaQueryBottone(buttonId, buttonText, buttonImageUrl, azione);
    var bottone = document.getElementById(buttonId);
    bottone.getElementsByClassName('buttontext')[0].getElementsByTagName('p')[0].innerHTML = buttonText;
    bottone.style.backgroundImage = "url('" + buttonImageUrl + "')";

    // Hide the button edit overlay after saving
    document.getElementById('buttonEditOverlay').style.display = 'none';
});
document.getElementById('buttonPreviewText').addEventListener('input', updateTextPreview);
document.getElementById('buttonPreviewImageUrl').addEventListener('input', updateImagePrewiew);
function updateTextPreview() {
    var newText = document.getElementById('buttonPreviewText').value;
    document.getElementById('preview-button-text').innerHTML = newText;
}
function updateImagePrewiew() {
    var linkImage = document.getElementById('buttonPreviewImageUrl').value;
    var divbutton = document.getElementById('preview-button');
    var url = "url('" + linkImage + "')";
    divbutton.style.backgroundImage = url;
    divbutton.style.backgroundSize = "contain";
    divbutton.style.backgroundRepeat = "no-repeat";
    divbutton.style.backgroundPosition = "50%";
}
function creaQueryBottone(buttonId, buttonText, buttonImageUrl, azione) {
    var buttonId = buttonToModify.id;

    var payload = {
        "buttonId": buttonId,
        "config": {
            "text": buttonText || "",
            "image": buttonImageUrl || "",
            "action": azione || "",
            "path": ""
        }
    };

    // Send the updated configuration to the server-side script
    fetch('save_config.php', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(payload)
    })
    .then(response => {
        if (response.ok) {
            console.log('Configuration saved successfully');
        } else {
            console.error('Failed to save configuration');
        }
    })
    .catch(error => console.error('Error saving configuration:', error));
}