/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.ipn.www.finalproject.utils;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import javax.imageio.ImageIO;

/**
 *
 * @author Josue Duran
 */
public class QRgenerator {

    /**
     * @param args the command line arguments
     */
    private static final int qrTamAncho = 400;
    private static final int qrTamAlto = 400;
    private static final String formato = "png";
    private static final int randomMin = 100;
    private static final int randomMax = 998;
    
    public static String generateQRContent(String user){
        String result = user;
        try {
            int numero = (int)(Math.random()*(randomMin-randomMax+1)+randomMax);
            result = numero+"-"+result;
            MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(result.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            result += "-"+sb.toString().substring(0, 5);
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
    
    public static void generateQRImage(String content, String name){
        try{
            Writer writer = new QRCodeWriter();
            BitMatrix matriz = writer.encode(content, BarcodeFormat.QR_CODE, qrTamAncho, qrTamAlto);
            BufferedImage imagen = new BufferedImage(qrTamAncho,qrTamAlto, BufferedImage.TYPE_INT_RGB);
            for (int y = 0; y < qrTamAlto; y++) {
                for (int x = 0; x < qrTamAncho; x++) {
                    int valor = (matriz.get(x, y) ? 0 : 1) & 0xff;
                    imagen.setRGB(x, y, (valor == 0 ? 0 : 0xFFFFFF));
                }
            }
            FileOutputStream qrCode = new FileOutputStream(name+".png");
            ImageIO.write(imagen, formato, qrCode);
                
            qrCode.close();
        }catch(Exception e){
            System.out.println(e);
        }   
    }
    
    public static boolean verifyQRContent(String content){
        String[] ver = content.split("-");
        if(ver.length!=3) return false;
        try{
            MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest((ver[0]+"-"+ver[1]).getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            if(ver[2].equals(sb.toString().substring(0, 5))) return true;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
        return false;
    }
}
