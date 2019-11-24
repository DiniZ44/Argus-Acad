/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.enuns.SituacaoAluno;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.VinculoAlunoTurma;
import br.com.argus.view.Mensagem;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Cadastar_NotaController implements Initializable {
    private static VinculoAlunoTurma vinculoAlunoTurma, carregadoVinculoAluno;
    private Ver_Notas_AlunoController alunoController;
    double nm ;
    double nmf;
    private final static String CADASTRAR_NOTA = "/br/com/argus/view/Cadastar_Nota.fxml";
    private final static String VER_NOTAS_ALUNO =  "/br/com/argus/view/Ver_Notas_Aluno.fxml";
    @FXML
    private TextField nota1;

    @FXML
    private TextField nota3;

    @FXML
    private TextField nota2;

    @FXML
    private TextField nota4;

    @FXML
    void salvar(ActionEvent event) {
        cadastrar();
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(CADASTRAR_NOTA).close();
        App.genericaStage(VER_NOTAS_ALUNO).show();
    }
    
    @FXML
    void imprimir(ActionEvent event) {
        GerarPDF();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initVinculo();
    }   
    
    void cadastrar(){
        
        vinculoAlunoTurma = alunoController.getVAT();
        calculoMedia();
//        vinculoAlunoTurma.setNota1(0);
//        vinculoAlunoTurma.setNota2(0);
//        vinculoAlunoTurma.setNota3(0);
//        vinculoAlunoTurma.setNota4(0);
        
        
        try {
            Facade.getInstance().inserirOuAtualizarVincAlunoTurma(vinculoAlunoTurma);
            Mensagem.getInstance().mostrarMensagem("Cadastro Notas", "Cadastro realizado com sucesso", Alert.AlertType.INFORMATION);
        } catch (BussinesException ex) {
           ex.printStackTrace();
           Mensagem.getInstance().mostrarMensagem("Cadastro Notas", "Erro ao realizar cadastro", Alert.AlertType.ERROR);
        }
        
    }
    
    void initVinculo(){
    
           carregadoVinculoAluno = alunoController.getVAT();
    }
    
    void calculoMedia(){
        double nn1 = Double.parseDouble(nota1.getText());
        double nn2 = Double.parseDouble(nota2.getText());
        double nn3 = Double.parseDouble(nota3.getText());
        double nn4 = Double.parseDouble(nota4.getText());
        double media = (nn1+nn2+nn3+nn4)/4;
        if(media >= 7){
             nm = media;
             nmf = 0.0;
             vinculoAlunoTurma.setSituacaoAluno(SituacaoAluno.AM);
        }else if(media >= 5 && media  < 7){
             nm = media;
             nmf = nm;
             vinculoAlunoTurma.setSituacaoAluno(SituacaoAluno.AP);
        }else{
            nm = media;
            nmf = nm;
            vinculoAlunoTurma.setSituacaoAluno(SituacaoAluno.RP);
        }

        vinculoAlunoTurma.setNota1(nn1);
        vinculoAlunoTurma.setNota2(nn2);
        vinculoAlunoTurma.setNota3(nn3);
        vinculoAlunoTurma.setNota4(nn4);
        vinculoAlunoTurma.setMedia(nm);
        vinculoAlunoTurma.setMediaFinal(nmf);
        
    }
    
  void GerarPDF(){
      
            Document doc = new Document(PageSize.A4,30,20,20,30);
            String arquivoPDF = "Boletim do aluno "+ carregadoVinculoAluno.getAluno().getNome() +".pdf";
            
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(arquivoPDF));
                doc.open();
                Paragraph p = new Paragraph(" Boletim Argus Academico");
                p.setAlignment(1);
                doc.add(p);
                p = new Paragraph(" ");
                doc.add(p);
                
                PdfPTable table = new PdfPTable(3);
                
                PdfPCell cell1 = new PdfPCell(new Paragraph("Aluno"));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setBackgroundColor(BaseColor.BLUE);
                PdfPCell cell2 = new PdfPCell(new Paragraph("Turma"));
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setBackgroundColor(BaseColor.BLUE);
                PdfPCell cell3 = new PdfPCell(new Paragraph("Disciplina"));
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3.setBackgroundColor(BaseColor.BLUE);

                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                
                cell1 = new PdfPCell(new Paragraph(carregadoVinculoAluno.getAluno().getNome()));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2 = new PdfPCell(new Paragraph(carregadoVinculoAluno.getDisciplinaTurma().getTurma().getNome()));
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3 = new PdfPCell(new Paragraph(carregadoVinculoAluno.getDisciplinaTurma().getDisciplina().getNome()));
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                 
                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                 
                p = new Paragraph(" ");
                doc.add(p);
                PdfPTable table2 = new PdfPTable(6);
                PdfPCell cell7 = new PdfPCell(new Paragraph("1° Média"));
                cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell7.setBackgroundColor(BaseColor.DARK_GRAY);
                PdfPCell cell8 = new PdfPCell(new Paragraph("2° Média"));
                cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell8.setBackgroundColor(BaseColor.DARK_GRAY);
                PdfPCell cell9 = new PdfPCell(new Paragraph("3° Média"));
                cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell9.setBackgroundColor(BaseColor.DARK_GRAY);
                PdfPCell cel1l0 = new PdfPCell(new Paragraph("4° Média"));
                cel1l0.setHorizontalAlignment(Element.ALIGN_CENTER);
                cel1l0.setBackgroundColor(BaseColor.DARK_GRAY);
                PdfPCell cel1l1 = new PdfPCell(new Paragraph("Média Geral"));
                cel1l1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cel1l1.setBackgroundColor(BaseColor.RED);                
                PdfPCell cel1l3 = new PdfPCell(new Paragraph("Média Final"));
                cel1l3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cel1l3.setBackgroundColor(BaseColor.RED);
                
                
                table2.addCell(cell7);
                table2.addCell(cell8);
                table2.addCell(cell9);
                table2.addCell(cel1l0);
                table2.addCell(cel1l1);
                table2.addCell(cel1l3);

                cell7 = new PdfPCell(new Paragraph(carregadoVinculoAluno.getNota1()+""));
                cell7.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell8 = new PdfPCell(new Paragraph(carregadoVinculoAluno.getNota2()+""));
                cell8.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell9 = new PdfPCell(new Paragraph(carregadoVinculoAluno.getNota3()+""));
                cell9.setHorizontalAlignment(Element.ALIGN_CENTER);
                cel1l0 = new PdfPCell(new Paragraph(carregadoVinculoAluno.getNota4()+""));
                cel1l0.setHorizontalAlignment(Element.ALIGN_CENTER);
                cel1l1 = new PdfPCell(new Paragraph(carregadoVinculoAluno.getMedia()+""));
                cel1l1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cel1l3 = new PdfPCell(new Paragraph(carregadoVinculoAluno.getMediaFinal()+""));
                cel1l3.setHorizontalAlignment(Element.ALIGN_CENTER);
                 
                table2.addCell(cell7);
                table2.addCell(cell8);
                table2.addCell(cell9);
                table2.addCell(cel1l0);
                table2.addCell(cel1l1);
                table2.addCell(cel1l3);
                
                p = new Paragraph(" ");
                doc.add(p);
                PdfPTable table3 = new PdfPTable(1);
                PdfPCell cel = new PdfPCell(new Paragraph("Situação do aluno"));
                cel.setHorizontalAlignment(Element.ALIGN_CENTER);
                cel.setBackgroundColor(BaseColor.GREEN);
                
                table3.addCell(cel);
                
                cel = new PdfPCell(new Paragraph(carregadoVinculoAluno.getSituacaoAluno().toString()));
                cel.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                table3.addCell(cel);
                
                doc.add(table);
                doc.add(table2);
                doc.add(table3);
                
                doc.close();
                Desktop.getDesktop().open(new File(arquivoPDF));
                Mensagem.getInstance().mostrarMensagem("Gerar PDF", "PFD gerado com sucesso", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                Mensagem.getInstance().mostrarMensagem("Gerar PDF", "Ocorreu um erro ao gerar o PDF, por favor tente novamente", Alert.AlertType.ERROR);
            }
        }
        
    
}
