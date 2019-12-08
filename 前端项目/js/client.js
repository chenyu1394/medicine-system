
			$(function(){
				
			$("#page_add").show();
			$("#page_get").hide();
			$("#page_set").hide();
			$("#page_remove").hide();
			$("#li_add").addClass("active");
			$("#li_get").removeClass("active");
			$("#li_set").removeClass("active");
			$("#li_remove").removeClass("active");
			//添加顾客按钮事件监听
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
			//查看顾客按钮事件监听
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
			//修改顾客按钮事件监听
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
			//删除顾客按钮事件监听
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
				//添加顾客界面
				$("#doAdd").click(function(){
					$.ajax("http://localhost:8080/addClient"+"?token="+localStorage.getItem("app_token"),{
									type:"POST",
									data:{cno:$("#te_cno").val(),cname:$("#te_cname").val(),csex:$("#te_csex").val(),cage:$("#te_cage").val(),
									caddress:$("#te_caddress").val(),cphone:$("#te_cphone").val(),csymptom:$("#te_csymptom").val(),ano:$("#te_ano").val(),cremark:$("#te_cremark").val()},
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
				//查看顾客界面
				$("#th_cname").hide();
				$("#th_ano").hide();
				//查看第一页顾客信息
				$.ajax("http://localhost:8080/getClientByPage/1"+"?token="+localStorage.getItem("app_token"),{
								type:"GET",
								success:function(result){
						if(result.code == 200){
							
							$.each(result.clients,function(index,value){
								$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.cno+"</td>"
								+"<td>"+value.cname+"</td>"+
								"<td>"+value.csex+"</td>"+
								"<td>"+value.cage+"</td>"+
								"<td>"+value.caddress+"</td>"+
								"<td>"+value.cphone+"</td>"+
								"<td>"+value.csymptom+"</td>"+
								"<td>"+value.ano+"</td>"+
								"<td>"+value.cremark+"</td>"+
								"<td>"+value.cdate+"</td>"+"</tr>");
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
					$.ajax("http://localhost:8080/getClientByPage/1"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.clients,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.cno+"</td>"
									+"<td>"+value.cname+"</td>"+
									"<td>"+value.csex+"</td>"+
									"<td>"+value.cage+"</td>"+
									"<td>"+value.caddress+"</td>"+
									"<td>"+value.cphone+"</td>"+
									"<td>"+value.csymptom+"</td>"+
									"<td>"+value.ano+"</td>"+
									"<td>"+value.cremark+"</td>"+
									"<td>"+value.cdate+"</td>"+"</tr>");
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
					$.ajax("http://localhost:8080/getClientByPage/2"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.clients,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.cno+"</td>"
									+"<td>"+value.cname+"</td>"+
									"<td>"+value.csex+"</td>"+
									"<td>"+value.cage+"</td>"+
									"<td>"+value.caddress+"</td>"+
									"<td>"+value.cphone+"</td>"+
									"<td>"+value.csymptom+"</td>"+
									"<td>"+value.ano+"</td>"+
									"<td>"+value.cremark+"</td>"+
									"<td>"+value.cdate+"</td>"+"</tr>");
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
					$.ajax("http://localhost:8080/getClientByPage/3"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.clients,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.cno+"</td>"
									+"<td>"+value.cname+"</td>"+
									"<td>"+value.csex+"</td>"+
									"<td>"+value.cage+"</td>"+
									"<td>"+value.caddress+"</td>"+
									"<td>"+value.cphone+"</td>"+
									"<td>"+value.csymptom+"</td>"+
									"<td>"+value.ano+"</td>"+
									"<td>"+value.cremark+"</td>"+
									"<td>"+value.cdate+"</td>"+"</tr>");
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
					$.ajax("http://localhost:8080/getClientByPage/4"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.clients,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.cno+"</td>"
									+"<td>"+value.cname+"</td>"+
									"<td>"+value.csex+"</td>"+
									"<td>"+value.cage+"</td>"+
									"<td>"+value.caddress+"</td>"+
									"<td>"+value.cphone+"</td>"+
									"<td>"+value.csymptom+"</td>"+
									"<td>"+value.ano+"</td>"+
									"<td>"+value.cremark+"</td>"+
									"<td>"+value.cdate+"</td>"+"</tr>");
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
					$.ajax("http://localhost:8080/getClientByPage/5"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.clients,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.cno+"</td>"
									+"<td>"+value.cname+"</td>"+
									"<td>"+value.csex+"</td>"+
									"<td>"+value.cage+"</td>"+
									"<td>"+value.caddress+"</td>"+
									"<td>"+value.cphone+"</td>"+
									"<td>"+value.csymptom+"</td>"+
									"<td>"+value.ano+"</td>"+
									"<td>"+value.cremark+"</td>"+
									"<td>"+value.cdate+"</td>"+"</tr>");
								});
							}else if(result.code == 400){
								alert(result.msg);
							}else{
								 window.parent.location.href = "login.html";
							}
						}
					});
				});
				//根据顾客名查看
				$("#doGetByCname").click(function(){
					let url = "http://localhost:8080/getClientByCname/"+$("#username_cname").val()+"?token="+localStorage.getItem("app_token");
					$.ajax(url,{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$("#th_cname").show();
								$(".tr_page_cname").remove();
								$.each(result.clients,function(index,value){
									$("#tb_cname").append("<tr class='tr_page_cname'>"+"<td>"+value.cno+"</td>"
									+"<td>"+value.cname+"</td>"+
									"<td>"+value.csex+"</td>"+
									"<td>"+value.cage+"</td>"+
									"<td>"+value.caddress+"</td>"+
									"<td>"+value.cphone+"</td>"+
									"<td>"+value.csymptom+"</td>"+
									"<td>"+value.ano+"</td>"+
									"<td>"+value.cremark+"</td>"+
									"<td>"+value.cdate+"</td>"+"</tr>");
								});
							}else if(result.code == 400){
								alert(result.msg);
							}else{
								 window.parent.location.href = "login.html";
							}
						}
					});
				});
				//根据经办人编号查看
				
				$("#doGetByAno").click(function(){
					let url = "http://localhost:8080/getClientByAno/"+$("#username_ano").val()+"?token="+localStorage.getItem("app_token");
					$.ajax(url,{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$("#th_ano").show();
								$(".tr_page_ano").remove();
								$.each(result.clients,function(index,value){
									$("#tb_ano").append("<tr class='tr_page_ano'>"+"<td>"+value.cno+"</td>"
									+"<td>"+value.cname+"</td>"+
									"<td>"+value.csex+"</td>"+
									"<td>"+value.cage+"</td>"+
									"<td>"+value.caddress+"</td>"+
									"<td>"+value.cphone+"</td>"+
									"<td>"+value.csymptom+"</td>"+
									"<td>"+value.ano+"</td>"+
									"<td>"+value.cremark+"</td>"+
									"<td>"+value.cdate+"</td>"+"</tr>");
								});
							}else if(result.code == 400){
								alert(result.msg);
							}else{
								 window.parent.location.href = "login.html";
							}
						}
					});
				});
				
				//修改顾客页面
				$("#doSet").click(function(){
					$.ajax("http://localhost:8080/setClient"+"?token="+localStorage.getItem("app_token"),{
									type:"POST",
									data:{cno:$("#te_cno_set").val(),cname:$("#te_cname_set").val(),csex:$("#te_csex_set").val(),cage:$("#te_cage_set").val(),
									caddress:$("#te_caddress_set").val(),cphone:$("#te_cphone_set").val(),csymptom:$("#te_csymptom_set").val(),ano:$("#te_ano_set").val(),cremark:$("#te_cremark_set").val()},
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
				
				//删除顾客信息
				$("#doRemove").click(function(){
					$.ajax("http://localhost:8080/removeClientByCno/"+$("#te_cremark_remove").val()+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
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
				
				
			});