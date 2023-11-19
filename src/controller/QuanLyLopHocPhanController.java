package controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeListener;

import javax.swing.Action;
import javax.swing.JFrame;

import view.QuanLyLopHocPhanView;
import view.TimKiemLopHocPhanView;
import view.TrangChuAdminView;

public class QuanLyLopHocPhanController implements Action, MouseListener{
	private QuanLyLopHocPhanView view;
	
	public QuanLyLopHocPhanController(QuanLyLopHocPhanView view) {
		super();
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if(command.equals("Hiển thị")) {
			this.view.hienThiData();
		}else if(command.equals("Thêm")) {
			this.view.themLopHP();
		}else if(command.equals("Sửa")) {
			this.view.suaLopHP();
		}else if(command.equals("Xóa")) {
			this.view.xoaLopHP();
		}else if(command.equals("Tìm kiếm")) {
			openTimKiemLopHocPhan();
		}else if(command.equals("Quay lại")) {
			JFrame frame = TrangChuAdminView.getInstance();
			frame.setVisible(true);
			this.view.dispose();
		}
	}

	private void openTimKiemLopHocPhan() {
		// TODO Auto-generated method stub
		JFrame frame = new TimKiemLopHocPhanView();
		frame.setLocationRelativeTo(null);
		view.setVisible(true);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		this.view.chonDong();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getValue(String key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void putValue(String key, Object value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEnabled(boolean b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		// TODO Auto-generated method stub
		
	}
	
}
