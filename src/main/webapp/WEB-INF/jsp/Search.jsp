<!-- Fetch the layout -->
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- What title should be on this page? -->
<t:layout su_title="Result">
    <jsp:attribute name="su_content"><!-- Implement the su_content html block -->

        <div class="container">
            <div class="jumbotron">

                <h1>Search Page</h1>
				<p>Search results for: ${searchTerm}</p>
                <%--${requestScope['javax.servlet.forward.request_uri']}--%>
				<ol>
                    <c:forEach var="entry" items="${results}">
						<li><a href="clip/${entry.getName()}">${entry.getName()}</a></li>
					</c:forEach>
				</ol>
            </div>
        </div>

    </jsp:attribute>
</t:layout>