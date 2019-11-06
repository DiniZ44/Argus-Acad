package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Aluno;
import br.com.argus.model.Contato;
import br.com.argus.model.Endereco;
import br.com.argus.model.Resp_Financeiro;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Ver_AlunosController {
    
    public static final String CADASTRO_ALUNO ="/br/com/argus/view/Cadastrar_Aluno.fxml" ;
    
    private Aluno aluno;
    private List<Aluno> alunos;
    private List<Resp_Financeiro> responsaveis;
    private Contato contato;
    private Resp_Financeiro resp_Financeiro;
    
    @FXML
    private TableView<Aluno> tabela_aluno;
    
    @FXML
    private TableColumn<Aluno, String> table_name;

    @FXML
    private TableColumn<Aluno, String> table_cpf;

    @FXML
    private TableColumn<Aluno, String> table_mae;

    @FXML
    private TableColumn<Aluno, String> table_pai;

    @FXML
    private TableColumn<Aluno, LocalDate> table_date;

    @FXML
    private TableColumn<Aluno, Contato> table_contato;

    @FXML
    private TableColumn<Aluno, Resp_Financeiro> table_resp;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button buscar;

    @FXML
    private Button add;

    @FXML
    private Button atualizar;

    @FXML
    void atualizar_aluno(ActionEvent event) {

    }

    @FXML
    void buscar_aluno(ActionEvent event) {
       
        try {
            alunos = Facade.getInstance().buscarTodosAlunos();
            tabela_aluno.getItems().setAll(alunos);
        } catch (BussinesException ex) {
            
        }

    }
   
    
    @FXML
    void adcionar_aluno(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_ALUNO).show();
    }


    
    
  
 
    
   

}

