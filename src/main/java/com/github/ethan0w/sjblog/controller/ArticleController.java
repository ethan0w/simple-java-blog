package com.github.ethan0w.sjblog.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.ethan0w.sjblog.model.Article;
import com.github.ethan0w.sjblog.service.ArticleService;
import com.github.ethan0w.sjblog.test.MockDataUtils;

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
	public String listArticle(String pageNo, Model model){
		model.addAttribute("list", MockDataUtils.getList());
		return "list";
	}
}
