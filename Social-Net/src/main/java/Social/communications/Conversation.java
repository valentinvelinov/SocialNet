package Social.communications;

import java.util.Date;

public class Conversation {

	private int conversation_id;
	private String text;
	private Date date;

	public Conversation(String text, Date date) {
		this.text = text;
		this.date = date;
	}

	public Conversation(int conversation_id, String text, Date date) {
		super();
		this.conversation_id = conversation_id;

	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getConversation_id() {
		return conversation_id;
	}

	public void setConversation_id(int conversation_id) {
		this.conversation_id = conversation_id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
