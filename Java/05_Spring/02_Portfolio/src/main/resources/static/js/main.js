$(document).ready(function(){
	$('.flex .box').hover(function(e){
		$(this).removeClass("box");
		$(this).addClass("boxEnlarge");
	},function(e){
		$(this).removeClass("boxEnlarge");
		$(this).addClass("box");
	})
})