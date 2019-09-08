/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamcapturetraining;

import com.github.sarxos.webcam.Webcam;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author admin
 */
public class ImagesSavingThread extends Thread{
private String savingPath;
private Webcam webcam;
private int imageCount = 0;
private int savingPause = 500;
   
public ImagesSavingThread(Webcam webcam) {
        this.webcam = webcam;
    }

    public void setSavingPause(int savingPause) {
        this.savingPause = savingPause;
    }


    @Override
    public void run() {
        try {
            for(int i=0; i<20; i++){
                
            savingPath = "SavedImages/" + imageCount+".jpg";
            System.out.println(savingPath);
            imageCount++;
            BufferedImage image = webcam.getImage();
            ImageIO.write(image, "JPG",new File(savingPath) );  
            System.out.println("Thread is sleping for " + savingPause);
            Thread.sleep(savingPause);
           
            }
      
        } 
       
        catch(IOException e){
            e.printStackTrace();
    }
        catch (InterruptedException ex) {
        Logger.getLogger(ImagesSavingThread.class.getName()).log(Level.SEVERE, null, ex);
    }
        
       
    }
    
    
     
    
}
