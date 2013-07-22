<html>
<head>
    <meta charset="UTF-8" />
    <title><tiles:getAsString name="title" /></title>
    <c:set var="contextPath" value="${ pageContext.request.contextPath }"/>
    <c:set var="style"><tiles:getAsString name="style" ignore="true" /></c:set>
    <c:if test="${ empty(style) }"><c:set var="style" value="style" /></c:if>
    <link rel="stylesheet" href="${contextPath}/css/${style}.css">
</head>
<body>
    <tiles:insert page="header.jsp" />
    <tiles:insert attribute="content" />
    <tiles:insert page="footer.jsp" />
</body>
</html>