package logo.interpreter;

import java.util.ArrayList;
import java.util.Arrays;

import logo.util.Token;

public final class Lexer
{
	static class LexRef
	{
		public static final String[] TURTLE_KEYWORDS = { "forward", "fd",
				"backward", "bk",
				"right", "rt",
				"left", "lt",
				"clearscreen", "cs",
				"cleartext", "ct",
				"print", "pr",
				"label",
				"penup", "pu",
				"pendown", "pd",
				"hideturtle", "ht",
				"showturtle", "st",
				"setpensize", 
				"home",
				"setxy", "setx", "sety",
				"setheading", "seth",
				"show", 
				"xcor", "ycor", "heading", "pos",
				"towards", "direction", "pixel"};
		
		public static final String[] NUMERIC_OPERATIONS = {
				"sum","+",
				"difference","-",
				"product","*",
				"quotient","/","remainder",
				"power", "^", "sqrt",
				"sign", "abs",
				"pi", "goldenratio",
				"random", "rerandom"};
	}

	private static ArrayList<Token> tokens;

	private static void tokenize(String input)
	{
		String[] toLex = input.split(" ");
		for (int i = 0; i < toLex.length; i++)
		{
			switch (toLex[i])
			{

			}
		}
	}
}
