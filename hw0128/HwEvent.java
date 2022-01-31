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
			System.out.println("������Ŭ���� ����");
			menu.dispose();						
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		//�޴��� �ݱ��ư
		if(ae.getSource()== menu.getClose()) {
			menu.dispose();
		}else if(ae.getSource()==menu.getTextFont()) {
			//���̾�α� �θ���
			new HwDialog(menu);
		} 
		
		//���� �ҷ�����
		if(ae.getSource() == menu.getNewtxt()) {
			if(!menu.getMemoBody().getText().isEmpty()) {
				int ask = JOptionPane.showConfirmDialog(menu, "���� �޸����� ������ �� ���Ͽ� �����Ͻðڽ��ϱ�?");
				switch(ask) {
				//�����ϱ�
				case JOptionPane.OK_OPTION:
					FileDialog fd = new FileDialog(menu, "����", FileDialog.SAVE);
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
