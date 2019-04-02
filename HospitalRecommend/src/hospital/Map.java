package hospital;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class Map extends Mapper<LongWritable, Text, Text, Text> {
	
	MultipleOutputs<Text, Text> out ;
	
	@Override
	protected void cleanup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		out.close();
	}

	public void map(LongWritable ikey, Text ivalue, Context context) throws IOException, InterruptedException {
		try {
			String s[] = ivalue.toString().split(",");
			System.out.println(ivalue.toString());
			Text k = new Text();
			Text v=  new Text();
			k.set(s[0]);
			v.set(s[1]+","+s[3]+","+s[4]);
			out.write(k, v,s[3]);
			
		} catch (Exception e) {
			System.out.println(e+" map");
			// TODO: handle exception
		}
	}


	@Override
	protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		out = new MultipleOutputs<>(context);
		
	}

	
}
