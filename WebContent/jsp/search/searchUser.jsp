<%@page pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
<title>查找病友</title>

<script type="text/javascript" src="script/jquery.js"></script>
<script type="text/javascript" src="script/thickbox.js"></script>
<link rel="stylesheet" href="css/thickbox.css" type="text/css" media="screen" />
<link rel="stylesheet" href="css/search.css" type="text/css" />

<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
<!--[if lte IE 7]>
	 <script src="../js/IE8.js" type="text/javascript"></script><![endif]-->

<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="../css/ie6.css"/><![endif]-->
</head>

<body id="index" class="home">
	<header id="banner" class="body">
		<h1><img src="/bingle/img/logo.jpg"/></h1>

		<nav>
			<ul>
					<%
						if(!request.getSession().getAttribute("login").equals("1")){
							out.println("<li><a href='/bingle/'>首页</a></li>");
						}
					%>
					<li class='active'><a href="/bingle/SearchControlServlet?searchType=patients">病友</a></li>
					<li><a href="/bingle/SearchControlServlet?searchType=diseases">病症</a></li>
					<li><a href="/bingle/ForumControlServlet?func=ini">交流区</a></li>
					<% if(request.getSession().getAttribute("login").equals("1")){
						out.println("<li><a href='jsp/info/selfInfo.jsp'>控制面板</a></li>");
						out.println("<li><a href='/bingle/LogoutControlServlet'>注销登录</a></li>");
					}
					%>
				</ul>
			<form action="/bingle/SearchControlServlet" id="search" method="get">
				<input type="search" name="keyword" placeholder="Search this site">
				<input type="submit" value="patients" class="search-btn" name="searchType">
				<input type="submit" value="diseases" class="search-btn" name="searchType">
			</form>
		</nav>
	</header>
	<section id="container" class="body">
		<header id="search-list-header"> </header>
		<table id="search-list-context">
			<thead>
				<tr>
					<th>用户名</th>
					<th>性别</th>
					<th>年龄</th>
					<th>近期疾病</th>
					<th>标签</th>
				</tr>
			</thead>
			<tbody>
				${table}
			</tbody>
			<tfoot>
				<tr>
					<td>总计:${total }</td>
					<td></td>
					<td></td>
					<td></td>
					<td>
						<nav class="pageNav">
							${nav }
						</nav>
					</td>
				</tr>
			</tfoot>
		</table>
	</section>

	<footer id="about" class="body">
		<p>blablabla</p>
	</footer>

</body>
</html>
