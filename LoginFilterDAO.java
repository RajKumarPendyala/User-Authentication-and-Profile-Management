package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoginFilterDAO {
	public static ArrayList<String> getUnames(){
		ArrayList<String> al = new ArrayList<>();
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement("Select * from USERREG");
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				al.add(rs.getString(1));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return al;
	}
}
