<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
    <tiles:put name="title">
        <bean:message key="product.list.title" />
    </tiles:put>
    <tiles:put name="style" value="login/index" />
    <tiles:put name="js1" value="js/jquery-plugin-fake-box-1.0.js" />
    <tiles:put name="content" type="string">
        <div style="margin-left: 100px;">
                <input class="fkbox" type="checkbox" value="4" id="input1" name="input1" tabindex="1"/>
                <label for="input1">Check box 1</label>
                <br/>
                <input class="fkbox" type="checkbox" value="5" id="input2" name="input2" tabindex="2"/>
                <label for="input2">Check box 2</label>
                <br/>
                <input class="fkbox" type="checkbox" value="6" name="input3" tabindex="3"/>
                <label>Check box 3</label>
                <br/>
                <input class="fkbox" type="checkbox" value="5" tabindex="4"/>
                <label>Check box 4</label>
                <br/>
                <input class="fkbox" type="checkbox" value="5" name="input5" tabindex="5"/>

<br><br>
                <input class="fkbox" type="radio" value="7" id="input7" name="radio" tabindex="7"/>
                <label for="input7">radio 1</label>
                <input class="fkbox" type="radio" value="8" id="input8" name="radio" tabindex="8"/>
                <label for="input8">radio 2</label>


        </div>
        <script type="text/javascript">
        $(function() {
            $('.fkbox').fakeCheck();
        });
        </script>
    </tiles:put>
</tiles:insert>