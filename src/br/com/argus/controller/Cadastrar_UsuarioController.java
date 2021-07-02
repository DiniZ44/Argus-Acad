package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.enuns.ResetSenha;
import br.com.argus.enuns.TipoCargo;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Coordenador;
import br.com.argus.model.Diretor;
import br.com.argus.model.Secretario;
import br.com.argus.model.SuperUsuario;
import br.com.argus.model.Usuario;
import br.com.argus.util.MaskField;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class Cadastrar_UsuarioController implements Initializable{
    
    private static Usuario usuario;
    private SuperUsuario superUsuario;
    private Diretor diretor;
    private Secretario secretario ;
    private Coordenador coordenador;
    private Ver_UsuariosController usuariosController;
    public static final String CADASTRO_USUARIO = "/br/com/argus/view/Cadastrar_Usuario.fxml" ;
    
    //private List cargos = new ArrayList(Arrays.asList(new String[]{TipoCargo.COORDENAÇÃO_PEDAGOGA.toString(),TipoCargo.DIRETORIA.toString(),TipoCargo.SECRETARIA.toString(), TipoCargo.SUPER_USUARIO.toString()}));

    @FXML
    private TextField nome;

    @FXML
    private TextField cpf;

    @FXML
    private ComboBox<TipoCargo> tipo_ComboBox;

    @FXML
    private Button salvar;

    @FXML
    private TextField login;

    @FXML
    private Button voltar;

    @FXML
    void salvarUsuario(ActionEvent event) {
        Cadastrar();
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_USUARIO).close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      carregarCampo();
//      initPerson();

    }
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public TextField getNome() {
        return nome;
    }

    public void setNome(TextField nome) {
        this.nome = nome;
    }

    public TextField getCpf() {
        return cpf;
    }

    public void setCpf(TextField cpf) {
        this.cpf = cpf;
    }

    public ComboBox<TipoCargo> getTipo_cargo() {
        return tipo_ComboBox;
    }

    public void setTipo_cargo(ComboBox<TipoCargo> tipo_cargo) {
        this.tipo_ComboBox = tipo_cargo;
    }

    public Button getSalvar() {
        return salvar;
    }

    public void setSalvar(Button salvar) {
        this.salvar = salvar;
    }

    public TextField getLogin() {
        return login;
    }

    public void setLogin(TextField login) {
        this.login = login;
    }

    public Button getVoltar() {
        return voltar;
    }

    public void setVoltar(Button voltar) {
        this.voltar = voltar;
    }
    
    public void Cadastrar(){
        
            
         if(getTipo_cargo().getValue().equals(TipoCargo.SUPER_USUARIO)){
        
        superUsuario = new SuperUsuario();
        superUsuario.setNome(nome.getText());
        superUsuario.setCpf(cpf.getText());
        superUsuario.setLogin(login.getText());
        superUsuario.setSenha(cpf.getText());
        superUsuario.setSolicitar_reset(ResetSenha.NAO);
        superUsuario.setTipoCargo(TipoCargo.SUPER_USUARIO);
        
            try {
                if(verificarCPF()){
                Facade.getInstance().inserirOuAtualizar(superUsuario);
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();}
                cpf.clear();
               // carregar_comboBox();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
            }
        }
        
        else if(getTipo_cargo().getValue().equals(TipoCargo.COORDENAÇÃO_PEDAGOGA)){
        coordenador = new Coordenador();
        coordenador.setNome(nome.getText());
        coordenador.setCpf(cpf.getText());
        coordenador.setLogin(login.getText());
        coordenador.setSenha(cpf.getText());
        coordenador.setSolicitar_reset(ResetSenha.NAO);
        coordenador.setTipoCargo(TipoCargo.COORDENAÇÃO_PEDAGOGA);
        
             try {
                 if(verificarCPF()){
                Facade.getInstance().inserirOuAtualizar(coordenador);
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();
                 }cpf.clear();
                //carregar_comboBox();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
            }
        }
        
        else if(getTipo_cargo().getValue().equals(TipoCargo.DIRETORIA)){
        diretor = new Diretor();
        diretor.setNome(nome.getText());
        diretor.setCpf(cpf.getText());
        diretor.setLogin(login.getText());
        diretor.setSenha(cpf.getText());
        diretor.setSolicitar_reset(ResetSenha.NAO);
        diretor.setTipoCargo(TipoCargo.DIRETORIA);
        
             try {
                 if(verificarCPF()){
                Facade.getInstance().inserirOuAtualizar(diretor);
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();}
                 cpf.clear();
               // carregar_comboBox();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
            }
        }
        
        else if (getTipo_cargo().getValue().equals(TipoCargo.SECRETARIA)){
        secretario = new Secretario();
        secretario.setNome(nome.getText());
        secretario.setCpf(cpf.getText());
        secretario.setLogin(login.getText());
        secretario.setSenha(cpf.getText());
        secretario.setSolicitar_reset(ResetSenha.NAO);
        secretario.setTipoCargo(TipoCargo.SECRETARIA);
        
             try {
                 if(verificarCPF()){
                Facade.getInstance().inserirOuAtualizar(secretario);
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();}
                 cpf.clear();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
            }
        }
    }
    
     void limparCampos(){
        nome.clear();
        cpf.clear();
        login.clear();
        tipo_ComboBox.getEditor().clear();
    }
    
    void carregarCampo(){
        tipo_ComboBox.getItems().setAll(TipoCargo.values());
        MaskField.cpfField(cpf);
    }
    

        boolean verificarCPF (){
        
        try {
            Usuario user = Facade.getInstance().buscarCPF(cpf.getText());
            if(user == null){
                return true;
            }
                Mensagem.getInstance().mostrarMensagem("Campo CPF", "O CPF "+cpf.getText()+" ja foi cadastrado no sistema", Alert.AlertType.ERROR);
                return false;

        } catch (BussinesException ex) {
            return true;
        }

    }
        

}


