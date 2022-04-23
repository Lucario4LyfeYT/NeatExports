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
            try {myWriter = new FileWriter("NeatEMM.txt");}catch (IOException e){}
            cL = fileReader.nextLine();
            while (true){
                if (!fileReader.hasNext()) break;
                if (!cL.contains("avatar_id") && !cL.contains("avatar_name")){
                    cL = fileReader.nextLine();
                    continue;
                }
                else if (cL.contains("avatar_id"))
                    try{myWriter.write("Avatar ID: "+ cL.substring(16,cL.length()-2));}catch(IOException e){}
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
            try {myWriter = new FileWriter("NeatODIOUS.txt");}catch (IOException e){}
            cL = fileReader.nextLine();
            while (true){
                if (!fileReader.hasNext()) break;
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
            fileReader = null;
        }
        try{fileReader = new Scanner(new File("FavCatRestored.txt"));}catch(FileNotFoundException e){}
        if (fileReader!=null){
            try {myWriter = new FileWriter("NeatFavCatRestored.txt");}catch (IOException e){}
            cL = fileReader.nextLine();
            while (true){
                if (!fileReader.hasNextLine()){break;}
                try{myWriter.write("Avatar ID: "+ cL.substring(0,41));myWriter.flush();}catch(IOException e){}
                cL=cL.substring(42,cL.length());
                try{myWriter.write("\nAvatar Name: "+ cL.substring(0,cL.lastIndexOf("by")-1));myWriter.flush();}catch(IOException e){}
                cL=cL.substring(cL.lastIndexOf("by")+2,cL.length());
                try{myWriter.write("\nAuthor Name:"+ cL + "\n----------------------------------------------------\n");myWriter.flush();}catch(IOException e){}
                cL = fileReader.nextLine();
            }
            try{myWriter.write("Avatar ID: "+ cL.substring(0,41));myWriter.flush();}catch(IOException e){}
            cL=cL.substring(42,cL.length());
            try{myWriter.write("\nAvatar Name: "+ cL.substring(0,cL.lastIndexOf("by")-1));myWriter.flush();}catch(IOException e){}
            cL=cL.substring(cL.lastIndexOf("by")+2,cL.length());
            try{myWriter.write("\nAuthor Name:"+ cL + "\n----------------------------------------------------");myWriter.flush();}catch(IOException e){}
            fileReader = null;
        }
        System.exit(0);
    }
}
