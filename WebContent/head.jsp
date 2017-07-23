<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
  <meta name="viewport" content="width=device-width,initial-scale=1,user-scalable=0">
  <title>${param.title}</title>
  <link rel="stylesheet" type="text/css" href="public/css/weui.css">
  <link rel="stylesheet" type="text/css" href="public/css/book.css">

</head>
<body>
<div class="bk_title_bar">
  <img class="bk_back" src="public/image/back.png" alt="" onclick="history.go(-1)">
  <p class="bk_title_content"></p>
  <img class="bk_menu" src="public/image/menu.png" alt="" onclick="onMenuClick()">
</div>
