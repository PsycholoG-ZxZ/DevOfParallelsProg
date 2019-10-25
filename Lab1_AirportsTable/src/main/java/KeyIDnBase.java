import org.apache.hadoop.io.WritableComparable;

import java.io.DataInput;

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

    public void write (DataInput)

}
