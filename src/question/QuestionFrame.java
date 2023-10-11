package question;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import common.ImagePanel;

/**
 * 책 추천 질문 화면 클래스
 */

public class QuestionFrame extends JFrame {
	
	public QuestionFrame() {
		setTitle("질문 화면");
		setSize(1000, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        ImagePanel questionFrameImg = new ImagePanel(new ImageIcon("./image/질문화면.png").getImage());
        questionFrameImg.setLayout(null);
        
        JLabel questionLbl = new JLabel("1. 어떤 장르 좋아해?");
        questionLbl.setFont(new Font("", Font.BOLD, 25));
        questionLbl.setBounds(100, 5, 300, 200);
        questionFrameImg.add(questionLbl);
        
        add(questionFrameImg);
	}
}
