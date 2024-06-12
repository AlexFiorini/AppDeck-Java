var ws = new WebSocket('ws://' + window.location.hostname + ':32424/websocket');
ws.onopen = function() {
    console.log('WebSocket connection established');
};
ws.onmessage = function(event) {
    console.log('Received message: ' + event.data);
};
ws.onclose = function(event) {
    console.log('WebSocket connection closed');
    console.log('Code: ' + event.code + ', Reason: ' + event.reason);
};
ws.onerror = function(event) {
    console.error('WebSocket error:', event);
};
