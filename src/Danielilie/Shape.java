package Danielilie;

public class Shape {
		
	int area = 0;
	int type = 0;
	int locationx;
	int locationy;
	int width = 0 ;
	int length = 0 ;
	int Rcolour = 0;
	int Gcolour = 0;
	int Bcolour = 0;
	
	
	public Shape(int type, int locationx, int locationy, int width, int length, int Rcolour, int Gcolour, int Bcolour) {
		
		
		
		this.type = type;
		this.locationx = locationx;
		this.locationy = locationy;
		this.width = width;
		this.length = length;
		this.Rcolour = Rcolour;
		this.Gcolour = Gcolour;
		this.Bcolour = Bcolour;
		
		this.area = area(this.length, this.width, this.type);
		
	}
	
	public int area(int length, int width, int type) {
		
		if(type == 1) {
			return width*length;
		}
		
		if(type == 2) {
			return width*width;
		}
		
		if(type == 3) {
			return (int)(Math.PI *  (width/2) * (width/2));
		}
		return 0;
		
	}
	
	public int findarea(){
		return area;
	}
	
	public int findtype() {
		return type;
	}
	
	public int findwidth() {
		return width;
	}
	
	public int findlength() {
		return length;
	}
	
	public int findR() {
		return Rcolour;
	}
	
	public int findG() {
		return Gcolour;
	}
	
	public int findB() {
		return Bcolour;
	}
	
}
