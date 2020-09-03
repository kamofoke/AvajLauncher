
import java.io.*;

public class WriteToFile {
    
    private static WriteToFile writeToFile = null;
    private static BufferedWriter bufferedWriter = null;
    private static File file = null;
    private static FileWriter fileWriter = null;

    private WriteToFile(){}

    public static WriteToFile getWriteToFile()
    {
        if(writeToFile == null)
        {
            try{
                writeToFile = new WriteToFile();
                file = new File("simulator.txt");
                fileWriter = new FileWriter(file);
                bufferedWriter = new BufferedWriter(fileWriter);
            } catch(IOException e){}
        }
        return writeToFile;
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
            System.out.println("Error in closing the file"+ex);
        }
    }

}
