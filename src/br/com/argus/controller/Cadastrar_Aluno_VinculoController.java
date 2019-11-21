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
import br.com.argus.model.VinculoAlunoTurma;
import br.com.argus.util.MaskField;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Cadastrar_Aluno_VinculoController implements Initializable {
    private final static String CADASTRAR_MATRICULA = "/br/com/argus/view/Cadastrar_Aluno_Vinculo.fxml";
    private List<Aluno> alunos;
    private Aluno aluno;
    private VinculoAlunoTurma vinculoAlunoTurma;
    
    @FXML
    private ComboBox<Aluno> aluno_cbox;

    @FXML
    private TextField matricula_aluno;

    @FXML
    void salvar(ActionEvent event) {
        cadastrar();

    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRAR_MATRICULA).close();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            carregarCombo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    void cadastrar(){
        vinculoAlunoTurma = new VinculoAlunoTurma();
        aluno = aluno_cbox.getValue();
        aluno.setMatricula(matricula_aluno.getText());
        vinculoAlunoTurma.setAluno(aluno);
        try {
            Facade.getInstance().inserirOuAtualizarAluno(aluno);
            Facade.getInstance().inserirOuAtualizarVincAlunoTurma(vinculoAlunoTurma);
            Mensagem.getInstance().mostrarMensagem("Cadastro Matricula", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
            limpar();
        } catch (BussinesException ex) {
            Mensagem.getInstance().mostrarMensagem("Cadastro Matricula", "Erro ao realizar matricula", Alert.AlertType.ERROR);
            ex.printStackTrace();
        }
    }

    void carregarCombo() throws Exception{
        
        alunos = Facade.getInstance().buscarTodosAlunos();
        aluno_cbox.getItems().setAll(alunos);
        MaskField.numericField(matricula_aluno);
    
    }
    void limpar(){
        matricula_aluno.clear();
    }
    
}
