<%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Ingreso al sistema</title>
	
		<style>
			.error {
				padding: 15px;
				margin-bottom: 20px;
				border: 1px solid transparent;
				border-radius: 4px;
				color: #a94442;
				background-color: #f2dede;
				border-color: #ebccd1;
			}
			
			.msg {
				padding: 15px;
				margin-bottom: 20px;
				border: 1px solid transparent;
				border-radius: 4px;
				color: #31708f;
				background-color: #d9edf7;
				border-color: #bce8f1;
			}

			#login-box {
				width: 300px;
				padding: 20px;
				margin: 100px auto;
				background: #fff;
				-webkit-border-radius: 2px;
				-moz-border-radius: 2px;
				border: 1px solid #000;
			}
		</style>
	</head>
	
	<body onload="document.f.j_username.focus();">
		
		<div class="msg">
			Bienvenido al sistema<br>
			<p>Locale is: <%= request.getLocale() %></p>
		</div>

		<%-- this form-login-page form is also used as the form-error-page to ask for a login again. --%>
		<c:if test="${not empty param.login_error}">
			<div class="error">	
				No pudieron validarse sus credenciales, intente de nuevo.<br/>
				Motivo: <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>.
			</div>
		</c:if>   
		
		<div id="login-box">
		
			<form name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
				<table>
					<tr>
						<td>Usuario:</td>
						<td><input type='text' name='j_username' value='<c:if test="${ not empty param.login_error }"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>'/></td>
					</tr>
					<tr>
						<td>Clave:</td>
						<td><input type='password' name='j_password'></td>
					</tr>
					<tr>
						<td colspan='2'><input name="submit" type="submit" value="submit" /></td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>
