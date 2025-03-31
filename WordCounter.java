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
            System.out.println("DEBUG: WHAT IS WORD?" + word);
            if(word.equals(stopword)){
                found = true;
                //break;
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
                //throw new InvalidStopwordException("Couldn't find stopword: " + stopword);


            }
     //       else //if (!found){
               // System.out.println("DEBUG 1: " + new InvalidStopwordException("Couldn't find stopword " + stopword));
        //        throw new InvalidStopwordException("Couldn't find stopword: " + stopword);
            //}
       //     else if (count < 5 )
              //  throw new TooSmallText("Only found " + count + " words.");
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
        boolean empty = true;
       // BufferedReader aas = new BufferedReader(new FileReader(new File(path)));

       File file = new File(path);
       System.out.println(file.length());
       if (file.length() == 0){
        throw new EmptyFileException(path + " was empty");
       }
        

        try (BufferedReader br = new BufferedReader(new FileReader(new File(path)))){
            empty = false;
            sb.append(br.readLine());
            System.out.println(sb.toString());

            System.out.println(empty);
            System.out.println(sb.toString());

            if (sb.toString().equals(null)){
                System.out.println("what");
                throw new EmptyFileException(path + " was empty");
            }
            System.out.println("123 help");

  
        }
        catch (FileNotFoundException i){
            //throw new IOException("yo");
            System.out.println("1233 help");
            throw new EmptyFileException(path + " was empty");
        }
        catch (IOException a){
            System.out.println("sfasdoafjd");
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
        Scanner sc = new Scanner(System.in);

      //  try{

       // }
    }



}

