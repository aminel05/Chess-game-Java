package chess;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MAIN implements ActionListener{
	JFrame preframe;
	JPanel mainp;
	JLabel announce;
	JLabel[] smallblocks,smallbcl;
	JPanel smallboard,smallcolor;
	JButton startbut;
	JRadioButton movcol,timerr,col1,col2,col3,col4;
	ImageIcon chek=new ImageIcon("chek.png"),unchek=new ImageIcon("unchek.png");
	static boolean movehelper;
	ImageIcon wrookicon = new ImageIcon("src\\chess\\wrook.png");
	JComboBox timer;
	String[] periods = {"60 min","30 min","15 min","10 min","5 min","3 min"};
	static int time=61,cl=0x356C35;
	static Color color1=Color.gray,color2=Color.white,mcl2=new Color(0x75C675),mcl1=new Color(0x98FB98),mcl4=new Color(0xfafafa),mcl3=new Color(0x808081),
			mcl5=new Color(0x808082),mcl6=new Color(0xF5F5F5);
	
	
	public MAIN(){
		preframe = new JFrame();
		preframe.setSize(700,400);
		preframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		preframe.setResizable(false);
		preframe.setLocationRelativeTo(null);
		preframe.setTitle("Chess(by amine)");
		preframe.setIconImage(wrookicon.getImage());
			
		mainp = new JPanel();
		mainp.setLayout(null);
		mainp.setBackground(new Color(0x235123));
		preframe.add(mainp);
			
		announce = new JLabel();
		announce.setOpaque(true);
		announce.setBackground(Color.gray );
		announce.setBounds(25, 25, 635, 100);
		announce.setFont(new Font(".",Font.BOLD,35));
		announce.setText("Welcome to the chess game");
		announce.setHorizontalAlignment(JLabel.CENTER);
		mainp.add(announce);
			
		startbut = new JButton();
		startbut.setBounds(255, 175, 175, 75);
		startbut.setFocusable(false);
		startbut.setBackground(new Color(0x75C675));
		startbut.setFont(new Font(".",Font.BOLD,35));
		startbut.setText("START");
		startbut.setHorizontalAlignment(JButton.CENTER);
		startbut.addActionListener(this);
		mainp.add(startbut);
		
		 ButtonGroup group = new ButtonGroup();
		  group.add(movcol);
		  group.add(timerr);
		  
		  
		  
		  
		  col1=new JRadioButton("col1");
		  col1.setBounds(480, 165, 20, 25);
		  col1.setBackground(new Color(0x235123));
		  col1.addActionListener(this);
		  mainp.add(col1);
		  
		  col2=new JRadioButton("col2");
		  col2.setBounds(480, 205, 20, 25);
		  col2.setBackground(new Color(0x235123));
		  col2.addActionListener(this);
		  mainp.add(col2);
		  
		  col3=new JRadioButton("col3");
		  col3.setBounds(480, 250, 20, 25);
		  col3.setBackground(new Color(0x235123));
		  col3.addActionListener(this);
		  mainp.add(col3);
		  
		  col4=new JRadioButton("col4");
		  col4.setBounds(480, 295, 20, 25);
		  col4.setBackground(new Color(0x235123));
		  col4.addActionListener(this);
		  mainp.add(col4);
		  
		  ButtonGroup clgroup = new ButtonGroup();
		  clgroup.add(col1);
		  clgroup.add(col2);
		  clgroup.add(col3);
		  clgroup.add(col4);
		  
			
			
		movcol= new JRadioButton("helper");
		movcol.setBounds(290, 265, 150, 25);
		movcol.setFont(new Font(".",Font.BOLD,20));
		movcol.setForeground(Color.BLACK);
		movcol.setFocusable(false);
		movcol.addActionListener(this);
		movcol.setBackground(new Color(0x235123));
		//movcol.setIcon(unchek);
		mainp.add(movcol);
		
		timerr= new JRadioButton("timer");
		timerr.setBounds(290, 290, 75, 25);
		timerr.setFont(new Font(".",Font.BOLD,20));
		timerr.setForeground(Color.BLACK);
		timerr.setFocusable(false);
		timerr.addActionListener(this);
		timerr.setBackground(new Color(0x235123));
		//timerr.setIcon(unchek);
		mainp.add(timerr);
		

			smallboard = new JPanel();
			smallboard.setBackground(Color.black);
			smallboard.setLayout(new GridLayout(3, 3));
			smallboard.setBounds( 25 , 150, 180, 180);
			mainp.add(smallboard);
			
			smallcolor = new JPanel();
			smallcolor.setBackground(Color.black);
			smallcolor.setLayout(new GridLayout(4, 2));
			smallcolor.setBounds(500, 150, 160, 180);
			mainp.add(smallcolor);
		
		
			smallbcl = new JLabel[8];
			for (int i = 0 ; i < 8 ; i++) {
				smallbcl[i]= new JLabel();
				smallbcl[i].setOpaque(true);
				switch(i) {
				
				case 0 :smallbcl[i].setBackground(new Color(0x4c844c));
				break;
				case 1 :smallbcl[i].setBackground(new Color(0xdad9b5));
				break;
				case 2 :smallbcl[i].setBackground(Color.gray);
				break;
				case 3 :smallbcl[i].setBackground(Color.white);
				break;
				case 4 :smallbcl[i].setBackground(new Color(0x964d22));
				break;
				case 5 :smallbcl[i].setBackground(new Color(0xeedc97));
				break;
				case 6 :smallbcl[i].setBackground(new Color(0x4b5198));
				break;
				case 7 :smallbcl[i].setBackground(new Color(0xa0b7cb));
				break;
				}
				
				smallcolor.add(smallbcl[i]);
				
			}
			
		
		smallblocks = new JLabel[9];
		for (int i = 0 ; i < 9 ; i++) {
			smallblocks[i]= new JLabel();
			smallblocks[i].setOpaque(true);
			if((i)%2!=0) {
				smallblocks[i].setBackground(color2);
			}
			if((i)%2==0) {
				smallblocks[i].setBackground(color1);
			}
			smallboard.add(smallblocks[i]);
			}
		
		
		
		
		smallblocks[7].setIcon(wrookicon);
		
		
		
		timer = new JComboBox(periods);
		timer.setBounds(290, 325,100,25);
		timer.setBackground(Color.gray);
		timer.setFont(new Font(".",Font.BOLD,20));
		timer.setVisible(false);
		timer.addActionListener(this);
		timer.setFocusable(false);
		mainp.add(timer);
		
		
		
		
		
		//------------------------
		preframe.setVisible(true);
	}
	
	
	
	
	public static void main(String[] args) {
		
		 new MAIN();
		
		//Chessboard Chessboard = new Chessboard();
	}
	public void helpercolor(){
		if(movcol.isSelected()) {
			movehelper=true;;
			smallblocks[4].setBackground(mcl2);
			smallblocks[6].setBackground(mcl2);
			smallblocks[8].setBackground(mcl2);
			smallblocks[1].setBackground(mcl1);
		}
		else {
			movehelper=false;
			smallblocks[4].setBackground(color1);
			smallblocks[6].setBackground(color1);
			smallblocks[8].setBackground(color1);
			smallblocks[1].setBackground(color2);
		}	
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==col1) {
			
			color1=new Color(0x4c844c);mcl2=new Color(0x386538);mcl3=new Color(0x4B894B);mcl5=new Color(0x4c844d);
			color2=new Color(0xdad9b5);mcl1=new Color(0xB1B090);mcl4=new Color(0xDAD9B6);mcl6=new Color(0xdad9b6);
			cl=0x256325;
		}
		
		if(e.getSource()==col2) {
			
			color1=Color.gray;mcl2=new Color(0x75C675);mcl3=new Color(0x808081);mcl5=new Color(0x808082);
			color2=Color.white;mcl1=new Color(0x98FB98);mcl4=new Color(0xF4FFFA);mcl6=new Color(0xF5F5F5);
			cl=0x356C35;
		}
		
		if(e.getSource()==col3) {
			
			color1=new Color(0x964d22);mcl1=new Color(0xC2B379);mcl3=new Color(0x954D23);mcl5=new Color(0x964d23);
			color2=new Color(0xeedc97);mcl2=new Color(0x773C19);mcl4=new Color(0xF1DF99);mcl6=new Color(0xeedc98);
			cl=0x482816;
		}
		if(e.getSource()==col4) {
			
			color1=new Color(0x4b5198);mcl1=new Color(0x8599AB);mcl3=new Color(0x4D549E);mcl5=new Color(0x4b5199);
			color2=new Color(0xa0b7cb);mcl2=new Color(0x404580);mcl4=new Color(0xA3BBD0);mcl6=new Color(0xa0b7cc);
			cl=0x1F2352;
		}
		
		
		for (int i = 0 ; i < 9 ; i++) {
			if((i)%2!=0) {
				smallblocks[i].setBackground(color2);
				helpercolor();
			}
			if((i)%2==0) {
				smallblocks[i].setBackground(color1);
				helpercolor();
			}
			}
		
		
		if(e.getSource()==movcol) {
			helpercolor();
		}
		
		if(e.getSource()==timerr) {
			if(timerr.isSelected()) {
				timer.setVisible(true);
				time=60;
			}
			else {
				timer.setVisible(false);
				time=61;
			} 
		}
			
			
			
			
			
			
		if(e.getSource()==timer) {
			switch(String.valueOf(timer.getSelectedItem())) {
			case "60 min" : time=60;break;
			case "30 min" : time=30;break;
			case "15 min" : time=15;break;
			case "10 min" : time=10;break;
			case "5 min" : time=5;break;
			case "3 min" : time=3;break;
			default :time=60;
			}
		}
		if(e.getSource()==startbut) {
			
			 new Chessboard();
			//pieces pieces =new pieces();
			preframe.dispose();
		}
		smallboard.repaint();
	}

}
