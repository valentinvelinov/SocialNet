package com.socialNet.interfaces;

import com.socialNet.exception.MessageException;
import com.socialNet.model.Message;

public interface IMessage {
	public int sendMessage(Message message) throws MessageException;
}
