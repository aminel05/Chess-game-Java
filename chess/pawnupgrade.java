package chess;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class pawnupgrade implements ActionListener {
	JFrame upframe;
	JPanel choose;
	JButton[] rkbqbutton;
	ImageIcon[] pieces;
	String[] wicons={"src\\chess\\wrook.png","src\\chess\\wkhight.png","src\\chess\\wbeshop.png","src\\chess\\wquinn.png"},bicons={"src\\chess\\brook.png","src\\chess\\bkhight.png","src\\chess\\bbeshop.png","src\\chess\\bquinn.png"};
	static String pawnto ="";
	JLabel[][] wpieces,bpieces;
	int pawnx,pawny,q=1;
	boolean turn;
	pawnupgrade(boolean turn,JLabel[][] wpieces,JLabel[][] bpieces,int pawnx,int pawny){
		this.turn=turn;
		upframe = new JFrame();
		upframe.setUndecorated(true);
		upframe.setSize(200,200);
		upframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		upframe.setResizable(false);
		upframe.setLocationRelativeTo(null);
		upframe.setVisible(true);
		upframe.setAlwaysOnTop(true);
		
		this.wpieces=wpieces;
		this.bpieces=bpieces;
		this.pawnx=pawnx;
		this.pawny=pawny;

		
		
		choose = new JPanel();
		choose.setLayout(new GridLayout(2, 2));
		upframe.add(choose);
		
		rkbqbutton = new JButton[4];
		pieces = new ImageIcon[4];
		for (int i =0 ; i<4 ; i++) {
			pieces[i] = new ImageIcon(turn?wicons[i]:bicons[i]);
			rkbqbutton[i] = new JButton();
			rkbqbutton[i].setFocusable(false);
			rkbqbutton[i].setIcon(pieces[i]);
			rkbqbutton[i].setBackground(Color.white);
			rkbqbutton[i].setOpaque(true);
			rkbqbutton[i].setBackground((i==0||i==3) ?MAIN.color2:MAIN.color1);
			rkbqbutton[i].addActionListener(this);
			choose.add(rkbqbutton[i]);
			
		}
		
		upframe.setVisible(true);
	}
	
	public String getpawnto() {
		return pawnto;
	}
	pawnupgrade(){
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		for (int i =0 ; i<4 ; i++) {
			if(e.getSource()==rkbqbutton[i]) {
				
				switch (i) {
				case 0 :pawnto="rook";
				if(turn==true) {wpieces[pawnx][pawny].setIcon(pieces[i]);}
				else{bpieces[pawnx][pawny].setIcon(pieces[i]);}
					upframe.dispose();
				break;
				case 1 :pawnto="khight";
				if(turn==true) {wpieces[pawnx][pawny].setIcon(pieces[i]);}
				else{bpieces[pawnx][pawny].setIcon(pieces[i]);}
					upframe.dispose();
				break;
				case 2 :pawnto="beshop";
				if(turn==true) {wpieces[pawnx][pawny].setIcon(pieces[i]);}
				else{bpieces[pawnx][pawny].setIcon(pieces[i]);}
					upframe.dispose();
				break;
				case 3 :pawnto="quinn";
				if(turn==true) {wpieces[pawnx][pawny].setIcon(pieces[i]);}
				else{bpieces[pawnx][pawny].setIcon(pieces[i]);}
					upframe.dispose();
				break;
				
				}
			}
		}
	}
}
