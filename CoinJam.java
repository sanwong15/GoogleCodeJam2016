import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CoinJam {

	public static void main(String[] args) {
	    try{
	        FileWriter fw = new FileWriter("outputC.txt");
	        PrintWriter pw = new PrintWriter(fw);
	        Path path = Paths.get("/Users/san/Documents/workspace/CodeJamQualification/src/inputC.txt");
        	Scanner sc = new Scanner(path);

	        int NumOfTestCase = sc.nextInt();
	        for (int k = 1; k<=NumOfTestCase; k++){
	        	pw.println("Case #"+k+":");
	        	int N = sc.nextInt();
	        	int J = sc.nextInt();
	        	ArrayList<String> result = jamcoin(N,J);
	        	for (int q = 0; q<J; q++){
	        		pw.println(result.get(q));
	        	}
	        }
	        sc.close();
	        pw.close();
	    }catch (IOException e){
	    	System.out.println("ERROR");
	    }

	}// End of main
	
	public static ArrayList<String> jamcoin(int N, int J){
		ArrayList<String> all = getBinaries(N,"");
		
		ArrayList<String> filtered = new ArrayList<String>();
		
		for (String s: all){
			//System.out.println(s);
			int a = Character.getNumericValue(s.charAt(0));
			int b = Character.getNumericValue(s.charAt(N-1));
			//System.out.println(a);
			//System.out.println(b);
			if (a==1 && b== 1){
				filtered.add(s);
			}
		}
		
		//System.out.println(filtered);
		
		ArrayList<String> nonPrime = new ArrayList<String>();
		for(String t: filtered){
			int[] ints = new int[N];
			for(int i=0; i<N; i++){ 
			   ints[i] = Character.getNumericValue(t.charAt(i));
			}
			
			//Found interpretation of diff base
			ArrayList<Integer> interpretResult = new ArrayList<Integer>();
			for (int b = 2; b<11; b++){
				int interpretVal = interpret (ints, b);
				if (!isPrime(interpretVal)){
					interpretResult.add(interpretVal);
				}
			}
			int r=0;
			if (interpretResult.size() < 9){
				interpretResult.clear();
			}else if (interpretResult.size() == 9 && r<J){
				String listString = "";
				for (Integer e: interpretResult)
				{ 
				    listString += e + "\t";
				}
				nonPrime.add(listString);
				r++;
			}
			//System.out.println(interpretResult);

		}//End of for loop
		
		ArrayList<String> finalResult = new ArrayList<String>();
		
		for (String s: nonPrime){
			ArrayList<Integer> sDivResult = new ArrayList<Integer>();
			//System.out.println(s);
			String[] parts = s.split("\t");
			for (String t: parts){
				int tval = Integer.parseInt(t);
				int sDiv = smallestdivisor(tval);
				tval = tval/sDiv;
				sDivResult.add(tval);
			}
			String listString = parts[8] +" ";
			for (Integer e1: sDivResult){ 
			    listString += e1 + " ";
			}
			finalResult.add(listString);
			
		}
/*		
		System.out.println("finalResult");
		for (String s1: finalResult){
			System.out.println(s1);
		}
*/		

		return finalResult;

	}// End of jamcoin
	
	public static boolean isPrime(int n) {
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}
	
	public static int interpret (int[] array, int base){
		int len = array.length;
		int val = 0;
		for (int j=0; j<len; j++){
			val += array[j]*(Math.pow(base, j));
		}
		return val;
	}
	
	//Generate all possible binary combination
	public static ArrayList<String> getBinaries(int bits, String current) {
	    ArrayList<String> binaries = new ArrayList<>();
	 
	    if (current.length() == bits) {
	        binaries.add(current);
	        return binaries;
	    } 
	 
	    //pad a 0 and 1 in front of current; 
	    binaries.addAll(getBinaries(bits, "0" + current));
	    binaries.addAll(getBinaries(bits, "1" + current));
	 
	    return binaries;
	}
	
	public static int smallestdivisor(int n){
		int d = 2;
		while(n%d != 0){
			d++;
		}
		return d;
	}


}//End of Coinjam
