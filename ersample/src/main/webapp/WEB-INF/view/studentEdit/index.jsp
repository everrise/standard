<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="studentEdit.title" /></tiles:put>
<tiles:put name="style" value="studentEdit/index" />
<tiles:put name="content" type="string">
<h1><bean:message key="studentEdit.headline" /></h1>
<html:errors />
<s:form>
    <table border="1">
        <tr>
            <th><bean:message key="studentEdit.input.studentid.label" /></th>
            <td>
                ${ f:h(studentEditForm.studentId) }
                <input name="studentId" value="${ f:h(studentEditForm.studentId) }" type="hidden" />
            </td>
        </tr>
        <tr>
            <th><bean:message key="studentEdit.input.name.label" /></th>
            <td>
                <input name="studentName" value="${ f:h(studentEditForm.studentName) }" type="text"  />
            </td>
        </tr>
        <tr>
            <th><bean:message key="studentEdit.input.address.label" /></th>
            <td>
                <input name="address" value="${ f:h(studentEditForm.address) }" type="text"  />
            </td>
        </tr>
        <tr>
            <th><bean:message key="studentEdit.input.email.label" /></th>
            <td>
                <input name="email" value="${ f:h(studentEditForm.email) }" type="text"  />
            </td>
        </tr>

    </table>
    <s:submit property="saveEdit">
        <bean:message key="studentEdit.submit.button" />
    </s:submit>
</s:form>
</tiles:put>
</tiles:insert>