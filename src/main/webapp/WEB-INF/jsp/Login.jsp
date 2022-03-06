<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Login</title>
</head>
<body>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">

<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Sign In</h1>
            <h4 class="text-center">Welcome to Book Lovers Club</h4>
            <div class="account-wall">
                <img class="profile-img center-block" src="https://wikiclipart.com/wp-content/uploads/2016/11/Child-reading-children-reading-clipart-black-and-white-2.jpg" height="200px"
                    alt="">
                <br>
                <form class="form-signin" method="post"  onsubmit="return submitForm();" id="myForm">
                <input name="name" type="email" id="email" class="form-control" placeholder="Email" required autofocus>
                <br>
                <input name="password" type="password" class="form-control" placeholder="Password" required>
                &nbsp;
                <c:if test="${error!=null}">
                <div class="error"><p style="color:red ">Wrong username or password!</p></div>
                </c:if>
                <button class="btn btn-lg btn-info btn-block" type="submit">
                    Sign in</button>
                <label class="checkbox pull-left">
                    <input type="checkbox" value="remember-me">
                    Remember me
                </label>
                <a href="/Help" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                </form>
            </div>
            <a href="/Register" class="text-center new-account">Create an account </a>
        </div>
    </div>
</div>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="text/javascript">

function validateEmail(){
   var email = document.getElementById("email").value;
   var reg = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;   
	console.log('email matcher..',reg.test(email));

   if (reg.test(email) == false) 
   {
       return false;
   }

   return true;

}

function submitForm(){
   
    	if(validateEmail()) {
    	
        $('#myForm').submit();
        
        return true;
    	}
    	else
    	{
    		alert('Invalid Email Address');
            return false;
    		
    	}
}
       

</script>
</body>
</html>