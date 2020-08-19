/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.easyprojects.api;

import java.io.IOException;

/**
 *
 * @author DELL
 */
public class NavegatorApi {
    public void abrirNavegadorPredeterminadorWindows(String url) throws IOException{
        Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + url);
    }
    public void abrirNavegadorPredeterminadorLinux(String url) throws IOException{
        Runtime.getRuntime().exec("xdg-open " + url);
    }
    public void abrirNavegadorPredeterminadorMacOsx(String url) throws IOException{
        Runtime.getRuntime().exec("open " + url);
    }
    
    public void abrirNavegadorPorDefecto(String url) throws IOException{
        String osName = System.getProperty("os.name");
        if(osName.contains("Windows"))
            abrirNavegadorPredeterminadorWindows(url);
        else if(osName.contains("Linux"))
            abrirNavegadorPredeterminadorLinux(url);
        else if(osName.contains("Mac OS X"))
            abrirNavegadorPredeterminadorMacOsx(url);
    }
}
