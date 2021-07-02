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
import br.com.argus.model.Coordenador;
import br.com.argus.model.ObservacaoAluno;
import br.com.argus.model.Usuario;
import br.com.argus.model.VinculoAlunoTurma;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Cadastrar_ObservacaoController implements Initializable {
    public static final String CADASTRAR_OBS = "/br/com/argus/view/Cadastrar_Observacao.fxml" ;
    private List<Aluno> alunos;
    private Aluno aluno;
    private ObservacaoAluno observacaoAluno;
    private static Coordenador coordenador;
    private static Usuario usuario;
    private LoginController loginController;
    
    @FXML
    private Label label_coord;

    @FXML
    private ComboBox<Aluno> cbox_vinculo;

    @FXML
    private TextArea observacao;

    @FXML
    private DatePicker data;

    @FXML
    void salvar(ActionEvent event) {
        cadastrar();
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRAR_OBS).close();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        intiCoord();
        try {
            carregarVinculo();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }    
    void carregarVinculo() throws BussinesException, Exception{
        alunos = Facade.getInstance().buscarTodosAlunos();
        cbox_vinculo.getItems().setAll(alunos);
    }
    void intiCoord(){
        usuario = loginController.getU();
        label_coord.setText(usuario.getNome());
    }
    
    void cadastrar(){ 
        usuario = loginController.getU();
        observacaoAluno = new ObservacaoAluno();
        aluno = cbox_vinculo.getValue();
        observacaoAluno.setAluno(aluno);
        observacaoAluno.setData(data.getValue());
        observacaoAluno.setCoordenador((Coordenador) usuario);
        observacaoAluno.setDescricao(observacao.getText());
        
        try {
                Facade.getInstance().inserirOuAtualizarObsAluno(observacaoAluno);
                Mensagem.getInstance().mostrarMensagem("Cadastro", "Cadastro feito com sucesso", Alert.AlertType.INFORMATION);
                observacao.clear();
            try {
                App.genericaStage(CADASTRAR_OBS).close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            } catch (BussinesException ex) {
                ex.printStackTrace();
               Mensagem.getInstance().mostrarMensagem("Cadastro", "Erro ao cadastrar ", Alert.AlertType.ERROR);
            }
        
    
    }
    
    
}
