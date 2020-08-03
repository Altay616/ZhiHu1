$(function() { 
		var innerUlList;
		var topicid
		var flag = true;
		$(".chose_topic").click(function() {
			$(".chose_topic").css("display", "none");
			$(".search").css("display", "block");
			$("#inputsearch").focus();
		}); 
  		$("#inputsearch").blur(function() {
 			$(".chose_topic").css("display", "block");
			$(".search").css("display", "none");
			$("#inputsearch").val(""); 
			$(".innerUl").css({ opacity:0 })
		 	$(".innerUl").hide(1000); 
		});   
		$(".div3").keydown(function() {
			if (flag == true) 
				$(".div3").text("");
			flag = false;
		});
		$(".div3").focus(function() {

			$(".div3").animate({
				borderColor : 'black'
			}, 500);
		});
		$(".div3").blur(
				function() {
					if ($('.div3').text() == "输入问题背景条件等详细信息"
							|| $('.div3').text() == '') {
						$(".div3").text("输入问题背景条件等详细信息");
						flag = true;
					}
					$(".div3").animate({
						borderColor : '#f0f0f0'
					}, 500);
				});

		/* 阿贾克斯 */
		$("#inputsearch").bind("input propertychange", function() {  
		 $(".innerUl").css("display", "").css("overflow","visible"); 
		 if($("#inputsearch").val()!=""){
			$.ajax({
				url : "askQuestionController/topic_search",
				dataType : "json",// 这他妈返回json数据结果返回的数据我真是日了狗了，怎么和以前不一样啊
				async : true,
				data : {
					"topicname" : $(inputsearch).val()
				},
				type : "get",
				beforeSend : function(data) {
				},
				complete : function(result) {
					// 请求完成处理
             	  	var data = eval(result.responseJSON.mylist); 
             	  	$(".innerUl").empty();
					if(data.length!=0){
						topicid = data[0].id;
						for(var i=0;i<data.length;i++){
							$(".innerUl").append('<li class=first>'+data[i].typename+'</li>')
						} 
					}  
					if($(".innerUl").children("li").length!=0){
						$(".innerUl").css("display", "block").css("overflow","scroll").css({ opacity:1}); 
						var x = $("#inputsearch").offset().top;
						var y = $("#inputsearch").offset().left;
						if (x != $(".innerUl").offset.top) {
							$(".innerUl").offset({
								top : x + 40,
								left : y + 10
							});
						}
						
						
						
						$(".innerUl").css("cursor","pointer"); 
						innerUlList = $(".innerUl").children("li");  
			 			for(var i =0;i<innerUlList.length;i++){
							let j = i;
							innerUlList[i].onclick = function(){ 
//								$(".publish_Question").css("background","#0084ff");
//								$(".publish_Question").prop("disabled", false);
								$("<li><span>"+innerUlList[j].innerText+"</span><img class='deleteImg'  src='images/delete_YuZengCai.png' align='top'></li>").insertBefore($(".targetLi"));  
								var target = $(".ul1 li");
					 			for(var i=0;i<target.length;i++){
					 				let j = i;
					 				var targetImg = target[i].getElementsByTagName("img")[0];
					 				targetImg.onclick = function(){
					 					$(this).parent().remove();
					 				}
							}
						}  
			 			}  
					} 
				},
				error : function(data) {
					// 请求出错处理
					alert("出错了");
				}
			}); 
		}
		});  
		// 按钮记录发布信息
		$(".publish_Question").click(function(){
// alert(topicid);
// alert($(".currId").text());
			
			if( $(".ul1 li").length!=1&&$("#textarea1").val()!=""&& $(".div3").text()!="输入问题背景条件等详细信息"){
				$.ajax({
					url : "askQuestionController/publishQuestion",
					dataType : "json",
					async : true,
					data : {
						"id": "0",
						"title": $("#textarea1").val(),
						"describe": $(".div3").text(),
						"typeid": topicid,
						"userid": $(".currId").text() 
					 },
					 success : function(data){  
						 
					 }
				});
			 alert("提问成功");
			 $(".div3").text("输入问题背景条件等详细信息");
			 $("#textarea1").val("");
			}else{
				if( $(".ul1 li").length==1){
					alert(($("#textarea1").val()).charAt(($("#textarea1").val().length-1)));
					alert("请选择话题");
				}else if($("#textarea1").val()==""){
					alert('请输入标题');
				}else if( $(".div3").text()=="输入问题背景条件等详细信息"){
					alert("请输入背景条件");
				}
			}

		}); 
/*     $(".div1").click(function(){
    	  
         if($("#textarea1").val()!="" && $(".div3").text()!="输入问题背景条件等详细信息" && $(".ul1 li").length!=1){
        	 $(".publish_Question").css("background","#0084ff");
			 $(".publish_Question").prop("disabled", false);
         }
     });*/
	});