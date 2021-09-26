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
			
			sort(shapeareas, 0 , 6);
			
			
			
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


public void sort(int[] arr, int l, int r)
{
    if (l < r) {
        // Find the middle point
        int m =l+ (r-l)/2;

        // Sort first and second halves
        sort(arr, l, m);
        sort(arr, m + 1, r);

        // Merge the sorted halves
        merge(arr, l, m, r);
    }
}

void merge(int arr[], int l, int m, int r)
{
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    /* Create temp arrays */
    int L[] = new int[n1];
    int R[] = new int[n2];

    /*Copy data to temp arrays*/
    for (int i = 0; i < n1; ++i)
        L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
        R[j] = arr[m + 1 + j];

    /* Merge the temp arrays */

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarray array
    int k = l;
    while (i < n1 && j < n2) {
        if (L[i] <= R[j]) {
            arr[k] = L[i];
            i++;
        }
        else {
            arr[k] = R[j];
            j++;
        }
        k++;
    }

    /* Copy remaining elements of L[] if any */
    while (i < n1) {
        arr[k] = L[i];
        i++;
        k++;
    }

    /* Copy remaining elements of R[] if any */
    while (j < n2) {
        arr[k] = R[j];
        j++;
        k++;
    }
}




}
