<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Expires" content="0">
    <title>verify code</title>
    <link rel="stylesheet" href="/css/register.css">
</head>
<body>
 <div class="temp">
     <div class="form">
        <form action="/verify" method="post">
        <label for="email">Email Id
        <input type="text" name="email" value=${Email_Id}   disabled>
        <lable for="code">
        <input type="text" name="code"  autocomplete="off" required>
        <button>Submit</button>
        </form>
     <div>
 </div>
</body>
</html>