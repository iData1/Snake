import java.awt.Point;
public class Food{
	protected Point position;
	double movement;
	public Food(Point position, double movement){
		setPosition(position);
		this.movement = movement;
	}
	public void setPosition(Point position){
		this.position = position;
	}
	public Point getPosition(){
		return this.position;
	}
}