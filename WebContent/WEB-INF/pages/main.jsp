<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String url = application.getContextPath() + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Creative - Start Bootstrap Theme</title>

<link href="<%=url %>resources/external/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=url %>resources/external/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800' rel='stylesheet' type='text/css'>
<link	href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic,900,900italic' rel='stylesheet' type='text/css'>
<link href="<%=url %>resources/external/vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

<!-- Theme CSS -->
<link href="<%=url %>resources/external/css/creative.min.css" rel="stylesheet">
<link href="<%=url %>resources/custom/css/main.css" rel="stylesheet">

</head>

<body id="page-top">

	<nav id="mainNav" class="navbar navbar-default navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
					<span class="sr-only">Toggle navigation</span> 
					Menu <i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand page-scroll" href="#page-top">Trend Tracker</a>
			</div>

			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-left">
					<li><a href="category?majorNum=100">뉴스</a></li>
					<li><a href="category?majorNum=101">스포츠</a></li>
					<li><a href="category?majorNum=102">문화</a></li>
					<li><a href="category?majorNum=103">여행</a></li>
					<li><a href="category?majorNum=104">KT그룹</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li class="dropdown ">
						<a href="#" class="dropdown-toggle" data-toggle="dropdown">User Info
							<b class="caret"></b>
						</a>
						<span class="dropdown-arrow"></span>
						<ul class="dropdown-menu">
							<li>
								<a href="#" data-toggle="modal" data-target="#login-modal">Login</a>
							</li>
							<br>
							<li>
								<a href="<%=url %>signUp.html">Sign up</a>
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

	<header>
		<div class="header-content">
			<div class="header-content-inner">
				<h1 id="homeHeading">멘트1</h1>
				<hr>
				<p>멘트2</p>
				<div style="padding: 30px auto;">
					<a href="#ageTrend" class="btn btn-primary btn-xl page-scroll"
						style="margin-right: 20px;">나이 별 트렌드</a>
					<a href="#genderTrend" class="btn btn-warning btn-xl page-scroll"
						style="margin-left: 20px;">성별 별 트렌드</a>
				</div>
			</div>
		</div>
	</header>

	<section id="ageTrend">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">나이 별 트렌드</h2>
					<hr class="primary">
				</div>
			</div>
		</div>
		<div class="container">
			<div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box">
						<i class="fa fa-4x fa-diamond text-primary sr-icons"></i>
						<h3>아이콘 1</h3>
						<p class="text-muted">설명 1</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box">
						<i class="fa fa-4x fa-paper-plane text-primary sr-icons"></i>
						<h3>아이콘 2</h3>
						<p class="text-muted">설명 2</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box">
						<i class="fa fa-4x fa-newspaper-o text-primary sr-icons"></i>
						<h3>아이콘 3</h3>
						<p class="text-muted">설명 3</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box">
						<i class="fa fa-4x fa-heart text-primary sr-icons"></i>
						<h3>아이콘 4</h3>
						<p class="text-muted">설명 4</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<section class="no-padding" id="portfolio">
		<div class="container-fluid">
			<div class="row no-gutter popup-gallery">
				<div class="col-lg-4 col-sm-6">
					<a href="#ageInfo" class="page-scroll portfolio-box"> 
						<img src="<%=url %>resources/img/portfolio/thumbnails/1.jpg" class="img-responsive" alt="" />
						<div id="10-age" class="portfolio-box-caption age-caption">
							<div class="portfolio-box-caption-content">
								<div class="project-name">10대</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a href="#ageInfo" class="page-scroll portfolio-box">
						<img src="<%=url %>resources/img/portfolio/thumbnails/2.jpg" class="img-responsive" alt="" />
						<div id="20-age" class="portfolio-box-caption age-caption">
							<div class="portfolio-box-caption-content">
								<div class="project-name">20대</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a href="#ageInfo" class="page-scroll portfolio-box">
						<img src="<%=url %>resources/img/portfolio/thumbnails/3.jpg" class="img-responsive" alt="">
						<div id="30-age" class="portfolio-box-caption age-caption">
							<div class="portfolio-box-caption-content">
								<div class="project-name">30대</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a href="#ageInfo" class="page-scroll portfolio-box">
					<img src="<%=url %>resources/img/portfolio/thumbnails/4.jpg" class="img-responsive" alt="">
						<div id="40-age" class="portfolio-box-caption age-caption">
							<div class="portfolio-box-caption-content">
								<div class="project-name">40대</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a href="#ageInfo" class="page-scroll portfolio-box">
					<img src="<%=url %>resources/img/portfolio/thumbnails/5.jpg" class="img-responsive" alt="">
						<div id="50-age" class="portfolio-box-caption age-caption">
							<div class="portfolio-box-caption-content">
								<div class="project-name">50대</div>
							</div>
						</div>
					</a>
				</div>
				<div class="col-lg-4 col-sm-6">
					<a href="#ageInfo" class="page-scroll portfolio-box">
					<img src="<%=url %>resources/img/portfolio/thumbnails/6.jpg" class="img-responsive" alt="">
						<div id="60-age" class="portfolio-box-caption age-caption">
							<div class="portfolio-box-caption-content">
								<div class="project-name">60대</div>
							</div>
						</div>
					</a>
				</div>
			</div>
		</div>
	</section>

	<section id="ageInfo">
		<div class="box age-transform col-xs-12">
			<div id="10-age-info">
				<p class="age-inactive">10대 정보</p>
			</div>
			<div id="20-age-info">
				<p class="age-inactive">20대 정보</p>
			</div>
			<div id="30-age-info">
				<p class="age-inactive">30대 정보</p>
			</div>
			<div id="40-age-info">
				<p class="age-inactive">40대 정보</p>
			</div>
			<div id="50-age-info">
				<p class="age-inactive">50대 정보</p>
			</div>
			<div id="60-age-info">
				<p class="age-inactive">60대 정보</p>
			</div>
		</div>
	</section>
	<br><br><br><br><br><br>
	
	<section id="genderTrend">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 text-center">
					<h2 class="section-heading">성별 별 트렌드</h2>
					<hr class="primary">
				</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box">
						<i class="fa fa-4x fa-diamond text-primary sr-icons"></i>
						<h3>아이콘 1</h3>
						<p class="text-muted">설명 1</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box">
						<i class="fa fa-4x fa-paper-plane text-primary sr-icons"></i>
						<h3>아이콘 2</h3>
						<p class="text-muted">설명 2</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box">
						<i class="fa fa-4x fa-newspaper-o text-primary sr-icons"></i>
						<h3>아이콘 3</h3>
						<p class="text-muted">설명 3</p>
					</div>
				</div>
				<div class="col-lg-3 col-md-6 text-center">
					<div class="service-box">
						<i class="fa fa-4x fa-heart text-primary sr-icons"></i>
						<h3>아이콘 4</h3>
						<p class="text-muted">설명 4</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	
	<section class="no-padding" id="portfolio">
		<div class="container-fluid">
			<div class="row">
				<div class="col-xs-6">
					<a href="#genderInfo" class="page-scroll portfolio-box">
					<img src="<%=url %>resources/img/portfolio/thumbnails/1.jpg" class="img-responsive" alt="">
						<div id="male" class="portfolio-box-caption gender-caption">
							<div class="portfolio-box-caption-content">
								<div class="project-name">남성</div>
							</div>
						</div>
					</a>
				</div>
				<!-- <div class="col-lg-4 col-sm-4"> -->
				<div class="col-xs-6">
					<a href="#genderInfo" class="page-scroll portfolio-box">
						<img src="<%=url %>resources/img/portfolio/thumbnails/2.jpg" class="img-responsive" alt="">
						<div id="female" class="portfolio-box-caption gender-caption">
							<div class="portfolio-box-caption-content">
								<div class="project-name">여성</div>
							</div>
						</div>
					</a>
				</div>
			</div>
		</div>
	</section>
	
	
	<section id="genderInfo">
		<div class="box age-transform col-xs-12">
			<div id="male-info">
				<p class="age-inactive">남성 정보</p>
			</div>
			<div id="female-info">
				<p class="age-inactive">여성 정보</p>
			</div>
	</section>

 	<hr>
	<section id="contact">
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
	</section>

	<div class="modal fade" id="login-modal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="display: none;">
	    <div class="modal-dialog">
	    	<div class="loginmodal-container">
	    		<h1>Login to Your Account</h1><br>
		    	<form action="trend/login">
		    		<input type="text" name="user" placeholder="Username">
		    		<input type="password" name="pass" placeholder="Password">
		    		<input type="submit" name="login" class="login loginmodal-submit" value="Login">
		    	</form>
	    	</div>
	    </div>
	</div>
	
	<script src="<%=url %>resources/external/vendor/jquery/jquery.min.js"></script>
	<script src="<%=url %>resources/external/vendor/bootstrap/js/bootstrap.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>
	<script src="<%=url %>resources/external/vendor/scrollreveal/scrollreveal.min.js"></script>
	<script src="<%=url %>resources/external/vendor/magnific-popup/jquery.magnific-popup.min.js"></script>
	<script src="<%=url %>resources/external/js/creative.js"></script>
	<script src="<%=url %>resources/custom/js/main.js"></script>
</body>
</html>
