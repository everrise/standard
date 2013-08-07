/**
 *
 */

(function($) {
	$.fn.pagin = function(options) {
		// This is the easiest way to have default options.
	    var settings = $.extend({}, $.fn.pagin.defaults, options );

	    return this.each(function() {
	    	 $.isFunction( options.doBefore ) && options.doBefore.call( this );
	    	 console.log(settings.color);
	    	 console.log(settings.fontSize);
	    	//Execute code
	    	 var $this = $( this );
	    	 console.log($this);
	    	 var $totalPage = $this.find('.pagin').length;
	    	 console.log($totalPage);
	    	 if($totalPage > settings.maxDisplayPage){
	    		 if(settings.currentPage >= (settings.maxDisplayPage / 2 + 1)){
	    			 console.log("left");
	    		 }
	    		 if(settings.currentPage <= $totalPage - (settings.maxDisplayPage / 2)){
	    			 console.log("right");
	    		 }
	    	 }
	    	//Execute code
	    	 $.isFunction( options.doAfter ) && options.doAfter.call( this );
	    });
	};
    // Bob's default settings:
	 $.fn.pagin.defaults = {
		 doBefore : function() {},
		 doAfter : function() {},
	     color : "#F00",
	     fontSize : "1.2em",
	     maxDisplayPage: 5,
	     currentPage : 1,
	     nonPage : 6
	 }
}(jQuery));