package view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.EventObject;

import model.AnyData;

public class OperEvent extends EventObject{
	private AnyData name;
	private String time;
	private String operation;
	
	public OperEvent(Object source, String operation, AnyData name) {
		super(source);
		this.name = name;
		this.operation = operation;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
		this.time = dtf.format(LocalDateTime.now());
	}
	
	public AnyData getOperation() {
		return name;
	}
	
	public String getTime() { 
		return time;
	}

	@Override
	public String toString() {
		return time + " " + operation + " " + name;
	}
}
