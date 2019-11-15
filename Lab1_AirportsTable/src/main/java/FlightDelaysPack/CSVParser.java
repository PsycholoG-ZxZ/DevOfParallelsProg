package FlightDelaysPack;

import org.apache.hadoop.io.Text;

private static String FRST_TABLE="Code,Description";

public class CSVParser {
    public static String[] parseIdDescr(Text str) {
        String[] data = str.toString().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        return data;
    }
    public static String[] parseSmall(Text str) {
        String[] data = str.toString().split(",");
        return data;

    }


    public static boolean CheckStringFrstCsv(Text str) {
            return id.equals("Code,Description");
    }



}
