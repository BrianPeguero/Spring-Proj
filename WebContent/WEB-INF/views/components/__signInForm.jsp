<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="signIn" method="post" modelAttribute="userSignIn">
	<div class="form-field">
		<label>Email</label>
		<form:input type="email" path="email" />
		<form:errors path="email" cssClass="error" />
	</div>
	<div class="form-field">
		<label>Password</label>
		<form:input type="password" path="password" />
		<form:errors path="password" cssClass="error" />
	</div>
	<div class="button">
		<input type="submit" value="submit" name="submit" />
	</div>
</form:form>