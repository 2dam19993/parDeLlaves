
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 2dam
 */
public class Main2 {
    public static void main(String[] args) {
        String texto = "Red Carmesi Blood";
        try {
            FileInputStream fis =new FileInputStream("C:\\Users\\2dam.TARTANGALH\\Desktop\\Software\\print\\public.key");
            //byte[] bytes=fi
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
