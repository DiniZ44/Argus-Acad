package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.enuns.TipoCargo;
import br.com.argus.util.Backup;
import br.com.argus.util.SQLUtil;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    public static final String VER_FINANÇAS = "/br/com/argus/view/Ver_Financas.fxml" ;
    public static final String VER_CONFIG = "/br/com/argus/view/Ver_Configuracao.fxml" ;
    public static final String VER_NOTAS = "/br/com/argus/view/Ver_Notas.fxml" ;
    public static final String VER_OBS = "/br/com/argus/view/Ver_Observacao.fxml" ;
    public static final String VER_LOG = "/br/com/argus/view/Ver_Log.fxml" ;
    
    
    private static Ver_AlunosController alunosController;
    private Ver_DisciplinasController disciplinasController;
    private Ver_FinanceiroController financeiroController;
    private Ver_NotasController notasController;
    private Ver_ProfessoresController professoresController;
    private Ver_TurmaController turmaController;
    private Alterar_AlunoController alterar_AlunoController;
    private Alterar_CarneController alterar_CarneController;
    private Alterar_DisciplinaController alterar_DisciplinaController;
    private Alterar_ProfessorController alterar_ProfessorController;
    private Alterar_TurmaController alterar_TurmaController;
    
    
    //  DASHBOARD
    @FXML
    private Label label_usuario;

    @FXML
    private Button aluno_button;

    @FXML
    private Button notas_button;

    @FXML
    private Button disciplinas_button;

    @FXML
    private Button prof_button;

    @FXML
    private Button finan_button1;

    @FXML
    private Button turma_button;

    @FXML
    private Button observacao_button;

    @FXML
    private Pane pane_adm;

    @FXML
    private Button config_button;

    @FXML
    private Button usuario_button;

    @FXML
    private Button alterar_senha;

    @FXML
    private Button home_button;

    @FXML
    private AnchorPane anchor_pane;
    
    
    @FXML
    void abir_log(ActionEvent event) throws IOException{
        getAnchor_pane().getChildren().clear();
        getAnchor_pane().getChildren().add(FXMLLoader.load(getClass().getResource(VER_LOG)));
    }
    
    @FXML
    void abrir_observaçao(ActionEvent event) throws IOException{
        getAnchor_pane().getChildren().clear();
        getAnchor_pane().getChildren().add(FXMLLoader.load(getClass().getResource(VER_OBS)));

    }
    @FXML
    void abir_config(ActionEvent event) throws IOException {
        getAnchor_pane().getChildren().clear();
        getAnchor_pane().getChildren().add(FXMLLoader.load(getClass().getResource(VER_CONFIG)));
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
        getAnchor_pane().getChildren().clear();
        getAnchor_pane().getChildren().add(FXMLLoader.load(getClass().getResource(VER_FINANÇAS)));
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
    void deslogar(ActionEvent event) throws IOException, InterruptedException{
        App.stagePrincipal().close();
        App.stageLogin().show();
        Backup.realizarBackupSaida();
    }
    
    @FXML
    void abrir_professor(ActionEvent event) throws IOException {
        getAnchor_pane().getChildren().clear();
        getAnchor_pane().getChildren().add(FXMLLoader.load(getClass().getResource(VER_PROFESSORES)));
    }
    @FXML
    void abrirNotas(ActionEvent event) throws IOException{
        getAnchor_pane().getChildren().clear();
        getAnchor_pane().getChildren().add(FXMLLoader.load(getClass().getResource(VER_NOTAS)));
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tipoUsuario();
        acessoTipo();
    }
    
    void tipoUsuario(){
    
        label_usuario.setText(SQLUtil.TIPO);
    }
    
    void acessoTipo(){
        if(SQLUtil.TIPO.equalsIgnoreCase(TipoCargo.COORDENAÇÃO_PEDAGOGA.toString())){
            pane_adm.setVisible(false);
            turma_button.setVisible(false);
            disciplinas_button.setVisible(false);
            prof_button.setVisible(false);
            finan_button1.setVisible(false);
            notas_button.setVisible(false);
            aluno_button.setVisible(false);
        }else if(SQLUtil.TIPO.equalsIgnoreCase(TipoCargo.DIRETORIA.toString())){
            pane_adm.setVisible(false);
//            alunosController.getAdd().setDisable(false);
//            disciplinasController.getAdd().setVisible(false);
//            financeiroController.getNovo_carne().setVisible(false);
//            professoresController.getAdd().setVisible(false);
//            turmaController.getAdd().setVisible(false);
//            alterar_AlunoController.getAdd().setVisible(false);
//            alterar_CarneController.getAdd().setVisible(false);
//            alterar_DisciplinaController.getAdd().setVisible(false);
//            alterar_ProfessorController.getAdd().setVisible(false);
//            alterar_TurmaController.getAdd().setVisible(false);
            
        }else if (SQLUtil.TIPO.equalsIgnoreCase(TipoCargo.SECRETARIA.toString())){
            pane_adm.setVisible(false);
            turma_button.setVisible(false);
            prof_button.setVisible(false);
            aluno_button.setVisible(false);
            finan_button1.setVisible(false);
            observacao_button.setVisible(false);
        }
    }

    public AnchorPane getAnchor_pane() {
        return anchor_pane;
    }

    public void setAnchor_pane(AnchorPane anchor_pane) {
        this.anchor_pane = anchor_pane;
    }
    
    
}