import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) {
		ScribbleParser sp = new ScribbleParser();
		while(true) {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		    String inputLine = null;
		    try {
		        inputLine = br.readLine();
		        sp.interpret(inputLine);
		      } catch (IOException e) {
		        System.out.println("I hate life. And I'm a vegetarian so I don't even get to eat chunky bacons.");
		        System.exit(1);
		      }
		}
	}
}
