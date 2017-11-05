$(function() {
	
	function loadUsers(query) {
		$.get('search?query='+query).then(function(data) {
			var result='';
			for(var index=0;index<data.length;index++) {
				var user=data[index];
				
				result+="<tr>";
				result+="<td>" + user.firstName; +"</td>";
				result+="<td>" + user.email; +"</td>";
				result+="<td>" + user.userId; +"</td>";
				result+="</tr>"
			}
			$('table > tbody').html(result);
	});
	}
	
	$('#search').on('click', function() {
		$('#user').css('background-color', 'blue');
	});
	
	$('input').on('keyup',function() {
		var text=this.value; 
//		loadUsers(text);
		
		$.get('search?query='+query).then(function(data) {
			var result='';
			for(var index=0;index<data.length;index++) {
				var user=data[index];
				result+="<option>" + user.firstName; +"</option>";
			}
			$('#users_list').html(result);
	});
	});
	loadUsers('');
});