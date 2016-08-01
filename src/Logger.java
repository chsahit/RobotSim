import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class Logger {
	private static Writer writer;
	private String filename;
	
	public static void init() {
		init("datalog.csv");
	}
	
	public static void init(String filename) {
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filename), "utf-8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			writer = null;
			e.printStackTrace();
		}
	}
	
	public static void writeData(String data) {
		try {
			writer.write(data + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void writeData(float f) {
		writeData(f + "");
	}
	
	public static void close() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
