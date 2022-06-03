package com.lhy.MR.Ranker;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.CombineTextInputFormat;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyDriver {
	
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		Configuration conf=new Configuration();
		Job rank=Job.getInstance(conf,"rank numbers");
		rank.setJarByClass(MyDriver.class);
		rank.setMapperClass(MyMapper.class);
		rank.setReducerClass(MyReducer.class);

		rank.setMapOutputKeyClass(LongWritable.class);
		rank.setMapOutputValueClass(NullWritable.class);

		rank.setOutputKeyClass(LongWritable.class);
		rank.setOutputValueClass(NullWritable.class);
		

		CombineTextInputFormat.setMaxInputSplitSize(rank, 1<<20);
		rank.setInputFormatClass(CombineTextInputFormat.class);
		rank.setOutputFormatClass(MyOutput.class);
		FileInputFormat.setInputPaths(rank,new Path("/root/Projects/input/rank"));
        FileOutputFormat.setOutputPath(rank,new Path("/root/Projects/output/rank"));
		boolean ret=rank.waitForCompletion(true);
		System.exit(ret?0:-1);
	}
}