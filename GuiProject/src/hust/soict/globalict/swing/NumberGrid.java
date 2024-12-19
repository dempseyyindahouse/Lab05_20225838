package hust.soict.globalict.swing; // Change to dsai if needed

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGrid extends JFrame {
    private JTextField display; // Display field

    public NumberGrid() {
        // Set up frame layout
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Create display field
        display = new JTextField();
        display.setEditable(false);
        cp.add(display, BorderLayout.NORTH);

        // Create button panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 3)); // 4 rows, 3 columns

        // Add number buttons (0-9)
        for (int i = 1; i <= 9; i++) {
            addButton(buttonPanel, String.valueOf(i));
        }
        addButton(buttonPanel, "0");

        // Add DEL and C buttons
        addButton(buttonPanel, "DEL");
        addButton(buttonPanel, "C");

        cp.add(buttonPanel, BorderLayout.CENTER);

        // Set up frame
        setTitle("Number Grid");
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addButton(JPanel panel, String label) {
        JButton button = new JButton(label);
        panel.add(button);

        // Attach action listener to handle button clicks
        button.addActionListener(new ButtonListener());
    }

    // Listener for button clicks
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cmd = e.getActionCommand();
            if (cmd.equals("DEL")) {
                // Remove the last character from the display
                String currentText = display.getText();
                if (!currentText.isEmpty()) {
                    display.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (cmd.equals("C")) {
                // Clear the display
                display.setText("");
            } else {
                // Append the button's label to the display
                display.setText(display.getText() + cmd);
            }
        }
    }

    public static void main(String[] args) {
        new NumberGrid();
    }
}
