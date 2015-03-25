package edu.ncsu.cms.model;
import java.sql.Timestamp;
import java.util.*;


public class PostManager {
	
	private HashMap<Integer,Post> postLists= new HashMap<Integer,Post>();
	private static PostManager postMngrInstance=new PostManager();
	private PostManager(){}
	
	public static PostManager instance(){
		return postMngrInstance;
	}
	
	public Post createNew(){
		
		Post p = new Post();
		addPost(p);
		return p;		
	}
	public void addPost(Post p){
		postLists.put(p.getPostId(),p);
	}
	
	public Post getPostById(int postID){
		return postLists.get(postID);
	}
	public Version getPostById(int postID, int versionid){
		Post post = postLists.get(postID);
		return post.getVersion(versionid);
	}
	public void savePost(int postId, int versionId, String content) {
		Version version = getPostById(postId, versionId);
		if(version.getState().equals(State.DRAFT)) {
			version.setContent(content);
		}
	}
	
	public Post editPost(Post p, int VersionID, String Content) {
		Version v= p.getVersion(VersionID);
		if(v.getState() == State.DRAFT){
			v.setContent(Content);
		}
		else {
			Version newVersion = new Version();
			newVersion.setVersionId(VersionID+1);
			newVersion.setState(State.DRAFT);
			newVersion.setContent(Content);
			newVersion.setUserId(v.getUserId());
			newVersion.setTimestamp(new Timestamp(System.currentTimeMillis()));
			p.addnewVersion(newVersion);
		}
		return p;
	}
	public boolean deletePost(int VersionID){
		Post p= postLists.remove(VersionID);
		return p!=null;
	}
}
