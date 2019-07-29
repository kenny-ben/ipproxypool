package ipproxypool.Myexception;

public class responseException extends RuntimeException{
	public responseException() {}
	public responseException(String response) {
		
		super(response);
	}
	
}
