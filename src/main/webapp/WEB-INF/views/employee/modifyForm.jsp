<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>modify Account</title>
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
</head>
<body>

	<div class="mainwrapper">
		<jsp:include page="../common/head.jsp"></jsp:include>
		<jsp:include page="../common/left.jsp"></jsp:include>

		<div class="rightpanel">

			<ul class="breadcrumbs">
				<li><a href="#"><i class="iconfa-home"></i></a> <span
					class="separator"></span></li>
				<li><a href="${pageContext.request.contextPath}/employee/view">employee</a>
					<span class="separator"></span></li>
				<li>Form Styles</li>

				<li class="right"><a href="" data-toggle="dropdown"
					class="dropdown-toggle"><i class="icon-tint"></i> Color Skins</a>
					<ul class="dropdown-menu pull-right skin-color">
						<li><a href="default">Default</a></li>
						<li><a href="navyblue">Navy Blue</a></li>
						<li><a href="palegreen">Pale Green</a></li>
						<li><a href="red">Red</a></li>
						<li><a href="green">Green</a></li>
						<li><a href="brown">Brown</a></li>
					</ul></li>
			</ul>

			<div class="pageheader">
				<form action="#" method="post" class="searchbar" />
				<input type="text" name="keyword"
					placeholder="To search type and hit enter..." />
				</form>
				<div class="pageicon">
					<span class="iconfa-pencil"></span>
				</div>
				<div class="pagetitle">
					<h5>Forms</h5>
					<h1>Form Styles</h1>
				</div>
			</div>
			<!--pageheader-->

			<div class="maincontent">
				<div class="maincontentinner">

					<div class="widgetbox box-inverse">
						<h4 class="widgettitle">Employe Information</h4>
						<div class="widgetcontent wc1">
							<form:form id="form1" cssClass="stdform" method="post"
								action="${pageContext.request.contextPath}/employee/modify"
								modelAttribute="employeeForm">
								<form:hidden path="id" />
								<div class="par control-group">
									<label class="control-label" for="name">Name</label>
									<div class="controls">
										<form:input type="text" path="ten" id="name"
											cssClass="input-large" />
									</div>
								</div>
								<div class="par control-group">
									<label>Gender</label> <span class=""> <span class=""><form:radiobutton
												path="gioiTinh" value="nam" required="required" /></span> nam
										&nbsp; &nbsp; <span class=""><form:radiobutton
												path="gioiTinh" value="nu" required="required" /></span> nu &nbsp;
										&nbsp;
									</span>
								</div>

								<div class="control-group">
									<label class="control-label" for="diaChi">Address</label>
									<div class="controls">
										<form:input type="text" path="diaChi" id="diaChi"
											cssClass="input-large" />
									</div>
								</div>
								<div class="par control-group">
									<label class="control-label" for="phone">phone</label>
									<div class="controls">
										<form:input type="text" path="phone" id="phone"
											cssClass="input-xlarge" />
									</div>
								</div>
								<p class="stdformbutton">
									<button class="btn btn-primary">Submit Button</button>
								</p>
							</form:form>
						</div>
						<!--widgetcontent-->
					</div>
					<!--widget-->
					<jsp:include page="../common/footer.jsp"></jsp:include>
				</div>
				<!--maincontentinner-->
			</div>
			<!--maincontent-->
		</div>
		<!--rightpanel-->
	</div>
	<!--mainwrapper-->
</body>
</html>