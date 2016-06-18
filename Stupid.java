public class Stupid{
	public static SnakeGUI snakeGUI;
	public static long t1;
	public static void main(String[] args) {
		snakeGUI = new SnakeGUI("Snake");
		snakeGUI.setVisible(true);
		Snake snake = snakeGUI.snake;
		while(snake.getGame()){
			if((System.currentTimeMillis() - t1) > snakeGUI.timer){
				snake.move();
				t1 = System.currentTimeMillis();
				snakeGUI.repaint();
			}
		}
		System.exit(0);
	}
}
