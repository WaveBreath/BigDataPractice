package com.lhy.MR.Ranker;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class MyMapper extends Mapper<LongWritable,Text,LongWritable,NullWritable> {
		


	@Override
	protected void map(LongWritable key, Text value,
			Mapper<LongWritable, Text, LongWritable, NullWritable>.Context context)
			throws IOException, InterruptedException {
			context.write(new LongWritable(Long.parseLong(value.toString())), NullWritable.get());//将数字变成key，排序交给shuffer
	}
}
