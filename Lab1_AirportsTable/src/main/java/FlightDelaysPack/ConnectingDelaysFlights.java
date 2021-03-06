package FlightDelaysPack;

import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.conf.Configuration;

import javax.security.auth.login.AppConfigurationEntry;


public class ConnectingDelaysFlights{
    public static void main (String[] args) throws Exception {
        if (args.length != 3) System.exit(-1);

        Job job = Job.getInstance();
        Configuration conf = new Configuration();
        job.setJarByClass(ConnectingDelaysFlights.class);
        job.setJobName("Connecting");
        MultipleInputs.addInputPath(job, new Path(args[1]), TextInputFormat.class, FlightMapper.class);
        MultipleInputs.addInputPath(job, new Path(args[0]), TextInputFormat.class, AirportMapper.class);
        FileOutputFormat.setOutputPath(job, new Path(args[2]));
        Path outputPath = new Path(args[2]);
        job.setPartitionerClass(AirPartitioner.class);
        job.setGroupingComparatorClass(GroupingComparator.class);
        job.setReducerClass(AirportsReducer.class);
        job.setMapOutputKeyClass(KeyIDnBase.class);
        job.setOutputKeyClass(Text.class);

        job.setOutputValueClass(Text.class);


        job.setNumReduceTasks(2);
        outputPath.getFileSystem(conf);
        System.exit(job.waitForCompletion(true) ? 0 : 1);
    }
}
