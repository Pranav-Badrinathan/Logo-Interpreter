package logo.interpreter;

import java.util.ArrayList;
import java.util.Arrays;

import logo.util.Token;
import logo.util.enums.TokenType;

public final class Lexer
{
	static class LexRef
	{
		public static final ArrayList<String> TURTLE_KEYWORDS = new ArrayList<String>(Arrays.asList(
				"forward", "fd",
				"back", "bk",
				"right", "rt",
				"left", "lt",
				"ellipse", "arc", "ellipsearc",
				"ellipse2", "arc2", "ellipsearc2",
				"clearscreen", "cs",
				"hideturtle", "ht",
				"showturtle", "st",
				"home",
				"setxy", "setx", "sety",
				"setheading", "seth", 
				"xcor", "ycor", "heading", "pos",
				"towards", "direction", "pixel"));
		
		public static final ArrayList<String> PEN_KEYWORDS = new ArrayList<String>(Arrays.asList(
				"penup", "pu",
				"pendown", "pd",
				"penpaint", "ppt",
				"penreverse", "px",
				"pennormal",
				"setpencolor", "setpencolour", "setpc",
				"setfloodcolor", "setfloodcolour", "setfc",
				"setscreencolor", "setscreencolour", "setsc",
				"setpensize", "setps",
				"setpen"));

		public static final ArrayList<String> OTHER_KEYWORDS = new ArrayList<String>(Arrays.asList(
				"cleartext", "ct",
				"print", "pr", "show",
				"label",
				"mouseon", "mouseoff",
				"keyboardon", "keyboardoff"));
		
		public static final ArrayList<String> OPERATION_KEYWORDS = new ArrayList<String>(Arrays.asList(
				"sum", "+",
				"difference", "-",
				"product", "*",
				"quotient", "/", "remainder",
				"power", "^", "sqrt",
				"sign", "abs", "pi", "goldenratio",
				"random", "rerandom"));
		
		public static final ArrayList<String> CONTROL_KEYWORDS = new ArrayList<String>(Arrays.asList(
				"run", "runresult",
				"repeat", "repcount",
				"if", "ifelse",
				"test", "iftrue", "ift", "iffalse", "iff",
				"pause", "continue",
				"halt", "continue",
				"settimer", "cleartimer"));
		
		public static final ArrayList<Character> NUMBERS = new ArrayList<Character>(Arrays.asList('1','2','3','4','5','6','7','8','9','0','.'));
	}

	private static ArrayList<Token> tokens = new ArrayList<Token>();

	public static void tokenize(String input)
	{
		String[] toLex = input.split(" ");
		for (int i = 0; i < toLex.length; i++)
		{
			String toTokenize = toLex[i];
			
			if(LexRef.TURTLE_KEYWORDS.contains(toTokenize)) tokens.add(new Token(TokenType.TURTLE_KEYWORD, toTokenize));
			else if(LexRef.PEN_KEYWORDS.contains(toTokenize)) tokens.add(new Token(TokenType.PEN_KEYWORD, toTokenize));
			else if(LexRef.OTHER_KEYWORDS.contains(toTokenize)) tokens.add(new Token(TokenType.OTHER_KEYWORD, toTokenize));
			else if(LexRef.OPERATION_KEYWORDS.contains(toTokenize)) tokens.add(new Token(TokenType.OPERATION_KEYWORD, toTokenize));
			else if(LexRef.CONTROL_KEYWORDS.contains(toTokenize)) tokens.add(new Token(TokenType.CONTROL_KEYWORD, toTokenize));
			else if(detectStringsAndIDs(toTokenize)) detectNumbers(toTokenize);
			
		}
	}
	
	private static boolean detectStringsAndIDs(String input) 
	{	
		if(input.charAt(0) == '"')
		{
			tokens.add(new Token(TokenType.STRING, input));
			return true;
		}
		else if(input.charAt(0) == ':') 
		{
			tokens.add(new Token(TokenType.IDENTIFIER, input));
			return true;
		}
		
		return false;
	}
	
	private static void detectNumbers(String input)
	{
		char[] toDetect = input.toCharArray();
		boolean periodFound = false;
		
		StringBuilder numberBuilder = new StringBuilder();
		
		for (char currentChar : toDetect)
		{
			if(periodFound && currentChar == '.')
				break; //Error!
			
			if(LexRef.NUMBERS.contains(currentChar)) 
				numberBuilder.append(currentChar);
			else if(numberBuilder.length() != 0)
			{
				tokens.add(new Token(TokenType.NUMBER, numberBuilder.toString()));
				numberBuilder.setLength(0);
				numberBuilder = new StringBuilder();
				periodFound = false;
			}
			
			//Register operators that might be between numbers without spaces.
			if(currentChar == '+' || currentChar == '-' || currentChar == '*' || currentChar == '/')
				tokens.add(new Token(TokenType.OPERATION_KEYWORD, Character.toString(currentChar)));
		}
	}
}
