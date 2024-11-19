package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UpdateProfileDAO {
	public int k=0;
	public int update(UserBean ub) {
		try {
			Connection con = DBConnection.getCon();
			PreparedStatement ps = con.prepareStatement
					("update USERREG set city=?, mid=?, pno=? where uname=? and pword=?");
			ps.setString(1,ub.getCity());
			ps.setString(2,ub.getmId());
		    ps.setLong(3,ub.getPhno());
	    	ps.setString(4,ub.getuName());
	 	    ps.setString(5,ub.getPword());
			k = ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return k;
	}
}
