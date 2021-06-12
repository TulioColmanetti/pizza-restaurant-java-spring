$(document).ready(function() {
	applyListeners();

});

var cleanModal = function() {
	$('#id').val('');
	$('#name').val('');
	$('#category').val('');
};

var applyListeners = function() {
	$('#modal-ingredient').on('hide.bs.modal', cleanModal);
	
	$('.btn-edit').on('click', function() {
		var id = $(this).parents('tr').data('id');
		var url = 'ingredients/' + id;

		$.get(url)
			.success(function(ingredient) {
				$('#id').val(ingredient.id);
				$('#name').val(ingredient.name);
				$('#category').val(ingredient.category);

				$('#modal-ingredient').modal('show');
			});
	});

	$('.btn-delete').on('click', function() {
		var id = $(this).parents('tr').data('id');
		var ingredients = $('#quantity-ingredients').text();

		$.ajax({
			url: "ingredients/" + id,
			type: 'DELETE',
			success: function(result) {
				$('tr[data-id="' + id + '"]').remove();
				$('#quantity-ingredients').text(ingredients - 1);
			}
		});
	});

	$('#btn-save').off('click');

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