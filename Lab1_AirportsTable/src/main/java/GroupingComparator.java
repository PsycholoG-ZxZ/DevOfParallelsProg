import org.apache.hadoop.io.WritableComparable;
import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator{
    public GroupingComparator() {
        super (KeyIDnBase.class, true);
    }
    @Override
    public int compare (WritableComparable ComparablePairFrst, WritableComparable ComparablePairSec){
            return 0;
    }
}
