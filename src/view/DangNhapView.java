package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.DangNhapController;
import dao.TaiKhoanDAO;
import model.TaiKhoan;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.Action;
import javax.swing.JButton;
import java.awt.Color;

public class DangNhapView extends JFrame {
	Action action = new DangNhapController(this);
	private JPanel contentPane;
	private JTextField textField_TenTK;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DangNhapView frame = new DangNhapView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DangNhapView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 762, 350);
		setTitle("Đăng nhập");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 231, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ SINH VIÊN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(256, 24, 243, 26);
		contentPane.add(lblNewLabel);
		
		JLabel labelTenTK = new JLabel("Tên tài khoản");
		labelTenTK.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelTenTK.setBounds(185, 96, 121, 21);
		contentPane.add(labelTenTK);
		
		textField_TenTK = new JTextField();
		textField_TenTK.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TenTK.setBounds(332, 94, 167, 26);
		contentPane.add(textField_TenTK);
		textField_TenTK.setColumns(10);
		
		JLabel labelMatKhau = new JLabel("Mật khẩu");
		labelMatKhau.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		labelMatKhau.setBounds(185, 148, 85, 26);
		contentPane.add(labelMatKhau);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		passwordField.setBounds(332, 149, 167, 26);
		contentPane.add(passwordField);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setBackground(Color.LIGHT_GRAY);
		btnDangNhap.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnDangNhap.setBounds(304, 236, 121, 26);
		contentPane.add(btnDangNhap);
		btnDangNhap.addActionListener(action);
	}

	public void dangNhap() {
		// TODO Auto-generated method stub
		if (textField_TenTK.getText().isEmpty() || passwordField.getText().isEmpty()) {
			JOptionPane.showMessageDialog(rootPane, "Bạn không được để trống tài khoản mật khẩu", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (textField_TenTK.getText().compareTo("admin") == 0 && passwordField.getText().compareTo("123456") == 0) {
			JOptionPane.showMessageDialog(rootPane, "Bạn đã đăng nhập thành công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			JFrame frame = TrangChuAdminView.getInstance();
			frame.setVisible(true);
			frame.setLocationRelativeTo(null);
			this.dispose();
		} else {
			ArrayList<TaiKhoan> dstk = TaiKhoanDAO.getInstance().selectAll();
			boolean check = false;
			for (TaiKhoan tk : dstk) {
				if (textField_TenTK.getText().compareTo(tk.getTenTK()) == 0 && passwordField.getText().compareTo(tk.getMatKhau()) == 0) {
					check = true;
					break;
				}
			}
			if (check == true) {
				JOptionPane.showMessageDialog(rootPane, "Bạn đã đăng nhập thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
				JFrame frame = TrangChuGiangVienView.getInstance();
				frame.setVisible(true);
				frame.setLocationRelativeTo(null);
				this.dispose();
			} else {
				JOptionPane.showMessageDialog(rootPane, "Tài khoản và mật khẩu không đúng", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}
}
