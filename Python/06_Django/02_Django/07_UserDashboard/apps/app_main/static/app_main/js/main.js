$(document).ready(function(e){
	var desc = $("textarea").attr('value');
	$('textarea').val(desc);//Dont ask why this was necessary, it just wouldnt update.

	$('.remove_user').click(function(e){
		var id = $(this).attr('user_id');
		var c = confirm("Are you sure you want to delete user: "+id+"?")

		if(c){
			$.get('/users/delete/'+id,function(){//You cant get here unless youre an admin, so itll do.
				location.reload()// Force reload, so we see the changes, cause idk how to do it differently.
			})
		}
	})
})