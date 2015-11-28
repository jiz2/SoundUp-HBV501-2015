<!-- Fetch the layout -->
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- What title should be on this page? -->
<t:layout su_title="Registration">
    <jsp:attribute name="su_content"><!-- Implement the su_content html block -->

        <div class="container">
            <div class="jumbotron">

                <h1>Registration</h1>
				
				<p>${msg} ${httpServletRequest.remoteUser}</p>
				
				<div c:if="${param.error}" class="alert alert-error">
					Invalid username and password.
				</div>
				<div c:if="${param.logout}" class="alert alert-success">
					You have been logged out.
				</div>
				
				
				<form action="/login" class="form-signin" method="POST">
					<h2 class="form-signin-heading">Please sign in</h2>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<label for="inputUsername" class="sr-only">User name</label>
					<input type="text" id="username" name="username" class="form-control" placeholder="Username" required autofocus>
					<label for="inputPassword" class="sr-only">Password</label>
					<input type="password" id="password" name="password" class="form-control" placeholder="Password" required>
					<div class="checkbox">
					  <label>
						<input type="checkbox" value="remember-me"> Remember me
					  </label>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
				</form>
            </div>
        </div>

    </jsp:attribute>
</t:layout>