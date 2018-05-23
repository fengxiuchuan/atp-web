//调用页面加载的loading动画
var pageload={
	loading:function(){
		var html='<div class="page_load">';
		    html+='<div class="load_con">';
		    html+='<div class="page_img loading_anmation"></div>';
		    html+='<div class="page_txt txt-loading">努力加载中...</div>';
		    html+='</div>';
		    html+='</div>';
		if (!$(".page_load")[0]) {
			$('body').append(html);
		}

	},	
	loading_close:function(){
		$("body .page_load").remove();
	}
};
layer.load(1);
//pageload.loading(); //加载loading
/*pageload.loading_close();*/ //加载完后去掉loading

function closeShadeDiv(){
	if($("body .page_load").length>0){
		pageload.loading_close();
	}else{
		layer.closeAll();
	}
}