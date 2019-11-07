package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.enuns.TipoEstadoUF;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Contato;
import br.com.argus.model.Endereco;
import br.com.argus.model.Professor;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class Cadastrar_ProfessorController implements Initializable{
    public static final String CADASTRO_PROFESSOR = "/br/com/argus/view/Cadastrar_Professor.fxml" ;
    private Professor professor;
    private Endereco endereco;
    private Contato contato;

    @FXML
    private Button salvar_button;

    @FXML
    private TextField nome;

    @FXML
    private DatePicker data_nasc;

    @FXML
    private TextField cpf;

    @FXML
    private TextField logradouro;

    @FXML
    private TextField bairro_field;

    @FXML
    private TextField cep_field;

    @FXML
    private TextField numCasa;

    @FXML
    private TextField camplemento;

    @FXML
    private TextField cidade_field;

    @FXML
    private ComboBox<TipoEstadoUF> uf_cbox;

    @FXML
    private TextField tel_field;

    @FXML
    private TextField celular_field;

    @FXML
    private Button voltar;
    
    @FXML
    private TextField email;
    
    
    @FXML
    private TextField naturalidade;

    @FXML
    void salvar(ActionEvent event) {
        cadastrar();
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_PROFESSOR).close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }
    
    void cadastrar(){
      endereco = new Endereco();
        endereco.setBairro(bairro_field.getText());
        endereco.setCep(cep_field.getText());
        endereco.setCidade(cidade_field.getText());
        endereco.setComplemento(camplemento.getText());
        endereco.setLogradouro(logradouro.getText());
        endereco.setTipoEstadoUF(uf_cbox.getValue());
        endereco.setNumero(numCasa.getText());
        
        contato = new Contato();
        contato.setCelular(celular_field.getText());
        contato.setEmail(email.getText());
        contato.setTelefone(tel_field.getText());
        
              professor = new Professor();
        professor.setEndereco(endereco);
        professor.setContato(contato);
        professor.setData_nascimento(data_nasc.getValue());
        professor.setCpf(cpf.getText());
        professor.setNaturalidade(naturalidade.getText() );
        professor.setNome(nome.getText());
        
           try {
                Facade.getInstance().inserirOuAtualizarProfessor(professor);
                Mensagem.getInstance().mostrarMensagem("Cadastro Professor", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();
                //carregarCombo();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Professor", "Erro ao cadastrar Professor", Alert.AlertType.ERROR);
            }

    }
    
    void carregarCombo(){
    
        uf_cbox.getItems().setAll(TipoEstadoUF.values());
    }
    
    void limparCampos(){
      cpf.clear();
    naturalidade.clear();
    nome.clear();
    logradouro.clear();
    camplemento.clear();
    cidade_field.clear();
    cep_field.clear();
    bairro_field.clear();
    celular_field.clear();
    email.clear();
    tel_field.clear();
    numCasa.clear();
    
    }

}

