<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Shamcey - Metro Style Admin Template</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/style.default.css"
	type="text/css" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/style.shinyblue.css"
	type="text/css" />

<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/app/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/app/js/jquery-migrate-1.1.1.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/app/js/jquery-ui-1.9.2.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/app/js/modernizr.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/app/js/bootstrap.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/app/js/jquery.cookie.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/app/js/custom.js"></script>
<script type="text/javascript">
	jQuery(document).ready(function() {
		jQuery('#login').submit(function() {
			var u = jQuery('#username').val();
			var p = jQuery('#password').val();
			if (u == '' && p == '') {
				jQuery('.login-alert').fadeIn();
				return false;
			}
		});
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" /></head>

<body class="loginpage">

<div class="loginpanel">
    <div class="loginpanelinner">
        <div class="logo animate0 bounceIn"><img src="${pageContext.request.contextPath}/resources/app/images/logo.png" alt="" /></div>
        <form:form id="login" action="#" method="post" >
            <div class="inputwrapper login-alert">
                <div class="alert alert-error">Invalid username or password</div>
            </div>
            <div class="inputwrapper animate1 bounceIn">
                <input type="text" name="username" id="username" placeholder="Enter any username" />
            </div>
            <div class="inputwrapper animate2 bounceIn">
                <input type="password" name="password" id="password" placeholder="Enter any password" />
            </div>
            <div class="inputwrapper animate3 bounceIn">
                <button name="submit">Sign In</button>
            </div>
            <div class="inputwrapper animate4 bounceIn">
                <label><input type="checkbox" class="remember" name="signin" /> Keep me sign in</label>
            </div>
            
        </form:form>
    </div><!--loginpanelinner-->
</div><!--loginpanel-->

<div class="loginfooter">
    <p>&copy; 2015: Ticket Train</p>
</div>

</body>
</html>

