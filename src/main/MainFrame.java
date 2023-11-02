package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import common.ImagePanel;
import join.JoinFrame;
import question.QuestionFrame;
import home.HomeFrame;
import common.CommonFrame;

public class MainFrame extends JFrame {
	private List<String> data;
	
	public MainFrame() {
        setTitle("Miriead");
        setSize(1000, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImagePanel mainFrameImg = new ImagePanel(new ImageIcon("./image/시작화면.png").getImage());
        mainFrameImg.setLayout(null);
        
        JTextField idField = new JTextField();
        idField.setBounds(300, 277, 280, 60); // 위치와 크기 설정
        idField.setBorder(BorderFactory.createEmptyBorder()); // 외곽선 없음
        idField.setOpaque(false); // 투명 배경
        idField.setFont(new Font("SansSerif", Font.PLAIN, 18)); // 폰트 설정
        mainFrameImg.add(idField);
        
        JTextField pwField = new JTextField();
        pwField.setBounds(300, 377, 280, 60);
        pwField.setBorder(BorderFactory.createEmptyBorder());
        pwField.setOpaque(false);
        pwField.setFont(new Font("SansSerif", Font.PLAIN, 18));
        mainFrameImg.add(pwField);
        
        JButton loginBtn = new JButton();
        loginBtn.setBounds(618, 270, 172, 170);
        loginBtn.setBorder(BorderFactory.createEmptyBorder()); // 외곽선 없음
        loginBtn.setOpaque(false); // 투명 배경
        loginBtn.setBackground(new Color(30, 144, 255)); // 배경색 설정
        mainFrameImg.add(loginBtn);
        
        // 로그인 버튼이 눌렸을 때
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 입력한 id와 pw값이 db에 존재하는지 확인하는 코드 작성하기
            	
//            	data = CommonFrame.getColumnDataFromTable("novel", "novel_title");
//
//                // 데이터 출력
//                for (String title : data) {
//                    System.out.println(title);
//                }
            	
            	String enteredID = idField.getText();
                String enteredPW = pwField.getText();

                // 데이터베이스에서 사용자 정보 가져오기
                List<String> userData = CommonFrame.getColumnDataFromTable("user", "user_identi", "user_pw");

                // 데이터베이스에서 사용자 정보와 입력한 정보 비교
                boolean loginSuccessful = false;
                for (int i = 0; i < userData.size(); i += 2) {
                    String storedID = userData.get(i);
                    String storedPW = userData.get(i + 1);
                    if (storedID.equals(enteredID) && storedPW.equals(enteredPW)) {
                        loginSuccessful = true;
                        break;
                    }
                }

                if (loginSuccessful) {
                	new HomeFrame(enteredID).setVisible(true);
                    setVisible(false);
                } else {
                    System.out.println("로그인 실패: 올바르지 않은 ID 또는 비밀번호");
                }
                
            }
        });
        
        JButton joinBtn = new JButton();
        joinBtn.setBounds(746, 565, 185, 100);
        joinBtn.setBorder(BorderFactory.createEmptyBorder());
        joinBtn.setOpaque(false); // 투명 배경
        joinBtn.setBackground(new Color(30, 144, 255));
        mainFrameImg.add(joinBtn);
        
        joinBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JoinFrame();
            }
        });
        
        add(mainFrameImg);
    }
	

	public static void main(String[] args) {
		MainFrame frame = new MainFrame();
        frame.setVisible(true);
	}

}
