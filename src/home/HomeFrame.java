package home;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import common.ImagePanel;
import question.QuestionFrame;
import recommand.RecommandFrame;
import user.User;

/**
 * 홈 화면 클래스
 */

public class HomeFrame extends JFrame {
	private User currentUser;
	
	public HomeFrame(User user) {
		this.currentUser = user;
		
		setTitle("홈 화면");
		setSize(1000, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImagePanel homeFrameImg = new ImagePanel(new ImageIcon("./image/메인화면.png").getImage());
        homeFrameImg.setLayout(null);
        
        JButton recommandedBookBtn = new JButton(); // 책 추천받기 버튼
        recommandedBookBtn.setBounds(120, 244, 270, 100);
        recommandedBookBtn.setOpaque(false); // 버튼의 배경을 투명하게 설정
        recommandedBookBtn.setContentAreaFilled(false); // 내용 영역 채우기 안함
        recommandedBookBtn.setBorderPainted(false); // 테두리 없음
        homeFrameImg.add(recommandedBookBtn);
        
        JButton recommandBookBtn = new JButton(); // 책 추천하기 버튼
        recommandBookBtn.setBounds(120, 376, 270, 100);
        recommandBookBtn.setOpaque(false);
        recommandBookBtn.setContentAreaFilled(false);
        recommandBookBtn.setBorderPainted(false);
        homeFrameImg.add(recommandBookBtn);
        
        recommandedBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new QuestionFrame().setVisible(true);
                setVisible(false);
            }
        });
        
        recommandBookBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new RecommandFrame().setVisible(true);
                //setVisible(false);
            }
        });
        
        JLabel nameLbl = new JLabel(currentUser.getId() + " 님");
        nameLbl.setFont(new Font("", Font.BOLD, 25));
        nameLbl.setBounds(705, 190, 100, 100);
        homeFrameImg.add(nameLbl);
        
        setLocationRelativeTo(null);
        add(homeFrameImg);
        
	}
	
}