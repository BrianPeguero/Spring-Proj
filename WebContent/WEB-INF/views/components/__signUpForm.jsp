<%@page import="java.util.Map"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="signUp" method="post" modelAttribute="userSigningUp">
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
	<div class="form-field">
		<form:select path="vehicalType">
			<form:options items="${vehicalItems}"/>
		</form:select>
		<form:errors path="vehicalType" cssClass="error"/>
	</div>
	<div class="button">
		<input type="submit" value="submit" name="submit" />
	</div>
</form:form>