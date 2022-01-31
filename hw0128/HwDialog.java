package hw0128;


import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class HwDialog extends JDialog{
	
	private JButton check, cancel;
	private JTextField fontTf, styleTf, sizeTf;
	private JList<String> textList, txtStyleList;
	private JList<Integer> txtSizeList;
	private JLabel changedFont;

	public HwDialog(HwMenu menu) {
		super(menu, "�۲�", true);
		JLabel textLable, txtStyleLable, txtSizeLabel;
		
		//�۲�: 
		textLable = new JLabel("�۲� : "); 
		String[] tsList = {"����", "���� ���", "�ü�ü", "Serif", "SansSerif"};
		textList = new JList<String>(tsList);
		fontTf = new JTextField();
		
		//�۲� ��Ÿ��:
		txtStyleLable = new JLabel("�۲� ��Ÿ�� :");
		String[] stList = "�Ϲ�,����,����Ӳ�,���� ����Ӳ�".split(",");
		txtStyleList = new JList<String>(stList);
		styleTf = new JTextField();
		
		//ũ�� : JList�� ���͸� ����
		txtSizeLabel = new JLabel("ũ��: ");
		Vector<Integer> sList = new Vector<Integer>();
		for(int i=1; i<=80; i++) {
			sList.add(i);
			if(i>10) {
				i++;
				sList.add(i);
			}
		}
		

		txtSizeList = new JList<Integer>();
		txtSizeList.setListData(sList);
		sizeTf = new JTextField();
		
		
		JScrollPane txtscrollPane = new JScrollPane(textList);
		JScrollPane stylescrollPane = new JScrollPane(txtStyleList);
		JScrollPane sizescrollPane = new JScrollPane(txtSizeList);

		//�ٲ���Ʈ����
		changedFont = new JLabel("AaBbYyZz");
		changedFont.setBorder(new TitledBorder("����: "));
		
		check = new JButton("Ȯ��");
		cancel = new JButton("�ݱ�");

		add(txtscrollPane);
		add(textLable);
		add(fontTf);
		add(stylescrollPane);
		add(txtStyleLable);
		add(styleTf);
		add(sizescrollPane);
		add(txtSizeLabel);
		add(sizeTf);
		
		add(changedFont);
		add(check);
		add(cancel);
		
		HwDialogEvnt dialogEvt = new HwDialogEvnt(this, menu);
		addWindowListener(dialogEvt);
		textList.addListSelectionListener(dialogEvt);
		txtStyleList.addListSelectionListener(dialogEvt);
		txtSizeList.addListSelectionListener(dialogEvt);
		
		check.addActionListener(dialogEvt);
		cancel.addActionListener(dialogEvt);
		
		setLayout(null);
		textLable.setBounds(20,10,50,30);
		fontTf.setBounds(20,38,130,25);
		txtscrollPane.setBounds(20,65,130,100);
		
		txtStyleLable.setBounds(200,10,90,30);
		styleTf.setBounds(200,38,130,25);
		stylescrollPane.setBounds(200,65,130,100);
		
		txtSizeLabel.setBounds(350,10,90,30);
		sizeTf.setBounds(350,38,90,25);
		sizescrollPane.setBounds(350,65,90,100);
		
		changedFont.setBounds(280, 180, 150, 100);
		check.setBounds(280, 300, 60,30 );
		cancel.setBounds(350, 300, 60,30);
		
		setBounds(menu.getX()+100, menu.getY()+100, 500,450);
		setVisible(true);
		
	}

	public JTextField getStyleTf() {
		return styleTf;
	}

	public JList<String> getTxtStyleList() {
		return txtStyleList;
	}

	public JButton getCheck() {
		return check;
	}

	public JButton getCancel() {
		return cancel;
	}

	public JTextField getFontTf() {
		return fontTf;
	}

	public JList<String> getTextList() {
		return textList;
	}

	public JTextField getSizeTf() {
		return sizeTf;
	}

	public JList<Integer> getTxtSizeList() {
		return txtSizeList;
	}

	public JLabel getChangedFont() {
		return changedFont;
	}
	
}
