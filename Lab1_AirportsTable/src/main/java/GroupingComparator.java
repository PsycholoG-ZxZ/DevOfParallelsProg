import org.apache.hadoop.io.WritableComparator;

public class GroupingComparator extends WritableComparator{
    public GroupingComparator() {
        super (KeyIDnBase.class, true);
    }
    @Override
    public int compare (WritableComparator)
}
