<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout_nologin.jsp" flush="true">
<tiles:put name="title"><bean:message key="prePostOnly.title" /></tiles:put>
<tiles:put name="style" value="top/index" />
<tiles:put name="content" type="string">
<h1><bean:message key="prePostOnly.headline" /></h1>
<s:form action="postOnly" method="post">
    <s:submit><bean:message key="prePostOnly.post.button" /></s:submit>
</s:form>
<s:form action="postOnly" method="get">
    <s:submit><bean:message key="prePostOnly.get.button" /></s:submit>
</s:form>

</tiles:put>
</tiles:insert>