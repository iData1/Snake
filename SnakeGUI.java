import java.awt.event.*;

import java.awt.Color;

import java.awt.Point;

import java.awt.Graphics;

import javax.swing.JFrame;

import java.util.*;

public class SnakeGUI extends JFrame implements KeyListener
{

	protected static Snake snake;


	public static final int DISTANCE = snake.MOVEMENT;


	public static final Color BACKGROUND_COLOR = Color.BLACK;


	public static final Color PIECES_COLOR = Color.GREEN;

	public static final Color HEAD_COLOR = Color.GREEN;


	public static final Color APPLE_COLOR = Color.GREEN;

	public static final Color TRASH_COLOR = Color.YELLOW;

	public static final Color BOOM_COLOR = Color.BLUE;

	public static final Color LONGFOOD_COLOR = Color.PINK;


	public static final char UP = 'w';

	public static final char DOWN = 's';

	public static final char RIGHT = 'd';

	public static final char LEFT = 'a';


	public static long timer = 200;


	public void paint(Graphics g)
	{

		g.setColor(BACKGROUND_COLOR);

		g.fillRect(0,0,getWidth(),getHeight());

		drawTail(g);

		drawHead(g);

		drawLine(g);


	}

	public void drawLine(Graphics g)
	{
		g.setColor(Color.green);
		for(int i = 0; i <= 900; i++)
		{
			g.drawLine(0, i * 10, getWidth(), i * 10);
		}
	}

	public void drawApple(Graphics g)
	{
		g.setColor(APPLE_COLOR);

		Point p = snake.apple.getPosition();

		g.fillRect((int) p.getX(), (int) p.getY(), DISTANCE, DISTANCE);


	}

	public void drawTrash(Graphics g)
	{

		g.setColor(TRASH_COLOR);

		Point p = snake.apple.getPosition();

		g.fillRect((int) p.getX(), (int) p.getY(), DISTANCE, DISTANCE);
	}
	public void drawBoom(Graphics g)
	{

		g.setColor(BOOM_COLOR);

		Point p = snake.apple.getPosition();

		g.fillRect((int) p.getX(), (int) p.getY(), DISTANCE, DISTANCE);
	}
	public void drawLongFood(Graphics g)
	{

		g.setColor(LONGFOOD_COLOR);

		Point p = snake.apple.getPosition();

		g.fillRect((int) p.getX(), (int) p.getY(), DISTANCE, DISTANCE);
	}
	/**

	 * Metodo per stampare la coda dello snake

	 * @param g graphics

	 */

	public void drawTail(Graphics g)
	{

		ArrayList<Point> pieces = snake.getPieces();

		Point temp;

		g.setColor(PIECES_COLOR);

		for(int i = 0; i < pieces.size()-1; i++)
		{

			temp = pieces.get(i);

			g.fillRect((int) temp.getX(), (int) temp.getY(), DISTANCE, DISTANCE);

		}


	}

	/**

	 * Metodo per stampare la testa dello snake

	 * @param g graphics

	 */

	public void drawHead(Graphics g)
	{

		ArrayList<Point> pieces = snake.getPieces();

		g.setColor(HEAD_COLOR);

		Point temp = pieces.get(pieces.size()-1);

		g.drawRect((int) temp.getX(), (int) temp.getY(), DISTANCE, DISTANCE);

	}

	/**

	 * Costruttore

	 * @param title Titolo della finestra

	 */

	public SnakeGUI(String title)
	{

		super(title);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		this.setSize(300, 300);

		this.addKeyListener(this);

		snake = new Snake(new Point(50,50));

	}

	/**

	 * Evento per quando viene premuto un tasto

	 * @param e evento

	 */

	public void keyPressed(KeyEvent e)
	{

		if(e.getKeyChar() == UP)
		{

			snake.setDirection(snake.UP);

		}

		else if(e.getKeyChar() == DOWN)
		{

			snake.setDirection(snake.DOWN);

		}

		else if(e.getKeyChar() == RIGHT)
		{

			snake.setDirection(snake.RIGHT);

		}

		else if(e.getKeyChar() == LEFT)
		{

			snake.setDirection(snake.LEFT);

		}

	}

	public void keyTyped(KeyEvent e){
}

	public void keyReleased(KeyEvent e){
}

}