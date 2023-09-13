package common;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * 컴포넌트에 이미지를 올리는 클래스
 */

class ImagePanel extends JPanel { // 이미지 클래스 (ImagePanel이 JPanel을 상속받음)
	private Image img;

	public ImagePanel(Image img) {
		this.img = img; // 생성자와 매개변수의 이름이 같기 때문에, this를 사용하여 this의 img는 멤버변수임을 의미
		setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
		setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null))); // 디멘션 객체를 인자로 받아 컴포넌트의 크기 지정
		setLayout(null);
	}

	public void paintComponent(Graphics g) { // 컴포넌트 그리기에 필요한 도구 제공
		g.drawImage(img, 0, 0, null);
	}
	
	public static void main(String[] args) {
		ImagePanel img = new ImagePanel(null);
	}
}
