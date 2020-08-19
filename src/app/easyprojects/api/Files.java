package app.easyprojects.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class Files {
    private JFileChooser selectorArchivo;
    private File archivo;
    private Scanner entrada;
    
    private String ruta;
    
    public void Files(){
        this.selectorArchivo = new JFileChooser();
    }
    
    public Scanner readFile() throws FileNotFoundException{
        this.selectorArchivo.showOpenDialog(this.selectorArchivo);
        this.ruta = this.selectorArchivo.getSelectedFile().getAbsolutePath();
        
        this.archivo = new File(ruta);
        
        this.entrada = new Scanner(this.archivo);
        
        return this.entrada;
    }
}
