import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class FourBallsOOP extends PApplet {

    public static final int HEIGHT = 480;
    public static final int WIDTH = 640;
    private final int OFFSET = HEIGHT / 5;
    private final List<Ball> ballsList = new ArrayList<>();
    
    public static void main(String[] args) {
        PApplet.main("FourBallsOOP");
    }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }
    
    @Override
    public void setup() {
        for(int i=1; i<=4; i++) {
            ballsList.add(new Ball(0, i*OFFSET, i, 0, 10));
        }
    }

    @Override
    public void draw() {
        for(Ball ball: ballsList) {
            ball.draw();
            ball.update();
        }
    }

    private class Ball {
        
        private int x;
        private int y;
        private int final dx;
        private int final dy;
        private int final diameter;
        
        public Ball(int xPos, int yPos, int dx, int dy, int diameter) {
            this.x = xPos;
            this.y = yPos;
            this.dx = dx;
            this.dy = dy;
            this.diameter = diameter;
        }
        
        private void draw() {
            ellipse(x, y, diameter, diameter);
        }
        
        private void update() {
            x+=dx;
            y+=dy;
        }
    }

}
