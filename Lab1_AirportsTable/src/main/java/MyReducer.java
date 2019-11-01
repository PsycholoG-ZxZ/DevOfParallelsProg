import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class MyReducer extends Reducer <LongWritable, Text, LongWritable, Text>{
    protected void reduce (KeyIDnBase key, Iterable<Text> value, Context context) throws IOException,InterruptedException {
        Iterator<Text> iter = value.iterator();
        double Mid
        while (iter.hasNext()){

        }
    }
}
