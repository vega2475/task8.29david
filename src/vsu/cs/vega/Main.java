package vsu.cs.vega;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Solution output = new Solution();
        String error = "You entered a non-rectangular matrix, please check the data and re-enter.";
        try {
            output.readMtx();
        }
        catch (ArrayIndexOutOfBoundsException exception){
            System.err.print(error);
        }


    }
}