package result;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import common.CommonFrame;
import common.ImagePanel;

/**
 * 책 추천 결과 화면 클래스
 */

public class ResultFrame extends JFrame {
	List<Integer> results = new ArrayList<>();

	public ResultFrame(String selectedGenre, String selectedSubGenre, String selectedPage, int selectedSchool) {
		setTitle("결과 화면");
		setSize(1000, 720);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		System.out.println("장르: " + selectedGenre);
		System.out.println("서브장르: " + selectedSubGenre);
		System.out.println("쪽수: " + selectedPage);
		System.out.println("학교보유여부: " + selectedSchool);

		ImagePanel resultFrameImg = new ImagePanel(new ImageIcon("./image/결과화면.png").getImage());
		resultFrameImg.setLayout(null);

		results = resultBook(selectedGenre, selectedSubGenre, selectedPage, selectedSchool);

		displayResults();

		add(resultFrameImg);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private List<Integer> resultBook(String selectedGenre, String selectedSubGenre, String selectedPage,
			int selectedSchool) {
		List<Integer> resultList = new ArrayList<>();

		String checkQuery = "SELECT * FROM " + selectedGenre + " WHERE " + selectedGenre
				+ "_type = ? AND " + selectedGenre + "_page " + selectedPage + " AND " + selectedGenre + "_school = ?";

		ResultSet resultSet = CommonFrame.getResult(checkQuery, selectedSubGenre, selectedSchool);

		// System.out.println("실행 쿼리문: " + checkQuery);
		// System.out.println("결과 집합: " + resultSet);

		try {
			while (resultSet.next()) {
				// 결과에서 각 컬럼에 대한 데이터를 가져와 출력하거나 다른 작업을 수행할 수 있습니다.
				 String title = resultSet.getString(selectedGenre + "_title");
				 String author = resultSet.getString(selectedGenre + "_author");
				 int page = resultSet.getInt(selectedGenre + "_page");
				 int school = resultSet.getInt(selectedGenre + "_school");
				// 여기에 다른 컬럼들에 대한 데이터를 가져와서 출력하거나 원하는 작업을 수행할 수 있습니다.

				// String result = "책 제목: " + title + ", 작가: " + author + ", 쪽수: " + page + ",
				// 학교보유여부: " + school;

				int result = resultSet.getInt(selectedGenre + "_id");
				System.out.println("결과: " + result);
				resultList.add(result);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close(); // ResultSet 닫기
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println("Result List Size: " + resultList.size()); // 디버깅 메시지

		return resultList;
	}

	private void displayResults() {
		if (results.isEmpty()) {
			System.out.println("검색 결과가 없습니다.");
		} else {
			System.out.println("검색 결과:");
			for (int result : results) {
				System.out.println(result);
			}
		}
	}
}
