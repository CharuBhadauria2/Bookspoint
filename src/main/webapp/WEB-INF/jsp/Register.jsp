<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Register</title>
</head>
<body>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">

<div class="container">
            <form class="form-horizontal" role="form" method="post" id="myForm"  onsubmit="return submitForm();">
               <div class="panel panel-info ">
               <div class="panel-heading"><h2>Register</h2></div>
               </div>
                <div class="form-group">
                    <label for="fullname" class="col-sm-3 control-label">Full Name</label>
                    <div class="col-sm-9">
                        <input type="text" name="fullname" placeholder="Full Name" class="form-control" autofocus>
                        <span class="help-block">Last Name, First Name, eg.: Smith, Harry</span>
                    </div>
                </div>
                <div class="form-group">
                    <label for="phoneno" class="col-sm-3 control-label">Phone Number</label>
                    <div class="col-sm-9">
                        <input type="tel" id="phoneno" name="phoneno" placeholder="Phone No" class="form-control" autofocus required>
                        </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email</label>
                    <div class="col-sm-9">
                        <input type="email" name="email" id="email" placeholder="Email" class="form-control">
                    </div>
                </div>
                <div class="form-group">
                    <label for="password" class="col-sm-3 control-label">Password</label>
                    <div class="col-sm-9">
                        <input type="password" name="password" placeholder="Password" class="form-control">
                    </div>
                </div>
                 <!-- /.form-group -->
              <!--   <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox">I accept <a href="#">terms</a>
                            </label>
                        </div>
                    </div>
                </div> <!-- /.form-group -->
                
                
                
                <c:if test="${errorreg!=null}">
                
                <div class="error"><p style="color:red ">Could not register! Please try again !</p></div>
                &nbsp;
                </c:if>
          <c:if test="${alreadyexists!=null}">
                
                <div class="error"><p style="color:red "> Username or password already taken. please try some other combination ! </p></div>
                &nbsp;
                </c:if>
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <button type="submit" class="btn btn-success btn-block">Register</button>
                    </div>
                </div>
                
                
            </form> <!-- /form -->
        </div> <!-- ./container -->
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="text/javascript">

function mobilenumber() {
	 var mobile = document.getElementById("phoneno").value;
	 var numericmob = isNumber(mobile);
	      if(!numericmob)
	      {
	          alert("Phone Number Invalid.");      
	          return false;
	      }
	      if(mobile.length!=10)
	      {
	          alert("Enter 10 digits Contact Number.");
	          return false;
	      }
	      return true;
}


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

function isNumber(mobile)
{    
    if(isNaN(mobile)||mobile.indexOf(" ")!=-1)
    {               
        return false;
    }
    return true;
}


function submitForm(){
	debugger;
    if(mobilenumber()){
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
        else{
            alert("Please Input Correct Mobile Number and Email Id");
            return false;
        }
}
</script>
</body>
</html>