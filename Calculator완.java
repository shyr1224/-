package Calculator;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.*;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import javax.swing.*;
import java.awt.GridLayout;

public class Calculator extends JFrame {
   private double op1 = 0;
   private double op2 = 0;
   private String operator;
   
   
   Calculator(){
      this.setTitle("계산기");
      Image picture = Toolkit.getDefaultToolkit().getImage("calculator.gif");
      this.setIconImage(picture);
      this.setBounds(100,100,400,500);
      this.setLayout(new BorderLayout());
      JTextField display = new JTextField("0");
      display.setFont(new Font("바탕체", Font.BOLD, 80));
      display.setHorizontalAlignment(JTextField.RIGHT);
      JPanel panel = new JPanel();
      panel.setLayout(new GridLayout(4, 4));
      JLabel status = new JLabel("GUI계산기");
      
      
      for (int i = 7; i < 10; i++) {
         JButton btn = new JButton("" + i);
         btn.addActionListener(e-> {
            if(display.getText().equals("0")) {
               display.setText(btn.getText());
            }
            else {
               display.setText(display.getText() + btn.getText());
            }
         });
         panel.add(btn);
      }
      
      JButton btnPlus = new JButton("+");
      btnPlus.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");
         operator = "+";
         status.setText(String.valueOf(op1 + "+"));
      });
      panel.add(btnPlus);
      
      
      for (int i = 4; i < 7; i++) {
          JButton btn = new JButton("" + i);
          btn.addActionListener(e-> {
             if(display.getText().equals("0")) {
                display.setText(btn.getText());
             }
             else {
                display.setText(display.getText() + btn.getText());
             }
          });
          panel.add(btn);
       }
      
      JButton btnMinus = new JButton("-");
      btnMinus.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");
         operator = "-";
      });
      panel.add(btnMinus);
      
      for (int i = 1; i < 4; i++) {
          JButton btn = new JButton("" + i);
          btn.addActionListener(e-> {
             if(display.getText().equals("0")) {
                display.setText(btn.getText());
             }
             else {
                display.setText(display.getText() + btn.getText());
             }
          });
          panel.add(btn);
       }
      JButton btnmultiply = new JButton("×");
      btnmultiply.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");
         operator = "×";
      });
      panel.add(btnmultiply);
      
      
     
      JButton btndivison = new JButton("÷");
      btndivison.addActionListener(e->{
         op1 = Double.parseDouble(display.getText());
         display.setText("0");
         operator = "÷";
      });
      panel.add(btndivison);
      
      for (int i = 0; i < 1; i++) {
          JButton btn = new JButton("" + i);
          btn.addActionListener(e-> {
             if(display.getText().equals("0")) {
                display.setText(btn.getText());
             }
             else {
                display.setText(display.getText() + btn.getText());
             }
          });
          panel.add(btn);
      }
      
      
      JButton btnDot = new JButton(".");
      btnDot.addActionListener(e->{
         if(!display.getText().contains(".")) {
            display.setText(display.getText()+ btnDot.getText());
         }
      });
      panel.add(btnDot);
      
      
      
      JButton btnEqual = new JButton("=");
      btnEqual.addActionListener(e->{
         op2 = Double.parseDouble(display.getText());
         double result = calc(op1, op2, operator);
         display.setText(""+ result);
         status.setText(String.valueOf(op1 + operator + op2));
      });
      panel.add(btnEqual);
      this.add(panel);
   
      
      
      this.add(BorderLayout.NORTH, display);
      this.add(BorderLayout.CENTER, panel);
      this.add(BorderLayout.SOUTH, status);
   }
   
   private double calc(double op1, double op2, String operator) {
      double result = 0;
      switch(operator) {
      case "+":
         result = op1 + op2;
         break;
      case "-":
         result = op1 - op2;
         break;
      case "×":
         result = op1 * op2;
         break;
      case "÷":
         result = op1 / op2;
         break;
      }
      return result;
   }
   
   public static void main(String[] args) {
      new Calculator().setVisible(true);
   }

}