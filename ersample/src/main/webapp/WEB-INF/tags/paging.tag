<%@tag pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="s" uri="http://sastruts.seasar.org" %>
<%@attribute name="p" %>
<%@attribute name="total" %>
<%@attribute name="hasFirst" %>
<%@attribute name="hasPrev" %>
<%@attribute name="hasNext" %>
<%@attribute name="hasLast" %>
<%@attribute name="urlHead" %>
<%@attribute name="urlTail" %>

<div style="text-align: center;">
<ul class="pagination">
<c:if test="${ hasFirst }">
    <li class="pagin-first">
        <s:link href="">
            First
        </s:link>
    </li>
</c:if>
<c:if test="${ hasPrev }">
    <li class="pagin-prev">
        <s:link href="">
            Prev
        </s:link>
    </li>
</c:if>
<li class="pagin-move-left hide">
<a href="#">
	<<
</a>
</li>
<c:forEach var="i" begin="1" end="${ total}" step="1">
    <c:if test="${ p != i }">
        <li class="pagin">
            <s:link href="${ urlHead }${ i }${ urlTail }">
                <span>${ i }</span>
            </s:link>
        </li>
    </c:if>
    <c:if test="${ p == i }">
        <li class="pagin">
            <span>${ i }</span>
        </li>
    </c:if>
</c:forEach>
<li class="pagin-move-right hide">
<a href="#">
	>>
</a>
</li>
<c:if test="${ hasNext }">
    <li class="pagin-next">
        <s:link href="">
            Next
        </s:link>
    </li>
</c:if>
<c:if test="${ hasLast }">
    <li class="pagin-last">
        <s:link href="">
            Last
        </s:link>
    </li>
</c:if>
</ul>
</div>