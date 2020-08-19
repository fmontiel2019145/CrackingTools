package app.easyprojects.controller;

import app.easyprojects.api.Files;
import app.easyprojects.system.Principal;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.Initializable;

public class SepararCombosController implements Initializable{

    private Principal principal = new Principal();
    private Files file = new Files();
    private Scanner entrada;
    private Principal escenarioPrincipal;
    
    public void getFile() throws FileNotFoundException{
        this.entrada = this.file.readFile();
        
        while(entrada.hasNext()){
            
        }
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
    public void ventanaSepararCombos(){
        escenarioPrincipal.ventanaSepararCombos();
    }
    
    public void menuPrincipal(){
        escenarioPrincipal.menuPrincipal();
    }
}
