<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="top.title" /></tiles:put>
<tiles:put name="style" value="top/index" />
<tiles:put name="content" type="string">
<h1><bean:message key="top.headline" /></h1>
<ul>
    <li><s:link href="/userList/"><bean:message key="top.menu.userList" /></s:link></li>
    <li><s:link href="/studentList/"><bean:message key="top.menu.studentList" /></s:link></li>
    <li><s:link href="/product/list"><bean:message key="top.menu.product.list" /></s:link></li>

</ul>
</tiles:put>
</tiles:insert>