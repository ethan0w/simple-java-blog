package com.github.ethan0w.sjblog.test;

import java.util.ArrayList;
import java.util.List;

import com.github.ethan0w.sjblog.model.Article;

public class MockDataUtils {
	public static List<Article> getList(){
		List<Article> list = new ArrayList<>();
		Article a1 = new Article();
		a1.setId(1);
		a1.setTitle("this is test article 1");
		a1.setContent("this is test content 1");
		list.add(a1);
		
		Article a2 = new Article();
		a2.setId(2);
		a2.setTitle("this is test article 2");
		a2.setContent("this is test content 2");
		list.add(a2);
		
		Article a3 = new Article();
		a3.setId(3);
		a3.setTitle("这是测试标题 3");
		a3.setContent("这是测试内容 3");
		list.add(a3);
		
		Article a4 = new Article();
		a4.setId(4);
		a4.setTitle("这是测试标题 4");
		a4.setContent("这是测试内容 4");
		list.add(a4);
		
		Article a5 = new Article();
		a5.setId(5);
		a5.setTitle("这是测试标题 5");
		a5.setContent("这是测试内容 5");
		list.add(a5);
//		
//		Article a6 = new Article();
//		a6.setId(6);
//		a6.setTitle("这是测试标题 6");
//		a6.setContent("这是测试内容 6");
//		list.add(a6);
//		
//		Article a7 = new Article();
//		a7.setId(7);
//		a7.setTitle("这是测试标题 7");
//		a7.setContent("这是测试内容 7");
//		list.add(a7);
		return list;
	}
}
