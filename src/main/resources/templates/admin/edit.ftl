<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<title>OMEGA | WordPress Theme Framework</title>
<meta name="viewport" content="width=device-width" />
<link rel="stylesheet" href="/css/admin_style.css" type="text/css" media="all" />
</head>
<body>
<div class="site-container">

<header id="header" class="site-header" role="banner" >
	<div class="wrap">
		<div class="title-area">
			<h1 class="site-title" ><a href="/" title="OMEGA" rel="home"></a></h1>
			<h3 class="site-description"><span></span></h3>
		</div>
	</div>
</header>
	
<div class="site-inner">
	<div class="wrap">
	<main class="content" id="content" role="main" >
		<div>文章标题：<input type="text" name="title" value="${article.title!}" id="titleInput"/></div>
		<div><textarea id="editor" style="width:100%">${article.source!}</textarea></div>
		<div><button type="button" id="saveBtn">保存</button></div>
	</main>

	<aside class="sidebar sidebar-primary widget-area" role="complementary" >
		<section id="search-2" class="widget widget-1 even widget-first widget_search">
			<div class="widget-wrap">
				<form role="search" method="get" class="search-form" >
					<input type="search" class="search-field" placeholder="Search ..." value="" name="s" title="Search for:">
					<input type="submit" class="search-submit" value="Search">
				</form>
			</div>
		</section>
		
		<section id="recent-posts-2" class="widget widget-3 even widget_recent_entries">
			<div class="widget-wrap">		
				<h4 class="widget-title">功能导航</h4>		
				<ul>
					<li><a>文章列表</a></li>
					<li><a>分类管理</a></li>
					<li><a>评论管理</a></li>
				</ul>
			</div>
		</section>
  	</aside>

	</div>
</div>

	<footer id="footer" class="site-footer" role="contentinfo" >
		<div class="wrap">
		<div class="footer-content footer-insert">
		<p class="copyright">Copyright &#169; 2015 OMEGA.</p>
		<p class="credit">Theme by ThemeHall.</p>
		</div>
		</div>
	</footer>
</div>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
<script src="//tinymce.cachefly.net/4.1/tinymce.min.js"></script>
<script type="text/javascript">
$(function(){
	tinymce.init({
	    selector: "#editor",
	    plugins: [
	        "advlist autolink lists link image charmap print preview anchor",
	        "searchreplace visualblocks code fullscreen",
	        "insertdatetime media table contextmenu paste "
	    ],
	    toolbar: "insertfile undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify | bullist numlist outdent indent | link image"
	});
	
	$('#saveBtn').click(function(){
		var title = $.trim($('#titleInput').val());
		if(title == ''){
			return alert('请输入文章标题');
		}
		$.ajax({
			url:'/admin/update',
			data:'title='+ title + '&content=' + $('#editor').val(),
			dataType:'json'
		}).success(function(ret){
			if(ret.status == 'ok'){
				alert(ret.articleId);
			}else{
				alert(ret.error);
			}
		});
	});
});
</script>
</body>
</html>