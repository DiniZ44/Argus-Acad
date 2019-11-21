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
import br.com.argus.model.DisciplinaTurma;
import br.com.argus.model.Turma;
import br.com.argus.model.VinculoAlunoTurma;
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
    private List<VinculoAlunoTurma> vinculosAlunoTurmas;
    private static Turma turma;
    private static DisciplinaTurma disciplinaTurma, novaDisciplinaTurma;
    private Ver_TurmaController turmaController;
    private VinculoAlunoTurma vinculoAlunoTurma;


    @FXML
    private TextField nome;
    
    @FXML
    private ComboBox<VinculoAlunoTurma> alunos_cbox;

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
    void salvar_disciplina(ActionEvent event) throws IOException {
        cadastrarDisciplina();
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
        
        disciplinaTurma = turmaController.getDt();
        turma.setNome(nome.getText());
        turma.setAnoLetivo(anoLetivo.getText());
        disciplinaTurma.setTurma(turma);
        disciplina = disciplina_cbox1.getValue();
        disciplinaTurma.setDisciplina(disciplina);
       
                  try {
                Facade.getInstance().buscarDisciplinaTurma(disciplinaTurma);
                Mensagem.getInstance().mostrarMensagem("Cadastro Turma", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limpar();
                App.genericaStage(ALTERAR_TURMA).close();
                //carregarCombo();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Turma", "Erro ao cadastrar Turma", Alert.AlertType.ERROR);
            }
 
    }
    
    void cadastrarDisciplina() throws IOException{
        
        disciplinaTurma = turmaController.getDt();
        disciplina = disciplina_cbox1.getValue();
        novaDisciplinaTurma = new DisciplinaTurma();
        novaDisciplinaTurma.setTurma(disciplinaTurma.getTurma());
        novaDisciplinaTurma.setDisciplina(disciplina);
            try {
                Facade.getInstance().inserirOuAtualizarDisciplinaTurma(novaDisciplinaTurma);
                Mensagem.getInstance().mostrarMensagem("Cadastro Turma", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                //carregarCombo();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Turma", "Erro ao cadastrar Turma", Alert.AlertType.ERROR);
            }
        
    }
    void cadastrarAluno() throws IOException{
    
    }
    
    void limpar(){
        nome.clear();
        anoLetivo.clear();
    
    }
    
    void initTurma(){
        
        disciplinaTurma = turmaController.getDt();
//        turma = turmaController.getT();
//        nome.setText(turma.getNome());
//        turma.setId(turma.getId());
          nome.setText(disciplinaTurma.getTurma().getNome());
          anoLetivo.setText(disciplinaTurma.getTurma().getAnoLetivo());
        
    
    }
    
    void carregaeDisciplinas() throws BussinesException{
       disciplinas = Facade.getInstance().buscarTodosDisciplinas();
        MaskField.numericField(anoLetivo);
       disciplina_cbox1.getItems().setAll(disciplinas);
    }
    
        void carregarAluno() throws BussinesException{
        vinculosAlunoTurmas = Facade.getInstance().buscarTodosVincAlunoTurma();
        alunos_cbox.getItems().setAll(vinculosAlunoTurmas);
    }

    public static Turma getTurma() {
        return turma;
    }

    public static void setTurma(Turma turma) {
        Alterar_TurmaController.turma = turma;
    }
    
    
}
