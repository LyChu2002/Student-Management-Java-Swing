package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyKetQuaHocTapController;
import controller.QuanLyKetQuaThiController;
import dao.DiemDAO;
import dao.LopHocPhanDAO;
import dao.SinhVienDAO;
import model.Diem;
import model.LopHocPhan;
import model.SinhVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;

public class QuanLyKetQuaThiView extends JFrame {
	ArrayList<Diem> dsd;
	String data[][];
	Action action = new QuanLyKetQuaThiController(this);
	private JPanel contentPane;
	private JTextField textField_MaLopHP;
	private JTextField textField_MaSV;
	private JTextField textField_TenSV;
	private JTextField textField_DiemCuoiKy;
	private JScrollPane scrollPane;
	private JTable table;
	DefaultTableModel defaultTableModel;

	String[] collumName = { "Mã sinh viên", "Họ và tên", "Mã lớp", "Điểm TB", "Điểm thi", "Điểm tổng kết", "Điểm chữ"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyKetQuaThiView frame = new QuanLyKetQuaThiView();
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
	public QuanLyKetQuaThiView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1190, 466);
		setTitle("Quản lý kết quả thi");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 231, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ KẾT QUẢ THI");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(392, 24, 321, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nhập điểm thi");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1.setBounds(128, 66, 135, 28);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(36, 107, 355, 190);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelMaLopHP = new JLabel("Nhập mã lớp học phần");
		labelMaLopHP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		labelMaLopHP.setBounds(10, 20, 142, 29);
		panel.add(labelMaLopHP);
		
		textField_MaLopHP = new JTextField();
		textField_MaLopHP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_MaLopHP.setBounds(162, 20, 183, 29);
		panel.add(textField_MaLopHP);
		textField_MaLopHP.setColumns(10);
		
		JLabel label_MaSV = new JLabel("Mã sinh viên");
		label_MaSV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_MaSV.setBounds(10, 59, 142, 29);
		panel.add(label_MaSV);
		
		textField_MaSV = new JTextField();
		textField_MaSV.setEditable(false);
		textField_MaSV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_MaSV.setColumns(10);
		textField_MaSV.setBounds(162, 59, 183, 29);
		panel.add(textField_MaSV);
		
		JLabel label_TenSV = new JLabel("Tên sinh viên");
		label_TenSV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_TenSV.setBounds(10, 98, 142, 29);
		panel.add(label_TenSV);
		
		textField_TenSV = new JTextField();
		textField_TenSV.setEditable(false);
		textField_TenSV.setForeground(new Color(0, 0, 0));
		textField_TenSV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TenSV.setColumns(10);
		textField_TenSV.setBounds(162, 98, 183, 29);
		panel.add(textField_TenSV);
		
		JLabel label_DiemCuoiKy = new JLabel("Điểm cuối kỳ");
		label_DiemCuoiKy.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_DiemCuoiKy.setBounds(10, 137, 142, 29);
		panel.add(label_DiemCuoiKy);
		
		textField_DiemCuoiKy = new JTextField();
		textField_DiemCuoiKy.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_DiemCuoiKy.setColumns(10);
		textField_DiemCuoiKy.setBounds(162, 137, 183, 29);
		panel.add(textField_DiemCuoiKy);
		
		JLabel lblNewLabel_1_1 = new JLabel("Danh sách điểm thi");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(726, 66, 205, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(448, 107, 718, 213);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		table = new JTable();
		table.setBounds(1, 1, 450, 0);
		panel_1.add(table);
		table.setCellSelectionEnabled(true);
		table.setBounds(34, 55, 444, -32);
		table.setBorder(new LineBorder(new Color(208, 208, 208)));
		table.setForeground(new Color(0, 0, 0));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		panel_1.add(table);
		defaultTableModel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setRowHeight(25);
		table.setModel(defaultTableModel);
		MouseListener mouseListener = new QuanLyKetQuaThiController(this);
		table.addMouseListener(mouseListener);
		panel_1.setLayout(null);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 718, 213);
		scrollPane.getViewport().setBackground(Color.WHITE);
		//hienThiData();
		panel_1.add(scrollPane);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(Color.LIGHT_GRAY);
		btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCapNhat.setBounds(64, 335, 104, 28);
		contentPane.add(btnCapNhat);
		btnCapNhat.addActionListener(action);
		
		JButton btnHienThi = new JButton("Hiển thị");
		btnHienThi.setBackground(Color.LIGHT_GRAY);
		btnHienThi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnHienThi.setBounds(256, 335, 104, 28);
		contentPane.add(btnHienThi);
		btnHienThi.addActionListener(action);
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBackground(new Color(215, 81, 62));
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnQuayLai.setBounds(1062, 391, 104, 28);
		contentPane.add(btnQuayLai);
		btnQuayLai.addActionListener(action);
	}

	public void hienThiData() {
		// TODO Auto-generated method stub
		String maLopHP = textField_MaLopHP.getText().trim();
		if(maLopHP.equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Bạn cần điền mã học phần");
			return;
		}
		dsd = DiemDAO.getInstance().selectByPassedCondition(maLopHP);
		int n = dsd.size();
		data = new String[n][7];
		int index = 0;
		SinhVien sv;
		LopHocPhan lhp;
		for (Diem x : dsd) {
			data[index][0] = x.getMaSV();
			sv = SinhVienDAO.getInstance().selectById(x.getMaSV());
			data[index][1] = sv.getHoTen();
			data[index][2] = x.getMaLopHP();
			lhp = LopHocPhanDAO.getInstance().selectById(maLopHP);
			double diemTB = (x.getDiemKTTX1() + x.getDiemKTTX2())/2;
			data[index][3] = diemTB + "";	
			//Diem thi, diem tong ket,diem chu
			data[index][4] = x.getDiemCuoiKy() +"";
			double diemTK = (x.getDiemCuoiKy() * 2 + diemTB)/3;
			data[index][5] = diemTK + "";
			if(diemTK >= 8.5) {
				data[index][6] = "A";
			}else if(diemTK >= 7.8) {
				data[index][6] = "B+";
			}else if(diemTK >= 7.0) {
				data[index][6] = "B";
			}else if(diemTK >= 6.3) {
				data[index][6] = "C+";
			}else if(diemTK >= 5.5) {
				data[index][6] = "C";
			}else if(diemTK >= 4.8) {
				data[index][6] = "D+";
			}else if(diemTK >= 4.0) {
				data[index][6] = "D";
			}else data[index][6] = "F";
			index++;
		}
		defaultTableModel.setDataVector(data, collumName);
		table.setModel(defaultTableModel);
	}

	public void capNhatDiem() {
		// TODO Auto-generated method stub
		Diem diem = new Diem(textField_MaSV.getText().trim(), textField_MaLopHP.getText().trim(), Double.parseDouble(textField_DiemCuoiKy.getText().trim()));
		if (diem != null) {
			int result = JOptionPane.showConfirmDialog(rootPane,
					"Bạn có chắc muốn cập nhật điểm của sinh viên có mã " + diem.getMaSV() + " không?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				DiemDAO.getInstance().updateDiemThi(diem);
				JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				hienThiData();
			}
		} else {
			JOptionPane.showMessageDialog(rootPane, "Cập nhật không thành công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}


	
	public void chonDong() {
		int r = table.getSelectedRow();
		String maLopHP = textField_MaLopHP.getText().trim();
		String maSV = data[r][0];
		Diem diem = DiemDAO.getInstance().selectByStudentAndClassId(maSV, maLopHP);
		textField_MaSV.setText(maSV);
		SinhVien sv = SinhVienDAO.getInstance().selectById(maSV);
		textField_TenSV.setText(sv.getHoTen());
	}
	
}
