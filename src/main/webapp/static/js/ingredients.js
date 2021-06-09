$(document).ready(function(){
	
	$('#btn-save').on('click', function(){
		var url = 'ingredients';
		//Serialize data, to prepare it for sending to the server through AJAX
		var ingredientData = $('#form-ingredient').serialize();
		
		$.post(url, ingredientData)
			.done(function(){
				alert('Ingredient saved successfully!');
				
			})
			.fail(function(){
				alert('Failed to save Ingredient!');
				
			});
	
	});
});