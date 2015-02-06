package com.github.ethan0w.sjblog.test;

import java.util.ArrayList;
import java.util.List;

import com.github.ethan0w.sjblog.model.Article;

public class MockDataUtils {
	public static List<Article> getList(){
		List<Article> list = new ArrayList<>();
		Article a1 = new Article();
		a1.setTitle("this is test article 1");
		a1.setContent("this is test content 1");
		list.add(a1);
		
		Article a2 = new Article();
		a2.setTitle("this is test article 2");
		a2.setContent("this is test content 2");
		list.add(a2);
		
		Article a3 = new Article();
		a3.setTitle("这是测试标题 3");
		a3.setContent("这是测试内容 3");
		list.add(a3);
		return list;
	}
}
