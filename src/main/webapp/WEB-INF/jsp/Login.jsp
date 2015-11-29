<!-- Fetch the layout -->
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- What title should be on this page? -->
<t:layout su_title="Login">
    <jsp:attribute name="su_content"><!-- Implement the su_content html block -->

        <div class="container">
            <div class="jumbotron">

                <h1>Login</h1>

                <c:choose>
                    <%--If Error has occured--%>
                    <c:when test="${not empty err}">
                        <p>${err}</p>
                    </c:when>

                    <%--If user exist--%>
                    <c:when test="${not empty sessionScope.user}">
                        <c:redirect url="/"/>
                    </c:when>

                    <%--Display Registration Form otherwise--%>
                    <c:otherwise>
                        <form method="POST" action="/login">
                            <div class="form-group">
                                <p>
                                    <label for="user">Username:
                                        <input id="user" name="user" type="text">
                                    </label>
                                </p>
                                <p>
                                    <label for="pass">Password:
                                        <input id="pass" name="pass" type="password">
                                    </label>
                                </p>
                            </div>
                            <button type="submit" class="btn btn-primary">Login</button>
                        </form>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>

    </jsp:attribute>
</t:layout>