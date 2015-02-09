package com.github.ethan0w.sjblog.controller.admin;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.ethan0w.sjblog.model.Article;
import com.github.ethan0w.sjblog.service.ArticleService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	ArticleService articleService;
	
	@RequestMapping("/edit")
	public String toEdit(String articleId, Model model){
		int artId = NumberUtils.toInt(articleId);
		int userId = 0;
		
		Article article = null;
		if(artId > 0){
			article = articleService.getArticle(artId);
		}
		
		if(article == null){
			article = new Article();
		}
		
		model.addAttribute("article", article);
		return "admin/edit";
	}
	
	@ResponseBody
	@RequestMapping("/update")
	public Map<String, Object> update(String articleId, String title, String type, String source, String content, String category, String tags ){
		Map<String, Object> result = new HashMap<>();
		
		int userId = 0;
		
		int artId = NumberUtils.toInt(articleId);
		int typeId = NumberUtils.toInt(type);
		
		title = StringUtils.trim(title);
		source = StringUtils.trim(source);
		content = StringUtils.trim(content);
		category = StringUtils.trim(category);
		tags = StringUtils.trim(tags);
		
		Article article = null;
		if(artId > 0){
			article = articleService.getArticle(artId);
		}
		
		if(article == null){
			article = new Article();
			article.setCreateTime(new Date());
		}
		
		article.setTitle(title);
		article.setSource(source);
		article.setType(typeId);
		article.setContent(content);
		article.setCategory(category);
		article.setTags(tags);
		article.setUserId(userId);
		
		int ret = 0;
		if(article.getId() > 0){
			ret = articleService.updateArticle(article);
		}else{
			ret = articleService.addArticle(article);
		}
		
		if(ret > 0){
			result.put("status", "ok");
			result.put("articleId", article.getId());
		}else{
			result.put("error", "save error");
		}
		
		return result;
	}
	
	
}
