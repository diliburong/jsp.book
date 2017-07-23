
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 



<%request.setCharacterEncoding("utf-8"); %>  
<jsp:include page="head.jsp" flush="true">
    <jsp:param name="title" value="登陆"/>
</jsp:include>
<div class="page">
<div class="weui_cells_title"></div>
<div class="weui_cells weui_cells_form">
  <div class="weui_cell">
      <div class="weui_cell_hd"><label class="weui_label">帐号</label></div>
      <div class="weui_cell_bd weui_cell_primary">
          <input class="weui_input" type="tel" name="username" placeholder="请输入用户名"/>
      </div>
  </div>
  <div class="weui_cell">
      <div class="weui_cell_hd"><label class="weui_label">密码</label></div>
      <div class="weui_cell_bd weui_cell_primary">
          <input class="weui_input" type="password" name="password" placeholder="不少于6位"/>
      </div>
  </div>
</div>
<div class="weui_cells_tips"></div>
<div class="weui_btn_area">
  <a class="weui_btn weui_btn_primary" href="javascript:" onclick="onLoginClick();">登录</a>
</div>
<a href="<%=request.getContextPath() %>/register.jsp" class="bk_bottom_tips bk_important">没有帐号? 去注册</a>



</div>
	


<jsp:include page="footer.jsp" flush="true"/>

<script type="text/javascript">

function onLoginClick(){

  var username=$('input[name=username]').val();
  if(username.length==0){
    $('.bk_toptips').show();
    $('.bk_toptips span').html('账号不能为空');
    setTimeout(function(){
      $('.bk_toptips').hide();},2000);
    return;
  }

 
  //密码
  var password=$('input[name=password]').val();
  if (password.length==0) {
    $('.bk_toptips').show();
    $('.bk_toptips span').html('密码不能为空');
    setTimeout(function(){
    $('.bk_toptips').hide();},2000);
    return;    
  }

  if (password.length<6) {
    $('.bk_toptips').show();
    $('.bk_toptips span').html('密码不能少于6位');
    setTimeout(function(){
    $('.bk_toptips').hide();},2000);
    return;    
  }


    $.ajax({
       type: "POST",
          url: '<%=request.getContextPath() %>/LoginServlet',
          dataType: 'json',
          cache: false,
      data: {username: username,password: password},
      success: function(data) { 
    	  
    	  //返回的data是一个json对象
    	  console.log(data);
        if(data == null) {
          $('.bk_toptips').show();
          $('.bk_toptips span').html('服务端错误');
          setTimeout(function() {$('.bk_toptips').hide();}, 2000);
          return;
        }

        if(data.status != 0) {
          $('.bk_toptips').show();
          $('.bk_toptips span').html(data.message);
          setTimeout(function() {$('.bk_toptips').hide();}, 2000);
          return;
        }

        $('.bk_toptips').show();
        $('.bk_toptips span').html('登陆成功');
        setTimeout(function() {$('.bk_toptips').hide();}, 2000);
	
        console.log("123");
        
       
        //location.href="{{$return_url}}";
        location.href="<%=request.getContextPath() %>/GetCategoryServlet";

      },
      error: function(xhr, status, error) {
        console.log(xhr);
        console.log(status);
        console.log(error);
      }
    });

}
</script>



