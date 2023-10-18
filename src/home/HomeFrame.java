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
	
    /* public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 이미지 로드
        ImageIcon imageIcon = new ImageIcon("./image/메인화면.png");
        Image image = imageIcon.getImage();

        // 이미지 크기 조정
        Image newImage = image.getScaledInstance(1000, 720, Image.SCALE_SMOOTH);
        ImageIcon newImageIcon = new ImageIcon(newImage);

        // 레이블에 이미지 추가
        JLabel label = new JLabel(newImageIcon);
        frame.setContentPane(label);

        // 책 추천으로 돌아가기
        JButton button = new JButton();
        button.setBounds(110, 275, 270, 100); // 
        button.setOpaque(false); // 버튼의 배경을 투명하게 설정
        button.setContentAreaFilled(false); // 내용 영역 채우기 안함
        button.setBorderPainted(false); // 테두리 없음
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("버튼이 클릭되었습니다");
            }
        });

        frame.add(button);

        frame.setVisible(true);
    } */
}