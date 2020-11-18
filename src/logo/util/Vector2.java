package logo.util;

public class Vector2
{
	public float x;
	public float y;
	
	public Vector2 (float x, float y) 
	{
		this.x = x;
		this.y = y;
	}
	
	public Vector2 () 
	{
		this.x = (this.y = 0);
	}
}
