package com.github.ethan0w.sjblog.controller;

import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.ethan0w.sjblog.model.Article;
import com.github.ethan0w.sjblog.persist.ArticleDao;

@Controller
@RequestMapping("/article")
public class ArticleController {
	
	@Autowired
	ArticleDao articleDao;
	
	@ResponseBody
	@RequestMapping("/index")
	public String getArticle(String id){
		Article article = articleDao.getArticleById(NumberUtils.toLong(id));
		if(article != null){
			return article.getTitle();
		}
		return "article does not exist";
	}
}
