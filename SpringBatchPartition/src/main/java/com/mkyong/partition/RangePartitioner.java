package com.mkyong.partition;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.core.partition.support.Partitioner;
import org.springframework.batch.item.ExecutionContext;

public class RangePartitioner implements Partitioner {

	private final String CLASS_NAME = "RangePartitioner";
	/*private String inputFile = "C:\\ECOS_NAS\\data\\TowingInvoice.txt";*/
	private String inputFile ;

	public String getInputFile() {
		return inputFile;
	}

	public void setInputFile(String inputFile) {
		this.inputFile = inputFile;
	}

	@Override
	public Map<String, ExecutionContext> partition(int gridSize) {
		// TODO Auto-generated method stub
		String MTD_NAME = "partition";
		// int limit = 0;
		List<String> fileStream = null;
		Map<String, ExecutionContext> exeCtxMap = new HashMap<String, ExecutionContext>();
		try {
			fileStream = getFlatFileLines();
			gridSize = fileStream.size();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println(CLASS_NAME + " | " + MTD_NAME + " | Error occured while getGridSize " + e);
			/*
			 * logger.error(CLASS_NAME + " | " + MTD_NAME +
			 * " | Error occured while getGridSize ", e);
			 */
		}
		for (int i = 0; i < gridSize; i++) {
			ExecutionContext exeCtx = new ExecutionContext();
			exeCtx.putString("INPUT_LINE", fileStream.get(i));
			exeCtx.putInt("THREAD", i+1);
			exeCtx.putInt("isRead", 0);
			exeCtxMap.put("PARTITION_ID" + i, exeCtx);
		}
		System.out.println(CLASS_NAME + " | " + MTD_NAME + " | Total worker thread created for " + exeCtxMap.size());
		/*
		 * logger.info(CLASS_NAME + " | " + MTD_NAME +
		 * " | Total worker thread created for " + exeCtxMap.size());
		 */
		printExeCtx(exeCtxMap);
		return exeCtxMap;
	}

	private void printExeCtx(Map<String, ExecutionContext> exeCtxMap) {
		for (Map.Entry<String, ExecutionContext> entry : exeCtxMap.entrySet()) {
			String key = entry.getKey();
			ExecutionContext exeCtx = entry.getValue();
			System.out.println("key=" + key + " ;THREAD=" + exeCtx.get("THREAD") + "\n" + "INPUT_LINE="
					+ exeCtx.get("INPUT_LINE"));
		}
	}

	private List<String> getFlatFileLines() throws IOException {
		String MTD_NAME = "getGridSize";
		String fileName = getInputFile();
		fileName = fileName.replace("file:", "");
		List<String> fileStream = Files.readAllLines(Paths.get(fileName));
		int lines = fileStream.size();
		System.out.println(
				CLASS_NAME + " | " + MTD_NAME + " | Total no of lines found " + lines + " in file = " + fileName);
		/*
		 * logger.info(CLASS_NAME + " | " + MTD_NAME +
		 * " | Total no of lines found " + lines + " in file = "+fileName);
		 */
		return fileStream;
	}

	private void readLineByLineNo() throws IOException {
		String MTD_NAME = "getGridSize";
		Map<Integer, String> exeCtxMap = new HashMap<Integer, String>();
		LineNumberReader lineNumberReader = null;
		String fileName = getInputFile();
		fileName = fileName.replace("file:", "");
		// Construct the LineNumberReader object
		lineNumberReader = new LineNumberReader(new FileReader(fileName));
		String line = null;
        while ((line = lineNumberReader.readLine()) != null)
        {
           System.out.println("Line " + lineNumberReader.getLineNumber() + ": " + line);
        }
	}

}
