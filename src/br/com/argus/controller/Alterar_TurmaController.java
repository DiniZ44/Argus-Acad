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
public class Alterar_TurmaController implements Initializable {
    
    

    public static final String ALTERAR_TURMA ="/br/com/argus/view/Alterar_Turma.fxml" ;
    private Disciplina disciplina;
    private List<Disciplina> disciplinas;
    private static Turma turma;
    private Ver_TurmaController turmaController;


    @FXML
    private TextField nome;
    
    @FXML
    private ComboBox<?> alunos_cbox;

    @FXML
    private ComboBox<Disciplina> disciplina_cbox1;
    
    @FXML
    private TextField anoLetivo;
    
    @FXML
    private TextField matricula_aluno;
    
    @FXML
    void salvar_aluno(ActionEvent event) {

    }

    @FXML
    void salvar_disciplina(ActionEvent event) {

    }

    @FXML
    void salvar(ActionEvent event) throws IOException {
        cadastrar();
    }
    
    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(ALTERAR_TURMA).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      initTurma();
        try {
            carregaeDisciplinas();
        } catch (BussinesException ex) {
            Logger.getLogger(Alterar_TurmaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void cadastrar() throws IOException{
        turma = turmaController.getT();
       turma.setNome(nome.getText());
        turma.setAnoLetivo(anoLetivo.getText());
        disciplina = disciplina_cbox1.getValue();
        turma.setDisciplina(disciplina);
       
                  try {
                Facade.getInstance().inserirOuAtualizarTurma(turma);
                Mensagem.getInstance().mostrarMensagem("Cadastro Turma", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limpar();
                App.genericaStage(ALTERAR_TURMA).close();
                //carregarCombo();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Turma", "Erro ao cadastrar Turma", Alert.AlertType.ERROR);
            }
 
    }
    
    void limpar(){
        nome.clear();
        anoLetivo.clear();
    
    }
    
    void initTurma(){
        turma = turmaController.getT();
        nome.setText(turma.getNome());
        turma.setId(turma.getId());
        
    
    }
    
    void carregaeDisciplinas() throws BussinesException{
       disciplinas = Facade.getInstance().buscarTodosDisciplinas();
        MaskField.numericField(anoLetivo);
       disciplina_cbox1.getItems().setAll(disciplinas);
    }

    public static Turma getTurma() {
        return turma;
    }

    public static void setTurma(Turma turma) {
        Alterar_TurmaController.turma = turma;
    }
    
    
}
