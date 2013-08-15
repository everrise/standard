<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
    <tiles:put name="title">
        <bean:message key="product.list.title" />
    </tiles:put>
    <tiles:put name="style" value="login/index" />
    <tiles:put name="js1" value="js/jquery-plugin-fake-box-1.0.js" />
    <tiles:put name="content" type="string">

    <style>
        .fake-check{
            display: inline-block;
            width: 20px;
            height: 20px;
            background-color: #DF3;
            color: #E22;
        }
        .fake-check.readonly{
            background-color: #DA3;
        }
        .fake-check.disabled{
            background-color: #D03;
            cursor: disabled;
        }

    </style>
    <div>
        <label for="afa">afa</label>
        <input class="js" type="checkbox" value="1" id="afa" name="afa" tabindex="1"/>
        <label for="afb">afb</label>
        <input class="js" type="checkbox" value="2" id="afb" name="afb" tabindex="2" readonly/>
        <label for="afc">afc</label>
        <input class="js" type="checkbox" value="3" id="afc" name="afc" tabindex="3" disabled/>
</div>
<div>
        <span class="fake-checkbox" tabindex="4">
            <input type="checkbox" value="4" id="afe" name="afe"/>
            <label for="afe">afe</label>
        </span>
</div>
        <script type="text/javascript">
        $(function() {
            $('input.js').fakeCheck({
            	fclass : 'fake-check'
            });
        });
        </script>
    </tiles:put>
</tiles:insert>