package Com.RabbitMQ.Example.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class RabbitMqConsumer 
{
	private Logger logger= LoggerFactory.getLogger(RabbitMqConsumer.class);
	
	@RabbitListener(queues = {"${rabbitmq.queue.name}"})
	public void consume(String message)
	{
		logger.info(String.format("Recieved Message ->"+message),message);
	}
}
