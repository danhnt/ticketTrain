<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Account</title>
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

	</div>
	<div class="rightpanel">
		<ul class="breadcrumbs">
			<li><a href="#"><i class="iconfa-home"></i></a> <span
				class="separator"></span></li>
			<li><a href="${pageContext.request.contextPath}/tintuc/view">tintuc</a>
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
		<form:form method="post" modelAttribute="tintucForm">
			<%-- modelAttribute="accountForm"
		action="${pageContext.request.contextPath}/account/delete" --%>
			<div class="panel panel-default qp-div-information">
				<div class="panel-heading">
					<span class="glyphicon  qp-heading-icon" aria-hidden="true">&nbsp;</span>
					<span class="pq-heading-text"></span>
				</div>
				<div class="panel-body">
					<table class="table table-bordered qp-table-form">
						<colgroup>
							<col width="5%" />
							<col width="10%" />
							<col width="10%" />
							<col width="10%" />
							<col width="20%" />
							<col width="20%" />
							<col width="5%" />
							<col width="5%" />
						</colgroup>
						<tr>
							<td><label>No.</label></td>
							<td><label>ma tin tức</label></td>
							<td><label>Người đăng</label></td>
							<td><label>Ngày đăng</label></td>
							<td><label>Tiêu đề</label></td>
							<td><label>Nội dung</label></td>
							<td><label>Edit</label></td>
							<td><label>Delete</label></td>

						</tr>
						<c:forEach items="${tintucList}" var="tintuc" varStatus="sts">
							<tr>
								<td class="com-output-integer">${sts.index + 1}</td>
								<td class="com-output-text"><span class="strike">${tintuc.maTin }</span>
								</td>
								<td class="com-output-text"><span class="strike">${tintuc.maNv.ten }</span>
								</td>
								<td class="com-output-text"><span class="strike">${tintuc.ngayDang }</span>
								</td>
								<td class="com-output-text"><span class="strike">${tintuc.tieuDe }</span>
								</td>
								<td class="com-output-text"><span class="strike">${tintuc.noiDung }</span>
								</td>
								<td class="com-output-text"><a
									href="${pageContext.request.contextPath}/tintuc/modify?id=${tintuc.maTin}"><span
										class="glyphicon glyphicon-pencil" aria-hidden="true">edit</span></a>
								</td>
								<td class="com-output-text"><a
									href="${pageContext.request.contextPath}/tintuc/delete?id=${tintuc.maTin}"><span
										class="glyphicon glyphicon-pencil" aria-hidden="true">Delete</span></a>
								</td>
							</tr>
						</c:forEach>
					</table>
				</div>
			</div>
		</form:form>
	</div>
</body>
</html>