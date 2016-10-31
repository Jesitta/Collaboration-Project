package com.niit.letzchat.dao;

import java.util.List;

import com.niit.letzchat.model.BlogInfo;


public interface BlogDAO {
	public BlogInfo get(int id);
	
	public void saveOrUpdate(BlogInfo bloginfo);
	public void delete(int id);
	public List<BlogInfo> list();
}

