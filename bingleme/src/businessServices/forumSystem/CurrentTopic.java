package businessServices.forumSystem;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import baseUse.Globalization;
import baseUse.TopicDetail;

public class CurrentTopic {
	List<TopicDetail> topic;
	DeleteReply deleteReply;
	
	public CurrentTopic(){
		topic = new ArrayList();
		deleteReply = new DeleteReply();
	}
	
	TopicDetail getTopic(int topicId) throws SQLException{
		for(int i =0;i < topic.size();i++){
			if(topic.get(i).getTopicId() == topicId){
				return topic.get(i);
			}
		}
		TopicDetail td = Globalization.forumData.getTopic(topicId);
		topic.add(td);
		return td;
	}
	void deleteTopic(int topicId){
		for(int i =0;i < topic.size();i++){
			if(topic.get(i).getTopicId() == topicId){
				topic.remove(i);
			}
		}
	}
	void deleteReply(int replyId,int topicId) throws SQLException{
		deleteReply.deleteReply(replyId);
		updateTopic(topicId);
	}
	void editReply(int replyId){
		
	}
	void updateTopic(int topicId) throws SQLException{
		for(int i =0;i < topic.size();i++){
			if(topic.get(i).getTopicId() == topicId){
				TopicDetail td = Globalization.forumData.getTopic(topicId);
				topic.set(i, td);
				break;
			}
		}
	}
}