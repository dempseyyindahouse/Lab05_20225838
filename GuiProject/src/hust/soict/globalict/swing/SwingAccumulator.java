package hust.soict.globalict.swing; // or hust.soict.dsai.swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0; // Accumulated sum

    public SwingAccumulator() {
        // Set layout
        Container cp = getContentPane();
        cp.setLayout(new FlowLayout());

        // Label and input field
        cp.add(new JLabel("Enter an integer: "));
        tfInput = new JTextField(10);
        cp.add(tfInput);

        // Label and output field
        cp.add(new JLabel("Accumulated sum: "));
        tfOutput = new JTextField(10);
        tfOutput.setEditable(false);
        cp.add(tfOutput);

        // Event listener
        tfInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int number = Integer.parseInt(tfInput.getText());
                    sum += number;
                    tfInput.setText(""); // Clear input field
                    tfOutput.setText(String.valueOf(sum)); // Update sum
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input! Please enter an integer.");
                }
            }
        });

        setTitle("Swing Accumulator");
        setSize(350, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new SwingAccumulator());
    }
}
