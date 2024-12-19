package hust.soict.globalict.swing; // or hust.soict.dsai.swing

import java.awt.*;
import java.awt.event.*;

public class AWTAccumulator extends Frame {
    private TextField tfInput;
    private TextField tfOutput;
    private int sum = 0; // Accumulated sum

    public AWTAccumulator() {
        setLayout(new FlowLayout());

        // Label and input field
        add(new Label("Enter an integer: "));
        tfInput = new TextField(10);
        add(tfInput);

        // Label and output field
        add(new Label("Accumulated sum: "));
        tfOutput = new TextField(10);
        tfOutput.setEditable(false);
        add(tfOutput);

        // Event listener
        tfInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int number = Integer.parseInt(tfInput.getText());
                sum += number;
                tfInput.setText(""); // Clear input field
                tfOutput.setText(String.valueOf(sum)); // Update sum
            }
        });

        setTitle("AWT Accumulator");
        setSize(300, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new AWTAccumulator();
    }
}