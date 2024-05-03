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
        <link rel="stylesheet" href="/css/Login.css">
        <title>Vault Login</title>
    </head>
    <body>
        <div class="head">
            <div class="logo">
             <img src="/images/mylogo1.png" alt="logo">
            </div>
            <div class="links">
            <a href="#">
                <li>About</li>
            </a><a href="#">
                <li>Links</li>
            </a><a href="#">
                <li>Review</li>
            </a><a href="#">
                <li>Contact</li>
            </a>
            </div>
            <div class="button">
                <a href="register"><button>Register</button></a>
            </div>
        </div>

        <div class="template1">
            <div class="template2">
                <p id="Name">UserAuth::VaultDrive</p>
              <div class="text">
                <p id="top">Nice to see you again !</p><br>
               WELCOME BACK <br>
                <p id="bottom">Your trusted destination for storing and managing all your uploaded data with peace of mind.
                     Your files are safeguarded here, ensuring privacy and accessibility whenever you need them.
                     Explore the ease and security of our vault and take control of your data today!</p>
              </div>
            </div>
            <div class="formtemp">
                <div class="context">
                    Login Account
                </div>
                <div class="Error">
         <%
                              String error = (String) request.getAttribute("Error");
                              if (error != null) {
                                  switch (error) {
                                      case "0": { %>
                                          <p id="EP">*Invalid Email, please use only Gmail</p>
                                      <% break; }
                                      case "1": { %>
                                          <p id="EP">*Invalid Password, use 8 characters including A-Z, a-z, 0-9, symbols</p>
                                      <% break; }
                                      case "2": { %>
                                          <p id="EP">*User Not Found</p>
                                      <% break; }
                                      default: { %>
                                          <p id="EP">*Server Side Error</p>
                                      <% break; }
                                  }
                              }
                          %>
                  </div>

                  <!----------------------script to hide error block -----------------------------------  -->
                <form action="/submit" method="post">
                    <div class="input">
                        <img src="/images/mail (2).png" alt="i" id="icon">
                        <input type="text" name="Email_id" autocomplete="off" value="Email Id" required>
                    </div>
                    <div class="input">
                        <img src="/images/password (1).png" alt="i" id="icon">
                        <input type="text" name="password" autocomplete="off" value="Password" required>
                    </div>

                    <div class="butt">
                        <button>Login</button>
                    </div>
                </form>
                <div class="link">
                <a href="forgotpassword" style="color:blue; text-decoration:none;">Forgot password ?</a>
                </div>
            </div>
        </div>
    </body>
    </html>