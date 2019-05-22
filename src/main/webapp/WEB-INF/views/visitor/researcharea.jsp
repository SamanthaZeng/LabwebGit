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
    .carousel-inner img {
        width: 548px;
        height:350px;
    }
    .carousel-indicators{

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
                    <li class="nav-item dropdown active">
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

<div style="background-color: #f1f1f1">
    <div class="container" style="background-color: #fff;">
        <div style="padding-top: 5em">
          <div class="row">
              <div class="col-md-6">
                  <h1 class="mb-3">${research.rname}</h1>
                  <p class="lead text-justify">${research.intro}</p>
              </div>

              <div class="col-md-6">
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
                              <c:choose>
                                  <c:when test="${research.rid==1}">
                                      <img src="${research.imgurl1}">
                                  </c:when>
                                  <c:when test="${research.rid==2}">
                                      <img src="${research.imgurl2}">
                                  </c:when>
                                  <c:when test="${research.rid==3}">
                                      <img src="${research.imgurl3}">
                                  </c:when>
                              </c:choose>
                          </div>
                          <div class="carousel-item">
                              <c:choose>
                                  <c:when test="${research.rid==1}">
                                      <img src="${research.imgurl1}">
                                  </c:when>
                                  <c:when test="${research.rid==2}">
                                      <img src="${research.imgurl2}">
                                  </c:when>
                                  <c:when test="${research.rid==3}">
                                      <img src="${research.imgurl3}">
                                  </c:when>
                              </c:choose>
                          </div>
                          <div class="carousel-item">
                              <c:choose>
                                  <c:when test="${research.rid==1}">
                                      <img src="${research.imgurl1}">
                                  </c:when>
                                  <c:when test="${research.rid==2}">
                                      <img src="${research.imgurl2}">
                                  </c:when>
                                  <c:when test="${research.rid==3}">
                                      <img src="${research.imgurl3}">
                                  </c:when>
                              </c:choose>
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
    <div class="container" style="background-color: #fff;">
        <div style="padding-top: 5em">
            <table class="table ">
                <thead>
                <tr>
                    <th scope="col">相关人员</th>
                    <th scope="col">职称</th>
                    <th scope="col">职务</th>
                    <th scope="col">联系邮箱</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${teachers}" var="teacher" varStatus="index">
                    <tr>
                        <td>${teacher.user.username}</td>
                        <td class="hidden-480">
                            <c:choose>
                                <%--得导入user--%>
                                <c:when test="${teacher.trank ==0}">
                                    讲师
                                </c:when>
                                <c:when test="${teacher.trank == 1}">
                                    副教授
                                </c:when>
                                <c:when test="${teacher.trank == 2}">
                                    教授
                                </c:when>
                            </c:choose>
                        </td>
                        <td>${teacher.tduty}</td>
                        <td>${teacher.tmail}</td>
                    </tr>
                </c:forEach>
                <c:forEach items="${students}" var="student" varStatus="index">
                    <tr>
                        <td>${student.user.username}</td>
                        <td>学生</td>
                        <td class="hidden-480">
                            <c:choose>
                                <%--得导入user--%>
                                <c:when test="${student.srank ==0}">
                                    本科生
                                </c:when>
                                <c:when test="${student.srank == 1}">
                                    硕士生
                                </c:when>
                                <c:when test="${tstudent.srank == 2}">
                                    博士生
                                </c:when>
                            </c:choose>
                        </td>
                        <td>${student.smail}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <div class="container"style="background-color: #fff;">
        <div>
            <table class="table ">
                <thead>
                <tr>
                    <th scope="col">#</th>
                    <th scope="col">项目名称</th>
                    <th scope="col">项目来源</th>
                    <th scope="col">项目编号</th>
                    <th scope="col">负责人</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${projects}" var="project" varStatus="index">
                    <tr>
                        <th scope="row">${index.count}</th>
                        <td>${project.proname}</td>
                        <td>${project.prosource}</td>
                        <td>${project.number}</td>
                        <td>作者</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>