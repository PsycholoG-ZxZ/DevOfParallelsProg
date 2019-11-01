package FlightDelaysPack;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class AirportMapper extends Mapper<LongWritable, Text, KeyIDnBase, Text> {

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException,InterruptedException {
        String data[] =Parser.parseIdDescr(value);
        String id = data[0];
        if (id.equals("Code,Description")) {return; }
        KeyIDnBase aKey = new KeyIDnBase(id, 0);
        Text title = new Text(data[1]);
        context.write(aKey,title);

    }
}
