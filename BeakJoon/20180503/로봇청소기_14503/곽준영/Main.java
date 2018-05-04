package ·Îº¿Ã»¼Ò±â_14503.°ûÁØ¿µ;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Main m = new Main();
		
		
	}
	
	private int[][] matrix;
	private int row,cal;
	private int startX, startY, direction;
	int cnt;
	public Main(){
		Scanner s = new Scanner(System.in);
		
		String settingNum1 = s.nextLine();
		cnt = 0;
		row = Integer.parseInt(settingNum1.split(" ")[0]);
		cal = Integer.parseInt(settingNum1.split(" ")[1]);
		
		String settingNum2 = s.nextLine();
		
		startX = Integer.parseInt(settingNum2.split(" ")[0]);
		startY = Integer.parseInt(settingNum2.split(" ")[1]);
		direction = Integer.parseInt(settingNum2.split(" ")[2]);
		
		matrix = new int[row][cal];

		for(int i = 0;i<row;i++){
			String line = s.nextLine();
			for(int j = 0;j<cal;j++){
				matrix[i][j] = Integer.parseInt(line.split(" ")[j]);
			}
		}
		
		clean(startX, startY, direction);
		
		
		System.out.println(cnt);
	}
	
	public int rotation(int d){
		if(d-1<0){
			return 3;
		}else{
			return d-1;
		}
	}
	
	public int clean(int x,int y,int d){
		
		if(matrix[x][y] == 0){
			matrix[x][y] = 2;
			cnt++;
		}

		if(saerch(x,y,d) == 0){
			switch (d){
			case 0 :
				x=x+1;
				break;
			case 1 :
				y=y-1;
				break;
			case 2 :
				x=x-1;
				break;
			case 3 : 
				y=y+1;
				break;
			}
			
			if(matrix[x][y] == 1){
				return 0;
			}

			clean(x,y,d);
		}
		
		return 0;
		
		
		
		

	}
	
	public int saerch(int x, int y, int d){
		int tempd = d;
		for(int i = 0;i<4;i++){
			tempd = rotation(tempd);
			if(matrix[checkX(x,tempd)][checkY(y,tempd)] == 0){
				clean(checkX(x,tempd),checkY(y,tempd),tempd);
				return 1;
			}
		}
		
		return 0;
	}
	
	public int checkX(int x, int d){
		switch (d){
		case 0 :
			return x-1;
		case 1 :
			return x;
		case 2 :
			return x+1;
		case 3 : 
			return x;
		}
		return 0;
	}
	
	public int checkY( int y, int d){
		switch (d){
		case 0 :
			return y;
		case 1 :
			return y+1;
		case 2 :
			return y;
		case 3 : 
			return y-1;
		}
		return 0;
	}

}
