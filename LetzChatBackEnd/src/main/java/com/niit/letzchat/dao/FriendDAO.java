package com.niit.letzchat.dao;

import java.util.List;
import com.niit.letzchat.model.FriendsInfo;

public interface FriendDAO {
public FriendsInfo get(int id);
	
	public void saveOrUpdate(FriendsInfo friendInfo);
	public void delete(int id);
	public List<FriendsInfo> list();
}
