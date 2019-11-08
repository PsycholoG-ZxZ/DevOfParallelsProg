package FlightDelaysPack;

import org.apache.hadoop.io.Text;

public class MyParser {
    public static String[] parseIdDescr(Text str) {
        //String[] data = str.toString().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        //String[] data = str.toString().split(",", 2);
        //String[] data = str.toString().split(",(?=\")");
        return data;
    }
    public static String[] parseSmall(Text str) {
        String[] data = str.toString().split(",");
        return data;
    }




}
