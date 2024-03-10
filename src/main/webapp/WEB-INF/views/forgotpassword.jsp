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
    <title>Document</title>
    <link rel="stylesheet" href="/css/forgotpassword.css">
</head>
<body>
    <div class="temp">
        <b>Re-Verification</b>
        <div class="form_details">
            <form action="Passreset" method="post">
                <p>*To access the account you have to verify with Eamil Id </p>
                <label for="Email_Id">Email Id or User Name</label><br>
                <input type="text" name="Email_Id"  autocomplete="off" required value=${Email_Id} ><br>
                <button>Send</button><br><br>
                </form>

        </div>
        <div class="content" style="color: rgb(237, 237, 237); text-align: left;">
            Go back to <a href="Login"> Login </a> Page
        </div>
    </div>
</body>
</html>
