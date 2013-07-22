<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="userList.title" /></tiles:put>
<tiles:put name="style" value="userList/index" />
<tiles:put name="content" type="string">
<h1><bean:message key="userList.headline" /></h1>
<s:link href="/userAdd">
    <bean:message key="userList.navi.userAdd" />
</s:link>

<s:form method="GET">
    <bean:message key="userList.searchform.condition.label" />
    <input name="sw" value="${ f:h(userListForm.sw) }" type="text" />
    <button type="submit">
         <bean:message key="userList.searchform.submit.button" />
    </button>
</s:form>
${ pageData.firstRow } - ${ pageData.lastRow } / total ${ pageData.total }

<table>
    <tr>
        <th>
            <ert:tablehead cn="1" oc="${ f:h(userListForm.orderColumn) }" other="${ f:h(userListForm.searchWordForUrl) }">
                <bean:message key="userList.table.header.id" />
            </ert:tablehead>
        </th>
        <th>
            <ert:tablehead cn="2" oc="${ f:h(userListForm.orderColumn) }" other="${ f:h(userListForm.searchWordForUrl) }">
                <bean:message key="userList.table.header.name" />
            </ert:tablehead>
        </th>
    </tr>
    <c:forEach var="user" items="${ pageData.resultList }" varStatus="s">
        <tr>
            <td>
                <s:link href="/userDetail/${ user.id }">
                    ${ f:h(user.id) }
                </s:link>
            </td>
            <td>${ f:h(user.name) }</td>
        </tr>
    </c:forEach>
</table>
<ert:pagenavi p="${ userListForm.page }"
              last="${ pageData.maxPage }"
              other="${ userListForm.orderColumnForUrl }&${ userListForm.searchWordForUrl }"
              hasPrev="${ pageData.hasPrev }"
              hasNext="${ pageData.hasNext }"
              />
</tiles:put>
</tiles:insert>