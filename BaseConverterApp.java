import javax.swing.*;
import java.awt.*;
// My first project
    public class BaseConverterApp extends JFrame {
        private JTextField inputField;
        private JComboBox<String> fromBaseCombo;
        private JComboBox<String> toBaseCombo;
        private JLabel resultLabel;

        public BaseConverterApp() { // My first program
            setTitle("Base Converter");
            setSize(400, 250);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            setLocationRelativeTo(null);
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(10, 10, 10, 10);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            // Input Number
            gbc.gridx = 0;
            gbc.gridy = 0;
            add(new JLabel("Input Number:"), gbc);

            inputField = new JTextField(20);
            gbc.gridx = 1;
            add(inputField, gbc);

            // From Base
            gbc.gridx = 0;
            gbc.gridy = 1;
            add(new JLabel("From Base (2-36):"), gbc);

            fromBaseCombo = new JComboBox<>();
            for (int i = 2; i <= 36; i++) {
                fromBaseCombo.addItem(String.valueOf(i));
            }
            fromBaseCombo.setSelectedItem("10");
            gbc.gridx = 1;
            add(fromBaseCombo, gbc);

            // To Base
            gbc.gridx = 0;
            gbc.gridy = 2;
            add(new JLabel("To Base (2-36):"), gbc);

            toBaseCombo = new JComboBox<>();
            for (int i = 2; i <= 36; i++) {
                toBaseCombo.addItem(String.valueOf(i));
            }
            toBaseCombo.setSelectedItem("10");
            gbc.gridx = 1;
            add(toBaseCombo, gbc);

            // Convert Button
            JButton convertButton = new JButton("Convert");
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 2;
            add(convertButton, gbc);

            // Result Label
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            add(new JLabel("Result:"), gbc);

            resultLabel = new JLabel("");
            resultLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
            gbc.gridx = 1;
            add(resultLabel, gbc);

            // Action Listener
            convertButton.addActionListener(e -> convert());
        }

        private void convert() {
            String input = inputField.getText().trim();
            int fromBase = Integer.parseInt((String) fromBaseCombo.getSelectedItem());
            int toBase = Integer.parseInt((String) toBaseCombo.getSelectedItem());

            if (input.isEmpty()) {
                showError("Please enter a number to convert.");
                return;
            }

            try {
                int decimalValue = Integer.parseInt(input, fromBase);
                String converted = Integer.toString(decimalValue, toBase).toUpperCase();
                resultLabel.setText(converted);
            } catch (NumberFormatException ex) {
                showError("'" + input + "' is not valid in base " + fromBase + ".");
            }
        }

        private void showError(String message) {
            JOptionPane.showMessageDialog(this, message, "Input Error", JOptionPane.ERROR_MESSAGE);
        }

        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                new BaseConverterApp().setVisible(true);
            });
        }
    }


