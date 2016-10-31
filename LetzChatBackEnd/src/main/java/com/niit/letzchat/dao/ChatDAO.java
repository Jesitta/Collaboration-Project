package com.niit.letzchat.dao;

import java.util.List;
import com.niit.letzchat.model.ChatInfo;

public interface ChatDAO {
public ChatInfo get(int id);
	
	public void saveOrUpdate(ChatInfo chatInfo);
	public void delete(int id);
	public List<ChatInfo> list();
}
