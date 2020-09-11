package kamofoke.tower;

import java.io.*;

public class WriteToFile {

    private static WriteToFile WriteToFile = null;
    private static BufferedWriter bufferedWriter = null;
    private static File file = new File("simulator.txt");
    private static FileWriter fileWriter = null;

    private WriteToFile(){}

    public static WriteToFile getWriteToFile()
    {
        if(WriteToFile == null)
        {
            try{
                WriteToFile = new WriteToFile();
                fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
            } catch(IOException e){}
        }
        return WriteToFile;
    }

    public void writeFile(String str)
    {
        try{
            bufferedWriter.write(str);
            bufferedWriter.newLine();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void close()
    {
        try{
            if(bufferedWriter != null)
            {
                bufferedWriter.close();
            }
        }
        catch (Exception ex)
        {
            System.out.println("Error closing file"+ex);
        }
    }
}
