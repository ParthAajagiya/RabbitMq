package Com.RabbitMQ.Example.Config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig 
{
	@Value("${rabbitmq.queue.name}")
	private String queue;
	
	@Value("${rabbitmq.queue.json.name}")
	private String JsonQueue;
	
	@Value("${rabbitmq.exchange.name}")
	private String exchange;
	
	@Value("${rabbitmq.routing.key}")
	private String routingKey;
	
	@Value("${rabbitmq.routing.json.key}")
	private String JsonRoutingKey;
	
//	@Value("${rabbitmq.routing.json.key2}")
//	private String JsonRoutingKey2;
//	
	@Bean
	public Queue queue()
	{
		return new Queue(queue);
	}
	
	@Bean
	public Queue Jsonqueue()
	{
		return new Queue(JsonQueue);
	}
	
	@Bean
	public DirectExchange exchange()
	{
		return new DirectExchange(exchange);
	}
	
	@Bean
	public Binding binding()
	{
		return BindingBuilder
				.bind(queue())
				.to(exchange())
				.with(routingKey);
	}
	
	@Bean
	public Binding JsonBinding()
	{
		return BindingBuilder
				.bind(Jsonqueue())
				.to(exchange())
				.with(JsonRoutingKey);
	}
	
	//converter to convert Jsondata
	@Bean
	public MessageConverter JsonConverter()
	{
		return new Jackson2JsonMessageConverter();
	}
	
	
	public AmqpTemplate jconverter(ConnectionFactory connectionFactory)
	{
		RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
		rabbitTemplate.convertAndSend(JsonConverter());
		return rabbitTemplate;
	}
}
