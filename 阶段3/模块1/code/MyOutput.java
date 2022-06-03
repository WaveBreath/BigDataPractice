package com.lhy.MR.Ranker;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class MyOutput extends FileOutputFormat<LongWritable,NullWritable>{

	@Override
	public RecordWriter<LongWritable, NullWritable> getRecordWriter(TaskAttemptContext arg0)
			throws IOException, InterruptedException {
			MyRecordWriter mrw=new MyRecordWriter();
			mrw.initialize(arg0, "/root/Project/output/rank.txt");
			return mrw;
	}
	
}
