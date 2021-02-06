<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
<title>Register</title>
</head>
<body>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">

<div class="container">
            <form class="form-horizontal" role="form" method="post">
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
                        <input type="number" name="phoneno" placeholder="Phone no" class="form-control" autofocus>
                        
                    </div>
                </div>
                <div class="form-group">
                    <label for="email" class="col-sm-3 control-label">Email</label>
                    <div class="col-sm-9">
                        <input type="email" name="email" placeholder="Email" class="form-control">
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
                
                <div class="error"><p style="color:red ">Could not register! Please try again</p></div>
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
</body>
</html>