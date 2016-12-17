<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="/WEB-INF/jsp/tag.jsp"%>
<html>
<head>
	<TITLE>药品采购平台</TITLE>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="content-type" content="text/html; charset=UTF-8">

	<LINK rel="stylesheet" type="text/css" href="${resourceRoot}/styles/style.css">
	<LINK rel="stylesheet" type="text/css" href="${resourceRoot}/styles/login.css">
	<LINK rel="stylesheet" type="text/css"	href="${resourceRoot}/js/easyui/themes/default/easyui.css">
	<LINK rel="stylesheet" type="text/css"	href="${resourceRoot}/js/easyui/themes/icon.css">

	<STYLE type="text/css">
		.btnalink {
			cursor: hand;
			display: block;
			width: 80px;
			height: 29px;
			float: left;
			margin: 12px 28px 12px auto;
			line-height: 30px;
			background: url('${resourceRoot}/images/login/btnbg.jpg') no-repeat;
			font-size: 14px;
			color: #fff;
			font-weight: bold;
			text-decoration: none;
		}
	</STYLE>
	<%@ include file="/WEB-INF/jsp/common_js.jsp"%>

	<script type="text/javascript">

		//登录提示方法
		function loginsubmit() {
			$("#loginform").submit();

		}

	</SCRIPT>
</HEAD>
<BODY style="background: #f6fdff url(${resourceRoot}/images/login/bg1.jpg) repeat-x;">
<form id="loginform" name="loginform" action="${baseurl}login"
	  method="post">
	<DIV class="logincon">

		<DIV class="title">
			<IMG alt="" src="${resourceRoot}/images/login/logo.png">
		</DIV>

		<DIV class="cen_con">
			<IMG alt="" src="${resourceRoot}/images/login/bg2.png">
		</DIV>

		<DIV class="tab_con">

			<input type="password" style="display:none;" />
			<TABLE class="tab" border="0" cellSpacing="6" cellPadding="8">
				<TBODY>
				<TR>
					<TD>用户名：</TD>
					<TD colSpan="2"><input type="text" id="username"
										   name="username" style="WIDTH: 130px" /></TD>
				</TR>
				<TR>
					<TD>密 码：</TD>
					<TD><input type="password" id="pwd" name="password" style="WIDTH: 130px" />
					</TD>
				</TR>
				<TR>
					<TD>验证码：</TD>
					<TD><input id="randomcode" name="randomcode" size="8" /> <img
							id="randomcode_img" src="${baseurl}validatecode.jsp" alt=""
							width="56" height="20" align='absMiddle' /> <a
							href=javascript:randomcode_refresh()>刷新</a></TD>
				</TR>
				<tr>
					<TD></TD>
					<td><input type="checkbox" name="rememberMe" />自动登陆</td>
				</tr>
				</TBODY>
			</TABLE>

		</DIV>
	</DIV>
	<div>
		<input type="submit" value="提交">
		<input type="reset" value="取消">
	</div>
</form>
</BODY>
</HTML>
