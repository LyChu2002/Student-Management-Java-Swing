package view;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.TimKiemLopHocPhanController;
import dao.LopHocPhanDAO;
import dao.MonHocDAO;
import model.LopHocPhan;
import model.MonHoc;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.Action;
import javax.swing.JButton;

public class TimKiemLopHocPhanView extends JFrame {
	ArrayList<LopHocPhan> dslhp;
	String[][] data;
	Action action = new TimKiemLopHocPhanController(this);
	private JPanel contentPane;
	private JTextField textField_TenMH;
	private JScrollPane scrollPane;
	private JTable table;
	DefaultTableModel defaultTableModel;

	String[] collumName = { "Mã lớp HP", "Tên lớp HP", "Mã MH", "Tên môn học", "Tên GV", "Ngày bắt đầu", "Ngày kết thúc", "Số tiết" };
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TimKiemLopHocPhanView frame = new TimKiemLopHocPhanView();
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
	public TimKiemLopHocPhanView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 381);
		setTitle("Tìm kiếm lớp học phần");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(243, 231, 234));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập tên môn học");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		lblNewLabel.setBounds(87, 33, 147, 20);
		contentPane.add(lblNewLabel);
		
		textField_TenMH = new JTextField();
		textField_TenMH.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		textField_TenMH.setBounds(229, 30, 198, 29);
		contentPane.add(textField_TenMH);
		textField_TenMH.setColumns(10);
		
		JButton btn_Tim = new JButton("Tìm");
		btn_Tim.setBackground(Color.LIGHT_GRAY);
		btn_Tim.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_Tim.setBounds(479, 29, 85, 29);
		contentPane.add(btn_Tim);
		btn_Tim.addActionListener(action);
		
		JButton btn_Thoat = new JButton("Thoát");
		btn_Thoat.setBackground(new Color(215, 81, 62));
		btn_Thoat.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btn_Thoat.setBounds(589, 29, 85, 29);
		contentPane.add(btn_Thoat);
		btn_Thoat.addActionListener(action);
		
		JPanel panel = new JPanel();
		panel.setBounds(45, 84, 931, 221);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setBounds(38, 60, 381, -37);
		panel.add(table);
		defaultTableModel = new DefaultTableModel() {
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		table.setModel(defaultTableModel);
		table.setRowHeight(25);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 931, 221);
		scrollPane.getViewport().setBackground(Color.WHITE);
		hienThiData();
		panel.add(scrollPane);
	}

	public void hienThiData() {
		String subjectName = textField_TenMH.getText().trim();
		dslhp = LopHocPhanDAO.getInstance().selectBySubjectName(subjectName);
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
			data[index][5] = ThongTinSinhVienView.getDateFormatted(x.getNgayBatDau());
			data[index][6] = ThongTinSinhVienView.getDateFormatted(x.getNgayKetThuc());
			data[index][7] = x.getSoTiet() + "";
			index++;
		}
		defaultTableModel.setDataVector(data, collumName);
		table.setModel(defaultTableModel);
	}
	

}
