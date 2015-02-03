package com.github.ethan0w.sjblog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.ethan0w.sjblog.model.Article;
import com.github.ethan0w.sjblog.persist.ArticleDao;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	public Article getArticle(long id){
		return articleDao.getArticleById(id);
	}
	
}
