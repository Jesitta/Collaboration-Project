package com.niit.letzchat.dao;

	import java.util.List;

	import org.hibernate.Criteria;
	import org.hibernate.Query;
	import org.hibernate.SessionFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import org.springframework.transaction.annotation.Transactional;

	import com.niit.letzchat.model.JobInfo;


	@Repository("jobDAO")
	@Transactional
	public class JobDAOImpl implements JobDAO{
		@Autowired
		public SessionFactory sessionFactory;

		public JobInfo get(int id) {
			String hql="from JobInfo where id  =" + "'" + id + "'";
			Query query=sessionFactory.getCurrentSession().createQuery(hql);
			
			List<JobInfo> list = query.list();
			
			if(list!= null && !list.isEmpty()) {
				return list.get(0);
				
			}
			return null;
		}

		public void saveOrUpdate(JobInfo jobInfo) {
			sessionFactory.getCurrentSession().saveOrUpdate(jobInfo);
			
		}


		public void delete(int id) {
			JobInfo delete = new JobInfo();
			delete.setId(id);
			sessionFactory.getCurrentSession().delete(delete);
			
			
		}
		
		
		public List<JobInfo> list() {
			
			@SuppressWarnings("unchecked")
			List<JobInfo> list =(List<JobInfo>)
			sessionFactory.getCurrentSession()
			.createCriteria(JobInfo.class)
			.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
			return list;
		}
		

	}


