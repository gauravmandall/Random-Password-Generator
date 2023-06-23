<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Random Password Generator</title>
</head>
<body>
<h1>Random Password Generator</h1>
<form action="GeneratePassword" method="post">
    <p>Password length: <input type="number" name="length" min="8" max="32" value="10"></p>
    <p>Include uppercase letters: <input type="checkbox" name="uppercase" checked></p>
    <p>Include lowercase letters: <input type="checkbox" name="lowercase" checked></p>
    <p>Include digits: <input type="checkbox" name="digits" checked></p>
    <p>Include special characters: <input type="checkbox" name="special"></p>
    <p><input type="submit" value="Generate"></p>
</form>
</body>
</html>
