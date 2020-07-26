package guru.springframework.sender;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import guru.springframework.config.JmsConfig;
import guru.springframework.model.HelloWorldMessage;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class HelloSender {

	private final JmsTemplate jmsTemplate; 
	
	@Value("${jms.queue}")
	String jmsQueue;
	
	@Scheduled(fixedRate = 2000)
	public void sendMessage() {
		System.out.println("I'm sending a message");
		HelloWorldMessage message = new HelloWorldMessage().builder().
				id(UUID.randomUUID())
				.message("Hello World !")
				.build();
		
		jmsTemplate.convertAndSend(jmsQueue,message);
		System.out.println("Message Sent !");
	}
	
}
