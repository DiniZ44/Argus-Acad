package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Aluno;
import br.com.argus.model.Contato;
import br.com.argus.model.Resp_Financeiro;
import br.com.argus.model.Usuario;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class Ver_AlunosController  implements Initializable{
    
    public static final String CADASTRO_ALUNO ="/br/com/argus/view/Cadastrar_Aluno.fxml" ;
    public static final String VER_ALUNOS = "/br/com/argus/view/Ver_Alunos.fxml" ;
    public static final String ALTERAR_ALUNO ="/br/com/argus/view/Alterar_Aluno.fxml" ;
    
    private Facade facada;
    private Cadastrar_AlunoController alunoController;
    private static Aluno a;
    
    @FXML
    private TableView<Aluno> tabela_aluno;
    
    @FXML
    private TableColumn<Aluno, String> table_name;

    @FXML
    private TableColumn<?, ?> table_turma;

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
    void sicronizar(ActionEvent event) throws IOException {
        try {
            atualizar_tabela(facada.getInstance().buscarTodosAlunos());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
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
        
        // ----------------------------------------------------------------------
        tabela_aluno.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                try {
                    if(event.getClickCount() == 2){
                        if(tabela_aluno.getSelectionModel().getSelectedItem() != null){
                            a = tabela_aluno.getSelectionModel().getSelectedItem();
                            App.genericaStage(ALTERAR_ALUNO).show();
                        }else{
                            Mensagem.getInstance().confirmar("Atenção", "Selecione o usuario", Alert.AlertType.WARNING);
                        }
                   
                }
                    
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        }

            }
        
        
        });
    // ----------------------------------------------------------------------
    
    
    
    
    
    }


    
    void atualizar_tabela(List<Aluno> alunoList){
        table_name.setCellValueFactory(new PropertyValueFactory<>("nome"));
        //table_turma.setCellValueFactory(new PropertyValueFactory<>(""));
        table_contato.setCellValueFactory(new PropertyValueFactory("contato"));
        table_mae.setCellValueFactory(new PropertyValueFactory<>("mae"));
        table_resp.setCellValueFactory(new PropertyValueFactory("responsavel_financeiro"));
        table_date.setCellValueFactory(new PropertyValueFactory("data_nascimento"));
       
       tabela_aluno.getItems().setAll(alunoList);
        
    
    }

    public static Aluno getA() {
        return a;
    }

    public static void setA(Aluno a) {
        Ver_AlunosController.a = a;
    }

    
  
 
    
   

}

