package com.lab6.panels;

import com.lab6.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Map;
import java.util.Random;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JSpinner sidesField; // number of sides
    JLabel sidesLabel;
    JComboBox<String> colorCombo; // the color of the shape
    JButton newColorBtn = new JButton("New random color");
    JComboBox<String> shapes; //the Shape
    JComboBox<String> addOrRemove;


    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init() {
        //create the label and the spinner
        sidesLabel = new JLabel("Number of sides:");
        sidesField = new JSpinner(new SpinnerNumberModel(3, 3, 100, 1));
        sidesField.setValue(6); //default number of sides
        //create the colorCombo, containing the values: Random and Black
        colorCombo=new JComboBox<String>();
        colorCombo.addItem("Black");
        colorCombo.addItem("Random");

        shapes=new JComboBox<String>();
        shapes.addItem("Regular Polygon");
        shapes.addItem("NodeShape");
        shapes.addItem("Free Drawing");


        addOrRemove=new JComboBox<String>();
        addOrRemove.addItem("Add");
        addOrRemove.addItem("Remove");
        newColorBtn.addActionListener(this::newColor);


        add(addOrRemove);
        add(shapes);
        add(sidesLabel); //JPanel uses FlowLayout by default
        add(sidesField);
        add(colorCombo);
        add(newColorBtn);
    }

    private void newColor(ActionEvent actionEvent) {
        frame.canvas.colors.put("Random",new Color(new Random().nextInt(128) + 128, new Random().nextInt(128) + 128, new Random().nextInt(128) + 128));
    }


}

