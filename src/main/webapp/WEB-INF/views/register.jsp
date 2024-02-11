 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/register.css">
</head>
<body>
    <div class="temp">
        <div class="content">
          Register
        </div>
        <div class="form_details">
             <form action="newreg" method="post">
               <label for="User_Name">Enter Your Name</label><br>
               <input type="text" name="User_Name" onclick="clearInput(this)" value="Name" required><br>
               <label for="EmailId">Email Id</label><br>
               <input type="text" name="EmailId" onclick="clearInput(this)" value="Email Id" required><br>
               *set password of length 8 charset <br>
               <% String req=(String)session.getAttribute("name");
                                     System.out.println("the error is grabed"+req);
                                    if(req!=null && req.equals("1")){
                                          %>
                                          <p style="color:red; z-index:2;">!The password length is invalid plz enter 8 digit password</p>
                                          <% session.invalidate(); }%>
               <label for="password">Password</label><br>
               <input type="text" name="password" onclick="clearInput(this)" value="password" required><br>
               <input type="checkbox" id="check" required> *Accept all T&C <br><br>
               <button>Submit</button>
             </form>
             <div class="links">
                Go to <a href="index">Home</a> or <a href="Login">Login</a>
            </div>
        </div>
    </div>
     <script>
                    function clearInput(inputField){
                        inputField.value = '';
                    }
                 </script>
</body>
</html>