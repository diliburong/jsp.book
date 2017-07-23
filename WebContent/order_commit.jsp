<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%request.setCharacterEncoding("utf-8"); %>  
<jsp:include page="head.jsp" flush="true">
    <jsp:param name="title" value="订单提交"/>
</jsp:include>

<div class="page">
	<div class="page bk_content" style="top: 0;">
		<div class="weui_cells">
			<c:forEach items="${cart_items}" var="cart_item">
				<div class="weui_cell">
					<div class="weui_cell_hd">
						<img src="public${cart_item.pdt.preview}" alt="" class="bk_icon">
					</div>
					<div class="weui_cell_bd weui_cell_primary">
						<p class="bk_summary">${cart_item.pdt.name}</p>
					</div>
					<div class="weui_cell_ft">
						<span class="bk_price">${cart_item.pdt.price}</span> <span>
							x </span> <span class="bk_important">${cart_item.count}</span>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="weui_cells_title">支付方式</div>
		<div class="weui_cells">
			<div class="weui_cell weui_cell_select">
				<div class="weui_cell_bd weui_cell_primary">
					<select class="weui_select" name="payway">
						<option selected="" value="1">支付宝</option>
						<option value="2">微信</option>
					</select>
				</div>
			</div>


		</div>

		<form action="<%=request.getContextPath()%>/PayOrderServlet " id="alipay" method="post">
			<input type="hidden" name="total_price" value="" />
			<input type="hidden" name="name" value="" /> <input type="hidden"
				name="order_no" value="" />
		</form>

		<div class="weui_cells">
			<div class="weui_cell">
				<div class="weui_cell_bd weui_cell_primary">
					<p>总计:</p>
				</div>
				<div class="weui_cell_ft bk_price" style="font-size: 25px;">￥${total_price}
				</div>
			</div>
		</div>

	</div>
	<div class="bk_fix_bottom">
		<div class="bk_btn_area">
			<button class="weui_btn weui_btn_primary" onclick="_onPay();">pay</button>
		</div>
	</div>

</div>





<jsp:include page="footer.jsp" flush="true"/>


<script>
	function _onPay(){
		
		$('#alipay').submit();
		location.href='<%=request.getContextPath() %>/ToOrderListServlet';
		return;
	}

</script>