import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BleatrixTroll {

	public static void main(String[] args){
		/* 
		INPUT
			5
			0
			1
			2
			11
			1692
			
		OUTPUT
		Case #1: INSOMNIA
		Case #2: 10
		Case #3: 90
		Case #4: 110
		Case #5: 5076


		int[] heap1 = new int[10];
		Arrays.fill(heap1, 0);
		if (canBleatrixSleep(heap1,0,1) == -1){
			System.out.println("INSOMNIA");
		}else{
			System.out.println("Case #1" + ": " + canBleatrixSleep(heap1,0,1));
		}

		
		int[] heap2 = new int[10];
		Arrays.fill(heap2, 0);
		System.out.println("Case #2" + ": " + canBleatrixSleep(heap2,1,1));
		
		int[] heap3 = new int[10];
		Arrays.fill(heap3, 0);
		System.out.println("Case #3" + ": " + canBleatrixSleep(heap3,2,1));
		
		int[] heap4 = new int[10];
		Arrays.fill(heap4, 0);
		System.out.println("Case #4" + ": " + canBleatrixSleep(heap4,11,1));
		
		int[] heap5 = new int[10];
		Arrays.fill(heap5, 0);
		System.out.println("Case #5" + ": " + canBleatrixSleep(heap5,1692,1));
*/

		//Consider dealing with CodeJam input format

	    
	    try{
	        FileWriter fw = new FileWriter("output.txt");
	        PrintWriter pw = new PrintWriter(fw);
	        Path path = Paths.get("/Users/san/Documents/workspace/CodeJamQualification/src/input.txt");
        	Scanner sc = new Scanner(path);

	        int NumOfTestCase = sc.nextInt();
	        for (int k = 1; k<=NumOfTestCase; k++){
	        	int[] heap = new int[10];
	        	Arrays.fill(heap, 0);
	        	int N = sc.nextInt();
	        	int result = canBleatrixSleep(heap,N,1);
	        	if (result == -1){
	        		pw.println("Case #" + k + ": " + "INSOMNIA");
	        		System.out.println("Case #" + k + ": " + "INSOMNIA");
	        	}else{
	        		pw.println("Case #" + k + ": " + result);
	        		System.out.println("Case #" + k + ": " + result);
	        	}
	        }
	       // br.close();
	        pw.close();
	    }catch (IOException e){
	    	System.out.println("ERROR");
	    }
		

	}
	
	public static int canBleatrixSleep(int[] array, int N,int i){
		//Base case of Recursive Call
		int Nnext = N*(i+1);
		System.out.println("i: " + i + "  |  N*(i+1): " +Nnext);
		if (Nnext == N){
			//System.out.println("N*(i+1) == N");
			return -1;
		}
		
		//Extract all digit from N
		int N_i = N*i;
		int Ncopy = N_i;
		boolean anyZeros = false;

		
		while(Ncopy > 0){
			array[Ncopy%10]++;
			Ncopy = Ncopy/10;
		}
		
		for (int j = 0; j<array.length; j++){
			if (array[j] == 0){
				anyZeros = true;
			}
		}
		
		if (anyZeros == true){
			i++;
			return canBleatrixSleep(array,N,i);
		}else{
			return N_i;
		}
		
		
	}

}
