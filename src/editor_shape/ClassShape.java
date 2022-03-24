package editor_shape;

import java.awt.*;

public class ClassShape extends Shape {
    Color myGray = new Color(200, 200, 200);

    public ClassShape(Point p) {
        x1 = p.x;
        y1 = p.y;
        width = 120;
        height = 180;
        shapeName = "Object Name";

        addPort();
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(myGray);
        g2.fillRect(x1, y1, width, height);
        g2.setColor(Color.BLACK);
        for (int i = 1; i <= 3; i++) {
            g2.drawRect(x1, y1, width, height / 3 * i);
        }
        g2.drawString(shapeName, x1 + (width - shapeName.length() * 6) / 2, y1 + 35);
    }
}
