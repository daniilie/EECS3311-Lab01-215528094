package Danielilie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import javax.swing.*;

	
public class MyPanel extends JPanel {
	
	public ArrayList<Integer> shapes = new ArrayList<Integer>();
	public ArrayList<Shape> shapeobj = new ArrayList<Shape>();
	static int runcount = 0;
	
	
	
	@Override
	public void paintComponent(Graphics g) {
		
		if(runcount == 0) {
		shapeobj.clear();
		
		int marker = 0;
		int location = 0;
		while(marker < 6) {
		
		double Rand = Math.floor(Math.random() * (3) + 1);
		
		//colour randomiser
		int RandRColour = (int) Math.floor(Math.random() * (200 + 1));
		int RandGColour = (int) Math.floor(Math.random() * (200 + 1));
		int RandBColour = (int) Math.floor(Math.random() * (200 + 1));
		
		//size randomiser
		int RandWidth = (int) Math.floor(Math.random() * (55) + 20);
		int RandLength = (int) Math.floor(Math.random() * (55) + 20);
		
		//rectangle
		if(Rand == 1) {
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(new Color(RandRColour, RandGColour, RandBColour));//
			g2d.fillRect(475 - location , 400 - location + 30, RandWidth, RandLength);//
			
			shapeobj.add(new Shape((int)Rand, 475 - location, 400 - location, RandWidth, RandLength, RandRColour, RandGColour, RandBColour));
			
			
			
			
		}
		
		//square
		if(Rand == 2) {
			
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(new Color(RandRColour, RandGColour, RandBColour));//
			g2d.fillRect(475 - location , 400 - location + 30 , RandWidth, RandWidth);//
			
			
			shapeobj.add(new Shape((int)Rand, 475 - location, 400 - location, RandWidth, RandLength, RandRColour, RandGColour, RandBColour));
			
		}
		
		//circle
		if(Rand == 3) {
			Graphics2D g2d = (Graphics2D) g;
			g2d.setColor(new Color(RandRColour, RandGColour, RandBColour));//
			g2d.fillOval(475 -location , 400 - location + 30 , RandWidth, RandWidth);//
			
		
			shapeobj.add(new Shape((int)Rand, 475 - location, 400 - location, RandWidth, RandLength, RandRColour, RandGColour, RandBColour));
		
		}
		marker++;
		location = location + 75;
		
		}
		}else {
				
			int[] shapeareas;
			shapeareas = new int[7];
			
			
			int areainsert = 0;
			while(areainsert < 6) {
				
				shapeareas[areainsert] = shapeobj.get(areainsert).findarea();
				areainsert++;
			
			}
			
			
			Sort a = new Sort(shapeareas, 0 , 6);
			shapeareas = a.getSort();
			
			
			
			int counter = 0;
			int location = 0;
			
			while(counter<7) {
				
				int index = 0;
				
				
				int Rand = 0;
				int RandWidth = 0;
				int RandLength = 0;
				int RandRColour = 0;
				int RandGColour = 0;
				int RandBColour = 0;
				
				while(index<6) {
					
					if(shapeobj.get(index).findarea() == shapeareas[counter] ) {
						Rand = shapeobj.get(index).findtype();
						RandWidth = shapeobj.get(index).findwidth();
						RandLength = shapeobj.get(index).findlength();
						RandRColour = shapeobj.get(index).findR();
						RandGColour = shapeobj.get(index).findG();
						RandBColour = shapeobj.get(index).findB();
						break;
					}
					
					index++;
					
				}
				
				counter++;
				
		
			
				//rectangle
				if(Rand == 1) {
					
					Graphics2D g2d = (Graphics2D) g;
					g2d.setColor(new Color(RandRColour, RandGColour, RandBColour));//
					g2d.fillRect(500 - location , 500 - location + 30, RandWidth, RandLength);//
					
					
					
				}
				
				//square
				if(Rand == 2) {
					
					Graphics2D g2d = (Graphics2D) g;
					g2d.setColor(new Color(RandRColour, RandGColour, RandBColour));//
					g2d.fillRect(500 - location , 500 - location + 30 , RandWidth, RandWidth);//
					
					
				}
				
				//circle
				if(Rand == 3) {
					Graphics2D g2d = (Graphics2D) g;
					g2d.setColor(new Color(RandRColour, RandGColour, RandBColour));//
					g2d.fillOval(500 -location , 500 - location + 30 , RandWidth, RandWidth);//
					
					
				}
				
				location = location + 75;
					
			}
			
		}
			
		}
		
	

public static void main(String[] args) {
	
	
	
	
	MyPanel rects = new MyPanel();
	JFrame frame = new JFrame("Display shapes");
	frame.getContentPane();
	JButton load = new JButton("Load Shapes");
	JButton sort = new JButton("Sort Shapes");
	load.setBounds(30, 0, 150, 25);
	sort.setBounds(180, 0, 150, 25);
	
	rects.setLayout(null);
	frame.add(load);
	frame.add(sort);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.add(rects);
	frame.setSize(600, 600);
	frame.setLocationRelativeTo(null);
	frame.setVisible(true);
	frame.remove(rects);
		load.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				frame.add(rects);
				frame.repaint();
				runcount = 0;
			
			}
		});
		sort.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				runcount++;
				frame.remove(rects);
				frame.add(rects);
				frame.repaint();
				
			}
		});
	
	
		
		
}







}
