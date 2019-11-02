package FlightDelaysPack;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

import java.io.IOException;

public class FlightMapper extends Mapper<LongWritable, Text, KeyIDnBase, Text>  {
    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException,InterruptedException {
        String data[] =Parser.parseSmall(value);
        if (data[17].equals("\"ARR_DELAY\"")) {return; }
        if (data[17].equals("")) {return; }
        String id = data[14];
        KeyIDnBase aKey = new KeyIDnBase(id.replace("\"", ""), 1);
        Text title = new Text(data[17]);
        context.write(aKey,title);
    }
}
