package guru.springframework.listener;

import javax.jms.Message;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import guru.springframework.model.HelloWorldMessage;

@Component
public class HelloMessageListener {

	@JmsListener(destination = "${jms.queue}")
	public void listen(@Payload HelloWorldMessage helloWorldMessage, @Headers MessageHeaders headers, 
			Message message) {
		System.out.println("I got a message !!!");
		System.out.println(helloWorldMessage);
	}
}
