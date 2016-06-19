import java.awt.Point;
public class Trash extends Food{
	public Trash(Point position, double movement){
		super(position, movement);
	}
	public Trash()
	{
		this(new Point(50, 50), 1);
	}
}