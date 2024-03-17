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
                  <%
                  String error=(String)session.getAttribute("error");
                  if(error!=null && error.equals("1"))
                  {
                  System.out.println("invalid email warning");
                  %>
                  <p>*Invalid Email Address</p>
                  <%}%>
                  <%
                  String error2=(String)session.getAttribute("error2");
                  if(error2!=null && error2.equals("3"))
                  {
                  System.out.println("Email sending warning");
                  %>
                  <p>* Error in Sending the Email </p>
                  <%} session.invalidate();%>
        <div class="form_details" id="myForm">
            <form action="Passreset" method="post" id="myForm">
                <p>*To access the account you have to verify with Eamil Id </p>
                <label for="Email_Id">Email Id or User Name</label><br>
                <div class="animation" style="margin:auto;display:none" id="animate"></div>
                <input type="text" name="Email_Id"  autocomplete="off" required value=${Email_Id} ><br>
                <button onclick="animate()">Send</button><br><br>
                </form>
                <script>
                  function animate() {
                                  var animate = document.querySelector('#animate');
                                  animate.style.display = 'block'; // Display the input form
                                  document.getElementById('myForm').submit();
                              }
                </script>
        </div>
        <div class="content" style="color: rgb(237, 237, 237); text-align: left;">
            Go back to <a href="Login"> Login </a> Page
        </div>
    </div>
</body>
</html>
