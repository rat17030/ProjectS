package Gui;




import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			primaryStage.setTitle("SUDOKU");
			
			
			Label top = new Label("Sudoku");
			top.setFont(new Font("Arial", 30));
			Button start = new Button("Start");
			Button end = new Button("Exit");
			Button credits = new Button("Credits");
			Button website = new Button("Website");
			Button settings = new Button("Settings");
		
			
			
			end.setOnAction(ActionEvent -> Platform.exit());
			Spiel s = new Spiel();
			start.setOnAction(ActionEvent -> s.start(primaryStage));
			
			credits.setOnAction(new EventHandler<ActionEvent>() {


				public void handle(ActionEvent event) {
					Alert info = new Alert(AlertType.INFORMATION);
					info.setTitle("JJ Games and more");
					info.setContentText("Made By Jakob Ratzenböck , pfusched by Johannes Strobl");
					info.show();

				}
			});


		//	credits.setOnAction(value);
			
			settings.setPrefSize(90, 35);
			start.setPrefSize(90, 35);
			end.setPrefSize(90, 35);
			credits.setPrefSize(90 , 35);
			website.setPrefSize(90, 35);
			website.setTranslateX(60);
			
			settings.setTranslateX(150);
			end.setTranslateX(150);
			start.setTranslateX(150);
			credits.setTranslateX(250);
			
			settings.setTranslateY(70);
			credits.setTranslateY(-35);
			start.setTranslateY(35);
			end.setTranslateY(105);
			
			
			//website.setTranslateY(-30);
			top.setTranslateY(20);
			top.setTranslateX(140);
		
			
			
			
			VBox boxbottom = new VBox(website,credits);
			VBox box  = new VBox ();
			VBox boxtop = new VBox(top);
			
			
			box.getChildren().addAll( start,settings,end);
			root.setLeft(box);
			
			root.setTop(boxtop);
			root.setBottom(boxbottom);
			
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	

		

	
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
	
}
