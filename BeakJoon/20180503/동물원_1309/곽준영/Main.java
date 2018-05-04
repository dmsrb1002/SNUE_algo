package 동물원_1309.곽준영;

import java.util.Scanner;

public class Main {

	public static void main(String []args){
		Main m = new Main();
	}
	private int cnt,size;
	private int matrix[];
	public Main(){
		Scanner s = new Scanner(System.in);
		cnt = 1;
		String line = s.nextLine();
		
		size = Integer.parseInt(line);
		
		matrix = new int[size*2];
		
		for(int i = 0;i<size*2;i++){
			matrix[i] = 0;
		}
		
		for(int i = 0;i<size*2;i++){
			
			push(i,matrix);
		}
		
		
		System.out.println(cnt);
		
	}
	
	public void push(int current, int[] matrix){
		
		int[] tempM = new int[size*2];
		for(int i = 0;i<size*2;i++){
			tempM[i] = matrix[i];
		}
		for(int i = current; i < size*2; i++){
			if(tempM[i] == 0){
				if(i == 0){
					if(tempM[i+1] == 0){
						tempM[i] = 1;
						for(int j = 0;j<size*2;j++){
							System.out.print(tempM[j]);
						}
						System.out.println(" ");
						cnt++;
						push(i,tempM);
						
					}
				}else if(i == 1){
					if(tempM[i-1] == 0 && tempM[i+1] == 0){
						tempM[i] = 1;
						for(int j = 0;j<size*2;j++){
							System.out.print(tempM[j]);
						}
						System.out.println(" ");
						cnt++;
						push(i,tempM);
						
					}
				}else if(1<i && i<size*2-1){
					if(tempM[i-2] == 0 && tempM[i-1] == 0 && tempM[i+1] == 0){
						tempM[i] = 1;
						for(int j = 0;j<size*2;j++){
							System.out.print(tempM[j]);
						}
						System.out.println(" ");
						cnt++;
						push(i,tempM);
						
					}
				}else if(i == size*2-1){
					if(tempM[i-2] == 0 && tempM[i-1] == 0){
						tempM[i] = 1;
						for(int j = 0;j<size*2;j++){
							System.out.print(tempM[j]);
						}
						System.out.println(" ");
						cnt++;
						push(i,tempM);
						
					}
				}
			}
			
			
		}
	}
}
