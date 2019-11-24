/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Disciplina;
import br.com.argus.model.Professor;
import br.com.argus.util.MaskField;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Alterar_DisciplinaController implements Initializable {
    
    public static final String ALTERAR_DISCIPLINA = "/br/com/argus/view/Alterar_Disciplina.fxml" ;
    private Professor professor;
    private Disciplina disciplina;
    private List<Professor> professores;
    Ver_DisciplinasController ver_DisciplinasController;


    @FXML
    private Button add;

    @FXML
    private TextField nome;

    @FXML
    private TextField codigo;

    @FXML
    private TextField carga_horario;

    @FXML
    private ComboBox<Professor> professor_cbox;

    @FXML
    private Button voltar;
    

    @FXML
    void salvar(ActionEvent event) throws IOException {
        Cadastrar();
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(ALTERAR_DISCIPLINA).close();
    }
    
    void Cadastrar() throws IOException{
        try {
            //Facade.getInstance().buscarProfessor(professor);
            disciplina = ver_DisciplinasController.getD();
            disciplina.setNome(nome.getText());
            //disciplina.setProfessor(professor);
            disciplina.setCodigo( codigo.getText());
            disciplina.setCarga_horaria(carga_horario.getText());
            professor = professor_cbox.getValue();
            disciplina.setProfessor(professor);
            Facade.getInstance().inserirOuAtualizarDisciplina(disciplina);
            limpar();
            App.genericaStage(ALTERAR_DISCIPLINA).close();
            Mensagem.getInstance().mostrarMensagem("Cadastro Disciplina", "Cadastro Efetuado com Sucesso", Alert.AlertType.INFORMATION);
        } catch (BussinesException ex) {
             Mensagem.getInstance().mostrarMensagem("Cadastro Disciplina", "Erro ao Cadastrar, por favor tente novamente!", Alert.AlertType.ERROR);
        }
        
    }

    public Button getAdd() {
        return add;
    }

    public TextField getNome() {
        return nome;
    }

    public void setNome(TextField nome) {
        this.nome = nome;
    }

    public TextField getCodigo() {
        return codigo;
    }

    public void setCodigo(TextField codigo) {
        this.codigo = codigo;
    }

    public TextField getCarga_horario() {
        return carga_horario;
    }

    public void setCarga_horario(TextField carga_horario) {
        this.carga_horario = carga_horario;
    }

    public ComboBox<?> getProfessor_cbox() {
        return professor_cbox;
    }

    public void setProfessor_cbox(ComboBox<Professor> professor_cbox) {
        this.professor_cbox = professor_cbox;
    }

    public Button getVoltar() {
        return voltar;
    }

    public void setVoltar(Button voltar) {
        this.voltar = voltar;
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initDisciplinas();
        try {
            CarregarProfessor();
        } catch (BussinesException ex) {
            ex.printStackTrace();
        }
    }
    
        void CarregarProfessor() throws BussinesException{
        professores = Facade.getInstance().buscarTodosProfessores();
            MaskField.numericField(codigo);
        professor_cbox.getItems().setAll(professores);
       
    }

    void initDisciplinas(){
        disciplina = ver_DisciplinasController.getD();
        nome.setText(disciplina.getNome());
        //disciplina.setProfessor(professor);
        codigo.setText(disciplina.getCodigo());
        carga_horario.setText(disciplina.getCarga_horaria());
    }
    
    void limpar(){
        nome.clear();
        codigo.clear();
        carga_horario.clear();
    }

    
}
