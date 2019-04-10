

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

    <link href="/bootstrap/assets/css/bootstrap.min.css" rel="stylesheet" />
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
    <nav class="navbar  navbar-inverse" role="navigation">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">NKU</a>
            </div>
            <div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="home.jsp">主页</a></li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            研究方向
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="researcharea.jsp">A</a></li>
                            <li class="divider"></li>
                            <li><a href="researcharea.jsp">B</a></li>
                            <li class="divider"></li>
                            <li><a href="researcharea.jsp">C</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            论文
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="paper.jsp">2019</a></li>
                            <li class="divider"></li>
                            <li><a href="paper.jsp">2018</a></li>
                            <li class="divider"></li>
                            <li><a href="paper.jsp">2017</a></li>
                        </ul>
                    </li>
                    <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        人员
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="user.jsp">教师</a></li>
                        <li class="divider"></li>
                        <li><a href="user.jsp">学生</a></li>
                        <li class="divider"></li>
                        <li><a href="user.jsp">合作伙伴</a></li>
                    </ul>
                    </li>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                            教学
                            <b class="caret"></b>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="course.jsp">课程</a></li>
                            <li class="divider"></li>
                            <li><a href="book.jsp">教材</a></li>
                        </ul>
                    </li>
                    <li class="dropdown"><a href="project.jsp">项目</a></li>
                </ul>
                <ul class="nav navbar-nav " style="padding-left:30em">
                    <li class="dropdown"><a href="login.jsp">登陆</a></li>
                    <li class="dropdown"><a href="login.jsp">注册</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>
<div style="margin-top: 5em">
    <div class="container">
        <div class="row">
            <div class="col-md-6">
                <h1 class="mb-3">实验室介绍</h1>
                <p class="lead">实验室详细介绍 </p>
            </div>
            <div class="col-md-6">
                <img src="/bootstrap/assets/images/gallery/badge.jpg" alt="NKU" width="150" height="150">
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
                        <a href="#" class="card-link">Card link</a>
                        <a href="#" class="card-link">Another link</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 p-3 col-md-4">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="card-link">Card link</a>
                        <a href="#" class="card-link">Another link</a>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 p-3 col-md-4">
                <div class="card" style="width: 18rem;">
                    <div class="card-body">
                        <h5 class="card-title">Card title</h5>
                        <h6 class="card-subtitle mb-2 text-muted">Card subtitle</h6>
                        <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                        <a href="#" class="card-link">Card link</a>
                        <a href="#" class="card-link">Another link</a>
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