$(function(){
				$("#page_add").show();
				$("#page_get").hide();
				$("#page_set").hide();
				$("#page_remove").hide();
				$("#li_add").addClass("active");
				$("#li_get").removeClass("active");
				$("#li_set").removeClass("active");
				$("#li_remove").removeClass("active");
				//添加经办人按钮事件监听
				$("#a_add").click(function(){
					$("#page_add").show();
					$("#page_get").hide();
					$("#page_set").hide();
					$("#page_remove").hide();
					$("#li_add").addClass("active");
					$("#li_get").removeClass("active");
					$("#li_set").removeClass("active");
					$("#li_remove").removeClass("active");
				});
				//查看经办人按钮事件监听
				$("#a_get").click(function(){
					$("#page_add").hide();
					$("#page_get").show();
					$("#page_set").hide();
					$("#page_remove").hide();
					$("#li_add").removeClass("active");
					$("#li_get").addClass("active");
					$("#li_set").removeClass("active");
					$("#li_remove").removeClass("active");
				});
				//修改经办人按钮事件监听
				$("#a_set").click(function(){
					$("#page_add").hide();
					$("#page_get").hide();
					$("#page_set").show();
					$("#page_remove").hide();
					$("#li_add").removeClass("active");
					$("#li_get").removeClass("active");
					$("#li_set").addClass("active");
					$("#li_remove").removeClass("active");
				});
				//删除经办人按钮事件监听
				$("#a_remove").click(function(){
					$("#page_add").hide();
					$("#page_get").hide();
					$("#page_set").hide();
					$("#page_remove").show();
					$("#li_add").removeClass("active");
					$("#li_get").removeClass("active");
					$("#li_set").removeClass("active");
					$("#li_remove").addClass("active");
				});
				
				//添加经办人界面
				$("#doAdd").click(function(){
					$.ajax("http://localhost:8080/addAgency"+"?token="+localStorage.getItem("app_token"),{
									type:"POST",
									data:{ano:$("#te_ano").val(),aname:$("#te_aname").val(),asex:$("#te_asex").val(),
									aphone:$("#te_aphone").val(),aremark:$("#te_aremark").val()},
									success:function(result){
							if(result.code == 200){
								alert(result.msg)
							}else if(result.code == 400){
								alert(result.msg);
							}
							else{
								 window.parent.location.href = "login.html";
							}
						}
					});
				});
				
				//查看第一页经办人信息
				$.ajax("http://localhost:8080/getAgencyByPage/1"+"?token="+localStorage.getItem("app_token"),{
								type:"GET",
								success:function(result){
						if(result.code == 200){
							
							$.each(result.agencies,function(index,value){
								$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.ano+"</td>"
								+"<td>"+value.aname+"</td>"+
								"<td>"+value.asex+"</td>"+
								"<td>"+value.aphone+"</td>"+
								"<td>"+value.aremark+"</td>"+
								"<td>"+value.created+"</td>"+"</tr>");
							});
						}else if(result.code == 400){
							alert(result.msg);
						}else{
							 window.parent.location.href = "login.html";
						}
					}
				});
				//分页查询
				//第一页
				$("#page_1").click(function(){
					$.ajax("http://localhost:8080/getAgencyByPage/1"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.agencies,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.ano+"</td>"
									+"<td>"+value.aname+"</td>"+
									"<td>"+value.asex+"</td>"+
									"<td>"+value.aphone+"</td>"+
									"<td>"+value.aremark+"</td>"+
									"<td>"+value.created+"</td>"+"</tr>");
								});
							}else if(result.code == 400){
								alert(result.msg);
							}else{
								 window.parent.location.href = "login.html";
							}
						}
					});
				});
				//第二页
				$("#page_2").click(function(){
					$.ajax("http://localhost:8080/getAgencyByPage/2"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.agencies,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.ano+"</td>"
									+"<td>"+value.aname+"</td>"+
									"<td>"+value.asex+"</td>"+
									"<td>"+value.aphone+"</td>"+
									"<td>"+value.aremark+"</td>"+
									"<td>"+value.created+"</td>"+"</tr>");
								});
							}else if(result.code == 400){
								alert(result.msg);
							}else{
								 window.parent.location.href = "login.html";
							}
						}
					});
				});
				//第三页
				$("#page_3").click(function(){
					$.ajax("http://localhost:8080/getAgencyByPage/3"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.agencies,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.ano+"</td>"
									+"<td>"+value.aname+"</td>"+
									"<td>"+value.asex+"</td>"+
									"<td>"+value.aphone+"</td>"+
									"<td>"+value.aremark+"</td>"+
									"<td>"+value.created+"</td>"+"</tr>");
								});
							}else if(result.code == 400){
								alert(result.msg);
							}else{
								 window.parent.location.href = "login.html";
							}
						}
					});
				});
				//第四页
				$("#page_4").click(function(){
					$.ajax("http://localhost:8080/getAgencyByPage/4"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.agencies,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.ano+"</td>"
									+"<td>"+value.aname+"</td>"+
									"<td>"+value.asex+"</td>"+
									"<td>"+value.aphone+"</td>"+
									"<td>"+value.aremark+"</td>"+
									"<td>"+value.created+"</td>"+"</tr>");
								});
							}else if(result.code == 400){
								alert(result.msg);
							}else{
								 window.parent.location.href = "login.html";
							}
						}
					});
				});
				//第五页
				$("#page_5").click(function(){
					$.ajax("http://localhost:8080/getAgencyByPage/5"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.agencies,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.ano+"</td>"
									+"<td>"+value.aname+"</td>"+
									"<td>"+value.asex+"</td>"+
									"<td>"+value.aphone+"</td>"+
									"<td>"+value.aremark+"</td>"+
									"<td>"+value.created+"</td>"+"</tr>");
								});
							}else if(result.code == 400){
								alert(result.msg);
							}else{
								 window.parent.location.href = "login.html";
							}
						}
					});
				});
				//根据经办人姓名查询
				$("#th_aname").hide();
				$("#doGetByAname").click(function(){
					let url = "http://localhost:8080/getAgencyByAname/"+$("#username_aname").val()+"?token="+localStorage.getItem("app_token");
					$.ajax(url,{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$("#th_aname").show();
								$(".tr_page_aname").remove();
								$.each(result.agencies,function(index,value){
									$("#tb_aname").append("<tr class='tr_page_aname'>"+"<td>"+value.ano+"</td>"
									+"<td>"+value.aname+"</td>"+
									"<td>"+value.asex+"</td>"+
									"<td>"+value.aphone+"</td>"+
									"<td>"+value.aremark+"</td>"+
									"<td>"+value.created+"</td>"+"</tr>");
								});
							}else if(result.code == 400){
								alert(result.msg);
							}else{
								 window.parent.location.href = "login.html";
							}
						}
					});
				});
				
				//修改经办人页面
				$("#doSet").click(function(){
					$.ajax("http://localhost:8080/setAgency"+"?token="+localStorage.getItem("app_token"),{
									type:"POST",
									data:{ano:$("#te_ano_set").val(),aname:$("#te_aname_set").val(),asex:$("#te_asex_set").val(),
									aphone:$("#te_aphone_set").val(),aremark:$("#te_aremark_set").val()},
									success:function(result){
							if(result.code == 200){
								alert(result.msg);
							}else if(result.code == 400){
								alert(result.msg);
							}
							else{
								 window.parent.location.href = "login.html";
							}
						}
					});
				});
				//删除经办人信息
				$("#doRemove").click(function(){
					$.ajax("http://localhost:8080/removeAgencyByAno/"+$("#te_agency_remove").val()+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								alert(result.msg);
							}else if(result.code == 400){
								alert(result.msg);
							}
							else{
								 window.parent.location.href = "login.html";
							}
						}
					});
				});
				
				
			});