package test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	public UserBean ub = null;
	public UserBean login(String uName, String pWord) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("select * from USERREG where uname=? and pword=?");
			ps.setString(1, uName);
			ps.setString(2, pWord);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				ub = new UserBean();
				ub.setuName(rs.getString(1));
				ub.setPword(rs.getString(2));
				ub.setfName(rs.getString(3));
				ub.setlName(rs.getString(4));
				ub.setCity(rs.getString(5));
				ub.setmId(rs.getString(6));
				ub.setPhno(rs.getLong(7));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return ub;
	}
}