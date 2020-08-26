package app.easyprojects.controller;

import app.easyprojects.system.Principal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class BlogController implements Initializable{
    private final Principal principal = new Principal();
    private Principal escenarioPrincipal;
    
    @FXML private WebView pagina;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        final WebEngine web = this.pagina.getEngine();
        String url = "https://dev-easyprojects.blogspot.com/";
        web.load(url);
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
