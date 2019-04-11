GET: $(document).ready(
		function() {

			$("#filter").keyup(function(event) {
				console.log("key donw");

			var a=$("#filter").val();
				if(a!=""){
				$.ajax({
					type : "GET",
					url : "/userHome/"+a,
					success : function(result) {
						if (result.status == "success") {
							$('#tbhead').empty();
							$('#tbhead').append("	<tr><th scope='col'>UserName</th><th scope='col'>Email</th><th scope='col'>Country</th><th scope='col'>City</th><th scope='col'>Phone Number</th><th scope='col'></th></tr>");
							$('#utilisateurtable').empty();
							$('#utilisateurs').empty();
							$.each(result.data,
									function(i, users) {
								
										var tableInit= "<tr><th scope='row'>"+users.username+"</th><td>"
												
												+ users.email+"</td><td>"
												+ users.country+"</td><td>"
												+ users.city+"</td><td>"
												+ users.numtel+"</td><td>"
												+ "<a class='btn btn-success btn-circle'  href='/user/ViewAVA?id="+users.id+"' >View</a><a  href='/user/FormulaireRes' class='btn btn-primary'>Next</a></td>"
                   										 
                 										 
												+ "</tr>";
											var	datalistInit="<option value='"+users.email+"' name='"+users.Id+"'>"+users.country+" "+users.city+"</option>";


										$('#utilisateurtable').append(
												tableInit)
										$('#utilisateurs').append(
												datalistInit)
									});
							console.log("Success: ", result);
						} else {
							$("#error").html("<strong>Error</strong>");
							console.log("Fail: ", result);
						}
					},
					error : function(e) {
						$("#getResultDiv").html("<strong>Error</strong>");
						console.log("ERROR: ", e);
					}
				})}else{$('#tbhead').empty();
				$('#utilisateurtable').empty();
				$('#utilisateurs').empty();
				};
			});
		});


