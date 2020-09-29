package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class AddressSelectAllMain {

	public static void main(String[] args) throws Exception {
		/**************DB접속정보**************/
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javapython31";
		
		String password="javapython31";
		
		String selectSql="select no,id,name,phone,address from address";
		
		Class.forName(driverClass);
		Connection con=DriverManager.getConnection(url, user, password);
		Statement stmt=con.createStatement();
		/*
		 << Statement >>
		 public ResultSet executeQuery(String sql) throws SQLException;
			Executes the given SQL statement, 
			which returns a single ResultSet object.

		Parameters:
			sql - an SQL statement to be sent to the database, 
			typically a static SQL SELECT statement
		Returns:
			a ResultSet object that contains the data produced by the given query;
			never null
		 */
		
		
		ResultSet rs=stmt.executeQuery(selectSql);
		
		/*
		<< ResultSet >>
		boolean next() throws SQLException
		 - Moves the cursor forward one row from its current position.
		 - A ResultSet cursor is initially positioned before the first row; 
		 	 the first call to the method next makes the first row the current row;
		 	 the second call makes the second row the current row, and so on.
		 - When a call to the next method returns false, 
		     the cursor is positioned after the last row.
		 */
		
		//rs.getInt("no");
		while(rs.next()) {
			/*
			  DB NUMBER			--> java int,double
			  DB VARCHAR2,CHAR	--> String
			  DB DATE           --> Date  
			 XXX var = rs.getXXX(컬럼이름);
			 */
			int no = rs.getInt("no");
			String id=rs.getString("id");
			String name=rs.getString("name");
			String phone=rs.getString("phone");
			String address=rs.getString("address");
			System.out.println(no+"\t"+id+"\t"+name+"\t"+phone+"\t"+address);
		}
		//rs.getInt("no");
		rs.close();
		stmt.close();
		con.close();
		
	}

}









