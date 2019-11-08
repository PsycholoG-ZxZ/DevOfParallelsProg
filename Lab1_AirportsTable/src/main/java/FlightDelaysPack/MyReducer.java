package FlightDelaysPack;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class MyReducer extends Reducer <LongWritable, Text, Text, Text>{
    protected void reduce (KeyIDnBase key, Iterable<Text> value, Context context) throws IOException,InterruptedException {
        Iterator<Text> iter = value.iterator();
        Text ID = new Text (iter.next());
        double MidDelay = 0;
        double HighDelay = 0;
        double LowDelay = 9999999;
        double sum = 0;
        int i = 0;
        while (iter.hasNext()){
            double delay = Double.parseDouble(iter.next().toString(););
            if (HighDelay <= delay){
                HighDelay = delay;
            }
            if (LowDelay >= delay){
                LowDelay = delay;
            }
            sum += delay;
            i++;

        }
        if (i == 0){ return;}
            MidDelay = sum / i;
            String output = "Min: " + LowDelay + " Mid: " + MidDelay + " Max: " + HighDelay;
            Text outputText = new Text (output);
            //ID = new Text ("TestPatch");
            //outputText = new Text ("123");

        context.write (new Text (ID), outputText);

    }
}
