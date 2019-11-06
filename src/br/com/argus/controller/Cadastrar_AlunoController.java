package br.com.argus.controller;

import br.com.argus.enuns.TipoEstadoUF;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Aluno;
import br.com.argus.model.Contato;
import br.com.argus.model.Endereco;
import br.com.argus.model.Resp_Financeiro;
import br.com.argus.view.Mensagem;
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

public class Cadastrar_AlunoController implements Initializable{
    
    Endereco endereco;
    Contato contato;
    Resp_Financeiro financeiro;
    Aluno aluno;

    @FXML
    private Button salvar_button;

    @FXML
    private TextField nome_aluno;

    @FXML
    private DatePicker data_nasc;

    @FXML
    private TextField pai;

    @FXML
    private TextField cpf_Aluno;

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
    private TextField mae;

    @FXML
    private TextField responsavel;

    @FXML
    private TextField cpf_responsavel;
    
    
    @FXML
    private TextField email;

    @FXML
    private Button voltar;
    
        @FXML
    private TextField naturalidade;

    @FXML
    void salvar(ActionEvent event) {
       // carregarCombo();
        cadastrar();
    }

    @FXML
    void voltar(ActionEvent event) {

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
        
        financeiro = new Resp_Financeiro();
        financeiro.setCpf(cpf_responsavel.getText());
        financeiro.setNome(responsavel.getText());
        
        aluno = new Aluno();
        aluno.setEndereco(endereco);
        aluno.setContato(contato);
        aluno.setData_nascimento(data_nasc.getValue());
        aluno.setCpf(cpf_Aluno.getText());
        aluno.setMae(mae.getText());
        aluno.setNaturalidade(naturalidade.getText() );
        aluno.setNome(nome_aluno.getText());
        aluno.setPai(pai.getText());
        aluno.setResponsavel_financeiro(financeiro);
        
            try {
                Facade.getInstance().inserirOuAtualizarAluno(aluno);
                Mensagem.getInstance().mostrarMensagem("Cadastro Aluno", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();
                //carregarCombo();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Aluno", "Erro ao cadastrar Aluno", Alert.AlertType.ERROR);
            }
    }

    
    void carregarCombo(){
        uf_cbox.getItems().setAll(TipoEstadoUF.values());
    }
    
    void limparCampos(){
    cpf_Aluno.clear();
    cpf_responsavel.clear();
    mae.clear();
    naturalidade.clear();
    nome_aluno.clear();
    pai.clear();
    responsavel.clear();
    logradouro.clear();
    camplemento.clear();
    cidade_field.clear();
    cep_field.clear();
    bairro_field.clear();
    celular_field.clear();
    email.clear();
    tel_field.clear();
    numCasa.clear();
    data_nasc.getEditor().clear();
    }

}
