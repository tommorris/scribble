import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import org.jruby.RubyObject;

public class ScribbleParser {
	private ScriptEngineManager sem;
	private ScriptEngine rubyEngine;
	private ScriptContext ctx;

	public ScribbleParser() {
		this.sem = new ScriptEngineManager();
		this.rubyEngine = this.sem.getEngineByName("ruby");
		this.ctx = this.rubyEngine.getContext();
	}

	public void interpret(String input) {
		String convertedInput = convert(input);
		try {
			Object returned = (Object) this.rubyEngine.eval(convertedInput, this.ctx);
			if (returned instanceof RubyObject) {
				System.out.println("--> " + ((RubyObject) returned).inspect());
			} else {
				// for objects that aren't boxed in a Ruby type.
				System.out.println("--> " + returned.toString());
			}
		} catch (ScriptException exception) {
			exception.printStackTrace();
		}
	}

	public static String convert(String input) {
		input = input.replaceAll(" times ", " * ");
		input = input.replaceAll(" plus ", " + ");
		input = input.replaceAll(" ! ", " = ");
		input = input.replaceAll(" gte ", " >= ");
		input = input.replaceAll(" lte ", " <= ");
		input = input.replaceAll(" gt ", " > ");
		input = input.replaceAll(" lt ", " < ");
		input = input.replaceAll(" eq ", " == ");
		input = input.replaceAll(" append ", " += ");
		input = input.replaceAll(" ,, (.+) ", " do |x| $1 end");
		return input;
	}
	
//	private void silentEval(String input) {
//		
//	}
}
