//登陆
		$(function(){
				$("#doLogin").click(function(){
						$.ajax("http://localhost:8080/checkLogin",{
							type:"POST",
							data:{username:$("#user_name").val(),password:$("#password").val()},
							success:function(result){
					if(result.code == 200){
						localStorage.setItem("app_token",result.token);
						window.location.href = "index.html";
					}else{
						alert(result.msg);
					}
				}
			});
				});
		});