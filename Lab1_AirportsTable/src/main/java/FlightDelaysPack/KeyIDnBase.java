package FlightDelaysPack;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class KeyIDnBase implements WritableComparable<KeyIDnBase> {
    //private IntWritable aeroport_id;
    //private IntWritable base;
    int aeroport_id;
    int base;

    public KeyIDnBase(){
    //    this.aeroport_id = new IntWritable();
    //    this.base = new IntWritable();

    }
    public KeyIDnBase(String id, int baseOut){
        //this.aeroport_id = new IntWritable(Integer.parseInt(id.replace("\"", "")));
        //this.base = new IntWritable( baseOut );
        aeroport_id = Integer.parseInt(id);
        base = baseOut;
    }

    public int getAeroport_id(){
        return aeroport_id;
    }

    public int getBase(){
        return base;
    }

    public void readFields(DataInput in) throws IOException{
      //  aeroport_id.readFields(in);
       // base.readFields(in);
        aeroport_id = in.readInt();
        base = in.readInt();
    }

    public void write (DataOutput out) throws IOException{
        //aeroport_id.write(out);
        //base.write(out);
        out.writeInt(aeroport_id);
        out.writeInt(base);
    }

    public int compareTo(KeyIDnBase keyNeitr) {
        //int act = aeroport_id.compareTo(keyNeitr.getAeroport_id());
        int act = 0;
        if (aeroport_id== keyNeitr.getAeroport_id()){
            act = 0;
        }
        if (aeroport_id > keyNeitr.getAeroport_id()){
            act = 1;
        }
        if (aeroport_id== keyNeitr.getAeroport_id()){
            act = 0;
        }


        if (act != 0)
            return act;
        return base.compareTo(keyNeitr.getBase());

    }

}
