/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.enuns.TipoEstadoUF;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Aluno;
import br.com.argus.model.Contato;
import br.com.argus.model.Endereco;
import br.com.argus.model.Resp_Financeiro;
import br.com.argus.util.MaskField;
import br.com.argus.view.Mensagem;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Alterar_AlunoController implements Initializable {
    
    public static final String ALTERAR_ALUNO ="/br/com/argus/view/Alterar_Aluno.fxml" ;
    private static final String CADASTRO_RESP = "/br/com/argus/view/Cadastrar_Resp.fxml";
    private Ver_AlunosController alunosController;
    public List<Resp_Financeiro> responsaveis;
    
//    private List ufs = new ArrayList(Arrays.asList(new String[]{TipoEstadoUF.ACRE.toString(), TipoEstadoUF.ALAGOAS.toString(), TipoEstadoUF.AMAPA.toString(), 
//    TipoEstadoUF.AMAZONAS.toString(), TipoEstadoUF.BAHIA.toString(), TipoEstadoUF.CEARA.toString(), TipoEstadoUF.DISTRITO_FERERAL.toString(), TipoEstadoUF.ESPIRITO_SANTO.toString(), TipoEstadoUF.GOIAS.toString(),
//    TipoEstadoUF.MARANAO.toString(), TipoEstadoUF.MATO_GROSSO.toString(), TipoEstadoUF.MATO_GROSSO_DO_SUL.toString(), TipoEstadoUF.MINAS_GERAIS.toString(), TipoEstadoUF.PARA.toString(), TipoEstadoUF.PARAIBA.toString(),
//    TipoEstadoUF.PARANA.toString(), TipoEstadoUF.PERNAMBUCO.toString(), TipoEstadoUF.PIAUL.toString(), TipoEstadoUF.RIO_DE_JANEIRO.toString(), TipoEstadoUF.RIO_GRANDE_DO_NORTE.toString(), 
//    TipoEstadoUF.RIO_GRANDE_DO_SUL.toString(), TipoEstadoUF.RONDONIA.toString(), TipoEstadoUF.RORAIMA.toString(), TipoEstadoUF.SANTA_CATARINA.toString(), TipoEstadoUF.SAO_PAULO.toString(), TipoEstadoUF.SERGIPE.toString(),
//    TipoEstadoUF.TONANTINS.toString()}));
    
    Endereco endereco;
    Contato contato;
    Resp_Financeiro financeiro;
    private static Aluno aluno;

    @FXML
    private Button add;
    
    @FXML
    private TextField nome_aluno;

    @FXML
    private DatePicker data_nasc;

    @FXML
    private TextField pai;

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
        App.genericaStage(ALTERAR_ALUNO).close();
    }
    
    @FXML
    void add_resp(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRO_RESP).show();
    }
    

    

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       carregarCombo();
       initAluno();
        try {
            buscarResp_Financeiros();
            
        } catch (BussinesException ex) {
            Logger.getLogger(Alterar_AlunoController.class.getName()).log(Level.SEVERE, null, ex);
        }
 
       
       
       
       
       
    }
    
    void cadastrar() throws IOException{
        aluno = alunosController.getA();
        
        
        endereco = aluno.getEndereco();
        endereco.setBairro(bairro_field.getText());
        endereco.setCep(cep_field.getText());
        endereco.setCidade(cidade_field.getText());
        endereco.setComplemento(camplemento.getText());
        endereco.setLogradouro(logradouro.getText());
        endereco.setTipoEstadoUF(uf_cbox.getValue());
        endereco.setNumero(numCasa.getText());
        
        contato = aluno.getContato();
        contato.setCelular(celular_field.getText());
        contato.setEmail(email.getText());
        contato.setTelefone(tel_field.getText());
        
        
        
        aluno.setEndereco(endereco);
        aluno.setContato(contato);
        aluno.setData_nascimento(data_nasc.getValue());
        aluno.setMae(mae.getText());
        aluno.setNaturalidade(naturalidade.getText() );
        aluno.setNome(nome_aluno.getText());
        aluno.setPai(pai.getText());
        financeiro = reps_combo.getValue();
        aluno.setResponsavel_financeiro(financeiro);
        
            try {
                Facade.getInstance().inserirOuAtualizarAluno(aluno);
                Mensagem.getInstance().mostrarMensagem("Cadastro", "Cadastro feito com sucesso", Alert.AlertType.INFORMATION);
                limparCampos();
                App.genericaStage(ALTERAR_ALUNO).close();
                //carregarCombo();
            } catch (BussinesException ex) {
               Mensagem.getInstance().mostrarMensagem("Cadastro", "Erro ao cadastrar ", Alert.AlertType.ERROR);
            }
    }
        
    
    void buscarResp_Financeiros() throws BussinesException{
        responsaveis = Facade.getInstance().buscarTodosResp_FinS();
         
        reps_combo.getItems().setAll(responsaveis);
    }

    
    void carregarCombo(){
        uf_cbox.getItems().setAll(TipoEstadoUF.values());
       
        MaskField.foneField(tel_field);
        MaskField.foneField(celular_field);
        MaskField.cepField(cep_field);
        cep_field.clear();

      celular_field.clear();

      tel_field.clear();
    }
    
    void limparCampos(){
    mae.clear();
    naturalidade.clear();
    nome_aluno.clear();
    pai.clear();
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
    
    void initAluno(){
        aluno = alunosController.getA();
        

        bairro_field.setText(aluno.getEndereco().getBairro());
        cep_field.setText(aluno.getEndereco().getCep());
        cidade_field.setText(aluno.getEndereco().getCidade());
        camplemento.setText(aluno.getEndereco().getComplemento());
        logradouro.setText(aluno.getEndereco().getLogradouro());
        uf_cbox.setValue(aluno.getEndereco().getTipoEstadoUF());
        numCasa.setText(aluno.getEndereco().getNumero());
        

        celular_field.setText(aluno.getContato().getCelular());
        email.setText(aluno.getContato().getEmail());
        tel_field.setText(aluno.getContato().getTelefone());
        
        
        data_nasc.setValue(aluno.getData_nascimento());
        mae.setText(aluno.getMae());
        naturalidade.setText(aluno.getNaturalidade());
        nome_aluno.setText(aluno.getNome());
        pai.setText(aluno.getPai());

    
    }

    public TextField getNome_aluno() {
        return nome_aluno;
    }

    public void setNome_aluno(TextField nome_aluno) {
        this.nome_aluno = nome_aluno;
    }

    public DatePicker getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(DatePicker data_nasc) {
        this.data_nasc = data_nasc;
    }

    public TextField getPai() {
        return pai;
    }

    public void setPai(TextField pai) {
        this.pai = pai;
    }

    public TextField getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(TextField logradouro) {
        this.logradouro = logradouro;
    }

    public TextField getBairro_field() {
        return bairro_field;
    }

    public void setBairro_field(TextField bairro_field) {
        this.bairro_field = bairro_field;
    }

    public TextField getCep_field() {
        return cep_field;
    }

    public void setCep_field(TextField cep_field) {
        this.cep_field = cep_field;
    }

    public TextField getNumCasa() {
        return numCasa;
    }

    public void setNumCasa(TextField numCasa) {
        this.numCasa = numCasa;
    }

    public TextField getCamplemento() {
        return camplemento;
    }

    public void setCamplemento(TextField camplemento) {
        this.camplemento = camplemento;
    }

    public TextField getCidade_field() {
        return cidade_field;
    }

    public void setCidade_field(TextField cidade_field) {
        this.cidade_field = cidade_field;
    }

    public ComboBox<TipoEstadoUF> getUf_cbox() {
        return uf_cbox;
    }

    public void setUf_cbox(ComboBox<TipoEstadoUF> uf_cbox) {
        this.uf_cbox = uf_cbox;
    }

    public TextField getTel_field() {
        return tel_field;
    }

    public void setTel_field(TextField tel_field) {
        this.tel_field = tel_field;
    }

    public TextField getCelular_field() {
        return celular_field;
    }

    public void setCelular_field(TextField celular_field) {
        this.celular_field = celular_field;
    }

    public TextField getMae() {
        return mae;
    }

    public void setMae(TextField mae) {
        this.mae = mae;
    }

    public TextField getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(TextField responsavel) {
        this.responsavel = responsavel;
    }

    public TextField getEmail() {
        return email;
    }

    public void setEmail(TextField email) {
        this.email = email;
    }

    public TextField getNaturalidade() {
        return naturalidade;
    }

    public void setNaturalidade(TextField naturalidade) {
        this.naturalidade = naturalidade;
    }

    public ComboBox<Resp_Financeiro> getReps_combo() {
        return reps_combo;
    }

    public void setReps_combo(ComboBox<Resp_Financeiro> reps_combo) {
        this.reps_combo = reps_combo;
    }

    public Button getAdd() {
        return add;
    }
    
    
    
    
    

}
