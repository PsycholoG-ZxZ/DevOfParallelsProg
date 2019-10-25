import org.apache.hadoop.io.WritableComparable;

public class KeyIDnBase implements WritableComparable<KeyIDnBase> {
    public int aeroport_id;
    public int base;

    public KeyIDnBase(){
        this.aeroport_id = new int();
        this.base = new int();
    }
    public KeyIDnBase(String id, int baseOut){
        this.aeroport_id = id.replace();
        this.base = baseOut;
    }

}
