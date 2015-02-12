package com.github.ethan0w.sjblog.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.ethan0w.sjblog.BlogConstants;
import com.github.ethan0w.sjblog.model.Article;
import com.github.ethan0w.sjblog.service.ArticleService;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	//@ResponseBody
	@RequestMapping("/index")
	public String getArticle(String id, Model model){
		Article article = articleService.getArticle(NumberUtils.toInt(id));
		model.addAttribute("article", article);
		return "article";
	}
	
	@ResponseBody
	@RequestMapping("/all")
	public Map<String, Object>  listArticles(){
		Map<String, Object> result = new HashMap<String, Object>();
		int count = articleService.getArticleCount(0, null, null, null);
		result.put("num", count);
		result.put("list", articleService.getArticleList(0, null, null, null, 0, 10));
		return result;
	}
	
	@RequestMapping("/list")
	public String listArticle(Integer pageNo, Model model){
		int count = articleService.getArticleCount(0, null, null, null);
		
		//总页数
		model.addAttribute("num", Math.ceil(count*1.0/BlogConstants.ARTICLE_COUNT_PER_PAGE));
		
		//当前页面：如果没有传pageNo参数，则默认第一页
		if(pageNo == null || pageNo <=0 ){
			pageNo = 1;
		}
		model.addAttribute("pageNo", pageNo);
				
		//当前页文章列表
		model.addAttribute("list", articleService.getArticleList(0, null, null, null, (pageNo-1)*BlogConstants.ARTICLE_COUNT_PER_PAGE, BlogConstants.ARTICLE_COUNT_PER_PAGE));
		
		//最近五条
		model.addAttribute("recentPosts", articleService.getArticleList(0, null, null, null, 0, BlogConstants.RECENT_POST_NUM));
		
		//档案
		model.addAttribute("achives", articleService.getArchiveList(0));
		return "list";
	}
}
