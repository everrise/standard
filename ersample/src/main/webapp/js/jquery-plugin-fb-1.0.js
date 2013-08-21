/**
 * @classDescription     Fb plugin hide original check or radio input and generate
 *                       a wrapper element to wrap input and label together while keeping the original tab event.
 *                       Thus, this maximizes the user experience when using keyboard
 * @author               Tai Sang - tai.nguyen@everrise.asia
 * @version              V.1.0.2
 * @since                2013060
 * @dependency           jquery-2.0.3.min.js
 * @param                opntion.doBefore     callback function execute before render a box
 * @param                options.doAfter      callback function execute after render a box
 * @param                options.spanClass    default : 'wrap'
 */

(function($) {
    $.fn.fakeCheck = function(options) {
        var $settings = $.extend({}, $.fn.fakeCheck.defaults, options);// load options and defaults, passing to $vars
        var $syncId = 0;//for generating id when no id is defined
        var $selector = this.each(function() {
            $syncId++;
            $.isFunction($settings.doBefore) && $settings.doBefore.call(this);//doBefore function is execute first
            // Execute code start
            var $vars = $.extend({}, $settings, {input : null});
            $vars.input = $(this);
            render($vars, 'fb-' + $syncId);
            // Execute code end
            $.isFunction($settings.doAfter) && $settings.doAfter.call(this);//doAfter function is execute lastly
        });
        return $selector;
    };

    function render($vars, $syncId) {
        var $fb = $('<span>');//create new wrapper element
        $fb.attr('tabindex', $vars.input.attr('tabindex'));//transfer tab index to wrapper
        //add class for wrapper
        if($vars.input.attr('type') == 'checkbox'){
            $fb.attr('class', 'fcb-' + $vars.spanClass); //
        } else{
            $fb.attr('class', 'frb-' + $vars.spanClass).attr('data-name', 'frc-' + $vars.input.attr('name')); //
        }
        if($vars.input.attr('id') === undefined){
            $vars.input.attr('id', $syncId);//set id if id is underfined
        }
        var $label = $vars.input.next();//get lable next to input
        if(!$label.is('label')){//if no label found
            $label = $('<label>').html('&nbsp;');//create an empty label
            $vars.input.after($label);//append label after input
        }
        if($label.attr('for') === undefined){
            $label.attr('for', $vars.input.attr('id')); //set for attribute of label
        }
        if($vars.input.prop('disabled') == true){
            $fb.addClass('disabled');
        }
        if($vars.input.prop('readonly') == true){
            $fb.addClass('readonly');
        }
        $vars.input.add($label).wrapAll($fb);//wrap input and label in wrapper
        $vars.input.addClass('real-input');//hide real input
        $vars.input.on({
            focus : function(e){//add focus to current element
                $(this).parent().addClass('focus');
            },
            blur : function(e){//remove focus from losing element
                $(this).parent().removeClass('focus');
            }
        });
    }

    // default value, use when options are missing
    $.fn.fakeCheck.defaults = {
        doBefore : function() {},
        doAfter : function() {},
        spanClass : 'wrap'
    }
}(jQuery));