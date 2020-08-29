import java.util.Scanner;
public class ConvertToString {
    // declaring array for the 1 to 19 number.
	static String one[] = { "", "One ", "Two ", "Three ", "Four ", "Five ", 
    		"Six ", "Seven ", "Eight ",  "Nine ", "Ten ", 
    		"Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", 
            "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen " }; 
            
    // declaring array for value of tens.
    static String ten[] = { "", "", "Twenty ", "Thirty ", "Forty ", 
                            "Fifty ", "Sixty ", "Seventy ", "Eighty ", 
                            "Ninety " }; 
  
    // function to handle the double digit number.
    // function take input for a number and additional string.
    // additional string will store the text.
    static String numToWords(int number, String suffix) 
    { 
        String strngOut = ""; 
        if (number > 19) 
        { 
            strngOut += ten[number / 10] + one[number % 10]; 
        } 
        else 
        { 
            strngOut += one[number]; 
        } 
         
        if (number != 0) { 
            strngOut += suffix; 
        } 
        return strngOut; 
    }
    
    // function will convert and number to words.
    static String convertToWords(double input) 
    {      
        String out = "";
        String temp = "";

        String s = String.valueOf(input); // converting the input to string from double.
        
        String [] splitted = s.split("\\."); // splitting the string to find dot(.)
		for (String strTemp : splitted)
		{
			if(strTemp.matches("0") )
            {
                temp = strTemp.replaceAll("0","Only");
            }
            else 
            {
                temp = strTemp.concat("/100 ONLY");
            }
		}
		
        out += numToWords((int)((input / 100000) % 100), "Lakh ");  // function call       
        out += numToWords((int)((input / 1000) % 100), "Thousand ");          
        out += numToWords((int)((input / 100) % 10), "Hundred "); 
        if (input > 100 && input % 100 > 0) 
        { 
            out += "and "; 
        } 
        out += numToWords((int)(input % 100), "");
        out += temp;
        return out; 
    }

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		double input_number = sc.nextDouble(); // taking a user input
        sc.close();
        
		String n = String.valueOf(input_number);  // converting it to a string
        
        int wholeNumber = 0;

        if(n.matches (".0") ) // if a number does not contain a decimal value
        {
            wholeNumber = (int)input_number; 
            System.out.println("Rs."+ convertToWords(wholeNumber) ); // function call
        }
        else 
        {
            System.out.println("Rs." + convertToWords(input_number) ); // function call
        }
	}
}
