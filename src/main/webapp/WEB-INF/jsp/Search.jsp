<!-- Fetch the layout -->
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- What title should be on this page? -->
<t:layout su_title="Search results">
    <jsp:attribute name="su_content"><!-- Implement the su_content html block -->

        <div class="container">
            <div class="jumbotron">

                <h1>Search Page</h1>
                <%--${requestScope['javax.servlet.forward.request_uri']}--%>
				<ol>
                    <c:forEach items="${results}" var="item">
						<li><a href="/clip/${item.name}.${item.ext}">${item.name}</li>
					</c:forEach>
				</ol>
            </div>
        </div>

    </jsp:attribute>
</t:layout>