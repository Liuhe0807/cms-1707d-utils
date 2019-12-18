package com.lh.test;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;

import com.liuhe.beans.Book;
import com.liuhe.ESUtils;

public class EsTest {

	/*@Autowired
	ElasticsearchTemplate elasticsearchTemplate;
	//高亮显示
	@Test
	public void testHL(){
		
		AggregatedPage<Book> selectObjects = (AggregatedPage<Book>)ESUtils.selectObjects(elasticsearchTemplate, Book.class, 1, 5, new String[]{"name"}, "红");
		List<Book> content = selectObjects.getContent();
		for (Book book : content) {
			System.out.println(book);
		}
		
	}*/
}
