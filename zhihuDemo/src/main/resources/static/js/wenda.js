$(function() { 
	$(".follow").click(function() {
		if ($(".follow").text() != "关注问题") {
			$(".follow").text("关注问题");
			$(".follow").css("background", "#0084ff");
		} else {
			$(".follow").text("已关注");
			$(".follow").css("background", "#8590a6");
		}

	});
	$(".follow").mouseover(function() {
		if ($(".follow").text() != "关注问题") {
			$(".follow").text("取消关注");
		}
	});

	$(".follow").mouseout(function() {
		if ($(".follow").text() != "关注问题") {
			$(".follow").text("已关注");
		}
	});
	$(".write").click(function() {
		$(".answerParent").fadeIn(100);

	});
	$(".cancel").click(function() {
		$(".answerParent").fadeOut(100);
	});

	var goodflag = false;
	$(".topic .good").click(
			function() {
				if (goodflag == false) {
					$(".topic .good").text(
							"好问题 "
									+ (parseInt($(".topic .good").text()
											.substring(4)) + 1));
					$(".topic .good").css("color", "#0084ff");
					goodflag = true;
				} else if (goodflag == true) {
					$(".topic .good").text(
							"好问题 "
									+ (parseInt($(".topic .good").text()
											.substring(4)) - 1));
					$(".topic .good").css("color", "#8590a6");
					goodflag = false;
				}
			}); 
	for (var i = 1; i <= $(".reply img").length; i++) {
		var obj1 = $("#goodbutton" + i);
		var obj2 = $("#notgoodbutton" + i)
		buttonclick(obj1, obj2);
	}
	$(".ensure")
			.click(
					function() {
						$(".reply")
								.append(
										" <li> <div class='imgIDV' style='height:80px;width:100%;line-height: 50px;padding-left:20px'> <img src='images/head.jpg' align='top'>  <span style='padding-left:5px;'>匿名用户</span><br><span style='color:#bd9abf' class='time"+($(".reply img").length + 1)+"'>2017-7-31</span></div>"
												+ "<div style='width:95%;padding-left: 20px;padding-top:15px;padding-right: 15px;'>"
												+ $("textarea").val()
												+ "</div> <div style='width:100%;height:80px;background-color: white;'>"
												+ " <ul class='optionof_you'>  <li class='good'><button id='goodbutton"
												+ ($(".reply img").length + 1)
												+ "'>赞同 0</button></li><li class='notgood'><button id='notgoodbutton"
												+ ($(".reply img").length + 1)
												+ "'>不赞同</button></li>"
												+ "<li class='comment'><button id='commentbutton"
												+ ($(".reply img").length + 1)
												+ "'>评论</button></li>"
												+ "<li class='share'><button id='sharebutton"
												+ ($(".reply img").length + 1)
												+ "'>分享</button></li>"
												+ "<li class='collect'><button id='collectbutton"
												+ ($(".reply img").length + 1)
												+ "'>收藏</button></li>"
												+ "<li class='like'><button id='likebutton"
												+ ($(".reply img").length + 1)
												+ "'>喜欢</button></li> </ul> </div></li>");
						$(".firstAnswerDiv").css("display","none");
						$(".answerParent").fadeOut(100);
						
						var num = $(".reply img").length;
						$(".time"+num).text(new Date().toLocaleDateString().split("/").join("-"));
						var obj1 = $("#goodbutton" + num);
						var obj2 = $("#notgoodbutton" + num)
						buttonclick(obj1, obj2);

						$.ajax( {
							url: "wenda/commment",
							dataType:"json",
							data:{
								"id":"0",
								"essayid":$(".essayid").text(),
								"context":$("textarea").val(),
								"userid" :"1"
							},
							success:function(result){
								alert(1);
							}
						});
						
						$(".topic .comment").text( "评论 "+ (parseInt($(".topic .comment").text().substring(3)) + 1)); 
					});
	
	$(".firstAnswer").click(function(){
		$(".write").click();
	});
});

var buttonclick = function(obj1, obj2) {
	
	var goodsflag = false;
	obj1.click(function() {
		if (goodsflag == false) {
			obj1.css("background", "#0084ff").css("color", "white");
			obj1.text("赞同 " + (parseInt(obj1.text().substring(3)) + 1));
			goodsflag = true;
			if (notgoodflag == true) {
				obj2.css("background", "#e5f2ff").css("color", "#0084ff");
				obj2.text("不赞同");
				notgoodflag = false;
			}
		} else if (goodsflag == true) {
			obj1.css("background", "#e5f2ff").css("color", "#0084ff");
			obj1.text("赞同 " + (parseInt(obj1.text().substring(3)) - 1));
			goodsflag = false;
		}
	});

	var notgoodflag = false;
	obj2.click(function() {
		if (notgoodflag == false) {
			obj2.css("background", "#0084ff").css("color", "white");
			obj2.text("不赞同");
			if (goodsflag == true) {
				obj1.css("background", "#e5f2ff").css("color", "#0084ff");
				obj1.text("赞同 " + (parseInt(obj1.text().substring(3)) - 1));
				goodsflag = false;
			}
			notgoodflag = true;
		} else if (notgoodflag == true) {
			obj2.css("background", "#e5f2ff").css("color", "#0084ff");
			obj2.text("不赞同");
			notgoodflag = false;
		}
	});

}
