/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.argus.util;

import br.com.argus.view.Mensagem;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.control.Alert;
import javax.swing.JOptionPane;

/**
 *
 * @author Hakkinen
 */
public class Restore {
    
    public static void realizaRestore() {
        final List<String> comandos = new ArrayList<String>();      
             
            comandos.add("C:\\Program Files\\PostgreSQL\\9.6\\bin\\pg_restore.exe");
           
           
           //comandos.add("-i");      
           comandos.add("-h");      
           comandos.add("localhost");   
           comandos.add("-p");      
           comandos.add("5432");      
           comandos.add("-U");      
           comandos.add("postgres");      
           comandos.add("-d");      
           comandos.add("Projeto_PBD");     
           comandos.add("-v");      
             
           comandos.add("Projeto_PBD.backup");

           ProcessBuilder pb = new ProcessBuilder(comandos);      
             
           pb.environment().put("PGPASSWORD", "12345");          
             
           try {      
               final Process process = pb.start();      
         
               final BufferedReader r = new BufferedReader(      
                   new InputStreamReader(process.getErrorStream()));      
               String line = r.readLine();      
               while (line != null) {      
               System.err.println(line);      
               line = r.readLine();      
               }      
               r.close();      
         
               process.waitFor();    
               process.destroy(); 
               Mensagem.getInstance().confirmar("Restore", "Restore do Banco de Dados, realizado com sucesso", Alert.AlertType.INFORMATION);  
         
           } catch (IOException e) {      
               e.printStackTrace();      
           } catch (InterruptedException ie) {      
               ie.printStackTrace();      
           }         
               
       }      
  
}
