package com.sandwich.util.io;

import java.io.File;
import java.io.IOException;

public class FileCompiler {
	
	public static final String JAVA_SUFFIX = ".java";
	public static final String CLASS_SUFFIX = 	".class";

	public static void compile(String src, String bin) throws IOException {
		compile(new File(src), new File(bin));
	}

	public static void compile(File src, File bin, final String...classpath) throws IOException {
		final File destinationDirectory = bin;
		if(!destinationDirectory.exists()){
			if(!destinationDirectory.mkdir()){
				System.out.println("Was unable to create: "+destinationDirectory);
				System.exit(-231);
			}
		}
		FileUtils.forEachFile(src, bin, new FileCompilerAction(destinationDirectory, classpath));
	}
	
}
