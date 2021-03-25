package com.lab6;

import com.lab6.panels.ConfigPanel;
import com.lab6.panels.ControlPanel;
import com.lab6.panels.DrawingPanel;

import javax.swing.*;

import static java.awt.BorderLayout.*;

public class MainFrame extends JFrame {
    public ConfigPanel configPanel;
    ControlPanel controlPanel;
    public DrawingPanel canvas;

    public MainFrame() {
        super("My Drawing Application");
        init();
    }

    private void init() {


        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //create the components
        canvas = new DrawingPanel(this);
        controlPanel=new ControlPanel(this);
        configPanel=new ConfigPanel(this);
        add(controlPanel, SOUTH);
        add(canvas, CENTER);
        add(configPanel,NORTH);

        // TO DO

        this.setSize(1000,600);
        this.setVisible(true);
        pack();
    }


}
