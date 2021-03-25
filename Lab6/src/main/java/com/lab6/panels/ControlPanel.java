package com.lab6.panels;

import com.lab6.MainFrame;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton saveBtn = new JButton("Save");
    JButton loadBtn = new JButton("Load");
    JButton resetBtn = new JButton("Reset");
    JButton exitBtn = new JButton("Exit");
 //TO DO
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //change the default layout manager (just for fun)
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(resetBtn);
        add(exitBtn);

        saveBtn.addActionListener(e -> {
            try {
                save(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        loadBtn.addActionListener(e -> {
            try {
                load(e);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });
        resetBtn.addActionListener(this::reset);
        exitBtn.addActionListener(this::exit);
        //TO DO
    }
    private void save(ActionEvent e) throws IOException {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir","E:\\work\\Facultate\\PA-labs\\Lab6")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            ImageIO.write(frame.canvas.image, "PNG", selectedFile);
        }
    }
    private void load(ActionEvent e) throws IOException{
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir","E:\\work\\Facultate\\PA-labs\\Lab6")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            frame.remove(frame.canvas);
            frame.canvas=new DrawingPanel(frame,ImageIO.read(selectedFile));
            frame.add(frame.canvas);
            frame.setVisible(true);
        }

    }
    private void reset(ActionEvent e){
        frame.remove(frame.canvas);
        frame.canvas=new DrawingPanel(frame);
        frame.add(frame.canvas);
        frame.setVisible(true);

    }
    private void exit(ActionEvent e)
    {
        System.exit(0);
    }
    //TO DO
}

