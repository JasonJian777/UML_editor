package editor_shape;

import java.awt.*;
import java.awt.Point;

public class Port {
    public Point p;

    public Port(Point point) {

        p = point;
    }

    public void portDraw(Graphics2D g2) {
        g2.setColor(Color.BLACK);
        g2.fillRect(p.x - 5, p.y - 5, 10, 10);
    }

    public void move(int x, int y) {
        p.x += x;
        p.y += y;
    }
}
