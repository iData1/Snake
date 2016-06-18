import java.awt.*;
import java.util.*;
/**
 * @author Samuel Dias da Silva
 */
public class Snake{
	/**
	 * La dimensione iniziale dello snake
	 */
	protected static final int START_LENGTH = 2;
	/**
	 * Costante per quando la direzione dello snake è nulla, cioè fermo
	 */
	protected static final int STOP = -1;
	/**
	 * Costante per quando lo snake si sta muovendo in su
	 */
	protected static final int UP = 0;
	/**
	 * Costante per quando lo snake si sta muovendo a destra
	 */
	protected static final int RIGHT = 1;
	/**
	 * Costante per quando lo snake si sta muovendo in basso
	 */
	protected static final int DOWN = 2;
	/**
	 * Costante per quando lo snake si sta muovendo a sinistra
	 */
	protected static final int LEFT = 3;
	/**
	 * Costante per definire di quanto si deve muovere
	 */
	protected static final int MOVEMENT = 10;
	/**
	 * Posizione massima dello snake, coordinate X
	 */
	protected int maxPositionX;
	/**
	 * Posizione massima dello snake, coordinate Y
	 */
	protected int maxPositionY;
	/**
	 * Direzione dello snake
	 */
	protected int direction;
	/**
	 * ArrayList contenente tutte le coordinate dei vari pezzi dello snake
	 */
	protected ArrayList<Point> pieces;
	/**
	 * Frutto
	 */
	protected Apple apple;
	/**
	 * Flag per il ciclo di gioco
	 */
	protected boolean game;
	/**
	 * Setter per la direzione dello snakejjzjz
	 * @param direction nuova direzione dello snake
	 */
	protected void setDirection(int direction){
		if(direction != this.getDirection()){
			this.direction = direction;
		}
	}
	/**
	 * Setter per la direzione dello snake
	 * @return la direzione dello snake
	 */
	protected int getDirection(){
		return this.direction;
	}
	/**
	 * Setter per Ypieces dello snake
	 * @param pieces nuovo array di posizioni dello snake
	 */
	protected void setPieces(ArrayList<Point> pieces){
		this.pieces = pieces;
	}
	/**
	 * Setter per la direzione dello snake
	 * @return i pezzi dello snake
	 */
	protected ArrayList<Point> getPieces(){
		return this.pieces;
	}
	/**
	 * Getter per game
	 * @return game booleano per il ciclo di gioco
	 */
	protected boolean getGame(){
		return this.game;
	}
	/**
	 * Setter per game
	 * @param game booleano per il ciclo di gioco, 1 il gioco è in corso, 0 il gioco è finito
	 */
	protected void setGame(boolean game){
		this.game = game;
	}
	/**
	 * Setter per maxPositionY
	 * @param maxPositionY nuova posiziona massima dell'asse delle y dello snake
	 */
	protected void setMaxPositionY(int maxPositionY){
		this.maxPositionY = maxPositionY;
	}
	/**
	 * Getter per maxPositionY
	 * @return maxPositionY la posizione massima dell'asse delle y dello snake§
	 */
	protected int getMaxPositionY(){
		return this.maxPositionY;
	}
	/**
	 * Setter per maxPositionX
	 * @param maxPositionX nuova posizione massima per l'asse delle x
	 */
	protected void setMaxPositionX(int maxPositionX){
		this.maxPositionX = maxPositionX;
	}
	/**
	 * Getter per maxPositionX
	 * @return posizione massima dell'asse delle x dello snake
	 */
	protected int getMaxPositionX(){
		return this.maxPositionX;
	}
	/**
	 * Costruttore
	 * @param pieces pezzi dello snake
	 * @param initial posizione iniziale dello snake
	 * @param direction direzione iniziale dello snake
	 * @param maxPositionX posizione massima della x
	 * @param maxPositionY posizione massima della y
	 */
	public Snake(ArrayList<Point> pieces, Point initial, int direction, int maxPositionX, int maxPositionY, boolean game){
		setPieces(pieces);
		getPieces().add(initial);
		apple = new Apple(new Point(50,50));
		setDirection(direction);
		this.maxPositionX = maxPositionX;
		this.maxPositionY = maxPositionY;
		setGame(game);
	}
	/**
	 * Costruttore vuoto
	 */
	public Snake(){
		this(new ArrayList<Point>(), new Point(0,0), STOP,300,300, true);
	}
	/**
	 * Costruttore
	 * @param initial Posizione iniziale dello snake
	 */
	public Snake(Point initial){
		this(new ArrayList<Point>(), initial, STOP,300,300, true);
	}
	/**
	 * Metodo per mangiare
	 */
	protected void eat(){
		pieces.add(apple.getPosition());
		Point p = new Point(getRnd(getMaxPositionX(), 0), getRnd(getMaxPositionY(), 0));
		p.move((int)(p.getX() - p.getX() % MOVEMENT), (int)(p.getY() - p.getY() % MOVEMENT));
		apple = new Apple(p);
	}
	/**
	 * Metodo per muovere lo snake
	 */
	protected void move(){
		Point temp = new Point(pieces.get(pieces.size()-1));
		if(direction == UP)
			temp.move((int)temp.getX(),(int)temp.getY() - MOVEMENT);
		else if(direction == RIGHT)
			temp.move((int)temp.getX() + MOVEMENT, (int)temp.getY());
		else if(direction == DOWN)
			temp.move((int)temp.getX(),(int)temp.getY() + MOVEMENT);
		else if(direction == LEFT)
			temp.move((int)temp.getX() - MOVEMENT,(int)temp.getY());
		if(direction != STOP)
			moveToPoint(temp);
	}
	/**
	 * Metodo per muoversi in un punto specifico
	 * @param p Punto in cui muoversi
	 */
	private void moveToPoint(Point p){
		p = new Point((int)p.getX()%getMaxPositionX(),(int)p.getY()%getMaxPositionY());
		if(pieces.indexOf(p) == -1){
			pieces.add(p);
			if(pieces.size() > START_LENGTH)
				pieces.remove(0);
			if(p.equals(apple.getPosition()))
				eat();
		}
		else
			setGame(false);
	}
	private int getRnd(int max, int min){
		return (int)(Math.random() * (max - min) + min);
	}
}
