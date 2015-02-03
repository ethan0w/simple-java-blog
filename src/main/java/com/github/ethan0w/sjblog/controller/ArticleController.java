package com.github.ethan0w.sjblog.controller;

import java.util.List;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
		Article article = articleService.getArticle(NumberUtils.toLong(id));
		String title = "";
		if(article != null){
			title = article.getTitle();
		}
		model.addAttribute("title", title);
		return "article";
	}
	
	@ResponseBody
	@RequestMapping("/all")
	public List<Article>  listArticles(){
		return articleService.getAllArticles();
	}
}
