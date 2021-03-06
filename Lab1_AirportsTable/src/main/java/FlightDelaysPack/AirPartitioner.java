package FlightDelaysPack;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class AirPartitioner extends Partitioner <KeyIDnBase, Text> {
    public int getPartition(KeyIDnBase key, Text value, int numReduceTasks) {
        return (key.getAeroport_id().hashCode() & Integer.MAX_VALUE) % numReduceTasks;
    }
}