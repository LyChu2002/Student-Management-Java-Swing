package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TrangChuGiangVienController;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.Action;
import javax.swing.JButton;
import java.awt.Color;

public class TrangChuGiangVienView extends JFrame {
	Action action = new TrangChuGiangVienController(this);
	private static TrangChuGiangVienView trangChuGiangVienInstance = null;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChuGiangVienView frame = new TrangChuGiangVienView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static TrangChuGiangVienView getInstance() {
		if (trangChuGiangVienInstance == null) {
			trangChuGiangVienInstance = new TrangChuGiangVienView();
		}
		
		return trangChuGiangVienInstance; 
	}
	/**
	 * Create the frame.
	 */
	public TrangChuGiangVienView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 611, 320);
		setTitle("Trang chủ giảng viên");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 231, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ ĐIỂM SINH VIÊN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(162, 20, 305, 49);
		contentPane.add(lblNewLabel);
		
		JButton btnQLKetQuaHT = new JButton("Quản lý kết quả học tập");
		btnQLKetQuaHT.setBackground(Color.LIGHT_GRAY);
		btnQLKetQuaHT.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnQLKetQuaHT.setBounds(201, 102, 208, 36);
		contentPane.add(btnQLKetQuaHT);
		btnQLKetQuaHT.addActionListener(action);
		
		JButton btnQuanLyKQThi = new JButton("Quản lý kết quả thi");
		btnQuanLyKQThi.setBackground(Color.LIGHT_GRAY);
		btnQuanLyKQThi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnQuanLyKQThi.setBounds(201, 154, 208, 36);
		contentPane.add(btnQuanLyKQThi);
		btnQuanLyKQThi.addActionListener(action);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBackground(new Color(215, 81, 62));
		btnDangXuat.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDangXuat.setBounds(455, 244, 112, 29);
		contentPane.add(btnDangXuat);
		btnDangXuat.addActionListener(action);
	}

}
