<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="userEdit.title" /></tiles:put>
<tiles:put name="style" value="userEdit/index" />
<tiles:put name="content" type="string">
<h1><bean:message key="userEdit.headline" /></h1>
<html:errors />
<s:form>
    <table>
        <tr>
            <th><bean:message key="userEdit.input.userid.label" /></th>
            <td>
                ${ f:h(userEditForm.userId) }
                <input name="userId" value="${ f:h(userEditForm.userId) }" type="hidden" />
            </td>
        </tr>
        <tr>
            <th><bean:message key="userEdit.input.name.label" /></th>
            <td>
                <input name="name" value="${ f:h(userEditForm.name) }" type="text"  />
            </td>
        </tr>
        <tr>
            <th><bean:message key="userEdit.input.loginid.label" /></th>
            <td>
                <input name="loginId" value="${ f:h(userEditForm.loginId) }" type="text"  />
            </td>
        </tr>
        <tr>
            <th><bean:message key="userEdit.input.password.label" /></th>
            <td>
                <input name="password" value="${ f:h(userEditForm.password) }" type="password"  />
            </td>
        </tr>
        <tr>
            <th><bean:message key="userEdit.input.repassword.label" /></th>
            <td>
                <input name="repassword" value="${ f:h(userEditForm.repassword) }" type="password"  />
            </td>
        </tr>
        
    </table>
    <s:submit property="saveEdit">
        <bean:message key="userEdit.submit.button" />
    </s:submit>
</s:form>
</tiles:put>
</tiles:insert>