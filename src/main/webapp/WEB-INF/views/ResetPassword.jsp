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
        <link rel="stylesheet" href="/css/resetPass.css">
        <title>Vault Register</title>
    </head>
    <body>
          <div class="template">
            <div class="context">
              User Auth
            </div>
            <div class="usercred">
                 Name : ${Name}  <br> <br>
                 User Id : ${UserId}
            </div>
            <div class="form">
                *Set New Password  <br> <br>
                <form action="resetpassword" method="post" id="myForm">
                    <label for="newPassword">New password</label> <br>
                    <input type="password" name="newPassword" id="new" autocomplete="off" required> <br>

                    <label for="recheck">Re-enter new Password</label> <br>
                    <input type="password" name="Recheck" id="check" autocomplete="off" required> <br>

                    <span id="errorMsg"></span> <br>
                    <button id="submitButton">Reset</button>
                </form>
            </div>

            <script>
            document.addEventListener('DOMContentLoaded', function() {
              const passwordField = document.getElementById('new');
              const confirmPasswordField = document.getElementById('check');
              const errorMsg = document.getElementById('errorMsg');
              const submitButton = document.getElementById('submitButton');

              const passwordPattern = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&*]).{8,}$/;

                confirmPasswordField.addEventListener('input', function() {
                const password = passwordField.value;
                const confirmPassword = confirmPasswordField.value;

                if (!passwordPattern.test(password)) {
                  errorMsg.textContent = 'Password must contain at least 8 characters including at least one uppercase letter, one lowercase letter, one number, and one special character (!@#$%^&*)';
                  errorMsg.style.color = 'red';
                  submitButton.disabled = true;
                }
                else if (password === confirmPassword) {
                  errorMsg.textContent = 'Passwords match';
                  errorMsg.style.color = 'green';
                } else {
                  errorMsg.textContent = 'Passwords do not match';
                  errorMsg.style.color = 'red';
                }
              });
            });
            </script>
    </body>
    </html>