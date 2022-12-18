package graphics.javafx;

import graphics.Properties;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class DrawingJavaFxApplication extends Application {
    private GraphicsContext graphicsContext;
    private static final AtomicReference<DrawingJavaFxApplication> instance = new AtomicReference<>(null);
    private boolean prepared = false;

    public DrawingJavaFxApplication() {
        instance.set(this);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Canvas canvas = new Canvas(Properties.APPLICATION_WIDTH, Properties.APPLICATION_HEIGHT);
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        graphicsContext = canvas.getGraphicsContext2D();
        prepared = true;
    }

    public GraphicsContext getGraphicsContext() {
        return graphicsContext;
    }

    public static DrawingJavaFxApplication launch() {
        Thread applicationThread = new Thread(Application::launch);
        applicationThread.start();
        while (instance.get() == null) {}
        while (!instance.get().prepared) {}
        return instance.get();
    }
}
