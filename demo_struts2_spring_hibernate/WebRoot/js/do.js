$(document).ready(function(){
	$('.delete').bind('click',function(){
		return confirm("您确定要删除吗？");
	});
});