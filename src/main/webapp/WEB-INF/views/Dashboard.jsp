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
    <title>User Profil</title>
    <link rel="stylesheet" href="/css/DashBoard.css">
</head>
 <body>

        <div class="back1">
            <div class="links" >
                <a href="/home">⬅️Back</a>
            </div>
        </div>
        <div class="head">
            <div class="logo">
                <img src="/images/3.png" alt="Logo">
            </div>
            <div class="text" >
               <span>User</span>  Profile
            </div>
            <div class="profile">
                 <img src="/images/1.png" alt="Logo">
                 ${Name}
            </div>
        </div>
        <div class="template">
            <div class="template1">
               <div class="headtext" id="Headtext" style="display: flex;">
                *User Profile
               </div>
             <!-- -------------------------------------this is div for profile image div ------------------------------------------- -->
               <div class="innertemplate">
                   <div class="currlogo">
                      <img src="images/user_loog.png" alt="ProfileImage" id="profilepic">
                   </div>
                   <div id="ImageUploadForm" display="none">
                        <form action="Picupload" method="post" enctype="multipart/form-data">
                            <input type="file" name="ProfilePic" l class="file-input"  autocomplete="off">
                            <button class="upload-button">Upload Profile</button>
                        </form>
                   </div>
               </div>
            </div>
            <!-- -----------------------------------------end for profile image div -------------------------------------------------->
           <!-- ------------------------------------------div to display user cred ------------------------------------------------ -->
            <div id="userCred" style="display: block;">
                <p id="UserCredId">Name : <br> ${Name}</p> <br>
                <p id="UserCredId">Email Address : <br> ${Email}</p> <br>
                <p id="UserCredId">User ID : <br> ${UserId}</p> <br>
                <p id="UserCredId">Password : <br> ${Password}</p> <br>
                <button id="EditButton"> Edit ✒️</button></a>
            </div>
             <!-- ------------------------------------------------------------------------------------------------------------------  -->

             <!----------------------------------------end for the pre data fetch ------------------------------------------------  -->
             <!-- --------------------------------------code after Edit Enabled ----------------------------------------------------- -->
            <div class="formtemplate" style="display: none;" id="UpdateForm">
                <form action="EditInfo" method="post" >
                    <div class="Name" id="input">
                        <div class="img" id="img">

                        </div>
                        <label for="Name">Name</label> <br><br>
                        <input type="text" name="Name" value="${Name}" autocomplete="off" required>
                    </div>

                    <div class="Email" id="input">
                        <div class="img" id="img">
                        </div>
                        <label for="Email">Email</label> <br><br>
                        <input type="text" name="Email"  autocomplete="off" required>
                    </div>
                    <div class="UserId" id="input">
                        <div class="img" id="img">

                        </div>
                        <label for="Password">Password</label> <br><br>
                        <input type="text" name="Password" autocomplete="off" required>
                    </div>

                    <div class="button" id="button">
                        <button>Reset</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <script>

        document.getElementById("userCred").addEventListener("click", function(event) {
        event.preventDefault(); // Prevent the default anchor behavior (e.g., page reload)
        var UserCred1 = document.getElementById("userCred");
        var updateForm = document.getElementById("UpdateForm");
        var imageUploadForm = document.getElementById("ImageUploadForm");

        // Hide UserCred1
        UserCred1.style.display = "none";

        // Toggle UpdateForm
        if (updateForm.style.display === "flex") {
            updateForm.style.display = "none";
        } else {
            updateForm.style.display = "flex";
        }

        // Toggle ImageUploadForm
        if (imageUploadForm.style.display === "block") {
            imageUploadForm.style.display = "none";
        } else {
            imageUploadForm.style.display = "block";
        }
    });
      </script>
    </body>
    </html>