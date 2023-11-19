package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.QuanLyMonHocController;
import dao.MonHocDAO;
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

public class QuanLyMonHocView extends JFrame {
	ArrayList<MonHoc> dsmh;
	String[][] data;
	Action action = new QuanLyMonHocController(this);
	private JPanel contentPane;
	private JTextField textField_MaMH;
	private JTextField textField_TenMH;
	private JTextField textField_SoTC;
	private JScrollPane scrollPane;
	private JTable table;
	DefaultTableModel defaultTableModel;

	String[] collumName = { "Mã môn học", "Tên môn học", "Số tín chỉ"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QuanLyMonHocView frame = new QuanLyMonHocView();
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
	public QuanLyMonHocView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 927, 483);
		setTitle("Quản lý môn học");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 231, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ MÔN HỌC");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(359, 10, 205, 34);
		contentPane.add(lblNewLabel);
		
		JLabel labelTTMH = new JLabel("Thông tin môn học");
		labelTTMH.setFont(new Font("Times New Roman", Font.BOLD, 17));
		labelTTMH.setBounds(93, 61, 186, 28);
		contentPane.add(labelTTMH);
		
		JLabel labelDSMH = new JLabel("Danh sách môn học");
		labelDSMH.setFont(new Font("Times New Roman", Font.BOLD, 17));
		labelDSMH.setBounds(564, 61, 186, 28);
		contentPane.add(labelDSMH);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(30, 100, 321, 166);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel labelMaMH = new JLabel("Mã môn học");
		labelMaMH.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelMaMH.setBounds(20, 23, 99, 21);
		panel.add(labelMaMH);
		
		textField_MaMH = new JTextField();
		textField_MaMH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_MaMH.setBounds(123, 21, 177, 26);
		panel.add(textField_MaMH);
		textField_MaMH.setColumns(10);
		
		JLabel labelTenMH = new JLabel("Tên môn học");
		labelTenMH.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelTenMH.setBounds(20, 69, 99, 21);
		panel.add(labelTenMH);
		
		textField_TenMH = new JTextField();
		textField_TenMH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TenMH.setColumns(10);
		textField_TenMH.setBounds(123, 67, 177, 26);
		panel.add(textField_TenMH);
		
		JLabel labelSoTC = new JLabel("Số tín chỉ");
		labelSoTC.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		labelSoTC.setBounds(20, 121, 99, 21);
		panel.add(labelSoTC);
		
		textField_SoTC = new JTextField();
		textField_SoTC.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_SoTC.setColumns(10);
		textField_SoTC.setBounds(123, 119, 177, 26);
		panel.add(textField_SoTC);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(389, 100, 514, 229);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		table.setBounds(10, 130, 325, -119);
	
		defaultTableModel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(defaultTableModel);
		MouseListener mouseListener = new QuanLyMonHocController(this);
		table.addMouseListener(mouseListener);
		table.setRowHeight(25);
		panel_1.add(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 514, 219);
		scrollPane.getViewport().setBackground(Color.WHITE);
		hienThiData();
		panel_1.add(scrollPane);
		
		JButton btnThem = new JButton("Thêm");
		btnThem.setBackground(Color.LIGHT_GRAY);
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnThem.setBounds(115, 365, 86, 28);
		contentPane.add(btnThem);
		btnThem.addActionListener(action);
		
		JButton btnSua = new JButton("Sửa");
		btnSua.setBackground(Color.LIGHT_GRAY);
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnSua.setBounds(242, 365, 86, 28);
		contentPane.add(btnSua);
		btnSua.addActionListener(action);
		
		JButton btnXoa = new JButton("Xóa");
		btnXoa.setBackground(Color.LIGHT_GRAY);
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnXoa.setBounds(379, 365, 86, 28);
		contentPane.add(btnXoa);
		btnXoa.addActionListener(action);
		
		JButton btnTimKiem = new JButton("Tìm kiếm");
		btnTimKiem.setBackground(Color.LIGHT_GRAY);
		btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnTimKiem.setBounds(523, 365, 102, 28);
		contentPane.add(btnTimKiem);
		btnTimKiem.addActionListener(action);
		
		JButton btnHienThi = new JButton("Hiển thị");
		btnHienThi.setBackground(Color.LIGHT_GRAY);
		btnHienThi.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnHienThi.setBounds(664, 365, 102, 28);
		contentPane.add(btnHienThi);
		btnHienThi.addActionListener(action);
		
		JButton btnQuayLai = new JButton("Quay lại");
		btnQuayLai.setBackground(new Color(215, 81, 62));
		btnQuayLai.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnQuayLai.setBounds(785, 408, 102, 28);
		contentPane.add(btnQuayLai);
		btnQuayLai.addActionListener(action);

	}
	
	public void hienThiData() {
		dsmh = MonHocDAO.getInstance().selectAll();
		int n = dsmh.size();
		data = new String[n][3];
		int index = 0;
		for(MonHoc x : dsmh) {
			data[index][0] = x.getMaMH();
			data[index][1] = x.getTenMH();
			data[index][2] = x.getSoTC() + " ";
			index++;
		}
		defaultTableModel.setDataVector(data, collumName);
		table.setModel(defaultTableModel);
	}
	
	public boolean checkNull() {
		if (textField_MaMH.getText().trim().isEmpty() || textField_TenMH.getText().trim().isEmpty()
				|| textField_SoTC.getText().trim().isEmpty())
			return true;
		else
			return false;
	}

	public boolean checkMaMH() {
		String txt_ma = textField_MaMH.getText();
		for (MonHoc x : dsmh)
			if (x.getMaMH().equals(txt_ma))
				return true;
		return false;
	}
	
	public void themMonHoc() {
		if (checkNull()) {
			JOptionPane.showMessageDialog(rootPane, "Bạn không được để trống các trường");
			return;
		}
		if (checkMaMH()) {
			JOptionPane.showMessageDialog(rootPane, "Mã môn học đã tồn tại");
			return;
		}

		MonHoc mh = new MonHoc(textField_MaMH.getText().trim(), textField_TenMH.getText().trim(), Integer.parseInt(textField_SoTC.getText().trim()));
		if (MonHocDAO.getInstance().insert(mh) != 0) {
			JOptionPane.showMessageDialog(rootPane, "Thêm môn học thành công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(rootPane, "Thêm môn học không thành công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);

		}
		hienThiData();
	}
	
	public void xoaMonHoc() {
		if(textField_MaMH.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Bạn phải chọn 1 môn học", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		if(checkMaMH() == false) {
			JOptionPane.showMessageDialog(rootPane, "Mã môn học không tồn tại", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		MonHoc mh = MonHocDAO.getInstance().selectById(textField_MaMH.getText().trim());
		if(mh != null) {
			int result = JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa môn học có mã " + mh.getMaMH() + " không?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result == JOptionPane.YES_NO_OPTION) {
				MonHocDAO.getInstance().delete(mh);
				JOptionPane.showMessageDialog(rootPane, "Xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				hienThiData();
			}
		}else {
			JOptionPane.showMessageDialog(rootPane, "Xóa không thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void suaMonHoc() {
		// TODO Auto-generated method stub
		if (checkMaMH() == false) {
			JOptionPane.showMessageDialog(rootPane, "Mã môn học không tồn tại", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		MonHoc mh = new MonHoc(textField_MaMH.getText().trim(), textField_TenMH.getText().trim(), Integer.parseInt(textField_SoTC.getText().trim()));

		if (mh != null) {
			int result = JOptionPane.showConfirmDialog(rootPane,
					"Bạn có chắc muốn sửa môn học có mã " + mh.getMaMH() + " không?", "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (result == JOptionPane.YES_OPTION) {
				MonHocDAO.getInstance().update(mh);
				JOptionPane.showMessageDialog(rootPane, "Sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
				hienThiData();
			}
		} else {
			JOptionPane.showMessageDialog(rootPane, "Sửa không thành công", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void timKiemMonHoc() {
		// TODO Auto-generated method stub
		if (textField_TenMH.getText().equals("")) {
			JOptionPane.showMessageDialog(rootPane, "Nhập tên môn học cần tìm kiếm", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);

		} else {
			dsmh = MonHocDAO.getInstance().selectByCondition(textField_TenMH.getText());
			int n = dsmh.size();
			data = new String[n][3];
			int index = 0;
			for (MonHoc x : dsmh) {
				data[index][0] = x.getMaMH();
				data[index][1] = x.getTenMH();
				data[index][2] = x.getSoTC() + " ";
				index++;
			}
			defaultTableModel.setDataVector(data, collumName);
			table.setModel(defaultTableModel);
		}
	}
	
	public void chonDong() {
		int r = table.getSelectedRow();
		String maMH = data[r][0];
		MonHoc mh = MonHocDAO.getInstance().selectById(maMH);
		textField_MaMH.setText(maMH);
		textField_TenMH.setText(mh.getTenMH());
		textField_SoTC.setText(mh.getSoTC()+ " ");
	}
}
