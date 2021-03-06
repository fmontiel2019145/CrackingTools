package app.easyprojects.controller;

import app.easyprojects.system.Principal;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.Set;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class BorrarRepetidosController implements Initializable{

    private final Principal principal = new Principal();
    private Principal escenarioPrincipal;
    
    private JFileChooser selectorArchivo;
    private JFileChooser selectorArchivoSave;
    private PrintWriter pw;
    private File archivo;
    private Scanner entrada;
    private List<String> colores = new ArrayList<String>();
    
    private String ruta;
    private String saveRuta;
    
    private String combo = "";
    
    private String[] correos;
    
    private int i;
    
    @FXML private Button btnSeleccionarArchivo;
    @FXML private TextArea txtAreaEmails;
    @FXML private TextArea txtAreaClaves;
    @FXML private TextField txtDelimitador;
    @FXML private ProgressIndicator proInProgreso;
    
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
        
        this.correos = this.txtAreaEmails.getText().split("\n");
        this.pw = new PrintWriter(this.saveRuta+".txt", "UTF-8");
        
        for(int i = 0; i < this.correos.length; i++){
            pw.println(this.correos[i]);
        }
        
        pw.close();
        
        JOptionPane.showMessageDialog(null, "Guardado correctamente");
    }
    
    public void lineas() throws FileNotFoundException{
        this.archivo = new File(ruta);
        
        this.entrada = new Scanner(this.archivo);
        
        while(this.entrada.hasNext()){
            this.colores.add(this.entrada.nextLine());
        }
    }
    
    public void borrar() throws FileNotFoundException{
        
        lineas();
         
        Set<String> hashSet = new HashSet<String>(this.colores);
        colores.clear();
        colores.addAll(hashSet);
        
        for (String s : colores) {
            this.combo += s+"\n";
        }
        
        this.txtAreaEmails.setText(this.combo);
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
    
    public void ventanaBorrarRepetidos(){
        escenarioPrincipal.ventanaBorrarRepetidos();
    }
    
    public void menuPrincipal(){
        escenarioPrincipal.menuPrincipal();
    }
}
