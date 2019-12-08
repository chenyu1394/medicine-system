	$(function(){
				$("#page_add").show();
				$("#page_get").hide();
				$("#page_set").hide();
				$("#page_remove").hide();
				$("#li_add").addClass("active");
				$("#li_get").removeClass("active");
				$("#li_set").removeClass("active");
				$("#li_remove").removeClass("active");
				//添加药品按钮事件监听
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
				//查看药品按钮事件监听
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
				//修改药品按钮事件监听
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
				//删除药品按钮事件监听
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
				
				//添加药品
				$("#doAdd").click(function(){
					$.ajax("http://localhost:8080/addMedicine"+"?token="+localStorage.getItem("app_token"),{
									type:"POST",
									data:{mno:$("#te_mno").val(),mname:$("#te_mname").val(),mmode:$("#te_mmode").val(),
									mefficacy:$("#te_mefficacy").val(),cno:$("#te_cno").val()},
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
				
				//查看药品界面
				//隐藏表头
				$("#th_mname").hide();
				$("#th_cno").hide();
				//查看第一页药品信息
				$.ajax("http://localhost:8080/getMedicineByPage/1"+"?token="+localStorage.getItem("app_token"),{
								type:"GET",
								success:function(result){
						if(result.code == 200){
							
							$.each(result.medicines,function(index,value){
								$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.mno+"</td>"
								+"<td>"+value.mname+"</td>"+
								"<td>"+value.mmode+"</td>"+
								"<td>"+value.mefficacy+"</td>"+
								"<td>"+value.cno+"</td>"+
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
					$.ajax("http://localhost:8080/getMedicineByPage/1"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.medicines,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.mno+"</td>"
									+"<td>"+value.mname+"</td>"+
									"<td>"+value.mmode+"</td>"+
									"<td>"+value.mefficacy+"</td>"+
									"<td>"+value.cno+"</td>"+
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
					$.ajax("http://localhost:8080/getMedicineByPage/2"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.medicines,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.mno+"</td>"
									+"<td>"+value.mname+"</td>"+
									"<td>"+value.mmode+"</td>"+
									"<td>"+value.mefficacy+"</td>"+
									"<td>"+value.cno+"</td>"+
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
					$.ajax("http://localhost:8080/getMedicineByPage/3"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.medicines,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.mno+"</td>"
									+"<td>"+value.mname+"</td>"+
									"<td>"+value.mmode+"</td>"+
									"<td>"+value.mefficacy+"</td>"+
									"<td>"+value.cno+"</td>"+
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
					$.ajax("http://localhost:8080/getMedicineByPage/4"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.medicines,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.mno+"</td>"
									+"<td>"+value.mname+"</td>"+
									"<td>"+value.mmode+"</td>"+
									"<td>"+value.mefficacy+"</td>"+
									"<td>"+value.cno+"</td>"+
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
					$.ajax("http://localhost:8080/getMedicineByPage/5"+"?token="+localStorage.getItem("app_token"),{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$(".tr_page").remove();
								$.each(result.medicines,function(index,value){
									$("#tb_all").append("<tr class='tr_page'>"+"<td>"+value.mno+"</td>"
									+"<td>"+value.mname+"</td>"+
									"<td>"+value.mmode+"</td>"+
									"<td>"+value.mefficacy+"</td>"+
									"<td>"+value.cno+"</td>"+
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
				
				//根据药品名称查看
				$("#doGetByMname").click(function(){
					let url = "http://localhost:8080/getMedicineByMname/"+$("#username_mname").val()+"?token="+localStorage.getItem("app_token");
					$.ajax(url,{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$("#th_cname").show();
								$("tr_page_mname").remove();
								$.each(result.medicines,function(index,value){
									$("#tb_mname").append("<tr class='tr_page_mname'>"+"<td>"+value.mno+"</td>"
									+"<td>"+value.mname+"</td>"+
									"<td>"+value.mmode+"</td>"+
									"<td>"+value.mefficacy+"</td>"+
									"<td>"+value.cno+"</td>"+
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
				
				//根据顾客编号编号查看已购买药品
				$("#doGetByCno").click(function(){
					let url = "http://localhost:8080/getMedicineByCno/"+$("#username_cno").val()+"?token="+localStorage.getItem("app_token");
					$.ajax(url,{
									type:"GET",
									success:function(result){
							if(result.code == 200){
								$("#th_cno").show();
								$("tr_page_ano").remove();
								$.each(result.medicines,function(index,value){
									$("#tb_cno").append("<tr class='tr_page_ano'>"+"<td>"+value.mno+"</td>"
									+"<td>"+value.mname+"</td>"+
									"<td>"+value.mmode+"</td>"+
									"<td>"+value.mefficacy+"</td>"+
									"<td>"+value.cno+"</td>"+
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
				
				//修改药品信息
				$("#doSet").click(function(){
					$.ajax("http://localhost:8080/setMedicine"+"?token="+localStorage.getItem("app_token"),{
									type:"POST",
									data:{mno:$("#te_mno_set").val(),mname:$("#te_mname_set").val(),mmode:$("#te_mmode_set").val(),
									mefficacy:$("#te_mefficacy_set").val(),cno:$("#te_cno_set").val()},
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
				
				//删除药品信息
				$("#doRemove").click(function(){
					$.ajax("http://localhost:8080/removeMedicineByMno/"+$("#te_medicine_remove").val()+"?token="+localStorage.getItem("app_token"),{
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