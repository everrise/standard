<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
    <tiles:put name="title">
        <bean:message key="product.list.title" />
    </tiles:put>
    <tiles:put name="style" value="login/index" />
    <tiles:put name="js1" value="js/jquery-plugin-fake-box-1.0.js" />
    <tiles:put name="content" type="string">
        <div style="margin-left: 100px;">
            <select class="custom">
                <option>A</option>
                <option>B</option>
                <option>C</option>
                <option>D</option>
                <option>E</option>
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
        	var $body = $('body');
        	if( ! $body.hasClass('hasJS') ){
        		$body.addClass('hasJS');
        	}
            $("select.custom").each(function() {
                var sb = new SelectBox({
                    selectbox: $(this),
                    height: 150,
                    width: 200
                });
            });
        });
        </script>
    </tiles:put>
</tiles:insert>