/**
 * @author Tai Sang
 * @version A.0001
 * @since 2013060
 */

(function($) {
    $.fn.fakeCheck = function(options) {
        $.fn.fakeCheck.settings = $.extend({}, $.fn.fakeCheck.defaults, options);// load options and defaults, passing to $vars
		var $syncId = 0;
        return this.each(function() {
        	try{
        		$syncId++;
	            $.isFunction(options.doBefore) && options.doBefore.call(this);//doBefore function is execute first
	            // Execute code start
	            var $vars = $.extend({}, $.fn.fakeCheck.settings, $.fn.fakeCheck.getVars());
	            $vars.target = $(this);
	            $.fn.fakeCheck.render($vars, 'chkbox-' + $syncId);
	            // Execute code end
	            $.isFunction(options.doAfter) && options.doAfter.call(this);//doAfter function is execute lastly
        	} catch(e){
        		console.log(e);
        	}
        });
    };

    $.fn.fakeCheck.render = function($vars, $syncId) {
        var $fb = $('<span>');//create new div to replace old input
        $fb.attr('tabindex', $vars.target.attr('tabindex'));//keep old tab index
        $fb.attr('class', $vars.fclass);
        $fb.attr($vars.syncAttr, $syncId);//sync 2 object
        $vars.target.attr($vars.syncAttr, $syncId);
        if($vars.target.attr('disabled') != null){
        	$fb.addClass('disabled');
        }
        if($vars.target.attr('readonly') != null){
        	$fb.addClass('readonly');
        }
        $fb.on('click keypress', function(e){
            e.preventDefault();
            e.stopPropagation();
        	if( !$fb.hasClass('disabled') && !$fb.hasClass('readonly') ){
        		$('input[' + $vars.syncAttr + '=' + $(this).attr($vars.syncAttr) + ']').click();
            }
        });
        $vars.target.on('change', function(){
			if($(this).prop('checked') == true){
				$('.' + $vars.fclass + '[' + $vars.syncAttr + '=' + $(this).attr($vars.syncAttr) + ']').addClass('checked');
			} else{
				$('.' + $vars.fclass + '[' + $vars.syncAttr + '=' + $(this).attr($vars.syncAttr) + ']').removeClass('checked');
			}
		});
        $vars.target.after($fb);
        //$vars.target.hide();
    }

    // default value, use when options are missing
    $.fn.fakeCheck.defaults = {
        doBefore : function() {
        },
        doAfter : function() {
        },
        fclass : 'fake-check',
        syncAttr : 'data-sync'
    }

    $.fn.fakeCheck.getVars = function(){
        return {
        	target : null
        }
    }
}(jQuery));