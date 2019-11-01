import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitioner extends Partitioner <KeyIDnBase, Text>{
        public int getPartition(KeyIDnBase key, Text value, int numReduceTasks) {
            return (KeyIDnBase.hashCode() & Integer.MAX_VALUE) % numReduceTasks;
        }