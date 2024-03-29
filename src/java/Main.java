
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
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
public class Main {
    public static void main(String[] args) {
        try {
            KeyPairGenerator keyPairGenerator =  KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(1024);
            KeyPair kp = keyPairGenerator.generateKeyPair();
            
            PrivateKey privateKey = kp.getPrivate();
            PublicKey publicKey = kp.getPublic();
            
            guardarClavePrivada(privateKey);
            guardarClavePublica(publicKey);
            
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private static void guardarClavePrivada(PrivateKey privateKey) {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(privateKey.getEncoded());
        try {
            //FileOutputStream fos = new FileOutputStream("C:\\Users\\2dam.TARTANGALH\\Desktop\\Software\\print\\private.key");
            FileOutputStream fos = new FileOutputStream("F:\\Clase 2DAM\\Cosas_print\\private.key");
            fos.write(spec.getEncoded());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    private static void guardarClavePublica(PublicKey publicKey) {
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(publicKey.getEncoded());
        try {
            //FileOutputStream fos = new FileOutputStream("C:\\Users\\2dam.TARTANGALH\\Desktop\\Software\\print\\public.key");
            FileOutputStream fos = new FileOutputStream("F:\\Clase 2DAM\\Cosas_print\\public.key");
            fos.write(spec.getEncoded());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
