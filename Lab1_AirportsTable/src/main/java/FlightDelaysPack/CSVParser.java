package FlightDelaysPack;

import org.apache.hadoop.io.Text;

public class CSVParser {
    public static String[] parseIdDescr(Text str) {
        String[] data = str.toString().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        return data;
    }
    public static String[] parseSmall(Text str) {
        String[] data = str.toString().split(",");
        return data;
    }





}
