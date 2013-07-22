<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="userDetail.title" /></tiles:put>
<tiles:put name="style" value="userDetail/index" />
<tiles:put name="content" type="string">
<h1><bean:message key="userDetail.headline" /></h1>
<s:link href="/userEdit/${ f:h(user.id) }">
    <bean:message key="userDetail.navi.useredit" />
</s:link>
<s:link href="/userList">
    <bean:message key="userDetail.navi.userList" />
</s:link>
<table>
    <tr>
        <th><bean:message key="userDetail.table.header.id" /></th>
        <td>${ f:h(user.id) }</td>
    </tr>
    <tr>
        <th><bean:message key="userDetail.table.header.name" /></th>
        <td>${ f:h(user.name) }</td>
    </tr>
    <tr>
        <th><bean:message key="userDetail.table.header.loginid" /></th>
        <td>${ f:h(user.loginId) }</td>
    </tr>
</table>
</tiles:put>
</tiles:insert>