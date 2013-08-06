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
    <li>
        <s:link href="">
            First
        </s:link>
    </li>
</c:if>
<c:if test="${ hasPrev }">
    <li>
        <s:link href="">
            Prev
        </s:link>
    </li>
</c:if>
<c:forEach var="i" begin="1" end="${ total}" step="1">
    <c:if test="${ p != i }">
        <li>
            <s:link href="${ urlHead }${ i }${ urlTail }">
                <span>${ i }</span>
            </s:link>
        </li>
    </c:if>
    <c:if test="${ p == i }">
        <li>
            <span>${ i }</span>
        </li>
    </c:if>
</c:forEach>
<c:if test="${ hasNext }">
    <li>
        <s:link href="">
            Next
        </s:link>
    </li>
</c:if>
<c:if test="${ hasLast }">
    <li>
        <s:link href="">
            Last
        </s:link>
    </li>
</c:if>
</ul>
</div>
<script type="text/javascript">
$(function() {
	$('.pagination').
});
</script>