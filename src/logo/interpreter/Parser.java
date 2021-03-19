package logo.interpreter;

import logo.util.Token;

public class Parser
{
	//private static Token[] tokens;
	
	private static int nextExpected = 0;
	
	public static void Parse(Token[] tokens)
	{
		//Parser.tokens = tokens;
		
		for (int i = 0; i < tokens.length; i++)
		{
			Token currentToken = tokens[i];
			
			switch (currentToken.type)
			{
			case TURTLE_KEYWORD:
				executeTurtle(tokens[i].value);
				break;

			case CONTROL_KEYWORD:
				executeControl();
				break;
				
			case PEN_KEYWORD:
				executePen();
				break;
				
			case OTHER_KEYWORD:
				executeOther();
				break;
				
			case OPERATION_KEYWORD:
				executeOperation();
				break;
				
			case IDENTIFIER:
				break;
				
			case NUMBER:
				break;
				
			case SPECIAL:
				break;
				
			case STRING:
				break;
			default:
				break;
			}
		}
	}
	
	private static void executeTurtle(String tokenVal) 
	{
		// Movement logic here
		if(tokenVal.matches("forward|fd")) System.out.println("Forward!");
		if(tokenVal.matches("back|bk")) System.out.println("Forward!");
	}
	
	private static void executeControl() 
	{
		
	}
	
	private static void executePen() 
	{
		
	}
	
	private static void executeOther() 
	{
		
	}
	
	private static void executeOperation() 
	{
		
	}
}
