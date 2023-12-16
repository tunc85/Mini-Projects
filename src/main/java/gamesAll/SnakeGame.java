package gamesAll;


    import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Random;

    public class SnakeGame extends JFrame implements ActionListener, KeyListener {

        private static final int GRID_SIZE = 20;
        private static final int TILE_SIZE = 20;
        private static final int GAME_SPEED = 100; // in milliseconds

        private enum Direction {
            UP, DOWN, LEFT, RIGHT
        }

        private LinkedList<Point> snake;
        private Direction direction;
        private Point food;

        public SnakeGame() {
            setTitle("Snake Game");
            setSize(GRID_SIZE * TILE_SIZE, GRID_SIZE * TILE_SIZE);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLocationRelativeTo(null);

            snake = new LinkedList<>();
            snake.add(new Point(GRID_SIZE / 2, GRID_SIZE / 2));
            direction = Direction.RIGHT;

            generateFood();

            Timer timer = new Timer(GAME_SPEED, this);
            timer.start();

            addKeyListener(this);
            setFocusable(true);
        }

        private void generateFood() {
            Random rand = new Random();
            int x, y;
            do {
                x = rand.nextInt(GRID_SIZE);
                y = rand.nextInt(GRID_SIZE);
            } while (snake.contains(new Point(x, y)));

            food = new Point(x, y);
        }

        private void move() {
            Point head = snake.getFirst();
            Point newHead;

            switch (direction) {
                case UP:
                    newHead = new Point(head.x, (head.y - 1 + GRID_SIZE) % GRID_SIZE);
                    break;
                case DOWN:
                    newHead = new Point(head.x, (head.y + 1) % GRID_SIZE);
                    break;
                case LEFT:
                    newHead = new Point((head.x - 1 + GRID_SIZE) % GRID_SIZE, head.y);
                    break;
                case RIGHT:
                    newHead = new Point((head.x + 1) % GRID_SIZE, head.y);
                    break;
                default:
                    newHead = head;
            }

            if (snake.contains(newHead)) {
                gameOver();
                return;
            }

            snake.addFirst(newHead);

            if (newHead.equals(food)) {
                generateFood();
            } else {
                snake.removeLast();
            }
        }

        private void gameOver() {
            JOptionPane.showMessageDialog(this, "Game Over!", "Game Over", JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            move();
            repaint();
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);

            // Draw food
            g.setColor(Color.RED);
            g.fillRect(food.x * TILE_SIZE, food.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);

            // Draw snake
            g.setColor(Color.GREEN);
            for (Point point : snake) {
                g.fillRect(point.x * TILE_SIZE, point.y * TILE_SIZE, TILE_SIZE, TILE_SIZE);
            }

            Toolkit.getDefaultToolkit().sync();
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            switch (keyCode) {
                case KeyEvent.VK_UP:
                    if (direction != Direction.DOWN)
                        direction = Direction.UP;
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != Direction.UP)
                        direction = Direction.DOWN;
                    break;
                case KeyEvent.VK_LEFT:
                    if (direction != Direction.RIGHT)
                        direction = Direction.LEFT;
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != Direction.LEFT)
                        direction = Direction.RIGHT;
                    break;
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                SnakeGame snakeGame = new SnakeGame();
                snakeGame.setVisible(true);
            });
        }
    }


