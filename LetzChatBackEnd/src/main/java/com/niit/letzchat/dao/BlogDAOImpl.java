package com.niit.letzchat.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.letzchat.model.BlogInfo;


@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO{
	@Autowired
	public SessionFactory sessionFactory;

	public BlogInfo get(int id) {
		String hql="from BlogInfo where id  =" + "'" + id + "'";
		Query query=sessionFactory.getCurrentSession().createQuery(hql);
		
		List<BlogInfo> listBlog = query.list();
		
		if(listBlog!= null && !listBlog.isEmpty()) {
			return listBlog.get(0);
			
		}
		return null;
	}

	public void saveOrUpdate(BlogInfo bloginfo) {
		sessionFactory.getCurrentSession().saveOrUpdate(bloginfo);
		
	}


	public void delete(int id) {
		BlogInfo blogToDelete = new BlogInfo();
		blogToDelete.setId(id);
		sessionFactory.getCurrentSession().delete(blogToDelete);
		
		
	}
	
	
	public List<BlogInfo> list() {
		
		@SuppressWarnings("unchecked")
		List<BlogInfo> listCategory =(List<BlogInfo>)
		sessionFactory.getCurrentSession()
		.createCriteria(BlogInfo.class)
		.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
		return listCategory;
	}
	

}
