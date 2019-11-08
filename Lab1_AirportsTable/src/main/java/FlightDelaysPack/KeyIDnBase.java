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
        aeroport_id = new Text()
        base = baseOut;

    }

    public int getAeroport_id(){
        return aeroport_id;
    }

    public int getBase(){
        return base;
    }

    public void readFields(DataInput in) throws IOException{
        aeroport_id = in.readInt();
        base = in.readInt();
    }

    public static int compare (int a, int b){
        return Integer.compare(a,b);
    }

    public void write (DataOutput out) throws IOException{
        out.write(aeroport_id);
        out.write(base);
    }

    public int compareTo(KeyIDnBase keyNeitr) {
        int act = compare(aeroport_id,keyNeitr.aeroport_id);
        if (act != 0)
            return act;
        return compare(base,keyNeitr.base);

    }

    @Override
    public String toString() {
        return " " + aeroport_id + " ";
    }
}
