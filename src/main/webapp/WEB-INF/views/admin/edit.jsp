<%@ page import="java.util.List" %>
<%@ page import="zxl.web.controller.AdminController" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>计算机网络与信息安全研究室后台管理系统</title>
    <meta name="keywords" content="Bootstrap模版,Bootstrap模版下载,Bootstrap教程,Bootstrap中文" />
    <meta name="description" content="站长素材提供Bootstrap模版,Bootstrap教程,Bootstrap中文翻译等相关Bootstrap插件下载" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />



    <link href="/bootstrap/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="/bootstrap/assets/css/font-awesome.min.css" />



    <!-- page specific plugin styles -->

    <link rel="stylesheet" href="/bootstrap/assets/css/jquery-ui-1.10.3.custom.min.css" />
    <link rel="stylesheet" href="/bootstrap/assets/css/chosen.css" />
    <link rel="stylesheet" href="/bootstrap/assets/css/datepicker.css" />
    <link rel="stylesheet" href="/bootstrap/assets/css/bootstrap-timepicker.css" />
    <link rel="stylesheet" href="/bootstrap/assets/css/daterangepicker.css" />
    <link rel="stylesheet" href="/bootstrap/assets/css/colorpicker.css" />

    <!-- fonts -->

    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

    <!-- ace styles -->

    <link rel="stylesheet" href="/bootstrap/assets/css/ace.min.css" />
    <link rel="stylesheet" href="/bootstrap/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="/bootstrap/assets/css/ace-skins.min.css" />



    <script src="/bootstrap/assets/js/ace-extra.min.js"></script>


    <style type="text/css">
        .ace-file-multiple .file-label {
            position: relative;
            height: auto;
            border: 1px dashed #aaa;
            border-radius: 4px;
            text-align: center;
            width: 350px;
        }
    </style>
</head>

<body>
<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    计算机网络与信息安全研究室后台管理系统
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->

        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">

                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="${user.imgurl}" alt="Jason's Photo" />
                        <span class="user-info">
									<small>欢迎,</small>
									${user.username}
								</span>

                        <i class="icon-caret-down"></i>
                    </a>

                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">


                        <li>
                            <a href="/login.jsp">
                                <i class="icon-off"></i>
                                退出
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- /.ace-nav -->
        </div><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>
        <%--侧边导航栏--%>
        <div class="sidebar" id="sidebar">
            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
            </script>

            <div class="sidebar-shortcuts" id="sidebar-shortcuts">
                <div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
                    <button class="btn btn-success">
                        <i class="icon-signal"></i>
                    </button>

                    <button class="btn btn-info">
                        <i class="icon-pencil"></i>
                    </button>

                    <button class="btn btn-warning">
                        <i class="icon-group"></i>
                    </button>

                    <button class="btn btn-danger">
                        <i class="icon-cogs"></i>
                    </button>
                </div>

                <div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
                    <span class="btn btn-success"></span>

                    <span class="btn btn-info"></span>

                    <span class="btn btn-warning"></span>

                    <span class="btn btn-danger"></span>
                </div>
            </div><!-- #sidebar-shortcuts -->

            <ul class="nav nav-list">
                <li class="selfManage">
                    <a class="dropdown-toggle">
                        <i class="icon-desktop"></i>
                        <span class="menu-text" class="active open"> 个人信息管理</span>

                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li class="selfManage">
                            <a href="/admin/edit?id=${user.id}">
                                <i class="icon-double-angle-right"></i>
                                个人信息修改
                            </a>
                        </li>
                    </ul>

                </li>

                <li class="peopleManage studentHidden">
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-user"></i>
                        <span class="menu-text">人员管理</span>

                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li id="teacherSidebar" class="teacherHidden">
                            <a href="/teacher/index">
                                <i class="icon-double-angle-right"></i>
                                教师管理
                            </a>
                        </li>

                        <li id="studentSidebar">
                            <a href="/student/index" class="studentHidden">
                                <i class="icon-double-angle-right"></i>
                                学生管理
                            </a>
                        </li>
                        <li id="cooperatorSidebar" class="teacherHidden">
                            <a href="/cooperator/index">
                                <i class="icon-double-angle-right"></i>
                                合作者管理
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="teacherHidden">
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-building"></i>
                        <span class="menu-text"> 合作企业管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a href="/company/index">
                                <i class="icon-double-angle-right"></i>
                                企业列表
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text"> 论文管理</span>

                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a href="/paper/index">
                                <i class="icon-double-angle-right"></i>
                                论文列表
                            </a>
                        </li>
                    </ul>
                </li>
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text"> 项目管理</span>

                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a href="/project/index">
                                <i class="icon-double-angle-right"></i>
                                项目列表
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="studentHidden">
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text"> 课程管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a href="/course/index">
                                <i class="icon-double-angle-right"></i>
                                课程列表
                            </a>
                        </li>
                    </ul>
                </li>
                <li class="studentHidden">
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text"> 著作管理 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a href="/book/index">
                                <i class="icon-double-angle-right"></i>
                                著作列表
                            </a>
                        </li>
                    </ul>
                </li>



            </ul>

            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
            </div>

            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
            </script>
        </div>

        <div class="main-content">
            <%--面包屑导航栏--%>
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>
                <%-- 最上方导航栏  每加一个li标签就加一个链接 --%>
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="/admin/main">计算机网络与信息安全研究室</a>
                    </li>
                    <li class="breadcrumbSelfManage"style="display: none">
                        <a href="" >个人信息管理</a>
                    </li>
                    <li class="breadcrumbSelfManage"style="display: none">
                        <a href="">个人信息编辑</a>
                    </li>
                    <li id="breadcrumbPeopleManage"style="display: none">
                        <a href="" >人员管理</a>
                    </li>
                    <li id="breadcrumbTeacher"style="display: none">
                        <a href="">教师管理</a>
                    </li>
                    <li id="breadcrumbStudent"style="display: none">
                        <a href="">学生管理</a>
                    </li>
                    <li id="breadcrumbCooperator"style="display: none">
                        <a href="">合作者管理</a>
                    </li>

                </ul><!-- .breadcrumb -->
                <%-- 搜索栏 --%>
                <%--<div class="nav-search" id="nav-search">--%>
                <%--<form class="form-search">--%>
                <%--<span class="input-icon">--%>
                <%--<input type="text" placeholder="搜索" class="nav-search-input" id="nav-search-input" autocomplete="off" />--%>
                <%--<i class="icon-search nav-search-icon"></i>--%>
                <%--</span>--%>
                <%--</form>--%>
                <%--</div><!-- #nav-search -->--%>
            </div>

            <div class="page-content">


                <div class="row">
                    <div class="col-xs-12">
                        <!--学生表单 -->

                        <form class="form-horizontal" method="post" action="/admin/save" enctype="multipart/form-data"  accept-charset="UTF-8">
                            <!--新增点击过来，没有id，修改点过来有id-->
                            <input type="hidden" name="id" value="${userForEdit.id}"/>
                            <!--根据不同的用户类型，显示不同的表单页面-->
                            <input type="hidden" name="usertype" value="${userForEdit.usertype}"/>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 用户名 </label>

                                <div class="col-sm-9">
                                    <input type="text" name="username" id="username" disabled="disabled" class="col-xs-10 col-sm-5" value="${userForEdit.username}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-1"> 真实姓名 </label>

                                <div class="col-sm-9">
                                    <input type="text" name="realname" id="form-field-1" placeholder="真实姓名" class="col-xs-10 col-sm-5" value="${userForEdit.realname}"/>
                                </div>
                            </div>

                            <div class="space-4"></div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-2"> 密码 </label>

                                <div class="col-sm-9">
                                    <input type="password" name="pwd" value="${userForEdit.pwd}" id="form-field-2" placeholder="Password" class="col-xs-10 col-sm-5" />

                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="form-field-3"> 生日</label>

                                <div class="col-sm-9">
                                    <input type="date" name="birthday" id="form-field-3" class="col-xs-10 col-sm-5" value="${userForEdit.birthday}"/>
                                </div>
                            </div>

                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right"> 头像 </label>

                                <div class="col-sm-9">
                                    <input  multiple="" type="file" name="imgFile" id="id-input-file-3" class="col-xs-10 col-sm-5" style="width:200px"/>
                                </div>
                            </div>

                            <div class="form-group">

                                <label class="col-sm-3 control-label no-padding-right">性别</label>
                                <div class="col-sm-9">

                                    <div class="radio" id="radio_sex">
                                        <label>
                                            <input  type="radio" class="ace" name="sex" value=0 <c:if test="${0 == userForEdit.sex}">checked</c:if>/>
                                            <span class="lbl"> 男</span>
                                        </label>
                                        &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
                                        <label>
                                            <input  type="radio" class="ace" name="sex" value=1 <c:if test="${1 == userForEdit.sex}">checked</c:if>/>
                                            <span class="lbl"> 女</span>
                                        </label>
                                    </div>

                                </div>
                            </div>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right" for="userResearchArea"> 研究方向 </label>
                                <div class="col-sm-9">
                                    <select autocomplete="off" multiple="" name="userResearchArea" class="col-xs-10 col-sm-5 chosen-select" id="userResearchArea" data-placeholder="选择研究方向">
                                        <c:forEach items="${researchareaList}" var="researchArea">
                                            <c:if test="${associations==null}">
                                                <option class="researchareaAssociation" value="${researchArea.rid}">${researchArea.rname}</option>
                                            </c:if>
                                            <c:if test="${associations!=null}">
                                                <c:if test="${AdminController.ifInPid(associations, researchArea.rid) == true}">
                                                    <option class="researchareaAssociation" selected="selected" value="${researchArea.rid}">${researchArea.rname}</option>
                                                </c:if>
                                                <c:if test="${AdminController.ifInPid(associations, researchArea.rid) == false}">
                                                    <option class="researchareaAssociation" value="${researchArea.rid}">${researchArea.rname}</option>
                                                </c:if>
                                            </c:if>
                                        </c:forEach>
                                    </select>
                                </div>

                                </div>

                            <div class="space-4"></div>



                            <!--teacher   style="display: none"  -->
                            <div class="teacher"  style="display: none" >

                                <input type="hidden" name="tid" value="${teacher.tid}"/>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-4"> 教师邮箱 </label>

                                    <div class="col-sm-9">
                                        <input type="text" name="tmail" id="form-field-4" placeholder="教师邮箱" class="col-xs-10 col-sm-5" <c:if test="${0 == userForEdit.usertype}">value="${teacher.tmail}"</c:if>/>
                                    </div>
                                </div>

                                <div class="space-4"></div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-5">教师职务</label>

                                    <div class="col-sm-9">
                                        <input type="text" name="tduty" id="form-field-5" placeholder="教师职务" class="col-xs-10 col-sm-5" <c:if test="${0 == userForEdit.usertype}">value="${teacher.tduty}"</c:if>/>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" > 教育经历 </label>

                                    <div class="col-sm-9">
                                        <textarea name="teduexp" class="col-sm-5" rows="10" placeholder="教育经历" style="resize:none;">${teacher.teduexp}</textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" > 工作经历 </label>

                                    <div class="col-sm-9">
                                        <textarea name="workexp" class="col-sm-5" rows="10" style="resize:none;" placeholder="工作经历">${teacher.workexp}</textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" > 社会服务 </label>

                                    <div class="col-sm-9">
                                        <textarea name="service" style="resize:none;" class="col-sm-5" rows="10" placeholder="社会服务">${teacher.service}</textarea>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" >教师职称</label>
                                    <div class="col-sm-9">
                                        <select class="col-xs-10 col-sm-5" id="selectteacher" name="trank" >
                                            <option value="-1">-----------请选择职称----------</option>
                                            <option value="0" >讲师</option>
                                            <option value="1" >助理教授</option>
                                            <option value="2" >副教授</option>
                                            <option value="3" >教授</option>
                                        </select>
                                    </div>
                                </div>
                            </div><!--teacher-->


                            <!--student      style="display: none"    -->
                            <div class="student" style="display: none" >

                                <input type="hidden" name="sid" value="${student.sid}"/>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-6"> 学生邮箱 </label>

                                    <div class="col-sm-9">
                                        <input type="text" name="smail" id="form-field-6" placeholder="学生邮箱" class="col-xs-10 col-sm-5"  <c:if test="${1 == userForEdit.usertype}">value="${students.smail}"</c:if>/>
                                    </div>
                                </div>

                                <div class="space-4"></div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-7">毕业去向</label>

                                    <div class="col-sm-9">
                                        <input type="text" name="wheretogo" id="form-field-7" placeholder="毕业去向" class="col-xs-10 col-sm-5"  <c:if test="${1 == userForEdit.usertype}">value="${students.wheretogo}"</c:if> />
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" > 教育经历 </label>

                                    <div class="col-sm-9">
                                        <textarea name="stueduexp" style="resize:none;" class="col-sm-5" rows="10" placeholder="教育经历">${student.stueduexp}</textarea>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" >学生学位</label>
                                    <div class="col-sm-9">
                                        <select class="col-xs-10 col-sm-5" id="selectstudent" name="srank" value="${student.srank}">
                                            <option value="-1">-----------请选择学位----------</option>
                                            <option value="0" >本科生</option>
                                            <option value="1" >硕士生</option>
                                            <option value="2" >博士生</option>
                                        </select>
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-8"> 入学时间 </label>

                                    <div class="col-sm-9">
                                        <input type="date" name="entertime" id="form-field-8" class="col-xs-10 col-sm-5" value="${student.entertime}"/>
                                    </div>
                                </div>

                            </div><!--student-->


                            <!--cooperator   style="display: none"  -->
                            <div class="cooperator"  style="display: none" >

                                <input type="hidden" name="cid" value="${cooperator.cid}"/>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" >任职单位</label>
                                    <div class="col-sm-9">
                                        <select class="col-xs-10 col-sm-5" id="selectcompany" name="coid" value="${cooperator.coid}">
                                            <option value="-1">-----------请选择任职单位----------</option>
                                            <c:forEach items="${companies}" var="com">

                                                <option value="${com.coid}">${com.coname}</option>

                                            </c:forEach>
                                        </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-4"> 合作者头衔 </label>

                                    <div class="col-sm-9">
                                        <input type="text" name="title" id="form-field-9" placeholder="合作者头衔" class="col-xs-10 col-sm-5" <c:if test="${2 == userForEdit.usertype}">value="${cooperator.title}"</c:if>/>
                                    </div>
                                </div>

                                <div class="space-4"></div>

                                <div class="form-group">
                                    <label class="col-sm-3 control-label no-padding-right" for="form-field-5">合作者职务</label>

                                    <div class="col-sm-9">
                                        <input type="text" name="cduty" id="form-field-10" placeholder="合作者职务" class="col-xs-10 col-sm-5" <c:if test="${2 == userForEdit.usertype}">value="${cooperator.cduty}"</c:if>/>
                                    </div>
                                </div>




                            </div><!--cooperator-->

                            <div class="clearfix form-actions">
                                <div class="col-md-offset-3 col-md-9">
                                    <button class="btn btn-info" type="submit">
                                        <i class="icon-ok bigger-110"></i>
                                        保存
                                    </button>

                                    &nbsp; &nbsp; &nbsp;
                                    <button class="btn" type="reset">
                                        <i class="icon-undo bigger-110"></i>
                                        重置
                                    </button>
                                </div>
                            </div>
                        </form>


                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div><!-- /.main-content -->

        <div class="ace-settings-container" id="ace-settings-container">
            <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                <i class="icon-cog bigger-150"></i>
            </div>

            <div class="ace-settings-box" id="ace-settings-box">
                <div>
                    <div class="pull-left">
                        <select id="skin-colorpicker" class="hide">
                            <option data-skin="default" value="#438EB9">#438EB9</option>
                            <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                            <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                            <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                        </select>
                    </div>
                    <span>&nbsp; 换肤</span>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
                    <label class="lbl" for="ace-settings-navbar"> 固定导航栏</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
                    <label class="lbl" for="ace-settings-sidebar"> 固定工具栏</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
                    <label class="lbl" for="ace-settings-breadcrumbs"> 固定面包屑导航</label>
                </div>



                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
                    <label class="lbl" for="ace-settings-add-container">
                        内置
                        <b>.容器</b>
                    </label>
                </div>
            </div>
        </div><!-- /#ace-settings-container -->
    </div><!-- /.main-container-inner -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->



<script type="text/javascript">
    window.jQuery || document.write("<script src='/bootstrap/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>



<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='/bootstrap/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="/bootstrap/assets/js/bootstrap.min.js"></script>
<script src="/bootstrap/assets/js/typeahead-bs2.min.js"></script>



<script src="/bootstrap/assets/js/jquery-ui-1.10.3.custom.min.js"></script>
<script src="/bootstrap/assets/js/jquery.ui.touch-punch.min.js"></script>
<script src="/bootstrap/assets/js/chosen.jquery.min.js"></script>
<script src="/bootstrap/assets/js/fuelux/fuelux.spinner.min.js"></script>
<script src="/bootstrap/assets/js/date-time/bootstrap-datepicker.min.js"></script>
<script src="/bootstrap/assets/js/date-time/bootstrap-timepicker.min.js"></script>
<script src="/bootstrap/assets/js/date-time/moment.min.js"></script>
<script src="/bootstrap/assets/js/date-time/daterangepicker.min.js"></script>
<script src="/bootstrap/assets/js/bootstrap-colorpicker.min.js"></script>
<script src="/bootstrap/assets/js/jquery.knob.min.js"></script>
<script src="/bootstrap/assets/js/jquery.autosize.min.js"></script>
<script src="/bootstrap/assets/js/jquery.inputlimiter.1.3.1.min.js"></script>
<script src="/bootstrap/assets/js/jquery.maskedinput.min.js"></script>
<script src="/bootstrap/assets/js/bootstrap-tag.min.js"></script>

<!-- ace scripts -->

<script src="/bootstrap/assets/js/ace-elements.min.js"></script>
<script src="/bootstrap/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">
    jQuery(function($) {
        if("${user.isadmin}" == "false")
        {
            if("${user.usertype}" == "0")
            {
                $(".teacherHidden").css("display", "none");
            }
            if("${user.usertype}" == "1")
            {
                $(".teacherHidden").css("display", "none");
                $(".studentHidden").css("display", "none");
            }
        }
        //初始化选择菜单的值
        var usertype="${userForEdit.usertype}";
        if(usertype==0)//是老师
        {
            var selectval= "${teacher.trank}";
            if(selectval!=null&&selectval!=""){
                $('#selectteacher').find("option[value='"+selectval+"']").attr("selected", "true");
                //alert(selectval);
            }
        }else{
            if(usertype==1)
            {
                var selectval= "${student.srank}";
                if(selectval!=null&&selectval!=""){
                    $('#selectstudent').find("option[value='"+selectval+"']").attr("selected", "true");
                    //alert(selectval);
                }
            }else{
                if(usertype==2)
                {
                    var selectval= "${cooperator.coid}";
                    if(selectval!=null&&selectval!=""){
                        $('#selectcompany').find("option[value='"+selectval+"']").attr("selected", "true");
                        //alert(selectval);
                    }
                }
            }
        }
        //初始化拓展表单
        showExpandDiv(usertype);
        $(".date-picker").datepicker({
            format: "yyyy-mm-dd", //显示日期格式
            autoclose: true,
            todayBtn: true,
            minView: "month",//只选择到天自动关闭
            language: 'zh-CN',
        });
        //单选选中
        $("#radio_sex").on("click",function(){
            $('input[type="radio"]:checked').parent('label').addClass('active');
        });

        $('#id-disable-check').on('click', function() {
            var inp = $('#form-input-readonly').get(0);
            if(inp.hasAttribute('disabled')) {
                inp.setAttribute('readonly' , 'true');
                inp.removeAttribute('disabled');
                inp.value="This text field is readonly!";
            }
            else {
                inp.setAttribute('disabled' , 'disabled');
                inp.removeAttribute('readonly');
                inp.value="This text field is disabled!";
            }
        });



        $(".chosen-select").chosen();
        $('#chosen-multiple-style').on('click', function(e){
            var target = $(e.target).find('input[type=radio]');
            var which = parseInt(target.val());
            if(which == 2) $('#form-field-select-4').addClass('tag-input-style');
            else $('#form-field-select-4').removeClass('tag-input-style');
        });


        $('[data-rel=tooltip]').tooltip({container:'body'});
        $('[data-rel=popover]').popover({container:'body'});

        $('textarea[class*=autosize]').autosize({append: "\n"});
        $('textarea.limited').inputlimiter({
            remText: '%n character%s remaining...',
            limitText: 'max allowed : %n.'
        });

        $.mask.definitions['~']='[+-]';
        $('.input-mask-date').mask('99/99/9999');
        $('.input-mask-phone').mask('(999) 999-9999');
        $('.input-mask-eyescript').mask('~9.99 ~9.99 999');
        $(".input-mask-product").mask("a*-999-a999",{placeholder:" ",completed:function(){alert("You typed the following: "+this.val());}});



        $( "#input-size-slider" ).css('width','200px').slider({
            value:1,
            range: "min",
            min: 1,
            max: 8,
            step: 1,
            slide: function( event, ui ) {
                var sizing = ['', 'input-sm', 'input-lg', 'input-mini', 'input-small', 'input-medium', 'input-large', 'input-xlarge', 'input-xxlarge'];
                var val = parseInt(ui.value);
                $('#form-field-4').attr('class', sizing[val]).val('.'+sizing[val]);
            }
        });

        $( "#input-span-slider" ).slider({
            value:1,
            range: "min",
            min: 1,
            max: 12,
            step: 1,
            slide: function( event, ui ) {
                var val = parseInt(ui.value);
                $('#form-field-5').attr('class', 'col-xs-'+val).val('.col-xs-'+val);
            }
        });


        $( "#slider-range" ).css('height','200px').slider({
            orientation: "vertical",
            range: true,
            min: 0,
            max: 100,
            values: [ 17, 67 ],
            slide: function( event, ui ) {
                var val = ui.values[$(ui.handle).index()-1]+"";

                if(! ui.handle.firstChild ) {
                    $(ui.handle).append("<div class='tooltip right in' style='display:none;left:16px;top:-6px;'><div class='tooltip-arrow'></div><div class='tooltip-inner'></div></div>");
                }
                $(ui.handle.firstChild).show().children().eq(1).text(val);
            }
        }).find('a').on('blur', function(){
            $(this.firstChild).hide();
        });

        $( "#slider-range-max" ).slider({
            range: "max",
            min: 1,
            max: 10,
            value: 2
        });

        $( "#eq > span" ).css({width:'90%', 'float':'left', margin:'15px'}).each(function() {
            // read initial values from markup and remove that
            var value = parseInt( $( this ).text(), 10 );
            $( this ).empty().slider({
                value: value,
                range: "min",
                animate: true

            });
        });


        $('#id-input-file-1 , #id-input-file-2').ace_file_input({
            no_file:'No File ...',
            btn_choose:'Choose',
            btn_change:'Change',
            droppable:false,
            onchange:null,
            thumbnail:false //| true | large
            //whitelist:'gif|png|jpg|jpeg'
            //blacklist:'exe|php'
            //onchange:''
            //
        });

        $('#id-input-file-3').ace_file_input({
            style:'well',
            btn_choose:'Drop files here or click to choose',
            btn_change:null,
            no_icon:'icon-cloud-upload',
            droppable:true,
            thumbnail:'small'//large | fit
            //,icon_remove:null//set null, to hide remove/reset button
            /**,before_change:function(files, dropped) {
						//Check an example below
						//or examples/file-upload.html
						return true;
					}*/
            /**,before_remove : function() {
						return true;
					}*/
            ,
            preview_error : function(filename, error_code) {
                //name of the file that failed
                //error_code values
                //1 = 'FILE_LOAD_FAILED',
                //2 = 'IMAGE_LOAD_FAILED',
                //3 = 'THUMBNAIL_FAILED'
                //alert(error_code);
            }

        }).on('change', function(){
            //console.log($(this).data('ace_input_files'));
            //console.log($(this).data('ace_input_method'));
        });


        //dynamically change allowed formats by changing before_change callback function
        $('#id-file-format').removeAttr('checked').on('change', function() {
            var before_change
            var btn_choose
            var no_icon
            if(this.checked) {
                btn_choose = "Drop images here or click to choose";
                no_icon = "icon-picture";
                before_change = function(files, dropped) {
                    var allowed_files = [];
                    for(var i = 0 ; i < files.length; i++) {
                        var file = files[i];
                        if(typeof file === "string") {
                            //IE8 and browsers that don't support File Object
                            if(! (/\.(jpe?g|png|gif|bmp)$/i).test(file) ) return false;
                        }
                        else {
                            var type = $.trim(file.type);
                            if( ( type.length > 0 && ! (/^image\/(jpe?g|png|gif|bmp)$/i).test(type) )
                                || ( type.length == 0 && ! (/\.(jpe?g|png|gif|bmp)$/i).test(file.name) )//for android's default browser which gives an empty string for file.type
                            ) continue;//not an image so don't keep this file
                        }

                        allowed_files.push(file);
                    }
                    if(allowed_files.length == 0) return false;

                    return allowed_files;
                }
            }
            else {
                btn_choose = "Drop files here or click to choose";
                no_icon = "icon-cloud-upload";
                before_change = function(files, dropped) {
                    return files;
                }
            }
            var file_input = $('#id-input-file-3');
            file_input.ace_file_input('update_settings', {'before_change':before_change, 'btn_choose': btn_choose, 'no_icon':no_icon})
            file_input.ace_file_input('reset_input');
        });




        $('#spinner1').ace_spinner({value:0,min:0,max:200,step:10, btn_up_class:'btn-info' , btn_down_class:'btn-info'})
            .on('change', function(){
                //alert(this.value)
            });
        $('#spinner2').ace_spinner({value:0,min:0,max:10000,step:100, touch_spinner: true, icon_up:'icon-caret-up', icon_down:'icon-caret-down'});
        $('#spinner3').ace_spinner({value:0,min:-100,max:100,step:10, on_sides: true, icon_up:'icon-plus smaller-75', icon_down:'icon-minus smaller-75', btn_up_class:'btn-success' , btn_down_class:'btn-danger'});



        $('.date-picker').datepicker({autoclose:true}).next().on(ace.click_event, function(){
            $(this).prev().focus();
        });
        $('input[name=date-range-picker]').daterangepicker().prev().on(ace.click_event, function(){
            $(this).next().focus();
        });

        $('#timepicker1').timepicker({
            minuteStep: 1,
            showSeconds: true,
            showMeridian: false
        }).next().on(ace.click_event, function(){
            $(this).prev().focus();
        });

        $('#colorpicker1').colorpicker();
        $('#simple-colorpicker-1').ace_colorpicker();


        $(".knob").knob();


        //we could just set the data-provide="tag" of the element inside HTML, but IE8 fails!
        var tag_input = $('#form-field-tags');
        if(! ( /msie\s*(8|7|6)/.test(navigator.userAgent.toLowerCase())) )
        {
            tag_input.tag(
                {
                    placeholder:tag_input.attr('placeholder'),
                    //enable typeahead by specifying the source array
                    source: ace.variable_US_STATES,//defined in ace.js >> ace.enable_search_ahead
                }
            );
        }
        else {
            //display a textarea for old IE, because it doesn't support this plugin or another one I tried!
            tag_input.after('<textarea id="'+tag_input.attr('id')+'" name="'+tag_input.attr('name')+'" rows="3">'+tag_input.val()+'</textarea>').remove();
            //$('#form-field-tags').autosize({append: "\n"});
        }




        /////////
        $('#modal-form input[type=file]').ace_file_input({
            style:'well',
            btn_choose:'Drop files here or click to choose',
            btn_change:null,
            no_icon:'icon-cloud-upload',
            droppable:true,
            thumbnail:'large'
        })


        $('#modal-form').on('shown.bs.modal', function () {
            $(this).find('.chosen-container').each(function(){
                $(this).find('a:first-child').css('width' , '210px');
                $(this).find('.chosen-drop').css('width' , '210px');
                $(this).find('.chosen-search input').css('width' , '200px');
            });
        })


    });
    /*显示对应拓展表单*/
    function showExpandDiv(usertype) {
        if(${userForEdit.id} === ${user.id})
        {
            $(".selfManage").addClass("active open");
            $(".breadcrumbSelfManage").show();
        }
        else{
            $(".peopleManage").addClass("active open");
        }
        if(usertype==0)//是老师
        {//显示老师表单
            $(".teacher").show();//一定要加.
            if(${userForEdit.id} != ${user.id})
            {
                $("#teacherSidebar").addClass("active open");
                $("#breadcrumbTeacher").show();
            }

        }else{
            if(usertype==1)
            {
                $(".student").show();
                if(${userForEdit.id} != ${user.id})
                {
                    $("#studentSidebar").addClass("active open");
                    $("#breadcrumbStudent").show();
                }

            }
            else{
                if(usertype==2)
                {
                    $(".cooperator").show();
                    if(${userForEdit.id} != ${user.id})
                    {
                        $("#cooperatorSidebar").addClass("active open");
                        $("#breadcrumbCooperator").show();
                    }
                }

            }
        }
    }
</script>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
