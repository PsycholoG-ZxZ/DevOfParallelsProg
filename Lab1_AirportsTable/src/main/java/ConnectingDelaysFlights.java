import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;

public class ConnectingDelaysFlights{
    public static void main (String[] args) throws Exception {
        if (args.length != 2) System.exit(-1);

        Job job = Job.getInstance();
        job.setJarByClass(ConnectingDelaysFlights.class);
        job.setJobName("Connecting");
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(ConnectingDelaysFlights.class);
        job.setGroupingComparatorClass(GroupingComparator.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
