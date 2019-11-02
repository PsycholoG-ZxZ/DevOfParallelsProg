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
    private Text aeroport_id;
    public KeyIDnBase(){
        this.aeroport_id = new Text();
        this.base = new IntWritable();
    }
    public KeyIDnBase(String id, int baseOut){
        this.aeroport_id = new Text(id.replace("\"", ""));
        this.base = new IntWritable( baseOut );
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

    public void write (DataOutput out) throws IOException{
        aeroport_id.write(out);
        base.write(out);
    }

    public int compareTo(KeyIDnBase keyNeitr) {
        int act = aeroport_id.compareTo(keyNeitr.getAeroport_id());
        if (act != 0)
            return act;
        return base.compareTo(keyNeitr.getBase());

    }



    @Override
    public String toString() {
        return " " + aeroport_id + " ";
    }
}
