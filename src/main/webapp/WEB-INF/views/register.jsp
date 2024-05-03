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
        <link rel="stylesheet" href="/css/register.css">
        <title>Vault Register</title>
    </head>
    <body>
        <div class="temp">
            <div class="stmt">

            </div>
                    <div class="innertemp">
                        <div class="blur-overlay"></div>
                        <div class="headtxt">
                          Welcome To UserAuth
                        </div>
                        <div class="context">
                          Your safe haven for personal data storage. We keep your information secure on our servers,
                           ensuring your privacy is always protected.
                           Join us and experience peace of mind with every upload.
                        </div>
                    </div>
            <div class="formtemp">
                 <div class="regtxt">
                    User Registration
                    <div class="Errors">
                  <%
                                       String error = (String)request.getAttribute("Error");
                                       if (error != null) {
                                           switch (error) {
                                               case "1": { %>
                                                   <p id="EP">*Name already in use please enter new name</p>
                                               <% break; }
                                               case "2": { %>
                                                   <p id="EP">Invalid Email Please Enter only GMAIL Id</p>
                                               <% break; }
                                               case "3": { %>
                                                   <p id="EP">*Invalid Password, use 8 characters including A-Z, a-z, 0-9, symbols</p>
                                               <% break; }
                                               default: { %>
                                                   <p id="EP">*Server Side Error</p>
                                               <% break; }
                                           }
                                       }
                                   %>
                    </div>
                 </div>
               <form action="submit_register" method="post">

                <div class="name">
                    <img src="/images/user (1).png" alt="asdas" id="imglogo">
                    <input type="text" name="Name" value="username" autocomplete="off" onclick="clearinput(this)" required>
                </div>

                <div class="email">
                    <img src="/images/mail (2).png" alt="asdas" id="imglogo">
                    <input type="text" name="EmailId" value="email" autocomplete="off" onclick="clearinput(this)"  required>
                </div>

                <div class="password">
                    <img src="/images/password (1).png" alt="asdas" id="imglogo">
                    <input type="password" name="password" value="password" autocomplete="off" onclick="clearinput(this)" required>
                </div>

                <div class="check">
                  <input type="checkbox" required>*Accept all T&C
                </div>

                <div class="reg">
                    <button>Register</button>
                </div>

               </form>

               <script>
                function clearinput(inputField)
                 {
                   inputField.value = '';
                 }
               </script>

            </div>
        </div>
    </body>
    </html>