package com.niit.letzchat.dao;

	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.niit.letzchat.model.FriendsInfo;


	@Repository("friendDAO")
	@Transactional
	public class FriendDAOImpl implements FriendDAO{
		@Autowired
		public SessionFactory sessionFactory;

		public FriendsInfo get(int id) {
			String hql="from FriendsInfo where id  =" + "'" + id + "'";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			
			List<FriendsInfo> list = query.list();
			
			if(list!= null && !list.isEmpty()) {
				return list.get(0);
				
			}
			return null;
		}

		public void saveOrUpdate(FriendsInfo friendInfo) {
			sessionFactory.getCurrentSession().saveOrUpdate(friendInfo);
			
		}


		public void delete(int id) {
			FriendsInfo delete = new FriendsInfo();
			delete.setId(id);
			sessionFactory.getCurrentSession().delete(delete);
			
			
		}
		
		
		public List<FriendsInfo> list() {
			
			@SuppressWarnings("unchecked")
			List<FriendsInfo> list =(List<FriendsInfo>)
			sessionFactory.getCurrentSession()
			.createCriteria(FriendsInfo.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return list;
		}
		

	}


