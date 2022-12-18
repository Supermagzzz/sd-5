import graph.EdgeList;
import graph.EdgeMatrix;
import graphics.DrawingApi;
import graphics.awt.DrawingAwt;
import graphics.javafx.DrawingJavaFx;
import graphics.javafx.DrawingJavaFxApplication;

public class Main {
    private static void printUsage() {
        System.err.println("Usage: [list|matrix] [awt|javafx]");
        System.exit(0);
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            printUsage();
        }
        DrawingApi api = null;
        if (args[1].equals("awt")) {
            api = new DrawingAwt();
        } else if (args[1].equals("javafx")) {
            DrawingJavaFxApplication application = DrawingJavaFxApplication.launch();
            api = new DrawingJavaFx(application.getGraphicsContext());
        } else {
            printUsage();
        }
        if (args[0].equals("list")) {
            new EdgeList(api).drawGraph();
        } else if (args[0].equals("matrix")) {
            new EdgeMatrix(api).drawGraph();
        } else {
            printUsage();
        }
    }
}
