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

public class QuanLyKetQuaHocTapView extends JFrame {
	ArrayList<Diem> dsd;
	String data[][];
	Action action = new QuanLyKetQuaHocTapController(this);
	private JPanel contentPane;
	private JTextField textField_MaLopHP;
	private JTextField textField_MaSV;
	private JTextField textField_TenSV;
	private JTextField textField_SoTietNghi;
	private JTextField textField_DiemTX1;
	private JTextField textField_DiemTX2;
	private JScrollPane scrollPane;
	private JTable table;
	DefaultTableModel defaultTableModel;

	String[] collumName = { "Mã sinh viên", "Họ và tên", "Mã lớp", "Số tiết nghỉ", "KTTX1", "KTTX2", "Điểm TB", "Điều kiện" };
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyKetQuaHocTapView frame = new QuanLyKetQuaHocTapView();
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
	public QuanLyKetQuaHocTapView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1234, 477);
		setTitle("Quản lý kết quả học tập");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 231, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ KẾT QUẢ HỌC TẬP");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(452, 10, 305, 35);
		contentPane.add(lblNewLabel);
		
		JLabel labelNhapDiem = new JLabel("Nhập điểm sinh viên");
		labelNhapDiem.setFont(new Font("Times New Roman", Font.BOLD, 18));
		labelNhapDiem.setBounds(111, 55, 201, 21);
		contentPane.add(labelNhapDiem);
		
		JLabel lblDanhSachSV = new JLabel("Danh sách điểm sinh viên");
		lblDanhSachSV.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblDanhSachSV.setBounds(698, 55, 222, 21);
		contentPane.add(lblDanhSachSV);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(36, 86, 337, 250);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_MaLopHP = new JLabel("Nhập mã lớp học phần");
		label_MaLopHP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_MaLopHP.setBounds(10, 15, 151, 26);
		panel.add(label_MaLopHP);
		
		textField_MaLopHP = new JTextField();
		textField_MaLopHP.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_MaLopHP.setBounds(157, 15, 165, 26);
		panel.add(textField_MaLopHP);
		textField_MaLopHP.setColumns(10);
		
		JLabel label_MaSV = new JLabel("Mã sinh viên");
		label_MaSV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_MaSV.setBounds(10, 51, 151, 26);
		panel.add(label_MaSV);
		
		textField_MaSV = new JTextField();
		textField_MaSV.setEditable(false);
		textField_MaSV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_MaSV.setColumns(10);
		textField_MaSV.setBounds(157, 50, 165, 26);
		panel.add(textField_MaSV);
		
		JLabel label_TenSV = new JLabel("Tên sinh viên");
		label_TenSV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_TenSV.setBounds(10, 87, 151, 26);
		panel.add(label_TenSV);
		
		textField_TenSV = new JTextField();
		textField_TenSV.setEditable(false);
		textField_TenSV.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TenSV.setColumns(10);
		textField_TenSV.setBounds(157, 85, 165, 26);
		panel.add(textField_TenSV);
		
		JLabel label_SoTietNghi = new JLabel("Số tiết nghỉ");
		label_SoTietNghi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_SoTietNghi.setBounds(10, 120, 151, 26);
		panel.add(label_SoTietNghi);
		
		textField_SoTietNghi = new JTextField();
		textField_SoTietNghi.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_SoTietNghi.setColumns(10);
		textField_SoTietNghi.setBounds(157, 120, 165, 26);
		panel.add(textField_SoTietNghi);
		
		JLabel label_DiemTX1 = new JLabel("Điểm thường xuyên 1");
		label_DiemTX1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_DiemTX1.setBounds(10, 156, 151, 26);
		panel.add(label_DiemTX1);
		
		textField_DiemTX1 = new JTextField();
		textField_DiemTX1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_DiemTX1.setColumns(10);
		textField_DiemTX1.setBounds(157, 155, 165, 26);
		panel.add(textField_DiemTX1);
		
		JLabel label_DiemTX2 = new JLabel("Điểm thường xuyên 2");
		label_DiemTX2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		label_DiemTX2.setBounds(10, 192, 151, 26);
		panel.add(label_DiemTX2);
		
		textField_DiemTX2 = new JTextField();
		textField_DiemTX2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_DiemTX2.setColumns(10);
		textField_DiemTX2.setBounds(157, 190, 165, 26);
		panel.add(textField_DiemTX2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(399, 86, 799, 250);
		contentPane.add(panel_1);
		

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
		MouseListener mouseListener = new QuanLyKetQuaHocTapController(this);
		table.addMouseListener(mouseListener);
		panel_1.setLayout(null);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 799, 250);
		scrollPane.getViewport().setBackground(Color.WHITE);
		//hienThiData();
		panel_1.add(scrollPane);
		
		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.setBackground(Color.LIGHT_GRAY);
		btnCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnCapNhat.setBounds(243, 372, 103, 29);
		contentPane.add(btnCapNhat);
		btnCapNhat.addActionListener(action);
		
		JButton btnHienThi = new JButton("Hiển thị");
		btnHienThi.setBackground(Color.LIGHT_GRAY);
		btnHienThi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnHienThi.setBounds(483, 372, 109, 28);
		contentPane.add(btnHienThi);
		btnHienThi.addActionListener(action);
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBackground(new Color(215, 81, 62));
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnQuayLai.setBounds(1084, 401, 109, 29);
		contentPane.add(btnQuayLai);
		btnQuayLai.addActionListener(action);
		
		JButton btnThongKe = new JButton("Thống kê");
		btnThongKe.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnThongKe.setBackground(Color.LIGHT_GRAY);
		btnThongKe.setBounds(737, 372, 109, 28);
		contentPane.add(btnThongKe);
		btnThongKe.addActionListener(action);
	}

	public void hienThiData() {
		// TODO Auto-generated method stub
		String maLopHP = textField_MaLopHP.getText().trim();
		if(maLopHP.equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Bạn cần điền mã học phần");
			return;
		}
		dsd = DiemDAO.getInstance().selectByClassID(maLopHP);
		int n = dsd.size();
		data = new String[n][8];
		int index = 0;
		SinhVien sv;
		LopHocPhan lhp;
		for (Diem x : dsd) {
			data[index][0] = x.getMaSV();
			sv = SinhVienDAO.getInstance().selectById(x.getMaSV());
			data[index][1] = sv.getHoTen();
			data[index][2] = x.getMaLopHP();
			data[index][3] = x.getSoTietNghi()+" ";
			data[index][4] = x.getDiemKTTX1() + "";
			data[index][5] = x.getDiemKTTX2() + "";
			lhp = LopHocPhanDAO.getInstance().selectById(maLopHP);
			double diemTB = (x.getDiemKTTX1() + x.getDiemKTTX2())/2;
			double soTietToiDa = lhp.getSoTiet() * 30 / 100;
			data[index][6] = diemTB + " ";
			if(diemTB >= 4 && x.getSoTietNghi() <= soTietToiDa) {
				data[index][7] = "Đủ điều kiện";
			}else {
				data[index][7] = "Học lại";
			}			
			index++;
		}
		defaultTableModel.setDataVector(data, collumName);
		table.setModel(defaultTableModel);
	}
	
	public void chonDong() {
		int r = table.getSelectedRow();
		String maLopHP = textField_MaLopHP.getText().trim();
		String maSV = data[r][0];
		Diem diem = DiemDAO.getInstance().selectByStudentAndClassId(maSV, maLopHP);
		textField_MaSV.setText(maSV);
		SinhVien sv = SinhVienDAO.getInstance().selectById(maSV);
		textField_TenSV.setText(sv.getHoTen());
		textField_SoTietNghi.setText(diem.getSoTietNghi()+" ");
		textField_DiemTX1.setText(diem.getDiemKTTX1() + " ");
		textField_DiemTX2.setText(diem.getDiemKTTX2() + " ");
	}
	
	public void capNhatDiem() {
		// TODO Auto-generated method stub
		
		Diem diem = new Diem(textField_MaSV.getText().trim(), textField_MaLopHP.getText().trim(), Integer.parseInt(textField_SoTietNghi.getText().trim()),
				Double.parseDouble(textField_DiemTX1.getText().trim()), Double.parseDouble(textField_DiemTX2.getText().trim()));
		if (diem != null) {
			int result = JOptionPane.showConfirmDialog(rootPane,
					"Bạn có chắc muốn cập nhật điểm của sinh viên có mã " + diem.getMaSV() + " không?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				DiemDAO.getInstance().updateKQHT(diem);
				JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				hienThiData();
			}
		} else {
			JOptionPane.showMessageDialog(rootPane, "Cập nhật không thành công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	//Thong ke danh sach sinh vien du dieu kien thi
	
	public void thongKe() {
		String maLopHP = textField_MaLopHP.getText().trim();
		if(maLopHP.equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Bạn cần điền mã học phần");
			return;
		}
		dsd = DiemDAO.getInstance().selectByPassedCondition(maLopHP);
		int n = dsd.size();
		data = new String[n][8];
		int index = 0;
		SinhVien sv;
		LopHocPhan lhp;
		for (Diem x : dsd) {
			data[index][0] = x.getMaSV();
			sv = SinhVienDAO.getInstance().selectById(x.getMaSV());
			data[index][1] = sv.getHoTen();
			data[index][2] = x.getMaLopHP();
			data[index][3] = x.getSoTietNghi()+" ";
			data[index][4] = x.getDiemKTTX1() + "";
			data[index][5] = x.getDiemKTTX2() + "";
			lhp = LopHocPhanDAO.getInstance().selectById(maLopHP);
			double diemTB = (x.getDiemKTTX1() + x.getDiemKTTX2())/2;
			double soTietToiDa = lhp.getSoTiet() * 30 / 100;
			data[index][6] = diemTB + " ";
			if(diemTB >= 4 && x.getSoTietNghi() <= soTietToiDa) {
				data[index][7] = "Đủ điều kiện";
			}else {
				data[index][7] = "Học lại";
			}			
			index++;
		}
		defaultTableModel.setDataVector(data, collumName);
		table.setModel(defaultTableModel);
	}
	
	
}
