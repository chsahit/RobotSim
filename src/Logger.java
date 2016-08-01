import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;

public class Logger {
	private Writer writer;
	String filename;
	public Logger() {
		this("datalog.csv");
	}
	
	public Logger(String filename) {
		this.filename = filename;
	}
	
	public void init() {
		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filename), "utf-8"));
		} catch (UnsupportedEncodingException | FileNotFoundException e) {
			writer = null;
			e.printStackTrace();
		}
	}
	
	public void writeData(String data) {
		try {
			writer.write(data + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void writeData(float f) {
		writeData(f + "");
	}
	
	public void close() {
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
