package FlightDelaysPack;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator{
    protected GroupingComparator() {
        super(KeyIDnBase.class, true);
    }

    public int compare (WritableComparable ComparablePairFrst, WritableComparable ComparablePairSec){
        KeyIDnBase CP_Frst = (KeyIDnBase)ComparablePairFrst;
        KeyIDnBase CP_Sec = (KeyIDnBase)ComparablePairSec;
        return CP_Frst.getAeroport_id().compareTo( CP_Sec.getAeroport_id());
    }
}
