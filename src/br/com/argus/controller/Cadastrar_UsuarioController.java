package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.enuns.TipoCargo;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Coordenador;
import br.com.argus.model.Diretor;
import br.com.argus.model.Secretario;
import br.com.argus.model.SuperUsuario;
import br.com.argus.model.Usuario;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
    
    private Usuario usuario, NovoUsuario;
    private SuperUsuario superUsuario, NovoSuperUsuario;
    private Diretor diretor, NovoDiretor;
    private Secretario secretario, NovoSecretario;
    private Coordenador coordenador, NovoCoordenador;
    public static final String CADASTRO_USUARIO = "/br/com/argus/view/Cadastrar_Usuario.fxml" ;
    
    private List<TipoCargo> cargos = new ArrayList<>();
    private ObservableList<TipoCargo> observable ; 
    
    @FXML
    private TextField nome;

    @FXML
    private TextField cpf;

    @FXML
    private ComboBox<TipoCargo> tipo_cargo;

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
        return tipo_cargo;
    }

    public void setTipo_cargo(ComboBox<TipoCargo> tipo_cargo) {
        this.tipo_cargo = tipo_cargo;
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
    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        carregar_comboBox();
    }
    
    public void Cadastrar(){
        
        if(getTipo_cargo().getValue().equals(TipoCargo.SUPER_USUARIO)){
        
        superUsuario = new SuperUsuario();
        superUsuario.setNome(nome.getText());
        superUsuario.setCpf(cpf.getText());
        superUsuario.setLogin(login.getText());
        superUsuario.setSenha(cpf.getText());
        superUsuario.setTipoCargo(TipoCargo.SUPER_USUARIO);
        
            try {
                Facade.getInstance().inserirOuAtualizar(superUsuario);
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();
               // carregar_comboBox();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
            }
        }
        
        if(getTipo_cargo().getValue().equals(TipoCargo.COORDENAÇÃO_PEDAGOGA)){
        coordenador = new Coordenador();
        coordenador.setNome(nome.getText());
        coordenador.setCpf(cpf.getText());
        coordenador.setLogin(login.getText());
        coordenador.setSenha(cpf.getText());
        coordenador.setTipoCargo(TipoCargo.COORDENAÇÃO_PEDAGOGA);
        
             try {
                Facade.getInstance().inserirOuAtualizar(coordenador);
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();
                carregar_comboBox();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
            }
        }
        
        if(getTipo_cargo().getValue().equals(TipoCargo.DIRETORIA)){
        diretor = new Diretor();
        diretor.setNome(nome.getText());
        diretor.setCpf(cpf.getText());
        diretor.setLogin(login.getText());
        diretor.setSenha(cpf.getText());
        diretor.setTipoCargo(TipoCargo.DIRETORIA);
        
             try {
                Facade.getInstance().inserirOuAtualizar(diretor);
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();
                carregar_comboBox();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
            }
        }
        
        if(getTipo_cargo().getValue().equals(TipoCargo.SECRETARIA)){
        secretario = new Secretario();
        secretario.setNome(nome.getText());
        secretario.setCpf(cpf.getText());
        secretario.setLogin(login.getText());
        secretario.setSenha(cpf.getText());
        secretario.setTipoCargo(TipoCargo.SECRETARIA);
        
             try {
                Facade.getInstance().inserirOuAtualizar(secretario);
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();
                carregar_comboBox();
            } catch (BussinesException ex) {
                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
            }
        }
    }
    

    public void carregar_comboBox(){
        
        cargos.add(TipoCargo.DIRETORIA);
        cargos.add(TipoCargo.COORDENAÇÃO_PEDAGOGA);
        cargos.add(TipoCargo.SECRETARIA);
        cargos.add(TipoCargo.SUPER_USUARIO);
        
        observable = FXCollections.observableArrayList(cargos);
        tipo_cargo.setItems(observable);
    }
    
    public void limparCampos(){
        nome.clear();
        cpf.clear();
        login.clear();
    }
    
//    public void Atualizar (Usuario u){
//        if(u instanceof SuperUsuario){
//            NovoSuperUsuario = (SuperUsuario) u;
//            NovoSuperUsuario.setNome();
//            NovoSuperUsuario.setLogin();
//            NovoSuperUsuario.setId(superUsuario.getId());
//               try {
//                Facade.getInstance().inserirOuAtualizar(NovoSuperUsuario);
//                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
//                limparCampos();
//                carregar_comboBox();
//            } catch (BussinesException ex) {
//                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
//            }
//            
//        }else if(u instanceof Diretor){
//            NovoDiretor = (SuperUsuario) u;
//            NovoDiretor.setNome();
//            NovoDiretor.setLogin();
//            NovoDiretor.setId(superUsuario.getId());
//               try {
//                Facade.getInstance().inserirOuAtualizar(NovoDiretor);
//                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
//                limparCampos();
//                carregar_comboBox();
//            } catch (BussinesException ex) {
//                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
//            }
//        }else if(u instanceof Secretario){
//            NovoSecretario = (SuperUsuario) u;
//            NovoSecretario.setNome();
//            NovoSecretario.setLogin();
//            NovoSecretario.setId(superUsuario.getId());
//               try {
//                Facade.getInstance().inserirOuAtualizar(NovoSecretario);
//                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
//                limparCampos();
//                carregar_comboBox();
//            } catch (BussinesException ex) {
//                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
//            }
//        }else{
//            NovoCoordenador = (SuperUsuario) u;
//            NovoCoordenador.setNome();
//            NovoCoordenador.setLogin();
//            NovoCoordenador.setId(superUsuario.getId());
//               try {
//                Facade.getInstance().inserirOuAtualizar(NovoCoordenador);
//                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Cadastrado com sucesso", Alert.AlertType.INFORMATION);
//                limparCampos();
//                carregar_comboBox();
//            } catch (BussinesException ex) {
//                Mensagem.getInstance().mostrarMensagem("Cadastro Usuario", "Erro ao cadastrar Usuario", Alert.AlertType.ERROR);
//            }
//        }
//        
//    }
}


