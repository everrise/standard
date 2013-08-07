/**
 *
 */

(function($) {
    $.fn.pagin = function(options) {
        // load options
        var settings = $.extend({}, $.fn.pagin.defaults, options);

        return this.each(function() {
        	//doBefore function is execute first
            $.isFunction(options.doBefore) && options.doBefore.call(this);
            console.log(settings.color);
            console.log(settings.fontSize);
            // Execute code
            $.fn.pagin.render($(this), settings);
            // Execute code
        	//doAfter function is execute lastly
            $.isFunction(options.doAfter) && options.doAfter.call(this);
        });
    };

    $.fn.pagin.render = function($target, settings) {
        var $pages = $target.find('.pagin');//find all LI which is real page(some LIs are not for page)
        var $pageLength = $pages.length;//get total page
        console.log('number of page: ' + $pageLength);
        if ($pageLength > settings.maxDisplayPage) {//when total page is smaller than total
            var $half = settings.maxDisplayPage / 2;
            for(var $i = 1; $i <= $pageLength; $i++){
            	var $li = $($pages[$i - 1]);//convert to zero-index
            	$li.removeClass('hide');//clear all class hide on page LI
            	if(settings.currentPage > $half + 1//hide the left page number if they are out range
            			&& $i < (settings.currentPage - $half)
            			&& $i <= $pageLength - settings.maxDisplayPage){
//        			console.log("B|" + settings.currentPage + "|" + $i + "|" + $pageLength + "|" + $half);
        			$li.addClass('hide');
                }
            	if(settings.currentPage < $pageLength - $half//hide the right page number if they are out range
            			&& $i > settings.currentPage + $half
            			&& $i > settings.maxDisplayPage){
//            		console.log("A|" + settings.currentPage + "|" + $i + "|" + $pageLength + "|" + $half);
            		$li.addClass('hide');
            	}
            }
            var $paginMoveLeft = $target.find('.pagin-move-left');
            var $paginMoveRight = $target.find('.pagin-move-right');
            if (settings.currentPage >= $half + 1) {
                $paginMoveLeft.removeClass('hide');
            } else {
                $paginMoveLeft.addClass('hide');
            }
            if (settings.currentPage <= ($pageLength - $half)) {
                $paginMoveRight.removeClass('hide');
            } else {
                $paginMoveRight.addClass('hide');
            }
            $paginMoveLeft.click(function(){
            	var $pages = $target.find('.pagin');//find all LI which is real page(some LIs are not for page)
            	var $index = parseInt($target.find('.pagin:not(".hide")').get(0).innerText);
            	if($index > settings.maxDisplayPage){
            		$index = $index - settings.maxDisplayPage;
            	} else{
            		$index = 1;
            	}
            	$pages.addClass('hide');
            	for(var $i = $index; $i < $index + 5; $i++){
            		var $li = $($pages[$i - 1]);//convert to zero-index
                	$li.removeClass('hide');
            	}
            });
            $paginMoveRight.click(function(){
            	var $pages = $target.find('.pagin');//find all LI which is real page(some LIs are not for page)
            	var $showPage = $target.find('.pagin:not(".hide")');
            	var $index = parseInt($showPage.get(0).innerText);
            	if($index + $showPage.length + settings.maxDisplayPage < $pages.length){
            		$index = $index + settings.maxDisplayPage + 1;
            	} else{
            		$index = $pages.length - settings.maxDisplayPage + 1;
            	}
            	$pages.addClass('hide');
            	for(var $i = $index; $i < $index + 5; $i++){
            		var $li = $($pages[$i - 1]);//convert to zero-index
                	$li.removeClass('hide');
            	}
            });
        }
    }

    // Bob's default settings:
    $.fn.pagin.defaults = {
        doBefore : function() {
        },
        doAfter : function() {
        },
        color : "#F00",
        fontSize : "1.2em",
        maxDisplayPage : 5,
        currentPage : 1
    }
}(jQuery));