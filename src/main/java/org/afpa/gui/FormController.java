package org.afpa.gui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import org.afpa.model.Client;

public class FormController {

    public Button btnAjouter;
    public Button btnSupprimer;
    public Button btnModifier;
    public TextField inputNom;
    public TextField inputPrenom;
    public TextField inputVille;

    public  TableView<Client> tableClient;

    public  TableColumn<Client, String> nomCol;
    public  TableColumn<Client, String> prenomCol;

    ObservableList<Client> model = FXCollections.observableArrayList();

    @FXML
    public void initialize() {

        model.add(new Client("Josh", "Homme", "Joshua Tree"));
        model.add(new Client("Dave", "Grohl", "Warren"));
        model.add(new Client("Krist", "Novoselic", "Compton"));
        model.add(new Client("Robert", "Trujillo", "Santa Monica"));

        prenomCol.setCellValueFactory(new PropertyValueFactory<>("prenom"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("nom"));

        tableClient.setItems(model);
    }


    public void addClient(ActionEvent actionEvent) {
        Client client = new Client(inputNom.getText(),inputPrenom.getText(), inputVille.getText());
        model.add(client);
    }

    public void deleteClient(ActionEvent actionEvent) {
        model.remove(tableClient.getSelectionModel().getSelectedItem());

    }

    public void updateClient(ActionEvent actionEvent) {
        if(tableClient.getSelectionModel().getSelectedIndex() != -1){

            int  index = tableClient.getSelectionModel().getSelectedIndex();
            Client client = new Client();
            client.setNom(inputNom.getText());
            client.setPrenom(inputPrenom.getText());
            client.setVille(inputVille.getText());
            model.set(index,client);

        }

    }

    public void getDetails(MouseEvent mouseEvent) {

        Client client = tableClient.getSelectionModel().getSelectedItem();
        inputNom.setText(client.getNom());
        inputPrenom.setText(client.getPrenom());
        inputVille.setText(client.getVille());
    }
}
