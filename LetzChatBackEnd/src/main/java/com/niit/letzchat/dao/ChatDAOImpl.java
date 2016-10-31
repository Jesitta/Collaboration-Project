package com.niit.letzchat.dao;

	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.niit.letzchat.model.ChatInfo;


	@Repository("chatDAO")
	@Transactional
	public class ChatDAOImpl implements ChatDAO{
		@Autowired
		public SessionFactory sessionFactory;

		public ChatInfo get(int id) {
			//String hql="from ChatInfo where id  =" + "'" + id + "'";
		//	Query query=sessionFactory.getCurrentSession().createQuery(hql);
			Criteria query=sessionFactory.getCurrentSession().createCriteria(ChatInfo.class);
			query.add(Restrictions.eq("id", id));
			List<ChatInfo> list = query.list();
			
			if(list!= null && !list.isEmpty()) {
				return list.get(0);
				
			}
			return null;
		}

		public void saveOrUpdate(ChatInfo chatInfo) {
			sessionFactory.getCurrentSession().saveOrUpdate(chatInfo);
			
		}


		public void delete(int id) {
			ChatInfo delete = new ChatInfo();
			delete.setId(id);
			sessionFactory.getCurrentSession().delete(delete);
			
			
		}
		
		
		public List<ChatInfo> list() {
			
			@SuppressWarnings("unchecked")
			List<ChatInfo> list =(List<ChatInfo>)
			sessionFactory.getCurrentSession()
			.createCriteria(ChatInfo.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return list;
		}
		

	}


