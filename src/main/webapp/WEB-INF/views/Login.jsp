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
    <link rel="stylesheet" href="/css/login.css">
</head>
<body>

  <!--  <div class="image">
        <img src="/images/login.png" alt="user logo security pic">
    </div> -->
    <div class="temp">
        <div class="context">
            <b>Login</b>
        </div>


        <div class="form_details">
                <!-- <div class="input_logo1">
                     <img src="/images/user_loog.png">
                  </div>
                   <div class="input_logo2">
                        <img src="/images/password_logo.jpg">
                     </div> -->
               <form action="/submit" method="post">
                   <label for="User_Name" >User Name </label><br>
                   <input type="text" name="User_Name" value=" User Name" onclick="clearInput(this)" autocomplete="off" required><br>
                      <% String req=(String)session.getAttribute("name");
                      System.out.println("the error is grabed"+req);
                     if(req!=null && req.equals("1")){
                           %>
                           <p style="color:red; z-index:2;">!The password length is invalid plz enter 8 digit password</p>
                           <% }%>
                   <label for="password">Password</label><br>
                   <input type="text" name="password"  value=" Password" onclick="clearInput(this)" autocomplete="off" required><br>
                   <button>Login</button>
               </form>
        </div>
        <div class="otherLinks">
            <a href="forgotpassword">Forgot Password !</a><br>
            <a href="register">New Register</a>
        </div>
    </div>
    <script>
            // JavaScript function to clear input field value on click
            function clearInput(inputField) {
                inputField.value = '';
            }
        </script>
</body>
</html>