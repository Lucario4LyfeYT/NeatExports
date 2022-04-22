import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
public class AvatarExportToDiscordFormat{
    public static void main (String [] args){
        Scanner fileReader = null;
        FileWriter myWriter = null;
        String cL = "";
        try{fileReader = new Scanner(new File("EMM.txt"));}catch(FileNotFoundException e){}
        if (fileReader!= null){
            try {myWriter = new FileWriter("ReadableEMM.txt");}catch (IOException e){}
            cL = fileReader.nextLine();
            while (true){
                if (fileReader.hasNext() == false) break;
                if (!cL.contains("avatar_id") && !cL.contains("avatar_name")){
                    cL = fileReader.nextLine();
                    continue;
                }
                else if (cL.contains("avatar_id"))
                    try{myWriter.write("Avatar ID:\n"+ cL.substring(16,cL.length()-2));}catch(IOException e){}
                else if (cL.contains("avatar_name"))
                    try{
                        myWriter.write("\nAvatar NAME: " + cL.substring(18,cL.length()-1) + "\n-----------------------------------------\n");
                    }
                    catch(IOException e){}
                try{myWriter.flush();}catch(IOException e){}
                cL = fileReader.nextLine();
            }
            fileReader = null;
        }
        try{fileReader = new Scanner(new File("ODIOUS.txt"));}catch(FileNotFoundException e){}
        if (fileReader!=null){
            try {myWriter = new FileWriter("ReadableODIOUS.txt");}catch (IOException e){}
            cL = fileReader.nextLine();
            while (true){
                if (fileReader.hasNext() == false) break;
                else if (cL.isEmpty()) cL = fileReader.nextLine();
                try{myWriter.write("Avatar ID: "+ cL.substring(0,41));}catch(IOException e){}
                cL=cL.substring(42,cL.length());
                try{myWriter.write("\nAvatar NAME: "+ cL.substring(0,cL.indexOf('|')));}catch(IOException e){}
                cL=cL.substring(cL.indexOf('|')+1,cL.length());
                int c = cL.indexOf("avtr_");
                if (c == -1) c=cL.length();
                if (cL.startsWith("https://")){
                    try{
                        myWriter.write("\nImageURL: "+ cL.substring(0,c) + "\n----------------------------------------------------------------------------------------------\n");
                    }
                    catch(IOException e){}
                    try{myWriter.flush();}catch(IOException e){}
                    cL=cL.substring(c,cL.length());
                }
            }
        }
        System.exit(0);
    }
}