package FlightDelaysPack;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Objects;

public class KeyIDnBase implements WritableComparable<KeyIDnBase> {
    //private IntWritable aeroport_id;
    private IntWritable base;
    //private int base;
    private Text aeroport_id;
    //private int aeroport_id, i;
    public KeyIDnBase(){

    }
    public KeyIDnBase(String id, int baseOut){
        aeroport_id = new Text(id);
        base = new IntWritable( baseOut );

    }

    public Text getAeroport_id(){
        return aeroport_id;
    }

    public IntWritable getBase(){
        return base;
    }

    public void readFields(DataInput in) throws IOException{
        aeroport_id.readFields(in);
        base.readFields(in);
    }

    public static int compare (int a, int b){
        return Integer.compare(a,b);
    }

    public void write (DataOutput out) throws IOException{
        aeroport_id.write(out);
        base.write(out);
    }

    public int compareTo(KeyIDnBase keyNeitr) {
        int act = aeroport_id.compareTo(keyNeitr.aeroport_id);
        if (act != 0)
            return act;
        return base.compareTo(keyNeitr.base);

    }

    //@Override
    //public String toString() {
     //   return " " + aeroport_id + " ";
    //}
}
