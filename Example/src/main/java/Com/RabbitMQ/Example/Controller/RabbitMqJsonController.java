package Com.RabbitMQ.Example.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.RabbitMQ.Example.Consumer.RAbbitMqJsonConsumer;
import Com.RabbitMQ.Example.Dto.User;
import Com.RabbitMQ.Example.Producer.RabbitMqJsonPublisher;
import Com.RabbitMQ.Example.Producer.RabbitMqPublisher;

@RestController
@RequestMapping("/api/rabbitmqjson")
public class RabbitMqJsonController 
{
	private RabbitMqJsonPublisher publisher;
	
	public RabbitMqJsonController(RabbitMqJsonPublisher publisher) {

		this.publisher = publisher;
	}
	
	@Autowired
	private RAbbitMqJsonConsumer consumer;


	@PostMapping()
	public ResponseEntity<String> sendMessage(@RequestBody User user)
	{
		publisher.SendMessage(user);
		return ResponseEntity.ok("Data sent Successfully...");
	}
	
	@GetMapping
	public User Getdata()
	{
		return consumer.GetUser();
	}

}
