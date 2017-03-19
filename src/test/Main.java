package test;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int y = sc.nextInt();
		int dangao[] = new int[x];
		for(int i=0;i<x;i++){
			dangao[i]=sc.nextInt();
		}
		sort(dangao,0,dangao.length-1);
		
		int answer=0;
		int flag=0;
		int temp=0;
		while(flag<=x-1&&answer<=y){
			int sum=0;
			while(sum<y){
				sum=sum+dangao[flag];
				flag++;
				if(sum>=y){
					answer++;
					break;
				}
				
				if(flag>x-1||answer>y){
					break;
				}
			}
			if(sum<y)
				answer++;
		}
		System.out.println(answer);
	}
	public static void sort(int a[],int lo,int hi){
		if(hi<=lo) return;
		int j=partition(a, lo, hi);
		sort(a,lo,j-1);
		sort(a,j+1,hi);
	}
	public static int partition(int a[],int lo,int hi){
		int i=lo,j=hi+1;
		int v = a[lo];
		while(true){
			while(a[++i]<v) if(i==hi) break;
			while(v<a[--j]) if(j==lo) break;
			if(i>=j) break;
			exch(a,i,j);
		}
		exch(a,lo,j);
		return j;
	}
	public static void exch(int a[],int x,int y){
		int t=a[x];
		a[x]=a[y];
		a[y]=t;
	}

}
