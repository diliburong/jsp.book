<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%request.setCharacterEncoding("utf-8"); %>  
<jsp:include page="head.jsp" flush="true">
    <jsp:param name="title" value="书籍列表"/>
</jsp:include>


<link rel="stylesheet" href="public/css/swiper.min.css">
	<div class="page">
	<div class="page" style="top: 0;">
		<div class="swiper-container"style="width: 100%;"><!--swiper容器[可以随意更改该容器的样式-->  
	    <div class="swiper-wrapper"> 
			<c:forEach items="${pdt_images}" var ="pdt_image">
	    	<div class="swiper-slide">
	    		<img class="img-responsive" src="public${pdt_image.image_path }" alt="">
	    	</div>				
			</c:forEach>

	    </div>  
	     <div class="swiper-pagination swiper-pagination-clickable swiper-pagination-bullets" ></div>
	</div>  




    <div class="weui_cells_title">
        <span class="bk_title">${product.name}</span>
        <span class="bk_price" style="float:right;">￥${product.price}</span>
    </div>
    <div class="weui_cells">
        <div class="weui_cell">
            <p class="bk_summary">${product.summary}</p>
        </div>
    </div>  

    <div class="weui_cells_title">详细介绍</div>
	<div class="weui_cells">
		<div class="weui_cell">

		<p>${pdt_content.content }</p>
		
		

			
		</div>
	</div>
</div>	

<div class="bk_fix_bottom">
	<div class="bk_half_area">
		<button class="weui_btn weui_btn_primary" onclick="_addCart();">加入购物车</button>
	</div>
	<div class="bk_half_area">
		<button class="weui_btn weui_btn_dafault" style="color:black" onclick="_toCart()">结算(<span id="cart_num" class="m3_price">{{$count}}</span>)</button>
	</div>
</div>


</div>
<jsp:include page="footer.jsp" flush="true"/>


<script type="text/javascript" src="public/js/swiper.min.js" charset="utf-8"></script>
<script>

 var mySwiper = new Swiper(".swiper-container",{  
        
        pagination:".swiper-pagination",/*分页器*/
        paginationClickable :true,
        paginationType : 'bullets',    
        autoplay:3000/*每隔3秒自动播放*/ ,
        touchRatio : 0.7
    }) 
 
 
 function _addCart(){

	 	var product_id="${product.id}"
	 	$.ajax({
	 		type: "GET",
	 		url: '<%=request.getContextPath() %>/CartAddServlet?product_id=${product.id}',
	 		dataType: 'json',
	 		cache: false,
	        success: function(data) {  //返回的data是一个json对象
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
	      	$('.bk_toptips span').html('添加成功');
	      	setTimeout(function() {$('.bk_toptips').hide();}, 2000);


	      	var num=$('#cart_num').html();
	      	if (num=='') num=0;
	      	$('#cart_num').html(Number(num)+1);

	      },
	      error: function(xhr, status, error) {
	      	console.log(xhr);
	      	console.log(status);
	      	console.log(error);
	      }
	  });
	 }
 
 function _toCart(){

	  location.href='<%=request.getContextPath() %>/GetCartListServlet';
	}

 
</script>