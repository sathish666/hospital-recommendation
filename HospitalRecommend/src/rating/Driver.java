package rating;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Driver {

	public static void main(String[] args) throws Exception {
		Configuration conf = new Configuration();
		conf.set("fs.default.name", "hdfs://localhost:9000");
		FileSystem fs = FileSystem.get(conf);
		Path p  = new Path("hdfs://localhost:9000/a2");
		if(fs.exists(p)) {
			fs.delete(p);
		}
		
		Job job = Job.getInstance(conf, "JobName");
		job.setJarByClass(rating.Driver.class);
		// TODO: specify a mapper
		job.setMapperClass(Map.class);
		// TODO: specify a reducer
		job.setReducerClass(Reduce.class);

		// TODO: specify output types
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		FileStatus fs1[] = fs.listStatus(new Path("hdfs://localhost:9000/a1"));
		
		
		for(FileStatus fs2 : fs1) {
		Path p1 =	fs2.getPath();
		if(p1.toString().toLowerCase().contains("_success")) {
			
		}else {
			MultipleInputs.addInputPath(job, p1, TextInputFormat.class, Map.class);
		}
		}
		// TODO: specify input and output DIRECTORIES (not files)
//		FileInputFormat.setInputPaths(job, new Path("hdfs://localhost:9000/a1/Bone diseases-m-00000"));
		FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:9000/a2"));

		if (!job.waitForCompletion(true))
			return;
	}

}
