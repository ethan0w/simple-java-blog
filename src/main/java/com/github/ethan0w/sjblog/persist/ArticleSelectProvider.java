package com.github.ethan0w.sjblog.persist;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

public class ArticleSelectProvider {
	
	public String buildArticleSelector(Map<String, Object> params){
		int userId = (int) params.get("param1");
		String title = (String) params.get("param2");
		String category = (String) params.get("param3");
		String tag = (String) params.get("param4");
		
		String where = " 1=1 ";
		if(userId > 0){
			where += " AND userId=" + userId;
		}
		
		if(StringUtils.isNotBlank(title)){
			title = "%" + title + "%";
			where += " AND title like #{title} ";
		}
		
		if(StringUtils.isNotBlank(category)){
			where += " AND category=#{category}";
		}
		
		if(StringUtils.isNotBlank(tag)){
			tag = "%" + tag + "%";
			where += " AND tag like #{tag}";
		}
		
		String columns = "count(1)";
		String orderBy = "id desc";
		if(params.containsKey("5")){
			columns = "id, userId, title,  summary, category, tags, createTime, updateTime, type, state";
			int offset = (int) params.get("param5");
			int size = (int) params.get("param6");
			orderBy += " LIMIT " + offset + ", " + size;
		}
		
		final String selection = columns;
		final String condition = where;
		final String orderClause = orderBy;
		return new SQL(){{
			SELECT(selection);
			FROM("sj_blog_article");
			WHERE(condition);
			if(orderClause.contains("LIMIT")){//order by where there is a limit clause
				ORDER_BY(orderClause);
			}
		}}.toString();
	}
}
