<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Home</title>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/app/css/styles.css">
</head>
<body>
	<div id="wrapper">
		<h1>TRAIN TICKET</h1>
		<p>The time on the server is ${serverTime}.</p>
	</div>

	<div id="todoForm">

		<form:form action="${pageContext.request.contextPath}/create"
			method="post" modelAttribute="todoForm">
			<form:input path="todoTitle" />
			<form:errors path="todoTitle" cssClass="text-error" />
			<input type="submit" value="Create Todo" />
		</form:form>
	</div>
	<hr />
	<div id="todoList">
		<ul>
			<c:forEach items="${todos}" var="todo">
				<li><c:choose>
						<c:when test="${todo.finished}">
							<span class="strike">${todo.todoTitle}</span>
						</c:when>
						<c:otherwise>
                            ${todo.todoTitle}
                            <form:form
								action="${pageContext.request.contextPath}/todo/finish"
								method="post" modelAttribute="todoForm"
								cssStyle="display: inline-block;">
								<form:hidden path="todoId" value="${todo.todoId}" />
								<input type="submit" name="finish" value="Finish" />
							</form:form>
						</c:otherwise>
					</c:choose> <!-- (1) --> <form:form
						action="${pageContext.request.contextPath}/todo/delete"
						method="post" modelAttribute="todoForm"
						cssStyle="display: inline-block;">
						<!-- (2) -->
						<form:hidden path="todoId" value="${todo.todoId}" />
						<input type="submit" value="Delete" />
					</form:form></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>
