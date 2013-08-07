<html>
<head>
    <meta charset="UTF-8" />
    <title><tiles:getAsString name="title" /></title>
    <c:set var="contextPath" value="${ pageContext.request.contextPath }"/>
    <link rel="stylesheet" href="${contextPath}/css/common.css" />
    <link rel="stylesheet" href="${contextPath}/css/bootstrap.min.css" />
    <script type="text/javascript" src="${contextPath}/js/jquery-2.0.3.min.js"></script>
    <script type="text/javascript" src="${contextPath}/js/jquery-plugin-pagin-1.0.js"></script>
    <c:set var="style"><tiles:getAsString name="style" ignore="true" /></c:set>
    <c:if test="${ empty(style) }"><c:set var="style" value="style" /></c:if>
    <link rel="stylesheet" href="${contextPath}/css/${style}.css" />

</head>
<body>
    <tiles:insert page="header.jsp" />
    <tiles:insert attribute="content" />
    <tiles:insert page="footer.jsp" />
</body>
</html>