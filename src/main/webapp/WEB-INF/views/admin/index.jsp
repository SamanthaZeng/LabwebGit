<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8" />
    <title>计算机网络与信息安全研究室后台管理系统</title>
    <meta name="keywords" content="Bootstrapæ¨¡ç,Bootstrapæ¨¡çä¸è½½,Bootstrapæç¨,Bootstrapä¸­æ" />
    <meta name="description" content="ç«é¿ç´ ææä¾Bootstrapæ¨¡ç,Bootstrapæç¨,Bootstrapä¸­æç¿»è¯ç­ç¸å³Bootstrapæä»¶ä¸è½½" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <!-- basic styles -->

    <link href="/bootstrap/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="/bootstrap/assets/css/font-awesome.min.css" />


    <!-- ace styles -->

    <link rel="stylesheet" href="/bootstrap/assets/css/ace.min.css" />
    <link rel="stylesheet" href="/bootstrap/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="/bootstrap/assets/css/ace-skins.min.css" />

    <script src="/bootstrap/assets/js/ace-extra.min.js"></script>
    <script type="text/javascript" src="/bootstrap/assets/js/jquery-2.0.3.min.js"></script>

    <!--google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Exo+2|ZCOOL+XiaoWei" rel="stylesheet">

    <!--pingendo-->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="css/theme.css" type="text/css">

    <style>
        .first{
            font-family: 'ZCOOL XiaoWei', serif;
            font-size: 48px;
            text-align: center;
        }
        .second{
            font-family: 'Exo 2', sans-serif;
            font-size: 48px;
            text-align: center;
        }
        .page-content-1{
            min-height: 100%;
            margin:0;
            padding:250px 20px;
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
        <script src="/component/sidebar.js" type="text/javascript"></script>

        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>
                <%-- 最上方导航栏  每加一个li标签就加一个链接 --%>
                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="/student/index">计算机网络与信息安全研究室</a>
                    </li>
                </ul><!-- .breadcrumb -->
            </div>

            <div class="page-content-1 text-center align-items-center"  style="background-image:linear-gradient(to left bottom, rgba(189, 195, 199, .75), rgba(44, 62, 80, .75)); background-size: cover;">
                <div class="container py-5">
                    <div class="row">
                        <!-- PAGE CONTENT BEGINS -->
                            <i class="d-block fa fa-stop-circle mb-3 text-muted fa-5x"></i>

                            <h1 class="display-3 mb-4">Welcome to</h1>
                            <p class="lead mb-5">Computer Networks &amp; Information Security Lab </p>

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

<!-- basic scripts -->


<script type="text/javascript">
    window.jQuery || document.write("<script src='/bootstrap/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>


<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='/bootstrap/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="/bootstrap/assets/js/bootstrap.min.js"></script>
<script src="/bootstrap/assets/js/typeahead-bs2.min.js"></script>


<script src="/bootstrap/assets/js/jquery.dataTables.min.js"></script>
<script src="/bootstrap/assets/js/jquery.dataTables.bootstrap.js"></script>

<!-- ace scripts -->

<script src="/bootstrap/assets/js/ace-elements.min.js"></script>
<script src="/bootstrap/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->

<script type="text/javascript">
    jQuery(function($) {
        //初始化选择菜单的值
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
    })
</script>

<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>

</body>
</html>
