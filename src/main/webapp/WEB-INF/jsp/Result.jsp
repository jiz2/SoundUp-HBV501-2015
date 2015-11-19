<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html lang="en">

    <head>
        <title>Result Page</title>
    </head>
    <body>

	    <h1>Result Page</h1>
	    <p>Here is the link to your uploaded file.</p>

	    <p>Local Filepath: ${localURI}</p>
	    <p>Database Filepath: ${soundURI}</p>
	    <p>Url: ${url}</p>

    </body>

</html>
