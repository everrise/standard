<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
    <tiles:put name="title">
        <bean:message key="product.list.title" />
    </tiles:put>
    <tiles:put name="style" value="login/index" />
    <tiles:put name="content" type="string">
        <html:errors />
        <br />
        <table class="table table-striped table-bordered">
            <tr>
                <th>
                    <ert:tdSort column="productid" limit="${listForm.limit}" page="${listForm.page}" orderColumn="${listForm.orderColumn}" orderBy="${listForm.orderBy}" name="${listForm.name}">
                        <bean:message key="product.list.table.head.id" />
                    </ert:tdSort>
                </th>
                <th>
                    <ert:tdSort column="name" limit="${listForm.limit}" page="${listForm.page}" orderColumn="${listForm.orderColumn}" orderBy="${listForm.orderBy}" name="${listForm.name}">
                        <bean:message key="product.list.table.head.name" />
                    </ert:tdSort>
                </th>
            </tr>
            <c:forEach items="${pageData.resultList}" var="p">
                <tr>
                    <td><s:link href="/product/edit/${ p.productId }">${ f:h(p.productId) }</s:link></td>
                    <td>${ f:h(p.name) }</td>
                </tr>
            </c:forEach>
        </table>

        <ert:pagenavi p="${ userListForm.page }"
              last="${ pageData.maxPage }"
              other="${ userListForm.orderColumnForUrl }&${ userListForm.searchWordForUrl }"
              hasPrev="${ pageData.hasPrev }"
              hasNext="${ pageData.hasNext }"
              />
    </tiles:put>
</tiles:insert>