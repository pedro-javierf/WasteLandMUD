package interpreter;

import java.util.List;

import interpreter.command.Command;
import world.Player;

public class InterpreterRefactored {

	private static InterpreterRefactored instance;

	public InterpreterRefactored() {
		// TODO Auto-generated constructor stub
	}

	/**
	 *getInstance() returns a static reference to this Interpreter following
	 * the Singleton pattern. This will be used by server.Client to gain a
	 * reference to the interpreter to which it is sending commands.
	 * 
	 * @return a reference to the Singleton Interpreter.
	 */
	public static InterpreterRefactored getInstance() {

		if(instance == null) {
			instance =  new InterpreterRefactored();
		}
		return instance;
	}
	
	public synchronized void processCommand(Player player, String textCommand) {
		
		List<String> parsedCommandSequence = CommandParser.parseCommand(textCommand);
		
		if(!parsedCommandSequence.isEmpty()) {
			
			Command command = CommandInstantiator.instantiate(player, parsedCommandSequence);
			
			command.execute();	
			
		}	
	}
}
