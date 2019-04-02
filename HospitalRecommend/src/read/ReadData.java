package read;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.commons.collections.map.HashedMap;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.mapreduce.lib.input.MultipleInputs;
import org.apache.hadoop.mapreduce.lib.input.TextInputFormat;

import rating.Map;

public class ReadData {
	public static ArrayList<String> read(String path) {
		ArrayList<String> hs = new ArrayList<>();
		try {
			
			Configuration conf = new Configuration();
			conf.set("fs.default.name", "hdfs://localhost:9000");
			FileSystem fs = FileSystem.get(conf);
			FileStatus fs1[] = fs.listStatus(new Path("hdfs://localhost:9000/a2"));
			
			
			for(FileStatus fs2 : fs1) {
			Path p1 = fs2.getPath();
			
			if(p1.toString().toLowerCase().contains(path.toLowerCase())) {
				
				InputStreamReader ir = new InputStreamReader(fs.open(p1));
				BufferedReader br =new BufferedReader(ir);
				String s ="";
				while((s=br.readLine())!=null) {
					
				
				
				System.out.println(s);
				String s1[] =s.split("\t");
				String s2[] =s1[1].split(" ");
				
				int low = 0;
				int high = 0;
				
				int r1 = Integer.parseInt(s2[0]);
				int r2 = Integer.parseInt(s2[1]);
				
				int r4 = Integer.parseInt(s2[3]);
				int r5 = Integer.parseInt(s2[4]);
				
				low = r1+r2;
				high = r4+r5;
				if(low<high) {
					
					hs.add(s1[0]);
				}else if(low==high) {
					hs.add(s1[0]);
				}
				
			
				
				}
			}
			
			}
			
			
			
			
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
			// TODO: handle exception
		}
		
		return hs;
		
	}
	public static void main(String args[]) {
	ArrayList<String>	al = read("Cancer");
	System.out.println(al.size());
	for(String s1 : al) {
		System.out.println(s1);
		System.out.println("sdfjkdsf");
	}
	}
}
