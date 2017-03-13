$(document).ready(function(){
	$(".age-caption").on('click', function(){
		if($("#ageInfo > .box").hasClass("age-transform-active")){
			if($("#ageInfo > div > #" + $(this).attr("id") + "-info > p").hasClass("age-active")){
				$("#ageInfo > div > #" + $(this).attr("id") + "-info > p").removeClass("age-active");
				$("#ageInfo > .box").removeClass("age-transform-active");
			} else {
				$("#ageInfo p").removeClass("age-active");
				$("#ageInfo > div > #" + $(this).attr("id") + "-info > p").addClass("age-active");
			}
		} else {
			$("#ageInfo > .box").addClass("age-transform-active");
			$("#ageInfo > div > #" + $(this).attr("id") + "-info > p").addClass("age-active");
		}
	});
	
	$(".gender-caption").on('click', function(){
		if($("#genderInfo > .box").hasClass("gender-transform-active")){
			if($("#genderInfo > div > #" + $(this).attr("id") + "-info > p").hasClass("gender-active")){
				$("#genderInfo > div > #" + $(this).attr("id") + "-info > p").removeClass("gender-active");
				$("#genderInfo > .box").removeClass("gender-transform-active");
			} else {
				$("#genderInfo p").removeClass("gender-active");
				$("#genderInfo > div > #" + $(this).attr("id") + "-info > p").addClass("gender-active");
			}
		} else {
			$("#genderInfo > .box").addClass("gender-transform-active");
			$("#genderInfo > div > #" + $(this).attr("id") + "-info > p").addClass("gender-active");
		}
	});
});