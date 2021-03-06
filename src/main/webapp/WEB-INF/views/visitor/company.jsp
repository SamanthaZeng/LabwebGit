<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>科研实验室管理系统</title>
    <meta name="keywords" content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文" />
    <meta name="description" content="站长素材提供Bootstrap模版,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!--<link href="theme.css" rel="stylesheet" type="text/css">-->
    <link href="/bootstrap/assets/css/theme.css" rel="stylesheet" />

    <!--pingendo-->
    <!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" >-->

    <style>
        /*   @import url(bootstrap/assets/css/bootstrap.min.css);/*这里是通过@import引用CSS的样式内容*/
        /*     @import url(bootstrap/assets/css/font-awesome.min.css);
             @import url(bootstrap/assets/css/datepicker.css);
             @import url(bootstrap/assets/css/jquery-ui-1.10.3.custom.min.css);
             @import url(http://fonts.googleapis.com/css?family=Open+Sans:400,300);
             @import url(bootstrap/assets/css/ace.min.css);
             @import url(bootstrap/assets/css/ace-rtl.min.css);
             @import url(https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css);*/
        html,body{
            height: 100%;
            background-color: #f1f1f1;
        }
    </style>
</head>

<body>
<div style="background-color:#49beb7">
    <div style="padding-top: 5em;padding-bottom:5em;">
        <div class="container">
            <div class="row" style="justify-content:  center">
                <div style="vertical-align: middle;text-align: center">
                    <p style="color: #005542;font-size: xx-large;">科研实验室管理系统</p>
                    <p class="lead" >scientific research laboratory management system</p>
                </div>
            </div>
        </div>
    </div>
</div>

<div>
    <div style="background-color:#ffbe00;width: 100%;height: 0.5rem"></div>
    <nav class="navbar navbar-expand-lg navbar-dark" style="background-color: #005542">
        <div class="container">
            <!--<a class="navbar-brand" href="#">NKU</a>-->
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent"  style="justify-content: space-between">
                <ul class="navbar-nav" style="width:80%;justify-content: space-around" >
                    <li class="nav-item">
                        <a class="nav-link" href="/visitor/home">主页 <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            人员
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/visitor/user?usertype=0">教师</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/visitor/user?usertype=1&srank=2">博士生</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/visitor/user?usertype=1&srank=1">硕士生</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/visitor/user?usertype=1&srank=0">本科生</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            研究方向
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <c:forEach items="${researchareas}" var="research" varStatus="index">
                                <a class="dropdown-item" href="/visitor/research?rid=${research.rid}">${research.rname}</a>
                                <c:if test="${index.count!=rsize}">
                                    <div class="dropdown-divider"></div>
                                </c:if>
                            </c:forEach>
                        </div>
                    </li>
                     <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            项目
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/visitor/project?protype=1">横向项目</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/visitor/project?protype=0">纵向项目</a>
                        </div>
                    </li>
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            论文
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/visitor/paper?papertype=-1">论文总览</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="/visitor/paper?papertype=1">会议论文</a>
              <div class="dropdown-divider"></div>
              <a class="dropdown-item" href="/visitor/paper?papertype=2">期刊论文</a>
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
                    <li class="nav-item dropdown active">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            合作交流
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a class="dropdown-item" href="/visitor/company">合作单位</a>
                            <div class="dropdown-divider"></div>
                            <a class="dropdown-item" href="/visitor/user?usertype=2">合作者</a>
                        </div>
                    </li>
                </ul>
                <ul class="navbar-nav my-2 my-lg-0 mr-0" >
                    <li class="nav-item"><a class="nav-link" href="/visitor/login">登录</a></li>
                    <li class=" nav-item"><a class="nav-link" href="/visitor/login">注册</a></li>
                </ul>
            </div>
        </div>
    </nav>
</div>

<div class="container" style="background-color: #fff;min-height: 100%">
    <div style="padding-top: 5em;min-height: 400px">
        <div class="row">
            <c:forEach items="${companies}" var="company" varStatus="index">
                <div class="col-lg-4 p-3 col-md-4">
                    <div class="card text-white mb-3" style="max-width: 18rem;background-color: #49beb7">
                        <div class="card-header">

                        </div>
                        <div class="container">
                            <a href="${company.copage}">
                                <img class="card-img" src="${company.logourl}"  alt="公司图标">
                            </a>
                        </div>
                        <div class="card-body">
                            <h5 class="card-title">${company.coname}</h5>
                            <p class="card-text">公司类型:<c:choose>
                                <c:when test="${company.cotype == -1}">
                                    其他
                                </c:when>
                                <c:when test="${company.cotype == 0}">
                                    互联网公司
                                </c:when>
                                <c:when test="${company.cotype == 1}">
                                    金融公司
                                </c:when>
                                <c:when test="${company.cotype == 2}">
                                    教育类公司
                                </c:when>
                                <c:when test="${company.cotype == 3}">
                                    自媒体公司
                                </c:when>
                                <c:when test="${company.cotype == 4}">
                                    科研院所
                                </c:when>
                                <c:when test="${company.cotype == 5}">
                                    高校
                                </c:when>
                            </c:choose></p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>