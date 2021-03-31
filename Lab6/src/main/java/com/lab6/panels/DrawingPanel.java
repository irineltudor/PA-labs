package com.lab6.panels;

import com.lab6.MainFrame;
import com.lab6.shapes.FreeDrawing;
import com.lab6.shapes.RegularPolygon;
import com.lab6.shapes.NodeShape;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Random;



public class DrawingPanel extends JPanel {
    final MainFrame frame;
    final static int W = 800, H = 600;
    BufferedImage image; //the offscreen image
    Graphics2D graphics; //the "tools" needed to draw in the image
    LinkedList<Shape> shapes= new LinkedList<>();
    LinkedList<Color> shapesColor= new LinkedList<>();
    HashMap<String,Color> colors= new HashMap<>();

    public DrawingPanel(MainFrame frame) {
        this.frame = frame; createOffscreenImage(); init();
    }
    public DrawingPanel(MainFrame frame,BufferedImage image) {
        this.frame = frame;
        this.image= image;
        graphics = this.image.createGraphics();
        init();
    }
    private void createOffscreenImage() {
        image = new BufferedImage(W, H, BufferedImage.TYPE_INT_ARGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE); //fill the image with white
        graphics.fillRect(0, 0, W, H);
    }
    private void init() {
        setPreferredSize(new Dimension(W, H)); //don’t use setSize. Why?
        setBorder(BorderFactory.createEtchedBorder()); //for fun
        colors.put("Black",new Color(0,0,0));
        colors.put("Random",new Color(new Random().nextInt(128) + 128, new Random().nextInt(128) + 128, new Random().nextInt(128) + 128));
        MouseAdapter mouse=new MouseAdapter() {
            FreeDrawing freeDrawing=new FreeDrawing();
            @Override
            public void mousePressed(MouseEvent e) {


                if(frame.configPanel.addOrRemove.getSelectedItem()=="Add"&&frame.configPanel.shapes.getSelectedItem()!="Free Drawing") {
                    drawShape(e.getX(), e.getY());


                }
                else {
                    if(frame.configPanel.addOrRemove.getSelectedItem()=="Remove")
                    deleteShape(e.getX(),e.getY());
                    else{
                        freeDrawing.addNew(e.getX(),e.getY());
                    }


                }
                repaint();

            }

            @Override
            public void mouseDragged(MouseEvent e) {

                if(frame.configPanel.addOrRemove.getSelectedItem()=="Add" && frame.configPanel.shapes.getSelectedItem()=="Free Drawing")
                {   Color color;
                    if(frame.configPanel.colorCombo.getSelectedItem()=="Black")
                {
                    color=colors.get("Black");
                }
                else{
                    color=colors.get("Random");
                }
                graphics.setColor(color);
                graphics.drawLine(freeDrawing.getCurrentX(),freeDrawing.getCurrentY(),e.getX(),e.getY());
                    freeDrawing.addNew(e.getX(),e.getY());

                    repaint();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e)
            {   int[] circleInfo=new int[3];
                circleInfo= freeDrawing.getCircleInfo();
                if(circleInfo[2]!=0)
                {
                    graphics.fill(new NodeShape(circleInfo[0],circleInfo[1],circleInfo[2]));
                }
                freeDrawing.deleteList();

            }
        };

        this.addMouseListener(mouse);
        this.addMouseMotionListener(mouse);
    }
    private void drawShape(int x, int y) {
        if(frame.configPanel.shapes.getSelectedItem()=="Regular Polygon") {
            int radius = new Random().nextInt(20) + 5;
            int sides = (Integer) frame.configPanel.sidesField.getValue();///get the value from UI (in ConfigPanel)
            Color color; //Value got from selected item in ColorCombo
            if(frame.configPanel.colorCombo.getSelectedItem()=="Black")
            {
                color=colors.get("Black");
            }
            else{
                color=colors.get("Random");
            }
            graphics.setColor(color);
            graphics.fill(new RegularPolygon(x, y, radius, sides));
            shapes.add(new RegularPolygon(x, y, radius, sides));
            shapesColor.add(color);
        }
        else
        {  if(frame.configPanel.shapes.getSelectedItem()=="NodeShape") {
            int radius = new Random().nextInt(20) + 5;
            Color color;
            if (frame.configPanel.colorCombo.getSelectedItem() == "Black") {
                color = colors.get("Black");
            } else {
                color = colors.get("Random");
            }
            graphics.setColor(color);
            graphics.fill(new NodeShape(x, y, radius));
            shapes.add(new NodeShape(x, y, radius));
            shapesColor.add(color);
        }

        }
    }

    private void deleteShape(int x,int y){
        int savedI =-1;
        for (int i = 0; i < shapes.size(); i++) {

            if(shapes.get(i).contains(x,y)) {
                savedI = i;
            }
        }
        if(savedI >= 0) {
            graphics.setColor(new Color(255, 255, 255));
            graphics.fill(shapes.get(savedI));
            for (int i = 0; i < shapes.size(); i++) {
                if(i!=savedI)
                {
                    if(shapes.get(i).intersects(shapes.get(savedI).getBounds2D()))
                    {
                        graphics.setColor(shapesColor.get(i));
                        graphics.fill(shapes.get(i));
                    }
                }
            }
            shapes.remove(savedI);
            shapesColor.remove(savedI);
        }

    }
    @Override
    public void update(Graphics g) { } //Why did I do that?

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}

