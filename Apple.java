import java.awt.Point;
public class Apple extends Food{
	public Apple(Point position, double movement){
		super(position, movement);
	}
	public Apple()
	{
		this(new Point(50, 50), 1);
	}
}