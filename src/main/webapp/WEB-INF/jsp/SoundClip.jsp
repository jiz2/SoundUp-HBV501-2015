<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<t:layout su_title="SoundClip ${action}" su_header="${action}">
    <jsp:attribute name="su_content">
		<c:choose>
			<c:when test="${not empty err}">
				<p>${err}</p>
			</c:when>

			<c:when test="${(action=='Success' || action=='Play') && not empty soundclip}">
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
				<a href="/soundclip/play/${soundclip.getUrl()}">Copy this link address to share this sound clip with friends!</a>
			</c:when>
			
			<c:when test="${action=='Search results' && not empty soundclips}">
				<%--${requestScope['javax.servlet.forward.request_uri']}--%>
				<ol>
                    <c:forEach items="${soundclips}" var="s">
						<li><a href="/soundclip/play/${s.getUrl()}">${s.name}</a></li>
					</c:forEach>
				</ol>
			</c:when>
			
			<c:otherwise>
				Something went wrong...
			</c:otherwise>
		</c:choose>
    </jsp:attribute>
</t:layout>