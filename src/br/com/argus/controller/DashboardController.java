package br.com.argus.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class DashboardController implements Initializable{
    

    @FXML
    private Button aluno_button;

    @FXML
    private Button disciplinas_button;

    @FXML
    private Button prof_button;

    @FXML
    private Button finan_button;

    @FXML
    private Pane pane_adm;

    @FXML
    private Button config_button;

    @FXML
    private Button usuario_button;

    @FXML
    private Pane panel_home;

    @FXML
    private Button home_button;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

}

