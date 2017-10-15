package Social.communications;

import java.sql.Date;

public class Message {
	private int message_id;
	private int conversation_id;
	private String content;
	private Date date;

	public Message(int message_id, int conversation_id, String content, Date date) {
		this.message_id = message_id;
		this.conversation_id = conversation_id;
		this.content = content;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getMessage_id() {
		return message_id;
	}

	public void setMessage_id(int message_id) {
		this.message_id = message_id;
	}

	public int getConversation_id() {
		return conversation_id;
	}

	public void setConversation_id(int conversation_id) {
		this.conversation_id = conversation_id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
