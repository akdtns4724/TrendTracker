<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String url = application.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Creative - Start Bootstrap Theme</title>

<link href="<%=url%>resources/external/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=url%>resources/external/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<link href="<%=url%>resources/external/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="<%=url%>resources/external/css/creative.min.css" rel="stylesheet">
<link href="<%=url%>resources/external/css/styles.css" rel="stylesheet">
<link href="<%=url%>resources/custom/css/main.css" rel="stylesheet">
<link href="<%=url%>resources/custom/css/categoryView.css" rel="stylesheet">

</head>


<body id="page-top">

	<nav id="top-nav" class="navbar navbar-default navbar-fixed-top affix">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> Menu <i
					class="fa fa-bars"></i>
			</button>
			<a class="navbar-brand page-scroll" href="<%=url %>trend/">Trend Tracker</a>
		</div>

		<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-left">
				<li><a href="<%=url %>trend/category?majorNum=100">뉴스</a></li>
				<li><a href="<%=url %>trend/category?majorNum=101">스포츠</a></li>
				<li><a href="<%=url %>trend/category?majorNum=102">문화</a></li>
				<li><a href="<%=url %>trend/category?majorNum=103">여행</a></li>
				<li><a href="<%=url %>trend/category?majorNum=104">KT그룹</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="dropdown ">
					<a href="#" class="dropdown-toggle" data-toggle="dropdown">User Info
						<b class="caret"></b>
					</a>
					<span class="dropdown-arrow"></span>
					<ul class="dropdown-menu">
						<li>
							<a href="#">Login</a>
						</li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<form class="navbar-form" role="search keyword" action="<%=url %>trend/keyword" method="POST">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="Search" name="keyword" id="keyword">
						<div class="input-group-btn">
							<button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
						</div>
					</div>
					</form>
			</ul>
		</div>
	</div>
	</nav>


	<div id="nav-content" class="row">
		<div class="col-sm-2">
			<div class="row">
				<div>
					<c:forEach items="${requestScope.category }" var="category">
						<ul class="nav nav-stacked collapse in" id="userMenu">
							<li class="active">
								<a href="#">${category.category }</a>
							</li>
						</ul>
					</c:forEach>
				</div>
			</div>
		</div>

		<div class="col-sm-9">
			<div class="row">
				<img src="<%=url %>resources/img/header.jpg" width="100%" height="300px" />
			</div>
			<div class="row">
				<div id="queries_div" class="col-sm-6">
					<table class="table table-striped">
						    <tr>
						        <th>#</th>
						        <th>연관 검색어</th>
						    </tr>
					</table>
				</div>
				<div id="topics_div" class="col-sm-6">
					<table class="table table-striped">
						    <tr>
						        <th>#</th>
						        <th>연관 주제</th>
						    </tr>
					</table>
				</div>
			</div>
			<div id="chart_div" class="row">
			</div>
		</div>
		
		
	</div>
	
	<div class="row">
		<hr>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 text-center">
					<h2 class="section-heading">제작자 정보</h2>
					<hr class="primary">
					<p>제작자 설명</p>
				</div>
				<div class="col-lg-4 col-lg-offset-2 text-center">
					<i class="fa fa-phone fa-3x sr-contact"></i>
					<p>전화번호</p>
				</div>
				<div class="col-lg-4 text-center">
					<i class="fa fa-envelope-o fa-3x sr-contact"></i>
					<p>
						<a href="mailto:your-email@your-domain.com">이@메.일</a>
					</p>
				</div>
			</div>
		</div>
	</div>
	<script src="<%=url%>resources/external/vendor/jquery/jquery.min.js"></script>
	<script src="<%=url %>resources/external/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="<%=url %>resources/external/vendor/scrollreveal/scrollreveal.min.js"></script>
	<script src="<%=url %>resources/external/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
	<script src="<%=url %>resources/external/js/creative.js"></script>
	<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
	<script src="<%=url %>resources/custom/js/categoryView.js"></script>
	<script>
		$(document).ready(function(){
			console.log('${requestScope.major.major}');
			
			google.charts.load('current', {packages: ['corechart', 'line']});
			google.charts.setOnLoadCallback(makeChart('${requestScope.major.major}'));
			
			makeQueries('${requestScope.major.major}');
			makeTopics('${requestScope.major.major}');
		});
	
		$(window).resize(function (){
			google.charts.load('current', {packages: ['corechart', 'line']});
			google.charts.setOnLoadCallback(makeChart('${requestScope.major.major}'));
		});
	</script>
</body>
</html>
