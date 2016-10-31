package com.niit.letzchat.dao;

import java.util.List;

import com.niit.letzchat.model.JobInfo;

public interface JobDAO {
     
	public JobInfo get(int id);
	
	public void saveOrUpdate(JobInfo jobInfo);
	public void delete(int id);
	public List<JobInfo> list();
}
