package com.github.ethan0w.sjblog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.ethan0w.sjblog.model.Archives;
import com.github.ethan0w.sjblog.model.Article;
import com.github.ethan0w.sjblog.persist.ArticleDao;

@Service
public class ArticleService {
	
	@Autowired
	private ArticleDao articleDao;
	
	public Article getArticle(int id){
		return articleDao.getArticleById(id);
	}

	//文章列表
	public List<Article> getArticleList(int userId, String title, String category, String tag,  int start, int limit) {
		return articleDao.getArticleList(userId, title, category, tag, start, limit);
	}
	
	//文章总数
	public int getArticleCount(int userId, String title, String category, String tag){
		return articleDao.getArticleCount(userId, title, category, tag);
	}

	//新增文章
	public int addArticle(Article article) {
		return articleDao.addArticle(article);
	}

	//更新文章
	public int updateArticle(Article article) {
		return articleDao.updateArticle(article);
	}
	
	//档案列表
	public List<Archives> getArchiveList(int userId) {
		return articleDao.getArchives(userId);
	}
}
