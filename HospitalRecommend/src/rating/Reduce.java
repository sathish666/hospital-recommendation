package rating;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.output.MultipleOutputs;

public class Reduce extends Reducer<Text, Text, Text, Text> {
	
	
MultipleOutputs<Text, Text> out ;

	


	@Override
protected void setup(Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
	out = new MultipleOutputs<>(context);
}



	public void reduce(Text _key, Iterable<Text> values, Context context) throws IOException, InterruptedException {
		// process values
	try {	int r1 = 0;
		int r2 = 0; 
		int r3 = 0;
		int r4 = 0;
		int r5 = 0;
		System.out.println("dsfl;fsdl;");
		String f ="";
		for (Text val : values) 
		{ 
			String v = val.toString();
			System.out.println(v);
			String s[] = v.split(":");
			r1 = r1+ Integer.parseInt(s[0]);
			r2 = r2+ Integer.parseInt(s[1]);
			r3 = r3+ Integer.parseInt(s[2]);
			r4 = r4+ Integer.parseInt(s[3]);
			r5 = r5+ Integer.parseInt(s[4]);
			f = s[5];
			
		}
		
		out.write(_key, new Text(r1+" "+r2+" "+r3+" "+r4+" "+r5),f);
	

	}catch (Exception e) {
		// TODO: handle exception
		System.out.println(e);
		e.printStackTrace();
	}
	
  }



	@Override
	protected void cleanup(Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
		out.close();
	}


}