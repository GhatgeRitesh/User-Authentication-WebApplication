<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="/css/forgotpassword.css">
</head>
<body>
    <div class="temp">
        <b>Re-Verification</b>
        <div class="form_details">
            <form action="passReset" method="post">
                <p>*To access the account you have to verify with Eamil Id </p>
                <label for="Email_Id">Email Id or User Name</label><br>
                <input type="text" name="Email_Id" onclick="clearInput(this)" required><br>
                <button>Send</button><br><br>
                <%
                  String Code= (String)session.getAttribute("name");
                  if(Code !=null)
                  {


                %>
                <label for="code">Enter Security Code</label><br>
                <input type="text" name="code" required><br>
                <a href="verify"><button>Verify</button></a>
                <div class="captcha"><br>
                   palcae for the captcha input
                </div><br>
                <% }%>
            </form>
        </div>
        <div class="content" style="color: rgb(237, 237, 237); text-align: left;">
            Go back to <a href="Login"> Login </a> Page
        </div>
    </div>
</body>
</html>
