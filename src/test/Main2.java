package test;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int people_num = sc.nextInt();
		int move_count = sc.nextInt();
	
		int stu[] = new int[people_num+1];
		int loca[] = new int[people_num+1];
		for(int i=0;i<=people_num;i++){
			stu[i]=i;
			loca[i]=i;
		}
		for(int i=0;i<move_count;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			int loc = stu[x];
			
			
			if(y<=0){
				//向前移动
				y=-y;
				for(int j=0;j<y;j++){
					loca[loc-j]=loca[loc-1-j];
					stu[loca[loc-j-1]]++;
				}
				stu[x]=loc-y;
				loca[loc-y]=x;
				
			}else{
				//向后移动
				for(int j=0;j<y;j++){
					loca[loc+j]=loca[loc+1+j];
					stu[loca[loc+j+1]]--;
				}
				stu[x]=loc+y;
				loca[loc+y]=x;
			}
	
		}
		
		
		for(int i=1;i<=people_num;i++){
			if(i!=people_num)
				System.out.print(loca[i]+" ");
			else
				System.out.println(loca[i]);
		}
		
	}


}
