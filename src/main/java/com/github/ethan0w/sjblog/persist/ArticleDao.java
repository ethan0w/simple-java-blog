package com.github.ethan0w.sjblog.persist;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;

import com.github.ethan0w.sjblog.model.Article;

/**
 * article dao
 * @author hy
 *
 */
public interface ArticleDao {

	@Select("select * from sj_blog_article where id=#{id}")
	Article getArticleById(int id);

	
	@SelectProvider(type=ArticleSelectProvider.class, method="buildArticleSelector")
	List<Article> getArticleList(int userId, String title, String category, String tag, int start, int limit);
	
	@SelectProvider(type=ArticleSelectProvider.class, method="buildArticleSelector")
	int getArticleCount(int userId, String title, String category, String tag);
	
	@Insert("insert into sj_blog_article (userId, title, content, summary, source, category, tags, createTime, type, state) "
			+ "values (#{userId}, #{title}, #{content}, #{summary}, #{source}, #{category}, #{tags}, #{createTime}, #{type}, #{state} )")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int addArticle(Article article);
	
	@Update("update sj_blog_article set title=#{title}, content=#{content}, summary=#{summary}, source=#{source}, category=#{category}, tags=#{tags}, type=#{type}), state=#{state} where id=#{id}")
	int updateArticle(Article article);
	
	@Update("update sj_blog_article set state=#{state} where id=#{articleId}")
	int updateState(int articleId, int state);
}
