
public class MessageUtil {

	private String message;

	public MessageUtil(String message) {
		super();
		this.message = message;
	}
	
	
	public String printMessage(){
		System.out.println(message);
		return message;
	}
	
	public String salutationMessage(){
		message = "HI! "+message;
		System.out.println(message);
		return message;
	}
	
	public void arithmeticSalutionMessage(){
		System.out.println(message);
		int a = 0;
		int b= 1/a;
		
	}
}
