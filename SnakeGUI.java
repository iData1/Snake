import java.awt.event.*;
import java.awt.Color;
import java.awt.Point;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.util.*;
public class SnakeGUI extends JFrame implements KeyListener {
	protected static Snake snake;

	public static final int DISTANCE = snake.MOVEMENT;
	public static final int OFFSET_SNAKE = 2;
	public static final int OFFSET_FRUIT = 4;
	public static final Color BACKGROUND_COLOR = Color.BLACK;

	public static final Color PIECES_COLOR = Color.GREEN;
	public static final Color HEAD_COLOR = Color.RED;

	public static final Color FRUIT_COLOR = Color.WHITE;

	public static final char UP = 'z';
	public static final char DOWN = 'h';
	public static final char RIGHT = 'j';
	public static final char LEFT = 'g';

	public long timer = 40;

	public int width;
	public int height;

	Point point;

	public void paint(Graphics g){
		if(getHeight() != snake.getMaxPositionY()){
			snake.setMaxPositionY(getHeight() - (getHeight() % DISTANCE));
		}
		if(getWidth() != snake.getMaxPositionX()){
			snake.setMaxPositionX(getWidth() - (getWidth() % DISTANCE));
		}
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0,0,getWidth(),getHeight());
		drawTail(g);
		drawHead(g);
		drawFruit(g);
		point = new Point((int)snake.getPieces().get(0).getX(),(int)snake.getPieces().get(0).getY());

	}
	public void drawFruit(Graphics g){
		g.setColor(FRUIT_COLOR);
		Point p = snake.apple.getPosition();
		g.fillRect((int) p.getX() + OFFSET_FRUIT, (int) p.getY() + OFFSET_FRUIT, DISTANCE-OFFSET_FRUIT, DISTANCE-OFFSET_FRUIT);
	}
	/**
	 * Metodo per stampare la coda dello snake
	 * @param g graphics
	 */
	public void drawTail(Graphics g){
		ArrayList<Point> pieces = snake.getPieces();
		Point temp;
		g.setColor(PIECES_COLOR);
		for(int i = 0; i < pieces.size()-1; i++){
			temp = pieces.get(i);
			g.fillRect((int) temp.getX() + OFFSET_SNAKE, (int) temp.getY() + OFFSET_SNAKE, DISTANCE-OFFSET_SNAKE, DISTANCE-OFFSET_SNAKE);
		}
	}
	/**
	 * Metodo per stampare la testa dello snake
	 * @param g graphics
	 */
	public void drawHead(Graphics g){
		ArrayList<Point> pieces = snake.getPieces();
		g.setColor(HEAD_COLOR);
		Point temp = pieces.get(pieces.size()-1);
		g.fillRect((int) temp.getX() + OFFSET_SNAKE, (int) temp.getY() + OFFSET_SNAKE, DISTANCE - OFFSET_SNAKE, DISTANCE-OFFSET_SNAKE);
	}
	/**
	 * Costruttore
	 * @param title Titolo della finestra
	 */
	public SnakeGUI(String title) {
		super(title);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(300, 300);
		this.addKeyListener(this);
		snake = new Snake(new Point(50,50));
		point = new Point(-DISTANCE,-DISTANCE);
	}
	/**
	 * Evento per quando viene premuto un tasto
	 * @param e evento
	 */
	public void keyPressed(KeyEvent e){
		if(e.getKeyChar() == UP){
			snake.setDirection(snake.UP);
		}
		else if(e.getKeyChar() == DOWN){
			snake.setDirection(snake.DOWN);
		}
		else if(e.getKeyChar() == RIGHT){
			snake.setDirection(snake.RIGHT);
		}
		else if(e.getKeyChar() == LEFT){
			snake.setDirection(snake.LEFT);
		}
	}
	public void keyTyped(KeyEvent e){
	}
	public void keyReleased(KeyEvent e){
	}
}
