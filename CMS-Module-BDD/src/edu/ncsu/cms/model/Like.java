package edu.ncsu.cms.model;

import java.util.ArrayList;
import java.util.List;

public class Like {
	private List<String> userList = new ArrayList<String>();
	
	public List<String> getUserList() {
		return userList;
	}

	public void setUserList(List<String> userList) {
		this.userList = userList;
	}
	
	//add a particular user to this list
}
