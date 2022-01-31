package hw0128;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class HwMenu extends JFrame {
	private JMenuItem newtxt, open, save, textFont ,newNameSave, close, memoReview, help;
	private JTextArea memoBody;
	public HwMenu() {
		super("�޸���");
		
		JMenuBar memoMenu = new JMenuBar();
		
		JMenu menuFile = new JMenu("����");
		JMenu menuFont = new JMenu("����");
		JMenu helpMenu= new JMenu("����");
		
		newtxt = new JMenuItem("���� ����");
		open = new JMenuItem("����");
		save = new JMenuItem("����");
		newNameSave= new JMenuItem("�ٸ��̸����� ����");
		close= new JMenuItem("�ݱ�");
		textFont = new JMenuItem("�۲�");
		help = new JMenuItem("�޸��� ����");
		menuFile.add(newtxt);
		menuFile.add(open);
		menuFile.add(save);
		menuFile.add(newNameSave);
		menuFile.add(close);
		
		
		menuFont.add(textFont);
		helpMenu.add(help);
		
		memoMenu.add(menuFile);
		memoMenu.add(menuFont);
		memoMenu.add(helpMenu);
		
		setJMenuBar(memoMenu);
		memoBody = new JTextArea();
		add(memoBody);
		
		HwEvent event = new HwEvent(this);
		textFont.addActionListener(event);
		close.addActionListener(event);
		newtxt.addActionListener(event);
		addWindowListener(event);
		
		
		setSize(500,500);
		setVisible(true);
		
		
	}
	
	
	public JMenuItem getNewtxt() {
		return newtxt;
	}


	public JMenuItem getOpen() {
		return open;
	}


	public JMenuItem getSave() {
		return save;
	}


	public JMenuItem getTextFont() {
		return textFont;
	}


	public JMenuItem getNewNameSave() {
		return newNameSave;
	}


	public JMenuItem getClose() {
		return close;
	}


	public JMenuItem getMemoReview() {
		return memoReview;
	}


	public JMenuItem getHelp() {
		return help;
	}


	public JTextArea getMemoBody() {
		return memoBody;
	}


	public static void main(String[] args) {
		new HwMenu();
	}
	
}