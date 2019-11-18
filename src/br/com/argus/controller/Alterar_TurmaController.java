/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Alterar_TurmaController implements Initializable {
    
    

    public static final String ALTERAR_TURMA ="/br/com/argus/view/Alterar_Turma.fxml" ;
    private Disciplina disciplina;
    private static Turma turma;
    private Aluno aluno;
    private Ver_TurmaController turmaController;

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
    private TextField anoLetivo;


    @FXML
    void salvar(ActionEvent event) {
        cadastrar();
    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(ALTERAR_TURMA).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      initTurma();
    }
    
    void cadastrar(){
        turma = turmaController.getT();
     //   turma.setAluno(aluno);
       // turma.setDisciplina(disciplina);
       turma.setNome(nome.getText());
              turma.setAnoLetivo(anoLetivo.getAnchor());
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
        anoLetivo.clear();
    
    }
    
    void carregarCombo(){
    
    }
    
    void initTurma(){
        turma = turmaController.getT();
        nome.setText(turma.getNome());
        turma.setId(turma.getId());
        
    
    }

    public static Turma getTurma() {
        return turma;
    }

    public static void setTurma(Turma turma) {
        Alterar_TurmaController.turma = turma;
    }
    
    
}
