<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="studentAdd.title" /></tiles:put>
<tiles:put name="style" value="studentAdd/index" />
<tiles:put name="content" type="string">
<h1><bean:message key="studentAdd.headline" /></h1>
<s:link href="/studentList">
    <bean:message key="studentAdd.navi.studentList" />
</s:link>
<html:errors />
<s:form>
    <table border="1">
        <tr>
            <th><bean:message key="studentAdd.input.name.label" /></th>
            <td>
                <input name="studentName" value="${studentAddForm.studentName}" type="text"  />
            </td>
        </tr>
        <tr>
            <th><bean:message key="studentAdd.input.address.label" /></th>
            <td>
                <input name="address" value="${studentAddForm.address}" type="text"  />
            </td>
        </tr>
        <tr>
            <th><bean:message key="studentAdd.input.email.label" /></th>
            <td>
                <input name="email" value="${studentAddForm.email}" type="text"  />
            </td>
        </tr>
    </table>
    <s:submit property="saveStudentAdd">
        <bean:message key="studentAdd.submit.button" />
    </s:submit>
</s:form>
</tiles:put>
</tiles:insert>