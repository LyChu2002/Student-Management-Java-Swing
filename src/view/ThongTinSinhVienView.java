package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controller.ThongTinSinhVienController;
import dao.SinhVienDAO;
import model.SinhVien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class ThongTinSinhVienView extends JFrame {
	ArrayList<SinhVien> dssv;
	String[][] data;
	Action action = new ThongTinSinhVienController(this);
	private JPanel contentPane;
	private JTextField textField_MaSV;
	private JTextField textField_HoVaTen;
	private JTextField textField_NgaySinh;
	private JTextField textField_SDT;
	private JTextField textField_DiaChi;
	private ButtonGroup groupGioiTinh;
	private JScrollPane scrollPane;
	private JRadioButton radioNam;
	private JRadioButton radioNu;
	private JTable table;
	DefaultTableModel defaultTableModel;

	String[] collumName = { "Mã sinh viên", "Họ và tên", "Ngày sinh", "Giới tính", "Số điện thoại", "Địa chỉ" };
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThongTinSinhVienView frame = new ThongTinSinhVienView();
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
	public ThongTinSinhVienView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1300, 551);
		setTitle("Thông tin sinh viên");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 231, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblQLSV = new JLabel("QUẢN LÝ SINH VIÊN");
		lblQLSV.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblQLSV.setBounds(420, 10, 321, 33);
		contentPane.add(lblQLSV);
		
		JLabel lblThongTinSV = new JLabel("Thông tin sinh viên");
		lblThongTinSV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblThongTinSV.setBounds(105, 67, 211, 21);
		contentPane.add(lblThongTinSV);
		
		JLabel lblDSSV = new JLabel("Danh sách sinh viên");
		lblDSSV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDSSV.setBounds(719, 62, 217, 30);
		contentPane.add(lblDSSV);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(43, 98, 328, 301);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelMaSV = new JLabel("Mã sinh viên");
		labelMaSV.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelMaSV.setBounds(10, 21, 91, 13);
		panel.add(labelMaSV);
		
		textField_MaSV = new JTextField();
		textField_MaSV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_MaSV.setBounds(124, 15, 186, 26);
		panel.add(textField_MaSV);
		textField_MaSV.setColumns(10);
		
		JLabel labelHoVaTen = new JLabel("Họ và tên");
		labelHoVaTen.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelHoVaTen.setBounds(10, 67, 91, 19);
		panel.add(labelHoVaTen);
		
		textField_HoVaTen = new JTextField();
		textField_HoVaTen.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_HoVaTen.setColumns(10);
		textField_HoVaTen.setBounds(124, 64, 186, 26);
		panel.add(textField_HoVaTen);
		
		JLabel labelNgaySinh = new JLabel("Ngày sinh");
		labelNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelNgaySinh.setBounds(10, 114, 91, 19);
		panel.add(labelNgaySinh);
		
		textField_NgaySinh = new JTextField();
		textField_NgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_NgaySinh.setColumns(10);
		textField_NgaySinh.setBounds(124, 111, 186, 26);
		panel.add(textField_NgaySinh);
		
		JLabel labelGioiTinh = new JLabel("Giới tính");
		labelGioiTinh.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelGioiTinh.setBounds(10, 161, 91, 13);
		panel.add(labelGioiTinh);
		
		JLabel labelSDT = new JLabel("Số điện thoại");
		labelSDT.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelSDT.setBounds(10, 201, 91, 19);
		panel.add(labelSDT);
		
		textField_SDT = new JTextField();
		textField_SDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_SDT.setColumns(10);
		textField_SDT.setBounds(124, 198, 186, 26);
		panel.add(textField_SDT);
		
		JLabel labelDiaChi = new JLabel("Địa chỉ");
		labelDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelDiaChi.setBounds(10, 244, 91, 19);
		panel.add(labelDiaChi);
		
		textField_DiaChi = new JTextField();
		textField_DiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_DiaChi.setColumns(10);
		textField_DiaChi.setBounds(124, 241, 186, 26);
		panel.add(textField_DiaChi);
		
		radioNam = new JRadioButton("Nam");
		radioNam.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		radioNam.setBounds(126, 157, 91, 21);
		panel.add(radioNam);
		
		radioNu = new JRadioButton("Nữ");
		radioNu.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		radioNu.setBounds(219, 157, 103, 21);
		panel.add(radioNu);
		
		groupGioiTinh = new ButtonGroup();
		groupGioiTinh.add(radioNam);
		groupGioiTinh.add(radioNu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(420, 98, 841, 301);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
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
		table.setModel(defaultTableModel);
		MouseListener mouseListener = new ThongTinSinhVienController(this);
		table.addMouseListener(mouseListener);

		table.setRowHeight(25);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 841, 301);
		scrollPane.getViewport().setBackground(Color.WHITE);
		hienThiData();
		panel_1.add(scrollPane);
		
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(Color.LIGHT_GRAY);
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnThem.setBounds(137, 439, 97, 30);
		contentPane.add(btnThem);
		btnThem.addActionListener(action);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(Color.LIGHT_GRAY);
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSua.setBounds(301, 439, 97, 30);
		contentPane.add(btnSua);
		btnSua.addActionListener(action);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.LIGHT_GRAY);
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnXoa.setBounds(467, 439, 97, 30);
		contentPane.add(btnXoa);
		btnXoa.addActionListener(action);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.LIGHT_GRAY);
		btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnTimKiem.setBounds(635, 439, 97, 30);
		contentPane.add(btnTimKiem);
		btnTimKiem.addActionListener(action);
		
		JButton btnHienThi = new JButton("Hiển thị");
		btnHienThi.setBackground(Color.LIGHT_GRAY);
		btnHienThi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnHienThi.setBounds(805, 439, 97, 30);
		contentPane.add(btnHienThi);
		btnHienThi.addActionListener(action);
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBackground(new Color(215, 81, 62));
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnQuayLai.setBounds(1164, 474, 97, 30);
		contentPane.add(btnQuayLai);
		btnQuayLai.addActionListener(action);
	}
	
	public void hienThiData() {
		dssv = SinhVienDAO.getInstance().selectAll();
		int n = dssv.size();
		data = new String[n][6];
		int index = 0;
		for (SinhVien x : dssv) {
			data[index][0] = x.getMaSV();
			data[index][1] = x.getHoTen();
			data[index][2] = getDateFormatted(x.getNgaySinh());
			data[index][3] = x.getGioiTinh();
			data[index][4] = x.getSdt();
			data[index][5] = x.getDiaChi();
			index++;
		}
		defaultTableModel.setDataVector(data, collumName);
		table.setModel(defaultTableModel);

	}
	
	public static String getDateFormatted(String str) {
		String[] tempNgay = str.split("-");
		String ngayThangNam = tempNgay[2] + "/" + tempNgay[1] + "/" + tempNgay[0];
		return ngayThangNam;
	}

	public static String getReverseDate(String date) {
		String[] temp = date.split("/");
		return temp[2] + "-" + temp[1] + "-" + temp[0];
	}
	
	public boolean checkNull() {
		if (textField_MaSV.getText().trim().isEmpty() || textField_HoVaTen.getText().trim().isEmpty()
				|| textField_NgaySinh.getText().trim().isEmpty() || groupGioiTinh.getSelection() == null
				|| textField_SDT.getText().trim().isEmpty() || textField_DiaChi.getText().trim().isEmpty())
			return true;
		else
			return false;
	}

	public boolean checkMaSV() {
		String txt_ma = textField_MaSV.getText();
		for (SinhVien x : dssv)
			if (x.getMaSV().equals(txt_ma))
				return true;
		return false;
	}
	
	public void themSinhVien() {
		if (checkNull()) {
			JOptionPane.showMessageDialog(rootPane, "Bạn không được để trống các trường");
			return;
		}
		if (checkMaSV()) {
			JOptionPane.showMessageDialog(rootPane, "Mã sinh viên đã tồn tại");
			return;
		}

		SinhVien sv = new SinhVien(textField_MaSV.getText().trim(), textField_HoVaTen.getText().trim(),
				getReverseDate(textField_NgaySinh.getText().trim()),
				(String) (groupGioiTinh.getSelection() == radioNam.getModel() ? "Nam" : "Nữ").toString(),
				textField_SDT.getText(), textField_DiaChi.getText().trim());
		if (SinhVienDAO.getInstance().insert(sv) != 0) {
			JOptionPane.showMessageDialog(rootPane, "Thêm sinh viên thành công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(rootPane, "Thêm sinh viên không thành công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);

		}
		hienThiData();
	}

	public void xoaSinhVien() {
		// TODO Auto-generated method stub
		if (textField_MaSV.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn 1 sinh viên", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if (checkMaSV() == false) {
			JOptionPane.showMessageDialog(rootPane, "Mã sinh viên không tồn tại", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		SinhVien sv = SinhVienDAO.getInstance().selectById(textField_MaSV.getText().trim());

		if (sv != null) {
			int result = JOptionPane.showConfirmDialog(rootPane,
					"Bạn có chắc muốn xóa sinh viên có mã " + sv.getMaSV() + " không?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				SinhVienDAO.getInstance().delete(sv);
				JOptionPane.showMessageDialog(rootPane, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				hienThiData();
			}
		} else {
			JOptionPane.showMessageDialog(rootPane, "Xóa không thành công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void suaSinhVien() {
		// TODO Auto-generated method stub
		if (checkMaSV() == false) {
			JOptionPane.showMessageDialog(rootPane, "Mã sinh viên không tồn tại", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		SinhVien sv = new SinhVien(textField_MaSV.getText().trim(), textField_HoVaTen.getText().trim(),
				getReverseDate(textField_NgaySinh.getText().trim()),
				(String) (groupGioiTinh.getSelection() == radioNam.getModel() ? "Nam" : "Nữ").toString(),
				textField_SDT.getText(), textField_DiaChi.getText().trim());

		if (sv != null) {
			int result = JOptionPane.showConfirmDialog(rootPane,
					"Bạn có chắc muốn sửa sinh viên có mã " + sv.getMaSV() + " không?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				SinhVienDAO.getInstance().update(sv);
				JOptionPane.showMessageDialog(rootPane, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				hienThiData();
			}
		} else {
			JOptionPane.showMessageDialog(rootPane, "Sửa không thành công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void chonDong() {
		int r = table.getSelectedRow();
		String maSV = data[r][0];
		SinhVien sv = SinhVienDAO.getInstance().selectById(maSV);
		textField_MaSV.setText(maSV);
		textField_HoVaTen.setText(sv.getHoTen());
		textField_NgaySinh.setText(getDateFormatted(sv.getNgaySinh()));
		if (sv.getGioiTinh().equals("Nam")) {
			radioNam.setSelected(true);
		} else {
			radioNu.setSelected(true);
		}
		textField_DiaChi.setText(sv.getDiaChi());
		textField_SDT.setText(sv.getSdt());
	}

	public void timSinhVien() {
		// TODO Auto-generated method stub
		if (textField_HoVaTen.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Nhập tên sinh viên cần tìm kiếm", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);

		} else {
			dssv = SinhVienDAO.getInstance().selectByCondition(textField_HoVaTen.getText().trim());
			int n = dssv.size();
			data = new String[n][6];
			int index = 0;
			for (SinhVien x : dssv) {
				data[index][0] = x.getMaSV();
				data[index][1] = x.getHoTen();
				data[index][2] = getDateFormatted(x.getNgaySinh());
				data[index][3] = x.getGioiTinh();
				data[index][4] = x.getSdt();
				data[index][5] = x.getDiaChi();
				index++;
			}
			defaultTableModel.setDataVector(data, collumName);
			table.setModel(defaultTableModel);
		}
	}
	
}
