import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

public class KeyIDnBase implements WritableComparable<KeyIDnBase> {
    public int aeroport_id;
    public int base;

    public KeyIDnBase(){
        this.aeroport_id = -1;
        this.base = -1;
    }
    public KeyIDnBase(String id, int baseOut){
        this.aeroport_id = Integer.parseInt(id.replace("\"", ""));
        this.base = baseOut;
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

    }

    public int compareTo (KeyIDnBase keyNeitr) {
        int act = aeroport_id.compareTo(keyNeitr.getAeroport_id());
        if (act != 0)
            return act;
        return 

    }

}
