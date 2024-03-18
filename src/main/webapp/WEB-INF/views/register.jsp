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
    <div class="temp">
        <div class="content">
        <%
                     String SaveError=(String)session.getAttribute("ServerError");
                     if(SaveError!=null && SaveError.equals("4"))
                     {
                     %>
                     <p style="color:red;">* server Error please try later.</p><br>
                     <%}%>
          Register
        </div>
        <div class="form_details">
             <form action="submit_register" method="post">
             <%
             String NameError=(String)session.getAttribute("NameError");
             if(NameError!=null && NameError.equals("3"))
             {
             %>
             <p style="color:red;">* User Name Already used please provide another.</p><br>
             <%}%>
               <label for="Name">Enter Your Name</label><br>
               <input type="text" name="Name" onclick="clearInput(this)" value="Name" autocomplete="off" required><br>
               <%
                String emailerror=(String)session.getAttribute("GmailError");
                if(emailerror!=null && emailerror.equals("2"))
                {
               %>
               <p>*Only Gmail ID is valid for this project please enter valid email ID</p>
               <% } %>
               <label for="EmailId">Email Id</label><br>
               <input type="text" name="EmailId" onclick="clearInput(this)" autocomplete="off" required><br>
               *set password of length 8 charset <br>
               <% String passerror=(String)session.getAttribute("PassError");

                                    if(passerror!=null && passerror.equals("1")){
                                          %>
                                          <p style="color:red; z-index:2;">!The password length is invalid plz enter 8 digit password</p>
                                          <% } %>
               <label for="password">Password</label><br>
               <input type="text" name="password" onclick="clearInput(this)" value="password" autocomplete="off" required><br>
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
