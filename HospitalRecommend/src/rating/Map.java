package rating;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;
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
			
			int r1 = 0;
			int r2 = 0;
			int r3 = 0;
			int r4 = 0;
			int r5 = 0;
			
			String s[] = ivalue.toString().split("\t");
			String k = s[0];
			String val = s[1];
			System.out.println(ivalue.toString());
			String val1[] = val.split(",");
			String rate = val1[2];
			String filename = val1[1];
			
			if(rate.equals("1")) {
				r1++;
			}else if(rate.equals("2")) {
				r2++;
			}else if(rate.equals("3")){
				r3++;
			}else if(rate.equals("4")){
				r4++;
			}else if(rate.equals("4")){
				r4++;
			}
			Text t = new Text();
			Text t1 = new Text();
			t.set(r1+":"+r2+":"+r3+":"+r4+":"+r5+":"+filename);
			t1.set(k);
			context.write(t1, t);
			
			
			
			
//			k, r1+" "+r2+" "+r3+" "+r4+" "+r5		1	1 0 0 0 0 0 
//													1	1 0 0 0 0 0
			
//												    1	2 0 0 0 0 
			
		} catch (Exception e) {
			System.out.println(e+" map");
			e.printStackTrace();
			// TODO: handle exception
		}
	}


	@Override
	protected void setup(Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		out = new MultipleOutputs<>(context);
		
	}

	
}
