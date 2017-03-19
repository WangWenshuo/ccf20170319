package test;

import java.util.LinkedList;
import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String s = scanner.nextLine();
		System.out.println(process2(s));
		//s=process(s);
		//System.out.println(s);
	}
	public static String process1(String s){
		s=s.replace("_", "</em>");
		String x[] = s.split("</em>");
		int len = x.length;
		String finalString = "";
		for(int i=0;i<len;i++){
			if(i==len-1){
				finalString+=x[len-1];
			}else if(i%2==0){
				finalString+=x[i]+"<em>";
			}else if(i%2!=0){
				finalString+=x[i]+"</em>";
			}
		}
		if(len%2==0)
			finalString+="</em>";
		return finalString;
	}
	public static String process2(String s){
		String finalString = "";
		int len = s.length();
		int x=0,y=0;
		int tempx=x;
		int tempy=y;
		x=s.indexOf("[",x);
		y=s.indexOf("]",y);
		//String p3 = s.substring(y+1, len);
		
		int m=0,n=0;
		int tempm=m;
		int tempn=n;
		
		while(x!=-1){
			String p1=s.substring(tempx,x);
			String p2 = s.substring(x+1, y);
			tempm=m;
			tempn=n;
			m=y+1;
			n=s.indexOf(")",n+1);
			//System.out.println(x);
			//System.out.println(y);
			//String p4=  s.substring(tempm,m);
			String p5 = s.substring(m+1, n);
			String p6 = s.substring(n+1, len);
			
			finalString=p1+"<a href=\""+p5+"\">"+p2+"</a>"+p6;
			
			System.out.println(finalString);
			
			tempx=x;
			tempy=y;
			
			x=s.indexOf("[",x+1);
			y=s.indexOf("]",y+1);
		}
		//System.out.println(p4);;
		return finalString;
	}

}
