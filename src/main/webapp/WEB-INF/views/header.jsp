<!-- <div class="container"> -->
<!-- 	<header> -->
		<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="#">User ${pageContext.request.userPrincipal.name}</a>
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false">
						<span class="sr-only">Menu</span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
						<span class="icon-bar"></span>
					</button>
				</div>
				<div class="collapse navbar-collapse" id="navbar-collapse">
					<ul class="nav navbar-nav">
						<li><a href="${pageContext.request.contextPath}/reDirectAdmin"> Admin</a></li>
						<li><a href="${pageContext.request.contextPath}/reDirectClass"> Class</a></li>
						<li><a href="${pageContext.request.contextPath}/reDirectShift"> Shift</a></li>
						<li><a href="${pageContext.request.contextPath}/sessionHome"> Session</a></li>
						<li><a href="${pageContext.request.contextPath}/studentOtherInfo"> Student Detail</a></li>
						<li><a href="${pageContext.request.contextPath}/reDirectStudent"> Student</a></li>
					</ul>
					<a type="button" href="${pageContext.request.contextPath}/logout" class="btn btn-default navbar-btn navbar-right">Log out</a>
				</div>
			</div>
		</nav>
	</header>