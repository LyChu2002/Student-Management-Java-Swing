package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.TrangChuAdminController;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import java.awt.Color;

public class TrangChuAdminView extends JFrame {
	private static TrangChuAdminView trangChuAdminInstance = null;
	private JPanel contentPane;
	private ActionListener actionListener = new TrangChuAdminController(this);;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrangChuAdminView frame = new TrangChuAdminView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static TrangChuAdminView getInstance() {
		if (trangChuAdminInstance == null) {
			trangChuAdminInstance = new TrangChuAdminView();
		}
		
		return trangChuAdminInstance; 
	}
	
	/**
	 * Create the frame.
	 */
	public TrangChuAdminView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 791, 334);
		setTitle("Trang chủ admin");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 231, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ SINH VIÊN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(293, 27, 209, 24);
		contentPane.add(lblNewLabel);
		
		JButton btnTTSinhVien = new JButton("Thông tin sinh viên");
		btnTTSinhVien.setBackground(Color.LIGHT_GRAY);
		btnTTSinhVien.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnTTSinhVien.setBounds(146, 89, 190, 43);
		contentPane.add(btnTTSinhVien);
		btnTTSinhVien.addActionListener(actionListener);
		
		JButton btnQuanLyMH = new JButton("Quản lý môn học");
		btnQuanLyMH.setBackground(Color.LIGHT_GRAY);
		btnQuanLyMH.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnQuanLyMH.setBounds(435, 89, 190, 43);
		contentPane.add(btnQuanLyMH);
		btnQuanLyMH.addActionListener(actionListener);
		
		JButton btnQuanLyLHP = new JButton("Quản lý lớp học phần");
		btnQuanLyLHP.setBackground(Color.LIGHT_GRAY);
		btnQuanLyLHP.setFont(new Font("Times New Roman", Font.BOLD, 18));
		btnQuanLyLHP.setBounds(279, 184, 234, 43);
		contentPane.add(btnQuanLyLHP);
		btnQuanLyLHP.addActionListener(actionListener);
		
		JButton btnDangXuat = new JButton("Đăng xuất");
		btnDangXuat.setBackground(new Color(215, 81, 62));
		btnDangXuat.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDangXuat.setBounds(644, 247, 110, 29);
		contentPane.add(btnDangXuat);
		btnDangXuat.addActionListener(actionListener);
	}

}
