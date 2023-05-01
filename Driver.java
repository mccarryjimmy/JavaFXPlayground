import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class Driver extends Application{
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    

    @Override
    public void start(Stage mainStage) throws Exception {
        HBox mainPane = new HBox(8);
        
        mainPane.setMaxWidth(750);
        mainStage.setTitle("I made a GUI!");
        setupControls(mainPane);
        Scene scene = new Scene(mainPane, 750, 500, Color.BLUE);
        scene.setFill(Color.BLUE);
        scene.setOnMouseDragReleased(e -> scene.setFill(Color.RED));
        mainStage.setScene(scene);
        mainStage.sizeToScene();
        mainStage.show();
    }

    private static void setupControls(Pane mainPane) {
        Button btn1 = new Button("Click me!");
        Button btn2 = new Button("Or click me!");
        Button btn3 = new Button("Don't click me");
        Button btn4 = new Button("Guess where I am");
        Button btn5 = new Button("Now try me!");
        Button resetButton = new Button("Reset");
        CheckBox checkbox = new CheckBox("What do I do?"); 
        checkbox.setSelected(false); 
        TextField text = new TextField("I like to walk around my house pretending to be a goblin");

        Label lbl1 = new Label("Some buttons");
        Label lbl2 = new Label("I'm a label");
        Label lbl3 = new Label("Holy shit he's cooking");

        Text leftText = new Text("Super");
        Text centerText = new Text("Auto");
        Text rightText = new Text("Pets");

        VBox leftPane = new VBox(8, leftText, btn1, btn2, lbl1);
        VBox centerPane = new VBox(8, centerText, btn3, btn4, lbl2);
        VBox rightPane = new VBox(8, rightText, btn5, resetButton, lbl3);
        VBox extraPane = new VBox(8, text);
        

        btn1.setOnAction(e -> lbl1.setText("This is button 1"));
        btn2.setOnAction(e -> lbl1.setText("This is button 2"));
        btn3.setOnAction(e -> lbl2.setText("This is button 3"));
        btn4.setOnAction(e -> lbl2.setText("Kid named finger"));
        btn5.setOnAction(e -> lbl3.setText("Let him cook"));
        resetButton.setOnAction(e -> {
            lbl1.setText("You hit reset");
            lbl2.setText("Congrats!");
            lbl3.setText("There's no more text");
        });
        checkbox.setOnAction(e -> {
            HBox hbox = new HBox(8);
            Scene scene = new Scene(hbox, 300, 200);
            hbox.getChildren().addAll(leftPane, centerPane, rightPane);
            
        });

        styleVBox(leftPane, Pos.TOP_LEFT);
        styleVBox(centerPane, Pos.CENTER);
        styleVBox(rightPane, Pos.BOTTOM_RIGHT);
        
        mainPane.getChildren().addAll(leftPane, centerPane, rightPane);
    }

    private static void setStage(Stage mainStage, Scene scene) {
        mainStage.setScene(scene);
    }

    private static void styleVBox(VBox panel, Pos pos) { 
        panel.setMinHeight(300);
        panel.setMinWidth(200);
        panel.setMaxHeight(600);
        panel.setMaxWidth(500);
        panel.setAlignment(pos);
    }

    private static void styleHBox(HBox panel, Pos pos) {
        panel.setMinHeight(100);
        panel.setMinWidth(300);
        panel.setMaxHeight(200);
        panel.setMaxWidth(750);
        panel.setAlignment(pos);
    }


    
}
