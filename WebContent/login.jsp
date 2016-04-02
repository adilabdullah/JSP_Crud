<%@page import="javax.xml.ws.Response"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="oracle.jdbc.OraclePreparedStatement"%>
<%@page import="java.sql.SQLException"%>
<%@page import="jdk.nashorn.internal.ir.RuntimeNode.Request"%>
<%@page import="java.sql.Connection"%>
<%@page import="Backend.Bean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html >
  <head>
    <meta charset="UTF-8">
    <title>Elastic Login Form</title>
    
    
    
    
        <!--link rel="stylesheet" href="css/login.css"-->

    
    
    
  </head>

  <body>

    <!--Google Font - Work Sans-->
<!-- link href='https://fonts.googleapis.com/css?family=Work+Sans:400,300,700' rel='stylesheet' type='text/css'-->

<!--div class="container">
  <div class="profile">
    <button class="profile__avatar" id="toggleProfile">
     <img src="https://pbs.twimg.com/profile_images/554631714970955776/uzPxPPtr.jpeg" alt="Avatar" /> 
    </button>
    
    <div class="profile__form">
    <form method="post" action="log">
      <div class="profile__fields">
        <div class="field">
          <input type="email" name="name" id="fieldUser" class="input" required pattern=.*\S.* />
          <label for="fieldUser" class="label">Email:</label>
        </div>
        <div class="field">
          <input type="password" name="father" id="fieldPassword" class="input" required pattern=.*\S.* />
          <label for="fieldPassword" class="label">Password:</label>
        </div>
        <div class="profile__footer">
          <input type="submit" class="btn" name="siin" value="Sign in"/>
        </div>
      </div>
      </form>
      <form method="post" action="log">
        <div class="profile__footer">
          <input type="submit" class="btn" name="siup" value="Sign up" />
        </div> 
     </form>
     </div>
     
     
     
  </div>
</div-->
    
    <form method="post" action="log">
    <input type="email" name="email" placeholder="Enter email"/>
    <input type="password" name="password" placeholder="Enter password"/>
    <input type="submit" value="Sign in" name="siin"/>
    </form>
    
    <form method="post" action="log">
    <input type="submit" value="Sign up" name="siup"/>
    </form>
    

        <!-- script src="js/index.js"></script-->

    
    
    
  </body>
</html>
    