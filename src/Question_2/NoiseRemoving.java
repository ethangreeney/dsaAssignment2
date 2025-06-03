/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Question_2;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author xhu
 */
public class NoiseRemoving {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        JFileChooser imageFileChooser = new JFileChooser(new File("."));
        int stateImageFileChooser = imageFileChooser.showOpenDialog(null);

        JFrame frame = new JFrame("Remove Noise From Image");

        if (stateImageFileChooser != JFileChooser.APPROVE_OPTION) {
            return;
        }

        String fileName = imageFileChooser.getSelectedFile().getPath();
        ImageProcess ip = new ImageProcess(fileName);

        frame.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        JButton saveButton = new JButton("Save image");
        saveButton.setEnabled(false);
        ActionListener saveimageListener = _ -> ip.save("noise_removed.jpg");
        saveButton.addActionListener(saveimageListener);

        JButton denoiseButton = new JButton("Clean image");
        ActionListener denoiseListener = _ -> {
            ip.cleanNoise();
            saveButton.setEnabled(true);
        };
        denoiseButton.addActionListener(denoiseListener);

        frame.add(denoiseButton);
        frame.add(saveButton);
        frame.pack();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }

}
