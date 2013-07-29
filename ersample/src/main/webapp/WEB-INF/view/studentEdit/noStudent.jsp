<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="studentEdit.title" /></tiles:put>
<tiles:put name="style" value="studentEdit/noStudent" />
<tiles:put name="content" type="string">
<h1><bean:message key="studentEdit.headline" /></h1>
<p><bean:message key="studentEdit.errors.nostudent" /></p>
<s:link href="/studentList/"><bean:message key="studentEdit.navi.studentlist" /></s:link>
</tiles:put>
</tiles:insert>