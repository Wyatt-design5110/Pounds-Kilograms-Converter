import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

/*
 * Mason Kubiak and Wyatt Gaines
 * CSCI 185 M01
 * Build a more advanced GUI Lab
 */

public class Converter extends JFrame implements ActionListener{
    JTextField poundInput = new JTextField();
    JTextField kiloInput = new JTextField();
    String userInputPounds="";
    String userInputKgs="";
    double userNumberPounds;
    double userNumberKgs;
    double convertedPounds;
    double convertedKgs;

    DecimalFormat df = new DecimalFormat("#.###");

    public Converter(){
        setLayout(new GridLayout(2, 2, 5, 5));
        setSize(500,200);
        poundInput.addActionListener(this);
        kiloInput.addActionListener(this);
        add(new JLabel("Pounds:"));
        add(poundInput);
        add(new JLabel("Kilograms:"));
        add(kiloInput);
    }

    public void actionPerformed(ActionEvent e){
        try{
            if((e.getSource() == poundInput) && !(kiloInput.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Please only input one value to convert at a time.");
                poundInput.setText("");
                kiloInput.setText("");
            } else if((e.getSource() == kiloInput) && !(poundInput.getText().isEmpty())){
                JOptionPane.showMessageDialog(null, "Please only input one value to convert at a time.");
                poundInput.setText("");
                kiloInput.setText("");
            } else if((e.getSource() == poundInput) && (kiloInput.getText().isEmpty())){
                userInputPounds = poundInput.getText();
                userNumberPounds = Double.parseDouble(userInputPounds);
                convertedKgs = calcKilo(userNumberPounds);
                JOptionPane.showMessageDialog(null, userNumberPounds + "lbs is equal to " + df.format(convertedKgs) + "kg.");
                poundInput.setText("");
            } else if((e.getSource() == kiloInput) && (poundInput.getText().isEmpty())){
                userInputKgs = kiloInput.getText();
                userNumberKgs = Double.parseDouble(userInputKgs);
                convertedPounds = calcPounds(userNumberKgs);
                JOptionPane.showMessageDialog(null, userNumberKgs + "kgs is equal to " + df.format(convertedPounds) + "lbs.");
                kiloInput.setText("");
            }else{
                JOptionPane.showMessageDialog(null, "How did you get this error?");
            }
        }catch(NumberFormatException nfe){
            JOptionPane.showMessageDialog(null, "Please input a valid value to convert.");
        }
    }

    public double calcPounds(double kilograms){
        double numOfPounds = kilograms * 2.205;
        return numOfPounds;
    }

    public double calcKilo(double pounds){
        double numOfKilos = pounds / 2.205;
        return numOfKilos;
    }

    public static void main(String args[]){
        Converter frame = new Converter();
        frame.setTitle("Measurement Unit Converter");
        frame.setVisible(true);
    }
}