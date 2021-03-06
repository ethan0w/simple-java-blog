<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<title>eHuang's Blog</title>
<meta name="viewport" content="width=device-width" />
<link rel="stylesheet" href="/css/style.css" type="text/css" media="all" />
</head>
<body>
<div class="site-container">

<header id="header" class="site-header" role="banner" >
	<div class="wrap">
		<div class="title-area">
			<h1 class="site-title" ><a href="/" title="OMEGA" rel="home">eHuang</a></h1>
			<h3 class="site-description"><span>学而时习之，不亦乐乎</span></h3>
		</div>
	</div>
</header>
	
<div class="site-inner">
	<div class="wrap">
	<main class="content" id="content" role="main" >

		<#list list as articlelist>
		<article id="post-1178" class="entry post publish author-hwijaya post-1178 format-standard has-post-thumbnail category-markup post_tag-content-2 post_tag-css post_tag-formatting-2 post_tag-html post_tag-markup-2" itemscope="itemscope" itemtype="http://schema.org/BlogPosting" itemprop="blogPost">	

			<div class="entry-wrap">
				<header class="entry-header">	
					<h2 class="entry-title" ><a href="/article/index?id=${articlelist.id}">${articlelist.title}</a></h2>
					<div class="entry-meta">
						<time class="entry-time">${articlelist.createTime?datetime}</time>
					</div>
				</header>
					
				<div class="entry-summary" >
					<div id="lorems">
						${articlelist.summary!}
					</div>
				</div>
				
				<footer class="entry-footer">
					<div class="entry-meta">
						<span class="entry-terms category" >Posted in: ${articlelist.category!}</span>		
						<span class="entry-terms post_tag" >Tagged: ${articlelist.tags!}</span>		
					</div>
				</footer>
			</div>
		</article>
		</#list>
		
		<!-- 翻页按钮 -->
		<nav role="navigation" id="nav-below" class="navigation  paging-navigation">
			<nav class="pagination loop-pagination">
				<#if pageNo == 1>
					<span class="page-numbers current">1</span>
				<#else>
					<a class="prev page-numbers" href="/article/list?pageNo=${pageNo-1}">&laquo; Previous</a>
					<a class="page-numbers" href="/article/list">1</a>
				</#if>
				
				<#if (pageNo > 3)>
					<span class="page-numbers dots">&hellip;</span>
				</#if>
				
				<#if (pageNo > 2)>
					<a class="page-numbers" href="/article/list?pageNo=${pageNo-1}">${pageNo-1}</a>
				</#if>
				
				<#if (pageNo > 1) && (pageNo < num)>
					<span class="page-numbers current">${pageNo}</span>
				</#if>
				
				<#if (pageNo+1 < num) >
					<a class="page-numbers" href="/article/list?pageNo=${pageNo+1}">${pageNo+1}</a>
				</#if>
				
				<#if (pageNo+2 < num) >
					<span class="page-numbers dots">&hellip;</span>
				</#if>
				
				<#if pageNo == num>
					<span class="page-numbers current">${num}</span>
				<#else>
					<a class="page-numbers" href="/article/list?pageNo=${num}">${num}</a>
					<a class="next page-numbers" href="/article/list?pageNo=${pageNo+1}">Next &raquo;</a>
				</#if>
			</nav>
		</nav>
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
		
		<section id="calendar-2" class="widget widget-2 odd widget_calendar">
			<div class="widget-wrap">
				<div id="calendar_wrap">
				<table id="wp-calendar">
					<caption>February 2015</caption>
					<thead>
						<tr>
							<th scope="col" title="Monday">M</th>
							<th scope="col" title="Tuesday">T</th>
							<th scope="col" title="Wednesday">W</th>
							<th scope="col" title="Thursday">T</th>
							<th scope="col" title="Friday">F</th>
							<th scope="col" title="Saturday">S</th>
							<th scope="col" title="Sunday">S</th>
						</tr>
					</thead>

					<tfoot>
						<tr>
							<td colspan="3" id="prev"><a href="http://themehall.com/preview/omega/2013/01">&laquo; Jan</a></td>
							<td class="pad">&nbsp;</td>
							<td colspan="3" id="next" class="pad">&nbsp;</td>
						</tr>
					</tfoot>

					<tbody>
					<tr>
						<td colspan="6" class="pad">&nbsp;</td><td>1</td>
					</tr>
					<tr>
						<td>2</td><td>3</td><td id="today">4</td><td>5</td><td>6</td><td>7</td><td>8</td>
					</tr>
					<tr>
						<td>9</td><td>10</td><td>11</td><td>12</td><td>13</td><td>14</td><td>15</td>
					</tr>
					<tr>
						<td>16</td><td>17</td><td>18</td><td>19</td><td>20</td><td>21</td><td>22</td>
					</tr>
					<tr>
						<td>23</td><td>24</td><td>25</td><td>26</td><td>27</td><td>28</td>
						<td class="pad" colspan="1">&nbsp;</td>
					</tr>
					</tbody>
				</table>
				</div>
			</div>
		</section>		
		
		<section id="recent-posts-2" class="widget widget-3 even widget_recent_entries">
			<div class="widget-wrap">		
				<h4 class="widget-title">Recent Posts</h4>		
				<ul>
					<#list recentPosts as post>
						<li><a href="/article/index?id=${post.id}">${post.title}</a></li>
					</#list>
				</ul>
			</div>
		</section>
		
		<section id="archives-2" class="widget widget-4 odd widget_archive">
			<div class="widget-wrap"><h4 class="widget-title">Archives</h4>		
				<ul>
					<#list achives as achive>
						<li><a>${achive.archiveDate!}</a></li>
					</#list>
				</ul>
			</div>
		</section>
		
		<section id="categories-2" class="widget widget-5 even widget-last widget_categories">
			<div class="widget-wrap"><h4 class="widget-title">Categories</h4>		
			<ul>
				<li class="cat-item cat-item-2"><a>aciform</a></li>
			</ul>
			</div>
		</section>
		
  	</aside>

	</div>
	</div>

	<footer id="footer" class="site-footer" role="contentinfo" >
		<div class="wrap">
		<div class="footer-content footer-insert">
		<p class="copyright">Copyright &#169; 2015 eHuang.</p>
	
		<p class="credit">Theme by ThemeHall.</p>
		</div>
		</div>
	</footer>
</div>

<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.1/jquery.min.js"></script>
</body>
</html>