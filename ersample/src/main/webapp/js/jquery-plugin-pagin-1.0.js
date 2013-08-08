/**
 * @author Tai Sang
 */

(function($) {
    $.fn.pagin = function(options) {
        $.fn.pagin.settings = $.extend({}, $.fn.pagin.defaults, options);// load options and defaults, passing to $vars

        return this.each(function() {
            $.isFunction(options.doBefore) && options.doBefore.call(this);//doBefore function is execute first
            // Execute code start
            var $vars = $.extend({}, $.fn.pagin.settings, $.fn.pagin.getVars());
            $vars.target = $(this);
            $vars.first = $(this).find('.pagin-first');
            $vars.prev = $(this).find('.pagin-prev');
            $vars.left = $(this).find('.pagin-left');
            $vars.pages = $(this).find('.pagin');
            $vars.right = $(this).find('.pagin-right');
            $vars.next = $(this).find('.pagin-next');
            $vars.last = $(this).find('.pagin-last');
            $vars.pageLength = $vars.pages.length;
            $vars.half = $vars.maxPage / 2;

            $.fn.pagin.render($vars);
            // Execute code end
            $.isFunction(options.doAfter) && options.doAfter.call(this);//doAfter function is execute lastly
        });
    };

    $.fn.pagin.render = function($vars) {
        if ($vars.pageLength > $vars.maxPage) {//when total page is smaller than total
            /*
             * When page load
             */
            for(var $i = 1; $i <= $vars.pageLength; $i++){
                var $li = $($vars.pages[$i - 1]);//convert to zero-index
                $li.removeClass('hide');//clear all class hide on page LI
                if($vars.currentPage > $vars.half + 1//hide the left page number if they are out range
                        && $i < ($vars.currentPage - $vars.half)
                        && $i <= $vars.pageLength - $vars.maxPage){
                    $li.addClass('hide');
                }
                if($vars.currentPage < $vars.pageLength - $vars.half//hide the right page number if they are out range
                        && $i > $vars.currentPage + $vars.half
                        && $i > $vars.maxPage){
                    $li.addClass('hide');
                }
            }
            if ($vars.currentPage >= $vars.half + 1) {//when left is available
                $vars.left.removeClass('hide');
            } else {//dont need to show left due to no element on left hand side
                $vars.left.addClass('hide');
            }
            if ($vars.currentPage <= ($vars.pageLength - $vars.half)) {//when right is available
                $vars.right.removeClass('hide');
            } else {//dont need to show right due to no element on right hand side
                $vars.right.addClass('hide');
            }

            /*
             * When click left
             */
            $vars.left.click(function(){
                var $showPage = $vars.target.find('.pagin:not(".hide")');//find all shown page
                var $index = parseInt($showPage.get(0).innerText);//get first shown page index
                if($index > $vars.maxPage){//if can nav left
                    $index = $index - $vars.maxPage;
                } else{//can not move left due to NO pagins on the left
                    $index = 1;
                }
                $.fn.pagin.softNavigate($vars, $showPage, $index);//determine show or hide left, right
            });

            /*
             * When click right
             */
            $vars.right.click(function(){
                var $showPage = $vars.target.find('.pagin:not(".hide")');
                var $index = parseInt($showPage.get(0).innerText);
                if($index + $showPage.length + $vars.maxPage < $vars.pageLength){
                    $index = $index + $vars.maxPage + 1;
                } else{
                    $index = $vars.pageLength - $vars.maxPage + 1;
                }
                $.fn.pagin.softNavigate($vars, $showPage.length, $index);
            });
        }
    }

    $.fn.pagin.softNavigate = function($vars, $showPage, $index){
        $vars.pages.addClass('hide');//hide all page item
        for(var $i = $index; $i < $index + $vars.maxPage; $i++){
            var $li = $($vars.pages[$i - 1]);//convert to zero-index
            $li.removeClass('hide');//re-show page item
        }

        if($index <= 1){
            $vars.left.addClass('hide');
        } else{
            $vars.left.removeClass('hide');
        }

        if($index > $vars.pageLength - $showPage - 1){
            $vars.right.addClass('hide');
        } else{
            $vars.right.removeClass('hide');
        }
    }

    // default value, use when options are missing
    $.fn.pagin.defaults = {
        doBefore : function() {
        },
        doAfter : function() {
        },
        maxPage : 5,
        currentPage : 1
    }

    //this create an empty object hold all necessary variables
    $.fn.pagin.getVars = function(){
        return {
            target : null,
            first : null,
            prev : null,
            left : null,
            pages : null,
            pageLength : 0,
            right : null,
            next : null,
            last : null,
            half : 0
        }
    }

}(jQuery));