package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Aluno;
import br.com.argus.model.Contato;
import br.com.argus.model.Resp_Financeiro;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Ver_AlunosController  implements Initializable{
    
    public static final String CADASTRO_ALUNO ="/br/com/argus/view/Cadastrar_Aluno.fxml" ;
    public static final String VER_ALUNOS = "/br/com/argus/view/Ver_Alunos.fxml" ;
    
    private Aluno aluno;
    private List<Aluno> alunos;
    private List<Resp_Financeiro> responsaveis;
    private Contato contato;
    private Resp_Financeiro resp_Financeiro;
    private Facade facada;
    
    @FXML
    private TableView<Aluno> tabela_aluno;
    
    @FXML
    private TableColumn<Aluno, String> table_name;

    @FXML
    private TableColumn<Aluno,String> table_cpf;

    @FXML
    private TableColumn<Aluno, String>table_mae;

    @FXML
    private TableColumn<Aluno,LocalDate> table_date;

    @FXML
    private TableColumn<Aluno,String> table_contato;

    @FXML
    private TableColumn<Aluno,String> table_resp;

    @FXML
    private TextField pesquisa;

    @FXML
    private Button buscar;

    @FXML
    private Button add;

    @FXML
    private Button atualizar;

    @FXML
    void sicronizar(ActionEvent event) throws IOException {
        App.genericaStage(VER_ALUNOS);
    }

    @FXML
    void buscar_aluno(ActionEvent event) {


    }
   
    
    @FXML
    void adcionar_aluno(ActionEvent event) throws IOException, BussinesException {
        
        App.genericaStage(CADASTRO_ALUNO).show();
      
    }
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {
            atualizar_tabela(facada.getInstance().buscarTodosAlunos());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }


    
    void atualizar_tabela(List<Aluno> alunoList){
        table_name.setCellValueFactory(new PropertyValueFactory<>("nome"));
        table_cpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        table_contato.setCellValueFactory(new PropertyValueFactory("contato"));
        table_mae.setCellValueFactory(new PropertyValueFactory<>("mae"));
        table_resp.setCellValueFactory(new PropertyValueFactory("responsavel_financeiro"));
        table_date.setCellValueFactory(new PropertyValueFactory("data_nascimento"));
       
       tabela_aluno.getItems().setAll(alunoList);
        
    
    }
    
  
 
    
   

}

