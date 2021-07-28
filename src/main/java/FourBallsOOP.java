import processing.core.PApplet;

import java.util.ArrayList;
import java.util.List;

public class FourBallsOOP extends PApplet {

    public static final int HEIGHT = 480;
    public static final int WIDTH = 640;
    public static final int OFFSET = HEIGHT / 5;
    private List<Ball> ballsList = new ArrayList<>();
    
    public static void main(String[] args) {
        PApplet.main("FourBallsOOP");
    }

    @Override
    public void settings() {
        super.settings();
        size(WIDTH, HEIGHT);
    }

    private class Ball {
        
        private int x;
        private int y;
        private final int dx;
        private final int dy;
        private final int diameter;
        
        public Ball(int xPos, int yPos, int dx, int dy, int diameter, PApplet sketch) {
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

    @Override
    public void setup() {
        for(int i=1; i<=4; i++) {
            ballsList.add(new Ball(0, i*OFFSET, i, 0, 10, this));
        }
    }

    @Override
    public void draw() {
        for(Ball ball: ballsList) {
            ball.draw();
            ball.update();
        }
    }
}
