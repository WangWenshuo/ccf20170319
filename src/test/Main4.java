package test;

import java.util.Scanner;

public class Main4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int y = scanner.nextInt();
		
		int a[][] = new int[x+1][x+1];
		for(int i=0;i<y;i++){
			int index1 = scanner.nextInt();
			int index2 = scanner.nextInt();
			int weight = scanner.nextInt();
			
			a[index1][index2]=weight;
		}
		
		for(int k=1;k<=x;k++){
			for(int i=1;i<=x;i++){
				for(int j=1;j<=x;j++){
					if(a[i][k]==0||a[k][j]==0)
						continue;
					if((a[i][j]==0||(a[i][k]<a[i][j]&&a[k][j]<a[i][j]))&&a[i][k]!=0&&a[k][j]!=0)
						a[i][j]=a[i][k]>a[k][j]?a[i][k]:a[k][j];
				}
			}
		}
		
		System.out.println(a[1][x]);
	}

}
