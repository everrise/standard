<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="studentList.title" /></tiles:put>
<tiles:put name="style" value="studentList/index" />
<tiles:put name="content" type="string">
<h1><bean:message key="studentList.headline" /></h1>
<s:link href="/studentAdd">
    <bean:message key="studentList.navi.studentAdd" />
</s:link>

<s:form method="GET">
    <bean:message key="studentList.searchform.condition.label" />
    <input name="sw" value="${ f:h(studentListForm.sw) }" type="text" />
    <button type="submit">
         <bean:message key="studentList.searchform.submit.button" />
    </button>
</s:form>
${ pageData.firstRow } - ${ pageData.lastRow } / total ${ pageData.total }

<table border="1">
    <tr>
        <th>
            <ert:tablehead cn="1" oc="${ f:h(studentListForm.orderColumn) }" other="${ f:h(studentListForm.searchWordForUrl) }">
                <bean:message key="studentList.table.header.id" />
            </ert:tablehead>
        </th>
        <th>
            <ert:tablehead cn="2" oc="${ f:h(studentListForm.orderColumn) }" other="${ f:h(studentListForm.searchWordForUrl) }">
                <bean:message key="studentList.table.header.name" />
            </ert:tablehead>
        </th>
        <th>
			Delete
        </th>
    </tr>
    <c:forEach var="student" items="${ pageData.resultList }" varStatus="s">

        <tr>
        <s:form>
            <td>
            	<html:hidden property="a" value="${student.id}"/>
                <s:link href="/studentDetail/${ student.id }">
                    ${ f:h(student.id) }
                </s:link>
            </td>
            <td>${ f:h(student.name) }</td>
            <td>
            	<s:submit property="deleteStudent">Delete</s:submit>
            </td>
         </s:form>
        </tr>
    </c:forEach>

</table>

<!-- ???? -->
<ert:pagenavi p="${ studentListForm.page }"
              last="${ pageData.maxPage }"
              other="${ studentListForm.orderColumnForUrl }&${ studentListForm.searchWordForUrl }"
              hasPrev="${ pageData.hasPrev }"
              hasNext="${ pageData.hasNext }"
              />
</tiles:put>
</tiles:insert>