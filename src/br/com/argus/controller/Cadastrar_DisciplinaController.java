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

public class Cadastrar_DisciplinaController implements Initializable{
    
    public static final String CADASTRO_DISCIPLINA = "/br/com/argus/view/Cadastrar_Disciplina.fxml" ;
    private Professor professor;
    private List<Professor> professores;
    private Disciplina disciplina;
    Ver_DisciplinasController ver_DisciplinasController;

    @FXML
    private Button salvar_button;

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
    void salvar(ActionEvent event) {
        Cadastrar();
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_DISCIPLINA).close();
    }
    
    void Cadastrar(){
        try {

            disciplina = new Disciplina();
            disciplina.setNome(nome.getText());
            professor = professor_cbox.getValue();
            disciplina.setProfessor(professor);
            disciplina.setCodigo( codigo.getText());
            disciplina.setCarga_horaria(carga_horario.getText());
            Facade.getInstance().inserirOuAtualizarDisciplina(disciplina);
            limpar();
            Mensagem.getInstance().mostrarMensagem("Cadastro Disciplina", "Cadastro Efetuado com Sucesso", Alert.AlertType.INFORMATION);
        } catch (BussinesException ex) {
             Mensagem.getInstance().mostrarMensagem("Cadastro Disciplina", "Erro ao Cadastrar, por favor tente novamente!", Alert.AlertType.ERROR);
        }
        
    }

    public Button getSalvar_button() {
        return salvar_button;
    }

    public void setSalvar_button(Button salvar_button) {
        this.salvar_button = salvar_button;
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
    
    void limpar(){
        nome.clear();
        codigo.clear();
        carga_horario.clear();
        
    }

}

