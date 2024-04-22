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
    <link rel="stylesheet" href="/css/register.css">
</head>
<body>
        <div class="head">
                                         Register
        </div>
        <div class="template">
        <%
                             String SaveError=(String)session.getAttribute("ServerError");
                             if(SaveError!=null && SaveError.equals("4"))
                             {
                             %>
                             <p style="color:red; font-size:1.1rem;">* server Error please try later.</p><br>
                             <% }%>
                <%
                             String NameError=(String)session.getAttribute("NameError");
                             if(NameError!=null && NameError.equals("3"))
                             {
                             %>
                             <p style="color:red;font-size:1.1rem;">* User Name Already used please provide another.</p><br>
                             <%}%>
                <%
                                String emailerror=(String)session.getAttribute("GmailError");
                                if(emailerror!=null && emailerror.equals("2"))
                                {
                               %>
                               <p style="color:red;font-size:1.1rem;>*Only Gmail ID is valid for this project please enter valid email ID</p>
                               <% } %>
                <% String passerror=(String)session.getAttribute("PassError");

                                                    if(passerror!=null && passerror.equals("1")){
                                                          %>
                                                          <p style="color:red; z-index:2;font-size:1.1rem;">!The password length is invalid plz enter 8 digit password</p>
                                                          <% } %>
        <div class="form">
             <form action="submit_register" method="post">
               <label for="Name">User Name</label><br>
               <input type="text" name="Name"  autocomplete="off" required><br>
               <label for="EmailId">Email Id</label><br>
               <input type="text" name="EmailId"  autocomplete="off" required><br>
               *set password of length 8 charset <br>
               <label for="password">Password</label><br>
               <input type="text" name="password"   autocomplete="off" required><br>
               <input type="checkbox" id="check" required> *Accept all T&C <br><br>
               <button>Register</button>
             </form>
             </div>
             </div>
             <div class="links">
            <a href="index"><button id="links-button">Home</button></a>  <a href="Login"><button id="links-button">Login</button></a>
            </div>
</body>
</html>
