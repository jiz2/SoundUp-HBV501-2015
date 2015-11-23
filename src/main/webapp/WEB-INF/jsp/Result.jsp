<!-- Fetch the layout -->
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<!-- What title should be on this page? -->
<t:layout su_title="Result">
    <jsp:attribute name="su_content"><!-- Implement the su_content html block -->

        <div class="container">

            <div class="jumbotron">
                <h1>Result Page (Still a placeholder)</h1>
                <p>Here is the link to your uploaded file.</p>

                <p>Local Filepath: ${localURI}</p>
                <p>Database Filepath: ${soundURI}</p>
                <p>Url: ${url}</p>
            </div>

        </div>

    </jsp:attribute>
</t:layout>