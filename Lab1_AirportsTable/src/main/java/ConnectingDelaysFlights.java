import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

public class ConnectingDelaysFlights{
    public static void main (String[] args) throws Exception {
        if (args.length != 2) System.exit(-1);

        Job job = Job.getInstance();
        job.setJarByClass(ConnectingDelaysFlights.class);
        job.setJobName("Connecting");
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, AirportMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, FlightMapper.class);
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(ConnectingDelaysFlights.class);
        job.setGroupingComparatorClass(GroupingComparator.class);
        job.setNumReduceTasks(2);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
