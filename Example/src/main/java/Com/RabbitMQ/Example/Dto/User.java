package Com.RabbitMQ.Example.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class User 
{
	private String name;
	private int rollno;
	private int maths;
	private int sci;
	private int eng;
	public User() {
		super();
	}
	
	
}
