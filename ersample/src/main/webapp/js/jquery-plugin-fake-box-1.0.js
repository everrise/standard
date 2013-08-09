/**
 * @author Tai Sang
 * @version A.0001
 * @since 2013060
 */

(function($) {
    $.fn.fakeBox = function(options) {
        $.fn.fakeBox.settings = $.extend({}, $.fn.fakeBox.defaults, options);// load options and defaults, passing to $vars

        return this.each(function() {
            $.isFunction(options.doBefore) && options.doBefore.call(this);//doBefore function is execute first
            // Execute code start
            var $vars = $.extend({}, $.fn.fakeBox.settings, $.fn.fakeBox.getVars());
            $vars.target = $(this);

            $.fn.fakeBox.render($vars);

            // Execute code end
            $.isFunction(options.doAfter) && options.doAfter.call(this);//doAfter function is execute lastly
        });
    };

    $.fn.fakeBox.render = function($vars) {

    }

    // default value, use when options are missing
    $.fn.fakeBox.defaults = {
        doBefore : function() {
        },
        doAfter : function() {
        }
    }

    //this create an empty object hold all necessary variables
    $.fn.fakeBox.getVars = function(){
        return {
            id : null,
            name : null,
            _class : null,
            type : null,
            text : null,
            checked : null,
            disabled : null,
            readonly : null,
            value : null
        }
    }

}(jQuery));