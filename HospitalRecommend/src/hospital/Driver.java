package hospital;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Partitioner;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;



class a extends Partitioner<Text, Text >{

	@Override
	public int getPartition(Text key, Text value, int n) {
		// TODO Auto-generated method stub
		
		
		
		return 0;
	}
	
	
}
public class Driver {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://localhost:9000");
		FileSystem fs = FileSystem.get(conf);
		Path p  = new Path("hdfs://localhost:9000/a1");
		if(fs.exists(p)) {
			fs.delete(p);
		}
		Job job = Job.getInstance(conf, "JobName");
		job.setJarByClass(hospital.Driver.class);
		// TODO: specify a mapper
		job.setMapperClass(Map.class);
		// TODO: specify a reducer
		job.setReducerClass(Reduce.class);

		// TODO: specify output types
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);

		// TODO: specify input and output DIRECTORIES (not files)
		FileInputFormat.setInputPaths(job, new Path("hdfs://localhost:9000/a"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:9000/a1"));

		if (!job.waitForCompletion(true))
			return;
	}

}
