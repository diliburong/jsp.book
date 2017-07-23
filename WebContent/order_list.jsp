<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%request.setCharacterEncoding("utf-8"); %>  
<jsp:include page="head.jsp" flush="true">
    <jsp:param name="title" value="订单列表"/>
</jsp:include>

<div class="page">
	
	<c:forEach items="${orders }" var="order">
		<div class="weui_cells_title">
			<span>订单号: ${order.order_no}</span>
			<c:choose>
				<c:when test="${order.status ==1}">
				<span style="float: right;" class="bk_price">
					未支付
				</span>
				</c:when>
				<c:otherwise>
				<span style="float: right;" class="bk_important">
					已支付
				</span>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="weui_cells">
			<c:forEach items="${order.order_items }" var="order_item">

			<div class="weui_cell">
				<div class="weui_cell_hd">
					<img src="public${order_item.pdt.preview}" alt="" class="bk_icon">
				</div>
				<div class="weui_cell_bd weui_cell_primary">
					<p class="bk_summary">${order_item.pdt.name}</p>
				</div>
				<div class="weui_cell_ft">
					<span class="bk_summary">${order_item.pdt.price}</span>
					<span> x </span>
					<span class="bk_important">${order_item.count}</span>
				</div>
			</div>
			</c:forEach>
		</div>
		<div class="weui_cells_tips" style="text-align: right;">合计: <span class="bk_price">${order.total_price}</span></div>
	
	</c:forEach>
	
	
	
	
	
	
	
	
</div>





<jsp:include page="footer.jsp" flush="true"/>