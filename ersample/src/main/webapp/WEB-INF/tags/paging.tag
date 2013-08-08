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
<li class="pagin-first${hasFirst ? '' : ' sleep'}">
        <s:link href="${ urlHead }1${ urlTail }">
            <span>First</span>
        </s:link>
</li>
<li class="pagin-prev${hasPrev ? '' : ' sleep'}">
        <s:link href="${ urlHead }${ p - 1 }${ urlTail }">
            <span>Prev</span>
        </s:link>
</li>
<li class="pagin-left">
        <a href="#"><span>&lt;&lt;</span>
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
        <li class="pagin sleep">
            <a><span>${ i }</span></a>
        </li>
    </c:if>
</c:forEach>
<li class="pagin-right">
    <a href="#"><span>&gt;&gt;</span></a>
</li>
<li class="pagin-next${hasNext ? '' : ' sleep'}">
<s:link href="${ urlHead }${ p + 1 }${ urlTail }">
    <span>Next</span>
</s:link>
</li>
<li class="pagin-last${hasLast ? '' : ' sleep'}">
<s:link href="${ urlHead }${ total }${ urlTail }">
    <span>Last</span>
</s:link>
</li>
</ul>
</div>