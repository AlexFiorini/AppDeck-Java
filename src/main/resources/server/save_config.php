<?php
    if ($_SERVER['REQUEST_METHOD'] == 'POST') {
        $json = $_POST['json'];
        file_put_contents('config.json', $json);
    }
?>