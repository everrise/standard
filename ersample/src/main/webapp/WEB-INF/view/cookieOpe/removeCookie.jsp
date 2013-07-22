<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="cookieOpe.removeCookie.title" /></tiles:put>
<tiles:put name="style" value="cookieOpe/removeCookie" />
<tiles:put name="content" type="string">
<h1><bean:message key="cookieOpe.removeCookie.headline" /></h1>
<s:link href="/cookieOpe/">
    <bean:message key="cookieOpe.removeCookie.navi.cookieOpeIndex" />
</s:link>
</tiles:put>
</tiles:insert>