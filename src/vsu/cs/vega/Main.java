package vsu.cs.vega;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {
    public static void main(String[] args)  {
        String error = "You entered a non-rectangular matrix, please check the data and re-enter.";
        try{
        Solution output = new Solution();


            output.readMtx();
        }
        catch (ArrayIndexOutOfBoundsException exception){
            System.err.print(error);
        }
        catch (IOException ex){
            System.out.println("not work");
        }


    }
}