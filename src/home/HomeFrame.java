package home;

import javax.swing.*;

import common.ImagePanel;
import question.QuestionFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 홈 화면 클래스
 */

public class HomeFrame extends JFrame {
	
	public HomeFrame() {
		setTitle("홈 화면");
		setSize(1000, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImagePanel homeFrameImg = new ImagePanel(new ImageIcon("./image/메인화면.png").getImage());
        homeFrameImg.setLayout(null);
        
        JButton recommandBookBtn = new JButton();
        recommandBookBtn.setBounds(120, 292, 270, 100); // 
        recommandBookBtn.setOpaque(false); // 버튼의 배경을 투명하게 설정
        recommandBookBtn.setContentAreaFilled(false); // 내용 영역 채우기 안함
        recommandBookBtn.setBorderPainted(false); // 테두리 없음
        homeFrameImg.add(recommandBookBtn);
        
        recommandBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new QuestionFrame().setVisible(true);
                setVisible(false);
            }
        });
        
        JLabel nameLbl = new JLabel("OOO 님");
        nameLbl.setFont(new Font("", Font.BOLD, 25));
        nameLbl.setBounds(705, 190, 100, 100);
        homeFrameImg.add(nameLbl);
        
        
        add(homeFrameImg);
	}
	
}