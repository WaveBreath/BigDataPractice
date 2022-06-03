package com.lhy.MR.Ranker;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.mapreduce.RecordWriter;
import org.apache.hadoop.mapreduce.TaskAttemptContext;


public class MyRecordWriter extends RecordWriter<LongWritable,NullWritable>{

	private int counter=1;
	private FSDataOutputStream fdos=null;
	void initialize(TaskAttemptContext context, String outputPath){
		Configuration conf=context.getConfiguration();
		FileSystem fs;
		try {
			
			fs = FileSystem.get(conf);
			fdos=fs.create(new Path("/root/Projects/output/rank/rank.txt"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void close(TaskAttemptContext arg0) throws IOException, InterruptedException {
		if(fdos!=null)
			IOUtils.closeStream(fdos);
	}

	@Override
	public void write(LongWritable arg0, NullWritable arg1) throws IOException, InterruptedException {
		if(fdos!=null){
			fdos.writeBytes(""+counter+"\t"+arg0.get()+"\n");
			counter++;
		}
		
	}
	
}
