<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="userAdd.title" /></tiles:put>
<tiles:put name="style" value="userAdd/index" />
<tiles:put name="content" type="string">
<h1><bean:message key="userAdd.headline" /></h1>
<s:link href="/userList">
    <bean:message key="userAdd.navi.userList" />
</s:link>
<html:errors />
<s:form>
    <table>
        <tr>
            <th><bean:message key="userAdd.input.name.label" /></th>
            <td>
                <input name="name" value="${ f:h(userAddForm.name) }" type="text"  />
            </td>
        </tr>
        <tr>
            <th><bean:message key="userAdd.input.loginid.label" /></th>
            <td>
                <input name="loginId" value="${ f:h(userAddForm.loginId) }" type="text"  />
            </td>
        </tr>
        <tr>
            <th><bean:message key="userAdd.input.password.label" /></th>
            <td>
                <input name="password" value="${ f:h(userAddForm.password) }" type="password"  />
            </td>
        </tr>
        <tr>
            <th><bean:message key="userAdd.input.repassword.label" /></th>
            <td>
                <input name="repassword" value="${ f:h(userAddForm.repassword) }" type="password"  />
            </td>
        </tr>
    </table>
    <s:submit property="saveAdd">
        <bean:message key="userAdd.submit.button" />
    </s:submit>
</s:form>
</tiles:put>
</tiles:insert>