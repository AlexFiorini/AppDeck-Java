<?php
if ($argc < 2) {
    http_response_code(400);
    echo json_encode(array('error' => 'No data passed'));
    exit;
}

$inputJson = $argv[1];
$inputJson = preg_replace('/:(?=\s*,)/', ':""', $inputJson);
$inputJson = preg_replace('/([{,])(\s*)(\w+)(\s*):/', '$1"$3":', $inputJson);
$inputJson = preg_replace('/:(\s*)([A-Za-z0-9\/\.\-\:_]+)(\s*[,}])/', ':"$2"$3', $inputJson);
$inputJson = preg_replace('/"text":,/', '"text":"",', $inputJson);
$inputJson = preg_replace('/"image":,/', '"image":"",', $inputJson);
$inputJson = preg_replace('/"action":,/', '"action":"",', $inputJson);
$inputJson = preg_replace('/"path":}/', '"path":""}', $inputJson);
$inputArray = json_decode($inputJson, true);

if ($inputArray === null) {
    http_response_code(400);
    echo json_encode(array('error' => 'Invalid JSON'));
    exit;
}

// Convert the array to the desired format
$outputArray = [
    'buttonId' => $inputArray['buttonId'],
    'config' => [
        'text' => $inputArray['config']['text'] ?? "",
        'image' => $inputArray['config']['image'] ?? "",
        'action' => $inputArray['config']['action'],
        'path' => $inputArray['config']['path'] ?? ""
    ]
];

$data = json_encode($outputArray, JSON_PRETTY_PRINT);
$data = json_decode($data, true);

if (isset($data['buttonId']) && isset($data['config'])) {
    $configFilePath = __DIR__ . '/../../config.json';
    $config = json_decode(file_get_contents($configFilePath), true);

    if ($config === null) {
        http_response_code(500);
        echo json_encode(array('error' => 'Failed to decode config.json'));
        exit;
    }

    $buttonId = $outputArray['buttonId'];
    $config['buttons'][$buttonId] = $outputArray['config'];

    if (!file_put_contents($configFilePath, json_encode($config, JSON_PRETTY_PRINT))) {
        http_response_code(500);
        echo json_encode(array('error' => 'Failed to write to config.json'));
        exit;
    }

    echo json_encode(array('message' => 'Configuration updated successfully'));

} else {
    echo json_encode(array('error' => 'Invalid data'));
}
