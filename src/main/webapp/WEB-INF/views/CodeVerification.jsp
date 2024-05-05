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
    <link rel="stylesheet" href="./css/codeverify.css">
    <title>verify code</title>
</head>
<body>
 <div class="template">
         <div class="head">
          Verify Code
         </div>
         <div class="form">
           <form action="verify" method="post">
             <label for="Email">Email</label> <br>
             <input type="text" name="Email" value="${Email_Id}" autocomplete="off" required disabled><br>
             <label for="code">Code</label><br>
             <input type="text" name="code" autocomplete="off" required><br>
             <button>Submit</button>
           </form>
         </div>
         <div class="links">
            <a href="forgotpassword">Back</a>
            <a href="register">New Register</a>
         </div>
     </div>
</body>
</html>