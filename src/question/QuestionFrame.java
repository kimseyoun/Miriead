package question;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Window;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import common.ImagePanel;

/**
 * 책 추천 질문 화면 클래스
 */

public class QuestionFrame extends JFrame {
	JLabel questionLbl = new JLabel();
	JPanel currentPagePanel; // 현재 질문 패널을 저장하는 변수
    JPanel nextPagePanel; // 다음 질문 패널을 저장하는 변수
    ImagePanel questionFrameImg = new ImagePanel(new ImageIcon("./image/질문화면.png").getImage());
	
	public QuestionFrame() {
		setTitle("질문 화면");
		setSize(1015, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        questionFrameImg.setLayout(null);
        
        questionLbl.setText("1. 어떤 장르 좋아해?");
        questionLbl.setFont(new Font("", Font.BOLD, 25));
        questionLbl.setBounds(100, 5, 900, 200);
        questionFrameImg.add(questionLbl);
        
        
        JPanel pagePanel = PagePanel();
        questionFrameImg.add(pagePanel);
        
        currentPagePanel = pagePanel;
        
        add(questionFrameImg);
        pack();

	}
	
	
	// 쪽수 패널
	private JPanel PagePanel() {
		// 그냥 hashmap은 순서가 없기 때문에, 삽입한 순서대로 사용하기 위해 LinkedHashMap을 사용
	    Map<String, String> pageMap = new LinkedHashMap<>();
	    pageMap.put("200쪽 미만", "_page < 200");
	    pageMap.put("200~500쪽", "_page BETWEEN 200 AND 500");
	    pageMap.put("500쪽 초과", "_page > 500");

	    JPanel pagePanel = new JPanel();
	    pagePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 10));

	    for (String page : pageMap.keySet()) {
	        JButton button = new JButton(page);

	        button.setFont(new Font("", Font.PLAIN, 18));
	        button.setPreferredSize(new Dimension(160, 60));

	        button.addActionListener(e -> {
	            String selectedValue = pageMap.get(page);
	            System.out.println("쪽수 선택: " + selectedValue);

	            updateQuestionText("3. 학교 도서관에 있는 책이면 좋겠어?");
	            showNextQuestionPanel(schoolPanel());
	        });
	        
	        pagePanel.add(button);
	    }

	    pagePanel.setBounds(100, 200, 800, 100);

	    return pagePanel;
	}

	
	// 학교보유여부 패널
	private JPanel schoolPanel() {
	    Map<String, String> schoolMap = new LinkedHashMap<>();
	    schoolMap.put("응! 학교 도서관에 있으면 좋겠어", "_school = 1");
	    schoolMap.put("아니 상관없어", "_school = 0");

	    JPanel schoolPanel = new JPanel();
	    schoolPanel.setLayout(new FlowLayout());

	    for(String school : schoolMap.keySet()) {
	        JButton button = new JButton(school);
	        // schoolBtns.add(button);

	        button.setFont(new Font("", Font.PLAIN, 18));
	        button.setPreferredSize(new Dimension(300, 40));
	        
	        button.addActionListener(e -> {
	            String selectedValue = schoolMap.get(school);
	            System.out.println("학교 보유 여부 선택: " + selectedValue);
	            showNextQuestionPanel(null);
	        });

	        schoolPanel.add(button);
	    }

	    schoolPanel.setBounds(100, 200, 800, 100);
	    schoolPanel.setBackground(Color.white);
	    questionFrameImg.add(schoolPanel);

	    return schoolPanel;
	}
	
	
	// 다음 질문 패널을 가져오는 메서드
	private void showNextQuestionPanel(JPanel nextPanel) {
        // 현재 패널 숨기기
        currentPagePanel.setVisible(false);

        if (nextPanel != null) {
            // 다음 질문 패널 보이기
            nextPanel.setVisible(true);
            // 현재 질문 패널 업데이트
            currentPagePanel = nextPanel;
        } else {
            // 모든 질문이 끝났을 때 필요한 로직 추가
            System.out.println("모든 질문이 완료되었습니다.");
        }
    }
	
	
	// 질문 텍스트를 업데이트하는 메서드
	private void updateQuestionText(String newText) {
	    questionLbl.setText(newText);
	}
	
}