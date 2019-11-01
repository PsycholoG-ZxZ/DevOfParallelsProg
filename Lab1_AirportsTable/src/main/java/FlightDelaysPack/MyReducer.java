package FlightDelaysPack;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;
import java.util.Iterator;

public class MyReducer extends Reducer <LongWritable, Text, Text, Text>{
    protected void reduce (KeyIDnBase key, Iterable<Text> value, Context context) throws IOException,InterruptedException {
        Iterator<Text> iter = value.iterator();
        double MidDelay = 0;
        double HighDelay = 0;
        double LowDelay = 9999999;
        double sum = 0;
        int i = 0;
        while (iter.hasNext()){
            String iteration = iter.next().toString();
            if (iteration == " "){break;}
            double delay = Double.parseDouble(iteration);
            sum += delay;
            i++;
            if (HighDelay <= delay){
                HighDelay = delay;
            }
            if (LowDelay >= delay){
                LowDelay = delay;
            }
        }
        if (sum > 0){
            MidDelay = sum / i;
            String output = "Min: " + LowDelay + " Mid: " + MidDelay + " Max: " + HighDelay;
            Text outputText = new Text (output);
                iter = value.iterator();
            Text ID = new Text (iter.next());
            context.write (ID, outputText);
        }
    }
}
