package edu.adams.backendboys;

public abstract class Database {

	public abstract Boolean insert(String table,String[] data);
	
	public abstract String[] select(String table,String[] data);
	
	public abstract Boolean update(String table,String[] data);
	
}
