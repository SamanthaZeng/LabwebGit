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
  <link href="/bootstrap/assets/css/bootstrap.min.css" rel="stylesheet" />

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
  <nav class="navbar  navbar-inverse" role="navigation">
    <div class="container-fluid">
      <div class="navbar-header">
        <a class="navbar-brand" href="#">NKU</a>
      </div>
      <div>
        <ul class="nav navbar-nav">
          <li ><a href="home.jsp">主页</a></li>
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
          <li class="dropdown active">
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
  <table class="table table-dark">
    <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">论文名称</th>
      <th scope="col">论文摘要</th>
      <th scope="col">作者</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
    </tr>
    </tbody>
  </table>
</div>



<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</body>

</html>