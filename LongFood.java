import java.awt.Point;
public class LongFood extends Food{
	public LongFood(Point position, double movement){
		super(position, movement);
	}
	public LongFood()
	{
		this(new Point(50, 50), 1);
	}
}