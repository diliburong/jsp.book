
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%request.setCharacterEncoding("utf-8"); %>  
<jsp:include page="head.jsp" flush="true">
    <jsp:param name="title" value="书籍类别"/>
</jsp:include>



<div class="page">

<div class="weui_cells">
	<div class="weui_cell weui_cell_select ">
		<div class="weui_cell_bd weui_cell_primary">
			
		</div>
	</div>
</div>

<div class="weui_cells_title">选择书籍类别</div>
 <div class="weui_cells weui_cells_access">
 	
 	<c:forEach items="${categorys}" var ="category">
 	<a class="weui_cell" href="<%=request.getContextPath() %>/GetProductServlet?category_id=${category.id }">
 		<div class="weui_cell_bd weui_cell_primary">
 			<p>${category.name}</p>
 		</div>
		<div class="weui_cell_ft">说明文字</div>
 	</a>
	</c:forEach>
 </div>

</div>

<jsp:include page="footer.jsp" flush="true"/>