package edu.ncsu.cms.manager;

import edu.ncsu.cms.model.Like;
import edu.ncsu.cms.model.Post;

public class LikeManager {
	public static void like(Post post, String user) {
		Like like = post.getLikes();
		if(like.getUserList().contains(user))
		{
			like.getUserList().remove(user);
			post.setLikesCount(like.getUserList().size());
			
		}
		else{
			like.getUserList().add(user);
			post.setLikesCount(like.getUserList().size());
		}
		
		//return post.getLikesCount();
	}
}
