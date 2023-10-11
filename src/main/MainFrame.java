package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import common.ImagePanel;
import join.JoinFrame;
import question.QuestionFrame;

public class MainFrame extends JFrame {
	
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
                
                new QuestionFrame().setVisible(true);
                setVisible(false);
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
