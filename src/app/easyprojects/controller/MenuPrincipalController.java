package app.easyprojects.controller;

<<<<<<< HEAD
import app.easyprojects.api.NavegatorApi;
import app.easyprojects.system.Principal;
import java.io.IOException;
=======
<<<<<<< HEAD
import app.easyprojects.api.NavegatorApi;
import app.easyprojects.system.Principal;
import java.io.IOException;
=======
import app.easyprojects.system.Principal;
>>>>>>> cambios
>>>>>>> cambios
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

/**
 *
 * @author EasyProjects
 */
public class MenuPrincipalController implements Initializable {
    
<<<<<<< HEAD
    private NavegatorApi navegatorApi = new NavegatorApi();
    
=======
<<<<<<< HEAD
    private NavegatorApi navegatorApi = new NavegatorApi();
    
=======
>>>>>>> cambios
>>>>>>> cambios
    private Principal escenarioPrincipal;
    
    @FXML private Button btnSepararCombos;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    public void setEscenarioPrincipal(Principal escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }
    
    public Principal getEscenarioPrincipal() {
        return escenarioPrincipal;
    }
    
    public void setSeparadorCombos() {
        escenarioPrincipal.ventanaSepararCombos();
    }
<<<<<<< HEAD
=======
<<<<<<< HEAD
>>>>>>> cambios
    
    public void setBorrarRepetidos() {
        escenarioPrincipal.ventanaBorrarRepetidos();
    }
    
    public void setBorrarTextos() {
        escenarioPrincipal.ventanaBorrarTextos();
    }
    
    public void abrirVentana() throws IOException{
        this.navegatorApi.abrirNavegadorPorDefecto("https://www.youtube.com/channel/UCTDilMoOGFanqQLwWSZLJAw");
    }
<<<<<<< HEAD
=======
=======
>>>>>>> cambios
>>>>>>> cambios
}

