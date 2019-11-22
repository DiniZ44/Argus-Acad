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
import br.com.argus.model.Carne_Pagamento;
import br.com.argus.model.LiquidaCarne;
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

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Cadastrar_CarneController implements Initializable {
    public final static String CADASTRAR_CARNE = "/br/com/argus/view/Cadastrar_Carne.fxml" ;
    private List<Aluno> alunos;
    private LiquidaCarne liquidaCarne;
    private Aluno aluno;
    private Carne_Pagamento carne_Pagamento;
    
    @FXML
    private ComboBox<Aluno> aluno_cbox;

    @FXML
    private DatePicker data_venc;

    @FXML
    void salvar(ActionEvent event) {
        cadastrar();
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRAR_CARNE).close();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            carregarAlunos();
        } catch (Exception ex) {
           ex.printStackTrace();
        }
    }

    void cadastrar(){
        
        liquidaCarne = new LiquidaCarne();
        carne_Pagamento = new Carne_Pagamento();
        aluno = aluno_cbox.getValue();
        carne_Pagamento.setAluno(aluno);
        carne_Pagamento.setData_vencimento(data_venc.getValue());
        carne_Pagamento.setValor(400);
        liquidaCarne.setCarne_Pagamento(carne_Pagamento);
        
        try {
            Facade.getInstance().inserirOuAtualizarLiquidaCarne(liquidaCarne);
            Mensagem.getInstance().mostrarMensagem("Carne", "Cadastro feito com sucesso", Alert.AlertType.INFORMATION);
        } catch (BussinesException ex) {
            Logger.getLogger(Cadastrar_CarneController.class.getName()).log(Level.SEVERE, null, ex);
            Mensagem.getInstance().mostrarMensagem("Carne", "Erro ao cadastrar carne ", Alert.AlertType.ERROR);
        }
    
    }
    
    void carregarAlunos() throws Exception{
        alunos = Facade.getInstance().buscarTodosAlunos();
        aluno_cbox.getItems().setAll(alunos);
        
    }
        
    
}
