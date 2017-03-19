package test;

import java.util.Scanner;

public class Main3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String line = null;
		int rec_list = -1;
		String s=null;
		int startEndP=0;
		while(sc.hasNextLine()){
			line = sc.nextLine();
			if(!line.contains("*")&&rec_list!=-1){
				System.out.println("</ul>");
				rec_list=-1;
			}
			line=process1(line);
			line=process2(line);
			//±ÍÃ‚ºÏ≤‚
			if(line.contains("#")){
				String rec[] = line.split(" ");
				int len = rec.length;
				int count = rec[0].length();
				System.out.println("<h"+count+">"+line.replace("#", "").trim()+"</h"+count+">");
			}else if(line.contains("*")){
				if(rec_list==-1){
					System.out.println("<ul>");
					rec_list++;
					System.out.println("<li>"+line.replace("*", "").trim()+"<li>");
				}else{
					rec_list++;
					System.out.println("<li>"+line.replace("*", "").trim()+"<li>");
				}
				if(!sc.hasNextLine()){
					System.out.println("</ul>");
					rec_list=-1;
				}
			}else if(!line.equals("")){
				startEndP++;
				if(startEndP==1){
					System.out.println("<p>"+line);
				}else{
					System.out.println(line);
				}
				s+=line+"\n";
			}else {
				if(startEndP!=0){
					System.out.println(line+"</p>");
					startEndP=0;
				}
			}
		}
			
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
		String finalString;
		int len = s.length();
		int x=0,y=0;
		int tempx=x;
		int tempy=y;
		x=s.indexOf("[",x);
		y=s.indexOf("]",y);
		if(x==-1){
			return s;
		}
		String p1=s.substring(tempx,x);
		String p2 = s.substring(x+1, y);
		//String p3 = s.substring(y+1, len);
		
		int m=0,n=0;
		int tempm=m;
		int tempn=n;
		m=y+1;
		n=s.indexOf(")",n);
		//System.out.println(x);
		//System.out.println(y);
		//String p4=  s.substring(tempm,m);
		String p5 = s.substring(m+1, n);
		String p6 = s.substring(n+1, len);
		
		finalString=p1+"<a href=\""+p5+"\">"+p2+"</a>"+p6;
		//System.out.println(p4);;
		return finalString;
	}

}
