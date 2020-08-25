package app.easyprojects.controller;

import app.easyprojects.api.NavegatorApi;
import app.easyprojects.system.Principal;
import java.io.IOException;
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
    
    private NavegatorApi navegatorApi = new NavegatorApi();
    
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
    
    public void setBorrarRepetidos() {
        escenarioPrincipal.ventanaBorrarRepetidos();
    }
    
    public void setBorrarTextos() {
        escenarioPrincipal.ventanaBorrarTextos();
    }
    
    public void abrirVentana() throws IOException{
        this.navegatorApi.abrirNavegadorPorDefecto("https://www.youtube.com/channel/UCTDilMoOGFanqQLwWSZLJAw");
    }
}

