package edu.adams.backendboys;

import java.util.ArrayList;


public abstract class Database {

	public abstract Boolean insert(String table,String[] data);
	
	public abstract ArrayList<ArrayList<String>> select(String table,String[] data);
	
	public abstract Boolean update(String table,String[] updatedData,String[] searchData);
	
	public abstract Boolean delete(String table,String[] data);
	
}


