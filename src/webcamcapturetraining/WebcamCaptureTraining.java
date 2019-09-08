/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamcapturetraining;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author admin
 */
public class WebcamCaptureTraining {

    /**
     * @param args the command line arguments
     */
    public void initWebCam(){
        
    }
    
    public static void main(String[] args) throws IOException {
    

        MyJframe myJframe = new MyJframe();
        myJframe.start();
    }

    
}
