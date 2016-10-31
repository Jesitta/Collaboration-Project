package com.niit.letzchat.dao;

	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.niit.letzchat.model.GroupInfo;


	@Repository("groupDAO")
	@Transactional
	public class GroupDAOImpl implements GroupDAO{
		@Autowired
		public SessionFactory sessionFactory;

		public GroupInfo get(int id) {
			String hql="from GroupInfo where id  =" + "'" + id + "'";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			
			List<GroupInfo> list = query.list();
			
			if(list!= null && !list.isEmpty()) {
				return list.get(0);
				
			}
			return null;
		}

		public void saveOrUpdate(GroupInfo groupInfo) {
			sessionFactory.getCurrentSession().saveOrUpdate(groupInfo);
			
		}


		public void delete(int id) {
			GroupInfo delete = new GroupInfo();
			delete.setId(id);
			sessionFactory.getCurrentSession().delete(delete);
			
			
		}
		
		
		public List<GroupInfo> list() {
			
			@SuppressWarnings("unchecked")
			List<GroupInfo> list =(List<GroupInfo>)
			sessionFactory.getCurrentSession()
			.createCriteria(GroupInfo.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return list;
		}
		

	}


