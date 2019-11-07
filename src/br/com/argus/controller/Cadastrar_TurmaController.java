package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Aluno;
import br.com.argus.model.Disciplina;
import br.com.argus.model.Turma;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Cadastrar_TurmaController implements Initializable{
    public static final String CADASTRO_TURMA = "/br/com/argus/view/Cadastrar_Turma.fxml" ;
    private Disciplina disciplina;
    private Turma turma;
    private Aluno aluno;

    @FXML
    private Button salvar_button;

    @FXML
    private TextField nome;

    @FXML
    private ComboBox<?> alunos_cbox;

    @FXML
    private Button voltar;

    @FXML
    private ComboBox<?> disciplina_cbox1;

    @FXML
    void salvar(ActionEvent event) {
        cadastrar();
    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_TURMA).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
    }
    
    void cadastrar(){
        turma = new Turma();
     //   turma.setAluno(aluno);
       // turma.setDisciplina(disciplina);
       turma.setNome(nome.getText());
       //turma.setNota(nota.get;
       
                  try {
                Facade.getInstance().inserirOuAtualizarTurma(turma);
                Mensagem.getInstance().mostrarMensagem("Cadastro Turma", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limpar();
                //carregarCombo();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Turma", "Erro ao cadastrar Turma", Alert.AlertType.ERROR);
            }
 
    }
    
    void limpar(){
        nome.clear();
    
    }
    
    void carregarCombo(){
    
    }
}