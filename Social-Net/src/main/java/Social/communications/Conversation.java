package Social.communications;

public class Conversation {

	private int conversation_id;
	private String text;

	public Conversation(int conversation_id, String text) {
		this.conversation_id = conversation_id;
		this.text = text;
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
