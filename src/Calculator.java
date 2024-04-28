import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {
    public static void main(String[] args){

        // Frame Settings
        JFrame frame= new JFrame("calculator");
        Dimension frameSize = new Dimension(600,702);
        frame.setSize(frameSize);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(new Color(187,210,232));
        frame.setLayout(null);

        // Monitor
        Label lMonitor = new Label();
        lMonitor.setBackground(Color.WHITE);
        lMonitor.setBounds(100,39,400,39);

        // Panel Button Declaration
        JPanel panel= new JPanel();
        panel.setBounds(100,117, 400,468);
        panel.setBackground(new Color(187,210,232));
        panel.setLayout(new GridLayout(4,3,2,2));
        Button b1 = new Button("1");
        b1.setBackground(new Color(212, 62,196));
        Button b2 = new Button("2");
        b2.setBackground(new Color(212, 62,196));
        Button b3 = new Button("3");
        b3.setBackground(new Color(212, 62,196));
        Button bPlus = new Button("+");
        bPlus.setBackground(new Color(212, 62,196));
        Button b4 = new Button("4");
        b4.setBackground(new Color(150, 62,212));
        Button b5 = new Button("5");
        b5.setBackground(new Color(150, 62,212));
        Button b6 = new Button("6");
        b6.setBackground(new Color(150, 62,212));
        Button bMinus = new Button("-");
        bMinus.setBackground(new Color(150, 62,212));
        Button b7 = new Button("7");
        b7.setBackground(new Color(150, 62,212));
        Button b8 = new Button("8");
        b8.setBackground(new Color(150, 62,212));
        Button b9 = new Button("9");
        b9.setBackground(new Color(150, 62,212));
        Button bTimes = new Button("*");
        bTimes.setBackground(new Color(150, 62,212));
        Button bpart = new Button(".");
        bpart.setBackground(new Color(62, 84,212));
        Button b0 = new Button("0");
        b0.setBackground(new Color(62, 84,212));
        Button bequals = new Button("=");
        bequals.setBackground(new Color(62, 84,212));
        Button bdivide = new Button("/");
        bdivide.setBackground(new Color(62, 84,212));
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(bPlus);
        panel.add(b4);
        panel.add(b5);
        panel.add(b6);
        panel.add(bMinus);
        panel.add(b7);
        panel.add(b8);
        panel.add(b9);
        panel.add(bTimes);
        panel.add(bpart);
        panel.add(b0);
        panel.add(bequals);
        panel.add(bdivide);

        // Three buttom buttons
        Button bDel = new Button("Del");
        Button bManfi = new Button("-");
        Button bClr = new Button("Clr");
        bDel.setBounds(100,624,100,39);
        bClr.setBounds(250, 624, 100, 39);
        bManfi.setBounds(400,624,100,39);


        // actions
        Button[] arr = {b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, bManfi, bMinus, bTimes, bdivide, bpart, bPlus };
        for(Button b : arr){
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    lMonitor.setText(lMonitor.getText() + b.getLabel());
                }
            });
        }


        bequals.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int keeper = 0;
                double num1=0, num2=0, result=0;
                String wholeThing = lMonitor.getText();
                String subNum1="invalid", subNum2= "invalid";
                for(int i =1; i<wholeThing.length(); i++){
                    if (wholeThing.charAt(i)== '+'|| wholeThing.charAt(i)== '-' || wholeThing.charAt(i)== '/'|| wholeThing.charAt(i)== '*'){
                        subNum1 = wholeThing.substring(0,i);
                        subNum2= wholeThing.substring(i+1);
                        keeper = i;
                        break;
                    }
                }

                num1 = Double.parseDouble(subNum1);
                num2= Double.parseDouble(subNum2);
                switch (wholeThing.charAt(keeper)){
                    case '/':
                        result= num1/num2;
                        break;
                    case '+':
                        result= num1+num2;
                        break;
                    case '-':
                        result= num1-num2;
                        break;
                    case '*':
                        result= num1*num2;
                        break;
                }
                lMonitor.setText(String.valueOf(result));
            }
        });
        bDel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String wholeThing = lMonitor.getText();
                if(wholeThing.length()>0){
                    String result = wholeThing.substring(0, wholeThing.length()-1);
                    lMonitor.setText(result);
                }else{
                    lMonitor.setText("");
                }
            }
        });
        bClr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lMonitor.setText("");
            }
        });
        // Frame setters
        frame.add(lMonitor);
        frame.add(panel);
        frame.add(bDel);
        frame.add(bClr);
        frame.add(bManfi);
        frame.setVisible(true);
    }

}
