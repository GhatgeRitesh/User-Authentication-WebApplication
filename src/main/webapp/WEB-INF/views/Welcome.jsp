<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome To UserAuth DashBoard</title>
    <link rel="stylesheet" href="/css/welcome.css">
</head>
<body>
    <!-- ---------------------------------------------------------------------------------------------------------------------- -->
       <img src="./images/12.png" alt="Logo_with transperent Background" id="logo">
       <div class="head">
             <div class="menu">
                <div class="about1" id="menuFont">
                   <a href="#jump">About</a>
                </div>
                <div class="GetDetails" id="menuFont">
                   <a href="#">Links</a>
                </div>
                <div class="profile" id="menuFont" style="text-align:center; position: relative; top:-10vh; margin-left:1vw;">
                   <a href="#">
                <img src="./images/9.png" alt="">
               <br> ${UserName}</a>
                </div>
             </div>
       </div>
       <!-- ---------------------------------------------------------------------------------------------------------------------- -->
       <div class="side">
         <div class="buttons">
            <a href="/logout"><button>Logout</button></a>
            <a href="/deleteaccount"><button>Delete Account</button></a>
            <a href="/Userlist"><button>GetUserlist</button></a>
         </div>
       </div>
       <!-- ---------------------------------------------------------------------------------------------------------------------- -->
       <div class="cards">
            <div class="content1" id="c">
               <p id="heading">Tech Used</p>
                <ul class="li">Html</ul>
                <ul class="li">CSS</ul>
                <ul class="li">JSP</ul>
                <ul class="li">Java</ul>
                <ul class="li">Spring Boot</ul>
                <ul class="li">MySQL</ul>
            </div>
            <div class="content2" id="c">
               <p id="heading">Features</p>  <br>
                <ul class="li">Secure Hash Algorithm -256</ul>
                <ul class="li">Gmail API Integration</ul>
                <ul class="li">Safe Password Storage</ul>
                <ul class="li">Maven Architechture as MultiModule Implementation</ul>
            </div>
         </div>
         <div class="cards">
            <div class="content3" id="c" style="padding: 3%; height: 35vh;">
                 <p id="heading">API Implementation</p>
                 GMail API Implementation provides features of Secure Login and Account Recovery <br><br>
                 Implementation of SHA-256 provides best Privacy and Encryption for user Credentials <br><br>
                 Using MySQL provides features of faster transactions and secure Authentication of user Credentials <br><br>
                 The project helps in instant merging to the any Maven Architechture Project making it more efficient and Reliable <br><br>
            </div>
            <div class="content4" id="c" style="height: 25vh;padding-top:-5%">
               <p id="heading">Scalability</p>
                 The UserAuth is built by having focus on the multimodule project Structure <br><br>
                 In Future the UserAuth will be used as the Integral part of E-Vault {Future Microservice Project }. <br><br>
            </div>
       </div>
       <!-- ---------------------------------------------------------------------------------------------------------------------- -->
       <div class="main" id="jump">
           Developed By :- <br>
           <p class="name">
            Ritesh Balaji Ghatge
           </p><br>
           The Project is Developed as Learning Project
           <div class="about">
                Fresher Java Backend Developer <br><br>
               Core Skills : <br>
                <ul class="li">Core Java</ul>
                <ul class="li">MySQL</ul>
                <ul class="li">Spring Boot</ul>
                <ul class="li">RestAPI Integration.</ul>
                <ul class="li">Git [ version control ]</ul>
           </div>
           <div class="intrest">
               Intrested Skill sets <br><br>
               Familiar To: <br>
               <ul class="li">Gmail API [ OAuth2.0 ]</ul>
               <ul class="li">SHA-Family</ul>
               <ul class="li">Token Auth</ul>
               <ul class="li">Auth</ul>
               <ul class="li">Maven MultiModule Architechture</ul>
           </div>
       </div>
       <div class="blank">

       </div>
</body>
</html>