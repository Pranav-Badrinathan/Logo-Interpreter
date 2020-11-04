package logo.util;

import logo.util.enums.TokenType;

public class Token
{
	public TokenType type;
	public String value;

	public Token(TokenType type, String value)
	{
		this.type = type;
		this.value = value;
	}

	public Token()
	{
		this(null, null);
	}
}
