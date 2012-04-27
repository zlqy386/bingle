<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="en">
	<head>
	<meta charset="gkb" />
	<title>Smashing HTML5!</title>

	<link rel="stylesheet" href="/bingle/css/forum.css" type="text/css" />

	<!--[if IE]>
	 <script src="http://html5shiv.googlecode.com/svn/trunk/html5.js"></script><![endif]-->
	<!--[if lte IE 7]>
	 <script src="js/IE8.js" type="text/javascript"></script><![endif]-->

	<!--[if lt IE 7]>
	 <link rel="stylesheet" type="text/css" media="all" href="css/ie6.css"/><![endif]-->
	</head>

	<body id="index" class="home">
		<header id="banner" class="body">
			<h1><img src="/bingle/img/logo.jpg"/></h1>
						
			<nav>
				<ul>
					<li><a href="search.htm">病友</a></li>
					<li><a href="search.htm">病症</a></li>
					<li class="active"><a href="#">交流区</a></li>
				</ul>
				<form action="#" id="search" method="get">
					<input type="search" id="search_word" placeholder="Search this site">
					<input type="submit" value="查找病友" class="search-btn" name="subBtn">
					<input type="submit" value="查找病症" class="search-btn" name="subBtn">
				</form>
			</nav>
		</header>
		<section id="container" class="body">
			<header class="forumHead">
				<div class="forumTitle">
					<a href="../index.htm">病了么</a>
					 - 
					<a href="#">病友论坛</a>
					 -
					<a href="Forum">${tld.topicListName}</a>
				</div>
				<nav class="pageNav">
					<span class="disabled"><=</span>
					<span class="current">1</span>
					<span class="disabled">=></span>
				</nav>
				<input type="button" value="发表新帖" onclick="window.location.href='ForumControlServlet?func=newtopicpage&user=${udi.username}&list=${tld.topicListName}'"/>
			</header>
			<div class="forumResult">
				${table}
			</div>
			<nav class="pageNav">
				<span class="disabled"><=</span>
				<span class="current">1</span>
				<span class="disabled">=></span>
			</nav>
		</section>
		
		<footer id="about" class="body">
			<p>blablabla</p>
		</footer>
		
	</body>
</html>