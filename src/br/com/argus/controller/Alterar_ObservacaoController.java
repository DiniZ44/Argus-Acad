/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.model.ObservacaoAluno;
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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Alterar_ObservacaoController implements Initializable {
    
    public static final String ALTERAR_OBS ="/br/com/argus/view/Alterar_Observacao.fxml" ;
    private static ObservacaoAluno observacaoAluno;
    private Ver_ObservacaoController ver_ObservacaoController;
    
    
    
    @FXML
    private TextArea observacao;

    @FXML
    private Label label_cord;

    @FXML
    private Label label_aluno;

    @FXML
    private Label label_data;

    @FXML
    void imprimir(ActionEvent event) {
            GerarPdf();
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(ALTERAR_OBS).close();

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initObs();
        
    }

    void initObs(){
        observacaoAluno = ver_ObservacaoController.getObs();
        label_aluno.setText(observacaoAluno.getAluno().getNome());
        label_cord.setText(observacaoAluno.getCoordenador().getNome());
        label_data.setText(observacaoAluno.getData()+"");
        observacao.setText(observacaoAluno.getDescricao());
    }
    
    void GerarPdf(){
    
            
            Document doc = new Document(PageSize.A4,30,20,20,30);
            String arquivoPDF = "Relatorio Observação do aluno "+ observacaoAluno.getAluno().getNome() +".pdf";
            
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(arquivoPDF));
                doc.open();
                Paragraph p = new Paragraph(" Relatório Observação -- Carnê Argus Acadêmico");
                p.setAlignment(1);
                doc.add(p);
                p = new Paragraph(" ");
                doc.add(p);
                
                PdfPTable table = new PdfPTable(3);
                
                PdfPCell cell1 = new PdfPCell(new Paragraph("Aluno"));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setBackgroundColor(BaseColor.BLUE);
                PdfPCell cell2 = new PdfPCell(new Paragraph("Coordenado Pedagogo"));
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2.setBackgroundColor(BaseColor.BLUE);
                PdfPCell cell3 = new PdfPCell(new Paragraph("Data de Observação"));
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3.setBackgroundColor(BaseColor.BLUE);
                
                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                
                cell1 = new PdfPCell(new Paragraph(observacaoAluno.getAluno().getNome()));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell2 = new PdfPCell(new Paragraph(observacaoAluno.getCoordenador().getNome()));
                cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3 = new PdfPCell(new Paragraph(observacaoAluno.getData()+""));
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                
                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
 
                PdfPTable table1 = new PdfPTable(1);
                
                PdfPCell c = new PdfPCell(new Paragraph("Observação"));
                c.setHorizontalAlignment(Element.ALIGN_LEFT);
                c.setBackgroundColor(BaseColor.CYAN);
                
                table1.addCell(c);
                
                c = new PdfPCell(new Paragraph(observacaoAluno.getDescricao()));
                cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
                
                table1.addCell(c);
                
                doc.add(table);
                doc.add(table1);
                
                doc.close();
                Desktop.getDesktop().open(new File(arquivoPDF));
                Mensagem.getInstance().mostrarMensagem("Gerar PDF", "PFD gerado com sucesso", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                Mensagem.getInstance().mostrarMensagem("Gerar PDF", "Ocorreu um erro ao gerar o PDF, por favor tente novamente", Alert.AlertType.ERROR);
            }
    }
       
    
}
