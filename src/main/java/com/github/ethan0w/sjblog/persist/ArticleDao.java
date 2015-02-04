package com.github.ethan0w.sjblog.persist;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.github.ethan0w.sjblog.model.Article;

public interface ArticleDao {

	@Select("select * from Article where id=#{id}")
	Article getArticleById(int id);

	@Select("select * from Article")
	List<Article> getAllArticles();
}
