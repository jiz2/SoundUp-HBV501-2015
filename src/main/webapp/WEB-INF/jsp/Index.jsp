<!-- Fetch the layout -->
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- What title should be on this page? -->
<t:layout su_title="Home">

<jsp:attribute name="su_content"><!-- Implement the su_content html block -->
    <div class="container">

        <div class="jumbotron">
            <h1>Welcome to SoundUp</h1>
            <p>
				This is just a demo of the final product.
			</p>
            <form method="POST" enctype="multipart/form-data" action="/upload">
				<div class="form-group">
					<label for="sound">File to upload:</label>
					<input id="sound" name="file" type="file">
                    <c:choose>
                        <c:when test="${not empty sessionScope.user}">
                            <label>
                                <input id="private" name="private" type="checkbox"/>Private?
                            </label>
                        </c:when>
                        <c:otherwise>
                            <%--Nothing--%>
                        </c:otherwise>
                    </c:choose>
				</div>
				<button type="submit" class="btn btn-primary">Upload</button>
            </form>
        </div>

    </div>
</jsp:attribute>

</t:layout>