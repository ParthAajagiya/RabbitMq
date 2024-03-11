package Com.RabbitMQ.Example.Consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import Com.RabbitMQ.Example.Dto.User;

@Service
public class RAbbitMqJsonConsumer {
	private Logger logger= LoggerFactory.getLogger(RAbbitMqJsonConsumer.class);
	
	User u= new User();
	@RabbitListener(queues = {"${rabbitmq.queue.json.name}"})
	public void consume(User user)
	{
		logger.info(String.format("Get data ->"+user),user);
		u=user;
	}
	@Bean
	public User GetUser()
	{
		return u;
	}
	

}
