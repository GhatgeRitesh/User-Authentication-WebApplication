<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Delete Account</title>
    <link rel="stylesheet" href="/css/delete.css">
</head>
<body>
<div class="temp">
    <div class="head">
      Delete Account ❌
    </div>
    <div class="userdetails">
        <div class="userName">
            <p id="name" style="text-align: center;font-size:1.4rem;">${userName}</p> <br>
            Do you want to delete this account permanently? <br>
            <button onclick="password_function()" id="yes">✅Yes!</button> <button onclick="/Welcome" id="yes">❌ No</button> <br><br>
        </div>
        <script>
            function password_function() {
                var inputForm = document.querySelector('.inputform');
                inputForm.style.display = 'block'; // Display the input form
                var button = document.querySelector('#yes');
                button.style.display = 'none';
            }
        </script>
    </div>
    <div class="inputform" style="display: none;">
        <form action="delete1" method="post">
        <!--   -----------------------------code for error handling ------------------------------------------------------->
                    <%
                    String code=(String)session.getAttribute("error");
                    if(code!=null && code.equals("1")){
                    %>
                    <p>*Invalid Password</p>
                    <%}%>
        <!---------------------------------------------------------------------------------------------------------------->
            <label for="pass">Password :</label> <br>
            <input type="text" name="pass" autocomplete="off" id="input" required> <br>
            <button id="inputbutton">Delete</button>
        </form>
    </div>

    <div class="backbutton">
     <button onclick="/Welcome" id="back">🔙</button>
    </div>
</div>
</body>
</html>