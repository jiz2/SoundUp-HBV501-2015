<!-- Fetch the layout -->
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- What title should be on this page? -->
<t:layout su_title="Result">
    <jsp:attribute name="su_content"><!-- Implement the su_content html block -->

        <div class="container">
            <div class="jumbotron">

                <h1>Result Page</h1>
                <%--${requestScope['javax.servlet.forward.request_uri']}--%>
                <c:choose>
                    <%--If Error has occured--%>
                    <c:when test="${not empty errMsg}">
                        <p>${errMsg}</p>
                    </c:when>

                    <%--File Testing--%>
                    <c:when test="${not empty name}">
                        <p>Filename: ${name}</p>
                        <audio controls autoplay="true" loop="false"> 
							<source src="data:audio/${ext};base64,${data}">
						</audio>
                    </c:when>

                    <%--Display Result Link otherwise--%>
                    <c:otherwise>
                        <a href=${url}><p>Click here to view your uploaded file.</p></a>
                    </c:otherwise>
                </c:choose>

            </div>
        </div>

    </jsp:attribute>
</t:layout>