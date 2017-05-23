package Gui;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Optional;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Optionen extends Dialog<ButtonType> {

	String hNS = "";
	String hS = "";
	String bNS = "";
	String bS = "";
	String fNS = "";
	String fS = "";
	double sVal = 0;
	boolean tVal = false;

	ButtonType buttonTypeOk = new ButtonType("Ok", ButtonData.LEFT);
	ButtonType buttonTypeReset = new ButtonType("Reset");
	ButtonType buttonTypeBack = new ButtonType("Back", ButtonData.RIGHT);
	TabPane tPane = new TabPane();
	Tab allgemein = new Tab("Allgemein");
	GridPane allgemeinP = new GridPane();
	Tab fortg = new Tab("Fortgeschrittene Einstellungen");
	GridPane fortgP = new GridPane();

	private ObservableList<String> options = FXCollections.observableArrayList("", "Schwarz", "Grau", "Weiß", "Blau",
			"Rot", "Gelb", "Grün");

	Label h = new Label("Hintergrund: ");
	ComboBox hCb = new ComboBox(options);

	Label b = new Label("Border: ");
	ComboBox bCb = new ComboBox(options);

	Label f = new Label("Felder: ");
	ComboBox fCb = new ComboBox(options);

	Label m = new Label("Musiklautstärke:");
	Slider slider = new Slider();
	ToggleButton mute = new ToggleButton();
	Image muted = new Image("muted.png");
	Image unmuted = new Image("unmuted.png");
	Image unmuted0 = new Image("unmuted0.png");
	Image unmuted1 = new Image("unmuted1.png");
	Image unmuted2 = new Image("unmuted2.png");

	TextField hTf = new TextField();
	TextField bTf = new TextField();
	TextField fTf = new TextField();

	@SuppressWarnings("unchecked")
	public Optionen(int height, int width) {
		try {
			load();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		hCb.getSelectionModel().select(hNS);
		bCb.getSelectionModel().select(bNS);
		fCb.getSelectionModel().select(fNS);

		//
		System.out.println(tVal);

		if (tVal) {
			slider.setValue(0);
			mute.setGraphic(new ImageView(muted));
		} else {
			slider.setValue(sVal);
		}
		mute.setGraphic(new ImageView(muted));
		hTf.setText(hS);
		bTf.setText(bS);
		fTf.setText(fS);

		this.setTitle("Optionen");
		this.setHeight(800);
		this.setWidth(600);
		this.setResizable(false);
		tPane.getTabs().addAll(allgemein, fortg);
		allgemein.setContent(allgemeinP);
		allgemein.setClosable(false);
		fortg.setContent(fortgP);
		fortg.setClosable(false);
		allgemeinP.setAlignment(Pos.CENTER);
		fortgP.setAlignment(Pos.CENTER);

		h.setPrefHeight(20);
		b.setPrefHeight(20);
		f.setPrefHeight(20);
		m.setPrefHeight(20);

		hCb.getSelectionModel().select(3);
		hCb.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue observable, String oldValue, String newValue) {
				if (newValue.equals("Schwarz")) {
					hNS = "Schwarz";
					hS = "000000";
					hTf.setText(hS);
				}
				if (newValue.equals("Grau")) {
					hNS = "Grau";
					hS = "C3C3C3";
					hTf.setText(hS);
				}
				if (newValue.equals("Weiß")) {
					hNS = "Weiß";
					hS = "FFFFFF";
					hTf.setText(hS);
				}
				if (newValue.equals("Blau")) {
					hNS = "Blau";
					hS = "00A2E8";
					hTf.setText(hS);
				}
				if (newValue.equals("Rot")) {
					hNS = "Rot";
					hS = "ED1C24";
					hTf.setText(hS);
				}
				if (newValue.equals("Gelb")) {
					hNS = "Gelb";
					hS = "FFF200";
					hTf.setText(hS);
				}
				if (newValue.equals("Gruen")) {
					hNS = "Grün";
					hS = "22B14C";
					hTf.setText(hS);
				}
			}
		});
		bCb.getSelectionModel().select(1);
		bCb.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue observable, String oldValue, String newValue) {
				if (newValue.equals("Schwarz")) {
					bNS = "Schwarz";
					bS = "000000";
					bTf.setText(bS);
				}
				if (newValue.equals("Grau")) {
					bNS = "Grau";
					bS = "C3C3C3";
					bTf.setText(bS);
				}
				if (newValue.equals("Weiß")) {
					bNS = "Weiß";
					bS = "FFFFFF";
					bTf.setText(bS);
				}
				if (newValue.equals("Blau")) {
					bNS = "Blau";
					bS = "00A2E8";
					bTf.setText(bS);
				}
				if (newValue.equals("Rot")) {
					bNS = "Rot";
					bS = "ED1C24";
					bTf.setText(bS);
				}
				if (newValue.equals("Gelb")) {
					bNS = "Gelb";
					bS = "FFF200";
					bTf.setText(bS);
				}
				if (newValue.equals("Grün")) {
					bNS = "Grün";
					bS = "22B14C";
					bTf.setText(bS);
				}
			}
		});
		fCb.getSelectionModel().select(2);
		fCb.valueProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue observable, String oldValue, String newValue) {
				if (newValue.equals("Schwarz")) {
					fNS = "Schwarz";
					fS = "000000";
					fTf.setText(fS);
				}
				if (newValue.equals("Grau")) {
					fNS = "Grau";
					fS = "C3C3C3";
					fTf.setText(fS);
				}
				if (newValue.equals("Weiß")) {
					fNS = "Weiß";
					fS = "FFFFFF";
					fTf.setText(fS);
				}
				if (newValue.equals("Blau")) {
					fNS = "Blau";
					fS = "00A2E8";
					fTf.setText(fS);
				}
				if (newValue.equals("Rot")) {
					fNS = "Rot";
					fS = "ED1C24";
					fTf.setText(fS);
				}
				if (newValue.equals("Gelb")) {
					fNS = "Gelb";
					fS = "FFF200";
					fTf.setText(fS);
				}
				if (newValue.equals("Grün")) {
					fNS = "Grün";
					fS = "22B14C";
					fTf.setText(fS);
				}
			}
		});

		// c"", "Schwarz", "Grau", "Weiß", "Blau", "Rot", "Gelb", "Grün");

		hTf.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (hTf.getText().length() == 6) {
					if (hTf.getText().equalsIgnoreCase("000000")) {
						hNS = "Schwarz";
						hS = "000000";
						hCb.getSelectionModel().select(1);
					} else if (hTf.getText().equalsIgnoreCase("C3C3C3")) {
						hNS = "Grau";
						hS = "C3C3C3";
						hCb.getSelectionModel().select(2);
					} else if (hTf.getText().equalsIgnoreCase("FFFFFF")) {
						hNS = "Weiß";
						hS = "FFFFFF";
						hCb.getSelectionModel().select(3);
					} else if (hTf.getText().equalsIgnoreCase("00A2E8")) {
						hNS = "Blau";
						hS = "00A2E8";
						hCb.getSelectionModel().select(4);
					} else if (hTf.getText().equalsIgnoreCase("ED1C24")) {
						hNS = "Rot";
						hS = "ED1C24";
						hCb.getSelectionModel().select(5);
					} else if (hTf.getText().equalsIgnoreCase("FFF200")) {
						hNS = "Gelb";
						hS = "FFF200";
						hCb.getSelectionModel().select(6);
					} else if (hTf.getText().equalsIgnoreCase("22B14C")) {
						hNS = "Grün";
						hS = "22B14C";
						hCb.getSelectionModel().select(7);
					} else {
						hNS = "";
						hS = hTf.getText();
						hCb.getSelectionModel().selectFirst();
					}
				}
			}
		});
		bTf.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub

			}
		});
		fTf.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub

			}
		});

		allgemeinP.add(h, 1, 1);
		allgemeinP.add(hCb, 2, 1);

		allgemeinP.add(b, 1, 2);
		allgemeinP.add(bCb, 2, 2);

		allgemeinP.add(f, 1, 3);
		allgemeinP.add(fCb, 2, 3);

		allgemeinP.add(m, 1, 4);
		slider.setMin(0);
		slider.setMax(100);
		slider.setShowTickLabels(false);
		slider.setShowTickMarks(false);
		slider.setMajorTickUnit(50);
		slider.setMinorTickCount(5);
		slider.setBlockIncrement(10);
		slider.setPrefHeight(20);
		// Change Voloume
		slider.valueProperty().addListener(new ChangeListener<Number>() {
			public void changed(ObservableValue<? extends Number> ov, Number old_val, Number new_val) {
				if (slider.getValue() >= 75) {
					mute.setSelected(false);
					mute.setGraphic(new ImageView(unmuted));
				} else if (slider.getValue() >= 50) {
					mute.setSelected(false);
					mute.setGraphic(new ImageView(unmuted2));
				} else if (slider.getValue() >= 25) {
					mute.setSelected(false);
					mute.setGraphic(new ImageView(unmuted1));
				} else if (slider.getValue() == 0) {
					mute.setSelected(false);
					mute.setGraphic(new ImageView(muted));
				} else {
					mute.setSelected(false);
					mute.setGraphic(new ImageView(unmuted0));
				}
			}
		});
		mute.setPrefHeight(10);
		mute.setPrefWidth(10);
		if (slider.getValue() >= 75) {
			mute.setSelected(false);
			mute.setGraphic(new ImageView(unmuted));
		} else if (slider.getValue() >= 50) {
			mute.setSelected(false);
			mute.setGraphic(new ImageView(unmuted2));
		} else if (slider.getValue() >= 25) {
			mute.setSelected(false);
			mute.setGraphic(new ImageView(unmuted1));
		} else if (slider.getValue() == 0) {
			mute.setSelected(false);
			mute.setGraphic(new ImageView(muted));
		} else {
			mute.setSelected(false);
			mute.setGraphic(new ImageView(unmuted0));
		}
		mute.setOnAction(new EventHandler<javafx.event.ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				if (mute.isSelected() && slider.getValue() != 0) {
					mute.setGraphic(new ImageView(muted));
					sVal = slider.getValue();
					slider.setValue(0);
				} else {
					slider.setValue(sVal);
					if (slider.getValue() >= 75) {
						mute.setGraphic(new ImageView(unmuted));
					} else if (slider.getValue() >= 50) {
						mute.setGraphic(new ImageView(unmuted2));
					} else if (slider.getValue() >= 25) {
						mute.setGraphic(new ImageView(unmuted1));
					} else if (slider.getValue() == 0) {
						mute.setGraphic(new ImageView(muted));
					} else {
						mute.setGraphic(new ImageView(unmuted0));
					}
				}
			}
		});
		allgemeinP.add(slider, 2, 4);
		allgemeinP.add(mute, 3, 4);

		fortgP.add(new Label("Hintergrund:	# "), 1, 1);
		fortgP.add(hTf, 2, 1);
		fortgP.add(new Label("Border:		# "), 1, 2);
		fortgP.add(bTf, 2, 2);
		fortgP.add(new Label("Felder:		# "), 1, 3);
		fortgP.add(fTf, 2, 3);

		tPane.setPrefHeight(height);
		tPane.setPrefWidth(width);
		this.setHeight(height);
		this.setWidth(width);
		this.getDialogPane().setContent(tPane);
		this.onCloseRequestProperty();
		this.getDialogPane().getButtonTypes().setAll(buttonTypeOk, buttonTypeReset, buttonTypeBack);
		Optional<ButtonType> result = this.showAndWait();
		if (result.get() == buttonTypeOk) {
			DataOutputStream dos;
			String path = "Settings/settings.dat";
			Paths.get(path);
			File f = new File(path);
			f.getParentFile().mkdirs();
			try {
				f.createNewFile();
				dos = new DataOutputStream(new FileOutputStream(f));
				dos.writeUTF("" + hCb.getSelectionModel().getSelectedItem());
				dos.writeUTF("" + bCb.getSelectionModel().getSelectedItem());
				dos.writeUTF("" + fCb.getSelectionModel().getSelectedItem());
				dos.writeUTF(hTf.getText());
				dos.writeUTF(bTf.getText());
				dos.writeUTF(fTf.getText());
				if (slider.getValue() != 0) {
					dos.writeDouble(slider.getValue());
				} else {
					dos.writeDouble(sVal);
				}
				if (mute.getGraphic() == new ImageView(muted)) {
					dos.writeBoolean(true);
				} else {
					dos.writeBoolean(false);
				}
				dos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (result.get() == buttonTypeReset) {
			DataOutputStream dos;
			String path = "Settings/settings.dat";
			Paths.get(path);
			File f = new File(path);
			f.getParentFile().mkdirs();
			try {
				f.createNewFile();
				dos = new DataOutputStream(new FileOutputStream(f));
				dos.writeUTF("Weiß");
				dos.writeUTF("Schwarz");
				dos.writeUTF("Grau");
				dos.writeUTF("ffffff");
				dos.writeUTF("000000");
				dos.writeUTF("C3C3C3");
				dos.writeDouble(40);
				dos.writeBoolean(false);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			hCb.getSelectionModel().select(3);
			bCb.getSelectionModel().select(1);
			fCb.getSelectionModel().select(2);
			slider.setValue(40);
			hTf.setText("ffffff");
			bTf.setText("000000");
			fTf.setText("C3C3C3");
			this.showAndWait();
		}
	}

	public void load() throws IOException {
		DataInputStream dis = new DataInputStream(new FileInputStream(new File("Settings/settings.dat")));
		hNS = dis.readUTF();
		bNS = dis.readUTF();
		fNS = dis.readUTF();
		hS = dis.readUTF();
		bS = dis.readUTF();
		fS = dis.readUTF();
		sVal = dis.readDouble();
		tVal = dis.readBoolean();
		dis.close();
	}
}