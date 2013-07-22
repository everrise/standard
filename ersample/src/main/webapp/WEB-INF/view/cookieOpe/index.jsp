<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="cookieOpe.index.title" /></tiles:put>
<tiles:put name="style" value="cookieOpe/index" />
<tiles:put name="content" type="string">
<h1><bean:message key="cookieOpe.index.headline" /></h1>
<table>
    <tr>
        <th>
            <bean:message key="cookieOpe.index.currentCookieValue.label" />
        </th>
        <td>
            ${ f:h(cookieValue) }
        </td>
    </tr>
</table>

<s:form method="get" action="putCookie">
    <button type="submit"><bean:message key="cookieOpe.index.putCookie.button" /></button>
</s:form>
<s:form method="get" action="removeCookie">
    <button type="submit"><bean:message key="cookieOpe.index.removeCookie.button" /></button>
</s:form>

</tiles:put>
</tiles:insert>