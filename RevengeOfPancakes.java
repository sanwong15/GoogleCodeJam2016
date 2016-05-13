import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class RevengeOfPancakes {

	public static void main(String[] args) {
		try{
	        FileWriter fw = new FileWriter("outputB.txt");
	        PrintWriter pw = new PrintWriter(fw);
	        Path path = Paths.get("/Users/san/Documents/workspace/CodeJamQualification/src/inputB.txt");
        	Scanner sc = new Scanner(path);

	        int NumOfTestCase = sc.nextInt();
	        sc.nextLine();
	        for (int k = 1; k<=NumOfTestCase; k++){
	        	String s = sc.nextLine();
	        	int result = flipOver(s);
	        	//System.out.println("Case #" + k + ": " + result);
	        	pw.println("Case #" + k + ": " + result);
	        }
	        sc.close();
	        pw.close();
	    }catch (IOException e){
	    	System.out.println("ERROR");
	    }
	}
	
	public static int flipOver(String s){
		System.out.println(s);
		int len = s.length();
		char[] charArray = s.toCharArray();
		
		if(len==1 && s.charAt(0) == '-'){
			return 1;
		}else if(len==1 && s.charAt(0) == '+'){
			return 0;
		}
		
		//Base case
		int counter = 0;
		for (int i=0; i<len-1; i++){
			if(charArray[i+1] != charArray[i]){
				//Flip it now
				for (int j = 0; j<= i; j++){
					charArray[j] = charArray[i+1];
				}
				counter++;
				System.out.println("counter: " + counter);
				i=0;
			}//End of if(charArray[i+1] != charArray[i]) up till index "len-2"
		}//End of Forloop
		
		//Output Result
		if(charArray[len-2] != charArray[len-1]){
			counter++;
		}else if(charArray[len-2] == charArray[len-1] && charArray[len-1] == '-'){
			counter++;
		}
		
		if(charArray[0] == '+'){

			return counter;
		}else{
			return counter++;
		}
		
	}

}
