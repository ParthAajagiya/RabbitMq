package Com.RabbitMQ.Example.Producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import Com.RabbitMQ.Example.Dto.User;


@Service
public class RabbitMqJsonPublisher {
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing.json.key}")
	private String routingKey;
//	
//	@Value("${rabbitmq.routing.json.key2}")
//	private String routingKey2;

	public RabbitTemplate rabbitTemplate;

	public RabbitMqJsonPublisher(RabbitTemplate rabbitTemplate) {
	
		this.rabbitTemplate = rabbitTemplate;
	}
	
	private static Logger logger = LoggerFactory.getLogger(RabbitMqJsonPublisher.class);
	
	public void SendMessage(User user)
	{
		logger.info(String.format("Message Sent ->"+user), user);
		rabbitTemplate.convertAndSend(exchange,routingKey,user);
//		rabbitTemplate.convertAndSend(exchange,routingKey2,user);
	}
}

