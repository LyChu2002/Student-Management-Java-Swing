package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyLopHocPhanController;
import dao.LopHocPhanDAO;
import dao.MonHocDAO;
import model.LopHocPhan;
import model.MonHoc;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;

public class QuanLyLopHocPhanView extends JFrame {
	ArrayList<LopHocPhan> dslhp;
	ArrayList<MonHoc> dsmh;
	String[][] data;
	Action action = new QuanLyLopHocPhanController(this);
	private static QuanLyLopHocPhanView quanLyLHPViewInstance = null;
	private JPanel contentPane;
	private JTextField textField_MaLopHP;
	private JTextField textField_TenLopHP;
	private JTextField textField_MaMH;
	private JTextField textField_TenGV;
	private JTextField textField_NgayBD;
	private JTextField textField_NgayKT;
	private JTextField textField_SoTiet;
	private JScrollPane scrollPane;
	private JTable table;
	DefaultTableModel defaultTableModel;

	String[] collumName = { "Mã lớp học phần", "Tên lớp học phần", "Mã môn học", "Tên môn học", "Tên giảng viên", "Ngày bắt đầu", "Ngày kết thúc", "Số tiết" };
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyLopHocPhanView frame = new QuanLyLopHocPhanView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static QuanLyLopHocPhanView getInstance() {
		if (quanLyLHPViewInstance == null) {
			quanLyLHPViewInstance = new QuanLyLopHocPhanView();
		}
		
		return quanLyLHPViewInstance; 
	}
	/**
	 * Create the frame.
	 */
	public QuanLyLopHocPhanView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1339, 514);
		setTitle("Quản lý lớp học phần");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 231, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ LỚP HỌC PHẦN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(446, 10, 247, 30);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin lớp học phần");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(82, 59, 203, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Danh sách lớp học phần");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(769, 59, 203, 21);
		contentPane.add(lblNewLabel_1_1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(44, 93, 327, 271);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelMaLopHP = new JLabel("Mã lớp học phần");
		labelMaLopHP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		labelMaLopHP.setBounds(10, 15, 127, 20);
		panel.add(labelMaLopHP);
		
		textField_MaLopHP = new JTextField();
		textField_MaLopHP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_MaLopHP.setBounds(134, 12, 171, 26);
		panel.add(textField_MaLopHP);
		textField_MaLopHP.setColumns(10);
		
		JLabel label_TenLopHP = new JLabel("Tên lớp học phần");
		label_TenLopHP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_TenLopHP.setBounds(10, 51, 127, 20);
		panel.add(label_TenLopHP);
		
		textField_TenLopHP = new JTextField();
		textField_TenLopHP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TenLopHP.setColumns(10);
		textField_TenLopHP.setBounds(134, 48, 171, 26);
		panel.add(textField_TenLopHP);
		
		JLabel label_MaMH = new JLabel("Mã môn học");
		label_MaMH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_MaMH.setBounds(10, 87, 127, 20);
		panel.add(label_MaMH);
		
		textField_MaMH = new JTextField();
		textField_MaMH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_MaMH.setColumns(10);
		textField_MaMH.setBounds(134, 84, 171, 26);
		panel.add(textField_MaMH);
		
		JLabel label_TenGV = new JLabel("Tên giảng viên");
		label_TenGV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_TenGV.setBounds(10, 122, 127, 23);
		panel.add(label_TenGV);
		
		textField_TenGV = new JTextField();
		textField_TenGV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TenGV.setColumns(10);
		textField_TenGV.setBounds(134, 120, 171, 26);
		panel.add(textField_TenGV);
		
		JLabel label_NgayBD = new JLabel("Ngày bắt đầu");
		label_NgayBD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_NgayBD.setBounds(10, 162, 127, 20);
		panel.add(label_NgayBD);
		
		textField_NgayBD = new JTextField();
		textField_NgayBD.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_NgayBD.setColumns(10);
		textField_NgayBD.setBounds(134, 155, 171, 26);
		panel.add(textField_NgayBD);
		
		JLabel label_NgayKT = new JLabel("Ngày kết thúc");
		label_NgayKT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_NgayKT.setBounds(10, 198, 127, 20);
		panel.add(label_NgayKT);
		
		textField_NgayKT = new JTextField();
		textField_NgayKT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_NgayKT.setColumns(10);
		textField_NgayKT.setBounds(134, 192, 171, 26);
		panel.add(textField_NgayKT);
		
		JLabel label_SoTiet = new JLabel("Số tiết");
		label_SoTiet.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_SoTiet.setBounds(10, 231, 127, 20);
		panel.add(label_SoTiet);
		
		textField_SoTiet = new JTextField();
		textField_SoTiet.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_SoTiet.setColumns(10);
		textField_SoTiet.setBounds(134, 228, 171, 26);
		panel.add(textField_SoTiet);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(402, 93, 913, 271);
		contentPane.add(panel_1);
		table = new JTable();
		table.setBounds(1, 1, 450, 0);
		panel_1.add(table);
		defaultTableModel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(defaultTableModel);
		MouseListener mouseListener = new QuanLyLopHocPhanController(this);
		table.addMouseListener(mouseListener);
		panel_1.setLayout(null);

		table.setRowHeight(25);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 913, 271);
		scrollPane.getViewport().setBackground(Color.WHITE);
		hienThiData();
		panel_1.add(scrollPane);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(Color.LIGHT_GRAY);
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnThem.setBounds(199, 396, 90, 30);
		contentPane.add(btnThem);
		btnThem.addActionListener(action);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(Color.LIGHT_GRAY);
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSua.setBounds(383, 396, 90, 30);
		contentPane.add(btnSua);
		btnSua.addActionListener(action);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.LIGHT_GRAY);
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnXoa.setBounds(568, 396, 90, 30);
		contentPane.add(btnXoa);
		btnXoa.addActionListener(action);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.LIGHT_GRAY);
		btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnTimKiem.setBounds(780, 396, 105, 30);
		contentPane.add(btnTimKiem);
		btnTimKiem.addActionListener(action);
		
		JButton btnHienThi = new JButton("Hiển thị");
		btnHienThi.setBackground(Color.LIGHT_GRAY);
		btnHienThi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnHienThi.setBounds(1001, 396, 90, 30);
		contentPane.add(btnHienThi);
		btnHienThi.addActionListener(action);
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBackground(new Color(215, 81, 62));
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnQuayLai.setBounds(1216, 437, 99, 30);
		contentPane.add(btnQuayLai);
		btnQuayLai.addActionListener(action);
	}
	
	private String getDateFormatted(String str) {
		String[] tempNgay = str.split("-");
		String ngayThangNam = tempNgay[2] + "/" + tempNgay[1] + "/" + tempNgay[0];
		return ngayThangNam;
	}

	public String getReverseDate(String date) {
		String[] temp = date.split("/");
		return temp[2] + "-" + temp[1] + "-" + temp[0];
	}
	
	public void hienThiData() {
		// TODO Auto-generated method stub
		dslhp = LopHocPhanDAO.getInstance().selectAll();
		int n = dslhp.size();
		data = new String[n][8];
		int index = 0;
		MonHoc mh;
		for (LopHocPhan x : dslhp) {
			data[index][0] = x.getMaLopHP();
			data[index][1] = x.getTenLopHP();
			data[index][2] = x.getMaMH();
			mh = MonHocDAO.getInstance().selectById(x.getMaMH());
			data[index][3] = mh.getTenMH();
			data[index][4] = x.getTenGV();
			data[index][5] = getDateFormatted(x.getNgayBatDau());
			data[index][6] = getDateFormatted(x.getNgayKetThuc());
			data[index][7] = x.getSoTiet() + " ";
			index++;
		}
		defaultTableModel.setDataVector(data, collumName);
		table.setModel(defaultTableModel);
	}
	
	public boolean checkNull() {
		if (textField_MaLopHP.getText().trim().isEmpty() || textField_TenLopHP.getText().trim().isEmpty()
				|| textField_MaMH.getText().trim().isEmpty()|| textField_TenGV.getText().trim().isEmpty() || textField_NgayBD.getText().trim().isEmpty()
				|| textField_NgayKT.getText().isEmpty() || textField_SoTiet.getText().trim().isEmpty())
			return true;
		else
			return false;
	}

	public boolean checkMaLopHP() {
		String txt_maLopHP = textField_MaLopHP.getText();
		for (LopHocPhan x : dslhp)
			if (x.getMaLopHP().equals(txt_maLopHP))
				return true;
		return false;
	}
	
	public boolean checkMaMonHoc() {
		String txt_maMonHoc = textField_MaMH.getText();
		dsmh = MonHocDAO.getInstance().selectAll();
		for (MonHoc x : dsmh)
			if (x.getMaMH().equals(txt_maMonHoc))
				return true;
		return false;
	}
	
	public void themLopHP() {
		if (checkNull()) {
			JOptionPane.showMessageDialog(rootPane, "Bạn không được để trống các trường");
			return;
		}
		if (checkMaLopHP()) {
			JOptionPane.showMessageDialog(rootPane, "Mã lớp học phần đã tồn tại");
			return;
		}
		if(checkMaMonHoc() == false) {
			JOptionPane.showMessageDialog(rootPane, "Mã môn học không tồn tại");
			return;
		}

		LopHocPhan lhp = new LopHocPhan(textField_MaLopHP.getText().trim(), textField_TenLopHP.getText().trim(), textField_MaMH.getText().trim(),
				textField_TenGV.getText().trim(), getReverseDate(textField_NgayBD.getText().trim()), getReverseDate(textField_NgayKT.getText().trim()), Integer.parseInt(textField_SoTiet.getText().trim()));
		if (LopHocPhanDAO.getInstance().insert(lhp) != 0) {
			JOptionPane.showMessageDialog(rootPane, "Thêm lớp học phần thành công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(rootPane, "Thêm lớp học phần không thành công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);

		}
		hienThiData();
	}

	public void suaLopHP() {
		// TODO Auto-generated method stub
		if (checkNull()) {
			JOptionPane.showMessageDialog(rootPane, "Bạn không được để trống các trường");
			return;
		}
		if (checkMaLopHP() == false) {
			JOptionPane.showMessageDialog(rootPane, "Mã lớp học phần không tồn tại", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		
		if(checkMaMonHoc() == false) {
			JOptionPane.showMessageDialog(rootPane, "Mã môn học không tồn tại");
			return;
		}

		LopHocPhan lhp = new LopHocPhan(textField_MaLopHP.getText().trim(), textField_TenLopHP.getText().trim(), 
				textField_MaMH.getText().trim(), textField_TenGV.getText().trim(), getReverseDate(textField_NgayBD.getText().trim()),
				getReverseDate(textField_NgayKT.getText().trim()), Integer.parseInt(textField_SoTiet.getText().trim()));
		

		if (lhp != null) {
			int result = JOptionPane.showConfirmDialog(rootPane,
					"Bạn có chắc muốn sửa lớp học phần có mã " + lhp.getMaLopHP() + " không?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				LopHocPhanDAO.getInstance().update(lhp);
				JOptionPane.showMessageDialog(rootPane, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				hienThiData();
			}
		} else {
			JOptionPane.showMessageDialog(rootPane, "Sửa không thành công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void xoaLopHP() {
		// TODO Auto-generated method stub
		if (textField_MaLopHP.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn 1 lớp học phần", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (checkMaLopHP() == false) {
			JOptionPane.showMessageDialog(rootPane, "Mã lớp học phần không tồn tại", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		LopHocPhan lhp = LopHocPhanDAO.getInstance().selectById(textField_MaLopHP.getText().trim());

		if (lhp != null) {
			int result = JOptionPane.showConfirmDialog(rootPane,
					"Bạn có chắc muốn xóa lớp học phần có mã " + lhp.getMaLopHP() + " không?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				LopHocPhanDAO.getInstance().delete(lhp);
				JOptionPane.showMessageDialog(rootPane, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				hienThiData();
			}
		} else {
			JOptionPane.showMessageDialog(rootPane, "Xóa không thành công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	//Tìm kiếm lớp học phần theo môn
	public void timKiemLopHP() {
		
	}
	
	public void chonDong() {
		int r = table.getSelectedRow();
		String maLopHP = data[r][0];
		LopHocPhan lhp = LopHocPhanDAO.getInstance().selectById(maLopHP);
		textField_MaLopHP.setText(maLopHP);
		textField_TenLopHP.setText(lhp.getTenLopHP());
		textField_MaMH.setText(lhp.getMaMH());
		textField_TenGV.setText(lhp.getTenGV());
		textField_NgayBD.setText(getDateFormatted(lhp.getNgayBatDau()));
		textField_NgayKT.setText(getDateFormatted(lhp.getNgayKetThuc()));
		textField_SoTiet.setText(lhp.getSoTiet()+ "");
	}
}
