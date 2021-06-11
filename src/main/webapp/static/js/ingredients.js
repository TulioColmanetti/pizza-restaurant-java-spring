$(document).ready(function() {
	applyListeners();

});

var applyListeners = function() {
	$('.btn-delete').on('click', function() {
		var id = $(this).parents('tr').data('id');
		
		$.ajax({
			url: "ingredients/"+id,
			type: 'DELETE',
			success: function(result) {
				$('tr[data-id="'+id+'"]').remove();
			}
		});
	});

	$('#btn-save').on('click', function() {
		var url = 'ingredients';
		//Serialize data, to prepare it for sending to the server through AJAX
		var ingredientData = $('#form-ingredient').serialize();

		$.post(url, ingredientData)
			.done(function(page) {
				$('#section-ingredients').html(page);
				//alert('Ingredient saved successfully!');
				applyListeners();

			})
			.fail(function() {
				alert('Failed to save Ingredient!');

			})
			.always(function() {
				$('#modal-ingredient').modal('hide');

			});

	});
}