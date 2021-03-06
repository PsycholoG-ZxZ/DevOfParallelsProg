package FlightDelaysPack;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, KeyIDnBase, Text> {

    private static int ID_AIR = 0 , DESCR = 1, FRST_TABLE_ID = 0;

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException,InterruptedException {
        String data[] =CSVParser.parseIdDescr(value);
        String id = data[ID_AIR];
        if (CSVParser.CheckStringFrstCsv(id)) {
        return;
        }
        KeyIDnBase aKey = new KeyIDnBase(CSVParser.RemoveSlash(id), FRST_TABLE_ID);
        Text title = new Text(data[DESCR]);
        context.write(aKey,title);

    }
}