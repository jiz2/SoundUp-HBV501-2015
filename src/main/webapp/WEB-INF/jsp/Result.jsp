<!-- Fetch the layout -->
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- What title should be on this page? -->
<t:layout su_title="Result">
    <jsp:attribute name="su_content"><!-- Implement the su_content html block -->

        <div class="container">
            <div class="jumbotron">

                <h1>Result Page (Still a placeholder)</h1>
                <%--${requestScope['javax.servlet.forward.request_uri']}--%>
                <c:choose>
                    <%--If Error has occured--%>
                    <c:when test="${not empty errMsg}">
                        <p>${errMsg}</p>
                    </c:when>

                    <%--Display Result Link otherwise--%>
                    <c:otherwise>
                        <p>Url: ${url}</p>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>

    </jsp:attribute>
</t:layout>