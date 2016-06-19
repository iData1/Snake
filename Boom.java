import java.awt.Point;
public class Boom extends Food{
	public Boom(Point position, double movement){
		super(position, movement);
	}
	public Boom()
	{
		this(new Point(50, 50), 1);
	}
}