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
        .img{
            width:100%;
            padding-right:40px;
            padding-left:40px;
            margin-bottom: 40px;
            margin-right:auto;
            margin-left:auto
        }
        .basicinfo{
            width: 100%;
            border-style: solid;
            border-color:#FDF5E6;
        }
        .title{
            margin-top: 50px;
            margin-left: 30px;
            margin-right: 30px;
            padding-left: 30px;
            padding-top: 5px;
            padding-bottom: 5px;
            border-left-style: solid;
            border-left-color: #0b6cbc;
            border-left-width: 10px;
            border-right-style:solid;
            border-right-color:transparent;
            border-top-style:solid;
            border-top-color:transparent;
            border-bottom-style:solid;
            border-bottom-color:transparent;
            background:#B0E0E6;
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
            <div class="col-md-6 ">
                <p class="lead">计算机网络与信息安全实验室</p>
                <p >Computer Networks & Information Security Lab</p>
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
                <li class="nav-item">
                    <a class="nav-link" href="../../../home.jsp">主页 <span class="sr-only">(current)</span></a>
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
                        <a class="dropdown-item" href="/visitor/paper">按年查找</a>
                        <!--<div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="/visitor/paper?time=2017">按研究领域进行查找</a>-->
                    </div>
                </li>
                <li class="nav-item dropdown active">
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
        <div class="row ">
            <c:if test="${usertype==0}">
                <!--基本信息栏-->
                <div class="basicinfo">
                    <p class="lead title">
                        基本信息
                    </p>
                    <div class="row">
                        <div class="col-md-6">
                            <p style="margin-left: 30px;">
                                姓名： ${teacher.user.realname}<br/>
                                性别：<c:if test="${teacher.user.sex==0}">男</c:if> <c:if test="${teacher.user.sex==1}">女</c:if><br>
                                所属部门：${teacher.college}<br>
                                职称：<c:if test="${teacher.trank==0}">讲师</c:if>
                                <c:if test="${teacher.trank==1}">助理教授</c:if>
                                <c:if test="${teacher.trank==2}">副教授</c:if>
                                <c:if test="${teacher.trank==3}">教授</c:if><br>
                                学历：${teacher.edubg}<br>
                                电子邮件：${teacher.tmail}<br>
                                社会服务：${teacher.service}<br>
                            </p>
                        </div>
                        <div class="col-md-6">
                            <img src="${teacher.user.imgurl}" height="200px" alt="userpic">
                        </div>
                    </div>
                </div>
                <!--教育经历和工作经历-->
                <div class="basicinfo">
                    <p class="lead title">
                        教育经历
                    </p>
                    <p style="margin-left: 30px;">
                            ${teacher.teduexp}
                    </p>
                    <p class="lead title">
                        工作经历
                    </p>
                    <p style="margin-left: 30px;">
                            ${teacher.workexp}
                    </p>
                </div>
            </c:if>
            <c:if test="${usertype==1}">
                <!--基本信息栏-->
                <div class="basicinfo">
                    <p class="lead title">
                        基本信息
                    </p>
                    <div class="row">
                        <div class="col-md-6">
                            <p style="margin-left: 30px;">
                                姓名： ${student.user.realname}<br/>
                                性别：<c:if test="${student.user.sex==0}">男</c:if> <c:if test="${student.user.sex==1}">女</c:if><br>
                                所属部门：${student.college}<br>
                                类别：<c:if test="${student.srank==0}">本科生</c:if>
                                <c:if test="${student.srank==1}">硕士生</c:if>
                                <c:if test="${student.srank==2}">博士生</c:if><br>
                                电子邮件：${student.smail}<br>
                                入学时间：${student.entertime}<br>
                            </p>
                        </div>
                        <div class="col-md-6">
                            <img src="${student.user.imgurl}" height="200px" alt="userpic">
                        </div>
                    </div>
                </div>
                <!--教育经历和工作经历-->
                <div class="basicinfo">
                    <p class="lead title">
                        教育经历
                    </p>
                    <p style="margin-left: 30px;">
                            ${student.stueduexp}
                    </p>
                    <p class="lead title">
                        毕业去向
                    </p>
                    <p style="margin-left: 30px;">
                            ${student.wheretogo}
                    </p>
                </div>
            </c:if>
            <c:if test="${usertype==2}">
                <!--基本信息栏-->
                <div class="basicinfo">
                    <p class="lead title">
                        基本信息
                    </p>
                    <div class="row">
                        <div class="col-md-6">
                            <p style="margin-left: 30px;">
                                姓名： ${cooperator.user.realname}<br/>
                                性别：<c:if test="${cooperator.user.sex==0}">男</c:if> <c:if test="${cooperator.user.sex==1}">女</c:if><br>
                                公司：${cooperator.company.coname}<br>
                                头衔：${cooperator.title}<br>
                                电子邮件：${cooperator.cmail}<br>
                                工作职务：${cooperator.cduty}<br>
                            </p>
                        </div>
                        <div class="col-md-6">
                            <img src="${cooperator.user.imgurl}" height="200px" alt="userpic">
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>