<!DOCTYPE html>
<html>

<head>

  <meta charset="UTF-8">
  <title>Admin login</title>
  
  
  
      <link rel="stylesheet" href="css/style.css">

  <h1>ADMIN</h1>
</head>

<body>

  <div class="login-page">
  <div class="form">
    <form class="register-form" action="admin_register.jsp">
      <input type="text" placeholder="name" name="n"/>
      
      <input type="text" placeholder="email address" name="e"/>
      <input type="password" placeholder="password" name="p"/>
      <button>Register</button>
     
      <p class="message">Already registered? <a href="#">Sign In</a></p>
    </form>
    <form class="login-form" action="admin_login.jsp">
      <input type="text" placeholder="email" name="e"/>
      <input type="password" placeholder="password" name="p"/>
      <button>login</button>
      <p class="message">Not registered? <a href="#">Create an account</a></p>
    </form>
  </div>
</div>
 
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>
</body>

</html>
