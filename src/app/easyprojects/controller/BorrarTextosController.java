package app.easyprojects.controller;

import app.easyprojects.system.Principal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class BorrarTextosController implements Initializable{

    private final Principal principal = new Principal();
    private Principal escenarioPrincipal;
    
    private JFileChooser selectorArchivo;
    private JFileChooser selectorArchivoSave;
    private PrintWriter pw;
    private File archivo;
    private Scanner entrada;
    private String ruta;
    private String saveRuta;
    
    
    private String combo;
    private String[] comboArray;
   
    
    private int i;
    
    @FXML private Button btnSeleccionarArchivo;
    @FXML private TextField txtBuscar;
    @FXML private TextField txtRemplazar;
    
    @FXML private TextArea txtArea;
    
    public void getFile() {
        this.selectorArchivo = new JFileChooser();
        this.selectorArchivo.showOpenDialog(this.selectorArchivo);
        
        try{
            this.ruta = this.selectorArchivo.getSelectedFile().getAbsolutePath();
            this.btnSeleccionarArchivo.setText(ruta);    
        }catch(Exception e){
            this.btnSeleccionarArchivo.setText("Seleccionar Combo");
            //JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void saveFile(){
        JOptionPane.showMessageDialog(null, "Selecciona el archivo donde se guardaran los datos");
        
        this.selectorArchivoSave = new JFileChooser();
        this.selectorArchivoSave.showOpenDialog(this.selectorArchivoSave);
        
        try{
            this.saveRuta = this.selectorArchivoSave.getSelectedFile().getAbsolutePath();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    public void guardar() throws FileNotFoundException, UnsupportedEncodingException{
        saveFile();
        
        /*this.correos = this.txtArea.getText().split("\n");
        this.pw = new PrintWriter(this.saveRuta+".txt", "UTF-8");
        
        for(int i = 0; i < this.correos.length; i++){
            pw.println(this.correos[i]);
        }*/
        
        pw.close();
        
        JOptionPane.showMessageDialog(null, "Guardado correctamente");
    }
    
    public void borrar() throws FileNotFoundException{
        this.archivo = new File(ruta);
        
        this.entrada = new Scanner(this.archivo);
        
        this.txtArea.setText("");
        
        this.btnSeleccionarArchivo.setText(this.ruta);
        
        this.i = 0;

        String resultado = "";
        
        while(this.entrada.hasNext()){
            this.combo = this.entrada.nextLine();

            resultado += this.combo.replace(this.txtBuscar.getText(), this.txtRemplazar.getText())+"\n";

            
            this.i +=1;
        }
        
        JOptionPane.showMessageDialog(null, "Separados Correctamente");
        
        this.txtArea.setText(resultado);
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
