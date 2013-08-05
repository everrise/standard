<%@tag pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="http://sastruts.seasar.org" %>
<%-- column number --%>
<%@attribute name="limit" %>
<%@attribute name="page" %>
<%@attribute name="orderColumn" %>
<%@attribute name="orderBy" %>
<%@attribute name="name" %>
<%@attribute name="column" %>

<c:if test="${ orderColumn == column}">
    <c:if test="${ orderBy == 'asc'}">
        <c:set var="order">desc</c:set>
    </c:if>
    <c:if test="${ orderBy != 'asc'}">
        <c:set var="order">asc</c:set>
    </c:if>
</c:if>
<c:if test="${ orderColumn != column}">
    <c:set var="order">asc</c:set>
</c:if>

<c:set var="next">${limit}/${page}/${column}/${order}/${name}</c:set>

<s:link href="${request.contextPath}/product/list/${ next }">
    <jsp:doBody />
    <c:if test="${ orderColumn == column && orderBy == 'asc' }">
        ▲
    </c:if>
    <c:if test="${ orderColumn == column && orderBy == 'desc' }">
        ▼
    </c:if>
</s:link>
