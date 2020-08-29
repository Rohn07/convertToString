import java.util.Scanner;
public class ConvertToString {
	
	static String one[] = { "", "One ", "Two ", "Three ", "Four ", "Five ", 
    		"Six ", "Seven ", "Eight ",  "Nine ", "Ten ", 
    		"Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", 
    		"Sixteen ", "Seventeen ", "Eighteen ", "Nineteen " }; 
  
     
    static String ten[] = { "", "", "Twenty ", "Thirty ", "Forty ", 
                            "Fifty ", "Sixty ", "Seventy ", "Eighty ", 
                            "Ninety " }; 
  
     
    static String numToWords(int n, String s) 
    { 
        String str = ""; 
        if (n > 19) 
        { 
            str += ten[n / 10] + one[n % 10]; 
        } 
        else 
        { 
            str += one[n]; 
        } 
         
        if (n != 0) { 
            str += s; 
        } 
        return str; 
    }
    
    static String convertToWords(double d) 
    {      
    	String out = "";
        String s = String.valueOf(d);
        String temp = "";
        String [] splitted = s.split("\\.");
		for (String strTemp : splitted)
		{
			  if(strTemp.matches("0"))
              {
              temp=strTemp.replaceAll("0","Only");

              }
              else {
                  temp = strTemp.concat("/100 ONLY");
              }
		}
		
        out += numToWords((int)((d / 100000) % 100), "Lakh ");         
        out += numToWords((int)((d / 1000) % 100), "Thousand ");          
        out += numToWords((int)((d / 100) % 10), "Hundred "); 
        if (d > 100 && d % 100 > 0) 
        { 
            out += "and "; 
        } 
        out += numToWords((int)(d % 100), "");
        out+=temp;
        return out; 
    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double n1 = sc.nextDouble();
		sc.close();
		String n=String.valueOf(n1); // string convert
        int in=0;
        if(n.matches(".0")) 
        {
            in=(int)n1; // 
            System.out.println("Rs."+convertToWords(in));

        }
        else {

            System.out.println("Rs." + convertToWords(n1));
        }
	}
}
