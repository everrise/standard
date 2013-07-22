<%@tag pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="http://sastruts.seasar.org" %>
<%-- column number --%>
<%@attribute name="cn" %>

<%-- current order & column 1_1 --%>
<%@attribute name="oc" %>

<%-- other params --%>
<%@attribute name="other" %>



<c:set var="c">${ (fn:split(oc, '_'))[0] }</c:set>
<c:set var="o">${ (fn:split(oc, '_'))[1] }</c:set>
<c:if test="${ (c == cn) && o == '1' }">
    <c:set var="next">?oc=${ cn }_2&${ other }</c:set>
</c:if>
<c:if test="${ (c == cn) && o == '2' }">
    <c:set var="next">?oc=${ cn }_1&${ other }</c:set>
</c:if>
<c:if test="${ (c != cn) }">
    <c:set var="next">?oc=${ cn }_1&${ other }</c:set>
</c:if>
<s:link href="${ next }">
    <jsp:doBody />
    <c:if test="${ (c == cn) && o == '1' }">
        ▲
    </c:if>
    <c:if test="${ (c == cn) && o == '2' }">
        ▼
    </c:if>
</s:link>
