package com.tf.teamflowcode.GestionePresenze.GestionePresenzeInterface;

import java.io.IOException;
import java.time.LocalDate;

import com.tf.teamflowcode.GestioneAccount.GestioneAccountControl.AccountControl;
import com.tf.teamflowcode.Utils.BoundaryDBMS;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.fxml.FXMLLoader;

public class InterfacciaimpostaPeriodoRosso {

	Parent parent;
	Stage stage;
	Scene scene;

	@FXML
	private DatePicker datePicker1;

	@FXML
	private DatePicker datePicker2;

	AccountControl accountControl = new AccountControl();

	@FXML
	private Button buttonIndietro;

	BoundaryDBMS boundaryGestionePresenze = new BoundaryDBMS();

	@FXML
	void buttonConferma(ActionEvent event) throws IOException {
		LocalDate localDate = datePicker1.getValue();
		LocalDate localDate2 = datePicker2.getValue();

		if (localDate.isAfter(localDate2)) {
			parent = FXMLLoader.load(getClass()
					.getResource(
							"/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreGestioneFerie.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(parent, 810, 500);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Gestione Presenze");
			stage.show();
			return;
		}

		// mettere questo dentro la control GestioneFerieControl
		if (!boundaryGestionePresenze.controllaDateFerie(localDate)) {
			boundaryGestionePresenze.registraPeriodoRosso(localDate.toString(), localDate2.toString());
			parent = FXMLLoader.load(getClass()
					.getResource(
							"/com/tf/teamflowcode/Pannelli/fxml/PannelloConfermaGestioneFerie.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(parent, 810, 500);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Gestione Presenze");
			stage.show();
		} else {
			parent = FXMLLoader.load(getClass()
					.getResource(
							"/com/tf/teamflowcode/Pannelli/fxml/PannelloErroreGestioneFerie.fxml"));
			stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			scene = new Scene(parent, 810, 500);
			stage.setScene(scene);
			stage.setResizable(false);
			stage.setTitle("Gestione Presenze");
			stage.show();
		}
	}

	@FXML
	void buttonVaiIndietro(ActionEvent event) throws IOException {
		parent = FXMLLoader.load(getClass()
				.getResource(
						"/com/tf/teamflowcode/Pannelli/fxml/InterfacciaPrincipaleAmministratore.fxml"));
		stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		scene = new Scene(parent, 810, 500);
		stage.setScene(scene);
		stage.setResizable(false);
		stage.setTitle("Interfaccia Principale - Amministratore");
		stage.show();
	}
}