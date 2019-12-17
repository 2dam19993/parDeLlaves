
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.EncodedKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
 *
 * @author Usuario
 */
public class Encriptador {
    public String descriptar(String mensaje) throws DescriptarException{
        String frase =null;
        File file=new File("F:\\Clase 2DAM\\Cosas_print\\private.key");//Se tiene que cambiar
        try {
            byte[] bytes=Files.readAllBytes(file.toPath());
            byte[] bytesEncript=mensaje.getBytes();
            EncodedKeySpec secretKeySpec = new  PKCS8EncodedKeySpec(bytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            
            PrivateKey privateKey = keyFactory.generatePrivate(secretKeySpec);
            
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            frase=new String(cipher.doFinal(bytesEncript));
            
        } catch (Exception ex) {
            throw new DescriptarException(ex.getMessage());
        }
        return frase;
    }
    
    public String encriptar(String mensaje) throws EncriptarException{
        String encriptado=null;
        try {
            
            File file=new File("F:\\Clase 2DAM\\Cosas_print\\public.key");//se tiene que cambiar
            byte[] bytes=Files.readAllBytes(file.toPath());
            
            EncodedKeySpec publicKeySpec = new  X509EncodedKeySpec(bytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);
            ///asd
            //RSA/ECB/PKCS1Padding
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] cipherText = cipher.doFinal(mensaje.getBytes());
            
            FileOutputStream fos = new FileOutputStream("F:\\Clase 2DAM\\Cosas_print\\percy.unker");
            fos.write(cipherText);
            
        } catch (Exception ex) {
            throw new EncriptarException(ex.getMessage());
        }
        return encriptado;
    }
    
}
