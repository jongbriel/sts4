package basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class JDBCFlowMain {

	public static void main(String[] args) throws Exception{
		/*
		String driverClass="oracle.jdbc.OracleDriver";
		String url="jdbc:oracle:thin:@182.237.126.19:1521:XE";
		String user="javapython31";
		String password="javapython31";
		*/
		/**************설정파일로부터 DB접속정보얻기*************/
		Properties dbProperties=new Properties();
		dbProperties.load(
				JDBCFlowMain.class.getResourceAsStream("db.properties"));
		
		String driverClass=dbProperties.getProperty("driverClass");
		String url=dbProperties.getProperty("url");
		String user=dbProperties.getProperty("user");
		String password=dbProperties.getProperty("password");
		
		
		String selectSql="select * from emp";
		/*
		 1.Driver Class loading
		 */
		Class.forName(driverClass);
		System.out.println("1.driver class loading");
		/*
		 2. Connection생성(DB Server에연결)
		 */
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println("2.Connection생성:"+con);
		/*
		 3. Statement 객체생성(SQL전송객체)
		 */
		Statement stmt = con.createStatement();
		System.out.println("3.Statement객체생성:"+stmt);
		/*
		 4.SQL문전송
		 5.ResultSet(결과집합) 얻기
		 */
		ResultSet rs=stmt.executeQuery(selectSql);
		System.out.println("4.SQL문전송:"+selectSql);
		System.out.println("5.ResultSet(결과집합) 얻기:"+rs);
		
		while(rs.next()) {
			System.out.println(
					rs.getString("EMPNO")+"\t"+
					rs.getString("ENAME")+"\t"+
					rs.getString("JOB")+"\t"+
					rs.getDouble("SAL"));
		}
		/*
		 6. resource해지
		 */
		System.out.println("6.resource해지 close()");
		rs.close();
		stmt.close();
		con.close();
		
		
	}

}









