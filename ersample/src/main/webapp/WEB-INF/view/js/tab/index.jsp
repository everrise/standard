<%@page pageEncoding="UTF-8"%>
<tiles:insert template="/WEB-INF/view/common/layout.jsp" flush="true">
    <tiles:put name="title">
        <bean:message key="product.list.title" />
    </tiles:put>
    <tiles:put name="style" value="login/index" />
    <tiles:put name="js1" value="js/jquery-plugin-fake-box-1.0.js" />
    <tiles:put name="content" type="string">
        <div style="margin-left: 100px;">
                <input class="fkbox" type="checkbox" value="4" id="input1" name="input1"/>
                <label for="input1">Check box 1</label>
                <br/>
                <input class="fkbox" type="checkbox" value="5" id="input2" name="input2"/>
                <label for="input2">Check box 2</label>
                <br/>
                <input class="fkbox" type="checkbox" value="6" name="input3"/>
                <label>Check box 3</label>
                <br/>
                <input class="fkbox" type="checkbox" value="5"/>
                <label>Check box 4</label>
                <br/>
                <input class="fkbox" type="checkbox" value="5" name="input5"/>

<br><br>
                <input class="fkbox" type="radio" value="7" id="input7" name="radio"/>
                <label for="input7">radio 1</label>
                <input class="fkbox" type="radio" value="8" id="input8" name="radio"/>
                <label for="input8">radio 2</label>
                <input class="fkbox" type="radio" value="9" id="input9" name="radio"/>
                <label for="input9">radio 2</label>
                <input class="fkbox" type="radio" value="10" id="input10" name="radio"/>
                <label for="input10">radio 2</label>

                <br/> <br/>
                <input class="fkbox" type="checkbox" value="100" name="input100" />
                <label>Check box 100</label>
                <br/>
                <input class="fkbox" type="checkbox" value="11" name="input11"/>
                <label>Check box 11</label>
                <br/>
                <input class="fkbox" type="checkbox" value="12"/>
                <label>Check box 12</label>
<br><br>
                <input class="fkbox" type="radio" value="13" id="input13" name="radio1"/>
                <label for="input13">radio 2</label>
                <input class="fkbox" type="radio" value="14" id="input14" name="radio1"/>
                <label for="input14">radio 2</label>

            <select class="custom">
                <option>A</option>
                <option>B</option>
                <option>C</option>
                <option>D</option>
                <option>E</option>
                <option>F</option>
                <option>G</option>
                <option>H</option>
                <option>I</option>
                <option>J</option>
                <option>K</option>
                <option>L</option>
                <option>M</option>
                <option>N</option>
                <option>O</option>
                <option>P</option>
                <option>A</option>
            </select>

            <br>
            <select class="custom">
                                <option>A</option>
                <option>B</option>
                <option>C</option>
                <option>D</option>
                <option>E</option>
                <option>F</option>
                <option>G</option>
                <option>H</option>
                <option>I</option>
                <option>J</option>
                <option>K</option>
                <option>L</option>
                <option>M</option>
                <option>N</option>
                <option>O</option>
                <option>P</option>
                <option>A</option>
            </select>
        </div>
        <script type="text/javascript">
        $(function() {
            $('.fkbox').fakeCheck();
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