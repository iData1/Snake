import java.awt.Point;
public class Apple{
	protected Point position;
	public Apple(Point position){
		setPosition(position);
	}
	public void setPosition(Point position){
		this.position = position;
	}
	public Point getPosition(){
		return this.position;
	}
}
