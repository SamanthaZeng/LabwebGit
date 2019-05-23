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
                    <li class="nav-item dropdown  active" id="user">
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
                    <li class="nav-item dropdown" id="couser">
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
    <div style="padding-top: 5em">
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
                                <c:if test="${teacher.trank==1}">副教授</c:if>
                                <c:if test="${teacher.trank==2}">教授</c:if><br>
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
                    <p style="margin-left: 30px;white-space: pre-line;">
                            ${teacher.teduexp}
                    </p>
                    <p class="lead title">
                        工作经历
                    </p>
                    <p style="margin-left: 30px;white-space: pre-line;">
                            ${teacher.workexp}
                    </p>
                </div>
                <!--论文和项目-->
                <div class="basicinfo">
                    <p class="lead title">
                        发表论文
                    </p>
                    <p style="margin-left: 30px;white-space: pre-line;">
                        <c:forEach items="${papers}" var="paper" varStatus="index">
                            [${index.count}] ${pauthors[index.count-1]}.${paper.ptitile}.${paper.papersource}.${paper.publictime}
                        </c:forEach>
                    </p>
                    <p class="lead title">
                        项目
                    </p>
                    <p style="margin-left: 30px;white-space: pre-line;">
                        <c:forEach items="${projects}" var="project" varStatus="index">
                            [${index.count}] ${proauthors[index.count-1]}.${project.proname}.${project.prosource}.${project.number}
                        </c:forEach>
                    </p>
                </div>
                <!--课程和著作-->
                <div class="basicinfo">
                    <p class="lead title">
                        所授课程
                    </p>
                    <p style="margin-left: 30px;white-space: pre-line;">
                        <c:forEach items="${courses}" var="course" varStatus="index">
                            [${index.count}] ${cauthors[index.count-1]}.${course.name}.${course.coursecode}.${course.classhour}.授课对象：<c:if test="${course.teachingobject==0}">本科生</c:if><c:if test="${course.teachingobject==1}">硕士生</c:if><c:if test="${course.teachingobject==2}">博士生</c:if>,${course.classhour}
                        </c:forEach>
                    </p>
                    <p class="lead title">
                        著作
                    </p>
                    <p style="margin-left: 30px;white-space: pre-line;">
                        <c:forEach items="${books}" var="book" varStatus="index">
                            [${index.count}]${bauthors[index.count-1]}.${book.bookname}.${book.press}.${book.time}.${book.isbn}
                        </c:forEach>
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
                    <p style="margin-left: 30px;white-space: pre-line;">
                            ${student.stueduexp}
                    </p>
                    <p class="lead title">
                        毕业去向
                    </p>
                    <p style="margin-left: 30px;white-space: pre-line;">
                            ${student.wheretogo}
                    </p>
                </div>
                <!--论文和项目-->
                <div class="basicinfo">
                    <p class="lead title">
                        发表论文
                    </p>
                    <p style="margin-left: 30px;white-space: pre-line;">
                        <c:forEach items="${papers}" var="paper" varStatus="index">
                            [${index.count}]${pauthors[index.count-1]}.${paper.ptitile}.${paper.papersource}.${paper.publictime}
                        </c:forEach>
                    </p>
                    <p class="lead title">
                        参与项目
                    </p>
                    <p style="margin-left: 30px;white-space: pre-line;">
                        <c:forEach items="${projects}" var="project" varStatus="index">
                            [${index.count}]${proauthors[index.count-1]}.${project.proname}.${project.prosource}.${project.number}
                        </c:forEach>
                    </p>
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