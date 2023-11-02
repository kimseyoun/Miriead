package join;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import common.ImagePanel;
import main.MainFrame;
import common.CommonFrame;

public class JoinFrame extends JFrame {

    public JoinFrame() {
        JFrame frame = new JFrame();
        frame.setSize(1000, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel JoinImg = new ImagePanel(new ImageIcon("image/가입화면.png").getImage());
        frame.setContentPane(JoinImg);

        JTextField idTextBox = new JTextField();
        idTextBox.setBounds(300, 230, 420, 75);
        idTextBox.setFont(new Font("SansSerif", Font.PLAIN, 18));
        idTextBox.setOpaque(false);
        idTextBox.setBorder(null);

		JTextField pwTextBox = new JTextField();
        pwTextBox.setBounds(300, 440, 410, 75);
        pwTextBox.setFont(new Font("SansSerif", Font.PLAIN, 18));
        pwTextBox.setOpaque(false);
        pwTextBox.setBorder(null);

        JButton joinButton = new JButton();
        joinButton.setBounds(400, 570, 205, 80);
        joinButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String enteredID = idTextBox.getText();
                String enteredPW = pwTextBox.getText();

                // 데이터베이스에 새 사용자 정보 추가
                boolean registrationSuccessful = registerNewUser(enteredID, enteredPW);

                if (registrationSuccessful) {
                    System.out.println("가입이 완료되었습니다");
                    frame.dispose();
                } else {
                    System.out.println("가입 실패: 이미 존재하는 ID 또는 오류 발생");
                }
                
                frame.dispose();
            }
        });
        joinButton.setOpaque(false);
        joinButton.setContentAreaFilled(false);
        joinButton.setBorderPainted(false);

        frame.add(joinButton);
        frame.add(idTextBox);
        frame.add(pwTextBox);

        frame.setVisible(true);
    }
    
    
    private boolean registerNewUser(String id, String password) {
        // 데이터베이스에 이미 있는 ID 확인
        String checkQuery = "SELECT user_identi FROM user WHERE user_identi = ?";
        ResultSet resultSet = CommonFrame.getResult(checkQuery, id);
        
        try {
            if (resultSet.next()) {
                // 이미 해당 ID가 데이터베이스에 존재함
                System.out.println("가입 실패: 이미 존재하는 ID");
                return false;
            } else {
                // 해당 ID가 데이터베이스에 존재하지 않음
                // 새로운 사용자를 데이터베이스에 등록
                String insertQuery = "INSERT INTO user (user_identi, user_pw) VALUES (?, ?)";
                CommonFrame.updateSQL(insertQuery, id, password);
                System.out.println("가입이 완료되었습니다");
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("가입 실패: 오류 발생");
            return false;
        }
    }

    
}