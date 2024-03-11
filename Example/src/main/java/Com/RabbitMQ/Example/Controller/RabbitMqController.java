package Com.RabbitMQ.Example.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Com.RabbitMQ.Example.Producer.RabbitMqPublisher;

@RestController
@RequestMapping("/api/rabbitmq")
public class RabbitMqController 
{
	private RabbitMqPublisher publisher;
	
	public RabbitMqController(RabbitMqPublisher publisher) {
		super();
		this.publisher = publisher;
	}

	@GetMapping("/{message}")
	public ResponseEntity<String> sendMessage(@PathVariable("message") String message)
	{
		publisher.SendMessage(message);
		return ResponseEntity.ok("Data sent Successfully...");
	}

}
