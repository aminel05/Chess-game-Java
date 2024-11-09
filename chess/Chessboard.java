package chess;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Chessboard implements MouseListener{
	
	static JFrame frame;
	static JPanel[][] blocks;static JLabel[][] wpieces,bpieces;
	static JPanel dashboard,chessboard;
	String winner ="";
	JLabel output,wtimer,btimer;
	int[] sec= {0,0},min= {MAIN.time,MAIN.time};
	boolean movehelper=MAIN.movehelper,resttime=true,starttimer=false,wpawnto=false,bpawnto=false;
	int pawntox=-1,pawntoy=-1;
	Color[] cl4 = new Color[4];
	Timer timer ;	
	ImageIcon bpawnicon = new ImageIcon( "src\\chess\\bpawn.png");
	ImageIcon brookicon = new ImageIcon("src\\chess\\brook.png");
	ImageIcon bkhighticon = new ImageIcon("src\\chess\\bkhight.png");
	ImageIcon bbeshopicon = new ImageIcon("src\\chess\\bbeshop.png");
	ImageIcon bquinnicon = new ImageIcon("src\\chess\\bquinn.png");
	ImageIcon bkingicon = new ImageIcon("src\\chess\\bking.png");
	
	ImageIcon wpawnicon = new ImageIcon("src\\chess\\wpawn.png");
	ImageIcon wrookicon = new ImageIcon("src\\chess\\wrook.png");
	ImageIcon wkhighticon = new ImageIcon("src\\chess\\wkhight.png");
	ImageIcon wbeshopicon = new ImageIcon("src\\chess\\wbeshop.png");
	ImageIcon wquinnicon = new ImageIcon("src\\chess\\wquinn.png");
	ImageIcon wkingicon = new ImageIcon("src\\chess\\wking.png");
	                                              
	Chessboard(){
		cl4[0]=MAIN.mcl1;cl4[1]=MAIN.mcl2;cl4[2]=MAIN.mcl3;cl4[3]=MAIN.mcl4;
		///////////////////////set chessboard main frame
		frame = new JFrame();
		frame.setSize(700,800);
		frame.setBackground(Color.black);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setTitle("Chess(by amine)");
		frame.setIconImage(wrookicon.getImage());
		
		dashboard = new JPanel();
		dashboard.setBounds(0,0,700, 75);
		dashboard.setBackground(Color.DARK_GRAY);
		dashboard.setLayout(null);
		frame.add(dashboard);
		
		chessboard = new JPanel();
		chessboard.setBounds(-1,75,687,700);
		chessboard.setBackground(Color.black);
		chessboard.setLayout(new GridLayout(8, 8));
		frame.add(chessboard);
		
		output = new JLabel();
		output.setBounds(200,0,300,75);
		output.setText("Press to start");
		output.setFont(new Font(".",Font.BOLD,35));
		output.setVerticalAlignment(JLabel.CENTER);
		output.setForeground(new Color(0x1C5C39));
		output.setHorizontalAlignment(JLabel.CENTER);
		dashboard.add(output);
		
		//////////////////////set chess board blocks and color
		blocks = new JPanel[8][8];
		for (int i = 0 ; i < 8 ; i++) {
			for (int j = 0 ; j < 8 ; j++) {
				blocks[i][j]= new JPanel();
				blocks[i][j].setBackground(((i+j)%2==0) ?MAIN.color2:MAIN.color1);
				blocks[i][j].addMouseListener(this);
				chessboard.add(blocks[i][j]);
			}
		}
		//////////////////////set chess board pieces
	//white pieces
		wpieces = new JLabel[8][8];
		for (int i = 0 ; i < 8 ; i++) {
			for (int j = 0 ; j < 8 ; j++) {
				
				wpieces[i][j]= new JLabel();
				if (i == 7 && j == 0) {
		            wpieces[i][j].setIcon(wrookicon);
		        } else if (i == 7 && j == 1) {
		            wpieces[i][j].setIcon(wkhighticon);
		        } else if (i == 7 && j == 2) {
		            wpieces[i][j].setIcon(wbeshopicon);
		        } else if (i == 7 && j == 3) {
		            wpieces[i][j].setIcon(wquinnicon);
		        } else if (i == 7 && j == 4) {
		            wpieces[i][j].setIcon(wkingicon);
		        } else if (i == 7 && j == 5) {
		            wpieces[i][j].setIcon(wbeshopicon);
		        } else if (i == 7 && j == 6) {
		            wpieces[i][j].setIcon(wkhighticon);
		        } else if (i == 7 && j == 7) {
		            wpieces[i][j].setIcon(wrookicon);
		        } else if (i == 6) {
		            wpieces[i][j].setIcon(wpawnicon);  
		        }
				
				wpieces[i][j].setVerticalAlignment(JLabel.CENTER);
				wpieces[i][j].setHorizontalAlignment(JLabel.CENTER);
				wpieces[i][j].addMouseListener(this);
				
				blocks[i][j].add(wpieces[i][j],BorderLayout.CENTER);
			}
		}
		//black pieces
				bpieces = new JLabel[8][8];
					
				for (int i = 0 ; i < 8 ; i++) {
					for (int j = 0 ; j < 8 ; j++) {
						
						bpieces[i][j]= new JLabel();
						//bpieces[i][j].setLayout(new BorderLayout());

						if (i == 0 && j == 0) {
				            bpieces[i][j].setIcon(brookicon);
				        } else if (i == 0 && j == 1) {
				            bpieces[i][j].setIcon(bkhighticon);
				        } else if (i == 0 && j == 2) {
				            bpieces[i][j].setIcon(bbeshopicon);
				        } else if (i == 0 && j == 3) {
				            bpieces[i][j].setIcon(bquinnicon);
				        } else if (i == 0 && j == 4) {
				            bpieces[i][j].setIcon(bkingicon);
				        } else if (i == 0 && j == 5) {
				            bpieces[i][j].setIcon(bbeshopicon);
				        } else if (i == 0 && j == 6) {
				            bpieces[i][j].setIcon(bkhighticon);
				        } else if (i == 0 && j == 7) {
				            bpieces[i][j].setIcon(brookicon);
				        } else if (i == 1) {
				            bpieces[i][j].setIcon(bpawnicon);
				        }
						
						bpieces[i][j].setVerticalAlignment(JLabel.CENTER);
						bpieces[i][j].setHorizontalAlignment(JLabel.CENTER);
						bpieces[i][j].addMouseListener(this);
						blocks[i][j].add(bpieces[i][j],BorderLayout.CENTER);
			
					}
				}
				wtimer = new JLabel();
				wtimer.setBounds(25,12,75,50);
				wtimer.setText(min[0]+":"+String.format("%02d", sec[0]));
				wtimer.setFont(new Font(".",Font.BOLD,20));
				wtimer.setHorizontalAlignment(JLabel.CENTER);
				wtimer.setForeground(Color.WHITE);
				wtimer.setVisible(false);
				dashboard.add(wtimer);
				
				btimer = new JLabel();
				btimer.setBounds(585,12,75,50);
				btimer.setText(min[1]+":"+String.format("%02d", sec[1]));
				btimer.setFont(new Font(".",Font.BOLD,20));
				btimer.setHorizontalAlignment(JLabel.CENTER);
				btimer.setForeground(Color.WHITE);
				btimer.setVisible(false);
				dashboard.add(btimer);
		
				timer = new Timer();
				TimerTask  task = new TimerTask() {
					@Override
					public void run() {
						if(MAIN.time<=60 && starttimer && winner.equals("")) {
							if(turn )  {
								if(sec[0]==0) {min[0]--;sec[0]=59;}
								wtimer.setText(min[0]+":"+String.format("%02d", sec[0]));
								wtimer.repaint();
								sec[0]--;
							}
							if(turn==false){
								if(sec[1]==0) {min[1]--;sec[1]=59;}
								btimer.setText(min[1]+":"+String.format("%02d", sec[1]));
								btimer.repaint();
								sec[1]--;
							}
							wtimer.setVisible(true);
							btimer.setVisible(true);
						}
						else if(MAIN.time==61){
							resttime=true;
							timer.cancel();
						}
						else if(min[1]==0||min[0]==0){
							resttime=false;
							timer.cancel();
						}
					}		
				};
				if(winner.equals("")) {
					timer.scheduleAtFixedRate(task, 0, 1000);
				}
				for(int z=0;z<8;z++) {
					wpawnx[z]=6;
					wpawny[z]=z;
					
					bpawnx[z]=1;
					bpawny[z]=z;
					
					twostepw[z]=-1;
					twostepb[z]=-1;
				}
				for(int z=0;z<10;z++) {
					wrookx[z]=-1;wrooky[z]=-1;
					wrookx[0]=7;wrooky[0]=0;
					wrookx[1]=7;wrooky[1]=7;
					
					wkhightx[z]=-1;wkhighty[z]=-1;
					wkhightx[0]=7;wkhighty[0]=1;
					wkhightx[1]=7;wkhighty[1]=6;
					
					wbeshopx[z]=-1;wbeshopy[z]=-1;
					wbeshopx[0]=7;wbeshopy[0]=2;
					wbeshopx[1]=7;wbeshopy[1]=5;
					
					
					brookx[z]=-1;brooky[z]=-1;
					brookx[0]=0;brooky[0]=0;
					brookx[1]=0;brooky[1]=7;
					
					bkhightx[z]=-1;bkhighty[z]=-1;
					bkhightx[0]=0;bkhighty[0]=1;
					bkhightx[1]=0;bkhighty[1]=6;
					
					bbeshopx[z]=-1;bbeshopy[z]=-1;
					bbeshopx[0]=0;bbeshopy[0]=2;
					bbeshopx[1]=0;bbeshopy[1]=5;
				}
				for(int z=0;z<9;z++) {
					wquinnx[z]=-1;wquinny[z]=-1;
					wquinnx[0]=7;wquinny[0]=3;
					
					bquinnx[z]=-1;bquinny[z]=-1;
					bquinnx[0]=0;bquinny[0]=3;
				}
				
				
		frame.setVisible(true);
	}
	
	int pair =0;
	public void movecol(int i, int j,boolean tf) {
		if(tf) {
	    if (MAIN.movehelper) {
	        blocks[i][j].setBackground(((i + j) % 2 == 0) ? MAIN.mcl1 : MAIN.mcl2);
	    }
	    else  {
	        blocks[i][j].setBackground(((i + j) % 2 == 0) ? MAIN.mcl4 : MAIN.mcl3);
	    }}
		else {
		        blocks[i][j].setBackground(((i + j) % 2 == 0) ? MAIN.mcl6 : MAIN.mcl5);
		    }
	}
	
	int colr=MAIN.cl;
	public void boardcolor() {
		for (int i = 0 ; i < 8 ; i++) {
			for (int j = 0 ; j < 8 ; j++) {
					blocks[i][j].setBackground(((i+j)%2==0) ?MAIN.color2:MAIN.color1);		
			}
		}
		pmove();

	}
	int[] twostepw=new int[8],twostepb=new int[8];
	int wpeatx=-1,wpeaty=-1,bpeatx=-1,bpeaty=-1;
	int[] wrookx = new int[10],wrooky = new int[10] ,wpawnx = new int[8],wpawny = new int[8],wbeshopx = new int[10],wbeshopy = new int[10],
			wkhightx = new int[10],wkhighty = new int[10],wquinnx = new int[9],wquinny = new int[9];
	int[] brookx = new int[10],brooky = new int[10] ,bpawnx = new int[8],bpawny = new int[8],bbeshopx = new int[10],bbeshopy = new int[10],
			bkhightx = new int[10],bkhighty = new int[10],bquinnx = new int[9],bquinny = new int[9];
	
	int ppt,rt,pt,kt,bt,qt,rcount=2;
	int wkingx=7,wkingy=4,bkingx=0,bkingy=4;
	boolean turn=true,wchek=false,bchek=false;
	String pieceturn="null";
	
	public void move_piece(int i ,int j ,int x ,int y ,JLabel[][] pieces) {
		pieces[i][j].setIcon(pieces[x][y].getIcon());
		pieces[x][y].setIcon(null);boardcolor();
		x=i;
		y=j;
		turn=false;
		pieceturn="null";
		boardcolor();
	}
	public void move_piece(int i ,int j ,int x ,int y ,JLabel[][] wpieces,JLabel[][] bpieces) {
		bpieces[i][j].setIcon(null);boardcolor();
		wpieces[i][j].setIcon(wpieces[x][y].getIcon());
		wpieces[x][y].setIcon(null);boardcolor();
		x=i;
		y=j;
		turn=false;
		pieceturn="null";
		boardcolor();
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		
		if(winner.equals("") && (min[0]>=0||min[1]>=0)) {
			starttimer=true;
			
			
			if(wpawnto==true) {
				String pawto;
				
				wpawnto=false;
				pawnupgrade pawnupgrade = new pawnupgrade();
				pawto=pawnupgrade.getpawnto();
				switch(pawto) {
				case "rook":rt=2+ppt;
				wrookx[rt]=wpawnx[ppt];wpawnx[ppt]=-1;
				wrooky[rt]=wpawny[ppt];wpawny[ppt]=-1;
				break;
				case "khight":kt=2+ppt;
				wkhightx[kt]=wpawnx[ppt];wpawnx[ppt]=-1;
				wkhighty[kt]=wpawny[ppt];wpawny[ppt]=-1;
				break;
				case "beshop":bt=2+ppt;
				wbeshopx[bt]=wpawnx[ppt];wpawnx[ppt]=-1;
				wbeshopy[bt]=wpawny[ppt];wpawny[ppt]=-1;
				break;
				case "quinn":qt=1+ppt;
				wquinnx[qt]=wpawnx[ppt];wpawnx[ppt]=-1;
				wquinny[qt]=wpawny[ppt];wpawny[ppt]=-1;
				break;
				
				}
			}
			else if(bpawnto==true) {
					String pawto;
					bpawnto=false;
					pawnupgrade pawnupgrade = new pawnupgrade();
					pawto=pawnupgrade.getpawnto();
					switch(pawto) {
					case "rook":rt=2+ppt;
					brookx[rt]=bpawnx[ppt];bpawnx[ppt]=-1;
					brooky[rt]=bpawny[ppt];bpawny[ppt]=-1;
					break;
					case "khight":kt=2+ppt;
					bkhightx[kt]=bpawnx[ppt];bpawnx[ppt]=-1;
					bkhighty[kt]=bpawny[ppt];bpawny[ppt]=-1;
					break;
					case "beshop":bt=2+ppt;
					bbeshopx[bt]=bpawnx[ppt];bpawnx[ppt]=-1;
					bbeshopy[bt]=bpawny[ppt];bpawny[ppt]=-1;
					break;
					case "quinn":qt=1+ppt;
					bquinnx[qt]=bpawnx[ppt];bpawnx[ppt]=-1;
					bquinny[qt]=bpawny[ppt];bpawny[ppt]=-1;
					break;
					
					}
			}

		if(turn )  {

			for (int i = 0 ; i < 8 ; i++) {
				for (int j = 0 ; j < 8 ; j++) {
					for(int z=0;z<8;z++) {
						//white pawn get cordinates
					if(wpawnx[z]!=-1 && wpawny[z]!=-1 &&  e.getSource()==wpieces[i][j] && i==wpawnx[z] && j==wpawny[z] && wpieces[i][j].getIcon()!=null) {
						boardcolor();
						pt=z;
						if(i==6 && wpieces[5][j].getIcon()==null && bpieces[5][j].getIcon()==null && wpieces[4][j].getIcon()==null && bpieces[4][j].getIcon()==null) {
							
							pieceturn="pawn";
							movecol(wpawnx[pt]-2,wpawny[pt],true);
							blocks[wpawnx[pt]][wpawny[pt]].setBackground(new Color(colr));
						}
						if(i<7) {
							
							pieceturn="pawn";
							if(j+1<8 && bpieces[wpawnx[pt]-1][j+1].getIcon()!=null ) { movecol((wpawnx[pt]-1),j+1,true);
							}
							if(j-1>=0 && bpieces[wpawnx[pt]-1][j-1].getIcon()!=null) { movecol((wpawnx[pt]-1),j-1,true);
							}
							if(wpawnx[pt]-1>=0 && wpieces[wpawnx[pt]-1][j].getIcon()==null && bpieces[wpawnx[pt]-1][j].getIcon()==null) { movecol(wpawnx[pt]-1,wpawny[pt],true);
							}
							for(int k=-1;k<2;k+=2) {
							if(pt-1>=0 && pt+1<8 && twostepw[pt+k]!=-1 && wpawnx[pt]==twostepw[pt+k]+1 ){
								movecol(twostepw[pt+k],wpawny[pt]+k,true );
							}}
							blocks[wpawnx[pt]][wpawny[pt]].setBackground(new Color(colr));
						}
						
						break;
					}
					}	
				}
			}
			//white pawn move
			for (int i = 0 ; i < 8 ; i++) {
				for (int j = 0 ; j < 8 ; j++) {
					for(int l=0;l<4;l++) {
					//move pawn
					if(e.getSource()==blocks[i][j] && blocks[i][j].getBackground()==cl4[l]  && pieceturn.equals("pawn") && bpieces[i][j].getIcon()==null) {
						
								wpieces[i][j].setIcon(wpieces[wpawnx[pt]][wpawny[pt]].getIcon());
								wpieces[wpawnx[pt]][wpawny[pt]].setIcon(null);boardcolor();
								if(i==0) {
									 new pawnupgrade(turn,wpieces,bpieces,i,j);
									wpawnto=true;
									ppt=pt;
									}
								if(i==wpawnx[pt]-2 && j==wpawny[pt]) {
									twostepb[pt]=5;
								}
								else {
									twostepb[pt]=-1;
								}
								for(int k=-1;k<2;k+=2) {
									if(pt+k<8 && pt+k>=0 && i==twostepw[pt+k]) {
										bpieces[twostepw[pt+k]+1][j].setIcon(null);
									}
								}
								
								turn=false;
								pieceturn="";
								boardcolor();
								wpawnx[pt]=i;
								wpawny[pt]=j;
								break;
						}
					
					//capture with pawn
						if(e.getSource()==bpieces[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("pawn")) {
							bpieces[i][j].setIcon(null);boardcolor();
							wpieces[i][j].setIcon(wpieces[wpawnx[pt]][wpawny[pt]].getIcon());
							wpieces[wpawnx[pt]][wpawny[pt]].setIcon(null);boardcolor();
							if(i==0) {
								 new pawnupgrade(turn,wpieces,bpieces,i,j);
								wpawnto=true;
								ppt=pt;
							}
							wpawnx[pt]=i;
							wpawny[pt]=j;
							turn=false;
							boardcolor();
							break;
							
						}
				}
				}
			}
		}
		//black pawn move///////////////////////////////////////////////////////////
		
		if(turn==false  ){
			
			//black pawn get cordinates
			for (int i = 0 ; i < 8 ; i++) {
				for (int j = 0 ; j < 8 ; j++) {
					for (int z = 0 ; z < 8 ; z++) {
						
					if(bpawnx[z]!=-1 && bpawny[z]!=-1 && e.getSource()==bpieces[i][j] && i==bpawnx[z] && j==bpawny[z] &&  bpieces[i][j].getIcon()!=null){
						boardcolor();
						pt=z;
						if(i==1 && bpieces[2][j].getIcon()==null && wpieces[2][j].getIcon()==null && bpieces[3][j].getIcon()==null && wpieces[3][j].getIcon()==null) {
							pieceturn="pawn";
							movecol(bpawnx[pt]+2,bpawny[pt],true);
							blocks[bpawnx[pt]][bpawny[pt]].setBackground(new Color(colr));
						}
						if(i>0 ) {
							
							pieceturn="pawn";
							if(j+1<8 && wpieces[bpawnx[pt]+1][j+1].getIcon()!=null ) {
								movecol((bpawnx[pt]+1),j+1,true);
							}
							if(j-1>=0 && wpieces[bpawnx[pt]+1][j-1].getIcon()!=null) {
								movecol((bpawnx[pt]+1),j-1,true);
							}
							if(bpawnx[pt]+1<8 && bpieces[bpawnx[pt]+1][j].getIcon()==null && wpieces[bpawnx[pt]+1][j].getIcon()==null) {
								movecol(bpawnx[pt]+1,bpawny[pt],true);
							}
							for(int k=-1;k<2;k+=2) {
							if(pt-1>=0 && pt+1<8 && twostepb[pt+k]!=-1 && bpawnx[pt]==twostepb[pt+k]-1 ){
								movecol(twostepb[pt+k],bpawny[pt]+k,true );
							}
							}
							blocks[bpawnx[pt]][bpawny[pt]].setBackground(new Color(colr));
						}
						
						break;
					}
					}
				}
			}
			
			for (int i = 0 ; i < 8 ; i++) {
				for (int j = 0 ; j < 8 ; j++) {
					for(int l=0;l<4;l++) {
					//pawn move
					if(e.getSource()==blocks[i][j] && blocks[i][j].getBackground()==cl4[l]&&pieceturn.equals("pawn") && wpieces[i][j].getIcon()==null) {
						bpieces[i][j].setIcon(bpieces[bpawnx[pt]][bpawny[pt]].getIcon());
						bpieces[bpawnx[pt]][bpawny[pt]].setIcon(null);boardcolor();
						if(i==7) {
							 new pawnupgrade(turn,wpieces,bpieces,i,j);
							bpawnto=true;
							ppt=pt;
							}
						if(i==bpawnx[pt]+2 && j==bpawny[pt]) {
							twostepw[pt]=2;
						}
						else {
							twostepw[pt]=-1;
						}
						for(int k=-1;k<2;k+=2) {
							if(pt+k<8 && pt+k >=0 && i==twostepb[pt+k]) {
								wpieces[twostepb[pt+k]-1][j].setIcon(null);
							}
						}
						bpawnx[pt]=i;
						bpawny[pt]=j;
						turn=true;
						pieceturn="";
						boardcolor();
						break;
					}
					//capture with pawn

						if(e.getSource()==wpieces[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("pawn")) {
							wpieces[j][j].setIcon(null);boardcolor();
							bpieces[i][j].setIcon(bpieces[bpawnx[pt]][bpawny[pt]].getIcon());
							bpieces[bpawnx[pt]][bpawny[pt]].setIcon(null);boardcolor();
							
							if(i==7) {
								 new pawnupgrade(turn,wpieces,bpieces,i,j);
								bpawnto=true;
								ppt=pt;
							}
							bpawnx[pt]=i;
							bpawny[pt]=j;
							wpieces[bpawnx[pt]][bpawny[pt]].setIcon(null);
							turn=true;
							boardcolor();
							break;
							
						}
					
				}
				}
			}

		}	
				//rook moves ////////////////////////////////////////////////////
				
				//white rookcondition//
						//white rook 1
						
				if(turn )  {
					for (int i = 0; i < 8; i++) {
					    for (int j = 0; j < 8; j++) {
					    	for(int z=0 ; z<10;z++) {
					    		if ( e.getSource()==wpieces[i][j] && i==wrookx[z] && j==wrooky[z] && wrookx[z]!=-1 && wrooky[z]!=-1 && wpieces[i][j].getIcon()!=null) {
					    			rt=z;
						    		wrookx[rt]=i;
						    		wrooky[rt]=j;
						    		pieceturn="wrook";
						    		boardcolor();
						    		blocks[wrookx[rt]][wrooky[rt]].setBackground(new Color(colr));
						    		for(int k = 1 ; k<8;k++) {
						    			if ((wrookx[rt]-k)>=0&& wpieces[wrookx[rt]-k][wrooky[rt]].getIcon()==null) {
						    				movecol(wrookx[rt]-k,wrooky[rt],true);
						    				if(bpieces[wrookx[rt]-k][wrooky[rt]].getIcon()==null && (wrookx[rt]-k)>=0) {movecol(wrookx[rt]-k,wrooky[rt],true);}else{break;}
						    			}
						    			else {break;}}
						    		
						    		for(int k = 1 ; k<8;k++) {
						    			if ((wrookx[rt]+k)<8&& wpieces[wrookx[rt]+k][wrooky[rt]].getIcon()==null && bpieces[wrookx[rt]+k-1][wrooky[rt]].getIcon()==null) {
						    				movecol(wrookx[rt]+k,wrooky[rt],true);	
						    			}
						    			else {break;}}
					    	
					    	
					    		///////
					    		for(int k = 1 ; k<8;k++) {
					    			if ((wrooky[rt]-k)>=0&& wpieces[wrookx[rt]][wrooky[rt]-k].getIcon()==null) {
					    				movecol(wrookx[rt],wrooky[rt]-k,true);
					    				if(bpieces[wrookx[rt]][wrooky[rt]-k].getIcon()==null && (wrooky[rt]-k)>=0) {movecol(wrookx[rt],wrooky[rt]-k,true);}else{break;}
					    			}
					    			else {break;}}
					    		
					    		for(int k = 1 ; k<8;k++) {
					    			if ((wrooky[rt]+k)<8 && wpieces[wrookx[rt]][wrooky[rt]+k].getIcon()==null && bpieces[wrookx[rt]][wrooky[rt]+k-1].getIcon()==null) {
					    				movecol(wrookx[rt],wrooky[rt]+k,true);	
					    			}
					    			else {break;}}
					    		
					    		
					    		}
					    	}
					//if you klicked a valid rook movement it will get the valid movment block
					for(int l =0;l<4;l++) {
					if( wrookx[rt] !=-1 && wrooky[rt]!=-1 &&  e.getSource()==blocks[i][j] && pieceturn.equals("wrook")  && wpieces[i][j].getIcon()==null&& bpieces[i][j].getIcon()==null && blocks[i][j].getBackground()==cl4[l]  ) {
						move_piece(i,j,wrookx[rt],wrooky[rt],wpieces);
						wrookx[rt]=i;
			    		wrooky[rt]=j;
					}
					if( wrookx[rt] !=-1 && wrooky[rt]!=-1 && pieceturn.equals("wrook")&& wpieces[i][j].getIcon()==null && blocks[i][j].getBackground()==cl4[l]) {
						if( e.getSource()==bpieces[i][j]  && wpieces[i][j].getIcon()==null ) {
							bpieces[i][j].setIcon(null);boardcolor();
							wpieces[i][j].setIcon(wpieces[wrookx[rt]][wrooky[rt]].getIcon());
							wpieces[wrookx[rt]][wrooky[rt]].setIcon(null);boardcolor();
							wrookx[rt]=i;
				    		wrooky[rt]=j;
							turn=false;
							pieceturn="null";
							boardcolor();
						}
						
					}}
				}
					}
				}	
						
			///////////////////////////////////////////////////black rook
						//black rookcondition//
						
						if(turn==false  ){
							for (int i = 0; i < 8; i++) {
							    for (int j = 0; j < 8; j++) {
							    	for (int z = 0; z < 10; z++) {
							    	if (brookx[z]!=-1 && brooky[z]!=-1 && e.getSource()==bpieces[i][j] && i==brookx[z] && j==brooky[z] && bpieces[i][j].getIcon()!=null ) {
							    		rt=z;
							    		brookx[rt]=i;
							    		brooky[rt]=j;
							    		pieceturn="brook";
							    		boardcolor();
							    		blocks[brookx[rt]][brooky[rt]].setBackground(new Color(colr));
							    		for(int k = 1 ; k<8;k++) {
							    			if ((brookx[rt]-k)>=0&& bpieces[brookx[rt]-k][brooky[rt]].getIcon()==null) {
							    				movecol(brookx[rt]-k,brooky[rt],true);
							    				if(wpieces[brookx[rt]-k][brooky[rt]].getIcon()==null && (brookx[rt]-k)>=0) {movecol(brookx[rt]-k,brooky[rt],true);}else{break;}
							    			}
							    			else {break;}}
							    		
							    		for(int k = 1 ; k<8;k++) {
							    			if ((brookx[rt]+k)<8&& bpieces[brookx[rt]+k][brooky[rt]].getIcon()==null && wpieces[brookx[rt]+k-1][brooky[rt]].getIcon()==null) {
							    				movecol(brookx[rt]+k,brooky[rt],true);	
							    			}
							    			else {break;}}
							    		///////
							    		for(int k = 1 ; k<8;k++) {
							    			if ((brooky[rt]-k)>=0&& bpieces[brookx[rt]][brooky[rt]-k].getIcon()==null) {
							    				movecol(brookx[rt],brooky[rt]-k,true);
							    				if(wpieces[brookx[rt]][brooky[rt]-k].getIcon()==null && (brooky[rt]-k)>=0) {movecol(brookx[rt],brooky[rt]-k,true);}else{break;}
							    			}
							    			else {break;}}
							    		
							    		for(int k = 1 ; k<8;k++) {
							    			if ((brooky[rt]+k)<8&& bpieces[brookx[rt]][brooky[rt]+k].getIcon()==null && wpieces[brookx[rt]][brooky[rt]+k-1].getIcon()==null) {
							    				movecol(brookx[rt],brooky[rt]+k,true);	
							    			}
							    			else {break;}}
							    		break;
							    	}	
							    	}
							//if you klicked a valid rook movement it will get the valid movment block
							
							for(int l=0;l<4;l++) {
							if( brookx[rt] !=-1 && brooky[rt]!=-1 && blocks[i][j].getBackground()==cl4[l] && e.getSource()==blocks[i][j] && pieceturn.equals("brook") && bpieces[i][j].getIcon()==null && wpieces[i][j].getIcon()==null) {
								bpieces[i][j].setIcon(bpieces[brookx[rt]][brooky[rt]].getIcon());
								bpieces[brookx[rt]][brooky[rt]].setIcon(null);boardcolor();
								brookx[rt]=i;
					    		brooky[rt]=j;
								turn=true;
								pieceturn="null";
								boardcolor();
							}
							if( brookx[rt] !=-1 && brooky[rt]!=-1 && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("brook")&& bpieces[i][j].getIcon()==null) {
								if( e.getSource()==wpieces[i][j]  && bpieces[i][j].getIcon()==null  ) {
									wpieces[i][j].setIcon(null);boardcolor();
									bpieces[i][j].setIcon(bpieces[brookx[rt]][brooky[rt]].getIcon());
									bpieces[brookx[rt]][brooky[rt]].setIcon(null);boardcolor();
									brookx[rt]=i;
						    		brooky[rt]=j;
									turn=true;
									pieceturn="null";
									boardcolor();
								}
								
							}
						}
							    }
							}
						
			}		
/////////khight moves////////////////////////////////////////////////////////////////////////
						//w khight 1
				
						if(turn )  {
							for (int i = 0; i < 8; i++) {
							    for (int j = 0; j < 8; j++) {
							    	for (int z = 0; z < 10; z++) {
							    	if (wkhightx[z]!=-1 && wkhighty[z]!=-1 && turn==true && e.getSource()==wpieces[i][j] && i==wkhightx[z] && j==wkhighty[z] && wpieces[i][j].getIcon()!=null ) {
							    		kt=z;
							    		pieceturn="wkhight";
							    		boardcolor();
							    		blocks[wkhightx[kt]][wkhighty[kt]].setBackground(new Color(colr));
							    		if(wkhightx[kt]-2>=0 && wkhighty[kt]+1<8 && wpieces[wkhightx[kt]-2][wkhighty[kt]+1].getIcon()==null) {
											movecol(wkhightx[kt]-2,wkhighty[kt]+1,true);}
							    		if(wkhightx[kt]-2>=0 && wkhighty[kt]-1>=0 && wpieces[wkhightx[kt]-2][wkhighty[kt]-1].getIcon()==null) {
											movecol(wkhightx[kt]-2,wkhighty[kt]-1,true);}
							    		if(wkhightx[kt]+2<8 && wkhighty[kt]+1<8 && wpieces[wkhightx[kt]+2][wkhighty[kt]+1].getIcon()==null) {
											movecol(wkhightx[kt]+2,wkhighty[kt]+1,true);}
							    		if(wkhightx[kt]+2<8 && wkhighty[kt]-1>=0 && wpieces[wkhightx[kt]+2][wkhighty[kt]-1].getIcon()==null) {
											movecol(wkhightx[kt]+2,wkhighty[kt]-1,true);}
							    		if(wkhightx[kt]-1>=0 && wkhighty[kt]+2<8 && wpieces[wkhightx[kt]-1][wkhighty[kt]+2].getIcon()==null) {
											movecol(wkhightx[kt]-1,wkhighty[kt]+2,true);}
										if(wkhightx[kt]-1>=0 && wkhighty[kt]-2>=0 && wpieces[wkhightx[kt]-1][wkhighty[kt]-2].getIcon()==null) {
											movecol(wkhightx[kt]-1,wkhighty[kt]-2,true);}
										if(wkhightx[kt]+1<8 && wkhighty[kt]+2<8 && wpieces[wkhightx[kt]+1][wkhighty[kt]+2].getIcon()==null) {
											movecol(wkhightx[kt]+1,wkhighty[kt]+2,true);}
										if(wkhightx[kt]+1<8 && wkhighty[kt]-2>=0 && wpieces[wkhightx[kt]+1][wkhighty[kt]-2].getIcon()==null) {
											movecol(wkhightx[kt]+1,wkhighty[kt]-2,true);}
							    		break;
							    	}	
							    	}
								
							    	for(int l=0;l<4;l++){
									if(e.getSource()==blocks[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("wkhight") ) {
										wpieces[i][j].setIcon(wpieces[wkhightx[kt]][wkhighty[kt]].getIcon());
										wpieces[wkhightx[kt]][wkhighty[kt]].setIcon(null);boardcolor();
										wkhightx[kt]=i;
										wkhighty[kt]=j;
										turn=false;
										pieceturn="null";
										boardcolor();
										break;
									}
									
									else if (e.getSource()==bpieces[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("wkhight") ) {
										bpieces[i][j].setIcon(null);boardcolor();
										wpieces[i][j].setIcon(wpieces[wkhightx[kt]][wkhighty[kt]].getIcon());
										wpieces[wkhightx[kt]][wkhighty[kt]].setIcon(null);boardcolor();
										wkhightx[kt]=i;
										wkhighty[kt]=j;
										turn=false;										
										pieceturn="null";
										boardcolor();
										break;
									}
								}
							    }
							    
							}
						}
							
				//black khight ////////////////////////////////////////
								
								if(turn==false  ){
									for (int i = 0; i < 8; i++) {
									    for (int j = 0; j < 8; j++) {
									    	for (int z = 0; z < 10; z++) {
									    	if (bkhightx[z]!=-1 && bkhighty[z]!=-1 && e.getSource()==bpieces[i][j] && i==bkhightx[z] && j==bkhighty[z]  && bpieces[i][j].getIcon()!=null) {
									    		kt=z;
									    		pieceturn="bkhight";
									    		boardcolor();
									    		blocks[bkhightx[kt]][bkhighty[kt]].setBackground(new Color(colr));
									    		if(bkhightx[kt]-2>=0 && bkhighty[kt]+1<8 && bpieces[bkhightx[kt]-2][bkhighty[kt]+1].getIcon()==null) {
													movecol(bkhightx[kt]-2,bkhighty[kt]+1,true);}
									    		if(bkhightx[kt]-2>=0 && bkhighty[kt]-1>=0 && bpieces[bkhightx[kt]-2][bkhighty[kt]-1].getIcon()==null) {
													movecol(bkhightx[kt]-2,bkhighty[kt]-1,true);}
									    		if(bkhightx[kt]+2<8 && bkhighty[kt]+1<8 && bpieces[bkhightx[kt]+2][bkhighty[kt]+1].getIcon()==null) {
													movecol(bkhightx[kt]+2,bkhighty[kt]+1,true);}
									    		if(bkhightx[kt]+2<8 && bkhighty[kt]-1>=0 && bpieces[bkhightx[kt]+2][bkhighty[kt]-1].getIcon()==null) {
													movecol(bkhightx[kt]+2,bkhighty[kt]-1,true);}
									    		if(bkhightx[kt]-1>=0 && bkhighty[kt]+2<8 && bpieces[bkhightx[kt]-1][bkhighty[kt]+2].getIcon()==null) {
													movecol(bkhightx[kt]-1,bkhighty[kt]+2,true);}
												if(bkhightx[kt]-1>=0 && bkhighty[kt]-2>=0 && bpieces[bkhightx[kt]-1][bkhighty[kt]-2].getIcon()==null) {
													movecol(bkhightx[kt]-1,bkhighty[kt]-2,true);}
												if(bkhightx[kt]+1<8 && bkhighty[kt]+2<8 && bpieces[bkhightx[kt]+1][bkhighty[kt]+2].getIcon()==null) {
													movecol(bkhightx[kt]+1,bkhighty[kt]+2,true);}
												if(bkhightx[kt]+1<8 && bkhighty[kt]-2>=0 && bpieces[bkhightx[kt]+1][bkhighty[kt]-2].getIcon()==null) {
													movecol(bkhightx[kt]+1,bkhighty[kt]-2,true);}
									    		break;
									    	}	
									    	}		
									    	for(int l=0;l<4;l++) {
											if(e.getSource()==blocks[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("bkhight") ) {
												bpieces[i][j].setIcon(bpieces[bkhightx[kt]][bkhighty[kt]].getIcon());
												bpieces[bkhightx[kt]][bkhighty[kt]].setIcon(null);boardcolor();
												bkhightx[kt]=i;
												bkhighty[kt]=j;
												turn=true;
												pieceturn="null";
												boardcolor();
												break;
											}
											
											else if (e.getSource()==wpieces[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("bkhight") ) {
												wpieces[i][j].setIcon(null);boardcolor();
												bpieces[i][j].setIcon(bpieces[bkhightx[kt]][bkhighty[kt]].getIcon());
												bpieces[bkhightx[kt]][bkhighty[kt]].setIcon(null);boardcolor();
												bkhightx[kt]=i;
												bkhighty[kt]=j;
												turn=true;										
												pieceturn="null";
												boardcolor();
												break;
											}
									    	}
										}
									}
								}
				//beshop moves
			//white beshop 1
				
			if(turn )  {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						for (int z = 0; z < 10; z++) {
						if (wbeshopx[z]!=-1 && wbeshopy[z]!=-1 && e.getSource()==wpieces[i][j] && i==wbeshopx[z] && j==wbeshopy[z] && wpieces[i][j].getIcon()!=null ) {
							bt=z;
							pieceturn="wbeshop";
							boardcolor();
							blocks[wbeshopx[bt]][wbeshopy[bt]].setBackground(new Color(colr));
							for( int k = 1 ; k<8;k++) {
								if (wbeshopx[bt]-k>=0 && wbeshopy[bt]+k<8 && wpieces[wbeshopx[bt]-k][wbeshopy[bt]+k].getIcon()==null) {
									movecol(wbeshopx[bt]-k,wbeshopy[bt]+k,true);
									if(bpieces[wbeshopx[bt]-k][wbeshopy[bt]+k].getIcon()==null) {movecol(wbeshopx[bt]-k,wbeshopy[bt]+k,true);}else{break;}
									}
								else {break;}}
							for( int k = 1 ; k<8;k++) {
								if (wbeshopx[bt]-k>=0 && wbeshopy[bt]-k>=0 && wpieces[wbeshopx[bt]-k][wbeshopy[bt]-k].getIcon()==null) {
									movecol(wbeshopx[bt]-k,wbeshopy[bt]-k,true);
									if(bpieces[wbeshopx[bt]-k][wbeshopy[bt]-k].getIcon()==null) {movecol(wbeshopx[bt]-k,wbeshopy[bt]-k,true);}else{break;}
									}
								else {break;}}
							//
							for( int k = 1 ; k<8;k++) {
								if (wbeshopx[bt]+k<8 && wbeshopy[bt]+k<8 && wpieces[wbeshopx[bt]+k][wbeshopy[bt]+k].getIcon()==null ) {
									movecol(wbeshopx[bt]+k,wbeshopy[bt]+k,true);
									if(bpieces[wbeshopx[bt]+k][wbeshopy[bt]+k].getIcon()==null) {movecol(wbeshopx[bt]+k,wbeshopy[bt]+k,true);}else{break;}
									}
								else {break;}}
							for( int k = 1 ; k<8;k++) {
								if (wbeshopx[bt]+k<8 && wbeshopy[bt]-k>=0 && wpieces[wbeshopx[bt]+k][wbeshopy[bt]-k].getIcon()==null) {
									movecol(wbeshopx[bt]+k,wbeshopy[bt]-k,true);
									if(bpieces[wbeshopx[bt]+k][wbeshopy[bt]-k].getIcon()==null) {movecol(wbeshopx[bt]+k,wbeshopy[bt]-k,true);}else{break;}
									}
								else {break;}}
							break;
			    	}
						}
						
						for(int l=0;l<4;l++) {
							if(e.getSource()==blocks[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("wbeshop") ) {
								wpieces[i][j].setIcon(wpieces[wbeshopx[bt]][wbeshopy[bt]].getIcon());
								wpieces[wbeshopx[bt]][wbeshopy[bt]].setIcon(null);boardcolor();
								wbeshopx[bt]=i;
								wbeshopy[bt]=j;
								turn=false;
								pieceturn="null";
								boardcolor();
								break;
							}
							
							else if (e.getSource()==bpieces[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("wbeshop") ) {
								bpieces[i][j].setIcon(null);boardcolor();
								wpieces[i][j].setIcon(wpieces[wbeshopx[bt]][wbeshopy[bt]].getIcon());
								wpieces[wbeshopx[bt]][wbeshopy[bt]].setIcon(null);boardcolor();
								wbeshopx[bt]=i;
								wbeshopy[bt]=j;
								turn=false;										
								pieceturn="null";
								boardcolor();
								break;
							}
					    	}
				}
			}
			}
										
			//black beshop 1
			if(turn==false  ){
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						for (int z = 0; z < 10; z++) {
						if (bbeshopx[z]!=-1 && bbeshopy[z]!=-1&& e.getSource()==bpieces[i][j] && i==bbeshopx[z] && j==bbeshopy[z] && bpieces[i][j].getIcon()!=null ) {
							bt=z;
							pieceturn="bbeshop";
							boardcolor();
							blocks[bbeshopx[bt]][bbeshopy[bt]].setBackground(new Color(colr));
							for( int k = 1 ; k<8;k++) {
								if (bbeshopx[bt]-k>=0 && bbeshopy[bt]+k<8 && bpieces[bbeshopx[bt]-k][bbeshopy[bt]+k].getIcon()==null) {
									movecol(bbeshopx[bt]-k,bbeshopy[bt]+k,true);
									if(bbeshopx[bt]-k-1>=0 && bbeshopy[bt]+k+1<8 &&wpieces[bbeshopx[bt]-k][bbeshopy[bt]+k].getIcon()==null) {movecol(bbeshopx[bt]-k-1,bbeshopy[bt]+k+1,true);}else{break;}
									}
								else {break;}}
							for( int k = 1 ; k<8;k++) {
								if (bbeshopx[bt]-k>=0 && bbeshopy[bt]-k>=0 && bpieces[bbeshopx[bt]-k][bbeshopy[bt]-k].getIcon()==null) {
									movecol(bbeshopx[bt]-k,bbeshopy[bt]-k,true);
						if(wpieces[bbeshopx[bt]-k][bbeshopy[bt]-k].getIcon()==null) {movecol(bbeshopx[bt]-k,bbeshopy[bt]-k,true);}else{break;}
									}
								else {break;}}
							//
							for( int k = 1 ; k<8;k++) {
								if (bbeshopx[bt]+k<8 && bbeshopy[bt]+k<8 && bpieces[bbeshopx[bt]+k][bbeshopy[bt]+k].getIcon()==null) {
									movecol(bbeshopx[bt]+k,bbeshopy[bt]+k,true);
									if(wpieces[bbeshopx[bt]+k][bbeshopy[bt]+k].getIcon()==null) {movecol(bbeshopx[bt]+k,bbeshopy[bt]+k,true);}else{break;}
									}
								else {break;}}
							for( int k = 1 ; k<8;k++) {
								if (bbeshopx[bt]+k<8 && bbeshopy[bt]-k>=0 && bpieces[bbeshopx[bt]+k][bbeshopy[bt]-k].getIcon()==null) {
									movecol(bbeshopx[bt]+k,bbeshopy[bt]-k,true);
									if(wpieces[bbeshopx[bt]+k][bbeshopy[bt]-k].getIcon()==null) {movecol(bbeshopx[bt]+k,bbeshopy[bt]-k,true);}else{break;}
									}
								else {break;}}
							break;
			    	}
						}
						
						for(int l=0;l<4;l++) {
							if(e.getSource()==blocks[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("bbeshop") ) {
								bpieces[i][j].setIcon(bpieces[bbeshopx[bt]][bbeshopy[bt]].getIcon());
								bpieces[bbeshopx[bt]][bbeshopy[bt]].setIcon(null);boardcolor();
								bbeshopx[bt]=i;
								bbeshopy[bt]=j;
								turn=true;
								pieceturn="null";
								boardcolor();
								break;
							}
							
							else if (e.getSource()==wpieces[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("bbeshop") ) {
								wpieces[i][j].setIcon(null);boardcolor();
								bpieces[i][j].setIcon(bpieces[bbeshopx[bt]][bbeshopy[bt]].getIcon());
								bpieces[bbeshopx[bt]][bbeshopy[bt]].setIcon(null);boardcolor();
								bbeshopx[bt]=i;
								bbeshopy[bt]=j;
								turn=true;										
								pieceturn="null";
								boardcolor();
								break;
							}
					    	}
				}
			}
			}
			//quin moves
			//white quin 
			if(turn )  {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						for (int z = 0; z < 9; z++) {
						if (wquinnx[z]!=-1 && wquinny[z]!=-1 && e.getSource()==wpieces[i][j] && i==wquinnx[z] && j==wquinny[z] && wpieces[i][j].getIcon()!=null ) {
							qt=z;
							pieceturn="wquinn";
							boardcolor();
							blocks[wquinnx[qt]][wquinny[qt]].setBackground(new Color(colr));
							for( int k = 1 ; k<8;k++) {
								if (wquinnx[qt]-k>=0 && wquinny[qt]+k<8 && wpieces[wquinnx[qt]-k][wquinny[qt]+k].getIcon()==null ) {
									movecol(wquinnx[qt]-k,wquinny[qt]+k,true);
									if(bpieces[wquinnx[qt]-k][wquinny[qt]+k].getIcon()==null) {movecol(wquinnx[qt]-k,wquinny[qt]+k,true);}else{break;}
									}
								else {break;}}
							for( int k = 1 ; k<8;k++) {
								if (wquinnx[qt]-k>=0 && wquinny[qt]-k>=0 && wpieces[wquinnx[qt]-k][wquinny[qt]-k].getIcon()==null) {
									movecol(wquinnx[qt]-k,wquinny[qt]-k,true);
									if(bpieces[wquinnx[qt]-k][wquinny[qt]-k].getIcon()==null) {movecol(wquinnx[qt]-k,wquinny[qt]-k,true);}else{break;}
									}
								else {break;}}
							//
							for( int k = 1 ; k<8;k++) {
								if (wquinnx[qt]+k<8 && wquinny[qt]+k<8 && wpieces[wquinnx[qt]+k][wquinny[qt]+k].getIcon()==null) {
									movecol(wquinnx[qt]+k,wquinny[qt]+k,true);
									if(bpieces[wquinnx[qt]+k][wquinny[qt]+k].getIcon()==null) {movecol(wquinnx[qt]+k,wquinny[qt]+k,true);}else{break;}
									}
								else {break;}}
							for( int k = 1 ; k<8;k++) {
								if (wquinnx[qt]+k<8 && wquinny[qt]-k>=0 && wpieces[wquinnx[qt]+k][wquinny[qt]-k].getIcon()==null) {
									movecol(wquinnx[qt]+k,wquinny[qt]-k,true);
									if(bpieces[wquinnx[qt]+k][wquinny[qt]-k].getIcon()==null) {movecol(wquinnx[qt]+k,wquinny[qt]-k,true);}else{break;}
									}
								else {break;}}
							for(int k = 1 ; k<8;k++) {
				    			if ((wquinnx[qt]-k)>=0&& wpieces[wquinnx[qt]-k][wquinny[qt]].getIcon()==null) {
				    				movecol(wquinnx[qt]-k,wquinny[qt],true);
				    				if(bpieces[wquinnx[qt]-k][wquinny[qt]].getIcon()==null && (wquinnx[qt]-k)>=0) {movecol(wquinnx[qt]-k,wquinny[qt],true);}else{break;}
				    			}
				    			else {break;}}
				    		
				    		for(int k = 1 ; k<8;k++) {
				    			if ((wquinnx[qt]+k)<8&& wpieces[wquinnx[qt]+k][wquinny[qt]].getIcon()==null && bpieces[wquinnx[qt]+k-1][wquinny[qt]].getIcon()==null) {
				    				movecol(wquinnx[qt]+k,wquinny[qt],true);	
				    			}
				    			else {break;}}
				    		///////
				    		for(int k = 1 ; k<8;k++) {
				    			if ((wquinny[qt]-k)>=0&& wpieces[wquinnx[qt]][wquinny[qt]-k].getIcon()==null) {
				    				movecol(wquinnx[qt],wquinny[qt]-k,true);
				    				if(bpieces[wquinnx[qt]][wquinny[qt]-k].getIcon()==null && (wquinny[qt]-k)>=0) {movecol(wquinnx[qt],wquinny[qt]-k,true);}else{break;}
				    			}
				    			else {break;}}
				    		
				    		for(int k = 1 ; k<8;k++) {
				    			if ((wquinny[qt]+k)<8&& wpieces[wquinnx[qt]][wquinny[qt]+k].getIcon()==null && bpieces[wquinnx[qt]][wquinny[qt]+k-1].getIcon()==null) {
				    				movecol(wquinnx[qt],wquinny[qt]+k,true);	
				    			}
				    			else {break;}}
							break;
			    	}	
						}
						for(int l=0;l<4;l++) {
							if(e.getSource()==blocks[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("wquinn") ) {
								wpieces[i][j].setIcon(wpieces[wquinnx[qt]][wquinny[qt]].getIcon());
								wpieces[wquinnx[qt]][wquinny[qt]].setIcon(null);boardcolor();
								wquinnx[qt]=i;
								wquinny[qt]=j;
								turn=false;
								pieceturn="null";
								boardcolor();
								break;
							}
							
							else if (e.getSource()==bpieces[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("wquinn") ) {
								bpieces[i][j].setIcon(null);boardcolor();
								wpieces[i][j].setIcon(wpieces[wquinnx[qt]][wquinny[qt]].getIcon());
								wpieces[wquinnx[qt]][wquinny[qt]].setIcon(null);boardcolor();
								wquinnx[qt]=i;
								wquinny[qt]=j;
								turn=false;										
								pieceturn="null";
								boardcolor();
								break;
							}
					    	}
				}
			
			}
			}

			//black quin 			
			if(turn==false  ){
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						for (int z = 0; z < 9; z++) {
						if (bquinnx[z]!=-1 && bquinny[z]!=-1 && turn==false==true && e.getSource()==bpieces[i][j] && i==bquinnx[z] && j==bquinny[z] && bpieces[i][j].getIcon()!=null ) {
							qt=z;
							bquinnx[qt]=i;
							bquinny[qt]=j;
							pieceturn="bquinn";
							boardcolor();
							blocks[bquinnx[qt]][bquinny[qt]].setBackground(new Color(colr));
							for( int k = 1 ; k<8;k++) {
								if (bquinnx[qt]-k>=0 && bquinny[qt]+k<8 && bpieces[bquinnx[qt]-k][bquinny[qt]+k].getIcon()==null) {
									movecol(bquinnx[qt]-k,bquinny[qt]+k,true);
									if(wpieces[bquinnx[qt]-k][bquinny[qt]+k].getIcon()==null) {movecol(bquinnx[qt]-k,bquinny[qt]+k,true);}else{break;}
									}
								else {break;}}
							for( int k = 1 ; k<8;k++) {
								if (bquinnx[qt]-k>=0 && bquinny[qt]-k>=0 && bpieces[bquinnx[qt]-k][bquinny[qt]-k].getIcon()==null) {
									movecol(bquinnx[qt]-k,bquinny[qt]-k,true);
									if(wpieces[bquinnx[qt]-k][bquinny[qt]-k].getIcon()==null) {movecol(bquinnx[qt]-k,bquinny[qt]-k,true);}else{break;}
									}
								else {break;}}
							//
							for( int k = 1 ; k<8;k++) {
								if (bquinnx[qt]+k<8 && bquinny[qt]+k<8 && bpieces[bquinnx[qt]+k][bquinny[qt]+k].getIcon()==null) {
									movecol(bquinnx[qt]+k,bquinny[qt]+k,true);
									if(wpieces[bquinnx[qt]+k][bquinny[qt]+k].getIcon()==null) {movecol(bquinnx[qt]+k,bquinny[qt]+k,true);}else{break;}
									}
								else {break;}}
							for( int k = 1 ; k<8;k++) {
								if (bquinnx[qt]+k<8 && bquinny[qt]-k>=0 && bpieces[bquinnx[qt]+k][bquinny[qt]-k].getIcon()==null) {
									movecol(bquinnx[qt]+k,bquinny[qt]-k,true);
									if(wpieces[bquinnx[qt]+k][bquinny[qt]-k].getIcon()==null) {movecol(bquinnx[qt]+k,bquinny[qt]-k,true);}else{break;}
									}
								else {break;}}
							///////////
				    		for(int k = 1 ; k<8;k++) {
				    			if ((bquinnx[qt]-k)>=0&& bpieces[bquinnx[qt]-k][bquinny[qt]].getIcon()==null) {
				    				movecol(bquinnx[qt]-k,bquinny[qt],true);
				    				if(wpieces[bquinnx[qt]-k][bquinny[qt]].getIcon()==null && (bquinnx[qt]-k)>=0) {movecol(bquinnx[qt]-k,bquinny[qt],true);}else{break;}
				    			}
				    			else {break;}}
				    		
				    		for(int k = 1 ; k<8;k++) {
				    			if ((bquinnx[qt]+k)<8&& bpieces[bquinnx[qt]+k][bquinny[qt]].getIcon()==null && wpieces[bquinnx[qt]+k-1][bquinny[qt]].getIcon()==null) {
				    				movecol(bquinnx[qt]+k,bquinny[qt],true);	
				    			}
				    			else {break;}}
				    		///////
				    		for(int k = 1 ; k<8;k++) {
				    			if ((bquinny[qt]-k)>=0&& bpieces[bquinnx[qt]][bquinny[qt]-k].getIcon()==null) {
				    				movecol(bquinnx[qt],bquinny[qt]-k,true);
				    				if(wpieces[bquinnx[qt]][bquinny[qt]-k].getIcon()==null && (bquinny[qt]-k)>=0) {movecol(bquinnx[qt],bquinny[qt]-k,true);}else{break;}
				    			}
				    			else {break;}}
				    		
				    		for(int k = 1 ; k<8;k++) {
				    			if ((bquinny[qt]+k)<8&& bpieces[bquinnx[qt]][bquinny[qt]+k].getIcon()==null && wpieces[bquinnx[qt]][bquinny[qt]+k-1].getIcon()==null) {
				    				movecol(bquinnx[qt],bquinny[qt]+k,true);	
				    			}
				    			else {break;}}
				    		
							break;
						}
			    	}	
						for(int l=0;l<4;l++) {
							if(e.getSource()==blocks[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("bquinn") ) {
								bpieces[i][j].setIcon(bpieces[bquinnx[qt]][bquinny[qt]].getIcon());
								bpieces[bquinnx[qt]][bquinny[qt]].setIcon(null);boardcolor();
								bquinnx[qt]=i;
								bquinny[qt]=j;
								turn=true;
								pieceturn="null";
								boardcolor();
								break;
							}
							
							else if (e.getSource()==wpieces[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("bquinn") ) {
								wpieces[i][j].setIcon(null);boardcolor();
								bpieces[i][j].setIcon(bpieces[bquinnx[qt]][bquinny[qt]].getIcon());
								bpieces[bquinnx[qt]][bquinny[qt]].setIcon(null);boardcolor();
								bquinnx[qt]=i;
								bquinny[qt]=j;
								turn=true;										
								pieceturn="null";
								boardcolor();
								break;
							}
					    	}
				}
			}
			}
			if(turn)  {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (wkingx!=-1 && wkingy!=-1 && turn==true && e.getSource()==wpieces[i][j] && i==wkingx && j==wkingy && wpieces[i][j].getIcon()!=null ) {
							pieceturn="wking";
							boardcolor();							
							if( wchek==false)blocks[wkingx][wkingy].setBackground(new Color(colr));
							if( wkingx==7&&wkingy==4&&wrookx[1]==7&&wrooky[1]==7&& wpieces[7][5].getIcon()==null&&bpieces[7][5].getIcon()==null &&
									wpieces[7][6].getIcon()==null&&bpieces[7][6].getIcon()==null&& (blocks[0][6].getBackground()!=MAIN.mcl5 &&blocks[0][6].getBackground()!=MAIN.mcl6 )){
								movecol(7,6,true);
							}
							break;
			    	}	
				//white king
				for(int k =0;k<3;k++) {
					for(int h =0;h<3;h++) {
					if(wkingx !=-1 && wkingy!=-1 && (wkingx-1)+k<8 && (wkingx-1)+k>=0 && (wkingy-1)+h<8 && (wkingy-1)+h>=0 && pieceturn.equals("wking")) {
						if(wpieces[(wkingx-1)+k][(wkingy-1)+h].getIcon()==null  && (blocks[(wkingx-1)+k][(wkingy-1)+h].getBackground()!=MAIN.mcl5  && blocks[(wkingx-1)+k][(wkingy-1)+h].getBackground()!=MAIN.mcl6)) {
								movecol((wkingx-1)+k,(wkingy-1)+h,true);
						}
						for(int l=0;l<4;l++) {
							if(e.getSource()==blocks[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("wking") ) {
								wpieces[i][j].setIcon(wpieces[wkingx][wkingy].getIcon());
								wpieces[wkingx][wkingy].setIcon(null);boardcolor();
								if(i==7 && j==6 && wkingx==7 && wkingy==4 ) {
									wpieces[7][5].setIcon(wpieces[7][7].getIcon());
									wpieces[7][7].setIcon(null);boardcolor();
								}
								wkingx=i;
								wkingy=j;
								turn=false;
								pieceturn="null";
								boardcolor();
								break;
							}
							
							else if (e.getSource()==bpieces[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("wking") ) {
								bpieces[i][j].setIcon(null);boardcolor();
								wpieces[i][j].setIcon(wpieces[wkingx][wkingy].getIcon());
								wpieces[wkingx][wkingy].setIcon(null);boardcolor();
								wkingx=i;
								wkingy=j;
								turn=false;										
								pieceturn="null";
								boardcolor();
								break;
							}
					    	}
					
					}
					}
				}	
					}
				}
			}
				
			if(turn==false){
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 8; j++) {
						if (bkingx!=-1 && bkingy!=-1 && turn==false && e.getSource()==bpieces[i][j] && i==bkingx && j==bkingy  && bpieces[i][j].getIcon()!=null) {
							pieceturn="bking";
							boardcolor();
							if(bchek==false)blocks[bkingx][bkingy].setBackground(new Color(colr));
							if( bkingx==0&&bkingy==4&&brookx[1]==0&&brooky[1]==7&& bpieces[0][5].getIcon()==null&&wpieces[0][5].getIcon()==null &&
									bpieces[0][6].getIcon()==null&&wpieces[0][6].getIcon()==null&& (blocks[0][6].getBackground()!=MAIN.mcl5 &&blocks[0][6].getBackground()!=MAIN.mcl6)) {
								movecol(0, 6,true);
							}
							
							break;
			    	}	
			
				for(int k =0;k<3 ;k++) {
					for(int h =0;h<3 ;h++) {
					if((bkingx-1)+k<8 && (bkingx-1)+k>=0 && (bkingy-1)+h<8 && (bkingy-1)+h>=0 && pieceturn.equals("bking") && bkingx !=-1 && bkingy!=-1){
						
						if( bpieces[(bkingx-1)+k][(bkingy-1)+h].getIcon()==null &&( blocks[(bkingx-1)+k][(bkingy-1)+h].getBackground()!=MAIN.mcl5  && blocks[(bkingx-1)+k][(bkingy-1)+h].getBackground()!=MAIN.mcl6)) {
							movecol((bkingx-1)+k,(bkingy-1)+h,true);
						}
					}
						for(int l=0;l<4;l++) {
							if(e.getSource()==blocks[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("bking") ) {
								bpieces[i][j].setIcon(bpieces[bkingx][bkingy].getIcon());
								bpieces[bkingx][bkingy].setIcon(null);boardcolor();
								if(i==0 && j==6 && bkingx==0 && bkingy==4 ) {
									bpieces[0][5].setIcon(bpieces[0][7].getIcon());
									bpieces[0][7].setIcon(null);boardcolor();
								}
								bkingx=i;
								bkingy=j;
								turn=true;
								pieceturn="null";
								boardcolor();
								break;
							}
							
							else if (e.getSource()==wpieces[i][j] && blocks[i][j].getBackground()==cl4[l] && pieceturn.equals("bking") ) {
								wpieces[i][j].setIcon(null);boardcolor();
								bpieces[i][j].setIcon(bpieces[bkingx][bkingy].getIcon());
								bpieces[bkingx][bkingy].setIcon(null);boardcolor();
								bkingx=i;
								bkingy=j;
								turn=true;										
								pieceturn="null";
								boardcolor();
								break;
							}

						}
					}
				}
					}
				}
			}

			if(blocks[wkingx][wkingy].getBackground()==MAIN.mcl5 || blocks[wkingx][wkingy].getBackground()==MAIN.mcl6) {wchek=true;}else {wchek=false;}
			if(blocks[bkingx][bkingy].getBackground()==MAIN.mcl5 || blocks[bkingx][bkingy].getBackground()==MAIN.mcl6) {bchek=true;}else {bchek=false;}

		if((wkingx!=-1 && wkingy!=-1 && wpieces[wkingx][wkingy].getIcon()==null)||min[0]<=0) {
			winner="black";
			output.setText("black is the winner");
			output.setForeground(new Color(152,251,152));
			boardcolor();
			
		}
		
		else if((bkingx!=-1 && bkingy!=-1 && bpieces[bkingx][bkingy].getIcon()==null)||min[1]<=0) {
			winner="white";
			output.setText("white is the winner");
			output.setForeground(new Color(152,251,152));
			boardcolor();
		}
		
		else if(turn && winner.equals("") && wchek==false) {
			output.setText("its white's turn");
			output.setForeground(Color.white);
			
		}
		else if(turn && winner.equals("") && wchek==true) {
			output.setText("white king under chek");
			output.setForeground(Color.white);
			
		}
		else if(turn==false&& winner.equals("") && bchek==false) {
			output.setText("its black's turn");
			output.setForeground(Color.black);
		}
		else if(turn==false&& winner.equals("") && bchek==true) {
			output.setText("black king under chek");
			output.setForeground(Color.black);
		}
		
		frame.repaint();
		frame.setVisible(true);
		}
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
	public void pmove() {
		for (int i =0;i<8;i++) {
			for (int j =0;j<8;j++) {
				for (int z =0;z<10;z++) {
	
						if(wpieces[i][j].getIcon()==null) {
							if(z<8 && i==wpawnx[z] && j==wpawny[z]) {wpawnx[z]=-1;wpawny[z]=-1;}
							if(i==wrookx[z] && j==wrooky[z]) {wrookx[z]=-1;wrooky[z]=-1;}
							if(i==wkhightx[z] && j==wkhighty[z]) {wkhightx[z]=-1;wkhighty[z]=-1;}
							if(i==wbeshopx[z] && j==wbeshopy[z]) {wbeshopx[z]=-1;wbeshopy[z]=-1;}
							if(z<9 && i==wquinnx[z] && j==wquinny[z]) {wquinnx[z]=-1;wquinny[z]=-1;}
						}
						if(bpieces[i][j].getIcon()==null) {
							if(z<8 && i==bpawnx[z] && j==bpawny[z]) {bpawnx[z]=-1;bpawny[z]=-1;}
							if(i==brookx[z] && j==brooky[z]) {brookx[z]=-1;brooky[z]=-1;}
							if(i==bkhightx[z] && j==bkhighty[z]) {bkhightx[z]=-1;bkhighty[z]=-1;}
							if(i==bbeshopx[z] && j==bbeshopy[z]) {bbeshopx[z]=-1;bbeshopy[z]=-1;}
							if(z<9 && i==bquinnx[z] && j==bquinny[z]) {bquinnx[z]=-1;bquinny[z]=-1;}
						}
						
					if(turn==false){
					if(z<8 && wpawnx[z]-1>=0 && wpawny[z]+1< 8)movecol((wpawnx[z]-1),wpawny[z]+1,false);
					if(z<8 && wpawnx[z]-1>=0 && wpawny[z]-1>=0)movecol((wpawnx[z]-1),wpawny[z]-1,false);
					if(wkhightx[z]!=-1 && wkhighty[z]!=-1) {
					if(wkhightx[z]-2>=0 && wkhighty[z]+1<8 && wpieces[wkhightx[z]-2][wkhighty[z]+1].getIcon()==null) {
						movecol(wkhightx[z]-2,wkhighty[z]+1,false);}
		    		if(wkhightx[z]-2>=0 && wkhighty[z]-1>=0 && wpieces[wkhightx[z]-2][wkhighty[z]-1].getIcon()==null) {
						movecol(wkhightx[z]-2,wkhighty[z]-1,false);}
		    		if(wkhightx[z]+2<8 && wkhighty[z]+1<8 && wpieces[wkhightx[z]+2][wkhighty[z]+1].getIcon()==null) {
						movecol(wkhightx[z]+2,wkhighty[z]+1,false);}
		    		if(wkhightx[z]+2<8 && wkhighty[z]-1>=0 && wpieces[wkhightx[z]+2][wkhighty[z]-1].getIcon()==null) {
						movecol(wkhightx[z]+2,wkhighty[z]-1,false);}
		    		if(wkhightx[z]-1>=0 && wkhighty[z]+2<8 && wpieces[wkhightx[z]-1][wkhighty[z]+2].getIcon()==null) {
						movecol(wkhightx[z]-1,wkhighty[z]+2,false);}
					if(wkhightx[z]-1>=0 && wkhighty[z]-2>=0 && wpieces[wkhightx[z]-1][wkhighty[z]-2].getIcon()==null) {
						movecol(wkhightx[z]-1,wkhighty[z]-2,false);}
					if(wkhightx[z]+1<8 && wkhighty[z]+2<8 && wpieces[wkhightx[z]+1][wkhighty[z]+2].getIcon()==null) {
						movecol(wkhightx[z]+1,wkhighty[z]+2,false);}
					if(wkhightx[z]+1<8 && wkhighty[z]-2>=0 && wpieces[wkhightx[z]+1][wkhighty[z]-2].getIcon()==null) {
						movecol(wkhightx[z]+1,wkhighty[z]-2,false);}}
					if(wrookx[z]!=-1 && wrooky[z]!=-1) {
					for(int k = 1 ; k<8;k++) {
		    			if ((wrookx[z]-k)>=0&& wpieces[wrookx[z]-k][wrooky[z]].getIcon()==null) {
		    				movecol(wrookx[z]-k,wrooky[z],false);
		    				if(bpieces[wrookx[z]-k][wrooky[z]].getIcon()==null && (wrookx[z]-k)>=0) {movecol(wrookx[z]-k,wrooky[z],false);}else{break;}
		    			}
		    			else {break;}}
		    		
		    		for(int k = 1 ; k<8;k++) {
		    			if ((wrookx[z]+k)<8&& wpieces[wrookx[z]+k][wrooky[z]].getIcon()==null && bpieces[wrookx[z]+k-1][wrooky[z]].getIcon()==null) {
		    				movecol(wrookx[z]+k,wrooky[z],false);	
		    			}
		    			else {break;}}
	    		///////
	    		for(int k = 1 ; k<8;k++) {
	    			if ((wrooky[z]-k)>=0&& wpieces[wrookx[z]][wrooky[z]-k].getIcon()==null) {
	    				movecol(wrookx[z],wrooky[z]-k,false);
	    				if(bpieces[wrookx[z]][wrooky[z]-k].getIcon()==null && (wrooky[z]-k)>=0) {movecol(wrookx[z],wrooky[z]-k,false);}else{break;}
	    			}
	    			else {break;}}
	    		
	    		for(int k = 1 ; k<8;k++) {
	    			if ((wrooky[z]+k)<8 && wpieces[wrookx[z]][wrooky[z]+k].getIcon()==null && bpieces[wrookx[z]][wrooky[z]+k-1].getIcon()==null) {
	    				movecol(wrookx[z],wrooky[z]+k,false);	
	    			}
	    			else {break;}}
					}
					if(wbeshopx[z]!=-1 && wbeshopy[z]!=-1) {
				for( int k = 1 ; k<8;k++) {
					if (wbeshopx[bt]-k>=0 && wbeshopy[bt]+k<8 && wpieces[wbeshopx[bt]-k][wbeshopy[bt]+k].getIcon()==null) {
						movecol(wbeshopx[bt]-k,wbeshopy[bt]+k,false);
						if(bpieces[wbeshopx[bt]-k][wbeshopy[bt]+k].getIcon()==null) {movecol(wbeshopx[bt]-k,wbeshopy[bt]+k,false);}else{break;}
						}
					else {break;}}
				for( int k = 1 ; k<8;k++) {
					if (wbeshopx[bt]-k>=0 && wbeshopy[bt]-k>=0 && wpieces[wbeshopx[bt]-k][wbeshopy[bt]-k].getIcon()==null) {
						movecol(wbeshopx[bt]-k,wbeshopy[bt]-k,false);
						if(bpieces[wbeshopx[bt]-k][wbeshopy[bt]-k].getIcon()==null) {movecol(wbeshopx[bt]-k,wbeshopy[bt]-k,false);}else{break;}
						}
					else {break;}}
				//
				for( int k = 1 ; k<8;k++) {
					if (wbeshopx[bt]+k<8 && wbeshopy[bt]+k<8 && wpieces[wbeshopx[bt]+k][wbeshopy[bt]+k].getIcon()==null ) {
						movecol(wbeshopx[bt]+k,wbeshopy[bt]+k,false);
						if(bpieces[wbeshopx[bt]+k][wbeshopy[bt]+k].getIcon()==null) {movecol(wbeshopx[bt]+k,wbeshopy[bt]+k,false);}else{break;}
						}
					else {break;}}
				for( int k = 1 ; k<8;k++) {
					if (wbeshopx[bt]+k<8 && wbeshopy[bt]-k>=0 && wpieces[wbeshopx[bt]+k][wbeshopy[bt]-k].getIcon()==null) {
						movecol(wbeshopx[bt]+k,wbeshopy[bt]-k,false);
						if(bpieces[wbeshopx[bt]+k][wbeshopy[bt]-k].getIcon()==null) {movecol(wbeshopx[bt]+k,wbeshopy[bt]-k,false);}else{break;}
						}
					else {break;}}
					}
	/**/			if(z<9 && wquinnx[z]!=-1 && wquinny[z]!=-1) {
				for( int k = 1 ; k<8;k++) {
					if (wquinnx[z]-k>=0 && wquinny[z]+k<8 && wpieces[wquinnx[z]-k][wquinny[z]+k].getIcon()==null ) {
						movecol(wquinnx[z]-k,wquinny[z]+k,false);
						if(bpieces[wquinnx[z]-k][wquinny[z]+k].getIcon()==null) {movecol(wquinnx[z]-k,wquinny[z]+k,false);}else{break;}
						}
					else {break;}}
				for( int k = 1 ; k<8;k++) {
					if (wquinnx[z]-k>=0 && wquinny[z]-k>=0 && wpieces[wquinnx[z]-k][wquinny[z]-k].getIcon()==null) {
						movecol(wquinnx[z]-k,wquinny[z]-k,false);
						if(bpieces[wquinnx[z]-k][wquinny[z]-k].getIcon()==null) {movecol(wquinnx[z]-k,wquinny[z]-k,false);}else{break;}
						}
					else {break;}}
				//
				for( int k = 1 ; k<8;k++) {
					if (wquinnx[z]+k<8 && wquinny[z]+k<8 && wpieces[wquinnx[z]+k][wquinny[z]+k].getIcon()==null) {
						movecol(wquinnx[z]+k,wquinny[z]+k,false);
						if(bpieces[wquinnx[z]+k][wquinny[z]+k].getIcon()==null) {movecol(wquinnx[z]+k,wquinny[z]+k,false);}else{break;}
						}
					else {break;}}
				for( int k = 1 ; k<8;k++) {
					if (wquinnx[z]+k<8 && wquinny[z]-k>=0 && wpieces[wquinnx[z]+k][wquinny[z]-k].getIcon()==null) {
						movecol(wquinnx[z]+k,wquinny[z]-k,false);
						if(bpieces[wquinnx[z]+k][wquinny[z]-k].getIcon()==null) {movecol(wquinnx[z]+k,wquinny[z]-k,false);}else{break;}
						}
					else {break;}}
				for(int k = 1 ; k<8;k++) {
	    			if ((wquinnx[z]-k)>=0&& wpieces[wquinnx[z]-k][wquinny[z]].getIcon()==null) {
	    				movecol(wquinnx[z]-k,wquinny[z],false);
	    				if(bpieces[wquinnx[z]-k][wquinny[z]].getIcon()==null && (wquinnx[z]-k)>=0) {movecol(wquinnx[z]-k,wquinny[z],false);}else{break;}
	    			}
	    			else {break;}}
	    		
	    		for(int k = 1 ; k<8;k++) {
	    			if ((wquinnx[z]+k)<8 && wpieces[wquinnx[z]+k][wquinny[z]].getIcon()==null && bpieces[wquinnx[z]+k-1][wquinny[z]].getIcon()==null) {
	    				movecol(wquinnx[z]+k,wquinny[z],false);	
	    			}
	    			else {break;}}
	    		///////
	    		for(int k = 1 ; k<8;k++) {
	    			if ((wquinny[z]-k)>=0&& wpieces[wquinnx[z]][wquinny[z]-k].getIcon()==null) {
	    				movecol(wquinnx[z],wquinny[z]-k,false);
	    				if(bpieces[wquinnx[z]][wquinny[z]-k].getIcon()==null && (wquinny[z]-k)>=0) {movecol(wquinnx[z],wquinny[z]-k,false);}else{break;}
	    			}
	    			else {break;}}
	    		
	    		for(int k = 1 ; k<8;k++) {
	    			if ((wquinny[z]+k)<8&& wpieces[wquinnx[z]][wquinny[z]+k].getIcon()==null && bpieces[wquinnx[z]][wquinny[z]+k-1].getIcon()==null) {
	    				movecol(wquinnx[z],wquinny[z]+k,false);	
	    			}
	    			else {break;}}
				}
					}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
					else {
						if(z<8 && bpawnx[z]+1<8 && bpawny[z]+1< 8)movecol((bpawnx[z]+1),bpawny[z]+1,false);
						if(z<8 && bpawnx[z]+1<8 && bpawny[z]-1>=0)movecol((bpawnx[z]+1),bpawny[z]-1,false);
						if(bkhightx[z]!=-1 && bkhighty[z]!=-1) {
						if(bkhightx[z]-2>=0 && bkhighty[z]+1<8 && bpieces[bkhightx[z]-2][bkhighty[z]+1].getIcon()==null) {
							movecol(bkhightx[z]-2,bkhighty[z]+1,false);}
			    		if(bkhightx[z]-2>=0 && bkhighty[z]-1>=0 && bpieces[bkhightx[z]-2][bkhighty[z]-1].getIcon()==null) {
							movecol(bkhightx[z]-2,bkhighty[z]-1,false);}
			    		if(bkhightx[z]+2<8 && bkhighty[z]+1<8 && bpieces[bkhightx[z]+2][bkhighty[z]+1].getIcon()==null) {
							movecol(bkhightx[z]+2,bkhighty[z]+1,false);}
			    		if(bkhightx[z]+2<8 && bkhighty[z]-1>=0 && bpieces[bkhightx[z]+2][bkhighty[z]-1].getIcon()==null) {
							movecol(bkhightx[z]+2,bkhighty[z]-1,false);}
			    		if(bkhightx[z]-1>=0 && bkhighty[z]+2<8 && bpieces[bkhightx[z]-1][bkhighty[z]+2].getIcon()==null) {
							movecol(bkhightx[z]-1,bkhighty[z]+2,false);}
						if(bkhightx[z]-1>=0 && bkhighty[z]-2>=0 && bpieces[bkhightx[z]-1][bkhighty[z]-2].getIcon()==null) {
							movecol(bkhightx[z]-1,bkhighty[z]-2,false);}
						if(bkhightx[z]+1<8 && bkhighty[z]+2<8 && bpieces[bkhightx[z]+1][bkhighty[z]+2].getIcon()==null) {
							movecol(bkhightx[z]+1,bkhighty[z]+2,false);}
						if(bkhightx[z]+1<8 && bkhighty[z]-2>=0 && bpieces[bkhightx[z]+1][bkhighty[z]-2].getIcon()==null) {
							movecol(bkhightx[z]+1,bkhighty[z]-2,false);}}
						if(brookx[z]!=-1 && brooky[z]!=-1) {
							for(int k = 1 ; k<8;k++) {
				    			if ((brookx[z]-k)>=0&& bpieces[brookx[z]-k][brooky[z]].getIcon()==null) {
				    				movecol(brookx[z]-k,brooky[z],false);
				    				if(wpieces[brookx[z]-k][brooky[z]].getIcon()==null && (brookx[z]-k)>=0) {movecol(brookx[z]-k,brooky[z],false);}else{break;}
				    			}
				    			else {break;}}
				    		
				    		for(int k = 1 ; k<8;k++) {
				    			if ((brookx[z]+k)<8&& bpieces[brookx[z]+k][brooky[z]].getIcon()==null && wpieces[brookx[z]+k-1][brooky[z]].getIcon()==null) {
				    				movecol(brookx[z]+k,brooky[z],false);	
				    			}
				    			else {break;}}
				    		///////
				    		for(int k = 1 ; k<8;k++) {
				    			if ((brooky[z]-k)>=0&& bpieces[brookx[z]][brooky[z]-k].getIcon()==null) {
				    				movecol(brookx[z],brooky[z]-k,false);
				    				if(wpieces[brookx[z]][brooky[z]-k].getIcon()==null && (brooky[z]-k)>=0) {movecol(brookx[z],brooky[z]-k,false);}else{break;}
				    			}
				    			else {break;}}
				    		
				    		for(int k = 1 ; k<8;k++) {
				    			if ((brooky[z]+k)<8&& bpieces[brookx[z]][brooky[z]+k].getIcon()==null && wpieces[brookx[z]][brooky[z]+k-1].getIcon()==null) {
				    				movecol(brookx[z],brooky[z]+k,false);	
				    			}
				    			else {break;}}
						}
						if(bbeshopx[z]!=-1 && bbeshopy[z]!=-1) {
							for( int k = 1 ; k<8;k++) {
								if (bbeshopx[z]-k>=0 && bbeshopy[z]+k<8 && bpieces[bbeshopx[z]-k][bbeshopy[z]+k].getIcon()==null) {
									movecol(bbeshopx[z]-k,bbeshopy[z]+k,false);
									if(bbeshopx[z]-k-1>=0 && bbeshopy[z]+k+1<8 &&wpieces[bbeshopx[z]-k][bbeshopy[z]+k].getIcon()==null) {movecol(bbeshopx[z]-k-1,bbeshopy[z]+k+1,false);}else{break;}
									}
								else {break;}}
							for( int k = 1 ; k<8;k++) {
								if (bbeshopx[z]-k>=0 && bbeshopy[z]-k>=0 && bpieces[bbeshopx[z]-k][bbeshopy[z]-k].getIcon()==null) {
									movecol(bbeshopx[z]-k,bbeshopy[z]-k,false);
						if(wpieces[bbeshopx[z]-k][bbeshopy[z]-k].getIcon()==null) {movecol(bbeshopx[z]-k,bbeshopy[z]-k,false);}else{break;}
									}
								else {break;}}
							//
							for( int k = 1 ; k<8;k++) {
								if (bbeshopx[z]+k<8 && bbeshopy[z]+k<8 && bpieces[bbeshopx[z]+k][bbeshopy[z]+k].getIcon()==null) {
									movecol(bbeshopx[z]+k,bbeshopy[z]+k,false);
									if(wpieces[bbeshopx[z]+k][bbeshopy[z]+k].getIcon()==null) {movecol(bbeshopx[z]+k,bbeshopy[z]+k,false);}else{break;}
									}
								else {break;}}
							for( int k = 1 ; k<8;k++) {
								if (bbeshopx[z]+k<8 && bbeshopy[z]-k>=0 && bpieces[bbeshopx[z]+k][bbeshopy[z]-k].getIcon()==null) {
									movecol(bbeshopx[z]+k,bbeshopy[z]-k,false);
									if(wpieces[bbeshopx[z]+k][bbeshopy[z]-k].getIcon()==null) {movecol(bbeshopx[z]+k,bbeshopy[z]-k,false);}else{break;}
									}
								else {break;}}
						}
		/**/			if(z<9 && bquinnx[z]!=-1 && bquinny[z]!=-1) {
			for( int k = 1 ; k<8;k++) {
				if (bquinnx[z]-k>=0 && bquinny[z]+k<8 && bpieces[bquinnx[z]-k][bquinny[z]+k].getIcon()==null) {
					movecol(bquinnx[z]-k,bquinny[z]+k,false);
					if(wpieces[bquinnx[z]-k][bquinny[z]+k].getIcon()==null) {movecol(bquinnx[z]-k,bquinny[z]+k,false);}else{break;}
					}
				else {break;}}
			for( int k = 1 ; k<8;k++) {
				if (bquinnx[z]-k>=0 && bquinny[z]-k>=0 && bpieces[bquinnx[z]-k][bquinny[z]-k].getIcon()==null) {
					movecol(bquinnx[z]-k,bquinny[z]-k,false);
					if(wpieces[bquinnx[z]-k][bquinny[z]-k].getIcon()==null) {movecol(bquinnx[z]-k,bquinny[z]-k,false);}else{break;}
					}
				else {break;}}
			//
			for( int k = 1 ; k<8;k++) {
				if (bquinnx[z]+k<8 && bquinny[z]+k<8 && bpieces[bquinnx[z]+k][bquinny[z]+k].getIcon()==null) {
					movecol(bquinnx[z]+k,bquinny[z]+k,false);
					if(wpieces[bquinnx[z]+k][bquinny[z]+k].getIcon()==null) {movecol(bquinnx[z]+k,bquinny[z]+k,false);}else{break;}
					}
				else {break;}}
			for( int k = 1 ; k<8;k++) {
				if (bquinnx[z]+k<8 && bquinny[z]-k>=0 && bpieces[bquinnx[z]+k][bquinny[z]-k].getIcon()==null) {
					movecol(bquinnx[z]+k,bquinny[z]-k,false);
					if(wpieces[bquinnx[z]+k][bquinny[z]-k].getIcon()==null) {movecol(bquinnx[z]+k,bquinny[z]-k,false);}else{break;}
					}
				else {break;}}
			///////////
			for(int k = 1 ; k<8;k++) {
				if ((bquinnx[z]-k)>=0&& bpieces[bquinnx[z]-k][bquinny[z]].getIcon()==null) {
					movecol(bquinnx[z]-k,bquinny[z],false);
					if(wpieces[bquinnx[z]-k][bquinny[z]].getIcon()==null && (bquinnx[z]-k)>=0) {movecol(bquinnx[z]-k,bquinny[z],false);}else{break;}
				}
				else {break;}}
			
			for(int k = 1 ; k<8;k++) {
				if ((bquinnx[z]+k)<8&& bpieces[bquinnx[z]+k][bquinny[z]].getIcon()==null && wpieces[bquinnx[z]+k-1][bquinny[z]].getIcon()==null) {
					movecol(bquinnx[z]+k,bquinny[z],false);	
				}
				else {break;}}
			///////
			for(int k = 1 ; k<8;k++) {
				if ((bquinny[z]-k)>=0&& bpieces[bquinnx[z]][bquinny[z]-k].getIcon()==null) {
					movecol(bquinnx[z],bquinny[z]-k,false);
					if(wpieces[bquinnx[z]][bquinny[z]-k].getIcon()==null && (bquinny[z]-k)>=0) {movecol(bquinnx[z],bquinny[z]-k,false);}else{break;}
				}
				else {break;}}
			
			for(int k = 1 ; k<8;k++) {
				if ((bquinny[z]+k)<8&& bpieces[bquinnx[z]][bquinny[z]+k].getIcon()==null && wpieces[bquinnx[z]][bquinny[z]+k-1].getIcon()==null) {
					movecol(bquinnx[z],bquinny[z]+k,false);	
				}
				else {break;}}
					}
					}
				}
			}
		}
	}
}