
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class MainPruebas {
    public static void main(String[] args) {
        try {
            Encriptador en=new Encriptador();
            String texto = "Red Carmesi Blood";
            System.out.println(en.descriptar2(en.encriptar2(texto)));
            System.out.println(en.descriptar(en.encriptar(texto)));
        } catch (Exception ex) {
            Logger.getLogger(MainPruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
}
