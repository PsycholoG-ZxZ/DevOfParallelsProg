import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

public class MyPartitioner extends Partitioner <KeyIDnBase, Text>{
        public int getPartition(K key, V value, int numReduceTasks) {
            return (KeyIDnBase.has & Integer.MAX_VALUE) % numReduceTasks;
        }