package hw0128;

import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class HwEvent extends WindowAdapter implements ActionListener{
	private HwMenu menu;
	
	
	public HwEvent(HwMenu menu) {
		this.menu = menu;
	}

	
	@Override
	public void windowClosing(WindowEvent we) {		
		if(we.getSource() == menu) {
			System.out.println("디자인클래스 꺼짐");
			menu.dispose();						
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//메뉴바 닫기버튼
		if(ae.getSource()== menu.getClose()) {
			menu.dispose();
		}else if(ae.getSource()==menu.getTextFont()) {
			//다이얼로그 부르기
			new HwDialog(menu);
		} 
		
		//새글 불러오기
		if(ae.getSource() == menu.getNewtxt()) {
			if(!menu.getMemoBody().getText().isEmpty()) {
				int ask = JOptionPane.showConfirmDialog(menu, "현재 메모장의 내용을 새 파일에 저장하시겠습니까?");
				switch(ask) {
				//저장하기
				case JOptionPane.OK_OPTION:
					FileDialog fd = new FileDialog(menu, "저장", FileDialog.SAVE);
					fd.setVisible(true);
					menu.getMemoBody().setText("");
					break;
				case JOptionPane.NO_OPTION:
					menu.getMemoBody().setText("");
					break;
			
			}
		}
		

		}

	}
}
