<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%request.setCharacterEncoding("utf-8"); %>  
<jsp:include page="head.jsp" flush="true">
    <jsp:param name="title" value="书籍列表"/>
</jsp:include>

<div class="page">
	<div class="weui_cells_title">带图标、说明、跳转的列表项</div>
	<div class="weui_cells weui_cell_access">
		<c:forEach items="${products}" var="product">
			<a class="weui_cell"
				href="<%=request.getContextPath() %>/GetPdtContentServlet?product_id=${product.id }">
				<div class="weui_cell_hd">
					<img class="bk_preview" src="public${product.preview }" alt="">
				</div>
				<div class="weui_cell_bd">
					<div style="margin-bottom: 10px;">
						<span class="bk_title">${product.name}</span> <span
							class="bk_price" style="float: right;">￥${product.price }</span>
					</div>
					<p class="bk_summary">${product.summary }</p>
				</div>
				<div class="weui_cell_ft"></div>
			</a>
		</c:forEach>
	</div>
</div>





<jsp:include page="footer.jsp" flush="true"/>