/**
 * 
 */

(function($) {
	$.fn.pagin = function(options) {
	    // Bob's default settings:
	    var defaults = {
    		onDone : function() {},
	        color: "#F00",
	        font-size: "1.2em"
	    };

		// This is the easiest way to have default options.
	    var settings = $.extend( {}, defaults, options );

	    return this.each(function() {
	    	 var $this = $( this );
	    });
	};

}(jQuery));