<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
<tiles:put name="title"><bean:message key="cookieOpe.putCookie.title" /></tiles:put>
<tiles:put name="style" value="cookieOpe/putCookie" />
<tiles:put name="content" type="string">
<h1><bean:message key="cookieOpe.putCookie.headline" /></h1>
<s:link href="/cookieOpe/">
    <bean:message key="cookieOpe.putCookie.navi.cookieOpeIndex" />
</s:link>
</tiles:put>
</tiles:insert>