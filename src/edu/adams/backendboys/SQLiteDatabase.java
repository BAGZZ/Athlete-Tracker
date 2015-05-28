package edu.adams.backendboys;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLiteDatabase extends Database {
	public static int MAXNUMBEROFTRIES =5;
	public static int MAXWAIT=1000/4;
	Connection connectionToDatabase=null;
	Statement statement=null;
	String databaseLocation ="S:\\AthleteTracker\\ASUAthleteTracker.db";
	
	public SQLiteDatabase() {
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Insert format first index in array is the list of data fields Ex (ID,Name,Age,Address) 
	//the rest of the indices  are the values followed by commas Ex. "1," "Zach," "21,"210 Edgemont Blvd Alamosa, CO 81101"
	@Override
	public Boolean insert(String table, String[] data) {
		String sql = "";
		connectionToDatabase=connect();
		if(connectionToDatabase!=null){
			try {
				statement=connectionToDatabase.createStatement();
				statement.setQueryTimeout(5);
				sql="INSERT INTO "+table+" "+data[0]+"VALUES (";
				for(int count=1; count<data.length; count++){
					sql+=data[count];
				}
				sql+=");";
				statement.executeUpdate(sql);
				connectionToDatabase.commit();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				disconnect();
			}
			return true;
		}else{
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<ArrayList<String>> select(String table, String[] data) {
		String sql = "";
		ResultSet results= null;
		ArrayList<String> temp;
		ArrayList<ArrayList<String>> output = new ArrayList<ArrayList<String>>();
		connectionToDatabase=connect();
		if(connectionToDatabase!=null){
			try {
				statement=connectionToDatabase.createStatement();
				statement.setQueryTimeout(5);
				sql="SELECT * FROM "+table+" WHERE ";
				for(String pair : data){
					sql+=pair;
				}
//*/
				results = statement.executeQuery(sql);	
				int numberOfColumns = results.getMetaData().getColumnCount();
				try {
					while (results.next()){
						temp = new ArrayList<String>();
						for(int columnIndex =1; columnIndex<=numberOfColumns;columnIndex++){
							temp.add(results.getString(columnIndex));
						}
						output.add(new ArrayList<String>(temp));
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				try {
					results.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				disconnect();
			}
			return output;
		}else{
			return null;
		}
	}

	@Override
	public Boolean update(String table, String[] updatedData, String[] searchData) {
		String sql = "";
		connectionToDatabase=connect();
		if(connectionToDatabase!=null){
			try {
				statement=connectionToDatabase.createStatement();
				statement.setQueryTimeout(5);
				sql="UPDATE "+table+" set ";
				for(String pair : updatedData){
					sql+=pair;
				}		
				sql+=" WHERE ";
				for(String pair : searchData){
					sql+=pair;
				}
				statement.executeUpdate(sql);
				connectionToDatabase.commit();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				disconnect();
			}
			
			return true;
		}else{
			return false;
		}
	}

	@Override
	public Boolean delete(String table, String[] data) {
		String sql="";
		connectionToDatabase=connect();
		if(connectionToDatabase!=null){
			try {
				statement=connectionToDatabase.createStatement();
				statement.setQueryTimeout(5);
				sql="DELETE from "+table+" WHERE ";
				for(String pair : data){
					sql+=pair;
				}
				statement.executeUpdate(sql);
				connectionToDatabase.commit();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				
				disconnect();
			}

			return null;
		}else{
			return false;
		}
	}

	
	private Connection connect() {
		int tries=0;
		Connection temp=null;
		if(connectionToDatabase!=null){
			disconnect();
		}
		while(temp==null && tries<SQLiteDatabase.MAXNUMBEROFTRIES){
			try {
				temp=DriverManager.getConnection("jdbc:sqlite:"+databaseLocation);
				temp.setAutoCommit(false);
			} catch (SQLException e) {
				temp=null;
				try {
					Thread.sleep( (long)(Math.random()*SQLiteDatabase.MAXWAIT) );
				} catch (InterruptedException interupt) {
					// TODO Auto-generated catch block
					interupt.printStackTrace();
				}
			}
			tries++;
		}
		if(tries>=SQLiteDatabase.MAXNUMBEROFTRIES){
			return null;
		}else{
			return temp;
		}
	}
	
	private void disconnect(){
		if(connectionToDatabase!=null){
			try {
				statement.close();
				connectionToDatabase.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			connectionToDatabase=null;
			statement=null;
		}
	}

}
