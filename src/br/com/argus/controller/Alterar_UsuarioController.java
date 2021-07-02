/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Alterar_UsuarioController implements Initializable {
    
    private static Usuario usuario;
    private SuperUsuario superUsuario;
    private Diretor diretor;
    private Secretario secretario ;
    private Coordenador coordenador;
    private Ver_UsuariosController usuariosController;
    public static final String ALTERAR_USUARIO ="/br/com/argus/view/Alterar_Usuario.fxml" ;
    
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
    void salvarUsuario(ActionEvent event) throws IOException {
        Cadastrar();
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(ALTERAR_USUARIO).close();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
      carregarCampo();
      initPerson();

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
    
    public void Cadastrar() throws IOException{
        
            
         if(getTipo_cargo().getValue().equals(TipoCargo.SUPER_USUARIO)){
        
        superUsuario = (SuperUsuario) usuariosController.getU();
        superUsuario.setNome(nome.getText());
        superUsuario.setCpf(cpf.getText());
        superUsuario.setLogin(login.getText());
        superUsuario.setSenha(cpf.getText());
        superUsuario.setTipoCargo(TipoCargo.SUPER_USUARIO);
        superUsuario.setSolicitar_reset(ResetSenha.NAO);
        
            try {

                Facade.getInstance().inserirOuAtualizar(superUsuario);
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();
                App.genericaStage(ALTERAR_USUARIO).close();
               // carregar_comboBox();
                cpf.clear();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
            }
        }
        
        else if(getTipo_cargo().getValue().equals(TipoCargo.COORDENAÇÃO_PEDAGOGA)){
        coordenador = (Coordenador) usuariosController.getU();
        coordenador.setNome(nome.getText());
        coordenador.setCpf(cpf.getText());
        coordenador.setLogin(login.getText());
        coordenador.setSenha(cpf.getText());
        coordenador.setTipoCargo(TipoCargo.COORDENAÇÃO_PEDAGOGA);
        coordenador.setSolicitar_reset(ResetSenha.NAO);
        
             try {

                Facade.getInstance().inserirOuAtualizar(coordenador);
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();
                App.genericaStage(ALTERAR_USUARIO).close();
                //carregar_comboBox();
                cpf.clear();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
            }
        }
        
        else if(getTipo_cargo().getValue().equals(TipoCargo.DIRETORIA)){
        diretor = (Diretor) usuariosController.getU();
        diretor.setNome(nome.getText());
        diretor.setCpf(cpf.getText());
        diretor.setLogin(login.getText());
        diretor.setSenha(cpf.getText());
        diretor.setTipoCargo(TipoCargo.DIRETORIA);
        diretor.setSolicitar_reset(ResetSenha.NAO);
        
             try {

                Facade.getInstance().inserirOuAtualizar(diretor);
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();
                App.genericaStage(ALTERAR_USUARIO).close();
                 cpf.clear();
               // carregar_comboBox();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
            }
        }
        
        else if (getTipo_cargo().getValue().equals(TipoCargo.SECRETARIA)){
        secretario = (Secretario) usuariosController.getU();
        secretario.setNome(nome.getText());
        secretario.setCpf(cpf.getText());
        secretario.setLogin(login.getText());
        secretario.setSenha(cpf.getText());
        secretario.setTipoCargo(TipoCargo.SECRETARIA);
        secretario.setSolicitar_reset(ResetSenha.NAO);
        
             try {

                Facade.getInstance().inserirOuAtualizar(secretario);
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();
                App.genericaStage(ALTERAR_USUARIO).close();
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
    
    void initPerson(){
        usuario = usuariosController.getU();
        nome.setText(usuario.getNome());
        cpf.setText(usuario.getCpf());
        login.setText(usuario.getLogin());
        tipo_ComboBox.setValue(usuario.getTipoCargo());
        usuario.setId(usuario.getId());
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
