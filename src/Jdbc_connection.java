import java.sql.DriverManager;
import java.sql.ResultSet;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;


public class Jdbc_connection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con= null;
		String url="jdbc:mysql://localhost:3306/";
		String dbname= "test";
		String uname= "root";
		String pass= "root";
		String driver= "com.mysql.jdbc.Driver";
		
		try{
Class.forName(driver).newInstance();
con=  (Connection) DriverManager.getConnection(url+dbname, uname, pass);
Statement st=  (Statement) con.createStatement();

ResultSet rs= st.executeQuery("select * from babu");
//rs.next();
//System.out.println(rs.getString("name"));
while(rs.next()){
	System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
	
	PreparedStatement pst= (PreparedStatement) con.prepareStatement("select * from babu where name= ?");
	pst.setString(1, "sudeep");
	ResultSet rs1= pst.executeQuery();
	while(rs1.next()){
		System.out.println(rs1.getString(1)+" "+rs1.getString(2)+" "+rs1.getString(3));
		
}

}}catch(Exception e){
		}
	}
	
	
	

}
