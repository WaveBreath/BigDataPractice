package com.lhy.MR.Ranker;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.Reducer;

public class MyReducer extends Reducer<LongWritable,NullWritable,LongWritable,NullWritable>{
	@Override
	protected void reduce(LongWritable arg0, Iterable<NullWritable> arg1,
			Reducer<LongWritable, NullWritable, LongWritable, NullWritable>.Context arg2)
			throws IOException, InterruptedException {
			for(NullWritable nw:arg1)
				arg2.write(arg0, NullWritable.get());
	}
	
}
