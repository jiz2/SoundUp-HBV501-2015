<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<div class="navbar-header">
			<button class="navbar-toggle" data-target="#navbar" data-toggle="collapse" type="button">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<%--<a class="navbar-brand" data-target="#aboutProject" data-toggle="modal" href="#" type="button">SoundUp</a>--%>
			<a class="navbar-brand" href="/" type="button">SoundUp</a>
		</div>
		<div class="navbar-collapse collapse" id="navbar">
			<ul class="nav navbar-nav navbar-left btn-group">
				<li>
					<a data-target="#advancedSearch" data-toggle="modal" href="#" type="button">Advanced</a>
				</li>
			</ul>
			<div class="navbar-form navbar-right btn-group">
				<!--
				<button class="btn btn-primary" data-target="#viewBookings" data-toggle="modal" type="button">Sign in</button>
				<button class="btn btn-primary" data-target="#viewDownloads" data-toggle="modal" type="button">Sign up</button>
				-->
				<a class="btn btn-primary" href="./user" role="button">Sign in</a>
				<a class="btn btn-primary" href="./user" role="button">Sign out</a>
			</div>
			<form class="navbar-form" method="POST" action="/search" id="searchForm" name="searchForm" role="search">
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-btn">
							<button aria-expanded="false" class="btn btn-default dropdown-toggle"data-toggle="dropdown" type="button">
								All <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" role="menu">
								<li>
									<a href="#">All</a>
								</li>
								<li>
									<a href="#">Concert</a>
								</li>
								<li>
									<a href="#">TV program</a>
								</li>
							</ul>
						</div>
						<input autofocus="" class="form-control" id="searchInput" name="term" placeholder="Search" type="text">
						<span class="input-group-addon">
							<span class="glyphicon glyphicon-search"></span>
						</span>
					</div>
				</div>
			</form>
		</div>
	</div>
</nav>