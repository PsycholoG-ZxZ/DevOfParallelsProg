package FlightDelaysPack;

import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator{
    public GroupingComparator() {
        super (KeyIDnBase.class, true);
    }
    @Override
    public int compare (WritableComparable ComparablePairFrst, WritableComparable ComparablePairSec){
        KeyIDnBase CP_Frst = (KeyIDnBase) ComparablePairFrst;
        KeyIDnBase CP_Sec = (KeyIDnBase) ComparablePairSec;
        //return CP_Frst.getAeroport_id().compareTo(CP_Sec.getAeroport_id());
        if (CP_Frst.aeroport_id == CP_Sec.getAeroport_id()) return 0;
        if (CP_Frst.aeroport_id > CP_Sec.getAeroport_id()) return 1;
        if (CP_Frst.aeroport_id < CP_Sec.getAeroport_id()) return -1;
        return 0;
    }
}
