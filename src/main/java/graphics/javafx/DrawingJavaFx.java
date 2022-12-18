package graphics.javafx;

import graphics.DrawingApi;
import graphics.Properties;
import javafx.scene.canvas.GraphicsContext;

public class DrawingJavaFx implements DrawingApi {
    private final GraphicsContext graphics;

    public DrawingJavaFx(GraphicsContext context) {
        this.graphics = context;
    }

    @Override
    public long getDrawingAreaWidth() {
        return Properties.APPLICATION_WIDTH;
    }

    @Override
    public long getDrawingAreaHeight() {
        return Properties.APPLICATION_HEIGHT;
    }

    @Override
    public void drawCircle(double x, double y, double radius) {
        graphics.fillOval(x - radius / 2, y - radius / 2, radius, radius);
    }

    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        graphics.moveTo(x1, y1);
        graphics.lineTo(x2, y2);
        graphics.stroke();
    }

    @Override
    public void draw() {}
}
