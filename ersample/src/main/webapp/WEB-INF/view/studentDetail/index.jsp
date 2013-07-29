<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="studentDetail.title" /></tiles:put>
<tiles:put name="style" value="studentDetail/index" />
<tiles:put name="content" type="string">
<h1><bean:message key="studentDetail.headline" /></h1>
<s:link href="/studentEdit/${ f:h(student.id) }">
    <bean:message key="studentDetail.navi.studentedit" />
</s:link>
<s:link href="/studentList">
    <bean:message key="studentDetail.navi.studentList" />
</s:link>
<table border="1">
    <tr>
        <th><bean:message key="studentDetail.table.header.id" /></th>
        <td>${ f:h(student.id) }</td>
    </tr>
    <tr>
        <th><bean:message key="studentDetail.table.header.name" /></th>
        <td>${ f:h(student.name) }</td>
    </tr>
    <tr>
        <th><bean:message key="studentDetail.table.header.address" /></th>
        <td>${ f:h(student.address) }</td>
    </tr>
    <tr>
        <th><bean:message key="studentDetail.table.header.email" /></th>
        <td>${ f:h(student.email) }</td>
    </tr>
</table>
</tiles:put>
</tiles:insert>