//import java.io.FileInputStream;
import java.io.*;
//import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.*;

public class WordCounter{
    //counts number of words in text through to stopword
    //if stopword not found, raise InvalidStopwordException
    //if stopword null, count all words
    //if int count < 5, return TooSmallText exception (regardless if stopword found)
    public static int processText(StringBuffer s, String stopword) throws InvalidStopwordException, TooSmallText{
        Pattern pattern = Pattern.compile("[a-zA-Z']+");
        Matcher matcher = pattern.matcher(s);
   
        int count = 0;
        boolean found = false;
        int index = 0;
        while(matcher.find()){
            String word = matcher.group();
            count++;
            //System.out.println("DEBUG: WHAT IS WORD?" + word);
            if(word.equals(stopword)){
                found = true;
                index = count;
            }
        }

        if (stopword != null){
            if (!found){
                if (count < 5)
                    throw new TooSmallText("Only found " + count + " words.");
                else 
                    throw new InvalidStopwordException("Couldn't find stopword: " + stopword);
            }
            else{
                if (count < 5 )
                    throw new TooSmallText("Only found " + count + " words.");
            }
        }
        else if (stopword == null){
            if (count < 5){
                throw new TooSmallText("Only found " + count + " words.");
            }
            return count;

        }

        return index;
    }
    //converts contents of file to and returns StringBuffer
    //if file cannot be opened, re-enter filename 
    //if file is empty, raise EmptyFileException containing file path in the message
    public static StringBuffer processFile(String path) throws EmptyFileException{
        StringBuffer sb = new StringBuffer();
        File file = new File(path);
        System.out.println(file.length());
        if (file.length() == 0){
            throw new EmptyFileException(path + " was empty");
        }
        

        try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))){
            sb.append(br.readLine());

            if (sb.toString().equals(null)){
                throw new EmptyFileException(path + " was empty");
            }
}
        catch (FileNotFoundException i){
            throw new EmptyFileException(path + " was empty");
        }
        catch (IOException a){
        }
        return sb;
    }
    //first command line argument:
    //ask user to process file with option 1, process text with option 2
    //if option invalid, choose again
    //second cmdline argument:
    //stopword specified 
    //calls methods above to process text
    //if file empty, display message of the exception raised (which includes the path of the file), 
    //continue processing with an empty string in place of the contents of the file (WILL raise a TooSmallText exception)
    //Note: path of the empty file may not be the same path that was specified in the command line by the time this exception is raised. 
    //If stopword not found in the text, allow one chance to re-specify the stopword and try to process the text again.
    // If they enter another stopword that can’t be found, report that to the user.
    public static void main(String[] args) {
        String A = args[0];//.split(" ");
        String stopWordString = null;
        try{
            stopWordString = args[1];

        }
        catch (IndexOutOfBoundsException i){
            stopWordString = null;

        }

       // for (int i = 0; i < A.length; i++)
         //   System.out.println(A[i]);
        Scanner sc = new Scanner(System.in);
        /*String temp = sc.next();//c.nextLine();
        String stopWordString = sc.next();//sc.nextLine();
        System.out.println(temp);

        System.out.println("Choose an option: \n 1: process a file \n 2: process your own text");
*/
        String temp = A;//[0];
        int input = sc.nextInt();
        

        
        System.out.println(input);
        while (input != 1 ){
            System.out.println("42543543");
            if (input != 2){
                System.out.println("invalid process choice. choose again");
                input = sc.nextInt();

                if (input == 1 || input == 2)
                    break;
            }
        }
        while (input!= 1 && input !=2){
            System.out.println("425435435443");

            if (input ==1)
                break;
            else{
                System.out.println("invalid process choice. choose again");
                input = sc.nextInt();  
                
                if (input == 1 || input == 2)
                    break;
            }
        }


       // if ((input ==1 || input ==2)) {
            //System.out.println("");
            if (input == 1){
       //         System.out.println("What is the file path?");
         //       String path = sc.next();
           //     System.out.println("Enter your stopword, or press enter to continue.");
             //   String stop = sc.next();
                try {
                    StringBuffer s = processFile(temp);
                    int count = processText(s, stopWordString);
                    System.out.println("Found " + count + " words.");

                }
                catch (EmptyFileException e){
                    System.out.println(e.toString());
                    /*System.out.println("One more chance. What is the file path?");
              //      String p = sc.next();
                //    System.out.println("Enter your stopword, or press enter to continue.");
                  //  String st = sc.next();
                    System.out.println("Choose an option: \n 1: process a file \n 2: process your own text");
                    int input2 = sc.nextInt();
                    String temp2 = sc.nextLine();
                    String stopWordString2 = sc.nextLine();
                    System.out.println(temp2);*/
          
                    /*try{
                    
                        StringBuffer sb2 = processFile(temp2);
                        int count = processText(sb2, stopWordString2);
                        System.out.println("Found " + count + " words");
                    }
                    catch (EmptyFileException et){
                        System.out.println(et.toString());
                    }
                    catch (InvalidStopwordException i){
                        System.out.println(i.toString());
                    }
                    catch (TooSmallText t){
                        System.out.println(t.toString());
                    }*/

                }
                catch (InvalidStopwordException i){
                    System.out.println(i.toString());
                }
                catch (TooSmallText t){
                    System.out.println(t.toString());
                }

            }
            else {

            }
        //} 

    //    else {
  ///          System.out.println("Please enter 1 or 2.");
 //           sc.nextLine();
   //     }
        //THIS IS WRONGGGGGGGGGGGGGG
        /*String stop = sc.nextLine();

        if (input == 1){

        }*/



    }



}

