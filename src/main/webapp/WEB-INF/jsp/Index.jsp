<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:layout su_title="Home" su_header="Welcome to SoundUp">
<jsp:attribute name="su_content">
	<p>
		Pick a file from your computer and access it from anywhere!
	</p>
	<form method="POST" enctype="multipart/form-data" action="/soundclip/upload">
		<div class="form-group">
			<label for="sound">File to upload (up to 10MB):</label>
			<!--Max 10MB, could validate with js plugin client side-->
			<input id="sound" name="file" type="file" accept="audio/*" required/>
			<c:choose>
				<c:when test="${not empty sessionScope.user}">
					<br>
					<label>Do you want your file to be private?
						<div class="radio">
							<label><input type="radio" name="private" value="true" checked="true">Yes</label>
						</div>
						<div class="radio">
							<label><input type="radio" name="private" value="false" checked="false">No</label>
						</div>
					</label>
				</c:when>
				<c:otherwise>
					<input type="hidden" name="private" value="false" checked="false">
				</c:otherwise>
			</c:choose>
		</div>
		<button type="submit" class="btn btn-primary">Upload</button>
	</form>
</jsp:attribute>
</t:layout>