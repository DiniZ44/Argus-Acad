package br.com.argus.controller;

import br.com.argus.app.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class DashboardController implements Initializable{
    
    public static final String ALTERA_SENHA = "/br/com/argus/view/Alterar_senha.fxml" ;
    public static final String RESET_SENHA = "/br/com/argus/view/Resetar_Senha.fxml" ;
    public static final String CADASTRO_ALUNO ="/br/com/argus/view/Cadastrar_Aluno.fxml" ;
    public static final String CADASTRO_DISCIPLINA = "/br/com/argus/view/Cadastrar_Disciplina.fxml" ;
    public static final String CADASTRO_PROFESSOR = "/br/com/argus/view/Cadastrar_Professor.fxml" ;
    public static final String CADASTRO_TURMA = "/br/com/argus/view/Cadastrar_Turma.fxml" ;
    public static final String CADASTRO_USUARIO = "/br/com/argus/view/Cadastrar_Usuario.fxml" ;
    public static final String VER_ALUNOS = "/br/com/argus/view/Ver_Alunos.fxml" ;
    public static final String VER_DISCIPLINAS ="/br/com/argus/view/Ver_Disciplinas.fxml" ;
    public static final String VER_PROFESSORES = "/br/com/argus/view/Ver_Professores.fxml" ;
    public static final String VER_TURMA = "/br/com/argus/view/Ver_Turma.fxml" ;
    public static final String VER_USUARIO = "/br/com/argus/view/Ver_Usuarios.fxml" ;
    
    public Ver_UsuariosController controller;

    //  DASHBOARD
    @FXML
    private Button aluno;

    @FXML
    private Button disciplinas_button;

    @FXML
    private Button prof_button;

    @FXML
    private Button finan_button;

    @FXML
    private Pane pane_adm;

    @FXML
    private Button config_button;

    @FXML
    private Button usuario_button;

    @FXML
    private Button turma_button;

    @FXML
    private Pane panel_home;

    @FXML
    private Button home_button;

    @FXML
    private Button alterar_senha;
    
    @FXML
    private AnchorPane anchor_pane;
    
    @FXML
    void abir_config(ActionEvent event) {
        
    }

    @FXML
    void abrirAluno(ActionEvent event) throws IOException {
        getAnchor_pane().getChildren().clear();
        getAnchor_pane().getChildren().add(FXMLLoader.load(getClass().getResource(VER_ALUNOS)));
    }

    @FXML
    void abrir_disciplina(ActionEvent event) throws IOException {
        getAnchor_pane().getChildren().clear();
        getAnchor_pane().getChildren().add(FXMLLoader.load(getClass().getResource(VER_DISCIPLINAS)));
    }

    @FXML
    void abrir_financas(ActionEvent event) throws IOException {
    }

    @FXML
    void abrir_turma(ActionEvent event) throws IOException {
        getAnchor_pane().getChildren().clear();
        getAnchor_pane().getChildren().add(FXMLLoader.load(getClass().getResource(VER_TURMA)));
    }

    @FXML
    void abrir_usuario(ActionEvent event) throws IOException {
        getAnchor_pane().getChildren().clear();
        getAnchor_pane().getChildren().add(FXMLLoader.load(getClass().getResource(VER_USUARIO)));
    }

    @FXML
    void alterar_senha(ActionEvent event) throws IOException{
        getAnchor_pane().getChildren().clear();
        getAnchor_pane().getChildren().add(FXMLLoader.load(getClass().getResource(ALTERA_SENHA)));
    }
    
    @FXML
    void deslogar(ActionEvent event) throws IOException{
        App.stagePrincipal().close();
        App.stageLogin().show();
    }
    
    @FXML
    void abrir_professor(ActionEvent event) throws IOException {
        getAnchor_pane().getChildren().clear();
        getAnchor_pane().getChildren().add(FXMLLoader.load(getClass().getResource(VER_PROFESSORES)));
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       
    }

    public Button getAluno() {
        return aluno;
    }

    public void setAluno(Button aluno) {
        this.aluno = aluno;
    }

    public Button getDisciplinas_button() {
        return disciplinas_button;
    }

    public void setDisciplinas_button(Button disciplinas_button) {
        this.disciplinas_button = disciplinas_button;
    }

    public Button getProf_button() {
        return prof_button;
    }

    public void setProf_button(Button prof_button) {
        this.prof_button = prof_button;
    }

    public Button getFinan_button() {
        return finan_button;
    }

    public void setFinan_button(Button finan_button) {
        this.finan_button = finan_button;
    }

    public Pane getPane_adm() {
        return pane_adm;
    }

    public void setPane_adm(Pane pane_adm) {
        this.pane_adm = pane_adm;
    }

    public Button getConfig_button() {
        return config_button;
    }

    public void setConfig_button(Button config_button) {
        this.config_button = config_button;
    }

    public Button getUsuario_button() {
        return usuario_button;
    }

    public void setUsuario_button(Button usuario_button) {
        this.usuario_button = usuario_button;
    }

    public Button getTurma_button() {
        return turma_button;
    }

    public void setTurma_button(Button turma_button) {
        this.turma_button = turma_button;
    }

    public Pane getPanel_home() {
        return panel_home;
    }

    public void setPanel_home(Pane panel_home) {
        this.panel_home = panel_home;
    }

    public Button getHome_button() {
        return home_button;
    }

    public void setHome_button(Button home_button) {
        this.home_button = home_button;
    }

    public Button getAlterar_senha() {
        return alterar_senha;
    }

    public void setAlterar_senha(Button alterar_senha) {
        this.alterar_senha = alterar_senha;
    }

    public AnchorPane getAnchor_pane() {
        return anchor_pane;
    }

    public void setAnchor_pane(AnchorPane anchor_pane) {
        this.anchor_pane = anchor_pane;
    }
    
    
    

}


