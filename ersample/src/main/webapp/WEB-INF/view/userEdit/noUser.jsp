<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="userEdit.title" /></tiles:put>
<tiles:put name="style" value="userEdit/noUser" />
<tiles:put name="content" type="string">
<h1><bean:message key="userEdit.headline" /></h1>
<p><bean:message key="userEdit.errors.nouser" /></p>
<s:link href="/userList/"><bean:message key="userEdit.navi.userlist" /></s:link>
</tiles:put>
</tiles:insert>