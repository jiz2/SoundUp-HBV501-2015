<!-- Fetch the layout -->
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %> 

<!-- What title should be on this page? -->
<t:layout su_title="Home">

<jsp:attribute name="su_content"><!-- Implement the su_content html block -->
    <div class="container">

      <div class="jumbotron">
        <h1>Welcome</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce hendrerit ante mi, sit amet consectetur libero vestibulum sed. Ut a tristique quam, in feugiat est. Nullam bibendum justo at suscipit suscipit. Aliquam ac lorem porttitor, maximus velit vitae, volutpat nulla.</p>
        <form method="POST" enctype="multipart/form-data" action="/upload">
			File to upload: <input type="file" name="file">
			Name: <input type="text" name="name">
			<input type="submit" value="Upload">
		</form>
		<ul>
			<li><a href="/postit">Click here for Persistence Layer Demo</a></li>
		</ul>
		<br/>
		<button>
			<a href="./user">To Users</a>
		</button>
		<p>
          <a class="btn btn-lg btn-primary" href="./upload" role="button">Upload a Sound File &raquo;</a>
        </p>
      </div>

    </div>
</jsp:attribute>
 
</t:layout>