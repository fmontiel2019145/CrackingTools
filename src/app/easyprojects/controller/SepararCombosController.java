package app.easyprojects.controller;

import app.easyprojects.system.Principal;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JFileChooser;

public class SepararCombosController implements Initializable{

    private final Principal principal = new Principal();
    private Principal escenarioPrincipal;
    
    private JFileChooser selectorArchivo;
    private File archivo;
    private Scanner entrada;
    private String ruta;
    
    private String emails = "";
    private String claves = "";
    
    private String combo;
    private String[] comboArray;
    
    private int i;
    
    @FXML private TextArea txtAreaEmails;
    @FXML private TextArea txtAreaClaves;
    @FXML private TextField txtDelimitador;
    
    public void getFile() throws FileNotFoundException{
        this.selectorArchivo = new JFileChooser();
        this.selectorArchivo.showOpenDialog(this.selectorArchivo);
        this.ruta = this.selectorArchivo.getSelectedFile().getAbsolutePath();
        
        this.archivo = new File(ruta);
        
        this.entrada = new Scanner(this.archivo);
        
        this.txtAreaEmails.setText("");
        this.txtAreaClaves.setText("");
        
        this.i = 0;
        
        while(this.entrada.hasNext()){
            this.combo = this.entrada.nextLine();
            this.comboArray = this.combo.split(this.txtDelimitador.getText());
            
            if(this.comboArray[0] != null && this.comboArray[1] != null){
                this.emails += this.comboArray[0]+"\n";
                this.claves += this.comboArray[1]+"\n";
            }else{
                this.emails += "\n";
                this.emails += "\n";
            }
            
            this.i +=1;
        }
        
        this.txtAreaEmails.setText(this.emails);
        this.txtAreaClaves.setText(this.claves);
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
