package Gui;

import java.io.File;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Auswahl extends Application {

	final FileChooser fileChooser = new FileChooser();
	Stage stage;

	public Auswahl() {
	}

	@Override
	public void start(Stage primaryStage) {
		try {

			Random r = new Random();

			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			primaryStage.setTitle("Sudoku");

			Button easy = new Button("Einfach");
			Button normal = new Button("Normal");
			Button hard = new Button("Schwer");
			Button load = new Button("Spiel Laden");

			VBox oben = new VBox(easy, normal, hard);
			VBox unten = new VBox(load);

			easy.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					int q = r.nextInt(22) + 9;
					new Game(q);
					primaryStage.close();
				}
			});

			normal.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					int m = r.nextInt(11) + 31;
					new Game(m);
					primaryStage.close();
				}
			});

			hard.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					int h = r.nextInt(22) + 42;
					new Game(h);
					primaryStage.close();
				}
			});

			load.setOnAction(new EventHandler<ActionEvent>() {
				@Override
				public void handle(final ActionEvent e) {
					stage = primaryStage;
					configureFileChooser(fileChooser);
					File file = fileChooser.showOpenDialog(primaryStage);
					if (file != null) {
						openFile(file);
					}
				}
			});

			easy.setMaxSize(90, 40);
			easy.setTranslateX(120);
			easy.setTranslateY(70);

			normal.setMaxSize(90, 40);
			normal.setTranslateX(170);
			normal.setTranslateY(70);

			hard.setMaxSize(90, 40);
			hard.setTranslateX(220);
			hard.setTranslateY(70);

			load.setMaxSize(400, 20);
			load.setTranslateX(0);
			load.setTranslateY(-40);

			root.setTop(oben);
			root.setBottom(unten);

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.centerOnScreen();
			primaryStage.getIcons().add(new Image("ImagesAndMore/JJGames.png"));
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void configureFileChooser(final FileChooser fileChooser) {
		fileChooser.setTitle("View Sudoku");
		fileChooser.setInitialDirectory(
				new File(System.getProperty("user.dir") + System.getProperty("file.separator") + "savedGames"));
		fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Datei", "*.dat"));
	}

	private void openFile(File file) {
		new Game(file);
	}
}
