<%@tag pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="http://sastruts.seasar.org" %>
<%@attribute name="last" %>
<%@attribute name="p" %>
<%@attribute name="other" %>
<%@attribute name="hasPrev" %>
<%@attribute name="hasNext" %>

<c:if test="${ hasPrev }">
    <s:link href="?pg=${ p - 1 }&${ other }">
        PrePage
    </s:link>
</c:if>
<c:forEach var="i" begin="1" end="${ last }" step="1">
    <c:if test="${ p != i }">
        <s:link href="?pg=${ i }&${ other }">
            ${ i }
        </s:link>
    </c:if>
    <c:if test="${ p == i }">
        ${ i }
    </c:if>
</c:forEach>
<c:if test="${ hasNext }">
    <s:link href="?pg=${ p + 1 }&${ other }">
        NextPage
    </s:link>
</c:if>
