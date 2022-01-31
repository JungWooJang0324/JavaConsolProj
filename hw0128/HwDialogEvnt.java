package hw0128;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class HwDialogEvnt extends WindowAdapter implements ActionListener, ListSelectionListener {
	private HwDialog dialog;
	private HwMenu menu;
	
	//±âº»°ª ¼³Á¤
	private String font ="¸¼Àº °íµñ";
	private int style = Font.BOLD;
	private int size = 15;
	
	public HwDialogEvnt(HwDialog dialog, HwMenu menu) {
		this.dialog = dialog;
		this.menu = menu;
	}
	
	@Override
	public void windowClosing(WindowEvent we) {		
		if(we.getSource() == dialog) {
			System.out.println("´ÙÀÌ¾ó·Î±× ²¨Áü");
			dialog.dispose();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == dialog.getCancel()) {
			dialog.dispose();
		}
		
		if(ae.getSource() == dialog.getCheck()) {
			menu.getMemoBody().setFont(new Font(font, style, size));
			dialog.dispose();
		}
		
	}
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if (e.getSource() == dialog.getTextList()) {        
			   dialog.getFontTf().setText(String.valueOf(dialog.getTextList().getSelectedValue()));
			   this.font = dialog.getTextList().getSelectedValue();
			   dialog.getChangedFont().setFont(new Font(font, style, size));

			   
        }
		else if(e.getSource() == dialog.getTxtStyleList()) {
        	dialog.getStyleTf().setText(String.valueOf(dialog.getTxtStyleList().getSelectedValue()));
        	String getStyle = dialog.getTxtStyleList().getSelectedValue();	
        	switch(getStyle) {
        	case "ÀÏ¹Ý": this.style = Font.PLAIN; break;
        	case "±½°Ô" : this.style = Font.BOLD; break;
        	case "±â¿ïÀÓ²Ã" : this.style= Font.ITALIC; break;
        	case "±½Àº ±â¿ïÀÓ²Ã": this.style = Font.BOLD + Font.ITALIC;break;
        	}
        	dialog.getChangedFont().setFont(new Font(font, style, size));
        } 
        
        else if(e.getSource() == dialog.getTxtSizeList()) {
        	dialog.getSizeTf().setText(String.valueOf(dialog.getTxtSizeList().getSelectedValue()));
        	size = dialog.getTxtSizeList().getSelectedValue();	
        	dialog.getChangedFont().setFont(new Font(font, style, size));
        	
        }
	}

}
