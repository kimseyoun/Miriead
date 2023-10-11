package join;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import common.ImagePanel;
import main.MainFrame;

public class JoinFrame extends JFrame {

    public JoinFrame() {
        JFrame frame = new JFrame();
        frame.setSize(1000, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel JoinImg = new ImagePanel(new ImageIcon("image/가입화면.png").getImage());
        frame.setContentPane(JoinImg);

        JTextField idTextBox = new JTextField();
        idTextBox.setBounds(300, 240, 420, 75);
        idTextBox.setOpaque(false);
        idTextBox.setBorder(null);

        JTextField passwordTextBox = new JTextField();
        passwordTextBox.setBounds(300, 440, 410, 75);
        passwordTextBox.setOpaque(false);
        passwordTextBox.setBorder(null);

        JButton joinButton = new JButton();
        joinButton.setBounds(400, 570, 205, 80);
        joinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("가입이 완료되었습니다");
                
                frame.dispose();
            }
        });
        joinButton.setOpaque(false);
        joinButton.setContentAreaFilled(false);
        joinButton.setBorderPainted(false);

        frame.add(joinButton);
        frame.add(idTextBox);
        frame.add(passwordTextBox);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new JoinFrame();
    }
}