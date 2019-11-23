/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.controller;

import br.com.argus.app.App;
import br.com.argus.enuns.SituacaoCarne;
import br.com.argus.exceptions.BussinesException;
import br.com.argus.facade.Facade;
import br.com.argus.model.Carne_Pagamento;
import br.com.argus.model.LiquidaCarne;
import br.com.argus.view.Mensagem;
import com.itextpdf.text.BaseColor;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
/**
 * FXML Controller class
 *
 * @author Hakkinen
 */
public class Alterar_CarneController implements Initializable {
    
    public final static String ALTERAR_CARNE = "/br/com/argus/view/Alterar_Carne.fxml" ;
    private static LiquidaCarne liquidaCarne;
    private Carne_Pagamento carne_Pagamento;
    Ver_FinanceiroController ver_FinanceiroController;
    
    @FXML
    private ComboBox<SituacaoCarne> tipo_pagemnto_cbox;

    @FXML
    private DatePicker data_pag;

    @FXML
    void salvar(ActionEvent event) throws IOException {
        cadastrar();
    }

    @FXML
    void voltar(ActionEvent event) throws IOException {
        App.genericaStage(ALTERAR_CARNE).close();
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
        initCarne();
        carregarCombo();
        // TODO
    }
    void carregarCombo(){
        tipo_pagemnto_cbox.getItems().setAll(SituacaoCarne.values());
    }
    
    void initCarne(){
        liquidaCarne = ver_FinanceiroController.getLc();
        
    }
    
        void cadastrar() throws IOException{
        liquidaCarne = ver_FinanceiroController.getLc();
        liquidaCarne.getCarne_Pagamento().setData_pago(data_pag.getValue());
        liquidaCarne.setSituacaoCarne(tipo_pagemnto_cbox.getValue());
        
        try {
            Facade.getInstance().inserirOuAtualizarLiquidaCarne(liquidaCarne);
            Mensagem.getInstance().mostrarMensagem("Carne", "Atualização feita com sucesso", Alert.AlertType.INFORMATION);
             App.genericaStage(ALTERAR_CARNE).close();
        } catch (BussinesException ex) {
            Logger.getLogger(Cadastrar_CarneController.class.getName()).log(Level.SEVERE, null, ex);
            Mensagem.getInstance().mostrarMensagem("Carne", "Erro ao atualizar carne ", Alert.AlertType.ERROR);
        }
    
    }
        
        void GerarPDF(){
            Document doc = new Document(PageSize.A4,30,20,20,30);
            String arquivoPDF = "Relatorio Financeiro do aluno "+ liquidaCarne.getCarne_Pagamento().getAluno().getNome() +".pdf";
            
            try {
                PdfWriter.getInstance(doc, new FileOutputStream(arquivoPDF));
                doc.open();
                Paragraph p = new Paragraph(" Relatório Finenceiro -- Carnê Argus Acadêmico");
                p.setAlignment(1);
                doc.add(p);
                p = new Paragraph(" ");
                doc.add(p);
                
                PdfPTable table = new PdfPTable(6);
                
                PdfPCell cell1 = new PdfPCell(new Paragraph("Aluno"));
                cell1.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell1.setBackgroundColor(BaseColor.BLUE);
                PdfPCell cell2 = new PdfPCell(new Paragraph("Responsável Financeiro"));
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell2.setBackgroundColor(BaseColor.BLUE);
                PdfPCell cell3 = new PdfPCell(new Paragraph("Data de Vencimento"));
                cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell3.setBackgroundColor(BaseColor.DARK_GRAY);
                PdfPCell cell4 = new PdfPCell(new Paragraph("Data de Pagamento"));
                cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell4.setBackgroundColor(BaseColor.DARK_GRAY);
                PdfPCell cell5 = new PdfPCell(new Paragraph("Valor da Prestação"));
                cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell5.setBackgroundColor(BaseColor.CYAN);
                PdfPCell cell6 = new PdfPCell(new Paragraph("Situação da Transação"));
                cell6.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell6.setBackgroundColor(BaseColor.GREEN);
                
                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);
                table.addCell(cell6);
                
                cell1 = new PdfPCell(new Paragraph(liquidaCarne.getCarne_Pagamento().getAluno().getNome()));
                cell1.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell2 = new PdfPCell(new Paragraph(liquidaCarne.getCarne_Pagamento().getAluno().getResponsavel_financeiro().getNome()));
                cell2.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell3 = new PdfPCell(new Paragraph(liquidaCarne.getCarne_Pagamento().getData_vencimento()+ ""));
                cell3.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell4 = new PdfPCell(new Paragraph(liquidaCarne.getCarne_Pagamento().getData_pago()+ ""));
                cell4.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell5 = new PdfPCell(new Paragraph(liquidaCarne.getCarne_Pagamento().getValor()+ ""));
                cell5.setHorizontalAlignment(Element.ALIGN_LEFT);
                cell6 = new PdfPCell(new Paragraph(liquidaCarne.getSituacaoCarne().toString()));
                cell6.setHorizontalAlignment(Element.ALIGN_LEFT);
                
                table.addCell(cell1);
                table.addCell(cell2);
                table.addCell(cell3);
                table.addCell(cell4);
                table.addCell(cell5);
                table.addCell(cell6);              
                doc.add(table);
                
                doc.close();
                Desktop.getDesktop().open(new File(arquivoPDF));
                Mensagem.getInstance().mostrarMensagem("Gerar PDF", "PFD gerado com sucesso", Alert.AlertType.INFORMATION);
            } catch (Exception e) {
                Mensagem.getInstance().mostrarMensagem("Gerar PDF", "Ocorreu um erro ao gerar o PDF, por favor tente novamente", Alert.AlertType.ERROR);
            }
        }
    
}
