package app.easyprojects.controller;

import app.easyprojects.system.Principal;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class TemporalMailController implements Initializable{
    private final Principal principal = new Principal();
    private Principal escenarioPrincipal;
    
    @FXML private WebView pagina;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.99 Safari/537.36";
        final WebEngine web = this.pagina.getEngine();
        web.setJavaScriptEnabled(true);
        web.setUserAgent(userAgent);
        String url = "http://tempmail.helpop.rf.gd/";
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
