<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:layout su_title="SoundClip ${action}" su_header="${action}">
    <jsp:attribute name="su_content">
		<c:choose>
			<c:when test="${not empty err}">
				<p>${err}</p>
			</c:when>

			<c:when test="${(action=='Upload' || action=='Play') && not empty soundclip}">
				<p>Filename: ${soundclip.getName()}</p>
				<c:choose>
					<c:when test="${not empty user}">
						<p>Uploader: ${user.getName()}</p>
					</c:when>
				</c:choose>
				<audio controls autoplay="true" loop="false"> 
					<source src="data:audio/${soundclip.getExt()};base64,${soundclip.getBase64Str()}">
				</audio>
				<br>
				<a href="/soundclip/play/${soundclip.getName()}">Copy this link address to share this sound clip with friends!</a>
			</c:when>
			
			<c:when test="${action=='Search results' && not empty soundclips}">
				<%--${requestScope['javax.servlet.forward.request_uri']}--%>
				<p>Your search for "${searchTerm}" returned these results:</p>
				<ol>
                    <c:forEach items="${soundclips}" var="s">
						<c:choose>
							<c:when test="${!s.getIsPrivate() || user.getName().equals(s.getUploader())}">
								<li>
									<a href="/soundclip/play/${s.getName()}">${s.getName()}</a>
									<c:choose>
										<c:when test="${empty s.getUploader()}">
											<span> Uploaded by: Guest.</span>
										</c:when>
										<c:when test="${not empty user && user.getName().equals(s.getUploader())}">
											<span> Uploaded by: You</span>
										</c:when>
										<c:otherwise><span>Uploaded by: ${s.getUploader()}. </span></c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${not empty user && user.getName().equals(s.getUploader())}">
											<span> (private).</span>
										</c:when>
									</c:choose>
								</li>
							</c:when>
						</c:choose>
					</c:forEach>
				</ol>
			</c:when>
			
			<c:otherwise>
				Something went wrong...
			</c:otherwise>
		</c:choose>
    </jsp:attribute>
</t:layout>