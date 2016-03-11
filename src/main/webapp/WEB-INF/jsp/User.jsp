<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:layout su_title="User ${action}" su_header="${action}">
    <jsp:attribute name="su_content">
		<c:choose>
			<c:when test="${not empty err}">
				<p>${err}</p>
			</c:when>

			<c:when test="${not empty user}">
				<p>You're logged in as: ${user.getName()}</p>
				<form method="POST" action="/user/logout">
					<button type="submit" class="btn btn-danger">Logout</button>
				</form>
			</c:when>

			<c:otherwise>
				<form method="POST" action="/user/${action.toLowerCase()}">
					<div class="form-group">
						<p>
							<label for="user">Username:
								<input id="user" name="name" type="text">
							</label>
						</p>
						<p>
							<label for="pass">Password:
								<input id="pw" name="pw" type="password">
							</label>
						</p>
					</div>
					<button type="submit" class="btn btn-primary">${action}</button>
				</form>
			</c:otherwise>
		</c:choose>
    </jsp:attribute>
</t:layout>