package calculator1;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Calculator1 extends JFrame implements ActionListener{
    
        JPanel[] row=new JPanel[5];
        JButton[] button=new JButton[19];
        //Making an array of buttons to make it simple to use.
        String[] buttonString={"7","8","9","+","4","5","6","-","1","2","3","*",".","/","C","sq.rt","+/-","=","0"};
        //Setting Dimensions of all buttons.
        Dimension DisplayDimension=new Dimension(275,35);
        Dimension NormalButtons=new Dimension(45,40);
        Dimension RightButtons=new Dimension(100,40);
        Dimension ZeroButton=new Dimension(94,40);
        //function for +,-,*,/
        boolean[] function=new boolean[4];
        double[] temporary={0,0};
        
        JTextArea display=new JTextArea(1,20);
        //Setting Font
        Font font=new Font("Curlz MT Regular",Font.ITALIC,15);
        /**
         * Constructor to
         * Set the Title,Design,Size
         * Setting it resizable false because all the button's size is set constant.
         * Setting how to close it.
         * Setting the grid 5*5.
         */
        Calculator1(){
            super("Calculator");
            setDesign();
            setSize(310,260);
            setResizable(false);
            setDefaultCloseOperation(EXIT_ON_CLOSE); 
            GridLayout grid=new GridLayout(5,5);
            setLayout(grid);
            
            for(int i=0;i<4;i++)
                function[i]=false;
            
            FlowLayout f1=new FlowLayout(FlowLayout.CENTER); 
            FlowLayout f2=new FlowLayout(FlowLayout.CENTER,4,4);
            
            for(int i=0;i<5;i++)
                row[i]=new JPanel();
            
            row[0].setLayout(f1);
            
            for(int i=1;i<5;i++)
                row[i].setLayout(f2);
            
            for(int i=0;i<19;i++){
                button[i]=new JButton();
                button[i].setText(buttonString[i]);
                button[i].setFont(font);
                button[i].addActionListener(this);}
            
            display.setFont(font);
            display.setEditable(false);          
            display.setPreferredSize(DisplayDimension);
            
            for(int i=0;i<14;i++)
                button[i].setPreferredSize(NormalButtons);
            
            for(int i=14;i<18;i++)
                button[i].setPreferredSize(RightButtons);
            
            button[18].setPreferredSize(ZeroButton);
            
            row[0].add(display);            
            add(row[0]);
            
            for(int i=0;i<4;i++)
                row[1].add(button[i]);
            row[1].add(button[14]);
            add(row[1]);
            
            for(int i=4;i<8;i++)
                row[2].add(button[i]);
            row[2].add(button[15]);
            add(row[2]);
            
            for(int i=8;i<12;i++)
                row[3].add(button[i]);
            row[3].add(button[16]);
            add(row[3]);
            
            row[4].add(button[18]);            
            for(int i=12;i<14;i++)
                row[4].add(button[i]);
            row[4].add(button[17]);
            add(row[4]);
            
            setVisible(true);
        }
        /**
         * Setting the design.
         */
        public final void setDesign(){
            try{
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");}
            catch(Exception e){}
            
        }
        /**
         * Clearing the display
         */             
        public void clear(){
            try{
                display.setText("");
            for(int i=0;i<4;i++)
                function[i]=false;
            for(int i=0;i<2;i++)
                temporary[i]=0;
            }
        catch(NullPointerException e){}
        }
        /**
         * Getting Square Root.
         */
        public void getSqrt(){
            try{
            double value=Math.sqrt(Double.parseDouble(display.getText()));
            display.setText(Double.toString(value));}
            catch(NumberFormatException e){}
        }
        /**
         * Making number positive or negative
        */
        public void getPosNeg(){
            try{
                double value=Double.parseDouble(display.getText());
                if(value!=0){
                    value*=(-1);
                    display.setText(Double.toString(value));}
                else{}
            }
                    catch(NumberFormatException e){}
                }
        /**
         * Definition when = button is clicked.
         */
        public void EqualsTo(){
        double result=0;
        temporary[1]=Double.parseDouble(display.getText());
        String temp0=Double.toString(temporary[0]);
        String temp1=Double.toString(temporary[1]);
        
        try{
            if(function[2]==true)
                result=temporary[0]*temporary[1];
            else if(function[3]==true)
                result=temporary[0]/temporary[1];
            else if(function[0]==true)
                result=temporary[0]+temporary[1];
            else if(function[1]==true)
                result=temporary[0]-temporary[1];
            
            display.setText(Double.toString(result));
            
            for(int i=0;i<4;i++)
                function[i]=false;
        }
        
        catch(NumberFormatException e){}
        }
        //All the Action Performed
        @Override
        public void actionPerformed(java.awt.event.ActionEvent ae){
            if(ae.getSource()==button[0])
                display.append("7");
            if(ae.getSource()==button[1])
                display.append("8");
            if(ae.getSource()==button[2])
                display.append("9");
            if(ae.getSource()==button[3]){
                temporary[0]=Double.parseDouble(display.getText());
                function[0]=true;
                display.setText("");}
            
            if(ae.getSource()==button[4])
                display.append("4");
            if(ae.getSource()==button[5])
                display.append("5");
            if(ae.getSource()==button[6])
                display.append("6");
            if(ae.getSource()==button[7]){
                temporary[0]=Double.parseDouble(display.getText());
                function[1]=true;
                display.setText("");}
            
            if(ae.getSource()==button[8])
                display.append("1");
            if(ae.getSource()==button[9])
                display.append("2");
            if(ae.getSource()==button[10])
                display.append("3");
            if(ae.getSource()==button[11]){
                temporary[0]=Double.parseDouble(display.getText());
                function[2]=true;
                display.setText("");}
            
            if(ae.getSource()==button[12])
                display.append(".");
            
            if(ae.getSource()==button[13]){
                temporary[0]=Double.parseDouble(display.getText());
                function[3]=true;
                display.setText("");}
            
            if(ae.getSource()==button[14])
                clear();
            
            if(ae.getSource()==button[15])
                getSqrt();
            
            if(ae.getSource()==button[16])
                getPosNeg();
            
            if(ae.getSource()==button[17])
                EqualsTo();
            
            if(ae.getSource()==button[18])
                display.append("0");
            }
        
        public static void main(String[] args){
            Calculator1 c=new Calculator1();
        }
}               