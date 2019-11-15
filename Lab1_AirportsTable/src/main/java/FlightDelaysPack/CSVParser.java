package FlightDelaysPack;

import org.apache.hadoop.io.Text;

private static String FRST_TABLE="Code,Description";
private static String SEC_TABLE="\"ARR_DELAY\"";


public class CSVParser {
    public static String[] parseIdDescr(Text str) {
        String[] data = str.toString().split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");
        return data;
    }
    public static String[] parseSmall(Text str) {
        String[] data = str.toString().split(",");
        return data;

    }


    public static boolean CheckStringFrstCsv(String id) {
            return id.equals("Code,Description");
    }



}
