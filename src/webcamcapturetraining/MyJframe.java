/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webcamcapturetraining;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class MyJframe {
     private JFrame window;
     private Webcam webcam;
     private WebcamPanel webcamPanel;
     private JPanel controlJPanel;
     private JComboBox<Webcam> webcamBox;
     private List<Webcam> webcamList;
     private JButton changeButton;
     private JComboBox<Integer> saveTimeBox;
     private JCheckBox saveCheckBox;
     private ImagesSavingThread imagesSavingThread;

    
    public MyJframe() {
       initWebcamPanel();
       initWebcamBox();
       initsaveTimeBox();
       initChangeButton();
       initCheckBox();
       initControlPanel();
       initWindow();
       imagesSavingThread = new ImagesSavingThread(webcam);
       
    }
    
    private void initWebcamPanel(){
        webcam = Webcam.getDefault();
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setSize(webcam.getViewSize());
       
    }
    private void initWebcamPanel(Webcam customWebcam){
        webcam = customWebcam;
        webcam.setViewSize(WebcamResolution.VGA.getSize());
        webcamPanel = new WebcamPanel(webcam);
        webcamPanel.setSize(webcam.getViewSize());
    }
    private void initChangeButton(){
        changeButton = new JButton("CHANGE");
        changeButton.addActionListener(changeButtonActionListener);
    }
    
    private void initWebcamBox(){
        webcamBox = new JComboBox<>();
        webcamBox.setSize(300, 20);

        webcamList = Webcam.getWebcams();
          for (Iterator<Webcam> iterator = webcamList.iterator(); iterator.hasNext();) {
            Webcam next = iterator.next();
            webcamBox.addItem(next);
            System.out.println(next.getName());
        }
    }
    private  void initCheckBox(){
        saveCheckBox = new JCheckBox("SAVE", false);
        saveCheckBox.addActionListener(savingCheckBoxActionListener);
        //saveCheckBox.setVisible(true);
    }
    
    private  void initsaveTimeBox(){
        saveTimeBox = new JComboBox<>(new Integer[] {100,300,500,1000, 2000, 3000});
        saveTimeBox.addActionListener(saveTimeBoxActionListener);
    }
     
    private void initControlPanel(){
        
        controlJPanel = new JPanel();
        //controlJPanel.setLayout(null);
        controlJPanel.setBounds(5, webcamPanel.getHeight()+5, webcamPanel.getWidth()-10, 80);
        controlJPanel.setBackground(Color.GRAY);
        controlJPanel.add(webcamBox);
        controlJPanel.add(changeButton);
        controlJPanel.add(saveTimeBox);
        controlJPanel.add(saveCheckBox);
        controlJPanel.setVisible(true);
    }
    
    private void initWindow(){
        window = new JFrame("Test webcam panel");
        window.setLayout(null);
        window.setSize(webcamPanel.getWidth(), webcamPanel.getHeight() + controlJPanel.getHeight() + 40 );
        
        window.setResizable(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(webcamPanel);
        window.add(controlJPanel);
        window.setVisible(true);
    }
    public void start(){
        webcam.open();
    }
    
   
   
    ActionListener changeButtonActionListener = (ActionEvent e) -> {
        webcam.close();
        webcam = (Webcam)webcamBox.getSelectedItem();
        window.remove(webcamPanel);
        
        initWebcamPanel(webcam);
        window.add(webcamPanel);
     };
   
    
    ActionListener savingCheckBoxActionListener = (ActionEvent e) -> {
        if(saveCheckBox.isSelected()){
            imagesSavingThread.start();
        }
        else{
            
            //need to write
            
            
        }
     };

    ActionListener saveTimeBoxActionListener = (ActionEvent e) -> {
        imagesSavingThread.setSavingPause((int)saveTimeBox.getSelectedItem());
     };
    public Webcam getWebcam() {
        return webcam;
    }
    
    public int getSavingPause(){
       
       return (int)saveTimeBox.getSelectedItem();
    }
     
    
    
}
