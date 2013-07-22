<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout_nologin.jsp" flush="true">
<tiles:put name="title"><bean:message key="login.title" /></tiles:put>
<tiles:put name="style" value="login/index" />
<tiles:put name="content" type="string">
<h1><bean:message key="login.headline" /></h1>
<html:errors /><br />
<html:errors property="invalidIdOrPassword" />
<s:form action="doLogin">
    <bean:message key="login.loginid.label" /> :
    <input name="loginId" value="${ loginForm.loginId }" type="text" />
    <html:errors property="loginId"/>
    <br />
    <bean:message key="login.password.label" /> :
    <input name="password" type="password" />
    <html:errors property="password"/>
    <br />
    <button type="submit"><bean:message key="login.submit.button" /></button>
</s:form>
</tiles:put>
</tiles:insert>