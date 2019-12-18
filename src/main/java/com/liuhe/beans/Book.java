package com.liuhe.beans;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
//指定索引库，和类型，（索引库名称和类型名称不能用大写字母，用了就报错！）
@Document(indexName="menghuan",type="book")
public class Book implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 486284164930253159L;
	//指定主键
	@Id
	private Integer id;
	//第1个值：用ik只能分词器来分词2.是否把当前字段的值设置索引3.建立的索引是否存储4.搜索时的关键字是否分词
	private Integer num;
	@Field(analyzer="ik",index=true,store=true,searchAnalyzer="ik",type=FieldType.text)
	private String name;
	@Field(analyzer="ik",index=true,store=true,searchAnalyzer="ik",type=FieldType.text)
	private String author;
	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * @return the num
	 */
	public Integer getNum() {
		return num;
	}
	/**
	 * @param num the num to set
	 */
	public void setNum(Integer num) {
		this.num = num;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	public Book(Integer id, Integer num, String name, String author) {
		super();
		this.id = id;
		this.num = num;
		this.name = name;
		this.author = author;
	}
	public Book() {
		super();
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Book [id=" + id + ", num=" + num + ", name=" + name
				+ ", author=" + author + "]";
	}
	
	
}
