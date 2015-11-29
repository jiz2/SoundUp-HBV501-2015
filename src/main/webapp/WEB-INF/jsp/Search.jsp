<!-- Fetch the layout -->
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!-- What title should be on this page? -->
<t:layout su_title="Home">

<jsp:attribute name="su_content"><!-- Implement the su_content html block -->
    <div class="container">

        <div class="jumbotron">
            <h1>Results:</h1>
            <p>
				This is what you searched for:
			</p>
			<p>Search term: ${searchTerm}</p>
			<%--<p>Results: ${results}</p>--%>
            </form>
        </div>

    </div>
</jsp:attribute>

</t:layout>