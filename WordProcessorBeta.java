import java.util.Scanner; 
import java.io.*; 
//This program was made by Jorge Salas on November 6, 2016 at the caf performs word processing via PrintWriter class. 
public class WordProcessorBeta{
	public static int processChoice(){
		Scanner input = new Scanner(System.in);
		int counter = 0;
		int caser; 
		System.out.println("Enter your choice.\n"
		               + "1 is for 500 words\n"
		               + "2 is for 250 words: "); 
		do{
			caser = input.nextInt();
			switch(caser){
				case 1: counter = 3000; break;
				case 2: counter = 100; break;
				default:{
				System.out.println("Invalid input reenter your choice\n"
						 + "1 is for 500 words\n"
		               		         + "2 is for 250 words: ");
		    	}
			}
		}while(!(caser == 1 || caser == 2)); 
		
		return counter; 
	}
	
       
	public static void processOutput(String fileName, int counter) throws IOException{
		Scanner input = new Scanner(System.in); 
		PrintWriter output = new PrintWriter(fileName + ".txt"); 
		boolean exit;
		int max = 0;
		String sentence,    //carries output sentence
			   line1,       //holds the processed substring of output sentence with at most 70 characters.
			   line2 = "",       //holds the processed substring of output sentence truncated if sentence was greater than 70 characters. 
			   totalString; //carries the concatenated line2 substring and new Sentence. 
		
		for(int i = 0; i < 70; i++){
			if(i == 69)
				System.out.print("-\n"); 
			else
				System.out.print("- "); 
		}
		
		do{
			sentence = input.nextLine();
			max += sentence.length();
			if(line2.length() >= 0 && line2.length() <= 70){
				line2 = line2 + sentence;
				sentence = line2;
			}
			 
			if(checkString(sentence)){//for first condition when line is right size for no operations on it.
				sentence = sentence.trim();  
				output.println(sentence); 
			}  
			
			else{
						line1 = sentence.substring(0, sentence.lastIndexOf(" ", 70));
						line2 = sentence.substring(sentence.lastIndexOf(" ", 70)).trim() + " ";//need to fix trim.
					
						while(70 <= line2.length()){
							output.println(line1);
							sentence = line2;
							line1 = sentence.substring(0, sentence.lastIndexOf(" ", 70));
							line2 = sentence.substring(sentence.lastIndexOf(" ", 70)).trim() + " ";//need to fix trim. 
						}
						
						if(line2.length() <= 70){
							output.println(line1);
						} 
					if(max > counter){
						System.out.println("Enter 1 for 100 more characters enter 2 to exit"); 
					int choice = input.nextInt();
					if(choice == 1)
						counter = counter + 100; 
                    }
                                        
						
                    }		
		}while(max < counter); //code works up to this point without the do while body filled (fourth bug check); 
                output.close();
	
    }
	
	public static boolean checkString(String sentence){
		boolean space; 
		if(70 >= sentence.length() && sentence.length() >= 50) {
			char spaceCharacter = sentence.charAt(sentence.length() - 1); 
			space = !Character.isLetterOrDigit(spaceCharacter); //negation because if its a letter then its not a space.
		} 
		
		else{
			space = false; 
		}
			
			return space;
	}
	
	public static void main(String[] args) throws IOException{ 
		Scanner input = new Scanner(System.in);
		String fileName;    //holds the output name. 
		int counter = processChoice(); //* from this point there are no errors. calls method to initialize counter. 
		System.out.print("Enter a filename: ");
		fileName = input.nextLine(); 
		processOutput(fileName, counter); 
		
			
	}
}