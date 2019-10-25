import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class KeyIDnBase implements WritableComparable<KeyIDnBase> {
    private IntWritable aeroport_id;
    private IntWritable base;

    public KeyIDnBase(){
        this.aeroport_id = -1;
        this.base = -1;
    }
    public KeyIDnBase(String id, int baseOut){
        this.aeroport_id = new IntWritable(Integer.parseInt(id.replace("\"", "")));
        this.base = new IntWritable( baseOut );
    }

    public int getAeroport_id(){
        return aeroport_id;
    }

    public int getBase(){
        return base;
    }

    public void readFields(DataInput in) throws IOException{

    }

    public void write (DataOutput out) throws IOException{
        aeroport_id.write();
    }

    public int compareTo(KeyIDnBase keyNeitr) {
        int act = aeroport_id.compareTo(keyNeitr.getAeroport_id());
        if (act != 0)
            return act;
        return base.compareTo(keyNeitr.getBase());

    }

}
