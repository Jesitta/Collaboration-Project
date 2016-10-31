package com.niit.letzchat.dao;

import java.util.List;
import com.niit.letzchat.model.GroupInfo;

public interface GroupDAO {
public GroupInfo get(int id);
	
	public void saveOrUpdate(GroupInfo groupInfo);
	public void delete(int id);
	public List<GroupInfo> list();
}
