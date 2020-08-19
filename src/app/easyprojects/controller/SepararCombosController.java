package app.easyprojects.controller;

<<<<<<< HEAD
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

public class SepararCombosController implements Initializable{

    private final Principal principal = new Principal();
    private Principal escenarioPrincipal;
    
    private JFileChooser selectorArchivo;
    private JFileChooser selectorArchivoSave;
    private PrintWriter pw;
    private File archivo;
    private Scanner entrada;
    private String ruta;
    private String saveRuta;
    
    private String emails = "";
    private String claves = "";
    
    private String combo;
    private String[] comboArray;
    
    private String[] correos;
    private String[] contras;
    
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
    
    public void guardarCorreos() throws FileNotFoundException, UnsupportedEncodingException{
        saveFile();
        
        this.correos = this.txtAreaEmails.getText().split("\n");
        this.pw = new PrintWriter(this.saveRuta+".txt", "UTF-8");
        
        for(int i = 0; i < this.correos.length; i++){
            pw.println(this.correos[i]);
        }
        
        pw.close();
        
        JOptionPane.showMessageDialog(null, "Guardado correctamente");
    }
    
    public void guardarClaves() throws FileNotFoundException, UnsupportedEncodingException{
        saveFile();
        
        this.contras = this.txtAreaClaves.getText().split("\n");
        this.pw = new PrintWriter(this.saveRuta+".txt", "UTF-8");
        
        for(int i = 0; i < this.contras.length; i++){
            pw.println(this.contras[i]);
        }
        
        pw.close();
        
        JOptionPane.showMessageDialog(null, "Guardado correctamente");
    }
    
    public void separar() throws FileNotFoundException{
        this.archivo = new File(ruta);
        
        this.entrada = new Scanner(this.archivo);
        
        this.txtAreaEmails.setText("");
        this.txtAreaClaves.setText("");
        
        this.btnSeleccionarArchivo.setText(this.ruta);
        
        this.i = 0;

        float progreso;
        
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
        
        JOptionPane.showMessageDialog(null, "Separados Correctamente");
        
        this.txtAreaEmails.setText(this.emails);
        this.txtAreaClaves.setText(this.claves);
=======
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
>>>>>>> cambios
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
<<<<<<< HEAD
=======
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
>>>>>>> cambios
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
