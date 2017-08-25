
package gwt.sample.app.server;

//@Path("test")
public class Message {

	
	//@GET
	//@Produces(MediaType.TEXT_PLAIN)
	public String getText()
	{
		return "Successfully Restful Service Invoked";
	}
}
