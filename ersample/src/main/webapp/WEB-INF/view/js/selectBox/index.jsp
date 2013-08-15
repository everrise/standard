<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
    <tiles:put name="title">
        <bean:message key="product.list.title" />
    </tiles:put>
    <tiles:put name="style" value="login/index" />
    <tiles:put name="js1" value="js/jquery-plugin-fake-box-1.0.js" />
    <tiles:put name="content" type="string">
        <div style="margin-left: 100px;">
            <select class="need-to-fake">
                <option>A</option>
                <option>A</option>
                <option>A</option>
                <option>A</option>
                <option>A</option>
                <option>A</option>
                <option>A</option>
                <option>A</option>
                <option>A</option>
                <option>A</option>
                <option>A</option>
                <option>A</option>
                <option>A</option>
                <option>A</option>
                <option>A</option>
                <option>A</option>
                <option>A</option>
            </select>
        </div>
        <script type="text/javascript">
        $(function() {
            $('.fkbox').fakeCheck();
        });
        </script>
    </tiles:put>
</tiles:insert>