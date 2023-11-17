package result;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import common.ImagePanel;
import home.HomeFrame;

/**
 * 책 추천 결과 화면 클래스
 */

public class ResultFrame extends JFrame {
	public ResultFrame() {
		setTitle("결과 화면");
		setSize(1000, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		ImagePanel resultFrameImg = new ImagePanel(new ImageIcon("./image/결과화면.png").getImage());
        resultFrameImg.setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
	}
}

/* public class ResultFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(1000, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel ResultImg = new ImagePanel(new ImageIcon("image/결과화면.png").getImage());
        frame.setContentPane(ResultImg);
        add(ResultImg);

        JTextField titleTextBox = new JTextField();
        titleTextBox.setBounds(140, 60, 800, 50);
        titleTextBox.setFont(new Font("SansSerif", Font.PLAIN, 18));
        titleTextBox.setOpaque(false);
        titleTextBox.setBorder(null);

        JTextField writerTextBox = new JTextField();
        writerTextBox.setBounds(140,120, 800, 50);
        writerTextBox.setFont(new Font("SansSerif", Font.PLAIN, 18));
        writerTextBox.setOpaque(false);
        writerTextBox.setBorder(null);

        JTextField pageTextBox = new JTextField();
        pageTextBox.setBounds(140, 180, 800, 50);
        pageTextBox.setFont(new Font("SansSerif", Font.PLAIN, 18));
        pageTextBox.setOpaque(false);
        pageTextBox.setBorder(null);

        JTextField schoolTextBox = new JTextField();
        schoolTextBox.setBounds(270, 240, 200, 50);
        schoolTextBox.setFont(new Font("SansSerif", Font.PLAIN, 18));
        schoolTextBox.setOpaque(false);
        schoolTextBox.setBorder(null); 
        //줄거리 보기 버튼
        JButton stroyBtn = new JButton();
        stroyBtn.setBounds(640, 410, 280, 100);
        stroyBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String story = "이 책의 줄거리는 어쩌구";  //디비연결할때는 지우고 다르게 해야함
                JOptionPane.showMessageDialog(null,story, "줄거리", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        stroyBtn.setOpaque(false);
        stroyBtn.setContentAreaFilled(false);
        stroyBtn.setBorderPainted(false);

        
        //메인으로 돌아가기 버튼
        JButton homebackBtn = new JButton();
        homebackBtn.setBounds(640, 555, 280, 100);
        homebackBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new HomeFrame().setVisible(true);
            }
        });
        homebackBtn.setOpaque(false);
        homebackBtn.setContentAreaFilled(false);
        homebackBtn.setBorderPainted(false);

        frame.add(homebackBtn);
        frame.add(stroyBtn);
        frame.add(titleTextBox);
        frame.add(writerTextBox);
        frame.add(pageTextBox);
        frame.add(schoolTextBox);

        frame.setVisible(true);
    }

    private static void add(ImagePanel joinImg) {
       
    }
} */
