package br.com.argus.controller;

import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import br.com.argus.model.Usuario;
import br.com.argus.view.Mensagem;
import java.util.List;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class Alterar_SenhaController {
    
    private Usuario usuario;
    
    @FXML
    private PasswordField senha_nova2;

    @FXML
    private PasswordField senha_nova;

    @FXML
    private PasswordField senha_atual;

    @FXML
    private TextField login_atual;

    @FXML
    private Button salvar_button1;

    @FXML
    void salvar(ActionEvent event) {
       
        
        if(trocarSenha()){
            Mensagem.getInstance().mostrarMensagem("ALTERAÇÃO DE SENHA", "Nova senha, cadastrada com sucesso", Alert.AlertType.INFORMATION);
        }else{
         Mensagem.getInstance().mostrarMensagem("ALTERAÇÃO DE SENHA", "Erro ao cadastrar nova senha, por favor tente de novo", Alert.AlertType.ERROR);
    }}
    
    public boolean trocarSenha() {
        try {
            
            
            if (senha_nova.getText().equals(senha_nova2.getText())){
                usuario = Facade.getInstance().buscarLoginUsuario(login_atual.getText(), senha_atual.getText());
                usuario.setSenha(senha_nova.getText());
                usuario.setId(usuario.getId());
                this.senha_atual.clear();
                this.senha_nova.clear();
                this.senha_nova2.clear();
                this.login_atual.clear();
                Facade.getInstance().inserirOuAtualizar(usuario);
                return true;
                
            }
            Mensagem.getInstance().mostrarMensagem("ALTERAÇÃO DE SENHA", "Senha não são iguais", Alert.AlertType.ERROR);
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public PasswordField getSenha_nova2() {
        return senha_nova2;
    }

    public PasswordField getSenha_nova() {
        return senha_nova;
    }

    public PasswordField getSenha_atual() {
        return senha_atual;
    }

    public TextField getLogin_atual() {
        return login_atual;
    }


    public Button getSalvar_button1() {
        return salvar_button1;
    }

    public void setSalvar_button1(Button salvar_button1) {
        this.salvar_button1 = salvar_button1;
    }
    
    
    
    
 

}

