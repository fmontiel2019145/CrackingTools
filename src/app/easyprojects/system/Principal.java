package app.easyprojects.system;

import app.easyprojects.controller.BinCheckerController;
import app.easyprojects.controller.BlogController;
import app.easyprojects.controller.BorrarRepetidosController;
import app.easyprojects.controller.BorrarTextosController;
import app.easyprojects.controller.CcGenController;
import app.easyprojects.controller.MenuPrincipalController;
import app.easyprojects.controller.ProxysController;
import app.easyprojects.controller.SepararCombosController;
import java.io.InputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 *
 * @author DELL
 */
public class Principal extends Application {
    private Stage escenarioPrincipal;
    private Scene escena; 
    private final String PAQUETE_VISTA = "/app/easyprojects/view/";
    
    @Override
    public void start(Stage escenarioPrincipal) throws Exception {
        this.escenarioPrincipal = escenarioPrincipal;
        this.escenarioPrincipal.setTitle("CrackingTools - EasyProjects");
        escenarioPrincipal.getIcons().add(new Image("/app/easyprojects/image/icono.png"));
        //Parent root = FXMLLoader.load(getClass().getResource("/org/noelaguirre/view/MenuPrincipalView.fxml"));
        //Scene escena = new Scene(root);
        //escenarioPrincipal.setScene(escena);
        menuPrincipal();
        escenarioPrincipal.show();
    }
    
    public void menuPrincipal(){
        try{
            MenuPrincipalController menuPrincipal = (MenuPrincipalController)cambiarEscena("MenuPrincipalView.fxml",600,406);
            menuPrincipal.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void ventanaSepararCombos(){
        try{
            SepararCombosController sc = (SepararCombosController)cambiarEscena("SepararCombosView.fxml",876,458);
            sc.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void ventanaBorrarRepetidos(){
        try{
            BorrarRepetidosController sc = (BorrarRepetidosController)cambiarEscena("BorrarRepetidosView.fxml", 586, 458);
            sc.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void ventanaBorrarTextos(){
        try{
            BorrarTextosController sc = (BorrarTextosController)cambiarEscena("BorrarTextosView.fxml", 586, 458);
            sc.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void ventanaCcGen(){
        try{
            CcGenController sc = (CcGenController)cambiarEscena("CcGenView.fxml", 892, 623);
            sc.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void ventanaBinChecker(){
        try{
            BinCheckerController sc = (BinCheckerController)cambiarEscena("BinCheckerView.fxml", 892, 623);
            sc.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void ventanaBlog(){
        try{
            BlogController sc = (BlogController)cambiarEscena("BlogView.fxml", 892, 623);
            sc.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void ventanaProxys(){
        try{
            ProxysController sc = (ProxysController)cambiarEscena("ProxysView.fxml", 892, 623);
            sc.setEscenarioPrincipal(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public Initializable cambiarEscena(String fxml, int ancho, int alto) throws Exception{
        Initializable resultado = null;
        FXMLLoader cargadorFXML = new FXMLLoader();
        InputStream archivo = Principal.class.getResourceAsStream(PAQUETE_VISTA + fxml);
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        cargadorFXML.setLocation(Principal.class.getResource(PAQUETE_VISTA + fxml));
        escena = new Scene((AnchorPane)cargadorFXML.load(archivo),ancho,alto);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.sizeToScene();
        resultado = (Initializable)cargadorFXML.getController();
        
        return resultado;
    }
}
