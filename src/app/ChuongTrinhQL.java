package app;

import javax.swing.JFrame;

import view.DangNhapView;

public class ChuongTrinhQL {
	private static JFrame dangNhapView;

	public static void main(String[] args) {
		dangNhapView = new DangNhapView();
		dangNhapView.setVisible(true);
	}
}
