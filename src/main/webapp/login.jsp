<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html lang="en">
	<head>
		<meta charset="utf-8" />
		<title>实验室后台管理系统</title>
		<meta name="keywords" content="BootstrapģѦ,BootstrapģѦЂ՘,BootstrapތԌ,Bootstrapאτ" />
		<meta name="description" content="վӤ̘ӄ͡٩BootstrapģѦ,BootstrapތԌ,Bootstrapאτ׭ӫֈРژBootstrapӥݾЂ՘" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />

		

		<link href="/bootstrap/assets/css/bootstrap.min.css" rel="stylesheet" />
		<link rel="stylesheet" href="/bootstrap/assets/css/font-awesome.min.css" />
		<link rel="stylesheet" href="/bootstrap/assets/css/datepicker.css" />
		<link rel="stylesheet" href="/bootstrap/assets/css/jquery-ui-1.10.3.custom.min.css" />

		<link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Open+Sans:400,300" />

		<link rel="stylesheet" href="/bootstrap/assets/css/ace.min.css" />
		<link rel="stylesheet" href="/bootstrap/assets/css/ace-rtl.min.css" />

	</head>

	<body class="login-layout">
	
		<div class="main-container">
			<div class="main-content">
				<div class="row">
					<div class="col-sm-10 col-sm-offset-1">
						<div class="login-container">
							<div class="center">
								<h1>
									<i class="icon-leaf green"></i>
									<span class="red">计算机网络与信息安全研究室</span>
									<br>
									<span class="white">后台管理系统</span>
								</h1>
								<h4 class="blue">Computer Networks & Information Security Lab</h4>
							</div>

							<div class="space-6"></div>

							<div class="position-relative">
								<div id="login-box" class="login-box visible widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header blue lighter bigger">
												<i class="icon-coffee green"></i>
												请输入你信息
											</h4>

											<div class="space-6"></div>

											<form action="/user/login" method="post">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="username" class="form-control" placeholder="用户名" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" name="pwd" class="form-control" placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
													</label>

													<div class="space"></div>

													<div class="clearfix">
														<label class="inline">
															<input type="checkbox" class="ace" />
															<span class="lbl"> 记住我</span>
														</label>

														<button type="submit" class="width-35 pull-right btn btn-sm btn-primary">
															<i class="icon-key"></i>
															登录
														</button>
													</div>

													<div class="space-4"></div>
												</fieldset>
											</form>


										</div><!-- /widget-main -->

										<div class="toolbar clearfix">
											<div>
												<a href="#" onclick="show_box('forgot-box'); return false;" class="forgot-password-link">
													<i class="icon-arrow-left"></i>
													忘记密码
												</a>
											</div>

											<div>
												<a href="#" onclick="show_box('signup-box'); return false;" class="user-signup-link">
													注册
													<i class="icon-arrow-right"></i>
												</a>
											</div>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /login-box -->

								<div id="forgot-box" class="forgot-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header red lighter bigger">
												<i class="icon-key"></i>
												找回密码
											</h4>

											<div class="space-6"></div>
											<p>
												输入你的邮件并且收到指令
											</p>

											<form>
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="email" class="form-control" placeholder="Email" />
															<i class="icon-envelope"></i>
														</span>
													</label>

													<div class="clearfix">
														<button type="button" class="width-35 pull-right btn btn-sm btn-danger">
															<i class="icon-lightbulb"></i>
															发送邮件！
														</button>
													</div>
												</fieldset>
											</form>
										</div><!-- /widget-main -->

										<div class="toolbar center">
											<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
												回到登陆页面
												<i class="icon-arrow-right"></i>
											</a>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /forgot-box -->

								<div id="signup-box" class="signup-box widget-box no-border">
									<div class="widget-body">
										<div class="widget-main">
											<h4 class="header green lighter bigger">
												<i class="icon-group blue"></i>
												新用户注册
											</h4>

											<div class="space-6"></div>
											<p> 输入你的信息 </p>

											<form action="/user/register" method="post" accept-charset="UTF-8">
												<fieldset>
													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="text" name="username" class="form-control" placeholder="用户名" />
															<i class="icon-user"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password" name="pwd" id="pwd" class="form-control" placeholder="密码" />
															<i class="icon-lock"></i>
														</span>
													</label>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="password"  name="rptpwd" id="rptpwd" class="form-control" onblur="checkpwd()" placeholder="重复密码" />
															<i class="icon-retweet"></i>
														</span>
													</label>

													<span id="tishi"></span>

													<label class="block clearfix">
														<span class="block input-icon input-icon-right">
															<input type="date" name="time" class="form-control" placeholder="生日" />
															<i class="icon-calendar"></i>
														</span>
													</label>

													<!--注意name一定要一致，不然会导致二个选择框都能选中的现象；-->
													<label>选择性别</label>
													<div>
														<label class="radio-inline">
															<input type="radio" name="sex" id="male" value="0" checked>男
														</label>
														<label class="radio-inline">
															<input type="radio" name="sex" id="female" value="1">女
														</label>
													</div>

													<label>用户类别</label>
													<div>
														<label class="radio-inline">
															<input type="radio" name="usertype" id="teacher" value="0" checked>老师
														</label>
														<label class="radio-inline">
															<input type="radio" name="usertype" id="student" value="1">学生
														</label>
														<label class="radio-inline">
															<input type="radio" name="usertype" id="coop" value="2">合作伙伴
														</label>
													</div>

													<label>
														<input type="checkbox" name="isadmin" values="true" >是否是管理员
													</label>

													<div class="space-24"></div>

													<div class="clearfix">
														<button type="reset" class="width-30 pull-left btn btn-sm">
															<i class="icon-refresh"></i>
															重置
														</button>

														<button type="submit" id="register" class="width-65 pull-right btn btn-sm btn-success">
															注册
															<i class="icon-arrow-right icon-on-right"></i>
														</button>
													</div>
												</fieldset>
											</form>
										</div>

										<div class="toolbar center">
											<a href="#" onclick="show_box('login-box'); return false;" class="back-to-login-link">
												<i class="icon-arrow-left"></i>
												回到登陆页面
											</a>
										</div>
									</div><!-- /widget-body -->
								</div><!-- /signup-box -->
							</div><!-- /position-relative -->
						</div>
					</div><!-- /.col -->
				</div><!-- /.row -->
			</div>
		</div><!-- /.main-container -->


		<script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
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
		<script type="text/javascript">
			window.jQuery || document.write("<script src='/bootstrap/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
		</script>
	  <script type="text/javascript">
			if("ontouchend" in document) document.write("<script src='/bootstrap/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
		</script>

		<!-- inline scripts related to this page -->

		<script type="text/javascript">
			function show_box(id) {
			 jQuery('.widget-box.visible').removeClass('visible');
			 jQuery('#'+id).addClass('visible');
			}
		</script>

		<!--判断重复的密码是否与密码一致-->
		<script>
			function checkpwd()
			{
				var x=document.getElementById("pwd").value;
				var y=document.getElementById("rptpwd").value;
				if(x==y)
				{
					document.getElementById("tishi").innerHTML="<font color='gray'>输入正确</font>"
					document.getElementById("register").disabled=false;
				}
				else{
					document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>"
					document.getElementById("register").disabled=true;
				}
			}
		</script>

	<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>
    