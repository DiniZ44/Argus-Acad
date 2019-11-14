package br.com.argus.controller;

import br.com.argus.app.App;

import br.com.argus.enuns.TipoEstadoUF;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Aluno;
import br.com.argus.model.Contato;
import br.com.argus.model.Endereco;
import br.com.argus.model.Resp_Financeiro;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class Cadastrar_AlunoController implements Initializable{
    
    public static final String CADASTRO_ALUNO ="/br/com/argus/view/Cadastrar_Aluno.fxml" ;
    private static final String CADASTRO_RESP = "/br/com/argus/view/Cadastrar_Resp.fxml";
    
//    private List ufs = new ArrayList(Arrays.asList(new String[]{TipoEstadoUF.ACRE.toString(), TipoEstadoUF.ALAGOAS.toString(), TipoEstadoUF.AMAPA.toString(), 
//    TipoEstadoUF.AMAZONAS.toString(), TipoEstadoUF.BAHIA.toString(), TipoEstadoUF.CEARA.toString(), TipoEstadoUF.DISTRITO_FERERAL.toString(), TipoEstadoUF.ESPIRITO_SANTO.toString(), TipoEstadoUF.GOIAS.toString(),
//    TipoEstadoUF.MARANAO.toString(), TipoEstadoUF.MATO_GROSSO.toString(), TipoEstadoUF.MATO_GROSSO_DO_SUL.toString(), TipoEstadoUF.MINAS_GERAIS.toString(), TipoEstadoUF.PARA.toString(), TipoEstadoUF.PARAIBA.toString(),
//    TipoEstadoUF.PARANA.toString(), TipoEstadoUF.PERNAMBUCO.toString(), TipoEstadoUF.PIAUL.toString(), TipoEstadoUF.RIO_DE_JANEIRO.toString(), TipoEstadoUF.RIO_GRANDE_DO_NORTE.toString(), 
//    TipoEstadoUF.RIO_GRANDE_DO_SUL.toString(), TipoEstadoUF.RONDONIA.toString(), TipoEstadoUF.RORAIMA.toString(), TipoEstadoUF.SANTA_CATARINA.toString(), TipoEstadoUF.SAO_PAULO.toString(), TipoEstadoUF.SERGIPE.toString(),
//    TipoEstadoUF.TONANTINS.toString()}));
    
    Endereco endereco;
    Contato contato;
    Resp_Financeiro financeiro;
    Aluno aluno;


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
    private TextField email;
    
        @FXML
    private TextField naturalidade;
    @FXML
    private ComboBox<Resp_Financeiro> reps_combo;

    @FXML
    void salvar(ActionEvent event) throws IOException {
        cadastrar();
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_ALUNO).close();
    }
    
    @FXML
    void add_resp(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_RESP).show();
    }
    

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       carregarCombo();
       
        // Pressionar Tecla tabela
       reps_combo.setOnKeyPressed(new EventHandler<KeyEvent>(){
           @Override
           public void handle(KeyEvent event) {
              
              
           }
    
    });
 
       
       
       
       
       
    }
    
    void cadastrar() throws IOException{
        
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
                Mensagem.getInstance().mostrarMensagem("Cadastro", "Cadastro feito com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();
                //carregarCombo();
            } catch (BussinesException ex) {
               Mensagem.getInstance().mostrarMensagem("Cadastro", "Erro ao cadastrar ", Alert.AlertType.ERROR);
            }
    }

    
    void carregarCombo(){
        uf_cbox.getItems().setAll(TipoEstadoUF.values());
    }
    
    void limparCampos(){
    cpf_Aluno.clear();
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
    uf_cbox.getEditor().clear();
    }
    
    

}
