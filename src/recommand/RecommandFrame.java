package recommand;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import common.CommonFrame;
import common.ImagePanel;

public class RecommandFrame extends JFrame {
	String selectedValue; // 선택한 장르값 변수
	
	public RecommandFrame() {
		setTitle("책 추천하기");
		setSize(1000, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImagePanel recommandFrameImg = new ImagePanel(new ImageIcon("./image/책추천화면.png").getImage());
		recommandFrameImg.setLayout(null);
		
		Map<String, String> genreMap = new LinkedHashMap<String, String>();
		genreMap.put("소설", "novel");
		genreMap.put("전공", "major");
		genreMap.put("자기계발", "improve");
		genreMap.put("에세이", "essay");
		
		JComboBox<String> genreBox = new JComboBox<String>(genreMap.keySet().toArray(new String[0]));
		genreBox.setBounds(100, 170, 200, 50);
		genreBox.setBackground(Color.yellow);
		genreBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedKey = (String) genreBox.getSelectedItem();
                selectedValue = genreMap.get(selectedKey);
                System.out.println(selectedKey);
                System.out.println(selectedValue);
            }
        });
		
		
		JTextField titleTextBox = new JTextField();
		titleTextBox.setBounds(160, 290, 680, 65);
		titleTextBox.setFont(new Font("SansSerif", Font.PLAIN, 18));
		titleTextBox.setOpaque(false);
		titleTextBox.setBorder(null);
		
		JTextField authorTextBox = new JTextField();
		authorTextBox.setBounds(160, 445, 680, 65);
		authorTextBox.setFont(new Font("SansSerif", Font.PLAIN, 18));
		authorTextBox.setOpaque(false);
		authorTextBox.setBorder(null);
		
		JButton recommandBtn = new JButton();
		recommandBtn.setBounds(400, 570, 205, 80);
		recommandBtn.setOpaque(false);
		recommandBtn.setBorder(BorderFactory.createEmptyBorder());
		recommandBtn.setBackground(new Color(30, 144, 255));
		
		recommandBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String enteredTitle = titleTextBox.getText();
				String enteredAuthor = authorTextBox.getText();
				
				boolean recommandSuccessful = recommandNewBook(selectedValue, enteredTitle, enteredAuthor);
				
				if(recommandSuccessful) {
					JOptionPane.showMessageDialog(null, "도서 추천 등록이 완료되었습니다");
				} else {
					JOptionPane.showMessageDialog(null, "이미 등록된 도서입니다");
				}
				
				dispose();
			}
		});
		
		add(genreBox);
		add(titleTextBox);
		add(authorTextBox);
		add(recommandBtn);
		
		setLocationRelativeTo(null);
		add(recommandFrameImg);
		
	}
	
	private boolean recommandNewBook(String genre, String title, String author) {
		String checkQuery = "SELECT * FROM " + genre + " WHERE " + genre + "_title = ? AND " + genre + "_author = ?";
		ResultSet resultSet = CommonFrame.getResult(checkQuery, title, author);
		
		try {
			if(resultSet.next()) {
				return false;
			} else {
				String insertQuery = "INSERT INTO recommand (recommand_title, recommand_author, recommand_genre) VALUES (?, ?, ?)";
				CommonFrame.updateSQL(insertQuery, title, author, genre);
				return true;
			}
		} catch(SQLException e) {
			e.printStackTrace();
            System.out.println("등록 실패: 오류 발생");
            return false;		
		}
	}
}
