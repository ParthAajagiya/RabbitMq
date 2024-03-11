package Com.RabbitMQ.Example.Producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RabbitMqPublisher {
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing.key}")
	private String routingKey;

	public RabbitTemplate rabbitTemplate;

	public RabbitMqPublisher(RabbitTemplate rabbitTemplate) {
	
		this.rabbitTemplate = rabbitTemplate;
	}
	
	private static Logger logger = LoggerFactory.getLogger(RabbitMqPublisher.class);
	
	public void SendMessage(String Message)
	{
		logger.info(String.format("Message Sent ->"+Message), Message);
		rabbitTemplate.convertAndSend(exchange,routingKey,Message);
	}
}
