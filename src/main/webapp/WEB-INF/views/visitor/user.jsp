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
    .cardimg{
        display: block;
        width: auto;
        height: auto;
        max-width: 100%;
        max-height: 100%;
        margin:auto;
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
        <div class="container">
            <a class="navbar-brand" href="#">NKU</a>
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
                    <li class="nav-item dropdown">
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

<div style="margin-top: 5em">
  <div class="container">
      <div class="row">
          <c:choose>
              <c:when test="${teachers!=null}">
                  <c:forEach items="${teachers}" var="teacher">
                      <div class="col-lg-4 p-3 col-md-4">
                          <div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
                              <div class="card-header">

                              </div>
                              <div class="container" >
                                  <a href="/visitor/userdetail?id=${teacher.user.id}">
                                      <img class="card-img" src="${teacher.user.imgurl}"  alt="userpic">
                                  </a>
                              </div>

                              <div class="card-body">
                                  <h5 class="card-title">${teacher.user.username}</h5>
                                  <p class="card-text">邮箱:${teacher.tmail}</p>
                                  <p class="card-text">
                                      <c:choose>
                                          <c:when test="${teacher.trank==0}">讲师</c:when>
                                          <c:when test="${teacher.trank==1}">助理教授</c:when>
                                          <c:when test="${teacher.trank==2}">副教授</c:when>
                                          <c:when test="${teacher.trank==3}">教授</c:when>
                                      </c:choose>
                                  </p>
                              </div>
                          </div><!--card-->
                      </div><!--col-->
                  </c:forEach>
              </c:when>
              <c:when test="${students!=null}">
                  <c:forEach items="${students}" var="student">
                      <div class="col-lg-4 p-3 col-md-4">
                          <div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
                              <div class="card-header">
                                  <c:choose>
                                      <c:when test="${student.srank==0}">本科生</c:when>
                                      <c:when test="${student.srank==1}">研究生</c:when>
                                      <c:when test="${student.srank==2}">博士生</c:when>
                                  </c:choose>
                              </div>
                              <div class="container">
                                  <a href="/visitor/userdetail?id=${student.user.id}">
                                      <img class="card-img" src="${student.user.imgurl}"  alt="userpic">
                                  </a>
                              </div>

                              <div class="card-body">
                                  <h5 class="card-title">${student.user.username}</h5>
                                  <p class="card-text">邮箱:${student.smail}</p>
                              </div>
                          </div>
                      </div>
                  </c:forEach>
              </c:when>
              <c:when test="${cooperators!=null}">
                  <c:forEach items="${cooperators}" var="cooperator">
                      <div class="col-lg-4 p-3 col-md-4">
                          <div class="card text-white bg-secondary mb-3" style="max-width: 18rem;">
                              <div class="card-header">${cooperator.title}</div>
                              <div class="container">
                                  <a href="${cooperator.cpage}">
                                      <img class="card-img" src="${cooperator.user.imgurl}"  alt="userpic">
                                  </a>
                              </div>

                              <div class="card-body">
                                  <h5 class="card-title">${cooperator.user.username}</h5>
                                  <p class="card-text">邮箱:${cooperator.cmail}</p>
                                  <p class="card-text">性别：<c:if test="${cooperator.user.sex==0}">男</c:if> <c:if test="${cooperator.user.sex==1}">女</c:if></p>
                                  <p class="card-text">公司：${cooperator.company.coname}</p>
                                  <p class="card-text">工作职务：${cooperator.cduty}</p>
                              </div>
                          </div>
                      </div>
                  </c:forEach>
              </c:when>
          </c:choose>


      </div>
  </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>