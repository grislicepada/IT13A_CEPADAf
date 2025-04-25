package guicode;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class GUIcode {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Login Form");
        frame.setSize(300, 180);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel userLabel = new JLabel("Username:");
        userLabel.setBounds(20, 20, 80, 25);
        frame.add(userLabel);

        JTextField userText = new JTextField();
        userText.setBounds(100, 20, 160, 25);
        frame.add(userText);

        JLabel passLabel = new JLabel("Password:");
        passLabel.setBounds(20, 60, 80, 25);
        frame.add(passLabel);

        JPasswordField passText = new JPasswordField();
        passText.setBounds(100, 60, 160, 25);
        frame.add(passText);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 100, 80, 25);
        frame.add(loginButton);

        frame.setVisible(true);

       
        int key = 3;

        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String usernameInput = userText.getText().trim();
                String passwordInput = new String(passText.getPassword()).trim();
                boolean found = false;

                try {
                    File file = new File("C:\\Users\\Ryan\\OneDrive\\Documents\\users.txt");

                    if (!file.exists()) {
                        JOptionPane.showMessageDialog(frame, "Credentials file not found.");
                        return;
                    }

                    BufferedReader reader = new BufferedReader(new FileReader(file));
                    String line;

                    while ((line = reader.readLine()) != null) {
                        if (line.trim().isEmpty()) continue;

                        String[] parts = line.split(",");
                        if (parts.length == 2) {
                            String fileUser = parts[0].trim();
                            String encryptedPass = parts[1].trim();
                            String decryptedPass = decryptMessage(encryptedPass, key); // 🔓 decrypt password

                            if (usernameInput.equals(fileUser) && passwordInput.equals(decryptedPass)) {
                                found = true;
                                break;
                            }
                        }
                    }
                    reader.close();

                    if (found) {
                        JOptionPane.showMessageDialog(frame, "Login successful!");
                    } else {
                        JOptionPane.showMessageDialog(frame, "Invalid username or password.");
                    }

                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Error reading credentials file.");
                    ex.printStackTrace();
                }
            }
        });
    }

    //  Decrypt method kay dika ka log in if wala
    public static String decryptMessage(String message, int key) {
        char[] chars = message.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] -= key;
        }
        return new String(chars);
    }
}
