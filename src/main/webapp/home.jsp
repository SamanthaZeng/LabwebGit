<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>计算机网络与信息安全研究室后台管理系统</title>
    <meta name="keywords" content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文" />
    <meta name="description" content="站长素材提供Bootstrap模版,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link href="/bootstrap/assets/css/theme.css" rel="stylesheet" />

    <style>
        .carousel-inner img {
            width: 548px;
            height:350px;
        }
    </style>
</head>

<body>
<div style="margin-top: 5em">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <img src="/bootstrap/assets/images/gallery/badge.jpg" alt="NKU" width="150" height="150">
            </div>
            <div class="col-md-6">
                <div style="vertical-align: middle;">
                    <p class="lead">计算机网络与信息安全实验室</p>
                    <p >Computer Networks & Information Security Lab</p>
                </div>
            </div>
        </div>
    </div>
</div>

<div style="margin-top: 5em">
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <a class="navbar-brand" href="#">NKU</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="home.jsp">主页 <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        研究方向
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/visitor/research?rid=1">网络安全态势感知</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/visitor/research?rid=2">移动边缘计算与资源管理</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/visitor/research?rid=3">物联网理论与应用</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       论文
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                       <!--<a class="dropdown-item" href="/visitor/paper?time=2019">2019</a>
                       <div class="dropdown-divider"></div>
                       <a class="dropdown-item" href="/visitor/paper?time=2018">2018</a>
                       <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/visitor/paper?time=2017">2017</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/visitor/paper?time=2016">2016</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/visitor/paper?time=2015">2015</a>-->
                        <a class="dropdown-item" href="/visitor/paper">按年查找</a>
                        <!--<div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/visitor/paper?time=2017">按研究领域进行查找</a>-->
                    </div>
               </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                       人员
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/visitor/user?usertype=0">教师</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/visitor/user?usertype=1">学生</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/visitor/user?usertype=2">合作伙伴</a>
                    </div>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        教学
                    </a>
                    <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="/visitor/course">课程</a>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/visitor/book">教材</a>
                    </div>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/visitor/project">项目</a>
                </li>
            </ul>
            <ul class="navbar-nav my-2 my-lg-0" >
                <li class="nav-item"><a class="nav-link" href="/visitor/login">登陆</a></li>
                <li class=" nav-item"><a class="nav-link" href="/visitor/login">注册</a></li>
            </ul>
        </div>
    </nav>
</div>

<div style="margin-top: 5em">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1 class="mb-3">计算机网络与信息安全实验室</h1>
                <p class="lead text-justify">计算机网络与信息安全研究室成立于1986年，现有教师7名，其中教授3名（其中兼职教授1名）、副教授3名、讲师1名，硕士和博研究生近40名。
                    三十多年来，在刘瑞挺和吴功宜老先生的带领下，研究室坚持以计算机网络和网络安全为核心研究方向，结合互联网技术的高速发展和国家的战略需求，
                    近年来主要在网络安全态势感知、移动边缘计算、车联网、无线传感网络、移动智能终端、软件定义网络等方面开展相关基础理论和应用技术的研究。 </p>
            </div>
            <div class="col-md-6">
                <!--<img src="/bootstrap/assets/images/gallery/badge.jpg" alt="NKU" width="150" height="150">-->
                <div id="picCarousel" class="carousel slide">
                    <!--指示符-->
                    <ul class="carousel-indicators">
                        <li data-target="#picCarousel" data-slide-to="0" class="active"></li>
                        <li data-target="#picCarousel" data-slide-to="1"></li>
                        <li data-target="#picCarousel" data-slide-to="2"></li>
                    </ul>

                    <!-- 轮播图片 -->
                    <div class="carousel-inner">
                        <div class="carousel-item active">
                            <img src="/bootstrap/assets/images/gallery/homepic1.JPG">
                        </div>
                        <div class="carousel-item">
                            <img src="/bootstrap/assets/images/gallery/homepic2.JPG">
                        </div>
                        <div class="carousel-item">
                            <img src="/bootstrap/assets/images/gallery/homepic3.JPG">
                        </div>
                    </div>

                    <!-- 左右切换按钮 -->
                    <a class="carousel-control-prev" href="#picCarousel"  data-slide="prev">
                        <!--<img src="/bootstrap/assets/images/icon/larrow.png">-->
                        <!--<span class="carousel-control-prev-icon"></span>-->
                        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                        <span class="sr-only">Previous</span>
                    </a>
                    <a class="carousel-control-next" href="#picCarousel" data-slide="next">
                        <!--<img src="/bootstrap/assets/images/icon/rarrow.png">-->
                        <span class="carousel-control-next-icon" style="color: #ba4b39"></span>
                    </a>
                </div><!--轮播框-->
            </div>
        </div>
    </div>
</div>
<div style="margin-top: 5em">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 p-3 col-md-4">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="card-link">阅读更多</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 p-3 col-md-4">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="card-link">阅读更多</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 p-3 col-md-4">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="card-link">阅读更多</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>