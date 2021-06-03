package binaryQuizGui;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class binaryQuizGui extends Frame implements ActionListener{
    JFrame f;
    JLabel h, b, a;
    JTextField t;
    JButton s, r;
    // Random Integer that is used to determine the binary for
    int i = Integer.parseInt(RandomInt()); 

    binaryQuizGui() {
        f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Header
        h = new JLabel("Binary Quiz");
        h.setBounds(100,10,100,30);
        f.add(h);

        // Binary Labal
        b = new JLabel(Integer.toString(i));
        b.setBounds(75,50,100,30);
        f.add(b);

        // Answer Label
        a = new JLabel();
        a.setBounds(75,200,100,30);
        f.add(a);

        // TextBox
        t = new JTextField();
        t.setBounds(75,100,100,30);
        f.add(t);

        // Submit Button
        s = new JButton("Submit");
        s.setBounds(75,150,100,40);
        s.addActionListener(this);
        f.add(s);
        
        // Reset Button
        Icon icon = new ImageIcon("reset2.png");
        r = new JButton(icon);
        r.setBounds(100,250,50,50);
        r.addActionListener(this);
        f.add(r);

        // JFrame size and visibility
        f.setSize(300,400);
        f.setLayout(null);
        f.setVisible(true);
    }

    public static void main(String[] args) {
        new binaryQuizGui();
    }

    // Action Buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        // Submit button
        if (e.getSource() == s) {
            try{
                // if input equals the integer i in binary
                if (isSame(t.getText(), i)) {
                    a.setText("Correct!");
                } else {
                    a.setText("Wrong!");
                }
            }catch(Exception ex) {
                a.setText("INVALID INPUT");
            }
        }
        // Reset Button
        if (e.getSource() == r) {
            a.setText("");
            t.setText("");
            // Create new random int to determine binary for
            i = Integer.parseInt(RandomInt());
            b.setText(Integer.toString(i));
        }
    }
    // Converts Decimal to Binary
    public static int DecimalToBinary(int num2) {
        String bin = Integer.toBinaryString(num2);
        int bin1 = Integer.parseInt(bin);
        return bin1;
    }
    // Generates random integer as STRING
    public static String RandomInt() {
        int max = 255;
        int min = 0;
        String r = Integer.toString((int)((Math.random() * (max - min)) + min));
        // RETURNS STRING
        return r;
    }
    // Verifies that integer value and binary input value are equal
    public static boolean isSame(String bin, int i) {
        if (DecimalToBinary(i) == (Integer.parseInt(bin))) {
            return true;
        }
        return false;
    }
}